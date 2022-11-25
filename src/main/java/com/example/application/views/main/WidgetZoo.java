package com.example.application.views.main;



import java.util.ArrayList;

import java.util.List;



import com.vaadin.flow.component.Text;

import com.vaadin.flow.component.button.Button;

import com.vaadin.flow.component.checkbox.Checkbox;

import com.vaadin.flow.component.checkbox.CheckboxGroup;

import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;

import com.vaadin.flow.component.combobox.ComboBox;

import com.vaadin.flow.component.grid.ColumnTextAlign;

import com.vaadin.flow.component.grid.Grid;

import com.vaadin.flow.component.grid.GridVariant;

import com.vaadin.flow.component.html.Span;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import com.vaadin.flow.component.textfield.TextArea;

import com.vaadin.flow.component.textfield.TextField;

import com.vaadin.flow.data.binder.Binder;

import com.vaadin.flow.data.binder.ValidationException;

import com.vaadin.flow.data.value.ValueChangeMode;

import com.vaadin.flow.router.PageTitle;

import com.vaadin.flow.router.Route;



@PageTitle("WidgetZoo - a demonstration of various widgets in Vaadin")

@Route(value = "/widgets")

public class WidgetZoo extends VerticalLayout {


	int number = 1;



	private void updateValues() {

		number++;

	}



	public WidgetZoo() {

		//simple widgets to display text

		add(new Text("Hello World..."));

		Span span = new Span("Welcome to the widget Zoo ;-)");

		span.getElement().getStyle().set("font-size", "23px");

		span.getElement().getStyle().set("font-weight", "bold");

		add(span);

		//combine with Button for interactivity

		//int number = 1;

		Text numberText = new Text(String.valueOf(number));

		Button commandButton = new Button("count");

		commandButton.addClickListener(listener -> {

			number = number + 1;

			numberText.setText(String.valueOf(number));

		});

		add(numberText);

		add(commandButton);



		//binding = automatic mapping between UI-widgets and classes

		TextField nameField = new TextField();

		Text log = new Text("");

		Person person1 = new Person("jf", "hfh", "hfklj", "hfh");

		Binder<Person> binder = new Binder<>();

		binder.bind(nameField, Person::getLastName, Person::setLastName);



		Button saveButton = new Button("save", event -> {

			try {

				binder.writeBean(person1);

				log.setText(person1.toString());

			} catch(ValidationException e) {

				e.printStackTrace();

			}

		});



		add(nameField);

		add(log);

		add(saveButton);


		//TextArea a widget for longer texts

		TextArea longerText = new TextArea();

		longerText.setLabel("Message");

		longerText.setPlaceholder("Please type a message...");

		//can setMaxLength Height Width

		//or listen to changes

		longerText.setValueChangeMode(ValueChangeMode.EAGER);

		longerText.addValueChangeListener(event -> {



		});

		add(longerText);



		//checkBox

		Checkbox yesNoCheck = new Checkbox();

		yesNoCheck.setLabel("Yes");

		add(yesNoCheck);



		yesNoCheck.setLabel("Yes");

		yesNoCheck.addValueChangeListener(event -> {

			log.setText(Boolean.toString(yesNoCheck.getValue()));

		});

		add(yesNoCheck);



		//group of checkBoxes

		CheckboxGroup<String> group = new CheckboxGroup<>();

		group.setLabel("Months");

		group.setItems("January","February","March");

		group.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);



		group.addValueChangeListener(event -> {

			log.setText(""+group.getValue());

		});



		add(group);



		//Combobox

		ComboBox<String> box = new ComboBox<>("Cars");

		box.setPlaceholder("Please select a value");

		box.setItems("Blue","Red","Green");



		box.addValueChangeListener(event -> {

			log.setText(box.getValue());

		});



		add(box);




/*
		List<Person> list = new ArrayList<>();

		list.add(new Person("Peter", "JLKFJl", "hhjf", "hdjhf"));

		box.setItemLabelGenerator(person -> person.  + person.getAge());

*/



		//a table with data

		List<Person> list = new ArrayList<>();

		list.add(new Person("Anna","hfjf" , "anna@abc.com", "hfh"));

		/*list.add(new Person("Peter", "Peter@abc.com", 45));

		list.add(new Person("Marc", "marc@abc.com", 33));

		list.add(new Person("Susy", "susy@abc.com", 49));

		list.add(new Person("Anna", "anna@abc.com", 35));

		list.add(new Person("Peter", "Peter@abc.com", 45));

		list.add(new Person("Marc", "marc@abc.com", 33));

		list.add(new Person("Susy", "susy@abc.com", 49));

		list.add(new Person("Anna", "anna@abc.com", 35));

		list.add(new Person("Peter", "Peter@abc.com", 45));

		list.add(new Person("Marc", "marc@abc.com", 33));

		list.add(new Person("Susy", "susy@abc.com", 49));

		list.add(new Person("Anna", "anna@abc.com", 35));

		list.add(new Person("Peter", "Peter@abc.com", 45));

		list.add(new Person("Marc", "marc@abc.com", 33));

		list.add(new Person("Susy", "susy@abc.com", 49));
*/


		Grid<Person> personGrid = new Grid<>(Person.class, false);

		personGrid.addColumn(Person::getFirstName).setHeader("Firstname").setSortable(true).setTextAlign(ColumnTextAlign.CENTER);

		personGrid.addColumn(Person::getEmail).setHeader("Emails").setSortable(true);

		personGrid.addColumn(Person::getLastName).setHeader("Lastname").setSortable(true);

		personGrid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);

		personGrid.setSelectionMode(Grid.SelectionMode.MULTI);

		personGrid.setItems(list);



		Button button = new Button("Remove");

		button.addClickListener(event -> {

			list.removeAll(personGrid.getSelectedItems());

			personGrid.getDataProvider().refreshAll();

		});



		add(personGrid);

		add(button);







	}

	}

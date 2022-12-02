package com.example.application.views.main;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.ColumnTextAlign;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.ListView;
import java.util.ArrayList;
import java.util.List;

@PageTitle("CustomerList")
@Route(value = "/CustomerList")

public class CustomersList extends VerticalLayout {
	private final PersonService personService;
	Grid<Person> grid = new  Grid<>(Person.class, false);
	Button add = new Button("Add");
	Button delete = new Button("Delete");

	private Person person;



@Autowired
	public CustomersList(PersonService personService){
	this.personService = personService;
	setSizeFull();

		configureGrid();

		add(grid, Buttons());
	}

	private Component Buttons() {
		add.addClickListener(e-> UI.getCurrent().navigate(AddCustomer.class));
		add.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		delete.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);
		HorizontalLayout horizontalLayout = new HorizontalLayout(add, delete);
	return horizontalLayout;
	}




	private void configureGrid(){
		grid.addClassName("ContactList");
		setSizeFull();
		grid.addColumn(Person::getFirstName).setHeader("Firstname").setSortable(true).setTextAlign(ColumnTextAlign.CENTER);
		grid.addColumn(Person::getLastName).setHeader("Lastname").setSortable(true);
		grid.addColumn(Person::getEmail).setHeader("Emails").setSortable(true);
		grid.addColumn(Person::getWohnort).setHeader("Wohnort").setSortable(true);
		grid.getColumns().forEach(col -> col.setAutoWidth(true));
		grid.setItems(personService.getPerson());
		grid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);
		grid.setSelectionMode(Grid.SelectionMode.MULTI);
	}

}

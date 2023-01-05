package com.example.application.views.main;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.ColumnTextAlign;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;

@PageTitle("DeleteCustomer")
@Route(value = "/DeleteCustomer")


public class DeleteView  extends VerticalLayout {

	private final PersonService personService;
	Binder<Person> binder = new BeanValidationBinder<>(Person.class);
	Grid<Person> grid = new  Grid<>(Person.class, false);
	H1 title = new H1("Do you really want to delete the selected objects?");
	Button delete = new Button("Delete");
	Button cancel = new Button("Cancel");
	HorizontalLayout horizontalLayout;



	@Autowired
	public DeleteView(PersonService personService){
		this.personService = personService;
		setSizeFull();
		horizontalLayout = new HorizontalLayout(cancel, delete);
		setSizeFull();
		cancel.addClickListener(e -> UI.getCurrent().navigate(CustomersList.class));
		cancel.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		delete.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);
		delete.addClickListener(e -> {
			personService.deleteCustomer();
			Notification.show("Selected objects got deleted!");
			UI.getCurrent().navigate(CustomersList.class);
		});
		delete.addClickShortcut(Key.ENTER);

		setHorizontalComponentAlignment(Alignment.CENTER,title);
		setHorizontalComponentAlignment(Alignment.END, horizontalLayout);




		configureGrid();
		add( title, grid, horizontalLayout);
	}


	private void configureGrid(){
		grid.addClassName("ContactList");
		setSizeFull();
		grid.addColumn(Person::getFirstName).setHeader("Firstname").setSortable(true).setTextAlign(ColumnTextAlign.CENTER);
		grid.addColumn(Person::getLastName).setHeader("Lastname").setSortable(true);
		grid.addColumn(Person::getEmail).setHeader("Emails").setSortable(true);
		grid.addColumn(Person::getWohnort).setHeader("Wohnort").setSortable(true);
		grid.getColumns().forEach(col -> col.setAutoWidth(true));
		grid.setItems(personService.getToBeDeleted());
		grid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);
	}





}

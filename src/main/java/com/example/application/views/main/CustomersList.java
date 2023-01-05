package com.example.application.views.main;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.ColumnTextAlign;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.ListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@PageTitle("CustomerList")
@Route(value = "/CustomerList")

public class CustomersList extends VerticalLayout {
	private final PersonService personService;
	Grid<Person> grid = new  Grid<>(Person.class, false);
	Button add = new Button("Add");
	Button delete = new Button("Delete");



@Autowired
	public CustomersList(PersonService personService){
	this.personService = personService;
	setSizeFull();

	add.addClickListener(e-> UI.getCurrent().navigate(AddCustomer.class));
	add.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
	delete.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);
	delete.addClickListener(e-> UI.getCurrent().navigate(DeleteView.class));
	HorizontalLayout horizontalLayout = new HorizontalLayout(add, delete);

	setHorizontalComponentAlignment(Alignment.END, horizontalLayout);

		configureGrid();

		add(grid, horizontalLayout);
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
		grid.addSelectionListener(event -> {
			Set<Person> selected = event.getAllSelectedItems();
			personService.setToBeDeleted(selected);
			Notification.show(selected.size() + " items selected");
		});
	}




}

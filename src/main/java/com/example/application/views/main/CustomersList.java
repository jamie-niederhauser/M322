package com.example.application.views.main;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.swing.text.html.ListView;

@PageTitle("CustomerList")
@Route(value = "/CustomerList")

public class CustomersList extends VerticalLayout {
	Grid<Person> grid = new  Grid<>(Person.class);
	Button add = new Button("Add");
	Button delete = new Button("Delete");


	public CustomersList(){
		setSizeFull();

		configureGrid();

		add(grid, Buttons());
	}

	private Component Buttons() {
		HorizontalLayout horizontalLayout = new HorizontalLayout(add, delete);
	return horizontalLayout;
	}


	private void configureGrid(){
		grid.addClassName("ContactList");
		setSizeFull();
		grid.setColumns("firstName", "lastName", "email");
		grid.getColumns().forEach(col -> col.setAutoWidth(true));
	}
}

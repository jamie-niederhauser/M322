package com.example.application.views.main;



import com.vaadin.flow.component.Text;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import com.vaadin.flow.router.PageTitle;

import com.vaadin.flow.router.Route;



@PageTitle("AnotherView")

@Route(value = "/AnotherView")

public class AnotherView extends VerticalLayout {



	private Text info = new Text("anotherView...");



	public AnotherView () {

		add(info);

	}

}
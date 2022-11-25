package com.example.application.views.main;



import com.vaadin.flow.component.Text;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import com.vaadin.flow.router.PageTitle;

import com.vaadin.flow.router.Route;



@Route(value="/applayoutf", layout = AppDemoZoo.class)

@PageTitle("First | Demo")

public class AppDemoFirst extends VerticalLayout {



	public AppDemoFirst () {

		Text text = new Text("First content");

		add(text);

	}

}
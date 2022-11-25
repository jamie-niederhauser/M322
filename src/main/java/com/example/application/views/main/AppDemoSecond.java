package com.example.application.views.main;



import com.vaadin.flow.component.Text;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import com.vaadin.flow.router.PageTitle;

import com.vaadin.flow.router.Route;



@Route(value="/applayouts", layout = AppDemoZoo.class)

@PageTitle("Second | Demo")

public class AppDemoSecond extends VerticalLayout {



	public AppDemoSecond () {

		Text text = new Text("Second content");

		add(text);

	}

}
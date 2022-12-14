package com.example.application.views.main;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;




public class MainView extends HorizontalLayout {

    private TextField name;

    private Button sayHello;



    private RouterLink link;



    public MainView() {

        name = new TextField("Your name");

        sayHello = new Button("Say hello");

        sayHello.addClickListener(e -> {

            Notification.show("Hello " + name.getValue());

        });

        sayHello.addClickShortcut(Key.ENTER);



        link = new RouterLink("Show other view", AppDemoZoo.class);

        setMargin(true);

        setVerticalComponentAlignment(Alignment.END, name, sayHello);



        add(name, sayHello, link);

    }



}
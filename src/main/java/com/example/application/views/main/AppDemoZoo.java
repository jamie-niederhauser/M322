package com.example.application.views.main;



import com.vaadin.flow.component.applayout.AppLayout;

import com.vaadin.flow.component.applayout.DrawerToggle;

import com.vaadin.flow.component.html.H1;

import com.vaadin.flow.component.html.Span;

import com.vaadin.flow.component.icon.Icon;

import com.vaadin.flow.component.icon.VaadinIcon;

import com.vaadin.flow.component.tabs.Tab;

import com.vaadin.flow.component.tabs.Tabs;

import com.vaadin.flow.router.PageTitle;

import com.vaadin.flow.router.Route;

import com.vaadin.flow.router.RouterLink;

import com.vaadin.flow.theme.Theme;



@PageTitle("AppLayoutZoo - a demonstration of various AppLayout in Vaadin")

@Route(value = "/applayout")

public class AppDemoZoo extends AppLayout {



	public AppDemoZoo() {

		DrawerToggle toggle = new DrawerToggle();



		H1 title = new H1("MyApp");

		title.getStyle().set("font-size", "var(--lumo-font-size-l)")

				.set("margin", "0");



		Tabs tabs = getTabs();



		addToDrawer(tabs);

		addToNavbar(toggle, title);

	}



	private Tabs getTabs() {

		Tabs tabs = new Tabs();

		tabs.add(createTab(VaadinIcon.DASHBOARD, "Dashboard",AppDemoFirst.class),

				createTab(VaadinIcon.CART, "Orders",AddCustomer.class),

				createTab(VaadinIcon.USER_HEART, "Customers",WidgetZoo.class),

				createTab(VaadinIcon.PACKAGE, "Products",AppDemoSecond.class),

				createTab(VaadinIcon.RECORDS, "Documents",AppDemoSecond.class),

				createTab(VaadinIcon.LIST, "Tasks",AppDemoSecond.class),

				createTab(VaadinIcon.CHART, "Analytics",AppDemoSecond.class),

				createTab(VaadinIcon.HOME, "Home", MainView.class));

		tabs.setOrientation(Tabs.Orientation.VERTICAL);

		return tabs;

	}



	private Tab createTab(VaadinIcon viewIcon, String viewName, Class name) {

		Icon icon = viewIcon.create();

		icon.getStyle().set("box-sizing", "border-box")

				.set("margin-inline-end", "var(--lumo-space-m)")

				.set("margin-inline-start", "var(--lumo-space-xs)")

				.set("padding", "var(--lumo-space-xs)");



		RouterLink link = new RouterLink();

		link.add(icon, new Span(viewName));

		link.setRoute(name);



		// Demo has no routes

		// link.setRoute(viewClass.java);

		link.setTabIndex(-1);



		return new Tab(link);

	}



}
package com.example.application.views.main;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.TextFieldVariant;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("AddCustomer")
@Route(value = "/AddCustomer")
public class AddCustomer extends VerticalLayout {

		public AddCustomer() {
			H1 title  = new H1("Add a Customer");
			TextField vorname = new TextField("Vorname");
			TextField nachname = new TextField("Nachname");
			EmailField email = new EmailField("E-Mail");
			TextField wohnort = new TextField("Wohnort");
			Button cancel = new Button("Cancel");
			Button create = new Button("Create");

			FormLayout formLayout = new FormLayout(vorname,nachname,email,wohnort,cancel, create);
			create.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
			create.addClickShortcut(Key.ENTER);
			create.addClickListener(e-> UI.getCurrent().navigate(CustomersList.class));
			cancel.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);
			cancel.addClickListener(event -> vorname.clear());
			cancel.addClickListener(event -> nachname.clear());
			cancel.addClickListener(event -> email.clear());
			cancel.addClickListener(event -> wohnort.clear());
			formLayout.setResponsiveSteps(new FormLayout.ResponsiveStep("0", 2));
			formLayout.setColspan(vorname, 2);
			formLayout.setColspan(nachname, 2);
			formLayout.setColspan(email, 2);
			formLayout.setColspan(wohnort, 2);
			formLayout.setWidth("300px");
			formLayout.setHeight("200px");
			setHorizontalComponentAlignment(Alignment.CENTER,title,formLayout);

			add(title , formLayout );
		}


}

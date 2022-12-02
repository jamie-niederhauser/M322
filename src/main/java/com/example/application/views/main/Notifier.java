package com.example.application.views.main;


import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.IronIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;

import java.util.ArrayList;
import java.util.List;

public class Notifier {

	private static final String STYLE_ATTR_NAME = "style";

	private Notifier() {
	}

	public static void showNotification(String message, boolean isPersistent) {
		if (isPersistent) {
			showPersistentNotification(message);
		} else {
			showNotification(message);
		}
	}

	public static void showNotification(String message) {
		showNotification(new Configuration(), message);
	}

	public static void showNotification(Configuration configuration, String... messages) {
		List<Component> components = new ArrayList<>();
		for (String message : messages) {
			Component payloadComponent;

			if (configuration.isHtml()) {
				payloadComponent = new Html("<div>" + message + "</div>");
			} else {
				payloadComponent = new Text(message);
			}

			Div container = new Div();

			if (configuration.isError()) {
				IronIcon warnIcon = new IronIcon("vaadin", "warning");
				warnIcon.getElement().setAttribute(STYLE_ATTR_NAME,
						"width: var(--lumo-icon-size-s); height: var(--lumo-icon-size-s); "
								+ "margin-right: var(--lumo-space-s); margin-bottom: var(--lumo-space-xs); ");

				container.add(warnIcon);
				container.getElement().setAttribute(STYLE_ATTR_NAME, "color: var(--lumo-error-contrast-color)");
			}

			container.add(payloadComponent);

			components.add(container);
		}

		Notification notification = new Notification(components.toArray(new Component[0]));
		notification.setPosition(Notification.Position.BOTTOM_START);
		notification.setDuration(getDuration(configuration));
		if (configuration.isError) {
			notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
		}

		if (configuration.isPersistent()) {
			Button close = new Button(new IronIcon("vaadin", "close"));
			close.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE, ButtonVariant.LUMO_SMALL);
			close.getElement().setProperty(STYLE_ATTR_NAME, "float: right;");
			close.addClickListener(event -> notification.close());
			notification.add(close);
		}

		notification.open();
	}

	public static void showPersistentNotification(String message) {
		showNotification(new Configuration().setPersistent(true), message);
	}

	public static void showErrorNotification(String message) {
		showNotification(new Configuration().setError(true).setPersistent(true), message);
	}

	private static int getDuration(Configuration configuration) {
		int durationFromConfiguration = (configuration.isError) ? (AppConst.notifier * 2) : (AppConst.notifier);
		return configuration.isPersistent() ? 0 : durationFromConfiguration;
	}

	public static class Configuration {
		private boolean isPersistent = false;
		private boolean isError = false;
		private boolean isHtml = false;

		public boolean isPersistent() {
			return isPersistent;
		}

		public Configuration setPersistent(boolean persistent) {
			isPersistent = persistent;
			return this;
		}

		public boolean isError() {
			return isError;
		}

		public Configuration setError(boolean error) {
			isError = error;
			return this;
		}

		public boolean isHtml() {
			return isHtml;
		}

		public Configuration setHtml(boolean html) {
			isHtml = html;
			return this;
		}
	}
}

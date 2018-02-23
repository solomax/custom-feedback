package org.apache.solomax;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.Component;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.markup.html.WebPage;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);

		add(new Label("version", getApplication().getFrameworkSettings().getVersion()));

		add(new FeedbackPanel("feedback") {
			private static final long serialVersionUID = 1L;

			@Override
			protected Component newMessageDisplayComponent(String id, FeedbackMessage message) {
				Component lbl = super.newMessageDisplayComponent("message", message);
				return new FeedbackMessagePanel(id).add(lbl);
			}
		});
		info("Info: This is the message.");
	}
}

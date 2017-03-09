package myResources;

import java.net.URL;

import constants.Constants;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class CommandDisplayer extends Stage{
	public CommandDisplayer(){
		URL urlHello = getClass().getResource(Constants.DEFAULT_RESOURCE_BUNDLE.getString("commandList"));
			// Create a WebView
			WebView browser = new WebView();
			// Get WebEngine via WebView
			WebEngine webEngine = browser.getEngine();
			// Load page
	        webEngine.load(urlHello.toExternalForm());
	        Scene s = new Scene(browser);
	        this.setScene(s);
	}
}

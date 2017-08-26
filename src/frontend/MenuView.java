
package frontend;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import languages.Language;
import constants.Constants;

/**
 * @author Daniel
 * @author Belal
 * 
 * This class sets up the elements of the menu and puts them into the menubar.
 */

public class MenuView {
	private MenuBar myMenuBar;
	private Menu myHelpMenu;
	private Menu myLanguagesMenu;
	private ChoiceBox<String> myLanguageChoiceBox;
	
	protected MenuView() {
		/** constructor that creates the menu bar and adds menu items to the menu bar */
		myMenuBar = new MenuBar();
		setUpMenuBarItems();
		myMenuBar.getMenus().addAll(myHelpMenu, myLanguagesMenu);
	}


	@SuppressWarnings("serial")
	private void setUpMenuBarItems() {
		/** set up the items in the menu bar */
		myHelpMenu = new Menu(Constants.DEFAULT_RESOURCE_BUNDLE.getString("helpPrompt"));
		MenuItem help = new MenuItem(Constants.DEFAULT_RESOURCE_BUNDLE.getString("listPrompt"));
	    myHelpMenu.getItems().add(help);
	    myHelpMenu.setOnAction(event -> {
			CommandDisplayer myCommandDisplay = new CommandDisplayer();
			myCommandDisplay.show();
		});
	    
	    
	    myLanguagesMenu = new Menu(Constants.DEFAULT_RESOURCE_BUNDLE.getString("languagePrompt"));
	    MenuItem languages = new MenuItem();
	    myLanguageChoiceBox = new ChoiceBox<String>(FXCollections.observableArrayList(
	    	new ArrayList<String>() {{
	    		for (Language lang : Language.values()) if (!lang.equals(Language.SYNTAX)) add(lang.getLang());
	    }}));
	    myLanguageChoiceBox.getSelectionModel().select(Constants.DEFAULT_LANGUAGE);
	    languages.setGraphic(myLanguageChoiceBox);
	    myLanguagesMenu.getItems().add(languages);
		
	}

	protected MenuBar getNode() {
		/** get the menu bar that has been set up*/
		return myMenuBar;
	}

	protected ChoiceBox<String> getLanguageChoiceBox() {
		/** get the 'select language' choice box */
		return myLanguageChoiceBox;
	}
}


package frontend;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import constants.Constants;

public class CommandPromptView {
	/**
	 * We use this class to store everything relating to what is happening in
	 * the command prompt. 
	 * We can type in commands or select a command from the history of commands.
	 * Using this class allows us to separate what is happening in the command prompt
	 * from everything else in the screen.
	 * This class also contains any buttons that allow the user to graphically
	 * perform a command on the turtle (move, rotate, change its appearance..).
	 * 
	 * @author Daniel
	 * @author Belal
	 * 
	 */
	
	private Button myExecuteButton;
	private ComboBox<String> myCommandHistory;
	private BorderPane myBorderPane;
	private VBox myVBox;
	private TextArea myCommandEntry;
	
	private HBox turtleMovers;
	private Button forwardButton;
	private Button rightButton;
	private Button leftButton;
	private Button backButton;
	private Button myTurtleImageSelectionButton;
	private CheckBox showSelectedTurtlesButton;
	
	ObservableList<String> listOfCommands;
	

	protected CommandPromptView() {
		myBorderPane = new BorderPane();
		setUpCommandEntry();
		setUpButtons();
		myBorderPane.setLeft(myCommandEntry);
		myBorderPane.setRight(myVBox);
	}
	
	private void setUpCommandEntry() {
		myCommandEntry = new TextArea();
		myCommandEntry.setMinWidth(Constants.COMMAND_WINDOW_WIDTH);
		myCommandEntry.setMinHeight(Constants.COMMAND_WINDOW_HEIGHT);
	}
	
	private void setUpButtons() {
		myVBox = new VBox();
		myVBox.setPrefWidth(Constants.BIG_BUTTON_WIDTH);
		myExecuteButton = new Button(Constants.DEFAULT_RESOURCE_BUNDLE.getString("executeCommandLabel"));
		setUpCommandHistory();
		myExecuteButton.setMinWidth(myVBox.getPrefWidth());
		myCommandHistory.setMinWidth(myVBox.getPrefWidth());
		createMovingButtons();
		myTurtleImageSelectionButton = new Button(Constants.DEFAULT_RESOURCE_BUNDLE.getString("fileLoaderLabel"));
		myTurtleImageSelectionButton.setPrefWidth(Constants.BIG_BUTTON_WIDTH);
		showSelectedTurtlesButton = new CheckBox(Constants.DEFAULT_RESOURCE_BUNDLE.getString("selectedTurtlesButton"));
		myVBox.getChildren().addAll(myExecuteButton, myCommandHistory, turtleMovers, myTurtleImageSelectionButton, showSelectedTurtlesButton);
	}
	
	private void createMovingButtons(){
		turtleMovers = new HBox();
		backButton = createButtonWithImage(Constants.BACK_IMAGE);
		forwardButton = createButtonWithImage(Constants.FORWARD_IMAGE);
		leftButton = createButtonWithImage(Constants.LEFT_ROTATE_IMAGE);
		rightButton = createButtonWithImage(Constants.RIGHT_ROTATE_IMAGE);
		turtleMovers.getChildren().addAll(backButton, forwardButton, leftButton, rightButton);
	}
	
	private Button createButtonWithImage(String source) {
		Button button = new Button();
		ImageView buttonImage = new ImageView(new Image(source));
		buttonImage.setFitHeight(Constants.SMALL_BUTTON_SIZE);
		buttonImage.setFitWidth(Constants.SMALL_BUTTON_SIZE);
		button.setGraphic(buttonImage);
		return button;
	}
	
	private void setUpCommandHistory() {
		listOfCommands = FXCollections.observableArrayList();
		myCommandHistory = new ComboBox<String>(listOfCommands);
		myCommandHistory.setPromptText(Constants.PREVIOUS_COMMAND_PROMPT);
		myCommandHistory.setOnAction((event) -> {
			myCommandEntry.setText(myCommandHistory.getSelectionModel().getSelectedItem());
		});
	}
	
	public void setForwards(EventHandler<ActionEvent> handler) {
		/** set action to be performed if forward button is clicked */
		forwardButton.setOnAction(handler);
	}
	public void setBackwards(EventHandler<ActionEvent> handler) {
		/** set action to be performed if backwards button is clicked */
		backButton.setOnAction(handler);
	}
	public void setRotateLeft(EventHandler<ActionEvent> handler) {
		/** set action to be performed if rotate left button is clicked */
		leftButton.setOnAction(handler);
	}
	public void setRotateRight(EventHandler<ActionEvent> handler) {
		/** set action to be performed if rotate right button is clicked */
		rightButton.setOnAction(handler);
	}
	
	public void addCommandToHistory(String cmd) {
		/** add a command to the history of commands */
		listOfCommands.add(cmd);
	}

	public String getUserInput() {
		/** get the text that the user inputed in the command line */
		return myCommandEntry.getText();
	}
	
	public Button getExecuteButton() {
		/** get the execute button */
		return myExecuteButton;
	}
	
	public BorderPane getNode() {
		/** get the entire border pane */
		return myBorderPane;
	}
	
	public Button getForwardButton(){
		/** get the forward button */
		return forwardButton;
	}
	
	public Button getBackwardsButton(){
		/** get the backwards button */
		return backButton;
	}
	
	
	public Button getRightRotate(){
		/** get the rotate right button */
		return rightButton;
	}
	
	public Button getLeftRotate(){
		/** get the rotate left button */
		return leftButton;
	}
	
	
	public CheckBox getGraphicalDisplayButton(){
		/** get the button that allows us to toggle whether to display active turtles differently
		 * from non-active ones*/
		return showSelectedTurtlesButton;
	}
	
	public void setCommandPromptText(String text) {
		/** set a different piece of text inside the command prompt view */
		myCommandEntry.setText(text);
	}
	
	protected Button getTurtleImageSelectionButton() {
		/** get the 'load new image file' button */
		return myTurtleImageSelectionButton;
	}
	
}
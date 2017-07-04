package application.views;

import application.resources.Constants;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class AddPatientView extends AbstractView {
	private Label fullNameLabel;
	private TextField fullNameField;
	private Label addressLabel;
	private TextField addressField;
	private Label phoneLabel;
	private TextField phoneField;
	private Text statusText;
    protected Button addButton;
    
    public AddPatientView(String title) {
    	init(title);
    }
    
	protected void createObjects() {
		super.createObjects();
		statusText = new Text();
		fullNameLabel = createLabel("Full name:");
		fullNameField = createTextField();
		addressLabel = createLabel("Address:");
		addressField = createTextField();
		phoneLabel = createLabel("Phone:");
		phoneField = createTextField();
        addButton = createButton("Add patient");
	}
	
	protected void addObjects() {
		super.addObjects();
		vBox.getChildren().add(fullNameLabel);
		vBox.getChildren().add(fullNameField);
		vBox.getChildren().add(addressLabel);
		vBox.getChildren().add(addressField);
		vBox.getChildren().add(phoneLabel);
		vBox.getChildren().add(phoneField);
		vBox.getChildren().add(statusText);
		vBox.getChildren().add(addButton);
	}
	
	protected void alignObjects() {
		super.alignObjects();
		vBox.setAlignment(Pos.CENTER);
        BorderPane.setMargin(vBox, new Insets(15, 15, 15, 15));			
	}
	
	public void setStatusText(String text) {
		statusText.setText(text);
	}
	
	protected void setPositionsForObjects() {
		super.setPositionsForObjects();
		borderPane.setCenter(vBox);
	}
	
	public String getFullName() {
		return fullNameField.getText();
	}
	
	public String getAddress() {
		return addressField.getText();
	}
	
	public String getPhone() {
		return phoneField.getText();
	}
	
	protected Scene createScene() {										
		return new Scene(borderPane, Constants.ADD_WINDOW_WIDTH, 
									 Constants.ADD_WINDOW_HEIGHT);
	}
	
	public void setButtonAction(EventHandler<ActionEvent> actionEvent) {
		addButton.setOnAction(actionEvent);
	}
}

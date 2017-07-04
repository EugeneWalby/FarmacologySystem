package application.views;

import application.resources.Constants;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class MainView extends AbstractView {
	private Button addPatientButton;
	private Button addHistoryButton;
	private Button showHistoriesButton;
	private Button deleteHistoryButton;
	private Button treatmentPlanButton;
	
    public MainView(String title) {
    	init(title);
    }
    
	protected void createObjects() {
		super.createObjects();
		addPatientButton = createButton("New patient");
		addHistoryButton = createButton("New disease history");
		showHistoriesButton = createButton("Show histories");
		deleteHistoryButton = createButton("Delete history");
		treatmentPlanButton = createButton("Treatment plan");
		createFonts();
	}
	
	protected void addObjects() {
		super.addObjects();
		vBox.getChildren().add(addPatientButton);
		vBox.getChildren().add(addHistoryButton);
		vBox.getChildren().add(showHistoriesButton);
		vBox.getChildren().add(deleteHistoryButton);
		vBox.getChildren().add(treatmentPlanButton);
	}
	
	protected void alignObjects() {
		super.alignObjects();
        VBox.setMargin(addPatientButton, new Insets(0, 0, 10, 0));
        VBox.setMargin(treatmentPlanButton, new Insets(0, 0, 10, 0));
        VBox.setMargin(addHistoryButton, new Insets(0, 0, 10, 0));
        VBox.setMargin(showHistoriesButton, new Insets(0, 0, 10, 0));
        VBox.setMargin(deleteHistoryButton, new Insets(0, 0, 10, 0));
	}
	
	protected void setPositionsForObjects() {
		super.setPositionsForObjects();
		borderPane.setCenter(vBox);
	}
	
	protected void createFonts() {
		addPatientButton.setFont(new Font("Verdana", 16));
		addHistoryButton.setFont(new Font("Verdana", 16));
		showHistoriesButton.setFont(new Font("Verdana", 16));
		deleteHistoryButton.setFont(new Font("Verdana", 16));
		treatmentPlanButton.setFont(new Font("Verdana", 16));
	}
	
	protected Scene createScene() {
		return new Scene(borderPane, Constants.MAIN_WINDOW_WIDTH, 
									Constants.MAIN_WINDOW_HEIGHT);
	}
	
	public void setAddPatientButtonAction(EventHandler<ActionEvent> eventHandler) {			
		addPatientButton.setOnAction(eventHandler);
	}
	
	public void setAddHistoryButtonAction(EventHandler<ActionEvent> eventHandler) {			
		addHistoryButton.setOnAction(eventHandler);
	}
	
	public void setShowHistoriesButtonAction(EventHandler<ActionEvent> eventHandler) {			
		showHistoriesButton.setOnAction(eventHandler);
	}
	
	public void setDeleteHistoryButtonAction(EventHandler<ActionEvent> eventHandler) {			
		deleteHistoryButton.setOnAction(eventHandler);
	}

	public void setTreatmentPlanButtonAction(EventHandler<ActionEvent> eventHandler) {			
		treatmentPlanButton.setOnAction(eventHandler);
	}
}

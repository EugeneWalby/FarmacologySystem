package application.views;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public abstract class AbstractView {
	protected VBox vBox;
	protected BorderPane borderPane;								
    protected Scene scene;
    protected Stage stage;
    
	protected void init(String title) {
		createWindow();
	    createStage(title);
	    setFont();
	}
	
	protected void createWindow() {
		createObjects();
	    addObjects();
        locateObjects();
	}
	
	protected void createStage(String title) {
		stage = new Stage();
		stage.setTitle(title);
		stage.setScene(scene);
	}
	
	protected void createObjects() {
		borderPane = createBorderPane();
	    scene = createScene();
		vBox = createVBox();
	}
	
	protected void addObjects() {

	}
	
	protected void locateObjects() {
		alignObjects();
		setPositionsForObjects();
	}
	
	protected void alignObjects() {
		vBox.setAlignment(Pos.CENTER);
	}

	protected void setPositionsForObjects() {

	}
	
	protected void setFont() {
		
	}
	
	public void showStage() {
		stage.show();
	}
	
	protected Button createButton() {
		return new Button();
	}
	
	protected Button createButton(String textOnButton) {
		return new Button(textOnButton);
	}
	
	protected VBox createVBox() {
		return new VBox();
	}
	
	protected HBox createHBox() {
		return new HBox();
	}
	
	protected Label createLabel(String textOnLabel) {
		return new Label(textOnLabel);
	}
	
	protected TextField createTextField() {
		return new TextField();
	}
	
	protected BorderPane createBorderPane() {
		return new BorderPane();
	}
	
	protected Scene createScene() {
		return null;
	}
	
	protected void setScene(Scene scene) {
		this.scene = scene;
	}
}

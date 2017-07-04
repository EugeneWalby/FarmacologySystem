package application.views;

import application.resources.Constants;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class AddHistoryView extends AbstractView {
	private Label patientLabel;
	@SuppressWarnings("rawtypes")
	private TableView tablePatients;
    private Label diseaseLabel;
    @SuppressWarnings("rawtypes")
	private TableView tableDiseases;
    @SuppressWarnings("rawtypes")
	protected TableColumn tableColumn;
    private Text statusText;
    protected Button addButton;
    private int patientID;
	private int diseaseID;
	
    public AddHistoryView(String title) {
    	init(title);
    }
    
	@SuppressWarnings("rawtypes")
	protected void createObjects() {
		super.createObjects();
		statusText = new Text();
		patientLabel = createLabel("Patients");
		tablePatients = new TableView();
        diseaseLabel = createLabel("Diseases");
        tableDiseases = new TableView();
        addButton = createButton("Add disease history");
	}
	
	protected void addObjects() {
		super.addObjects();
		vBox.getChildren().add(patientLabel);
		vBox.getChildren().add(getTablePatients());
		vBox.getChildren().add(diseaseLabel);
		vBox.getChildren().add(getTableDiseases());
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
	
	public int getPatient() {
		patientID = getTablePatients().getSelectionModel().getSelectedIndex() + 1;
		return patientID;
	}
	
	public int getDisease() {
		diseaseID = getTableDiseases().getSelectionModel().getSelectedIndex() + 1;
		return diseaseID;
	}
	
	protected Scene createScene() {										
		return new Scene(borderPane, Constants.ADD_WINDOW_WIDTH2, 
									 Constants.ADD_WINDOW_HEIGHT2);
	}
	
	public void setButtonAction(EventHandler<ActionEvent> actionEvent) {
		addButton.setOnAction(actionEvent);
	}
	
	@SuppressWarnings("rawtypes")
	public void createColumn(String columnName) {
		this.tableColumn = new TableColumn(columnName);
	}
	
	@SuppressWarnings("unchecked")
	public void addPatientsColumn() {
		getTablePatients().getColumns().addAll(tableColumn);
	}
	
	@SuppressWarnings("unchecked")
	public void addDiseasesColumn() {
		getTableDiseases().getColumns().addAll(tableColumn);
	}
	
	@SuppressWarnings("rawtypes")
	public TableColumn getColumn() {
		return tableColumn;
	}

	@SuppressWarnings("rawtypes")
	public TableView getTablePatients() {
		return tablePatients;
	}

	@SuppressWarnings("rawtypes")
	public TableView getTableDiseases() {
		return tableDiseases;
	}
}

package application.views;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class DeleteHistoryView extends ShowHistoriesView {
	private String selectedID;
	private Text statusText;
	protected Button deleteButton;
	
	public DeleteHistoryView(String title) {
		super(title);
	}
	
	protected void createObjects() {
		super.createObjects();
		statusText = createText();
		deleteButton = createButton("Delete history");
		createFonts();
	}	
	
	protected void addObjects() {
		super.addObjects();
		vBox.getChildren().add(statusText);
		vBox.getChildren().add(deleteButton);
	}
	
	protected void alignObjects() {
		super.alignObjects();
        VBox.setMargin(deleteButton, new Insets(10, 0, 0, 0));
        VBox.setMargin(statusText, new Insets(5, 0, 0, 0));
	}
	
	protected void createFonts() {
		deleteButton.setFont(new Font("Verdana", 14));
		statusText.setFont(new Font("Verdana", 14));
	}
	
	public void setButtonAction(EventHandler<ActionEvent> actionEvent) {
		deleteButton.setOnAction(actionEvent);
	}
	
	private Text createText() {
		return new Text();
	}
	
	public void setStatusText(String text) {
		statusText.setText(text);
	}
	
	public boolean deleteFromTable() {
		int selectedIndex = getTableView().getSelectionModel().getSelectedIndex();
		if (selectedIndex != -1) {
			setSelectedID((String)getColumn().getCellData(selectedIndex));
			getTableView().getItems().remove(selectedIndex);	
			return true;
		} 
		return false;
	}
	
	public void setSelectedID(String selectedID) {
		this.selectedID = selectedID;
	}
	
	public String getSelectedID() {
		return selectedID;
	}
}
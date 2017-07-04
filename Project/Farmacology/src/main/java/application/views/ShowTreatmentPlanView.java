package application.views;

import application.resources.Constants;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

public class ShowTreatmentPlanView extends AbstractView {
    @SuppressWarnings("rawtypes")
	private TableView tableView;
    @SuppressWarnings("rawtypes")
	protected TableColumn tableColumn;
    
    public ShowTreatmentPlanView(String title) {
    	init(title);
    }
    
	@SuppressWarnings("rawtypes")
	protected void createObjects() {
		super.createObjects();
        setTableView(new TableView());
	}
	
	protected void addObjects() {
		super.addObjects();
		vBox.getChildren().add(getTableView());
	}
	
	protected void alignObjects() {
		super.alignObjects();
		vBox.setAlignment(Pos.CENTER);
        BorderPane.setMargin(vBox, new Insets(15, 15, 15, 15));			
	}
	
	protected void setPositionsForObjects() {
		super.setPositionsForObjects();
		borderPane.setCenter(vBox);
	}
	
	protected Scene createScene() {										
		return new Scene(borderPane, Constants.SHOW_WINDOW_WIDTH, 
									 Constants.SHOW_WINDOW_HEIGHT);
	}
	
	@SuppressWarnings("rawtypes")
	public void createColumn(String columnName) {
		this.tableColumn = new TableColumn(columnName);
	}
	
	@SuppressWarnings("unchecked")
	public void addColumn() {
		getTableView().getColumns().addAll(tableColumn);
	}
	
	@SuppressWarnings("rawtypes")
	public TableColumn getColumn() {
		return tableColumn;
	}

	@SuppressWarnings("rawtypes")
	public TableView getTableView() {
		return tableView;
	}

	@SuppressWarnings("rawtypes")
	public void setTableView(TableView tableView) {
		this.tableView = tableView;
	}
}

package application.windows;

import java.sql.SQLException;
import application.handlers.EventHandlerClass;
import application.logic.Calculation;
import application.resources.Constants;
import application.views.AddHistoryView;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

public class AddHistoryWindow extends EventHandlerClass {
	protected AddHistoryView view;
    @SuppressWarnings("rawtypes")
	private ObservableList<ObservableList> data;

    public AddHistoryWindow() {
    	super.init();
    	init();
    }

	protected void init() {
		view = new AddHistoryView("New disease history");
		data = FXCollections.observableArrayList();
		buildPatientsData();
		data = FXCollections.observableArrayList();
		buildDiseasesData();
		setActionsForButtons();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void buildPatientsData() {
		try {
			dbConnector.createSelectPatientsQuery();
			dbConnector.executeSelectQuery();

			for (int i = 0; i < dbConnector.getColumnCount(); i++) {
				final int j = i;
				createPatientsColumn(i);
				view.getColumn().setCellValueFactory(
						new Callback<CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
							public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
								return new SimpleStringProperty(param.getValue().get(j).toString());
							}
						});

				view.addPatientsColumn();
			}

			while (dbConnector.nextElement()) {
				ObservableList<String> row = FXCollections.observableArrayList();
				for (int i = 1; i <= dbConnector.getColumnCount(); i++) {
					row.add(dbConnector.getDatabaseString(i));
				}
				data.add(row);
			}

			setPatientsItems();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void buildDiseasesData() {
		try {
			dbConnector.createSelectDiseasesQuery();
			dbConnector.executeSelectQuery();

			for (int i = 0; i < dbConnector.getColumnCount(); i++) {
				final int j = i;
				createDiseasesColumn(i);
				view.getColumn().setCellValueFactory(
						new Callback<CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
							public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
								return new SimpleStringProperty(param.getValue().get(j).toString());
							}
						});

				view.addDiseasesColumn();
			}

			while (dbConnector.nextElement()) {
				ObservableList<String> row = FXCollections.observableArrayList();
				for (int i = 1; i <= dbConnector.getColumnCount(); i++) {
					row.add(dbConnector.getDatabaseString(i));
				}
				data.add(row);
			}

			setDiseasesItems();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

    public void handle(ActionEvent event) {
    	executeInsertQuery();
	}
    
    private void executeInsertQuery() {
		try {
			dbConnector.createInsertHistoryQuery(view.getPatient(), 
												view.getDisease());		
			dbConnector.executeInsertQuery();
			int idHistory = getHistoryID();
			Calculation calc = new Calculation();
			calc.calculate(view.getDisease());
			
			for (int i = 0; i < calc.medCount; ++i) {
				dbConnector.createInsertTreatmentQuery(idHistory, 
						calc.getMedicineID().get(i), calc.getQuantity().get(i));
				dbConnector.executeInsertQuery();
			}
			setStatusOK();
		} catch (Exception ex) {
			setStatusERR();
		}		
	}

	public int getHistoryID() throws SQLException {
		dbConnector.createSelectLastHistoryQuery();
		dbConnector.executeSelectQuery();
		dbConnector.getResultSet().next();
		return dbConnector.getResultSet().getInt("idHistory");
	};
	
    protected void setStatusOK() {
    	view.setStatusText("New disease history added!");
    }
    
    protected void setStatusERR() {
    	view.setStatusText("Error adding new disease history! Check fields!");
    }
    
	protected void setActionsForButtons() {	
        view.setButtonAction(this);
	}
	
	@SuppressWarnings("unchecked")
	protected void setPatientsItems() {
		view.getTablePatients().setItems(data);
	}
	
	@SuppressWarnings("unchecked")
	protected void setDiseasesItems() {
		view.getTableDiseases().setItems(data);
	}
	
	protected void createPatientsColumn(int i) throws SQLException {
		view.createColumn(Constants.PATIENTS_COLUMNS[i]);
	}
	
	protected void createDiseasesColumn(int i) throws SQLException {
		view.createColumn(Constants.DISEASES_COLUMNS[i]);
	}

  	public void showWindow() {
		view.showStage();
	}
}
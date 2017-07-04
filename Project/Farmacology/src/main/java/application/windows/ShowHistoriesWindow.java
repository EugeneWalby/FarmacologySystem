package application.windows;

import java.sql.SQLException;
import application.handlers.EventHandlerClass;
import application.resources.Constants;
import application.views.ShowTreatmentPlanView;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

public class ShowHistoriesWindow extends EventHandlerClass {
	protected ShowTreatmentPlanView view;
    @SuppressWarnings("rawtypes")
	private ObservableList<ObservableList> data;

    public ShowHistoriesWindow() {
    	super.init();
    	init();
    }

	protected void init() {
		view = new ShowTreatmentPlanView("All diseases histories");
        data = FXCollections.observableArrayList();
		buildData();
	}
	
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public void buildData(){
          try {
        	dbConnector.createSelectDiseasesHistoriesQuery();
        	dbConnector.executeSelectQuery();

            for(int i = 0 ; i < dbConnector.getColumnCount(); i++) {
                final int j = i;                
                createColumn(i);
                view.getColumn().setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });

                view.addColumn();
            }

            while(dbConnector.nextElement()){
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i = 1 ; i <= dbConnector.getColumnCount(); i++){
                    row.add(dbConnector.getDatabaseString(i));
                }
                data.add(row);
            }

            setTableItems();
          } catch(Exception e){
              System.out.println(e);             
          }
      }

	@SuppressWarnings("unchecked")
	protected void setTableItems() {
		view.getTableView().setItems(data);
	}

	protected void createColumn(int i) throws SQLException {
		view.createColumn(Constants.HISTORIES_COLUMNS[i]);
	}

  	public void showWindow() {
		view.showStage();
	}
}
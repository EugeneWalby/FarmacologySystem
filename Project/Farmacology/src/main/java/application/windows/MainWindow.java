package application.windows;

import java.io.IOException;
import application.handlers.EventHandlerClass;
import application.resources.Constants;
import application.views.MainView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MainWindow extends EventHandlerClass {
	protected MainView view;
	
	public MainWindow() {
		init();
	}
	
	protected void init() {
		view = new MainView(Constants.MAIN_WINDOW_TITLE);
		super.init();
		setActionsForButtons();
	}
	
	protected void setActionsForButtons() {
		setAddPatientButtonAction();
		setAddHistoryButtonAction();
		setShowHistoriesButtonAction();
		setDeleteHistoryButtonAction();
		setShowTreatmentPlanButtonAction();
	}
	
	protected void setAddPatientButtonAction() {							
		view.setAddPatientButtonAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	openAddPatientWindow();
            }
		});
	}
	
	protected void setAddHistoryButtonAction() {							
		view.setAddHistoryButtonAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	openAddHistoryWindow();
            }
		});
	}
	
	protected void setShowHistoriesButtonAction() {							
		view.setShowHistoriesButtonAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	openShowHistoriesWindow();
            }
		});
	}
	
	protected void setDeleteHistoryButtonAction() {							
		view.setDeleteHistoryButtonAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	try {
					openDeleteHistoryWindow();
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
		});
	}
	
	protected void setShowTreatmentPlanButtonAction() {							
		view.setTreatmentPlanButtonAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	openTreatmentPlanWindow();
            }
		});
	}
	
	public void openAddPatientWindow() {
		AddPatientWindow window = new AddPatientWindow();
		window.showWindow();
	}
	
	public void openAddHistoryWindow() {
		AddHistoryWindow window = new AddHistoryWindow();
		window.showWindow();
	}
	
	public void openShowHistoriesWindow() {
		ShowHistoriesWindow window = new ShowHistoriesWindow();
		window.showWindow();
	}
	
	public void openDeleteHistoryWindow() throws IOException { 
		DeleteHistoryWindow window = new DeleteHistoryWindow();
		window.showWindow();
	}
	
	public void openTreatmentPlanWindow() {
		ShowTreatmentPlanWindow window = new ShowTreatmentPlanWindow();
		window.showWindow();
	}
	
	public void showWindow() {
		view.showStage();
	}
}
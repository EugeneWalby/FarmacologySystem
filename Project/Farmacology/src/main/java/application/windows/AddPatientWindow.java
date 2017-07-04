package application.windows;

import application.handlers.EventHandlerClass;
import application.views.AddPatientView;
import javafx.event.ActionEvent;

public class AddPatientWindow extends EventHandlerClass {
	protected AddPatientView view;

	public AddPatientWindow() {
		super.init();
		init();
	}

	protected void init() {
		view = new AddPatientView("New patient");
		setActionsForButtons();
	}

	public void handle(ActionEvent event) {
		executeInsertQuery();
	}

	private void executeInsertQuery() {
		try {
			dbConnector.createInsertPatientQuery(view.getFullName(), 
					view.getAddress(), view.getPhone());
			setStatusOK();
		} catch (Exception ex) {
			setStatusERR();
		}
	};

	protected void setStatusOK() {
		view.setStatusText("New patient registered!");
	}

	protected void setStatusERR() {
		view.setStatusText("Error! Please, check fields!");
	}

	protected void setActionsForButtons() {
		view.setButtonAction(this);
	}

	public void showWindow() {
		view.showStage();
	}
}
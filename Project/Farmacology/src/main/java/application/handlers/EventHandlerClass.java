package application.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class EventHandlerClass implements EventHandler<ActionEvent> {
	protected DatabaseConnector dbConnector;							
	
	protected void init() {
		dbConnector = new DatabaseConnector();
		dbConnector.getConnection();
	}
	
	public void handle(ActionEvent event) {
		
	}

	protected void setActionsForButtons() {
		
	}
}

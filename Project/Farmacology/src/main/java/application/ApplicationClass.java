package application;
	
import application.windows.MainWindow;
import javafx.application.Application;
import javafx.stage.Stage;

public class ApplicationClass extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			MainWindow mainWindow = new MainWindow();
			mainWindow.showWindow();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

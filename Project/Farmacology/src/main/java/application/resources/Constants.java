package application.resources;

public class Constants {
	public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	public static final String DATABASE_NAME = "farmacology";
    public static final String URL = 
    		"jdbc:mysql://localhost:3306/" + DATABASE_NAME;
    public static final String USER = "root";
    public static final String PASSWORD = "root";
    
	public static final String EMPTY_FIELDS_STATUS = "Please, fill empty fields!";	
	public static final String MAIN_WINDOW_TITLE = "Disease treatment system";

	public static final String PATIENTS_COLUMNS[] = {"ID", "Full name", 
			"Address", "Phone"};
	public static final String DISEASES_COLUMNS[] = {"ID", "Disease", 
			"Syptom", "Status"};
	public static final String HISTORIES_COLUMNS[] = {"Patient", "Disease", 
			"Syptom", "Status", "Registrated", "ID"};
	public static final String TREATMENTS_COLUMNS[] = {"Patient", "Disease", 
			"Registrated", "Medicine", "Quantity", "History ID"};
	
	public static final int MAIN_WINDOW_WIDTH = 270;
	public static final int MAIN_WINDOW_HEIGHT = 240;
	public static final int ADD_WINDOW_WIDTH = 250;
	public static final int ADD_WINDOW_HEIGHT = 200;
	public static final int ADD_WINDOW_WIDTH2 = 330;
	public static final int ADD_WINDOW_HEIGHT2 = 400;
	public static final int SHOW_WINDOW_WIDTH = 550;
	public static final int SHOW_WINDOW_HEIGHT = 250;
}

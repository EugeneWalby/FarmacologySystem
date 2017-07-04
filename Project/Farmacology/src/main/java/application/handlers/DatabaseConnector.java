package application.handlers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import application.resources.Constants;

public class DatabaseConnector {	
    private Connection connection;
    private Statement statement;
	private ResultSet resultSet;
    
	private String selectQuery;
	private String updateQuery;
	private String deleteQuery;
	
	public Connection getConnection() {
		try {
			createConnection();
			return connection;
		} catch (Exception e) {
			System.out.println(e);										
		}
		return null;
	}
	
	private void createConnection() throws ClassNotFoundException, 
													SQLException {
		Class.forName(Constants.DRIVER_NAME);
		connection = DriverManager.getConnection(
				Constants.URL, Constants.USER, Constants.PASSWORD);
	}
	
	public void executeUpdateQuery() throws SQLException {
		executeInsertQuery();
	}

	public boolean executeInsertQuery() throws SQLException {
		try {
			createStatement();
			statement.executeUpdate(updateQuery);
		} catch (SQLException ex) {
			return false;
		}
		
		return true;
	}
	
	public void executeSelectQuery() throws SQLException {
		createStatement();
		createResultSet();
	}
	
	public void executeDeleteQuery() throws SQLException {
		createStatement();
		statement.executeUpdate(deleteQuery);
	}
	
	private void createStatement() throws SQLException {
		statement = connection.createStatement();
	}
	
	private void createResultSet() {
		try {    		
			setResultSet(statement.executeQuery(selectQuery));
		} catch(SQLException e) {
			System.out.println(e);											
		}
	}
	
	public void createInsertPatientQuery(String name, String address, 
										String phone) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("insert into patient "
        		+ "values(not null, ?, ?, ?)");
        ps.setString(1, name);
        ps.setString(2, address);
        ps.setString(3, phone);
        ps.executeUpdate();            
        ps.close();
	}
	
	public void createInsertHistoryQuery(int patientID, int diseaseID) 
													throws SQLException {
		long term = 1000000000;
        java.util.Date date = new java.util.Date();
        java.sql.Date regDate = new java.sql.Date(date.getTime());
        java.sql.Date recoveryDate = new java.sql.Date(date.getTime() + term);
        PreparedStatement ps = connection.prepareStatement("insert into history "
        		+ "values(not null, ?, ?, ?, ?)");
        ps.setInt(1, patientID);
        ps.setInt(2, diseaseID);
        ps.setDate(3, regDate);
        ps.setDate(4, recoveryDate);
        ps.executeUpdate();            
        ps.close();
	}
	
	public void createInsertTreatmentQuery(int historyID ,int medID, 
							double quantity) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(
				"insert into treatment values(not null, ?, ?, ?)");
		ps.setInt(1, historyID);
		ps.setInt(2, medID);
		ps.setDouble(3, quantity);
		ps.executeUpdate(); 
		ps.close();
	}
	
	public void createSelectPatientsQuery() {
		StringBuilder sb = new StringBuilder();
		sb.append("select idPatient, fullName, address, phone "
				+ "from patient");
		setSelectQuery(sb.toString());
	}
	
	public void createSelectLastHistoryQuery() {
		StringBuilder sb = new StringBuilder();
		sb.append("select idHistory from history "
				+ "order by idHistory desc limit 1");
		setSelectQuery(sb.toString());
	}

	public void createSelectDiseasesQuery() {
		StringBuilder sb = new StringBuilder();
		sb.append("select idDisease, disease.title, symptom.title, status.title "
				+ "from disease inner join symptom_status "
				+ "on disease.idSymptomStatus=symptom_status.idSymptomStatus "
				+ "inner join symptom on symptom_status.idSymptom=symptom.idSymptom "
				+ "inner join status on symptom_status.idStatus=status.idStatus "
				+ "order by idDisease");
		setSelectQuery(sb.toString());
	}
	
	public void createSelectDiseasesHistoriesQuery() {
		StringBuilder sb = new StringBuilder();
		sb.append("select fullName, disease.title, symptom.title, "
				+ "status.title, registrationDate, idHistory from history "
				+ "inner join patient on history.idPatient=patient.idPatient "
				+ "inner join disease on history.idDisease=disease.idDisease "
				+ "inner join symptom_status "
				+ "on disease.idSymptomStatus=symptom_status.idSymptomStatus "
				+ "inner join symptom on symptom_status.idSymptom=symptom.idSymptom "
				+ "inner join status on symptom_status.idStatus=status.idStatus");
		setSelectQuery(sb.toString());
	}

	public void createSelectTreatmentsQuery() {
		StringBuilder sb = new StringBuilder();
		sb.append("select fullName, disease.title, registrationDate, "
				+ "medicine.title, Quantity, history.idHistory from treatment "
				+ "inner join history on treatment.idHistory=history.idHistory "
				+ "inner join patient on history.idPatient=patient.idPatient "
				+ "inner join disease on history.idDisease=disease.idDisease "
				+ "inner join medicine on treatment.idMedicine=medicine.idMedicine");
		setSelectQuery(sb.toString());
	}
	
	public void createDeleteHistoryQuery(String id) throws SQLException {
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM ")
			.append("history ").append(" WHERE idHistory = ")
			.append(Integer.parseInt(id)).append(";");
		setDeleteQuery(sb.toString());
	}
	
	public boolean nextElement() throws SQLException {
		if (resultSet.next()) {
			return true;
		}
		return false;
	}
	
    public Statement getStatement() {
    	try {
    		createStatement();
    		return statement;
    	} catch (SQLException e) {
			System.out.println(e);								
		}
    	return null;
	}
	
	public ResultSet getResultSet() {
		return resultSet;
	}
	
	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}
	
	public String getUpdateQuery() {
		return updateQuery;
	}
	
	public String getSelectQuery() {
		return selectQuery;
	}
	
	public void setUpdateQuery(String updateQuery) {
		this.updateQuery = updateQuery;
	}
	
	public void setSelectQuery(String selectQuery) {
		this.selectQuery = selectQuery;
	}
	
	public void setDeleteQuery(String deleteQuery) {
		this.deleteQuery = deleteQuery;
	}
	
	public int getColumnCount() throws SQLException {
		return resultSet.getMetaData().getColumnCount();
	}
	
	public String getDatabaseString(int number) throws SQLException {
		return resultSet.getString(number);
	}
}

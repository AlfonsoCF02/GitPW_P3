package data.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import properties.DBConnectionProperites;

/**
 * A class to manage the MySQL connection (general methods and configuration).
 * @author Alfonso Cabezas
 * */


public class connection {
	/* Attributes */
	/**
	 * The connection is initially set to null
	 */
	protected Connection connection = null;
	/**
	 * !!!!!!!!!!!!
	 */
	DBConnectionProperites db = new DBConnectionProperites();
	/**
	 * Get url from DB
	 */
	protected String url = db.getBDUrl_file();
	/**
	 * Get username from DB
	 */
	protected String user = db.getBDUser_file();
	/**
	 * Get user´s password from DB
	 */
	protected String password = db.getBDPass_file();

	
	/**
	 * A method that allow to connect to DataBase
	 * */
	public Connection getConnection(){

		try{
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = (Connection) DriverManager.getConnection("jdbc:mysql://oraclepr.uco.es:3306/i02cabfa","i02cabfa","zapatilla");
		} 
		catch (SQLException e) {
			System.err.println("Connection to MySQL has failed!");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("JDBC Driver not found.");
			e.printStackTrace();
		}
		return this.connection;
	}
	
	
	
	/**
	 * A method that allow to close the connection with DB
	 * */

	// We can include here other methods to encapsulate CRUD commands...
	public void closeConnection() {
		try {
			if(this.connection != null && !this.connection.isClosed()) {
				this.connection.close();
			}
		} catch (SQLException e) {
			System.err.println("Error while trying to close the connection.");
			e.printStackTrace();
		}
	}
}
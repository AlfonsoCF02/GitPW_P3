package properties;

import javax.naming.Context;
import javax.naming.InitialContext;


/**
 * A class to manage the MySQL connection properties.
 * @author Alfonso Cabezas
 * */


/**
 * A method that allows to get the connection data from the DataBase
 * @author Alfonso Cabezas
 * */

public class DBConnectionProperites {

	private String BDurl_file;
	private String BDuser_file;
	private String BDpass_file;
	
	public String getBDUrl_file(){
		cargar_datos();
		return BDurl_file;
	}

	public String getBDUser_file() {
		cargar_datos();
		return BDuser_file;
	}

	public String getBDPass_file() {
		cargar_datos();
		return BDpass_file;
	}

	
	/**
	* A method that allows to load the data
	 * @throws NamingException 
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	* */
	
	private void cargar_datos()  {
		
			
			try {
				
				Context cntxt= (Context) new InitialContext().lookup("java:comp/env");
				
				BDurl_file = (String)cntxt.lookup("servidor");
				BDuser_file = (String)cntxt.lookup("usuario");
				BDpass_file = (String)cntxt.lookup("password");
				
			} catch (Exception e) {
				e.printStackTrace();
			}			
     
	}

}

	

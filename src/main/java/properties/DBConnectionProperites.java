package properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import javax.naming.NamingException;
import org.xml.sax.SAXException;


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
	
			
			/*File file = new File("../../webapp/WEB-INF/lib/web.xml");
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.loadFromXML(fileInput);
			fileInput.close();
			properties.getProperty("servidor");
			*/
			BDurl_file = "jdbc:mysql://oraclepr.uco.es:3306/";
		    BDuser_file= "i02cabfa";
		    BDpass_file= "zapatilla";
			
			
     
	}

}

	

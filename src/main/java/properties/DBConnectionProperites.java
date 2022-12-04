package properties;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.lang.model.element.Element;
import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
;
/**
 * A class to manage the MySQL connection properties.
 * @author 
 * @author Victoria Muñoz
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
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	* */
	private void cargar_datos()  {
	
	Properties prop = new Properties();
	 BDurl_file = "jdbc:mysql://oraclepr.uco.es:3306/i02cabfa";
     BDuser_file="i02cabfa";
     BDpass_file= "zapatilla";
	}
}

	

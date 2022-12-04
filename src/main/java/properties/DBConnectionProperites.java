package properties;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.lang.model.element.Element;
import javax.swing.text.Document;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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
	
	public String getBDUrl_file() {
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
	* */
	private void cargar_datos() {
		
	Properties prop = new Properties();
	String filename = "../WEB_INF/context.xml";
	
	try {
		
		BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
		prop.load(reader);
		
		Document doc=dBuilder.parse(contenidoFicheroXML);
		NodeList nodoUsuario = doc.getElementsByTagName("usuario");
		Node nNode = nodoUsuario.item(temp);
		Element eElement = (Element) nNode;
		
		BDurl_file = prop.getProperty("BDurl");
		BDuser_file = prop.getProperty("BDuser");
		BDpass_file = prop.getProperty("BDpass");

		
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}
	
}

	

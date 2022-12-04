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
	
	public String getBDUrl_file() throws ParserConfigurationException, SAXException, IOException {
		cargar_datos();
		return BDurl_file;
	}

	public String getBDUser_file() throws ParserConfigurationException, SAXException, IOException {
		cargar_datos();
		return BDuser_file;
	}

	public String getBDPass_file() throws ParserConfigurationException, SAXException, IOException {
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
	 File file = new File("context.xml");
     DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
     DocumentBuilder db = null;
	try {
		db = dbf.newDocumentBuilder();
	} catch (ParserConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     Document document = null;
	try {
		document = (Document) db.parse(file);
	} catch (SAXException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     ((org.w3c.dom.Document) document).getDocumentElement().normalize();
     System.out.println("Root Element :" + ((org.w3c.dom.Document) document).getDocumentElement().getNodeName());
     NodeList nList = ((org.w3c.dom.Document) document).getElementsByTagName("");
     for (int temp = 0; temp < nList.getLength(); temp++) {
         Node nNode = nList.item(temp);
         System.out.println("\nCurrent Element :" + nNode.getNodeName());
         if (nNode.getNodeType() == Node.ELEMENT_NODE) {
             Element eElement = (Element) nNode;
             BDurl_file = (String) ((DocumentBuilderFactory) eElement).getAttribute("url");
             BDuser_file= (String) ((DocumentBuilderFactory) eElement).getAttribute("username");
             BDpass_file= (String) ((DocumentBuilderFactory) eElement).getAttribute("password");
         }
     }
	}
	
}

	

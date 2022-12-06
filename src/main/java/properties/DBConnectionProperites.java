package properties;


import java.io.IOException;
import javax.naming.Context;
import javax.naming.InitialContext;
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
	
	Context ctx;
	
		try {
			
			ctx = new InitialContext();
			Context env = (Context) ctx.lookup("../webapp/WEB-INF/lib/web.xml");
			
		    BDurl_file = (String) env.lookup("servidor");
		    BDuser_file= (String) env.lookup("usuario");
		    BDpass_file= (String) env.lookup("pass");
		    
		} catch (NamingException e) {
			e.printStackTrace();
		}
     
	}

}

	

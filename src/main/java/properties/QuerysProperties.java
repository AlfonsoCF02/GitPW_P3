package properties;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
/**
 * A method that allows to get the connection data from the DataBase
 * @author Alfonso de la Torre
 * A method that return the querys of sql
 * */
public class QuerysProperties {

	private String insertUser;
	private String updateUser;
	private String selectUserByEmail;
	private String deleteUser;
	private String selectAllUsers;
	private String selectAllReservas;
	private String selectReservaById;
	private String deleteReserva;
	private String insertReserva;
	private String updateReserva;
	private String insertKart;
	private String selectKartById;
	private String updateKart;
	private String deleteKart;
	private String selectAllKarts;
	private String insertBono;
	private String selectBonoById;
	private String selectBonoSecondPart;
	private String deleteBono;
	private String selectRestantesBono;
	private String updateBono;
	private String selectAllBonos;
	private String updateRestantesBono;
	private String updateRestantesBonoDos;
	private String insertPista;
	private String selectPistaByName;
	private String selectPistasFalse;
	private String selectPistaFirst;
	private String selectPistaSecond;
	private String insertKartPistas;
	private String selectKartPistasFirst;
	private String selectKartPistasSecond;
	private String selectConcretaUno;
	private String selectConcretaDos;
	
	public String getSelectConcretaDos() {
		cargar_datos();
		return selectConcretaDos;
	}
	
	public String getSelectConcretaUno() {
		cargar_datos();
		return selectConcretaUno;
	}
	
	public String getSelectKartPistasSecond() {
		cargar_datos();
		return selectKartPistasSecond;
	}
	
	public String getSelectKartPistasFirst() {
		cargar_datos();
		return selectKartPistasFirst;
	}
	
	public String getInsertKartPistas() {
		cargar_datos();
		return insertKartPistas;
	}
	
	public String getSelectPistaSecond() {
		cargar_datos();
		return selectPistaSecond;
	}
	
	public String getSelectPistaFirst() {
		cargar_datos();
		return selectPistaFirst;
	}
	
	public String getSelectPistasFalse() {
		cargar_datos();
		return selectPistasFalse;
	}
	
	public String getSelectPistaByName() {
		cargar_datos();
		return selectPistaByName;
	}
	
	public String getInsertPista() {
		cargar_datos();
		return insertPista;
	}
	
	public String getUpdateRestantesBonoDos() {
		cargar_datos();
		return updateRestantesBonoDos;
	}
	
	public String getUpdateRestantesBono() {
		cargar_datos();
		return updateRestantesBono;
	}
	
	public String getSelectAllBonos() {
		cargar_datos();
		return selectAllBonos;
	}
	
	public String getUpdateBono() {
		cargar_datos();
		return updateBono;
	}
	
	public String getSelectRestantesBono() {
		cargar_datos();
		return selectRestantesBono;
	}
	
	public String getDeleteBono() {
		cargar_datos();
		return deleteBono;
	}
	
	public String getSelectBonoSecondPart() {
		cargar_datos();
		return selectBonoSecondPart;
	}
	
	public String getSelectBonoById() {
		cargar_datos();
		return selectBonoById;
	}
	public String getInsertBono() {
		cargar_datos();
		return insertBono;
	}
	public String getInsertUser() {
		cargar_datos();
		return insertUser;
	}
	
	public String getInsertKart() {
		cargar_datos();
		return insertKart;
	}

	public String getUpdateUser() {
		cargar_datos();
		return updateUser;
	}

	public String getSelectUserByEmail() {
		cargar_datos();
		return selectUserByEmail;
	}
	
	public String getSelectKartById() {
		cargar_datos();
		return selectKartById;
	}
	
	public String getDeleteUser() {
		cargar_datos();
		return deleteUser;
	}

	public String getSelectAllUsers() {
		cargar_datos();
		return selectAllUsers;
	}

	public String getSelectAllKarts() {
		cargar_datos();
		return selectAllKarts;
	}
	
	public String getSelectAllReservas() {
		cargar_datos();
		return selectAllReservas;
	}
	
	public String getSelectReservaById() {
		cargar_datos();
		return selectReservaById;
	}

	public String getDeleteReserva() {
		cargar_datos();
		return deleteReserva;
	}
	
	public String getDeleteKart() {
		cargar_datos();
		return deleteKart;
	}

	public String getInsertReserva() {
		cargar_datos();
		return insertReserva;
	}
	
	public String getUpdateReserva() {
		cargar_datos();
		return updateReserva;
	}
	
	public String getUpdateKart() {
		cargar_datos();
		return updateKart;
	}
	/**
	* A method that allows to load the data
	* */
	private void cargar_datos() {
		
		Properties prop = new Properties();
		String filename = new String("./main/java/properties_file/sql.properties");
		
		System.out.println();
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
			prop.load(reader);
			
			insertUser = prop.getProperty("insertUser");
			updateUser = prop.getProperty("updateUser");
			selectUserByEmail = prop.getProperty("selectUserByEmail");
			deleteUser = prop.getProperty("deleteUser");
			selectAllUsers = prop.getProperty("selectAllUsers");
			selectAllReservas = prop.getProperty("selectAllReservas");
			selectReservaById = prop.getProperty("selectReservaById");
			deleteReserva = prop.getProperty("deleteReserva");
			insertReserva = prop.getProperty("insertReserva");
			updateReserva = prop.getProperty("updateReserva");
			insertKart = prop.getProperty("insertKart");
			selectKartById = prop.getProperty("selectKartById");
			updateKart = prop.getProperty("updateKart");
			deleteKart = prop.getProperty("deleteKart");
			selectAllKarts = prop.getProperty("selectAllKarts");
			insertBono = prop.getProperty("insertBono");
			selectBonoById = prop.getProperty("selectBonoById");
			selectBonoSecondPart = prop.getProperty("selectBonoSecondPart");
			deleteBono = prop.getProperty("deleteBono");
			selectRestantesBono = prop.getProperty("selectRestantesBono");
			updateBono = prop.getProperty("updateBono");
			selectAllBonos = prop.getProperty("selectAllBonos");
			updateRestantesBono=prop.getProperty("updateRestantesBono");
			updateRestantesBonoDos=prop.getProperty("updateRestantesBonoDos");
			insertPista=prop.getProperty("insertPista");
			selectPistaByName=prop.getProperty("selectPistaByName");
			selectPistasFalse=prop.getProperty("selectPistasFalse");
			selectPistaFirst=prop.getProperty("selectPistaFirst");
			selectPistaSecond=prop.getProperty("selectPistaSecond");
			insertKartPistas=prop.getProperty("insertKartPistas");
			selectKartPistasFirst=prop.getProperty("selectKartPistasFirst");
			selectKartPistasSecond=prop.getProperty("selectKartPistasSecond");
			selectConcretaUno=prop.getProperty("selectConcretaUno");
			selectConcretaDos=prop.getProperty("selectConcretaDos");
						
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		}
	
}

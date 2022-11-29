package business.usuario;

import java.util.Date;

import business.kart.KartDTO;
import business.pista.PistaDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

/**
 * A class that implements the User 
 * @author Alfonso Cabezas
 * @author Abraham Córdoba
 * */

public class UsuarioDTO {

	/* Attributes */
	/**
	 * The user name
	 */
	private String name;
	/**
	 * The user surname
	 */
	private String surname;
	/**
	 * The user date of birth
	 */
	private Date birth;
	/**
	 * The user first booking
	 */
	private Date firstBooking;
	/**
	 * The user email
	 */
	private String email;
	
	private String passw;
	
	private String tipo;
	/**
	 * Empty (default) constructor
	 * */
	public UsuarioDTO() {
		
	}
	
	/**
	 * Parameterized constructor
	 * @param name The user name
	 * @param surname The user surname
	 * @param The user date of birth
	 * @param The user email
	 * */
	public UsuarioDTO(String name, String surname, Date birth, String email) {
		this.name = name;
		this.surname = surname;
		this.birth = birth;
		this.firstBooking = new Date(); //Actual del sistema
		this.email = email;
	}


	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo=tipo;
	}
	public String getPass() {
		return passw;
	}

	public void setPass(String pass) {
		this.passw = pass;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Date getFirstBooking() {
		return firstBooking;
	}

	public void setFirstBooking(Date firstBooking) {
		this.firstBooking = firstBooking;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "UsuarioDTO [name=" + name + ", surname=" + surname + ", birthDate=" + birth + ", firstBooking=" + firstBooking
				+ ", email=" + email + "]";
	}
}

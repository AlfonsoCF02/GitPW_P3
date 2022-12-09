package display.javabean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import business.usuario.GestorUsuario;
import business.usuario.UsuarioDTO;
import business.usuario.typeof;

public class CustomerBean implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String password;
	private typeof privilegios;
	private String mail;
	private String email="";
	private String nombre="";
	private String apellidos="";
	private Date fechN;
	private Date primres;
	private String nres;
	
	public String getNres() {
		return this.nres;
	}
	
	public void setNres(String res) {
		nres=res;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nom) {
		nombre=nom;
	}
	
	public String getApellidos() {
		return this.apellidos;
	}
	
	public void setApellidos(String ap) {
		apellidos=ap;
	}
	
	public Date getfechN() {
		return this.fechN;
	}
	
	public void setfechN(Date fech) {
		fechN=fech;
	}
	
	public Date getprimres() {
		return this.primres;
	}
	
	public void setprimres(Date reserva) {
		primres=reserva;
	}	
	
	public typeof getPrivilegios() {
		return privilegios;
	}

	public void setPrivilegios(typeof p) {
		this.privilegios = p;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getLogin() {
		return mail;
	}

	public void setLogin(String email) {
		this.mail = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String pass) {
		this.password = pass;
	}

	public ArrayList<CustomerBean> users() throws SQLException{
		ArrayList<UsuarioDTO> udto=new ArrayList<UsuarioDTO>();
		ArrayList<CustomerBean> listbean=new ArrayList<CustomerBean>();
		GestorUsuario g=new GestorUsuario();
		udto=g.listarUsuarios();
		for(int i=0;i<udto.size();i++) {
			CustomerBean c=new CustomerBean();
			c.setNombre(udto.get(i).getName());
			c.setApellidos(udto.get(i).getSurname());
			c.setEmail(udto.get(i).getEmail());
			c.setPassword(udto.get(i).getPass());
			c.setfechN(udto.get(i).getBirth());
			c.setprimres(udto.get(i).getFirstBooking());
			c.setPrivilegios(udto.get(i).getTipo());
			c.setNres(udto.get(i).getNRes());
			listbean.add(c);
		}
		return listbean;
	}
	
	
}

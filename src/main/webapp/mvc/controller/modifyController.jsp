<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="business.usuario.UsuarioDTO,data.UserDAO" %>
<%@ page import ="java.util.Date" %>
<%@ page import ="business.usuario.typeof" %>
<%@ page import ="business.usuario.*" %>
<%@ page import ="java.text.SimpleDateFormat" %>
<jsp:useBean  id="customerBean" scope="session" class="display.javabean.CustomerBean"></jsp:useBean>
<%
/* Posibles flujos:
	1) customerBean está logado (!= null && != "") -> Se redirige al index.jsp
	2) customerBean no está logado:
		a) Hay parámetros en el request  -> procede de la vista 
		b) No hay parámetros en el request -> procede de otra funcionalidad o index.jsp
	*/
//Caso 1: Por defecto, vuelve al index
String nextPage = "../../index.jsp";
String mensajeNextPage = "";
String mensajeError="";
//Caso 2
if (customerBean == null || customerBean.getEmail().equals("")) {
	String nameUser = request.getParameter("nombre");
	String apellidosUser = request.getParameter("apellidos");
	String passwordUser = request.getParameter("password");
	String fechNUser = request.getParameter("fechN");

	//Caso 2.a: Hay parámetros -> procede de la VISTA
	if (nameUser != null) {
		Date birth = new Date();			
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		birth = format.parse(fechNUser);
		//Se accede a bases de datos para obtener el usuario
	    GestorUsuario g=new GestorUsuario();
		//Hacer que te devuelva un dao con el usuario
		//new UsuarioDTO( "name", "String surname", new Date(), "aaa","String password",typeof.user)
		UsuarioDTO u=new UsuarioDTO();
		UserDAO ud=new UserDAO();
		u=ud.obtenerUser(customerBean.getEmail());
		g.modificarUsuario(nameUser, apellidosUser, customerBean.getEmail(), birth, u.getFirstBooking(), customerBean.getPrivilegios(), passwordUser);
			%>
			<jsp:setProperty  name="customerBean" property="password" value="<%=passwordUser%>"/>
			<jsp:setProperty  name="customerBean" property="nombre" value="<%=nameUser%>"/>
			<jsp:setProperty  name="customerBean" property="apellidos" value="<%=apellidosUser%>"/>
			<jsp:setProperty  name="customerBean" property="fechN" value="<%=fechNUser%>"/>
			<%		
			nextPage = "../view/modifyView.jsp";
			mensajeNextPage = "El usuario que ha indicado no existe o no es v&aacute;lido";
	//Caso 2.b -> se debe ir a la vista por primera vez
	} else {
		nextPage = "../view/loginView.jsp";		
	}
}
%>
<jsp:forward page="<%=nextPage%>">
	<jsp:param value="<%=mensajeNextPage%>" name="message"/>
</jsp:forward>
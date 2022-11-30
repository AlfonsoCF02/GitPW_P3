<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="business.usuario.UsuarioDTO,data.UserDAO" %>
<%@ page import ="java.util.Date" %>
<%@ page import ="business.usuario.typeof" %>
<jsp:useBean  id="customerBean" scope="session" class="display.javabean.UserBean"></jsp:useBean>
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
//Caso 2
if (customerBean == null || customerBean.getLogin().equals("")) {
	String emailUser = request.getParameter("email");
	String passwordUser = request.getParameter("password");
	String rolUser = request.getParameter("rol");
	//Caso 2.a: Hay parámetros -> procede de la VISTA
	if (emailUser != null) {
		//Se accede a bases de datos para obtener el usuario
		UserDAO userDAO = new UserDAO();
			//Hacer que te devuelva un dao con el usuario
			//new UsuarioDTO( "name", "String surname", new Date(), "aaa","String password",typeof.user)
		UsuarioDTO user = new UsuarioDTO();
		user=userDAO.obtenerUser(emailUser);
		//Se realizan todas las comprobaciones necesarias del dominio
		//Aquí sólo comprobamos que exista el usuario
		if (user != null && user.getEmail().equals(emailUser)) {
			// Usuario válido		
			%>
			<jsp:setProperty  name="customerBean" property="*"/>
			<%		
		} else {
			// Usuario no válido
			nextPage = "../view/loginView.jsp";
			mensajeNextPage = "El usuario que ha indicado no existe o no es v&aacute;lido";
		}
	//Caso 2.b -> se debe ir a la vista por primera vez
	} else {
		nextPage = "../view/loginView.jsp";		
	}
}
%>
<jsp:forward page="<%=nextPage%>">
	<jsp:param value="<%=mensajeNextPage%>" name="message"/>
</jsp:forward>
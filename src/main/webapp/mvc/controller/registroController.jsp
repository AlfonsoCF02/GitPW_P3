<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="business.usuario.UsuarioDTO,data.UserDAO" %>
<%@ page import ="java.util.Date" %>
<%@ page import ="business.usuario.typeof" %>
<%@page errorPage="../../errorLogin.jsp" %>
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
String mensajeError="";
//Caso 2
if (customerBean == null || customerBean.getEmail().equals("")) {
	String emailUser = request.getParameter("email");
	String passwordUser = request.getParameter("password");
	String nomUser = request.getParameter("nombre");
	String apellidosUser = request.getParameter("apellidos");
	Date fechUser = request.getParameter("fechanacimiento");
	typeof priv=request.getParameter("rol");
	//Caso 2.a: Hay parámetros -> procede de la VISTA
	if (emailUser != null) {
		UserDAO userDAO = new UserDAO();
			
			%>
			<jsp:setProperty  name="customerBean" property="email" value="<%=emailUser%>"/>
			<jsp:setProperty  name="customerBean" property="password" value="<%=passwordUser%>"/>
			<jsp:setProperty  name="customerBean" property="privilegios" value="<%=priv%>"/>
			<jsp:setProperty  name="customerBean" property="nombre" value="<%=nomUser%>"/>
			<jsp:setProperty  name="customerBean" property="apellidos" value="<%=apellidosUser%>"/>
			<jsp:setProperty  name="customerBean" property="fechN" value="<%=fechUser%>"/>
			<%		
		
			nextPage = "../view/registroView.jsp";
			mensajeNextPage = "El usuario se ha registrado correctamente";
		
	//Caso 2.b -> se debe ir a la vista por primera vez
	} else {
		nextPage = "../view/registroView.jsp";		
	}
}
%>
<jsp:forward page="<%=nextPage%>">
	<jsp:param value="<%=mensajeNextPage%>" name="message"/>
</jsp:forward>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="display.javabean.UserBean" %>
<jsp:useBean  id="customerBean" scope="session" class="display.javabean.UserBean"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Cordoba Karting</title>
	<link rel="stylesheet" href="css/estilos.css" type="text/css"><link>
</head>
<body>
	<header>
		<nav class="nav">
			<ul>
				<li id="nav_fecha" class="nav_li"><%
				java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat ("dd/MM/yyyy");
				 java.util.Date currentTime = new java.util.Date (); // Obtener la hora actual del sistema
				 String str_date1 = formatter.format (currentTime); // format datetime
				 String str_date2 = str_date1.toString (); // Convertir fecha y hora en forma de cadena
				%>
                <%=str_date2 %></li>
				<li id="nav_nombre"class="nav_li"><a href="index.jsp"><b>CORDOBA KARTING</b></a></li>
				<%
				if (customerBean == null || customerBean.getEmail()=="") {
				%>
				<li id="nav_sesion" class="nav_li"><a href="./mvc/controller/loginController.jsp">Iniciar Sesion</a></li>
				<li id="nav_sesion" class="nav_li"><a href="./mvc/controller/registroController.jsp">Registrarse</a></li>
				<% 
				} else { %>
				<li id="nav_sesion" class="nav_li"><jsp:getProperty name="customerBean" property="email"/></li>
				<%} %>

			</ul>
		</nav>
	</header>
<% 
//Este código de reset es únicamente para poder probar múltiples veces el MVC
if (request.getParameter("reset") != null) {
%>
<jsp:setProperty property="email" value="" name="customerBean"/>
<%
}
if (customerBean == null || customerBean.getEmail()=="") {
	// Usuario no logado -> Se invoca al controlador de la funcionalidad
%>

<% } else { %>
BUENAS |<jsp:getProperty name="customerBean" property="email"/>|<jsp:getProperty name="customerBean" property="privilegios"/>
<% } %>
</body>
</html>
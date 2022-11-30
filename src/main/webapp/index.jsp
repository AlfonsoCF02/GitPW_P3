<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean  id="customerBean" scope="session" class="display.javabean.UserBean"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Prueba de MVC</title>
</head>
<body>
<% 
//Este código de reset es únicamente para poder probar múltiples veces el MVC
if (request.getParameter("reset") != null) {
%>
<jsp:setProperty property="email" value="" name="customerBean"/>
<%
}
if (customerBean == null || customerBean.getLogin()=="") {
	// Usuario no logado -> Se invoca al controlador de la funcionalidad
%>
<a href="./mvc/controller/loginController.jsp">Acceder</a>
<% } else { %>
	¡¡Bienvenido <jsp:getProperty property="email" name="customerBean"/>!! 
<% } %>
</body>
</html>
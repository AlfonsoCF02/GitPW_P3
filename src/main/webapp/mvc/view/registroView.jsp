<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean  id="customerBean" scope="session" class="display.javabean.CustomerBean"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<script src = "../../js/checkFormularioRegistro.js"></script>
<meta charset="UTF-8">
<title>Log in</title>
</head>
<body>
<%
String nextPage = "../controller/registroController.jsp";
String messageNextPage = request.getParameter("message");
if (messageNextPage == null) messageNextPage = "";

if (customerBean != null && !customerBean.getEmail().equals("")) {
	nextPage = "../../index.jsp";
} else {
%>
<%= messageNextPage %><br/><br/>
<form id="formregistro" method="post" onSubmit="return Validar()">
	<label for="email">Email: </label>
	<input type="text" id="email" name="email" placeholder="Enter email" required><br/>
	<label for="password">Password: </label>
	<input type="password" id="password" name="password" placeholder="Enter password" required><br/>
	<label for="nombre">Nombre: </label>
	<input type="text" id="nombre" name="nombre" placeholder="Enter name" required><br/>
	<label for="apellidos">Apellidos: </label>
	<input type="text" id="apellidos" name="apellidos" placeholder="Enter surname" required><br/>
	<label for="fechN">Fecha Nacimiento: </label>
	<input type="Date" id="fechanacimiento" name="fechN" placeholder="Enter bithday" required><br/>
	<input type="hidden" name="privilegios" value="user"><br/>
	<input type="submit" value="Submit">
</form>
<%
}
%>
</body>
</html>
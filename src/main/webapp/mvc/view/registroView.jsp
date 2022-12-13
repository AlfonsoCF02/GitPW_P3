<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean  id="customerBean" scope="session" class="display.javabean.CustomerBean"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<script src = "../../js/checkAge.js"></script>
<meta charset="UTF-8">
<title>Registro</title>
</head>
<body>
<%
String nextPage = "../controller/registroController.jsp";
String messageNextPage = request.getParameter("message");
if (messageNextPage == null) messageNextPage = "";

if (customerBean != null && !customerBean.getEmail().equals("")) {
	%>Usted ya esta logado
	<a href="../../index.jsp">volver al indice</a><br/><%
} else {
%>
<%= messageNextPage %><br/><br/>
<form method="post" onSubmit="return ValidarAnio('fechN')">
	<label for="email">Email: </label>
	<input type="text" name="email" placeholder="Enter email" required><br/>
	<label for="password">Password: </label>
	<input type="password" name="password" placeholder="Enter password" required><br/>
	<label for="nombre">Nombre: </label>
	<input type="text" name="nombre" placeholder="Enter name" required><br/>
	<label for="apellidos">Apellidos: </label>
	<input type="text" name="apellidos" placeholder="Enter surname" required><br/>
	<label for="fechN">Fecha Nacimiento: </label>
	<input type="Date" name="fechN" placeholder="Enter bithday" required><br/>
	<input type="hidden" name="privilegios" value="user"><br/>
	<input type="submit" value="Submit">
</form>
<%
}
%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean  id="customerBean" scope="session" class="display.javabean.CustomerBean"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modificar datos</title>
</head>
<body>
<%
if (customerBean != null && !customerBean.getEmail().equals("")) {%>
	<form method="post" action="../controller/modifyController.jsp">
	<label for="nombre">Nombre: </label>
	<input type="text" name="nombre" placeholder="Enter name" required><br/>
	<label for="apellidos">Apellidos: </label>
	<input type="text" name="apellidos" placeholder="Enter surname" required><br/>
	<label for="password">Password: </label>
	<input type="password" name="password" placeholder="Enter password" required>	
	<br/>
	<label for="fechN">Fecha Nacimiento: </label>
	<input type="Date" name="fechN" placeholder="Enter bithday" required><br/>
	<input type="submit" value="Submit">
</form><%
} else{%>
	Debe registrarse para acceder a la funcionalidad
	<a href="${pageContext.request.contextPath}/index.jsp">volver al indice</a><br/><%
}
%>

</body>
</html>
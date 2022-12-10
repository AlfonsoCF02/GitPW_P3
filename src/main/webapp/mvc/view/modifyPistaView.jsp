<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="business.pista.*" %>
<%@ page import="data.*" %>

<jsp:useBean  id="customerBean" scope="session" class="display.javabean.CustomerBean"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modificar Pista</title>
</head>
<body>
<%
if (customerBean != null && !customerBean.getEmail().equals("") && (customerBean.getPrivilegios().toString().equals("admin"))) {%>
	<form method="post" action="${pageContext.request.contextPath}/pistastate">
	<label for="pista">pista: </label>
	<input type="text" id="pista" name="pista" placeholder="" required><br/>
	<label for="disponible">Estado nuevo: </label>
	<input type="text" id="disponible" name="disponible" placeholder="true/false" required><br/>	
	<input type="submit" value="Submit">
</form><%
} else{%>
	Debe registrarse para acceder a la funcionalidad y ser administrador
	<a href="${pageContext.request.contextPath}/index.jsp">volver al indice</a><br/><%
}
%>

</body>
</html>
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
<form method="post" action="${pageContext.request.contextPath}/pistatate">
	<label for="pista">pista: </label>
	<input type="text" id="pista" name="pista" placeholder="" required><br/>
	<label for="disponible">Estado nuevo: </label>
	<input type="text" id="disponible" name="disponible" placeholder="true/false" required><br/>	
	<input type="submit" value="Submit">
</form>
</body>
</html>
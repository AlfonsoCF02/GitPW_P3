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
<title>Log in</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/kartstate">
	<label for="kart">kart: </label>
	<input type="text" id="kart" name="kart" placeholder="" required><br/>
	<label for="estado">Estado nuevo: </label>
	<input type="text" id="estado" name="estado" placeholder="" required><br/>	
	<input type="submit" value="Submit">
</form>
</body>
</html>
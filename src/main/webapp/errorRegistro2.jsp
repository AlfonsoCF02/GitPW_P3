<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<%@ page import="java.io.StringWriter" %>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ERROR!!</title>
</head>
<body>
La fecha debe ser que el usuario sea mayor de edad
<br/>
<a href="${pageContext.request.contextPath}/index.jsp">Volver al inicio</a>
</body>
</html>
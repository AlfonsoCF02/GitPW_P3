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

Los datos del usuario son incorrectos, vuelva a intentarlo!
Le recordamos que no debe introducir espacios o sera erroneo el acceso!
<a href="${pageContext.request.contextPath}/index.jsp">Volver al inicio</a>
</body>
</html>
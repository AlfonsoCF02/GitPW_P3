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
Esta intentando asociar a una pista adulta un kart infantil o bien a una pista infantil un kart adulto<br/>
kart adulto->pista adulta<br/>
kart infantil->pista infantil<br/>
Vuelva a intentarlo<br/>
<br/>
<a href="${pageContext.request.contextPath}/index.jsp">Volver al inicio</a>
</body>
</html>
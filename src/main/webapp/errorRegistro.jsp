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

El usuario ya esta registrado
<% String nextPage="../../index.jsp";%>

<jsp:forward page="<%=nextPage%>">
</jsp:forward>
</body>
</html>
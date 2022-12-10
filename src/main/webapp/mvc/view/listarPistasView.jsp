<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<jsp:useBean  id="customerBean" scope="session" class="display.javabean.CustomerBean"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar Pistas</title>
</head>
<body>
<%

	ArrayList<String> datos = (ArrayList<String>) request.getAttribute("listado");
	int i=0;
	while(i<datos.size()){
		String info=datos.get(i);
	    %>
		<%=info %><br/><br/>
		<%
		i++;
	}
%>
<a href="./index.jsp">Inicio</a>
</body>
</html>
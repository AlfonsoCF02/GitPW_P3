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
<title>Eliminar reserva</title>
</head>
<body>
<%
if (customerBean != null && !customerBean.getEmail().equals("") && (customerBean.getPrivilegios().toString().equals("user"))) {%>
	<form method="post" action="${pageContext.request.contextPath}/eliminareservauser">
	<label for="reserva">reserva: </label>
	<input type="text" id="reserva" name="reserva" placeholder="" required><br/>	
	<input type="hidden" name="email" value=<%=customerBean.getEmail()%>>
	<input type="submit" value="Submit">
</form><%
} else{%>
	Debe registrarse para acceder a la funcionalidad y ser administrador
	<a href="${pageContext.request.contextPath}/index.jsp">volver al indice</a><br/><%
}
%>
</body>
</html>
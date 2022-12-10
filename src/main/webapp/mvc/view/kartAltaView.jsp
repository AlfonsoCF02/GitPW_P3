<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean  id="customerBean" scope="session" class="display.javabean.CustomerBean"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<script src = "../../js/checkFormularioKart.js"></script>
<meta charset="UTF-8">
<title>Alta Kart</title>
</head>
<body>
<%
if (customerBean != null && !customerBean.getEmail().equals("") && (customerBean.getPrivilegios().toString().equals("admin"))) {%>
	<form id="formkart" method="post" action="${pageContext.request.contextPath}/kartpista" onSubmit="return Validar('tipo','estado')">
	<label for="tipo">Tipo: </label>
	<input type="text" id="tipo" name="tipo" placeholder="Enter type false/true" required><br/>
	<label for="estado">Estado: </label>
	<input type="text" id="estado"name="estado" placeholder="disponible/reservado/mantenimiento" required><br/>	
	<br/>
	<input type="submit" value="Submit">
</form><%
} else{%>
	Debe registrarse para acceder a la funcionalidad y ser administrador
	<a href="${pageContext.request.contextPath}/index.jsp">volver al indice</a><br/><%
}
%>
</body>
</html>
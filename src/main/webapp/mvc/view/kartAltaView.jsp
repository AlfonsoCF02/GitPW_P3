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
/* Posibles flujos:
	1) customerBean está logado (!= null && != "") -> Se redirige al index.jsp (no debería estar aquí pero hay que comprobarlo)
	2) customerBean no está logado:
		a) Hay parámetros en el request  -> procede del controlador /con mensaje 
		b) No hay parámetros en el request -> procede del controlador /sin mensaje
	*/
String nextPage = "../../index.jsp";
String messageNextPage = request.getParameter("message");
%>
<form id="formkart" method="post" action="${pageContext.request.contextPath}/kartpista" onSubmit="return Validar('tipo','estado')">
	<label for="tipo">Tipo: </label>
	<input type="text" id="tipo" name="tipo" placeholder="Enter type false/true" required><br/>
	<label for="estado">Estado: </label>
	<input type="text" id="estado"name="estado" placeholder="disponible/reservado/mantenimiento" required><br/>	
	<br/>
	<input type="submit" value="Submit">
</form>
</body>
</html>
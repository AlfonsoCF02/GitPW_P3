<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean  id="customerBean" scope="session" class="display.javabean.CustomerBean"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alta pista</title>
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
if (customerBean != null && !customerBean.getEmail().equals("") && (customerBean.getPrivilegios().toString().equals("admin"))) {%>
	<form id="formpista" method="post" action="${pageContext.request.contextPath}/pistaAlta">
	<label for="nombre">Nombre: </label>
	<input type="text" id="nombre" name="nombre" placeholder="Enter name" required><br/>
	<label for="disponible">Disponible: </label>
	<input type="text" id="disponible" name="disponible" placeholder="Enter true/false" required><br/>	
	<label for="maxkarts">MaxKarts: </label>
	<input type="text" id="maxkarts" name="maxkarts" placeholder="Enter max karts for truck" required><br/>	
	<label for="dificultad">Dificultad: </label>
	<input type="text" id="dificultad" name="dificultad" placeholder="child,family,adult" required><br/>
	<br/>
	<input type="submit" value="Submit">
</form>	<%
} else{%>
	Debe registrarse para acceder a la funcionalidad y ser administrador
	<a href="${pageContext.request.contextPath}/index.jsp">volver al indice</a><br/><%
}
%>
</body>
</html>
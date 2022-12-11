<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean  id="customerBean" scope="session" class="display.javabean.CustomerBean"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reserva Concreta</title>
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
if (customerBean != null && !customerBean.getEmail().equals("") && (customerBean.getPrivilegios().toString().equals("user"))) {%>
<form id="formlist" method="post" action="${pageContext.request.contextPath}/listarConcreta">
	<label for="fech1">Fecha primera: </label>
	<input type="Date" name="fech1" placeholder="Enter first date" required><br/>
	<label for="fech2">Fecha segunda: </label>
	<input type="Date" name="fech2" placeholder="Enter second date" required><br/>
	<input type="hidden" name="email" value=<%=customerBean.getEmail()%>>
	<input type="submit" value="Submit">
</form>	<%
} else{%>
	Debe registrarse para acceder a la funcionalidad y ser usuario-cliente
	<a href="${pageContext.request.contextPath}/index.jsp">volver al indice</a><br/><%
}
%>
</body>
</html>
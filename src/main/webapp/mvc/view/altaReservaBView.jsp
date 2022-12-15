<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean  id="customerBean" scope="session" class="display.javabean.CustomerBean"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nueva Reserva Bono</title>
</head>
<body>
<%

String nextPage = "../../index.jsp";
String messageNextPage = request.getParameter("message");
if (customerBean != null && !customerBean.getEmail().equals("") && (customerBean.getPrivilegios().toString().equals("user"))) {%>
	<form id="formReservaInd" method="post" action="${pageContext.request.contextPath}/altareservab">
	<input type="hidden" name="email" value=<%=customerBean.getEmail()%>>
	<label for="duracion">Duracion: </label>
	<input type="number" id="duracion"name="duracion" placeholder="60/90/120" required>
	<%--<select id="myDropdown">
	    <option value="60">60</option>
	    <option value="90">90</option>
	    <option value="120">120</option>
  	</select>--%>
  	<label for="pista">Pista: </label>
	<input type="text" id="pista"name="pista" required>
	<label for="NumBono">NumBono: </label>
	<input type="number" id="nbono" name="nbono" required>
	<label for="nadultos">Adultos: </label>
	<input type="number" id="nadultos" name="nadultos" required>
	<label for="nninios">Niños: </label>
	<input type="number" id="nninios" name="nninios" required>
	<label for="fecha">Fecha: </label>
	<input type="Date" id="fecha" name="fecha" required>
	<label for="Hora">Hora: </label>
	<input type="time" id="hora" name="hora" required>
	<br/>
	<input type="submit" value="Submit">
</form>	<%
} else{%>
	Debe registrarse para acceder a la funcionalidad y ser usuario-cliente
	<a href="${pageContext.request.contextPath}/index.jsp">volver al indice</a><br/><%
}
%>
</body>
</html>
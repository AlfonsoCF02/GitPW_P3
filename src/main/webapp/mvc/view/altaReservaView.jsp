<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<jsp:useBean  id="customerBean" scope="session" class="display.javabean.CustomerBean"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nueva Reserva</title>
</head>
<body>
<%

if (customerBean != null && !customerBean.getEmail().equals("") && (customerBean.getPrivilegios().toString().equals("user"))) {%>
	<form id="formReservaInd" method="post" action="${pageContext.request.contextPath}/altareserva">
	<input type="hidden" name="email" value=<%=customerBean.getEmail()%>>
	<label for="duracion">
		<span>Duración</span>
	</label>
	<select id="duracion" name="duracion">
		<option value="60">60</option>
		<option value="90">90</option>
		<option value="120">120</option>
	</select>
	<label for="nombrePista">
		<span>Pistas</span>
	</label>
	<select id="nombrePista" name="nombrePista">
		<%
		ArrayList<String> pistas = (ArrayList<String>) request.getAttribute("pistas");
		for(int i=0; i<pistas.size(); i++){
			String pista = pistas.get(i);
			String[] parts1 = pista.split(",");
			String parts2[] = parts1[0].split(" ");
			String nombrePista = parts2[1];
			%>
			<option value="<%=nombrePista%>"><%=pista%></option>
		<%} %>
	</select>
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
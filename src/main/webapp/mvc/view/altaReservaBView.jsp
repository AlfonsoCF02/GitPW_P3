<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="business.usuario.*" %>
<jsp:useBean  id="customerBean" scope="session" class="display.javabean.CustomerBean"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Nueva Reserva Bono</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/estilos.css">
</head>
<body>
	<header>
		<nav class="nav">
			<ul>
				<li id="nav_fecha" class="nav_li"><%
				java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat ("dd/MM/yyyy");
				 java.util.Date currentTime = new java.util.Date (); // Obtener la hora actual del sistema
				 String str_date1 = formatter.format (currentTime); // format datetime
				 String str_date2 = str_date1.toString (); // Convertir fecha y hora en forma de cadena
				%>
                <%=str_date2 %></li>
				<li id="nav_nombre"class="nav_li"><a href="<%=request.getContextPath()%>/index.jsp"><b>CORDOBA KARTING</b></a></li>
				<%
				if (customerBean == null || customerBean.getEmail()=="") {
				%>
				<li id="nav_sesion" class="nav_li"><a href="<%=request.getContextPath()%>/mvc/controller/loginController.jsp">Iniciar Sesion</a></li>
				<li id="nav_sesion" class="nav_li"><a href="<%=request.getContextPath()%>/mvc/controller/registroController.jsp">Registrarse</a></li>
				<% 
				} else { %>
				<%if(customerBean.getPrivilegios().toString().equals(typeof.user.toString())){%>
				<li id="menu" class="nav_li">MENU
					<ul>
						<li id="nav_sesion" class="nav_li"><a href="${pageContext.request.contextPath}/listarConcreta">Listar reservas concretas</a><br/></li>
				        <li id="nav_sesion" class="nav_li"><a href="${pageContext.request.contextPath}/pistasdisponibles">Pistas disponibles</a></li>
				        <li id="nav_sesion" class="nav_li"><a href="${pageContext.request.contextPath}/altabono">Alta bono</a></li>
				        <li id="nav_sesion" class="nav_li"><a href="${pageContext.request.contextPath}/altareserva">Añadir reserva</a></li>
				        <li id="nav_sesion" class="nav_li"><a href="${pageContext.request.contextPath}/altareservab">Añadir reserva Bono</a></li>
				        <li id="nav_sesion" class="nav_li"><a href="${pageContext.request.contextPath}/eliminarreservauser">Eliminar reserva</a></li>
						<li id="nav_sesion" class="nav_li"><a href="${pageContext.request.contextPath}/modificarreserva">Modificar Reserva Individual</a></li>
				        <li id="nav_sesion" class="nav_li"><a href="${pageContext.request.contextPath}/modificarreservab">Modificar Reserva Bono</a></li>
				        <li id="nav_sesion" class="nav_li"><a href="${pageContext.request.contextPath}/listarbono">Listar bono</a></li>
					</ul>
				</li>
				<li id="profile" class="nav_li"><img class=profile_image src="<%=request.getContextPath()%>/images/profile_icon.ico">
					<ul>
				<li id="nav_sesion" class="nav_li"><a href="<%=request.getContextPath()%>/mvc/controller/logoutController.jsp">Desconectar</a></li>
				<li id="nav_sesion" class="nav_li"><a href="<%=request.getContextPath()%>/mvc/view/modifyView.jsp">Modificar datos</a></li>
					</ul>
				</li>				
				<%}else{%>
				<li id="menu" class="nav_li">MENU
					<ul>
						<li class="nav_li"><a href="<%=request.getContextPath()%>/mvc/view/kartAltaView.jsp">Alta kart</a>
						<li class="nav_li"><a href="${pageContext.request.contextPath}/kartListar">Listar karts</a>
						<li class="nav_li"><a href="${pageContext.request.contextPath}/pistaAlta">Crear pista</a>
						<li class="nav_li"><a href="${pageContext.request.contextPath}/pistaListar">Listar pistas</a>
						<li class="nav_li"><a href="${pageContext.request.contextPath}/kartpista">Asociar kart-pista</a>
						<li class="nav_li"><a href="${pageContext.request.contextPath}/kartstate">Modificar estado kart</a>
						<li class="nav_li"><a href="${pageContext.request.contextPath}/pistastate">Modificar estado pista</a>
						<li class="nav_li"><a href="${pageContext.request.contextPath}/reservalistar">Listar reservas</a>
						<li class="nav_li"><a href="${pageContext.request.contextPath}/eliminareserva">Eliminar reserva</a>
					</ul>
				</li>
				<li id="profile" class="nav_li"><img class=profile_image src="<%=request.getContextPath()%>/images/profile_icon.ico">
					<ul>
				<li id="nav_sesion" class="nav_li"><a href="<%=request.getContextPath()%>/mvc/controller/logoutController.jsp">Desconectar</a></li>
				<li id="nav_sesion" class="nav_li"><a href="<%=request.getContextPath()%>/mvc/view/modifyView.jsp">Modificar datos</a></li>
					</ul>
				</li>							
				<%}} %>
			</ul>
		</nav>
	</header>

<%

if (customerBean != null && !customerBean.getEmail().equals("") && (customerBean.getPrivilegios().toString().equals("user"))) {%>
	<div id=div_form_altaResB>
		<form id="formReservaInd" method="post" action="${pageContext.request.contextPath}/altareservab">
			<input type="hidden" name="email" value=<%=customerBean.getEmail()%>>
			<label for="duracion">
				<span>Duración</span>
			</label>
			<select id="duracion" name="duracion">
				<option value="60">60</option>
				<option value="90">90</option>
				<option value="120">120</option>
			</select><br>
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
			</select><br>
			<label for="nbono">Nº Bono: </label>
			<input type="number" id="nbono" name="nbono" required><br>	
			<label for="nadultos">Adultos: </label>
			<input type="number" id="nadultos" name="nadultos" required><br>
			<label for="nninios">Niños: </label>
			<input type="number" id="nninios" name="nninios" required><br>
			<label for="fecha">Fecha: </label>
			<input type="Date" id="fecha" name="fecha" required><br>
			<label for="Hora">Hora: </label>
			<input type="time" id="hora" name="hora" required><br>
			<br/>
			<input type="submit" value="Reservar"><br>
		</form>
	</div>	
<%} else{%>
	Debe registrarse para acceder a la funcionalidad y ser usuario-cliente
	<a href="${pageContext.request.contextPath}/index.jsp">volver al indice</a><br/><%
}
%>

<footer>
	<%if (customerBean == null || customerBean.getEmail()=="") {%>
		<div class=footer_fisrt>
			<a href="<%=request.getContextPath()%>/mvc/controller/loginController.jsp">Iniciar Sesion</a>
			<a href="<%=request.getContextPath()%>/mvc/controller/registroController.jsp">Registrarse</a>
		</div>
	<%}else if(customerBean.getPrivilegios().toString().equals(typeof.user.toString())) {%>
		<div class=footer_user>
			<a href="${pageContext.request.contextPath}/listarConcreta">Listar reservas concretas</a><br/>
	        <a href="${pageContext.request.contextPath}/pistasdisponibles">Pistas disponibles</a><br/>
	        <a href="${pageContext.request.contextPath}/listarbono">Listar bono</a><br>
		</div>
		<div class=footer_user>
	        <a href="${pageContext.request.contextPath}/altabono">Alta bono</a><br/>
	        <a href="${pageContext.request.contextPath}/altareservab">Añadir reserva Bono</a><br/>
	        <a href="${pageContext.request.contextPath}/modificarreservab">Modificar Reserva Bono</a><br>	        			
		</div>
		<div class=footer_user>
	        <a href="${pageContext.request.contextPath}/altareserva">Añadir reserva</a><br/>
	        <a href="${pageContext.request.contextPath}/modificarreserva">Modificar Reserva Individual</a><br>
	        <a href="${pageContext.request.contextPath}/eliminarreservauser">Eliminar reserva</a><br/>		
		</div>
			        
		<% }else if(customerBean.getPrivilegios().toString().equals(typeof.admin.toString())){%>
		<div class=footer_admin>
			<a href="<%=request.getContextPath()%>/mvc/view/kartAltaView.jsp">Alta kart</a><br/>
			<a href="${pageContext.request.contextPath}/kartListar">Listar karts</a><br/>
		</div>
		<div class=footer_admin>
			<a href="${pageContext.request.contextPath}/pistaAlta">Crear pista</a><br/>
			<a href="${pageContext.request.contextPath}/pistaListar">Listar pistas</a><br/>
		</div>
		<div class=footer_admin>
			<a href="${pageContext.request.contextPath}/kartpista">Asociar kart-pista</a><br/>
		</div>
		<div class=footer_admin>
			<a href="${pageContext.request.contextPath}/kartstate">Modificar estado kart</a><br/>
			<a href="${pageContext.request.contextPath}/pistastate">Modificar estado pista</a><br/>
		</div>
		<div class=footer_admin>
			<a href="${pageContext.request.contextPath}/reservalistar">Listar reservas</a><br/>		
			<a href="${pageContext.request.contextPath}/eliminareserva">Eliminar reserva</a><br/>
		</div>
	<%}%>
	</footer>
</body>
</html>
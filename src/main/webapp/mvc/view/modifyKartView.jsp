<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="business.pista.*" %>
<%@ page import="business.usuario.*" %>
<%@ page import="data.*" %>

<jsp:useBean  id="customerBean" scope="session" class="display.javabean.CustomerBean"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Modificar Kart</title>
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
if (customerBean != null && !customerBean.getEmail().equals("") && (customerBean.getPrivilegios().toString().equals("admin"))) {%>
	<div id=div_form_modificarKart>	
		<form method="post" action="${pageContext.request.contextPath}/kartstate">
				<label for="kart">
					<span>Kart</span>
				</label>
				<select id="kart" name="kart">
					<%
					ArrayList<String> karts = (ArrayList<String>) request.getAttribute("karts");
					for(int i=0; i<karts.size(); i++){
						String kart = karts.get(i);
						String[] parts1 = kart.split(",");
						String parts2[] = parts1[0].split(" ");
						String numeroKart = parts2[1];
						%>
						<option value="<%=numeroKart%>"><%=kart%></option>
					<%} %>
				</select>
				<label for="estado">
					<span>Estado</span>
				</label>
				<select id="estado" name="estado">
					<option value="disponible">disponible</option>
					<option value="reservado">reservado</option>
					<option value="mantenimiento">mantenimiento</option>
				</select><br><br>	
			<input type="submit" value="Modificar">
		</form>
	</div>
		<%
} else{%>
	Debe registrarse para acceder a la funcionalidad y ser administrador
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="display.javabean.CustomerBean" %>
<%@ page import="business.usuario.*" %>
<%@ page import="data.*" %>
<%@ page import="java.util.ArrayList" %>

<jsp:useBean  id="customerBean" scope="session" class="display.javabean.CustomerBean"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Cordoba Karting</title>
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
	if (customerBean == null || customerBean.getEmail()=="") {%>
	<div id=noRegistrado>
		Para el acceso a las funcionalidades de nuestro sitio web debe Iniciar Sesión o Registrarse(si es la primera vez que accede al sitio).
	</div>
	<%} 
	else if(customerBean.getPrivilegios().toString().equals(typeof.user.toString())) {
		java.util.Date fecha = customerBean.getprimres();
		String fecha1 = formatter.format (currentTime);
		String fecha2 = fecha1.toString();
		ReservaChildDAO rcd=new ReservaChildDAO();
		String fechproxres=rcd.obtenerProxReserva(customerBean.getEmail());
		if(fechproxres.length()<7){
			fechproxres="No tiene reserva futura";
		}%>
		<div id=bienvenida>
			Bienvenido | <jsp:getProperty name="customerBean" property="email"/> | <%=str_date2 %> | Miembro desde <%=fecha2%> | Proxima reserva: <%=fechproxres%><br/>
       	</div>
	<% }
	else if(customerBean.getPrivilegios().toString().equals(typeof.admin.toString())){
		ArrayList<CustomerBean> users=new ArrayList<CustomerBean>();
		users=customerBean.users();
		int i=0;
		String usermail="";
		String fech="";
		String nres="";
		%>

	<div id=div_table_index>
		<table class="table_1">
		  <tr>
		    <th>Email</th>
		    <th>Fecha 1º Res</th>
		    <th>Nº Reservas</th>
		  </tr>
		  <%while(i<users.size()){%>
		  <tr>
		  	<%usermail=users.get(i).getEmail();%>
		    <td><%=usermail%></td>
		  	<%fech=users.get(i).getprimres().toString();%>
		    <td><%=fech%></td>	
		  	<%nres=users.get(i).getNres();%>
		    <td><%=nres%></td>		    	    
		  </tr>
		  <%i++;} %>
		</table>				
	<%}%>
	</div>

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
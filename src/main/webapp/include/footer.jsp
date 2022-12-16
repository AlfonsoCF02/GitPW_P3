<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="display.javabean.CustomerBean" %>
<%@ page import="business.usuario.*" %>
<%@ page import="data.*" %>
<%@ page import="java.util.ArrayList" %>

<jsp:useBean  id="customerBean" scope="session" class="display.javabean.CustomerBean"></jsp:useBean>

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
		</div>
		<div class=footer_user>
	        <a href="${pageContext.request.contextPath}/altabono">Alta bono</a><br/>
	        <a href="${pageContext.request.contextPath}/altareservab">Añadir reserva Bono</a><br/>	        			
		</div>
		<div class=footer_user>
	        <a href="${pageContext.request.contextPath}/altareserva">Añadir reserva</a><br/>
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
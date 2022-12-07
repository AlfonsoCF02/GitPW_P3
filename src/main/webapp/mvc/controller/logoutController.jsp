<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="business.usuario.UsuarioDTO,data.UserDAO" %>
<%@ page import ="java.util.Date" %>
<%@ page import ="business.usuario.typeof" %>
<%@page errorPage="../../errorLogin.jsp" %>
<jsp:useBean  id="customerBean" scope="session" class="display.javabean.CustomerBean"></jsp:useBean>
<%
request.getSession().removeAttribute("customerBean");
%>
<jsp:forward page="../../index.jsp">
	<jsp:param value="Sesion Cerrada exitosamente" name="message"/>
</jsp:forward>
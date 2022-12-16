<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="display.javabean.CustomerBean" %>
<%@ page import="business.usuario.*" %>
<%@ page import="data.*" %>
<%@ page import="java.util.ArrayList" %>

<jsp:useBean  id="customerBean" scope="session" class="display.javabean.CustomerBean"></jsp:useBean>

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
			<li id="menu" class="nav_li">MENU
				<ul>
					<li id="nav_sesion" class="nav_li"><a href="<%=request.getContextPath()%>/mvc/controller/loginController.jsp">Iniciar Sesion</a></li>
					<li id="nav_sesion" class="nav_li"><a href="<%=request.getContextPath()%>/mvc/controller/registroController.jsp">Registrarse</a></li>
				</ul>
			</li>
			<% 
			} else { %>
			<li id="nav_sesion" class="nav_li"><%String nombre=customerBean.getNombre().toString();%><%=nombre%></li>
			<li id="nav_sesion" class="nav_li"><a href="<%=request.getContextPath()%>/mvc/controller/logoutController.jsp">Desconectar</a></li>
			<li id="nav_sesion" class="nav_li"><a href="<%=request.getContextPath()%>/mvc/view/modifyView.jsp">Modificar datos</a></li>
			<%if(customerBean.getPrivilegios().toString().equals(typeof.user.toString())){//user
				
				}else{//admin
				}				
			} %>
		</ul>
	</nav>
</header>
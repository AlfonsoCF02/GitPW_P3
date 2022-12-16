<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<jsp:useBean  id="customerBean" scope="session" class="display.javabean.CustomerBean"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar bonos</title>
</head>
<body>
<%
if (customerBean != null && !customerBean.getEmail().equals("") && (customerBean.getPrivilegios().toString().equals("user"))) {

	ArrayList<String> datos = (ArrayList<String>) request.getAttribute("listado");
	int i=0;
	if(datos.isEmpty()){%>
		<%="Lo sentimos deseado cliente, usted no tiene bonos"%><br/>
	<%}else{
		while(i<datos.size()){
			String info=datos.get(i);
		    %>
			<%=info %><br/><br/>
			<%
			i++;
		}
	}
%>
<a href="./index.jsp">Inicio</a><%
} else{%>
	Debe registrarse para acceder a la funcionalidad y ser usuario-cliente
	<a href="${pageContext.request.contextPath}/index.jsp">volver al indice</a><br/><%
}
%>
</body>
</html>
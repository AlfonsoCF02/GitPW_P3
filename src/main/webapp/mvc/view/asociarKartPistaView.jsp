<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="business.pista.*" %>
<%@ page import="data.*" %>

<jsp:useBean  id="customerBean" scope="session" class="display.javabean.CustomerBean"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log in</title>
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
ArrayList<String> karts=new ArrayList<String>();
ArrayList<String> pistas=new ArrayList<String>();
GestorPistas g=new GestorPistas();
KartDAO kd=new KartDAO();
karts=kd.listarKarts();
pistas=g.listarPistas();
int val;
int j;
boolean continuar=true;
String fin="";
%>
<form id="formkart" method="post" action="${pageContext.request.contextPath}/kartAlta">
	<label for="tipo">Kart: </label>
	<select name="karts">
	<%for(int i=1;i<karts.size();i++){%>
    <option value=<%=i%>><%=i%></option>
    <%} %>
      </select><br/>
	<label for="pista">Pista: </label>
	<select name="pistas">
	<%for(int i=0;i<pistas.size();i++){
		String pista=pistas.get(i);
		%>
		<option value=<%=pista.substring(7,pista.indexOf(','))%>><%=pista.substring(7,pista.indexOf(','))%></option>
		<%
	 } %>
      </select><br/>	
	<br/>
	<input type="submit" value="Submit">
</form>
</body>
</html>
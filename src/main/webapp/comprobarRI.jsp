<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<%@ page import="java.io.StringWriter" %>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>INFO RESERVA!!</title>
</head>
<body>

<%int res = (int)request.getAttribute("res");

if(res == 0) {
	out.write("Reserva realizada correctamente\n");
}
else if( res == -1 ) {
	out.write("Error, el usuario introducido no existe\n");
}
else if( res == -6 ) {
	out.write("Error, la pista solicitada no esta disponible\n");
}
else if( res == -7 ) {
	out.write("Error, el numero de participantes introducido no es valido para la pista que quiere reservar\n");
}
else if ( res == -9 ){
	out.write("Error, el numero de participantes introducido no es valido para la pista que quiere reservar\n");
}
else {
	out.write("Error, la reserva no se ha podido realizar, introduzca datos validos\n");
}

%>

<a href="${pageContext.request.contextPath}/index.jsp">Volver al inicio</a>
</body>
</html>
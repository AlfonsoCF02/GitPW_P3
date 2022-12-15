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
		out.write("Reserva modificada correctamente\n");
	}
	else if( res == -1 ) {
		out.write("Error, el usuario introducido no existe\n");
	}
	else if( res == -2 ) {
		out.write("Error, el bono introducido no existe\n");
	}
	else if( res == -3 ) {
		out.write("Error, usted no es el dueño del bono que quiere usar\n");
	}
	else if( res == -4 ) {
		out.write("Error, el bono no es del tipo que de la reserva que quiere realizar\n");
	}
	else if( res == -6 ) {
		out.write("Error, la pista solicitada no esta disponible\n");
	}
	else if( res == -7 ) {
		out.write("Error, el tipo de pista y el tipo de bono no son compatibles\n");
	}
	else if ( res == -9 ){
		out.write("Error, el numero de participantes introducido no compatible con el tipo de pista que quiere reservar\n");
	}
	else {
		out.write("Error, la modificacion reserva no se ha podido realizar, introduzca datos validos\n");
	}

%>

<a href="${pageContext.request.contextPath}/index.jsp">Volver al inicio</a>
</body>
</html>
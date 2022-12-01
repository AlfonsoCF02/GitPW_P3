<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ERROR!!</title>
</head>
<body>
If you are watching this, then it is because an error happened!
<%String cad=exception.printStackTrace(response.getWriter());
String cad2="java.lang.NullPointerException";%>
<%if(cad.contains(cad2)){%>
Los datos del usuario son incorrectos, vuelva a intentarlo!
<%} %>
</body>
</html
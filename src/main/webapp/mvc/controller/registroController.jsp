<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="business.usuario.UsuarioDTO,data.UserDAO" %>
<%@ page import ="java.util.Date" %>
<%@ page import ="business.usuario.typeof" %>
<%@ page import ="business.usuario.*" %>
<%@ page import ="java.text.SimpleDateFormat" %>
<%@ page import ="java.util.Calendar"%>

<jsp:useBean  id="customerBean" scope="session" class="display.javabean.CustomerBean"></jsp:useBean>
<%

String nextPage = "../../index.jsp";
String mensajeNextPage = "";
String mensajeError="";
//Caso 2
if (customerBean == null || customerBean.getEmail().equals("")) {
	String emailUser = request.getParameter("email");
	String passwordUser = request.getParameter("password");
	String nomUser = request.getParameter("nombre");
	String apellidosUser = request.getParameter("apellidos");
	String fechUser = request.getParameter("fecha");
	String privilegios=request.getParameter("privilegios");
	typeof priv=null;

	
	if(privilegios!=null){
		if(privilegios.equals(typeof.admin.toString())){
			priv=typeof.admin;
		}else{
			priv=typeof.user;
		}
	}
	Date birth = new Date();
	Date now=new Date();
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	if (emailUser != null) {
		GestorUsuario g=new GestorUsuario();
		Date firstB=new Date();
		if(fechUser!=null){
			birth = format.parse(fechUser);	 		
		}
			if(g.comprobarUsuarioExistente(emailUser)==true){			
					nextPage = "../../errorRegistro.jsp";
					mensajeNextPage = "El usuario esta registrado";	
			}else if((now.getYear()-birth.getYear())<18){
				nextPage = "../../errorRegistro2.jsp";
			}else{
				%>
				<jsp:setProperty  name="customerBean" property="email" value="<%=emailUser%>"/>
				<jsp:setProperty  name="customerBean" property="password" value="<%=passwordUser%>"/>
				<jsp:setProperty  name="customerBean" property="privilegios" value="<%=priv%>"/>
				<jsp:setProperty  name="customerBean" property="nombre" value="<%=nomUser%>"/>
				<jsp:setProperty  name="customerBean" property="apellidos" value="<%=apellidosUser%>"/>
				<jsp:setProperty  name="customerBean" property="fechN" value="<%=birth%>"/>
				<%		
				g.altaUsuario(nomUser, apellidosUser, emailUser, birth, firstB, priv, passwordUser);
				nextPage = "../../index.jsp";
				mensajeNextPage = "El usuario se ha registrado correctamente";
			}
	//Caso 2.b -> se debe ir a la vista por primera vez
} else {
	nextPage = "../view/registroView.jsp";		
}
	//Caso 2.a: Hay parámetros -> procede de la VISTA
	
}
%>
<jsp:forward page="<%=nextPage%>">
	<jsp:param value="<%=mensajeNextPage%>" name="message"/>
</jsp:forward>
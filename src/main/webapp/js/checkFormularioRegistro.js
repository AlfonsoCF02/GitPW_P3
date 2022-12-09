function Validar()
  {
   email=document.getElementById(email);
   password=document.getElementById(password);
   nombre=document.getElementById(nombre);
   apellidos=document.getElementById(apellidos);
   fechanacimiento=document.getElementById(fechanacimiento);
   var espacios = false;
   var cont = 0;
	while (!espacios && (cont < password.length)) {
	 if (password.charAt(cont) == " ")
	    espacios = true;
	  cont++;
	}
	
   if(email.length<6)
    {
     alert("email muy corto");
     email.focus();
     return false;
    }
   else if(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email.value)){
	 alert("formato email invalido");
     email.focus();
     return false;
   }else
    {
     if(password.length<6)
      {
       alert("contrasenia corta");
       password.focus();
       return false;
      }
     else if(espacios) {
	  alert ("La contraseña no puede contener espacios en blanco");
	  password.focus();
	  return false;
     }else
      {
       return true;
      }
    }
    return false;
  }
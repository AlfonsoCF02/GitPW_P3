function Validar(tipo,estado)
  {
   tipo=document.getElementById(tipo);
   estado=document.getElementById(estado);
   if(tipo.value!="false" && tipo.value!="true")
    {
     alert("se debe introducir true/false");
     tipo.focus();
     return false;
    }
   else
    {
     if(estado.value!="reservado" && estado.value!="disponible" && estado.value!="mantenimiento")
      {
       alert("se debe introducir reservado/disponible/mantenimiento");
       estado.focus();
       return false;
      }
     else
      {
	   alert("Kart introducido correctamente")
       return true;
      }
    }
  }
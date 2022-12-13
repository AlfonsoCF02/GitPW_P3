function ValidarAnio(fechN)
  {
   var hoy = new Date();
    var cumpleanos = new Date(fechN);
    var edad = hoy.getFullYear() - cumpleanos.getFullYear();
    var m = hoy.getMonth() - cumpleanos.getMonth();
    if (m < 0 || (m === 0 && hoy.getDate() < cumpleanos.getDate())) {
        edad--;
    }
    if(edad >= 18){
   		alert("Eres mayor de edad :D ");
   		return true;
	}else{
	    alert("Eres menor de edad :( ");
	    return false;
	}
}


  
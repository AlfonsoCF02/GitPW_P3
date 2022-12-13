function ValidarAnio(fechN)
  {
    alert("validando fecha ");
    var hoy = new Date();
    fechN=document.getElementById(fechN);
    var cumpleanos = new Date(fechN);
    var edad = hoy.getFullYear() - cumpleanos.getFullYear();
    var m = hoy.getMonth() - cumpleanos.getMonth();
    if (m < 0 || (m === 0 && hoy.getDate() < cumpleanos.getDate())) {
        edad--;
    }
    alert("validando fecha ");
    if(edad >= 18){
   		return true;
	}else{
		alert("Eres menor de edad :( ");
	    return false;
	}
}


  
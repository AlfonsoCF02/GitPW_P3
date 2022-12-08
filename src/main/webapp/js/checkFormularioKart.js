document.addEventListener("DOMContentLoaded", function() {
  document.getElementById("formkart").addEventListener('submit', validarFormulario); 
});

function validarFormulario(evento) {
  evento.preventDefault();
  var tipo = document.getElementById('tipo').value;
  if(tipo != 'mantenimiento' && tipo != 'reservado' && tipo != 'disponible') {
    alert('no es valido el tipo introducido');
    return;
  }
  var estado = document.getElementById('estado').value;
  if (estado != true && estado != false) {
    alert('estado no valido');
    return;
  }
  this.submit();
}
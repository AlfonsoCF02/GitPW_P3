document.addEventListener("DOMContentLoaded", function() {
  document.getElementById("formkart").addEventListener('submit', validarFormulario); 
});

function validarFormulario(evento) {
  evento.preventDefault();
  var tipo = document.getElementById('tipo').value;
  if(usuario.length == 0) {
    alert('No has escrito nada en el usuario');
    return;
  }
  var clave = document.getElementById('clave').value;
  if (clave.length < 6) {
    alert('La clave no es válida');
    return;
  }
  this.submit();
}
$(document).ready(function() {
	pintarFondoFilas();
});

function pintarFondoFilas() {
	$('tbody tr:even').css('background-color','#dddddd');
    $('tbody tr:odd').css('background-color','#ECEECD');
}

function eliminarFilaTabla(id) {
	var tr = document.getElementById(id);
    var elements = document.getElementsByTagName("tbody");
    elements[0].removeChild(tr);
}










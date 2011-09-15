$(document).ready(function() {
	$('tbody tr:even').css('background-color','#dddddd');
});

function verArticulo(idArticulo) {
    var form = document.createElement("form");
    form.setAttribute("method", "post");
    form.setAttribute("action", "verArticulo.htm");

    var hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "idArticulo");
    hiddenField.setAttribute("value", idArticulo);

    form.appendChild(hiddenField);

    document.body.appendChild(form);
    form.submit();
}

function borrarArticulo(event, idArticulo) {
	event.stopPropagation();
	
	if(confirm("¿Desea realmente borrar este artículo?")) {	
	    var form = document.createElement("form");
	    form.setAttribute("method", "post");
	    form.setAttribute("action", "borrarArticulo.htm");
	
	    var hiddenField = document.createElement("input");
	    hiddenField.setAttribute("type", "hidden");
	    hiddenField.setAttribute("name", "idArticulo");
	    hiddenField.setAttribute("value", idArticulo);
	
	    form.appendChild(hiddenField);
	
	    document.body.appendChild(form);
	    form.submit();
	}
}

function verCategoria(idCategoria) {
    var form = document.createElement("form");
    form.setAttribute("method", "post");
    form.setAttribute("action", "verCategoria.htm");

    var hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "idCategoria");
    hiddenField.setAttribute("value", idCategoria);

    form.appendChild(hiddenField);

    document.body.appendChild(form);
    form.submit();
}

function borrarCategoria(event, idCategoria) {
	event.stopPropagation();
	
	if(confirm("¿Desea realmente borrar esta categoria?")) {	
	    var form = document.createElement("form");
	    form.setAttribute("method", "post");
	    form.setAttribute("action", "borrarCategoria.htm");
	
	    var hiddenField = document.createElement("input");
	    hiddenField.setAttribute("type", "hidden");
	    hiddenField.setAttribute("name", "idCategoria");
	    hiddenField.setAttribute("value", idCategoria);
	
	    form.appendChild(hiddenField);
	
	    document.body.appendChild(form);
	    form.submit();
	}
}

function verNumero(idNumero) {
    var form = document.createElement("form");
    form.setAttribute("method", "post");
    form.setAttribute("action", "verNumero.htm");

    var hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "idNumero");
    hiddenField.setAttribute("value", idNumero);

    form.appendChild(hiddenField);

    document.body.appendChild(form);
    form.submit();
}

function borrarNumero(event, idNumero) {
	event.stopPropagation();
	
	if(confirm("¿Desea realmente borrar este número?")) {	
	    var form = document.createElement("form");
	    form.setAttribute("method", "post");
	    form.setAttribute("action", "borrarNumero.htm");
	
	    var hiddenField = document.createElement("input");
	    hiddenField.setAttribute("type", "hidden");
	    hiddenField.setAttribute("name", "idNumero");
	    hiddenField.setAttribute("value", idNumero);
	
	    form.appendChild(hiddenField);
	
	    document.body.appendChild(form);
	    form.submit();
	}
}

function verRevista(idRevista) {
    var form = document.createElement("form");
    form.setAttribute("method", "post");
    form.setAttribute("action", "verRevista.htm");

    var hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "idRevista");
    hiddenField.setAttribute("value", idRevista);

    form.appendChild(hiddenField);

    document.body.appendChild(form);
    form.submit();
}

function borrarRevista(event, idRevista) {
	event.stopPropagation();
	
	if(confirm("¿Desea realmente borrar esta revista?")) {	
	    var form = document.createElement("form");
	    form.setAttribute("method", "post");
	    form.setAttribute("action", "borrarRevista.htm");
	
	    var hiddenField = document.createElement("input");
	    hiddenField.setAttribute("type", "hidden");
	    hiddenField.setAttribute("name", "idRevista");
	    hiddenField.setAttribute("value", idRevista);
	
	    form.appendChild(hiddenField);
	
	    document.body.appendChild(form);
	    form.submit();
	}
}

function verTema(idTema) {
    var form = document.createElement("form");
    form.setAttribute("method", "post");
    form.setAttribute("action", "verTema.htm");

    var hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "idTema");
    hiddenField.setAttribute("value", idTema);

    form.appendChild(hiddenField);

    document.body.appendChild(form);
    form.submit();
}

function borrarTema(event, idTema) {
	event.stopPropagation();
	
	if(confirm("¿Desea realmente borrar este tema?")) {	
	    var form = document.createElement("form");
	    form.setAttribute("method", "post");
	    form.setAttribute("action", "borrarTema.htm");
	
	    var hiddenField = document.createElement("input");
	    hiddenField.setAttribute("type", "hidden");
	    hiddenField.setAttribute("name", "idTema");
	    hiddenField.setAttribute("value", idTema);
	
	    form.appendChild(hiddenField);
	
	    document.body.appendChild(form);
	    form.submit();
	}
}
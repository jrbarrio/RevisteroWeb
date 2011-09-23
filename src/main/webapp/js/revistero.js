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

function marcarFavorito(event, idArticulo) {
	var xmlHttpReq = false;
    var self = this;
    // Mozilla/Safari
    if (window.XMLHttpRequest) {
        self.xmlHttpReq = new XMLHttpRequest();
    }
    // IE
    else if (window.ActiveXObject) {
        self.xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
    }

    self.xmlHttpReq.open('POST', "marcarFavorito.htm?idArticulo=" + idArticulo, true);
    self.xmlHttpReq.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    self.xmlHttpReq.send();
}

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
		var xmlHttpReq = false;
	    var self = this;
	    // Mozilla/Safari
	    if (window.XMLHttpRequest) {
	        self.xmlHttpReq = new XMLHttpRequest();
	    }
	    // IE
	    else if (window.ActiveXObject) {
	        self.xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
	    }

	    self.xmlHttpReq.open('POST', "borrarArticulo.htm?idArticulo=" + idArticulo, true);
	    self.xmlHttpReq.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	    self.xmlHttpReq.send();
	 
	    eliminarFilaTabla(idArticulo);
	    pintarFondoFilas();
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
		var xmlHttpReq = false;
	    var self = this;
	    // Mozilla/Safari
	    if (window.XMLHttpRequest) {
	        self.xmlHttpReq = new XMLHttpRequest();
	    }
	    // IE
	    else if (window.ActiveXObject) {
	        self.xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
	    }

	    self.xmlHttpReq.open('POST', "borrarCategoria.htm?idCategoria=" + idCategoria, true);
	    self.xmlHttpReq.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	    self.xmlHttpReq.send();
	 
	    eliminarFilaTabla(idCategoria);
	    pintarFondoFilas();
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
		
	if(confirm("¿Desea realmente borrar este numero?")) {	
		var xmlHttpReq = false;
	    var self = this;
	    // Mozilla/Safari
	    if (window.XMLHttpRequest) {
	        self.xmlHttpReq = new XMLHttpRequest();
	    }
	    // IE
	    else if (window.ActiveXObject) {
	        self.xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
	    }

	    self.xmlHttpReq.open('POST', "borrarNumero.htm?idNumero=" + idNumero, true);
	    self.xmlHttpReq.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	    self.xmlHttpReq.send();
	 
	    eliminarFilaTabla(idNumero);
	    pintarFondoFilas();
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
		var xmlHttpReq = false;
	    var self = this;
	    // Mozilla/Safari
	    if (window.XMLHttpRequest) {
	        self.xmlHttpReq = new XMLHttpRequest();
	    }
	    // IE
	    else if (window.ActiveXObject) {
	        self.xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
	    }

	    self.xmlHttpReq.open('POST', "borrarRevista.htm?idRevista=" + idRevista, true);
	    self.xmlHttpReq.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	    self.xmlHttpReq.send();
	 
	    eliminarFilaTabla(idRevista);
	    pintarFondoFilas();
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
		var xmlHttpReq = false;
	    var self = this;
	    // Mozilla/Safari
	    if (window.XMLHttpRequest) {
	        self.xmlHttpReq = new XMLHttpRequest();
	    }
	    // IE
	    else if (window.ActiveXObject) {
	        self.xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
	    }

	    self.xmlHttpReq.open('POST', "borrarTema.htm?idTema=" + idTema, true);
	    self.xmlHttpReq.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	    self.xmlHttpReq.send();
	 
	    eliminarFilaTabla(idTema);
	    pintarFondoFilas();
	}
}
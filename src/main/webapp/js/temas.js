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
	
	if(confirm("�Desea realmente borrar este tema?")) {	
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
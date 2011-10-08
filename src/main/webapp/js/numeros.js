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
		
	if(confirm("�Desea realmente borrar este numero?")) {	
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
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
		
	if(confirm("�Desea realmente borrar esta revista?")) {	
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
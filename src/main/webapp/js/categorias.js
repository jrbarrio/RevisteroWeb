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
	
	if(confirm("�Desea realmente borrar esta categoria?")) {	
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
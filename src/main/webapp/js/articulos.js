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
	
	if(confirm("�Desea realmente borrar este art�culo?")) {	
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
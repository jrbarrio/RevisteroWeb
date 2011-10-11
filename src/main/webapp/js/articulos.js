function verArticulo(idArticulo) {
    var form = document.createElement("form"), 
    	hiddenField = document.createElement("input");
    
    form.setAttribute("method", "post");
    form.setAttribute("action", "verArticulo.htm");

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
		var xmlHttpReq = null;
	    if (window.XMLHttpRequest) {
	        xmlHttpReq = new XMLHttpRequest();
	    } else if (window.ActiveXObject) {
	        xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
	    }

	    xmlHttpReq.open('POST', "borrarArticulo.htm?idArticulo=" + idArticulo, true);
	    xmlHttpReq.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	    xmlHttpReq.send();
	 
	    eliminarFilaTabla(idArticulo);
	    pintarFondoFilas();
	}
}

function marcarFavorito(event, idArticulo) {
	var xmlHttpReq = null;
    if (window.XMLHttpRequest) {
        xmlHttpReq = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
    }

    xmlHttpReq.open('POST', "marcarFavorito.htm?idArticulo=" + idArticulo, true);
    xmlHttpReq.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xmlHttpReq.send();
}
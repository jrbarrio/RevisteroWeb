function verCategoria(idCategoria) {
    var form = document.createElement("form"), 
    	hiddenField = document.createElement("input");
    
    form.setAttribute("method", "post");
    form.setAttribute("action", "verCategoria.htm");

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
		var xmlHttpReq = null;
	    if (window.XMLHttpRequest) {
	        xmlHttpReq = new XMLHttpRequest();
	    } else if (window.ActiveXObject) {
	        xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
	    }

	    xmlHttpReq.open('POST', "borrarCategoria.htm?idCategoria=" + idCategoria, true);
	    xmlHttpReq.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	    xmlHttpReq.send();
	 
	    eliminarFilaTabla(idCategoria);
	    pintarFondoFilas();
	}
}
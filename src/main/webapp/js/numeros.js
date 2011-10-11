function verNumero(idNumero) {
    var form = document.createElement("form"), 
    	hiddenField = document.createElement("input");
    
    form.setAttribute("method", "post");
    form.setAttribute("action", "verNumero.htm");

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
		var xmlHttpReq = null;
	    if (window.XMLHttpRequest) {
	        xmlHttpReq = new XMLHttpRequest();
	    } else if (window.ActiveXObject) {
	        xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
	    }

	    xmlHttpReq.open('POST', "borrarNumero.htm?idNumero=" + idNumero, true);
	    xmlHttpReq.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	    xmlHttpReq.send();
	 
	    eliminarFilaTabla(idNumero);
	    pintarFondoFilas();
	}
}
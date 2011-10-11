function verTema(idTema) {
    var form = document.createElement("form"), 
    	hiddenField = document.createElement("input");
    
    form.setAttribute("method", "post");
    form.setAttribute("action", "verTema.htm");
    
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
		var xmlHttpReq = null;
	    if (window.XMLHttpRequest) {
	        xmlHttpReq = new XMLHttpRequest();
	    } else if (window.ActiveXObject) {
	        xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
	    }

	    xmlHttpReq.open('POST', "borrarTema.htm?idTema=" + idTema, true);
	    xmlHttpReq.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	    xmlHttpReq.send();
	 
	    eliminarFilaTabla(idTema);
	    pintarFondoFilas();
	}
}
function verRevista(idRevista) {
    var form = document.createElement("form"), 
    	hiddenField = document.createElement("input");

    form.setAttribute("method", "post");
    form.setAttribute("action", "verRevista.htm");

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
		var xmlHttpReq = null;
	    if (window.XMLHttpRequest) {
	        xmlHttpReq = new XMLHttpRequest();
	    } else if (window.ActiveXObject) {
	    	xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
	    }

	    xmlHttpReq.open('POST', "borrarRevista.htm?idRevista=" + idRevista, true);
	    xmlHttpReq.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	    xmlHttpReq.send();
	 
	    eliminarFilaTabla(idRevista);
	    pintarFondoFilas();
	}
}
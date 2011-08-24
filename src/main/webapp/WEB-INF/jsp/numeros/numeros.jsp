<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="authz" uri="http://acegisecurity.org/authz" %>

<script type="text/javascript">
<!--
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
	
	if(confirm("¿Desea realmente borrar este número?")) {	
	    var form = document.createElement("form");
	    form.setAttribute("method", "post");
	    form.setAttribute("action", "borrarNumero.htm");
	
	    var hiddenField = document.createElement("input");
	    hiddenField.setAttribute("type", "hidden");
	    hiddenField.setAttribute("name", "idNumero");
	    hiddenField.setAttribute("value", idNumero);
	
	    form.appendChild(hiddenField);
	
	    document.body.appendChild(form);
	    form.submit();
	}
}
//-->
</script>


<div class="principal">
  <fieldset>
  	<legend><spring:message code="titulo.numeros"/></legend>
		<div>
			<form>
				<table class="tabla">
					<thead class="cabeceraTabla">
						<tr>
							<th><spring:message code="campo.titulo"/></th>
							<th><spring:message code="campo.descripcion"/></th>
							<authz:authorize ifAllGranted="ROLE_EDITOR">
								<th></th>
							</authz:authorize>
						</tr>
					</thead>
					<c:forEach items="${numeros}" var="numero">
					<tr onclick="javascript:verNumero(<c:out value='${numero.idNumero}'/>);">
						<td class="columna1"><c:out value="${numero.numero}"/> - <c:out value="${numero.titulo}"/></td>
						<td class="columna2"><c:out value="${numero.descripcion}"/></td>
						<authz:authorize ifAllGranted="ROLE_EDITOR">
							<td class="columna6">
								<a class="boton" onclick="javascript:borrarNumero(event, <c:out value='${numero.idNumero}'/>);">
									<spring:message code="boton.borrar"/>
								</a>
							</td>
						</authz:authorize>
					</tr>	
					</c:forEach>								
				</table>			
			</form>			
		</div>
	</fieldset>
</div>
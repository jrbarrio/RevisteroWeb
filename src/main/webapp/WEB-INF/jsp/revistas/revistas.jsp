<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="authz" uri="http://acegisecurity.org/authz" %>

<script type="text/javascript">
<!--
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
	
	if(confirm("¿Desea realmente borrar esta revista?")) {	
	    var form = document.createElement("form");
	    form.setAttribute("method", "post");
	    form.setAttribute("action", "borrarRevista.htm");
	
	    var hiddenField = document.createElement("input");
	    hiddenField.setAttribute("type", "hidden");
	    hiddenField.setAttribute("name", "idRevista");
	    hiddenField.setAttribute("value", idRevista);
	
	    form.appendChild(hiddenField);
	
	    document.body.appendChild(form);
	    form.submit();
	}
}
//-->
</script>

<div class="principal">
  <fieldset>
  	<legend><spring:message code="titulo.revistas"/></legend>
		<div>
			<form>
				<table class="tabla">
					<thead class="cabeceraTabla">
						<tr>
							<th><spring:message code="campo.nombre"/></th>
							<th><spring:message code="campo.descripcion"/></th>
							<authz:authorize ifAllGranted="ROLE_EDITOR">
								<th></th>
							</authz:authorize>
						</tr>
					</thead>
					<c:forEach items="${revistas}" var="revista">
					<tr onclick="javascript:verRevista(<c:out value='${revista.idRevista}'/>);">
						<td class="columna1"><c:out value="${revista.nombre}"/></td>
						<td class="columna2"><c:out value="${revista.descripcion}"/></td>
						<authz:authorize ifAllGranted="ROLE_EDITOR">
							<td class="columna6">
								<a class="boton" onclick="javascript:borrarRevista(event, <c:out value='${revista.idRevista}'/>);">
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
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="authz" uri="http://acegisecurity.org/authz" %>

<script type="text/javascript">
<!--
function verTema(idTema) {
    var form = document.createElement("form");
    form.setAttribute("method", "post");
    form.setAttribute("action", "verTema.htm");

    var hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "idTema");
    hiddenField.setAttribute("value", idTema);

    form.appendChild(hiddenField);

    document.body.appendChild(form);
    form.submit();
}

function borrarTema(event, idTema) {
	event.stopPropagation();
	
	if(confirm("¿Desea realmente borrar este tema?")) {	
	    var form = document.createElement("form");
	    form.setAttribute("method", "post");
	    form.setAttribute("action", "borrarTema.htm");
	
	    var hiddenField = document.createElement("input");
	    hiddenField.setAttribute("type", "hidden");
	    hiddenField.setAttribute("name", "idTema");
	    hiddenField.setAttribute("value", idTema);
	
	    form.appendChild(hiddenField);
	
	    document.body.appendChild(form);
	    form.submit();
	}
}
//-->
</script>

<div class="principal">
  <fieldset>
  	<legend><spring:message code="titulo.temas"/></legend>
		<div>
			<form>
				<table class="tabla">
					<thead class="cabeceraTabla">
						<tr>
							<th><spring:message code="campo.nombre"/></th>
							<th><spring:message code="campo.descripcion"/></th>
							<th><spring:message code="campo.categoria"/></th>
							<authz:authorize ifAllGranted="ROLE_EDITOR">
								<th></th>
							</authz:authorize>
						</tr>
					</thead>
					<c:forEach items="${temas}" var="tema">
					<tr onclick="javascript:verTema(<c:out value='${tema.idTema}'/>);">
						<td class="columna1"><c:out value="${tema.nombre}"/></td>
						<td class="columna2"><c:out value="${tema.descripcion}"/></td>
						<td class="columna3"><c:out value="${tema.categoria.nombre}"/></td>
						<authz:authorize ifAllGranted="ROLE_EDITOR">
							<td class="columna6">
								<a class="boton" onclick="javascript:borrarTema(event, <c:out value='${tema.idTema}'/>);">
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
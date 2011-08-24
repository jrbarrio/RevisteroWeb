<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="authz" uri="http://acegisecurity.org/authz" %>

<script type="text/javascript">
<!--
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
	
	if(confirm("¿Desea realmente borrar esta categoria?")) {	
	    var form = document.createElement("form");
	    form.setAttribute("method", "post");
	    form.setAttribute("action", "borrarCategoria.htm");
	
	    var hiddenField = document.createElement("input");
	    hiddenField.setAttribute("type", "hidden");
	    hiddenField.setAttribute("name", "idCategoria");
	    hiddenField.setAttribute("value", idCategoria);
	
	    form.appendChild(hiddenField);
	
	    document.body.appendChild(form);
	    form.submit();
	}
}
//-->
</script>

<div class="principal">
  <fieldset>
  	<legend><spring:message code="titulo.categorias"/></legend>
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
					<c:forEach items="${categorias}" var="categoria">
					<tr onclick="javascript:verCategoria(<c:out value='${categoria.idCategoria}'/>);">
						<td class="columna1"><c:out value="${categoria.nombre}"/></td>
						<td class="columna2"><c:out value="${categoria.descripcion}"/></td>
						<authz:authorize ifAllGranted="ROLE_EDITOR">
							<td class="columna6">
								<a class="boton" onclick="javascript:borrarCategoria(event, <c:out value='${categoria.idCategoria}'/>);">
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
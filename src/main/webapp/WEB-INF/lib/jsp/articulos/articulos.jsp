<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="authz" uri="http://acegisecurity.org/authz" %>

<script type="text/javascript">
<!--
function verArticulo(idArticulo) {
    var form = document.createElement("form");
    form.setAttribute("method", "post");
    form.setAttribute("action", "verArticulo.htm");

    var hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "idArticulo");
    hiddenField.setAttribute("value", idArticulo);

    form.appendChild(hiddenField);

    document.body.appendChild(form);    // Not entirely sure if this is necessary
    form.submit();
}
//-->
</script>


<div class="principal">
  <fieldset>
  	<legend><spring:message code="titulo.articulos"/></legend>
		<div>
			<form name="formarticulos">
				<table class="tabla">
					<tr class="cabeceraTabla">
						<th><spring:message code="campo.titulo"/></th>
						<th><spring:message code="campo.descripcion"/></th>
						<th><spring:message code="campo.numero"/></th>
						<authz:authorize ifAllGranted="ROLE_EDITOR">
							<th></th>
						</authz:authorize>
					</tr>
					<c:forEach items="${articulos}" var="articulo">
					<tr onclick="javascript:verArticulo(<c:out value='${articulo.idArticulo}'/>);">
						<td class="columna1"><c:out value="${articulo.titulo}"/></td>
						<td class="columna2"><c:out value="${articulo.descripcion}"/></td>
						<td class="columna3"><c:out value="${articulo.numero.numero}"/></td>
						<authz:authorize ifAllGranted="ROLE_EDITOR">
							<td class="columna6">
								<a class="boton" href="borrarArticulo.htm?idArticulo=<c:out value="${articulo.idArticulo}"/>">
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
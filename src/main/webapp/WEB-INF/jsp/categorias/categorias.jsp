<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="authz" uri="http://acegisecurity.org/authz" %>

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
						<tr id="<c:out value='${categoria.idCategoria}'/>">
							<td onclick="javascript:verCategoria(<c:out value='${categoria.idCategoria}'/>);" class="columna1"><c:out value="${categoria.nombre}"/></td>
							<td onclick="javascript:verCategoria(<c:out value='${categoria.idCategoria}'/>);" class="columna2"><c:out value="${categoria.descripcion}"/></td>
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
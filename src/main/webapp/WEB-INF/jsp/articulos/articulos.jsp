<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="authz" uri="http://acegisecurity.org/authz" %>

<div class="principal">
  <fieldset>
  	<legend><spring:message code="titulo.articulos"/></legend>
		<div>
			<form name="formarticulos">
				<c:choose> 
		  			<c:when test="${!empty articulos}" >
						<table class="tabla">
							<thead>
								<tr class="cabeceraTabla">
									<th><spring:message code="campo.titulo"/></th>
									<th><spring:message code="campo.descripcion"/></th>
									<th><spring:message code="campo.numero"/></th>
									<th><spring:message code="campo.favorito"/></th>
									<authz:authorize ifAllGranted="ROLE_EDITOR">
										<th></th>
									</authz:authorize>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${articulos}" var="articulo">
								<tr id="<c:out value='${articulo.idArticulo}'/>">
									<td onclick="javascript:verArticulo(<c:out value='${articulo.idArticulo}'/>);" class="columna1"><c:out value="${articulo.titulo}"/></td>
									<td onclick="javascript:verArticulo(<c:out value='${articulo.idArticulo}'/>);" class="columna2"><c:out value="${articulo.descripcion}"/></td>
									<td onclick="javascript:verArticulo(<c:out value='${articulo.idArticulo}'/>);" class="columna3"><c:out value="${articulo.numero.numero}"/></td>
									<td class="columna3">
										<c:choose> 
											<c:when test="${articulo.favorito}">
												<input type="checkbox" checked="checked" onclick="marcarFavorito(event, <c:out value='${articulo.idArticulo}'/>);"/>
											</c:when>
											<c:otherwise>
												<input type="checkbox" onclick="marcarFavorito(event, <c:out value='${articulo.idArticulo}'/>);"/>
											</c:otherwise>								
										</c:choose>							
									</td>
									<authz:authorize ifAllGranted="ROLE_EDITOR">
										<td class="columna6">
											<a class="boton" onclick="borrarArticulo(event, <c:out value='${articulo.idArticulo}'/>);">
												<spring:message code="boton.borrar"/>
											</a>
										</td>
									</authz:authorize>
								</tr>	
								</c:forEach>	
							</tbody>							
						</table>	
					</c:when>
					<c:otherwise>No hay artículos que mostrar.</c:otherwise>
				</c:choose>			
			</form>			
		</div>
	</fieldset>
</div>
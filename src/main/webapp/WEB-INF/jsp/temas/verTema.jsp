<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="authz" uri="http://acegisecurity.org/authz" %>

<div class="principal">
	<fieldset>
  		<legend><spring:message code="titulo.tema"/></legend>
		<div class="lista_campos">
			<form>
				<div class="lista_campos">
			    	<div class="campo">
						<div class="nombre_campo"><spring:message code="campo.nombre"/></div>
						<div class="valor_campo">
		            		<div class="deshabilitado"><c:out value="${tema.nombre}"/></div>
						</div>
					</div>
					<div class="campo">
						<div class="nombre_campo"><spring:message code="campo.descripcion"/></div>
						<div class="valor_campo">
		           			<div class="deshabilitado"><c:out value="${tema.descripcion}"/></div>
						</div>
					</div>
					<div class="campo">
						<div class="nombre_campo"><spring:message code="campo.categoria"/></div>
						<div class="valor_campo">
		           			<div class="deshabilitado">
		           				<a onclick="javascript:verCategoria(<c:out value='${tema.categoria.idCategoria}'/>);">
		           					<c:out value="${tema.categoria.nombre}"/>
		           				</a>
		           			</div>
						</div>
					</div>
					<authz:authorize ifAllGranted="ROLE_EDITOR">
						<div class="opciones">
							<a class="boton" href="editarTema.htm?idTema=<c:out value="${tema.idTema}"/>">
								<spring:message code="boton.editar"/>
							</a>
						</div>
					</authz:authorize>
				</div>	
			</form>			
		</div>
	</fieldset>
	<fieldset>
  		<legend><spring:message code="titulo.articulos"/></legend>
		<div>
			<form name="formarticulos">
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
						<c:forEach items="${tema.articulos}" var="articulo">
						<tr>
							<td onclick="javascript:verArticulo(<c:out value='${articulo.idArticulo}'/>);" class="columna1"><c:out value="${articulo.titulo}"/></td>
							<td onclick="javascript:verArticulo(<c:out value='${articulo.idArticulo}'/>);" class="columna2"><c:out value="${articulo.descripcion}"/></td>
							<td onclick="javascript:verArticulo(<c:out value='${articulo.idArticulo}'/>);" class="columna3"><c:out value="${articulo.numero.numero}"/></td>
							<td class="columna3">
								<c:choose> 
									<c:when test="${articulo.favorito}">
										<input type="checkbox" checked="checked" onclick="javascript:marcarFavorito(event, <c:out value='${articulo.idArticulo}'/>);"/>
									</c:when>
									<c:otherwise>
										<input type="checkbox" onclick="javascript:marcarFavorito(event, <c:out value='${articulo.idArticulo}'/>);"/>
									</c:otherwise>								
								</c:choose>							
							</td>
							<authz:authorize ifAllGranted="ROLE_EDITOR">
								<td class="columna6">
									<a class="boton" onclick="javascript:borrarArticulo(event, <c:out value='${articulo.idArticulo}'/>);">
										<spring:message code="boton.borrar"/>
									</a>
								</td>
							</authz:authorize>
						</tr>	
						</c:forEach>	
					</tbody>							
				</table>			
			</form>			
		</div>
	</fieldset>
</div>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="authz" uri="http://acegisecurity.org/authz" %>

<div class="principal">
	<fieldset>
  		<legend><spring:message code="titulo.categoria"/></legend>
		<div class="lista_campos">
			<form>
				<div class="lista_campos">
			    	<div class="campo">
						<div class="nombre_campo"><spring:message code="campo.nombre"/></div>
						<div class="valor_campo">
		            		<div class="deshabilitado"><c:out value="${categoria.nombre}"/></div>
						</div>
					</div>
					<div class="campo">
						<div class="nombre_campo"><spring:message code="campo.descripcion"/></div>
						<div class="valor_campo">
		           			<div class="deshabilitado"><c:out value="${categoria.descripcion}"/></div>
						</div>
					</div>
					<authz:authorize ifAllGranted="ROLE_EDITOR">
						<div class="opciones">
							<a class="boton" href="editarCategoria.htm?idCategoria=<c:out value="${categoria.idCategoria}"/>">
								<spring:message code="boton.editar"/>
							</a>
						</div>
					</authz:authorize>
				</div>	
			</form>			
		</div>
	</fieldset>
	<fieldset>
  		<legend><spring:message code="titulo.temas"/></legend>
		<div>
			<form>
				<c:choose> 
		  			<c:when test="${!empty categoria.temas}" > 
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
							<c:forEach items="${categoria.temas}" var="tema">
							<tr id="<c:out value='${tema.idTema}'/>">
								<td onclick="verTema(<c:out value='${tema.idTema}'/>);" class="columna1"><c:out value="${tema.nombre}"/></td>
								<td onclick="verTema(<c:out value='${tema.idTema}'/>);" class="columna2"><c:out value="${tema.descripcion}"/></td>
								<td onclick="verTema(<c:out value='${tema.idTema}'/>);" class="columna3"><c:out value="${tema.categoria.nombre}"/></td>
								<authz:authorize ifAllGranted="ROLE_EDITOR">
									<td class="columna6">
										<a class="boton" onclick="borrarTema(event, <c:out value='${tema.idTema}'/>);">
											<spring:message code="boton.borrar"/>
										</a>
									</td>
								</authz:authorize>
							</tr>	
							</c:forEach>								
						</table>			
					</c:when>
					<c:otherwise>Esta categoría no tiene temas.</c:otherwise>
				</c:choose>				
			</form>			
		</div>
	</fieldset>
</div>
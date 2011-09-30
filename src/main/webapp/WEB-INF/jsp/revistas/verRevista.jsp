<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="authz" uri="http://acegisecurity.org/authz" %>

<div class="principal">
	<fieldset>
  		<legend><spring:message code="titulo.revista"/></legend>
		<div class="lista_campos">
			<form>
				<div class="lista_campos">
			    	<div class="campo">
						<div class="nombre_campo"><spring:message code="campo.nombre"/></div>
						<div class="valor_campo">
		            		<div class="deshabilitado"><c:out value="${revista.nombre}"/></div>
						</div>
					</div>
					<div class="campo">
						<div class="nombre_campo"><spring:message code="campo.descripcion"/></div>
						<div class="valor_campo">
		           			<div class="deshabilitado"><c:out value="${revista.descripcion}"/></div>
						</div>
					</div>
					<authz:authorize ifAllGranted="ROLE_EDITOR">
						<div class="opciones">
							<a class="boton" href="editarRevista.htm?idRevista=<c:out value="${revista.idRevista}"/>">
								<spring:message code="boton.editar"/>
							</a>
						</div>
					</authz:authorize>
				</div>	
			</form>			
		</div>
	</fieldset>
	<fieldset>
  		<legend><spring:message code="titulo.numeros"/></legend>
		<div>
			<form>
				<c:choose> 
		  			<c:when test="${!empty revista.numeros}" >
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
							<c:forEach items="${revista.numeros}" var="numero">
							<tr id="<c:out value='${numero.idNumero}'/>">
								<td onclick="javascript:verNumero(<c:out value='${numero.idNumero}'/>);" class="columna1"><c:out value="${numero.numero}"/> - <c:out value="${numero.titulo}"/></td>
								<td onclick="javascript:verNumero(<c:out value='${numero.idNumero}'/>);" class="columna2"><c:out value="${numero.descripcion}"/></td>
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
					</c:when>			
					<c:otherwise>Esta revista no tiene números.</c:otherwise>
				</c:choose>		
			</form>			
		</div>
	</fieldset>
</div>
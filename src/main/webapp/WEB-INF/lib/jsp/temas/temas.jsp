<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="authz" uri="http://acegisecurity.org/authz" %>

<div class="principal">
  <fieldset>
  	<legend><spring:message code="titulo.temas"/></legend>
		<div>
			<form>
				<table class="tabla">
					<tr class="cabeceraTabla">
						<th><spring:message code="campo.nombre"/></th>
						<th><spring:message code="campo.descripcion"/></th>
						<th><spring:message code="campo.categoria"/></th>
						<th></th>
						<authz:authorize ifAllGranted="ROLE_EDITOR">
							<th></th>
							<th></th>
						</authz:authorize>
					</tr>
					<c:forEach items="${temas}" var="tema">
					<tr>
						<td class="columna1"><c:out value="${tema.nombre}"/></td>
						<td class="columna2"><c:out value="${tema.descripcion}"/></td>
						<td class="columna3"><c:out value="${tema.categoria.nombre}"/></td>
						<td class="columna4">
							<a class="boton" href="verTema.htm?idTema=<c:out value="${tema.idTema}"/>">
								<spring:message code="boton.ver"/>
							</a>
						</td>
						<authz:authorize ifAllGranted="ROLE_EDITOR">
							<td class="columna5">
								<a class="boton" href="editarTema.htm?idTema=<c:out value="${tema.idTema}"/>">
									<spring:message code="boton.editar"/>
								</a>
							</td>
							<td class="columna6">
								<a class="boton" href="borrarTema.htm?idTema=<c:out value="${tema.idTema}"/>">
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
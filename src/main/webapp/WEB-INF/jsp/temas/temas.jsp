<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="authz" uri="http://acegisecurity.org/authz" %>

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
					<tr id="<c:out value='${tema.idTema}'/>">
						<td onclick="javascript:verTema(<c:out value='${tema.idTema}'/>);" class="columna1"><c:out value="${tema.nombre}"/></td>
						<td onclick="javascript:verTema(<c:out value='${tema.idTema}'/>);" class="columna2"><c:out value="${tema.descripcion}"/></td>
						<td onclick="javascript:verTema(<c:out value='${tema.idTema}'/>);" class="columna3"><c:out value="${tema.categoria.nombre}"/></td>
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
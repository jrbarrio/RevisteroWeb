<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="authz" uri="http://acegisecurity.org/authz" %>

<div class="principal">
  <fieldset>
  	<legend><spring:message code="titulo.numeros"/></legend>
		<div>
			<form>
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
					<c:forEach items="${numeros}" var="numero">
					<tr id="<c:out value='${numero.idNumero}'/>">
						<td onclick="verNumero(<c:out value='${numero.idNumero}'/>);" class="columna1"><c:out value="${numero.numero}"/> - <c:out value="${numero.titulo}"/></td>
						<td onclick="verNumero(<c:out value='${numero.idNumero}'/>);" class="columna2"><c:out value="${numero.descripcion}"/></td>
						<authz:authorize ifAllGranted="ROLE_EDITOR">
							<td class="columna6">
								<a class="boton" onclick="borrarNumero(event, <c:out value='${numero.idNumero}'/>);">
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
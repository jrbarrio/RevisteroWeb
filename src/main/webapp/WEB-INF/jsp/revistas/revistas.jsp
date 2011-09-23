<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="authz" uri="http://acegisecurity.org/authz" %>

<div class="principal">
  <fieldset>
  	<legend><spring:message code="titulo.revistas"/></legend>
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
					<c:forEach items="${revistas}" var="revista">
					<tr id="<c:out value='${revista.idRevista}'/>">
						<td onclick="javascript:verRevista(<c:out value='${revista.idRevista}'/>);" class="columna1"><c:out value="${revista.nombre}"/></td>
						<td onclick="javascript:verRevista(<c:out value='${revista.idRevista}'/>);" class="columna2"><c:out value="${revista.descripcion}"/></td>
						<authz:authorize ifAllGranted="ROLE_EDITOR">
							<td class="columna6">
								<a class="boton" onclick="javascript:borrarRevista(event, <c:out value='${revista.idRevista}'/>);">
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
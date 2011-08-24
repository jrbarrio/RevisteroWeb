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
</div>
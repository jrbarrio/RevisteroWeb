<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="authz" uri="http://acegisecurity.org/authz" %>

<div class="principal">
	<fieldset>
  		<legend><spring:message code="titulo.articulo"/></legend>
		<div class="lista_campos">
			<form>
				<div class="lista_campos">
			    	<div class="campo">
						<div class="nombre_campo"><spring:message code="campo.titulo"/></div>
						<div class="valor_campo">
		            		<div class="deshabilitado"><c:out value="${articulo.titulo}"/></div>
						</div>
					</div>
					<div class="campo">
						<div class="nombre_campo"><spring:message code="campo.descripcion"/></div>
						<div class="valor_campo">
		           			<div class="deshabilitado"><c:out value="${articulo.titulo}"/></div>
						</div>
					</div>
					<div class="campo">
						<div class="nombre_campo"><spring:message code="campo.tema"/></div>
						<div class="valor_campo">
		           			<div class="deshabilitado"><c:out value="${articulo.tema.nombre}"/></div>
						</div>
					</div>
					<div class="campo">
						<div class="nombre_campo"><spring:message code="campo.numero"/></div>
						<div class="valor_campo">
		            		<div class="deshabilitado"><c:out value="${articulo.numero.numero}"/> - <c:out value="${articulo.numero.titulo}"/></div>
						</div>
					</div>
					<div class="campo">
						<div class="nombre_campo"><spring:message code="campo.revista"/></div>
						<div class="valor_campo">
		           			<div class="deshabilitado"><c:out value="${articulo.numero.revista.nombre}"/></div>
						</div>
					</div>
					<authz:authorize ifAllGranted="ROLE_EDITOR">
						<div class="opciones">
							<a class="boton" href="editarArticulo.htm?idArticulo=<c:out value="${articulo.idArticulo}"/>">
								<spring:message code="boton.editar"/>
							</a>
						</div>
					</authz:authorize>
				</div>	
			</form>			
		</div>
	</fieldset>
</div>
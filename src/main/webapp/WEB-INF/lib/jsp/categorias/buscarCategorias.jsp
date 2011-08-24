<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="principal">
	<form:form method="POST" action="buscarCategorias.htm" commandName="categoria">
		<fieldset>
	    	<legend><spring:message code="titulo.buscarcategorias"/></legend>
			<div class="lista_campos">
		    	<div class="campo">
					<div class="nombre_campo"><spring:message code="campo.nombre"/></div>
					<div class="valor_campo">
	            		<div>
	            			<form:textarea path="nombre" rows="3" cols="60"></form:textarea>
	            		</div>
					</div>
				</div>
				<div class="campo">
					<div class="nombre_campo"><spring:message code="campo.descripcion"/></div>
					<div class="valor_campo">
	           			<div>
	           				<form:textarea path="descripcion" rows="5" cols="60"></form:textarea>
	           			</div>
					</div>
				</div>
				<form:hidden path="idCategoria"/>
				<div class="opciones">
					<div class="opciones"><input type="submit" class="boton" value='<spring:message code="boton.buscar"/>'/></div>
				</div>
			</div>	
		</fieldset>
	</form:form>
</div>
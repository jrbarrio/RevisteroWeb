<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="principal">
	<form:form method="POST" action="buscarTemas.htm" commandName="tema">
		<fieldset>
	    	<legend><spring:message code="titulo.buscartemas"/></legend>
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
				<div class="campo">
					<div class="nombre_campo"><spring:message code="campo.categoria"/></div>
					<div class="valor_campo">
	           			<div>
	           				<form:select path="categoria.idCategoria">
	           					<form:options items="${categorias}" itemLabel="nombre" itemValue="idCategoria"/>
	           				</form:select>
	           			</div>
					</div>
				</div>
				<form:hidden path="idTema"/>
				<div class="opciones">
					<div class="opciones"><input type="submit" class="boton" value='<spring:message code="boton.buscar"/>'/></div>
				</div>
			</div>	
		</fieldset>
	</form:form>
</div>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="principal">
	<form:form method="POST" action="buscarNumeros.htm" commandName="numero">
		<fieldset>
	    	<legend><spring:message code="titulo.buscarnumeros"/></legend>
			<div class="lista_campos">
		    	<div class="campo">
					<div class="nombre_campo"><spring:message code="campo.titulo"/></div>
					<div class="valor_campo">
	            		<div>
	            			<form:textarea path="titulo" rows="3" cols="60"></form:textarea>
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
					<div class="nombre_campo"><spring:message code="campo.revista"/></div>
					<div class="valor_campo">
	           			<div>
	           				<form:select path="revista.idRevista">
	           					<form:options items="${revistas}" itemLabel="nombre" itemValue="idRevista"/>
	           				</form:select>
	           			</div>
					</div>
				<form:hidden path="idNumero"/>
				<div class="opciones">
					<div class="opciones"><input type="submit" class="boton" value='<spring:message code="boton.buscar"/>'/></div>
				</div>
			</div>	
		</fieldset>
	</form:form>
</div>
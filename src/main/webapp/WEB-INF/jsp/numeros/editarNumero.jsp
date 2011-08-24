<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="principal">
	<form:form method="POST" action="editarNumero.htm" commandName="numero">
		<fieldset>
	    	<legend><spring:message code="titulo.numero"/></legend>
			<div class="lista_campos">
		    	<div class="campo">
		    		<div class="error"><form:errors path="titulo"/></div>
					<div class="nombre_campo"><spring:message code="campo.titulo"/></div>
					<div class="valor_campo">
	            		<div>
	            			<form:textarea path="titulo" rows="3" cols="60"></form:textarea>
	            		</div>
					</div>
				</div>
				<div class="campo">
					<div class="error"><form:errors path="descripcion"/></div>
					<div class="nombre_campo"><spring:message code="campo.descripcion"/></div>
					<div class="valor_campo">
	           			<div>
	           				<form:textarea path="descripcion" rows="5" cols="60"></form:textarea>
	           			</div>
					</div>
				</div>
				<div class="campo">
					<div class="error"><form:errors path="numero"/></div>
					<div class="nombre_campo"><spring:message code="campo.numero"/></div>
					<div class="valor_campo">
	           			<div>
	           				<form:input path="numero"/>
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
				</div>				
				<form:hidden path="idNumero"/>
				<div class="opciones">
					<div class="opciones"><input type="submit" class="boton" value='<spring:message code="boton.guardar"/>'/></div>
				</div>
			</div>	
		</fieldset>
	</form:form>
</div>
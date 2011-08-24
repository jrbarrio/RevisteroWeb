<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script type="text/javascript">
<!--
	function actualizar()
	{
		document.getElementById('articulo').method="GET";
		document.getElementById('articulo').submit();
	}
//-->
</script>

<div class="principal">
	<form:form method="POST" action="editarArticulo.htm" commandName="articulo">
		<fieldset>
	    	<legend><spring:message code="titulo.articulo"/></legend>
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
					<div class="nombre_campo"><spring:message code="campo.tema"/></div>
					<div class="valor_campo">
	           			<div>
	           				<form:select path="tema.idTema">
	           					<form:options items="${temas}" itemLabel="nombre" itemValue="idTema"/>           					
	           				</form:select>
	           			</div>
					</div>
				</div>	
				<div class="campo">
					<div class="nombre_campo"><spring:message code="campo.numero"/></div>
					<div class="valor_campo">
	           			<div>
	           				<form:select path="numero.idNumero">
	           					<form:options items="${numeros}" itemLabel="titulo" itemValue="idNumero"/>           					
	           				</form:select>
	           			</div>
					</div>
				</div>	
				<div class="campo">
					<div class="nombre_campo"><spring:message code="campo.revista"/></div>
					<div class="valor_campo">
	           			<div>
	           				<form:select path="numero.revista.idRevista" onchange="javascript:actualizar();">
	           					<form:options items="${revistas}" itemLabel="nombre" itemValue="idRevista"/>           					
	           				</form:select>
	           			</div>
					</div>
				</div>				
				<form:hidden path="idArticulo"/>
				<div class="opciones">
					<div class="opciones"><input type="submit" class="boton" value='<spring:message code="boton.guardar"/>'/></div>
				</div>
			</div>	
		</fieldset>
	</form:form>
</div>
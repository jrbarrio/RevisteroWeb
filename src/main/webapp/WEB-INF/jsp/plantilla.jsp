<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ taglib prefix="tiles" uri="/WEB-INF/tlds/struts-tiles.tld" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="authz" uri="http://acegisecurity.org/authz" %>

<html>
	<head>			
		<title><spring:message code="titulo.revistero"/></title>
		<link rel="STYLESHEET" type="text/css" href="<%=request.getContextPath()%>/css/estilos.css">
		
		<script type="text/javascript" src="js/jquery.js"></script>            
  		<script type="text/javascript" src="js/revistero.js"></script>  
	</head>
	<body>
		<div class="contenedor">
			<div class="cabecera"><a href="inicio.htm"><spring:message code="titulo.revistero"/></a></div>
			
			<div class="cuerpo">
				<form>
					<div class="lateral">
						<ul>
							<li><spring:message code="titulo.categorias"/></li>
							<li>
								<ul>
									<li><a href="categorias.htm"><spring:message code="titulo.categorias"/></a></li>
									<authz:authorize ifAllGranted="ROLE_EDITOR">
										<li><a href="editarCategoria.htm"><spring:message code="titulo.nuevacategoria"/></a></li>
									</authz:authorize>
									<li><a href="buscarCategorias.htm"><spring:message code="titulo.buscarcategorias"/></a></li>
								</ul>
							</li>
							<li><spring:message code="titulo.temas"/></li>
							<li>
								<ul>
									<li><a href="temas.htm"><spring:message code="titulo.temas"/></a></li>
									<authz:authorize ifAllGranted="ROLE_EDITOR">
										<li><a href="editarTema.htm"><spring:message code="titulo.nuevotema"/></a></li>
									</authz:authorize>
									<li><a href="buscarTemas.htm"><spring:message code="titulo.buscartemas"/></a></li>
								</ul>
							</li>
							<li><spring:message code="titulo.revistas"/></li>
							<li>
								<ul>
									<li><a href="revistas.htm"><spring:message code="titulo.revistas"/></a></li>
									<authz:authorize ifAllGranted="ROLE_EDITOR">
										<li><a href="editarRevista.htm"><spring:message code="titulo.nuevarevista"/></a></li>
									</authz:authorize>
									<li><a href="buscarRevistas.htm"><spring:message code="titulo.buscarrevistas"/></a></li>
								</ul>
							</li>
							<li><spring:message code="titulo.numeros"/></li>
							<li>
								<ul>
									<li><a href="numeros.htm"><spring:message code="titulo.numeros"/></a></li>
									<authz:authorize ifAllGranted="ROLE_EDITOR">
										<li><a href="editarNumero.htm"><spring:message code="titulo.nuevonumero"/></a></li>
									</authz:authorize>
									<li><a href="buscarNumeros.htm"><spring:message code="titulo.buscarnumeros"/></a></li>
								</ul>
							</li>
							<li><spring:message code="titulo.articulos"/></li>
							<li>
								<ul>
									<li><a href="articulos.htm"><spring:message code="titulo.articulos"/></a></li>
									<authz:authorize ifAllGranted="ROLE_EDITOR">
										<li><a href="editarArticulo.htm"><spring:message code="titulo.nuevoarticulo"/></a></li>
									</authz:authorize>
									<li><a href="buscarArticulos.htm"><spring:message code="titulo.buscararticulos"/></a></li>
									<li><a href="articulosFavoritos.htm"><spring:message code="titulo.articulosfavoritos"/></a></li>
								</ul>
							</li>
						</ul>
					</div>
				</form>
				
				<tiles:insert name="contenido" />
			</div>
		  
			<div class="pie"><spring:message code="copyright"/></div>
		</div> 
	</body>
</html>
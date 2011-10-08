La finalidad de este proyecto es desarrollar un catalogo de revistas y articulos.

Esta desarrollado con las siguientes tecnologías:
- Java
- Spring 2.5
- JSP/Tiles
- Hibernate
- MySQL
- Javascript/JQuery
- Maven
- YUI Compressor

Hace uso de una base de datos "revistero" (usuario "root" y password "root") que se puede crear y poblar a partir del archivo de backup existente en el directorio conf.

Lanzar el seridor jetty desde MAven para que se genere y corra el war de la aplicación: 
mvn jetty:run-war

Ejecutar los goal del YUI Compressor:
mvn net.alchim31.maven:yuicompressor-maven-plugin:compress
mvn net.alchim31.maven:yuicompressor-maven-plugin:jslint

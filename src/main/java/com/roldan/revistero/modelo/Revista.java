package com.roldan.revistero.modelo;

/**
 * 
 * @author Jorge Roldán
 * @since 03/12/2008
 *
 */
public class Revista {
	private Long idRevista;
	private String nombre;
	private String descripcion;
	
	public Long getIdRevista() {
		return idRevista;
	}
	public void setIdRevista(Long idRevista) {
		this.idRevista = idRevista;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}

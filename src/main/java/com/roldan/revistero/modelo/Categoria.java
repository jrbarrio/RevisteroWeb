package com.roldan.revistero.modelo;

import java.util.List;

/**
 * 
 * @author Jorge Roldán
 * @since 03/12/2008
 *
 */
public class Categoria {
	private Long idCategoria;
	private String nombre;
	private String descripcion;
	private List<Tema> temas;
	
	public Long getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
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
	public List<Tema> getTemas() {
		return temas;
	}
	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}
}

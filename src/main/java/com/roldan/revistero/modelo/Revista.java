package com.roldan.revistero.modelo;

import java.util.List;

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
	private List<Numero> numeros;
	
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
	public List<Numero> getNumeros() {
		return numeros;
	}
	public void setNumeros(List<Numero> numeros) {
		this.numeros = numeros;
	}
}

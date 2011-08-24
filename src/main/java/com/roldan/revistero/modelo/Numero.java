package com.roldan.revistero.modelo;

/**
 * 
 * @author Jorge Roldán
 * @since 03/12/2008
 *
 */
public class Numero {
	private Long idNumero;
	private Revista revista;
	private String titulo;
	private String descripcion;
	private String numero;
	
	public Long getIdNumero() {
		return idNumero;
	}
	public void setIdNumero(Long idNumero) {
		this.idNumero = idNumero;
	}
	public Revista getRevista() {
		return revista;
	}
	public void setRevista(Revista revista) {
		this.revista = revista;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
}

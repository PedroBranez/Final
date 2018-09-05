package com.marcelo.datos;

public class Docente {
	
	private int codigoDocente;
	private String nombre;
	private long telefono;
	private String direccion;
	
	public Docente(int codigoDocente, String nombre, long telefono, String direccion){
		this.codigoDocente = codigoDocente;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	public int getCodigoDocente() {
		return codigoDocente;
	}

	public String getNombre() {
		return nombre;
	}

	public long getTelefono() {
		return telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	@Override
	public String toString() {
		return "Docente [codigoDocente=" + codigoDocente + ", nombre=" + nombre + ", telefono=" + telefono
				+ ", direccion=" + direccion + "]";
	}

	
	
	

}

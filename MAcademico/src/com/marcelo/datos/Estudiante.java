package com.marcelo.datos;

public class Estudiante {
	
	private int codigoEstudiante;
	private String nombre;
	private long telefono;
	private String direccion;
	
	public Estudiante(int codigoEstudiante, String nombre, long telefono, String direccion) {
		super();
		this.codigoEstudiante = codigoEstudiante;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	public int getCodigoEstudiante() {
		return codigoEstudiante;
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
		return "Estudiante [codigoEstudiante=" + codigoEstudiante + ", nombre=" + nombre + ", telefono=" + telefono
				+ ", direccion=" + direccion + "]";
	}
	



}

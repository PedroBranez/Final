package com.marcelo.datos;

public class Materia {
	private int codigoMateria;
	private String nombre;
	private String descripci�n;
	
	public Materia (int codigoMateria, String nombre, String descripcion){
		this.codigoMateria = codigoMateria;
		this.nombre = nombre;
		this.descripci�n = descripcion;
	}

	public int getCodigoMateria() {
		return codigoMateria;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripci�n() {
		return descripci�n;
	}

	@Override
	public String toString() {
		return "Materia [codigoMateria=" + codigoMateria + ", nombre=" + nombre + ", descripci�n=" + descripci�n + "]";
	}
	
	
	
}

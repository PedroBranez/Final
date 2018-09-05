package com.marcelo.datos;

public class Materia {
	private int codigoMateria;
	private String nombre;
	private String descripción;
	
	public Materia (int codigoMateria, String nombre, String descripcion){
		this.codigoMateria = codigoMateria;
		this.nombre = nombre;
		this.descripción = descripcion;
	}

	public int getCodigoMateria() {
		return codigoMateria;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripción() {
		return descripción;
	}

	@Override
	public String toString() {
		return "Materia [codigoMateria=" + codigoMateria + ", nombre=" + nombre + ", descripción=" + descripción + "]";
	}
	
	
	
}

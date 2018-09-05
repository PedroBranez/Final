package com.marcelo.datos;

import java.util.Date;

public class Horario {
	
	private int codigoHorario;
	private Date fechaInicio;
	private Date fechaFin;
	
	public Horario(int codigoHorario, Date fechaInicio, Date fechaFin) {
		super();
		this.codigoHorario = codigoHorario;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	public int getCodigoHorario() {
		return codigoHorario;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	@Override
	public String toString() {
		return "Horario [codigoHorario=" + codigoHorario + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin
				+ "]";
	}
	
	

}

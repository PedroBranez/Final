package com.marcelo.datos;

import java.util.Date;

public class AsignacionDocente {

	private int codigoAsignacionDocente;
	private int codigoDocente;
	private String numeroAula;
	private int codigoMateria;
	private int codigoHorario;
	private Date fecha;

	public AsignacionDocente(int codigoAsignacionDocente, int codigoDocente, String numeroAula, int codigoMateria,
			int codigoHorario, Date fecha) {
		super();
		this.codigoAsignacionDocente = codigoAsignacionDocente;
		this.codigoDocente = codigoDocente;
		this.numeroAula = numeroAula;
		this.codigoMateria = codigoMateria;
		this.codigoHorario = codigoHorario;
		this.fecha = fecha;
	}

	public int getCodigoAsignacionDocente() {
		return codigoAsignacionDocente;
	}

	public int getCodigoDocente() {
		return codigoDocente;
	}

	public String getNumeroAula() {
		return numeroAula;
	}

	public int getCodigoMateria() {
		return codigoMateria;
	}



	public int getCodigoHorario() {
		return codigoHorario;
	}

	public Date getFecha() {
		return fecha;
	}

	@Override
	public String toString() {
		return "AsignacionDocente [codigoAsignacionDocente=" + codigoAsignacionDocente + ", codigoDocente="
				+ codigoDocente + ", numeroAula=" + numeroAula + ", codigoMateria=" + codigoMateria
				+ ", codigoHorario=" + codigoHorario + ", fecha=" + fecha
				+ "]";
	}

}

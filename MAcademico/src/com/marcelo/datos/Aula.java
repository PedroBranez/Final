package com.marcelo.datos;

public class Aula {

	private String numero;
	private String bloque;

	public Aula(String numero, String bloque) {
		super();
		this.numero = numero;
		this.bloque = bloque;
	}

	public String getNumero() {
		return numero;
	}

	public String getBloque() {
		return bloque;
	}

	@Override
	public String toString() {
		return "Aula [numero=" + numero + ", bloque=" + bloque + "]";
	}

	public boolean equals(String numero) {

		return this.numero.equals(numero);

	}

	//
	// Métodos para la implementación HashSet
	//

	public boolean equals(Object o) {
		if (o == null)
			return false;
		Aula aula = (Aula) o;
		if (this.getNumero().equals(aula.getNumero()))
			return true;
		else
			return false;
	}

	public int hashCode() {
		return this.getNumero().hashCode();
	}

}

package com.marcelo.datos;

public class Vector<Entidad> {

	private Entidad[] entidades;
	private int last;

	@SuppressWarnings("unchecked")
	public Vector(int dimension) {
		last = -1;
		entidades = (Entidad[]) new Object[dimension];
	}

	public void add(Entidad entidad) {
		last = last + 1;
		entidades[last] = entidad;
	}

	public Entidad read(int position) {

		if (position >= 0 && position <= last) {
			return entidades[position];
		} else {
			return null;
		}
	}

	public void delete(int position) {
		if (position >= 0 && position < last) {
			for (int i = position; i < last; i++) {
				entidades[i] = entidades[i + 1];
				last--;
			}
		} else {
			if (position == last) {
				last--;
			}
		}
	}

	public int getLast() {
		return last;
	}

	public void print() {
		for (int i = 0; i <= last; i++) {
			System.out.println(this.read(i).toString());
		}
	}

}

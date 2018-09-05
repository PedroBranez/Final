package categoría.control;

import categoría.entity.Categoría;
import categoría.entity.NoExisteCategoría;

public class Categorías {

	private Categoría[] categorías;
	private int cantidad;
	private int último;

	public Categorías(int tamaño) {
		categorías = new Categoría[tamaño];
		cantidad = 0;
		último = -1;
	}

	/****************************
	 * Ingresar una Categoría    *
	 ****************************/
	
	public void ingresar(Categoría Categoría) throws  java.lang.ArrayIndexOutOfBoundsException{
		
		categorías[++último] = Categoría;
		cantidad++;
	}

	/****************************
	 * Devuelve la cantidad de  *
	 * elementos                *
	 ****************************/
	
	
	public int getCantidad() {
		return cantidad;
	}
	

	/****************************
	 * Eliminar una Categoría     
	 * @throws NoExisteCategoría *
	 ****************************/
	
	public void eliminar(int codCategoría) throws NoExisteCategoría {
		int índice;
		índice = buscar(codCategoría);

			if (índice != último) {
				for (int i = índice; i <= último; i++) {
					categorías[i] = categorías[i + 1];
				}
			}
			último--;
			cantidad--;
	}
	
	
	/****************************
	 * Buscar una   Categoría     
	 * @throws NoExisteCategoría *
	 ****************************/

	public int buscar(int codCategoría) throws NoExisteCategoría {
		int índice = -1;
		for (int i = 0; i <= último; i++) {
			if (codCategoría == categorías[i].getCodCategoría()) {
				índice = i;
			}
		}
		if (índice == -1) {
			throw new NoExisteCategoría();
		}
		return índice;
	}
	
	
	/****************************
	 * Devuelve el vector de    * 
	 * Categorías                *
	 ****************************/

	public Categoría[] getCategorías() {
		return categorías;
	}
}

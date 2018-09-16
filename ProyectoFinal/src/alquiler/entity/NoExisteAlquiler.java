package alquiler.entity;

public class NoExisteAlquiler  extends Exception {
	private static final long serialVersionUID = 1L;

	public NoExisteAlquiler() {
		super("No existe el Alquiler");
	}



}

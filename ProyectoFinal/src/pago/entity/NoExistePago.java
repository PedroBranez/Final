package pago.entity;

public class NoExistePago  extends Exception {
	private static final long serialVersionUID = 1L;

	public NoExistePago() {
		super("No existe el pago");
	}

}

package expensa.entity;

public class NoExisteExpensa extends Exception {
		private static final long serialVersionUID = 1L;

		public NoExisteExpensa() {
			super("No existe la Expensa");
		}



}

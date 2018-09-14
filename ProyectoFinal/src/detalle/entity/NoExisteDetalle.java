package detalle.entity;

public class NoExisteDetalle extends Exception {
		private static final long serialVersionUID = 1L;

		public NoExisteDetalle() {
			super("No existe la Detalle");
		}



}

package detalle.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import control.Conexi�n;
import detalle.entity.Detalle;
import detalle.entity.NoExisteDetalle;
import view.InputTypes;


public class DetallesIO {
	
	private Conexi�n conexi�n;
	private Scanner scanner;

	/****************************
	 * Constructor *
	 ****************************/

	public DetallesIO(Conexi�n conexi�n, Scanner scanner) {
		this.conexi�n = conexi�n;
		this.scanner = scanner;
	}

	/****************************
	 * Agregar Expensas *
	 ****************************/

	public void add() {
		Detalle detalle = DetalleIO.ingresar(scanner);
		String sql = "Insert into detalle (nroAlquiler, nroOficina, precioOficina) " + 
		"values(?,?,?)";
		try {
			conexi�n.consulta(sql);
			conexi�n.getSentencia().setDouble(1, detalle.getNroAlquiler());
			conexi�n.getSentencia().setDouble(2, detalle.getNroOficina());
			conexi�n.getSentencia().setDouble(3, detalle.getPrecioOficina());
			conexi�n.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
			System.out.println("Algo falla");
		}
	}

	/****************************
	 * Eliminar expensas
	 * 
	 * @throws SQLException*
	 ****************************/

	public void delete() throws SQLException {
		int nroAlquiler = InputTypes.readInt("N�mero de alquiler del detalle a eliminar: ", scanner);
		String sql = "delete " + "from detalle " + "where nroAlquiler = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, nroAlquiler);
		conexi�n.modificacion();
	}

	/****************************
	 * Modificar expensas
	 * 
	 * @throws SQLException *
	 ****************************/

	public void update() throws NoExisteDetalle, SQLException {
		ResultSet resultSet;
		Detalle detalle;
		int nroDetalle;
		int nroOficina;
		double precioOficina;
		
		int nroAlquiler = InputTypes.readInt("N�mero de Alquiler del Detalle: ", scanner);
		String sql = "select * from detalle where nroAlquiler = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, nroAlquiler);
		resultSet = conexi�n.resultado();
		if (resultSet.next()) {
			nroDetalle = resultSet.getInt("nroDetalle");
			nroOficina = resultSet.getInt("nroOficina");
			precioOficina = resultSet.getInt("precioOficina");
			detalle = new Detalle(nroDetalle, nroAlquiler, nroOficina, precioOficina);
		} else {
			throw new NoExisteDetalle();
		}

		System.out.println(detalle);
		Men�.men�Modificar(scanner, detalle);

		sql = "update detalle set nroOficina = ?, precioOficina = ? "
				+ "where nroAlquiler = ?";

		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, detalle.getNroOficina());
		conexi�n.getSentencia().setDouble(2, detalle.getPrecioOficina());
		conexi�n.getSentencia().setInt(3, detalle.getNroAlquiler());
		conexi�n.modificacion();
	}

	/****************************
	 * Listar oficinas
	 * 
	 ****************************/

	
	public void list() throws SQLException {
		Detalle detalle;
		String sql = "select * from detalle ";
		conexi�n.consulta(sql);
		ResultSet resultSet = conexi�n.resultado();
		while (resultSet.next()) {
			detalle = new Detalle(resultSet.getInt("nroDetalle"), resultSet.getInt("nroAlquiler"), 
					resultSet.getInt("nroOficina"), resultSet.getDouble("precioOficina"));
			System.out.println(detalle);
		}
	}
}

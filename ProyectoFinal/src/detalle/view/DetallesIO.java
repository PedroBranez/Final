package detalle.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import control.Conexión;
import detalle.entity.Detalle;
import detalle.entity.NoExisteDetalle;
import view.InputTypes;


public class DetallesIO {
	
	private Conexión conexión;
	private Scanner scanner;

	/****************************
	 * Constructor *
	 ****************************/

	public DetallesIO(Conexión conexión, Scanner scanner) {
		this.conexión = conexión;
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
			conexión.consulta(sql);
			conexión.getSentencia().setDouble(1, detalle.getNroAlquiler());
			conexión.getSentencia().setDouble(2, detalle.getNroOficina());
			conexión.getSentencia().setDouble(3, detalle.getPrecioOficina());
			conexión.modificacion();
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
		int nroAlquiler = InputTypes.readInt("Número de alquiler del detalle a eliminar: ", scanner);
		String sql = "delete " + "from detalle " + "where nroAlquiler = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, nroAlquiler);
		conexión.modificacion();
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
		
		int nroAlquiler = InputTypes.readInt("Número de Alquiler del Detalle: ", scanner);
		String sql = "select * from detalle where nroAlquiler = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, nroAlquiler);
		resultSet = conexión.resultado();
		if (resultSet.next()) {
			nroDetalle = resultSet.getInt("nroDetalle");
			nroOficina = resultSet.getInt("nroOficina");
			precioOficina = resultSet.getInt("precioOficina");
			detalle = new Detalle(nroDetalle, nroAlquiler, nroOficina, precioOficina);
		} else {
			throw new NoExisteDetalle();
		}

		System.out.println(detalle);
		Menú.menúModificar(scanner, detalle);

		sql = "update detalle set nroOficina = ?, precioOficina = ? "
				+ "where nroAlquiler = ?";

		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, detalle.getNroOficina());
		conexión.getSentencia().setDouble(2, detalle.getPrecioOficina());
		conexión.getSentencia().setInt(3, detalle.getNroAlquiler());
		conexión.modificacion();
	}

	/****************************
	 * Listar oficinas
	 * 
	 ****************************/

	
	public void list() throws SQLException {
		Detalle detalle;
		String sql = "select * from detalle ";
		conexión.consulta(sql);
		ResultSet resultSet = conexión.resultado();
		while (resultSet.next()) {
			detalle = new Detalle(resultSet.getInt("nroDetalle"), resultSet.getInt("nroAlquiler"), 
					resultSet.getInt("nroOficina"), resultSet.getDouble("precioOficina"));
			System.out.println(detalle);
		}
	}
}

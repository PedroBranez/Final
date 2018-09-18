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
	 * Agregar Detalle *
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
			System.out.println(e);
		}
	}

	/****************************
	 * Eliminar Detalle
	 * 
	 * @throws SQLException*
	 ****************************/

	public void delete() throws SQLException {
		int nroDetalle = InputTypes.readInt("Número del detalle a eliminar: ", scanner);
		String sql = "delete " + "from detalle " + "where nroDetalle = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, nroDetalle);
		conexión.modificacion();
	}

	/****************************
	 * Modificar Detalle
	 * 
	 * @throws NoExisteDetalle *
	 * @throws SQLException *
	 ****************************/

	public void update() throws NoExisteDetalle, SQLException {
		ResultSet resultSet;
		Detalle detalle;
		int nroAlquiler;
		int nroOficina;
		double precioOficina;
		
		int nroDetalle = InputTypes.readInt("Número del Detalle: ", scanner);
		String sql = "select * from detalle where nroDetalle = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, nroDetalle);
		resultSet = conexión.resultado();
		if (resultSet.next()) {
			nroAlquiler = resultSet.getInt("nroAlquiler");
			nroOficina = resultSet.getInt("nroOficina");
			precioOficina = resultSet.getInt("precioOficina");
			detalle = new Detalle(nroDetalle, nroAlquiler, nroOficina, precioOficina);
		} else {
			throw new NoExisteDetalle();
		}

		System.out.println(detalle);
		Menú.menúModificar(scanner, detalle);

		sql = "update detalle set nroAlquiler = ?, nroOficina = ?, precioOficina = ? "
				+ "where nroDetalle = ?";

		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, detalle.getNroAlquiler());
		conexión.getSentencia().setInt(2, detalle.getNroOficina());
		conexión.getSentencia().setDouble(3, detalle.getPrecioOficina());
		conexión.getSentencia().setInt(4, detalle.getNroDetalle());
		conexión.modificacion();
	}

	/****************************
	 * Listar Detalles
	 * 
	 * @throws SQLException
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

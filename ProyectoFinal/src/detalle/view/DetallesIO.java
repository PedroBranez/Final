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
	 * Agregar Detalle *
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
			System.out.println(e);
		}
	}

	/****************************
	 * Eliminar Detalle
	 * 
	 * @throws SQLException*
	 ****************************/

	public void delete() throws SQLException {
		int nroDetalle = InputTypes.readInt("N�mero del detalle a eliminar: ", scanner);
		String sql = "delete " + "from detalle " + "where nroDetalle = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, nroDetalle);
		conexi�n.modificacion();
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
		
		int nroDetalle = InputTypes.readInt("N�mero del Detalle: ", scanner);
		String sql = "select * from detalle where nroDetalle = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, nroDetalle);
		resultSet = conexi�n.resultado();
		if (resultSet.next()) {
			nroAlquiler = resultSet.getInt("nroAlquiler");
			nroOficina = resultSet.getInt("nroOficina");
			precioOficina = resultSet.getInt("precioOficina");
			detalle = new Detalle(nroDetalle, nroAlquiler, nroOficina, precioOficina);
		} else {
			throw new NoExisteDetalle();
		}

		System.out.println(detalle);
		Men�.men�Modificar(scanner, detalle);

		sql = "update detalle set nroAlquiler = ?, nroOficina = ?, precioOficina = ? "
				+ "where nroDetalle = ?";

		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, detalle.getNroAlquiler());
		conexi�n.getSentencia().setInt(2, detalle.getNroOficina());
		conexi�n.getSentencia().setDouble(3, detalle.getPrecioOficina());
		conexi�n.getSentencia().setInt(4, detalle.getNroDetalle());
		conexi�n.modificacion();
	}

	/****************************
	 * Listar Detalles
	 * 
	 * @throws SQLException
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

package alquiler.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import alquiler.entity.Alquiler;
import alquiler.entity.NoExisteAlquiler;
import control.Conexión;
import pago.entity.Pago;
import view.InputTypes;

public class AlquileresIO {
	private Conexión conexión;
	private Scanner scanner;
	/****************************
	 * Constructor *
	 ****************************/

	public AlquileresIO(Conexión conexión, Scanner scanner) {
		this.conexión = conexión;
		this.scanner = scanner;
	}

	/****************************
	 * Agregar Alquiler *
	 ****************************/

	public void add() {
		Alquiler alquiler = AlquilerIO.ingresar(scanner);
		String sql = "Insert into alquiler (nroInquilino, fecha) " + "values(?,?)";
		try {
			conexión.consulta(sql);
			conexión.getSentencia().setInt(1, alquiler.getNroInquilino());
			conexión.getSentencia().setString(2, alquiler.getFecha());
			conexión.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}

	/****************************
	 * Eliminar Alquiler
	 * 
	 * @throws SQLException *
	 ****************************/

	public void delete() throws SQLException {
		int nroAlquiler = InputTypes.readInt("Número de Alquiler: ", scanner);
		String sql = "delete " + "from alquiler " + "where nroAlquiler = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, nroAlquiler);
		conexión.modificacion();
	}

	/****************************
	 * Modificar Alquiler
	 * 
	 * @throws SQLException *
	 ****************************/

	public void update() throws NoExisteAlquiler, SQLException {
		ResultSet resultSet;
		Alquiler alquiler;
		int nroInquilino;
		String fecha;
		int nroAlquiler = InputTypes.readInt("Número de Alquiler: ", scanner);
		String sql = "select * from alquiler where nroAlquiler = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, nroAlquiler);
		resultSet = conexión.resultado();
		if (resultSet.next()) {
			nroInquilino = resultSet.getInt("nroInquilino");
			fecha = resultSet.getString("fecha");
			alquiler = new Alquiler(nroAlquiler, nroInquilino, fecha);
		} else {
			throw new NoExisteAlquiler();
		}

		System.out.println(alquiler);
		Menú.menúModificar(scanner, alquiler);

		sql = "update alquiler set nroInquilino = ?, fecha = ? "
				+ " where nroAlquiler = ?";

		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, alquiler.getNroInquilino());
		conexión.getSentencia().setString(2, alquiler.getFecha());
		conexión.getSentencia().setInt(3, alquiler.getNroAlquiler());
		conexión.modificacion();
	}

	/****************************
	 * Listar Pagos
	 * 
	 ****************************/

	public void list() throws SQLException {
		Alquiler alquiler;
		String sql = "select * from alquiler ";
		conexión.consulta(sql);
		ResultSet resultSet = conexión.resultado();
		while (resultSet.next()) {
			alquiler = new Alquiler(resultSet.getInt("nroAlquiler"), resultSet.getInt("nroInquilino"),
					resultSet.getString("fecha"));
			System.out.println(alquiler);
		}
	}

	/****************************
	 * Listar Pagos .
	 * 
	 * @throws NoExisteTitular
	 * @throws SQLException *
	 ****************************/

	public void listPagos() throws NoExisteAlquiler, SQLException {
		ResultSet resultSet;
		Alquiler alquiler;
		int nroInquilino;
		String fecha;
		int nroAlquiler = InputTypes.readInt("Número de Alquiler: ", scanner);
		String sql = "select * from alquiler where nroAlquiler = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, nroAlquiler);
		resultSet = conexión.resultado();
		if (resultSet.next()) {
			nroInquilino = resultSet.getInt("nroInquilino");
			fecha = resultSet.getString("fecha");
			alquiler = new Alquiler(nroAlquiler, nroInquilino, fecha);
		} else {
			throw new NoExisteAlquiler();
		}
		System.out.println(alquiler);

		Pago pago;
		int nroPago;
		String fechaPago;
		double monto;

		String sql1 = "select * from pago where nroAlquiler = ?";
		conexión.consulta(sql1);
		conexión.getSentencia().setInt(1, nroAlquiler);
		resultSet = conexión.resultado();
		while (resultSet.next()) {
			nroPago = resultSet.getInt("nroPago");
			nroAlquiler = resultSet.getInt("nroAlquiler");
			fechaPago = resultSet.getString("fechaPago");
			monto = resultSet.getDouble("monto");
			pago = new Pago(nroPago, nroAlquiler, fechaPago, monto);
			System.out.println(pago);
		} // else {
			// throw new NoExisteAlquiler();
			// }
	}
}

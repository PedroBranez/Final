package alquiler.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import alquiler.entity.Alquiler;
import alquiler.entity.NoExisteAlquiler;
import control.Conexi�n;
import pago.entity.Pago;
import view.InputTypes;

public class AlquileresIO {
	private Conexi�n conexi�n;
	private Scanner scanner;
	/****************************
	 * Constructor *
	 ****************************/

	public AlquileresIO(Conexi�n conexi�n, Scanner scanner) {
		this.conexi�n = conexi�n;
		this.scanner = scanner;
	}

	/****************************
	 * Agregar Alquiler *
	 ****************************/

	public void add() {
		Alquiler alquiler = AlquilerIO.ingresar(scanner);
		String sql = "Insert into alquiler (nroInquilino, fecha) " + "values(?,?)";
		try {
			conexi�n.consulta(sql);
			conexi�n.getSentencia().setInt(1, alquiler.getNroInquilino());
			conexi�n.getSentencia().setString(2, alquiler.getFecha());
			conexi�n.modificacion();
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
		int nroAlquiler = InputTypes.readInt("N�mero de Alquiler: ", scanner);
		String sql = "delete " + "from alquiler " + "where nroAlquiler = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, nroAlquiler);
		conexi�n.modificacion();
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
		int nroAlquiler = InputTypes.readInt("N�mero de Alquiler: ", scanner);
		String sql = "select * from alquiler where nroAlquiler = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, nroAlquiler);
		resultSet = conexi�n.resultado();
		if (resultSet.next()) {
			nroInquilino = resultSet.getInt("nroInquilino");
			fecha = resultSet.getString("fecha");
			alquiler = new Alquiler(nroAlquiler, nroInquilino, fecha);
		} else {
			throw new NoExisteAlquiler();
		}

		System.out.println(alquiler);
		Men�.men�Modificar(scanner, alquiler);

		sql = "update alquiler set nroInquilino = ?, fecha = ? "
				+ " where nroAlquiler = ?";

		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, alquiler.getNroInquilino());
		conexi�n.getSentencia().setString(2, alquiler.getFecha());
		conexi�n.getSentencia().setInt(3, alquiler.getNroAlquiler());
		conexi�n.modificacion();
	}

	/****************************
	 * Listar Pagos
	 * 
	 ****************************/

	public void list() throws SQLException {
		Alquiler alquiler;
		String sql = "select * from alquiler ";
		conexi�n.consulta(sql);
		ResultSet resultSet = conexi�n.resultado();
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
		int nroAlquiler = InputTypes.readInt("N�mero de Alquiler: ", scanner);
		String sql = "select * from alquiler where nroAlquiler = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, nroAlquiler);
		resultSet = conexi�n.resultado();
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
		conexi�n.consulta(sql1);
		conexi�n.getSentencia().setInt(1, nroAlquiler);
		resultSet = conexi�n.resultado();
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

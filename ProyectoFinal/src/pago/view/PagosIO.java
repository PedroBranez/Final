package pago.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import control.Conexión;
import pago.entity.NoExistePago;
import pago.entity.Pago;
import view.InputTypes;

public class PagosIO {
	private Conexión conexión;
	private Scanner scanner;

	/****************************
	 * Constructor *
	 ****************************/

	public PagosIO(Conexión conexión, Scanner scanner) {
		this.conexión = conexión;
		this.scanner = scanner;
	}

	/****************************
	 * Agregar Pago *
	 ****************************/

	public void add() {
		Pago pago = PagoIO.ingresar(scanner);
		String sql = "Insert into pago (nroAlquiler, fechaPago, monto) " + "values(?,?,?)";
		try {
			conexión.consulta(sql);
			conexión.getSentencia().setInt(1, pago.getNroAlquiler());
			conexión.getSentencia().setString(2, pago.getFechaPago());
			conexión.getSentencia().setDouble(3, pago.getMonto());
			conexión.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}

	/****************************
	 * Eliminar Pago
	 * 
	 * @throws SQLException *
	 ****************************/

	public void delete() throws SQLException {
		int nroPago = InputTypes.readInt("Número de Pago: ", scanner);
		String sql = "delete " + "from pago " + "where nroPago = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, nroPago);
		conexión.modificacion();
	}

	/****************************
	 * Modificar Pagos
	 * 
	 * @throws SQLException *
	 ****************************/

	public void update() throws NoExistePago, SQLException {
		ResultSet resultSet;
		Pago pago;
		int nroAlquiler;
		String fechaPago;
		Double monto;
		int nroPago = InputTypes.readInt("Número de pago: ", scanner);
		String sql = "select * from pago where nroPago = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, nroPago);
		resultSet = conexión.resultado();
		if (resultSet.next()) {
			nroAlquiler = resultSet.getInt("nroAlquiler");
			fechaPago = resultSet.getString("fechaPago");
			monto = resultSet.getDouble("monto");
			pago = new Pago(nroPago, nroAlquiler, fechaPago, monto);
		} else {
			throw new NoExistePago();
		}

		System.out.println(pago);
		Menú.menúModificar(scanner, pago);

		sql = "update pago set nroAlquiler = ?, fechaPago = ?, monto = ?"
				+ " where nroPago = ?";

		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, pago.getNroAlquiler());
		conexión.getSentencia().setString(2, pago.getFechaPago());
		conexión.getSentencia().setDouble(3, pago.getMonto());
		conexión.getSentencia().setInt(4, pago.getNroPago());
		conexión.modificacion();
	}

	/****************************
	 * Listar Pagos
	 * 
	 ****************************/

	public void list() throws SQLException {
		Pago pago;
		String sql = "select * from pago ";
		conexión.consulta(sql);
		ResultSet resultSet = conexión.resultado();
		while (resultSet.next()) {
			pago = new Pago(resultSet.getInt("nroPago"), resultSet.getInt("nroAlquiler"),
					resultSet.getString("fechaPago"), resultSet.getDouble("monto"));
			System.out.println(pago);
		}
	}

	/****************************
	 * Listar Pagos .
	 * 
	 * @throws NoExisteTitular
	 * @throws SQLException *
	 ****************************/

}

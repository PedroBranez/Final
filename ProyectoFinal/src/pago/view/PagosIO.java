package pago.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import control.Conexi�n;
import pago.entity.NoExistePago;
import pago.entity.Pago;
import view.InputTypes;

public class PagosIO {
	private Conexi�n conexi�n;
	private Scanner scanner;

	/****************************
	 * Constructor *
	 ****************************/

	public PagosIO(Conexi�n conexi�n, Scanner scanner) {
		this.conexi�n = conexi�n;
		this.scanner = scanner;
	}

	/****************************
	 * Agregar Pago *
	 ****************************/

	public void add() {
		Pago pago = PagoIO.ingresar(scanner);
		String sql = "Insert into pago (nroAlquiler, fechaPago, monto) " + "values(?,?,?)";
		try {
			conexi�n.consulta(sql);
			conexi�n.getSentencia().setInt(1, pago.getNroAlquiler());
			conexi�n.getSentencia().setString(2, pago.getFechaPago());
			conexi�n.getSentencia().setDouble(3, pago.getMonto());
			conexi�n.modificacion();
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
		int nroPago = InputTypes.readInt("N�mero de Pago: ", scanner);
		String sql = "delete " + "from pago " + "where nroPago = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, nroPago);
		conexi�n.modificacion();
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
		int nroPago = InputTypes.readInt("N�mero de pago: ", scanner);
		String sql = "select * from pago where nroPago = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, nroPago);
		resultSet = conexi�n.resultado();
		if (resultSet.next()) {
			nroAlquiler = resultSet.getInt("nroAlquiler");
			fechaPago = resultSet.getString("fechaPago");
			monto = resultSet.getDouble("monto");
			pago = new Pago(nroPago, nroAlquiler, fechaPago, monto);
		} else {
			throw new NoExistePago();
		}

		System.out.println(pago);
		Men�.men�Modificar(scanner, pago);

		sql = "update pago set nroAlquiler = ?, fechaPago = ?, monto = ?"
				+ " where nroPago = ?";

		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, pago.getNroAlquiler());
		conexi�n.getSentencia().setString(2, pago.getFechaPago());
		conexi�n.getSentencia().setDouble(3, pago.getMonto());
		conexi�n.getSentencia().setInt(4, pago.getNroPago());
		conexi�n.modificacion();
	}

	/****************************
	 * Listar Pagos
	 * 
	 ****************************/

	public void list() throws SQLException {
		Pago pago;
		String sql = "select * from pago ";
		conexi�n.consulta(sql);
		ResultSet resultSet = conexi�n.resultado();
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

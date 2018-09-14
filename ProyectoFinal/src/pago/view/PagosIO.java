package pago.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import alquiler.entity.Alquiler;
import alquiler.entity.NoExisteAlquiler;
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
 * Agregar Inquilinos *
 ****************************/

public void add() {
	Pago pago = PagoIO.ingresar(scanner);
	String sql = "Insert into pago (CI, nombre, teléfono, dirección, NIT) " + "values(?,?,?,?,?)";
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
 * Eliminar Inquilinos
 * 
 * @throws SQLException
 * 
 * @throws NoExisteTitular *
 ****************************/

public void delete() throws SQLException {
	int nroPago = InputTypes.readInt("Número de Pago: ", scanner);
	String sql = "delete " + "from pago " + "where nroPago = ?";
	conexión.consulta(sql);
	conexión.getSentencia().setInt(1, nroPago);
	conexión.modificacion();
}

/****************************
 * Modificar Inquilinos
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
		pago = new Pago(nroPago, nroAlquiler ,fechaPago, monto);
	} else {
		throw new NoExistePago();
	}

	System.out.println(pago);
	Menú.menúModificar(scanner, pago);

	sql = "update pago set nroAlquiler = ?, fechaPago = ?, monto = ?";

	conexión.consulta(sql);
	conexión.getSentencia().setInt(1, pago.getNroAlquiler());
	conexión.getSentencia().setString(2, pago.getFechaPago());
	conexión.getSentencia().setDouble(3, pago.getMonto());
	conexión.getSentencia().setInt(4, pago.getNroPago());
	conexión.modificacion();
}

/****************************
 * Listar Inquilinos
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
 * Listar Oficinas .
 * 
 * @throws NoExisteTitular
 * @throws SQLException *
 ****************************/

public void listAlquiler() throws NoExistePago,NoExisteAlquiler, SQLException {
	ResultSet resultSet;
	Pago pago;
	int nroAlquiler;
	String fechaPago;
	Double monto;
	int nroPago = InputTypes.readInt("Número de Pago: ", scanner);
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

	Alquiler alquiler;
	int nroInquilino;
	String fecha;

	String sql1 = "select * from pago where nroAlquiler = ?";
	conexión.consulta(sql1);
	conexión.getSentencia().setInt(1, nroAlquiler);
	resultSet = conexión.resultado();
	while (resultSet.next()) {
		nroAlquiler = resultSet.getInt("nroAlquiler");
		nroInquilino = resultSet.getInt("nroInquilino");
		fecha = resultSet.getString("fecha");
		alquiler = new Alquiler(nroAlquiler, nroInquilino, fecha);
		System.out.println(alquiler);
	} //else {
		//throw new NoExisteAlquiler();
	//}
}


}


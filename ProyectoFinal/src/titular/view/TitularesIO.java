package titular.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import control.Conexi�n;
import titular.entity.NoExisteTitular;
import titular.entity.Titular;
import view.InputTypes;

public class TitularesIO {
	private Conexi�n conexi�n;
	private Scanner scanner;

	/****************************
	 * Constructor *
	 ****************************/

	public TitularesIO(Conexi�n conexi�n, Scanner scanner) {
		this.conexi�n = conexi�n;
		this.scanner = scanner;
	}

	/****************************
	 * Agregar titulares *
	 ****************************/

	public void add() {
		Titular titular = TitularIO.ingresar(scanner);
		String sql = "Insert into Titular (CI, nombre, tel�fono, direcci�n, NIT) " + "values(?,?,?,?,?)";
		try {
			conexi�n.consulta(sql);
			conexi�n.getSentencia().setInt(1, titular.getCI());
			conexi�n.getSentencia().setString(2, titular.getNombre());
			conexi�n.getSentencia().setInt(3, titular.getTel�fono());
			conexi�n.getSentencia().setString(4, titular.getDirecci�n());
			conexi�n.getSentencia().setInt(5, titular.getNIT());
			conexi�n.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}

	/****************************
	 * Eliminar categor�as
	 * 
	 * @throws SQLException
	 * 
	 * @throws NoExisteTitular *
	 ****************************/

	public void delete() throws SQLException {
		int nroTitular = InputTypes.readInt("N�mero de titular: ", scanner);
		String sql = "delete " + "from titular " + "where c�digo = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, nroTitular);
		conexi�n.modificacion();
	}

	/****************************
	 * Modificar categor�as
	 * 
	 * @throws SQLException *
	 ****************************/

	/*public void update() throws NoExisteCategor�a, SQLException {
		ResultSet resultSet;
		Titular titular;
		int CI;
		String nombre;
		int tel�fono;
		String direcci�n;
		int NIT;
		int nroTitular = InputTypes.readInt("N�mero de Titular: ", scanner);
		String sql = "select * from titular where c�digo = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, nroTitular);
		resultSet = conexi�n.resultado();
		if (resultSet.next()) {
			CI = resultSet.getInt("CI");
			nombre = resultSet.getString("nombre");
			tel�fono = resultSet.getInt("tel�fono");
			direcci�n = resultSet.getString("direcci�n");
			NIT = resultSet.getInt("NIT");
			titular = new Titular(nroTitular, CI, nombre, tel�fono, direcci�n, NIT);
		} else {
			throw new NoExisteCategor�a();
		}

		System.out.println(titular);
		Men�.men�Modificar(scanner, titular);

		sql = "update categor�a set nombre = ?, descripci�n = ? where c�digo = ?";

		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, titular.getCI());
		conexi�n.getSentencia().setString(2, titular.getNombre());
		conexi�n.getSentencia().setInt(3, titular.getTel�fono());
		conexi�n.getSentencia().setString(4, titular.getDirecci�n());
		conexi�n.getSentencia().setInt(5, titular.getNIT());
		conexi�n.modificacion();
	}*/

	/****************************
	 * Listar categor�as
	 * 
	 ****************************/

	public void list() throws SQLException {
		Titular titular;
		String sql = "select * from categor�a ";
		conexi�n.consulta(sql);
		ResultSet resultSet = conexi�n.resultado();
		while (resultSet.next()) {
			titular = new Titular(resultSet.getInt("nroTitular"), resultSet.getInt("CI"),
					resultSet.getString("nombre"), resultSet.getInt("tel�fono"),
					resultSet.getString("direcci�n"), resultSet.getInt("NIT"));
			System.out.println(titular);
		}
	}

	/****************************
	 * Listar categor�as .
	 * 
	 * @throws NoExisteCategor�a
	 * @throws SQLException *
	 ****************************/
/*
	public void listProducts() throws NoExisteCategor�a, SQLException {
		ResultSet resultSet;
		Titular titular;
		int CI;
		String nombre;
		int tel�fono;
		String direcci�n;
		int NIT;
		int nroTitular = InputTypes.readInt("N�mero de Titular: ", scanner);
		String sql = "select * from titular where nroTitular = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, nroTitular);
		resultSet = conexi�n.resultado();
		if (resultSet.next()) {
			CI = resultSet.getInt("CI");
			nombre = resultSet.getString("nombre");
			tel�fono = resultSet.getInt("tel�fono");
			direcci�n = resultSet.getString("direcci�n");
			NIT = resultSet.getInt("NIT");
			titular = new Titular(nroTitular, CI, nombre, tel�fono, direcci�n, NIT);
		} else {
			throw new NoExisteCategor�a();
		}
		System.out.println(titular);

		Producto producto;
		Double precio;
		int codProducto;

		sql = "select * from producto where c�digoCategor�a = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, codCategor�a);
		resultSet = conexi�n.resultado();
		if (resultSet.next()) {
			codProducto = resultSet.getInt("c�digo");
			nombre = resultSet.getString("nombre");
			descripci�n = resultSet.getString("descripci�n");
			precio = resultSet.getDouble("precio");
			producto = new Producto(codProducto, nombre, precio, descripci�n, codCategor�a);
			System.out.println(producto);
		} else {
			throw new NoExisteCategor�a();
		}

	}
*/
}

package titular.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import control.Conexión;
import titular.entity.NoExisteTitular;
import titular.entity.Titular;
import view.InputTypes;

public class TitularesIO {
	private Conexión conexión;
	private Scanner scanner;

	/****************************
	 * Constructor *
	 ****************************/

	public TitularesIO(Conexión conexión, Scanner scanner) {
		this.conexión = conexión;
		this.scanner = scanner;
	}

	/****************************
	 * Agregar titulares *
	 ****************************/

	public void add() {
		Titular titular = TitularIO.ingresar(scanner);
		String sql = "Insert into Titular (CI, nombre, teléfono, dirección, NIT) " + "values(?,?,?,?,?)";
		try {
			conexión.consulta(sql);
			conexión.getSentencia().setInt(1, titular.getCI());
			conexión.getSentencia().setString(2, titular.getNombre());
			conexión.getSentencia().setInt(3, titular.getTeléfono());
			conexión.getSentencia().setString(4, titular.getDirección());
			conexión.getSentencia().setInt(5, titular.getNIT());
			conexión.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}

	/****************************
	 * Eliminar categorías
	 * 
	 * @throws SQLException
	 * 
	 * @throws NoExisteTitular *
	 ****************************/

	public void delete() throws SQLException {
		int nroTitular = InputTypes.readInt("Número de titular: ", scanner);
		String sql = "delete " + "from titular " + "where código = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, nroTitular);
		conexión.modificacion();
	}

	/****************************
	 * Modificar categorías
	 * 
	 * @throws SQLException *
	 ****************************/

	/*public void update() throws NoExisteCategoría, SQLException {
		ResultSet resultSet;
		Titular titular;
		int CI;
		String nombre;
		int teléfono;
		String dirección;
		int NIT;
		int nroTitular = InputTypes.readInt("Número de Titular: ", scanner);
		String sql = "select * from titular where código = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, nroTitular);
		resultSet = conexión.resultado();
		if (resultSet.next()) {
			CI = resultSet.getInt("CI");
			nombre = resultSet.getString("nombre");
			teléfono = resultSet.getInt("teléfono");
			dirección = resultSet.getString("dirección");
			NIT = resultSet.getInt("NIT");
			titular = new Titular(nroTitular, CI, nombre, teléfono, dirección, NIT);
		} else {
			throw new NoExisteCategoría();
		}

		System.out.println(titular);
		Menú.menúModificar(scanner, titular);

		sql = "update categoría set nombre = ?, descripción = ? where código = ?";

		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, titular.getCI());
		conexión.getSentencia().setString(2, titular.getNombre());
		conexión.getSentencia().setInt(3, titular.getTeléfono());
		conexión.getSentencia().setString(4, titular.getDirección());
		conexión.getSentencia().setInt(5, titular.getNIT());
		conexión.modificacion();
	}*/

	/****************************
	 * Listar categorías
	 * 
	 ****************************/

	public void list() throws SQLException {
		Titular titular;
		String sql = "select * from categoría ";
		conexión.consulta(sql);
		ResultSet resultSet = conexión.resultado();
		while (resultSet.next()) {
			titular = new Titular(resultSet.getInt("nroTitular"), resultSet.getInt("CI"),
					resultSet.getString("nombre"), resultSet.getInt("teléfono"),
					resultSet.getString("dirección"), resultSet.getInt("NIT"));
			System.out.println(titular);
		}
	}

	/****************************
	 * Listar categorías .
	 * 
	 * @throws NoExisteCategoría
	 * @throws SQLException *
	 ****************************/
/*
	public void listProducts() throws NoExisteCategoría, SQLException {
		ResultSet resultSet;
		Titular titular;
		int CI;
		String nombre;
		int teléfono;
		String dirección;
		int NIT;
		int nroTitular = InputTypes.readInt("Número de Titular: ", scanner);
		String sql = "select * from titular where nroTitular = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, nroTitular);
		resultSet = conexión.resultado();
		if (resultSet.next()) {
			CI = resultSet.getInt("CI");
			nombre = resultSet.getString("nombre");
			teléfono = resultSet.getInt("teléfono");
			dirección = resultSet.getString("dirección");
			NIT = resultSet.getInt("NIT");
			titular = new Titular(nroTitular, CI, nombre, teléfono, dirección, NIT);
		} else {
			throw new NoExisteCategoría();
		}
		System.out.println(titular);

		Producto producto;
		Double precio;
		int codProducto;

		sql = "select * from producto where códigoCategoría = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, codCategoría);
		resultSet = conexión.resultado();
		if (resultSet.next()) {
			codProducto = resultSet.getInt("código");
			nombre = resultSet.getString("nombre");
			descripción = resultSet.getString("descripción");
			precio = resultSet.getDouble("precio");
			producto = new Producto(codProducto, nombre, precio, descripción, codCategoría);
			System.out.println(producto);
		} else {
			throw new NoExisteCategoría();
		}

	}
*/
}

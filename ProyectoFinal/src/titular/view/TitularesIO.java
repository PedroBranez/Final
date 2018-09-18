package titular.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import control.Conexión;
import oficina.entity.Oficina;
import oficina.entity.NoExisteOficina;
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
	 * Agregar Titular *
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
			conexión.getSentencia().setString(5, titular.getNIT());
			conexión.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}

	/****************************
	 * Eliminar Titular
	 * 
	 * @throws SQLException *
	 ****************************/

	public void delete() throws SQLException {
		int nroTitular = InputTypes.readInt("Número de titular: ", scanner);
		String sql = "delete " + "from titular " + "where nroTitular = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, nroTitular);
		conexión.modificacion();
	}

	/****************************
	 * Modificar Titular
	 * 
	 * @throws NoExisteTitular *
	 * @throws SQLException *
	 ****************************/

	public void update() throws NoExisteTitular, SQLException {
		ResultSet resultSet;
		Titular titular;
		int CI;
		String nombre;
		int teléfono;
		String dirección;
		String NIT;
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
			NIT = resultSet.getString("NIT");
			titular = new Titular(nroTitular, CI, nombre, teléfono, dirección, NIT);
		} else {
			throw new NoExisteTitular();
		}

		System.out.println(titular);
		Menú.menúModificar(scanner, titular);

		sql = "update titular set CI = ?, nombre = ?, teléfono = ?, dirección = ?, NIT = ? where nroTitular = ?";

		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, titular.getCI());
		conexión.getSentencia().setString(2, titular.getNombre());
		conexión.getSentencia().setInt(3, titular.getTeléfono());
		conexión.getSentencia().setString(4, titular.getDirección());
		conexión.getSentencia().setString(5, titular.getNIT());
		conexión.getSentencia().setInt(6, titular.getNroTitular());
		conexión.modificacion();
	}

	/****************************
	 * Listar Titulares
	 * 
	 * @throws SQLException *
	 ****************************/

	public void list() throws SQLException {
		Titular titular;
		String sql = "select * from titular ";
		conexión.consulta(sql);
		ResultSet resultSet = conexión.resultado();
		while (resultSet.next()) {
			titular = new Titular(resultSet.getInt("nroTitular"), resultSet.getInt("CI"),
					resultSet.getString("nombre"), resultSet.getInt("teléfono"),
					resultSet.getString("dirección"), resultSet.getString("NIT"));
			System.out.println(titular);
		}
	}

	/****************************
	 * Listar Oficinas Titular
	 * 
	 * @throws NoExisteTitular
	 * @throws SQLException *
	 ****************************/

	public void listOficinas() throws NoExisteTitular, NoExisteOficina, SQLException {
		ResultSet resultSet;
		Titular titular;
		int CI;
		String nombre;
		int teléfono;
		String dirección;
		String NIT;
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
			NIT = resultSet.getString("NIT");
			titular = new Titular(nroTitular, CI, nombre, teléfono, dirección, NIT);
		} else {
			throw new NoExisteTitular();
		}
		System.out.println(titular);

		Oficina oficina;
		int nroOficina;
		String nombreO;
		Double dimensión;
		int nroPlanta;
		String estado;

		String sql1 = "select * from oficina where nroTitular = ?";
		conexión.consulta(sql1);
		conexión.getSentencia().setInt(1, nroTitular);
		resultSet = conexión.resultado();
		while (resultSet.next()) {
			nroOficina = resultSet.getInt("nroOficina");
			nombreO = resultSet.getString("nombre");
			dimensión = resultSet.getDouble("dimensión");
			nroPlanta = resultSet.getInt("nroPlanta");
			estado = resultSet.getString("estado");
			oficina = new Oficina(nroOficina, nroTitular, nombreO, dimensión, nroPlanta, estado);
			System.out.println(oficina);
		} 
	}

}

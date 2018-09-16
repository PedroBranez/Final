package titular.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import control.Conexi�n;
import oficina.entity.Oficina;
import oficina.entity.NoExisteOficina;
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
	 * Agregar Titular *
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
			conexi�n.getSentencia().setString(5, titular.getNIT());
			conexi�n.modificacion();
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
		int nroTitular = InputTypes.readInt("N�mero de titular: ", scanner);
		String sql = "delete " + "from titular " + "where nroTitular = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, nroTitular);
		conexi�n.modificacion();
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
		int tel�fono;
		String direcci�n;
		String NIT;
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
			NIT = resultSet.getString("NIT");
			titular = new Titular(nroTitular, CI, nombre, tel�fono, direcci�n, NIT);
		} else {
			throw new NoExisteTitular();
		}

		System.out.println(titular);
		Men�.men�Modificar(scanner, titular);

		sql = "update titular set CI = ?, nombre = ?, tel�fono = ?, direcci�n = ?, NIT = ? where nroTitular = ?";

		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, titular.getCI());
		conexi�n.getSentencia().setString(2, titular.getNombre());
		conexi�n.getSentencia().setInt(3, titular.getTel�fono());
		conexi�n.getSentencia().setString(4, titular.getDirecci�n());
		conexi�n.getSentencia().setString(5, titular.getNIT());
		conexi�n.getSentencia().setInt(6, titular.getNroTitular());
		conexi�n.modificacion();
	}

	/****************************
	 * Listar Titulares
	 * 
	 * @throws SQLException *
	 ****************************/

	public void list() throws SQLException {
		Titular titular;
		String sql = "select * from titular ";
		conexi�n.consulta(sql);
		ResultSet resultSet = conexi�n.resultado();
		while (resultSet.next()) {
			titular = new Titular(resultSet.getInt("nroTitular"), resultSet.getInt("CI"),
					resultSet.getString("nombre"), resultSet.getInt("tel�fono"),
					resultSet.getString("direcci�n"), resultSet.getString("NIT"));
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
		int tel�fono;
		String direcci�n;
		String NIT;
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
			NIT = resultSet.getString("NIT");
			titular = new Titular(nroTitular, CI, nombre, tel�fono, direcci�n, NIT);
		} else {
			throw new NoExisteTitular();
		}
		System.out.println(titular);

		Oficina oficina;
		int nroOficina;
		String nombreO;
		Double dimensi�n;
		int nroPlanta;
		String estado;

		String sql1 = "select * from oficina where nroTitular = ?";
		conexi�n.consulta(sql1);
		conexi�n.getSentencia().setInt(1, nroTitular);
		resultSet = conexi�n.resultado();
		while (resultSet.next()) {
			nroOficina = resultSet.getInt("nroOficina");
			nombreO = resultSet.getString("nombre");
			dimensi�n = resultSet.getDouble("dimensi�n");
			nroPlanta = resultSet.getInt("nroPlanta");
			estado = resultSet.getString("estado");
			oficina = new Oficina(nroOficina, nroTitular, nombreO, dimensi�n, nroPlanta, estado);
			System.out.println(oficina);
		} 
	}

}

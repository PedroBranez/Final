package expensa.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import control.Conexi�n;
import expensa.entity.Expensa;
import expensa.entity.NoExisteExpensa;
import view.InputTypes;

public class ExpensasIO {
	private Conexi�n conexi�n;
	private Scanner scanner;

	/****************************
	 * Constructor *
	 ****************************/

	public ExpensasIO(Conexi�n conexi�n, Scanner scanner) {
		this.conexi�n = conexi�n;
		this.scanner = scanner;
	}

	/****************************
	 * Agregar Expensa *
	 ****************************/

	public void add() {
		Expensa expensa = ExpensaIO.ingresar(scanner);
		String sql = "Insert into expensa (costoTel�fono, costoLuz, costoAgua) " + "values(?,?,?)";
		try {
			conexi�n.consulta(sql);
			conexi�n.getSentencia().setDouble(1, expensa.getCostoTel�fono());
			conexi�n.getSentencia().setDouble(2, expensa.getCostoLuz());
			conexi�n.getSentencia().setDouble(3, expensa.getCostoAgua());
			conexi�n.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}

	/****************************
	 * Eliminar Expensas
	 * 
	 * @throws SQLException*
	 ****************************/

	public void delete() throws SQLException {
		int nroOficina = InputTypes.readInt("N�mero de oficina de la expensa a eliminar: ", scanner);
		String sql = "delete " + "from expensa " + "where nroOficina = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, nroOficina);
		conexi�n.modificacion();
	}

	/****************************
	 * Modificar Expensa
	 * 
	 * @throws NoExisteExpensa *
	 * @throws SQLException *
	 ****************************/

	public void update() throws NoExisteExpensa, SQLException {
		ResultSet resultSet;
		Expensa expensa;
		Double costoTel�fono;
		Double costoLuz;
		Double costoAgua;

		int nroOficina = InputTypes.readInt("N�mero de Oficina de la Expensa: ", scanner);
		String sql = "select * from expensa where nroOficina = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, nroOficina);
		resultSet = conexi�n.resultado();
		if (resultSet.next()) {
			costoTel�fono = resultSet.getDouble("costoTel�fono");
			costoLuz = resultSet.getDouble("costoLuz");
			costoAgua = resultSet.getDouble("costoAgua");
			expensa = new Expensa(nroOficina, costoTel�fono, costoLuz, costoAgua);
		} else {
			throw new NoExisteExpensa();
		}

		System.out.println(expensa);
		Men�.men�Modificar(scanner, expensa);

		sql = "update expensa set costoTel�fono = ?, costoLuz = ?, costoAgua = ? " + "where nroOficina = ?";

		conexi�n.consulta(sql);
		conexi�n.getSentencia().setDouble(1, expensa.getCostoTel�fono());
		conexi�n.getSentencia().setDouble(2, expensa.getCostoLuz());
		conexi�n.getSentencia().setDouble(3, expensa.getCostoAgua());
		conexi�n.getSentencia().setInt(4, expensa.getNroOficina());
		conexi�n.modificacion();
	}

	/****************************
	 * Listar Expensas
	 * 
	 * @throws SQLException *
	 ****************************/

	public void list() throws SQLException {
		Expensa expensa;
		String sql = "select * from expensa ";
		conexi�n.consulta(sql);
		ResultSet resultSet = conexi�n.resultado();
		while (resultSet.next()) {
			expensa = new Expensa(resultSet.getInt("nroOficina"), resultSet.getDouble("costoTel�fono"),
					resultSet.getDouble("costoLuz"), resultSet.getDouble("costoAgua"));
			System.out.println(expensa);
		}
	}
}

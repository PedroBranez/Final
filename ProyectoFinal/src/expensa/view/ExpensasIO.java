package expensa.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import control.Conexión;
import expensa.entity.Expensa;
import expensa.entity.NoExisteExpensa;
import view.InputTypes;

public class ExpensasIO {
	private Conexión conexión;
	private Scanner scanner;

	/****************************
	 * Constructor *
	 ****************************/

	public ExpensasIO(Conexión conexión, Scanner scanner) {
		this.conexión = conexión;
		this.scanner = scanner;
	}

	/****************************
	 * Agregar Expensa *
	 ****************************/

	public void add() {
		Expensa expensa = ExpensaIO.ingresar(scanner);
		String sql = "Insert into expensa (costoTeléfono, costoLuz, costoAgua) " + "values(?,?,?)";
		try {
			conexión.consulta(sql);
			conexión.getSentencia().setDouble(1, expensa.getCostoTeléfono());
			conexión.getSentencia().setDouble(2, expensa.getCostoLuz());
			conexión.getSentencia().setDouble(3, expensa.getCostoAgua());
			conexión.modificacion();
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
		int nroOficina = InputTypes.readInt("Número de oficina de la expensa a eliminar: ", scanner);
		String sql = "delete " + "from expensa " + "where nroOficina = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, nroOficina);
		conexión.modificacion();
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
		Double costoTeléfono;
		Double costoLuz;
		Double costoAgua;

		int nroOficina = InputTypes.readInt("Número de Oficina de la Expensa: ", scanner);
		String sql = "select * from expensa where nroOficina = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, nroOficina);
		resultSet = conexión.resultado();
		if (resultSet.next()) {
			costoTeléfono = resultSet.getDouble("costoTeléfono");
			costoLuz = resultSet.getDouble("costoLuz");
			costoAgua = resultSet.getDouble("costoAgua");
			expensa = new Expensa(nroOficina, costoTeléfono, costoLuz, costoAgua);
		} else {
			throw new NoExisteExpensa();
		}

		System.out.println(expensa);
		Menú.menúModificar(scanner, expensa);

		sql = "update expensa set costoTeléfono = ?, costoLuz = ?, costoAgua = ? " + "where nroOficina = ?";

		conexión.consulta(sql);
		conexión.getSentencia().setDouble(1, expensa.getCostoTeléfono());
		conexión.getSentencia().setDouble(2, expensa.getCostoLuz());
		conexión.getSentencia().setDouble(3, expensa.getCostoAgua());
		conexión.getSentencia().setInt(4, expensa.getNroOficina());
		conexión.modificacion();
	}

	/****************************
	 * Listar Expensas
	 * 
	 * @throws SQLException *
	 ****************************/

	public void list() throws SQLException {
		Expensa expensa;
		String sql = "select * from expensa ";
		conexión.consulta(sql);
		ResultSet resultSet = conexión.resultado();
		while (resultSet.next()) {
			expensa = new Expensa(resultSet.getInt("nroOficina"), resultSet.getDouble("costoTeléfono"),
					resultSet.getDouble("costoLuz"), resultSet.getDouble("costoAgua"));
			System.out.println(expensa);
		}
	}
}

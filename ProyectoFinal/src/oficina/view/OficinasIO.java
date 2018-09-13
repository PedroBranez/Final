package oficina.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import control.Conexión;
import oficina.entity.NoExisteOficina;
import oficina.entity.Oficina;
import view.InputTypes;

public class OficinasIO {
		private Conexión conexión;
		private Scanner scanner;

		/****************************
		 * Constructor *
		 ****************************/

		public OficinasIO(Conexión conexión, Scanner scanner) {
			this.conexión = conexión;
			this.scanner = scanner;
		}

		/****************************
		 * Agregar Oficinas *
		 ****************************/

		public void add() {
			Oficina oficina = OficinaIO.ingresar(scanner);
			String sql = "Insert into Titular (CI, nombre, teléfono, dirección, NIT) " + "values(?,?,?,?,?)";
			try {
				conexión.consulta(sql);
				conexión.getSentencia().setInt(1, oficina.getNroOficina());
				conexión.getSentencia().setInt(2, oficina.getNroTitular());
				conexión.getSentencia().setDouble(3, oficina.getDimension());
				conexión.getSentencia().setInt(4, oficina.getNroPlanta());
				conexión.getSentencia().setString(5, oficina.getEstado());
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
			int nroOficina = InputTypes.readInt("Número de oficina: ", scanner);
			String sql = "delete " + "from Oficina " + "where código = ?";
			conexión.consulta(sql);
			conexión.getSentencia().setInt(1, nroOficina);
			conexión.modificacion();
		}

		/****************************
		 * Modificar categorías
		 * 
		 * @throws SQLException *
		 ****************************/

		public void update() throws NoExisteOficina, SQLException {
			ResultSet resultSet;
			Oficina oficina;
			int nroTitular;
			Double dimension;
			int nroPlanta;
			String estado;
			
			int nroOficina = InputTypes.readInt("Número de Oficina: ", scanner);
			String sql = "select * from oficina where nroOficina = ?";
			conexión.consulta(sql);
			conexión.getSentencia().setInt(1, nroOficina);
			resultSet = conexión.resultado();
			if (resultSet.next()) {
				nroTitular = resultSet.getInt("numero del Titular");
				dimension = resultSet.getDouble("dimension");
				nroPlanta = resultSet.getInt("numero de planta");
				estado = resultSet.getString("estado");
				oficina = new Oficina(nroOficina, nroTitular, dimension, nroPlanta, estado);
			} else {
				throw new NoExisteOficina();
			}

			System.out.println(oficina);
			Menú.menúModificar(scanner, oficina);

			sql = "update oficina set nroTitular = ?, dimension = ?, nroPlanta = ?, estado = ? where nroOficina = ?";

			conexión.consulta(sql);
			conexión.getSentencia().setInt(1, oficina.getNroTitular());
			conexión.getSentencia().setDouble(2, oficina.getDimension());
			conexión.getSentencia().setInt(3, oficina.getNroPlanta());
			conexión.getSentencia().setString(4, oficina.getEstado());
			conexión.getSentencia().setInt(5, oficina.getNroOficina());
			conexión.modificacion();
		}

		/****************************
		 * Listar categorías
		 * 
		 ****************************/

		public void list() throws SQLException {
			Oficina oficina;
			String sql = "select * from oficina ";
			conexión.consulta(sql);
			ResultSet resultSet = conexión.resultado();
			while (resultSet.next()) {
				oficina = new Oficina(resultSet.getInt("nroOficina"), resultSet.getInt("nroTitular"),
						resultSet.getInt("dimension"), resultSet.getInt("nroPlanta"),
						resultSet.getString("estado"));
				System.out.println(oficina);
			}
		}

		/****************************
		 * Listar Oficinas .
		 * 
		 * @throws NoExisteTitular
		 * @throws SQLException *
		 ****************************/

		public void listOficinasDisponibles() throws NoExisteOficina, SQLException {
			ResultSet resultSet;
			Oficina oficina;
			int nroTitular;
			int dimension;
			int nroPlanta;
			int nroOficina;
			String estado = InputTypes.readString("Estado: ", scanner);
			String sql = "select * from oficina where estado = ?";
			conexión.consulta(sql);
			conexión.getSentencia().setString(1, estado);
			resultSet = conexión.resultado();
			if (resultSet.next()) {
				nroTitular = resultSet.getInt("nroTitular");
				dimension = resultSet.getInt("dimension");
				nroPlanta = resultSet.getInt("nroPlanta");
				nroOficina = resultSet.getInt("nroOficina");
				oficina = new Oficina(nroOficina, nroTitular, dimension, nroPlanta, estado);
			} else {
				throw new NoExisteOficina();
			}
			System.out.println(oficina);

			/*Oficina oficina;
			int nroOficina;
			Double dimension;
			int nroPlanta;
			String estado;

			sql = "select * from oficina where nroTitular = ?";
			conexión.consulta(sql);
			conexión.getSentencia().setInt(1, nroTitular);
			resultSet = conexión.resultado();
			if (resultSet.next()) {
				nroOficina = resultSet.getInt("nroOficina");
				dimension = resultSet.getDouble("dimension");
				nroPlanta = resultSet.getInt("nroPlanta");
				estado = resultSet.getString("estado");
				oficina = new Oficina(nroOficina, nroTitular, dimension, nroPlanta, estado);
				System.out.println(oficina);
			} else {
				throw new NoExisteOficina();
			}
*/
		}



}

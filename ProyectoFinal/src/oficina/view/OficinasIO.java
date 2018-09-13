package oficina.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import control.Conexi�n;
import oficina.entity.NoExisteOficina;
import oficina.entity.Oficina;
import view.InputTypes;

public class OficinasIO {
		private Conexi�n conexi�n;
		private Scanner scanner;

		/****************************
		 * Constructor *
		 ****************************/

		public OficinasIO(Conexi�n conexi�n, Scanner scanner) {
			this.conexi�n = conexi�n;
			this.scanner = scanner;
		}

		/****************************
		 * Agregar Oficinas *
		 ****************************/

		public void add() {
			Oficina oficina = OficinaIO.ingresar(scanner);
			String sql = "Insert into Titular (CI, nombre, tel�fono, direcci�n, NIT) " + "values(?,?,?,?,?)";
			try {
				conexi�n.consulta(sql);
				conexi�n.getSentencia().setInt(1, oficina.getNroOficina());
				conexi�n.getSentencia().setInt(2, oficina.getNroTitular());
				conexi�n.getSentencia().setDouble(3, oficina.getDimension());
				conexi�n.getSentencia().setInt(4, oficina.getNroPlanta());
				conexi�n.getSentencia().setString(5, oficina.getEstado());
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
			int nroOficina = InputTypes.readInt("N�mero de oficina: ", scanner);
			String sql = "delete " + "from Oficina " + "where c�digo = ?";
			conexi�n.consulta(sql);
			conexi�n.getSentencia().setInt(1, nroOficina);
			conexi�n.modificacion();
		}

		/****************************
		 * Modificar categor�as
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
			
			int nroOficina = InputTypes.readInt("N�mero de Oficina: ", scanner);
			String sql = "select * from oficina where nroOficina = ?";
			conexi�n.consulta(sql);
			conexi�n.getSentencia().setInt(1, nroOficina);
			resultSet = conexi�n.resultado();
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
			Men�.men�Modificar(scanner, oficina);

			sql = "update oficina set nroTitular = ?, dimension = ?, nroPlanta = ?, estado = ? where nroOficina = ?";

			conexi�n.consulta(sql);
			conexi�n.getSentencia().setInt(1, oficina.getNroTitular());
			conexi�n.getSentencia().setDouble(2, oficina.getDimension());
			conexi�n.getSentencia().setInt(3, oficina.getNroPlanta());
			conexi�n.getSentencia().setString(4, oficina.getEstado());
			conexi�n.getSentencia().setInt(5, oficina.getNroOficina());
			conexi�n.modificacion();
		}

		/****************************
		 * Listar categor�as
		 * 
		 ****************************/

		public void list() throws SQLException {
			Oficina oficina;
			String sql = "select * from oficina ";
			conexi�n.consulta(sql);
			ResultSet resultSet = conexi�n.resultado();
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
			conexi�n.consulta(sql);
			conexi�n.getSentencia().setString(1, estado);
			resultSet = conexi�n.resultado();
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
			conexi�n.consulta(sql);
			conexi�n.getSentencia().setInt(1, nroTitular);
			resultSet = conexi�n.resultado();
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

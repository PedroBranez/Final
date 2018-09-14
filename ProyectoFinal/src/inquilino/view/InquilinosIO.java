package inquilino.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import alquiler.entity.Alquiler;
import alquiler.entity.NoExisteAlquiler;
import control.Conexi�n;
import inquilino.entity.Inquilino;
import inquilino.entity.NoExisteInquilino;
import view.InputTypes;

public class InquilinosIO {
		private Conexi�n conexi�n;
		private Scanner scanner;

		/****************************
		 * Constructor *
		 ****************************/

		public InquilinosIO(Conexi�n conexi�n, Scanner scanner) {
			this.conexi�n = conexi�n;
			this.scanner = scanner;
		}

		/****************************
		 * Agregar titulares *
		 ****************************/

		public void add() {
			Inquilino inquilino = InquilinoIO.ingresar(scanner);
			String sql = "Insert into Inquilino (CI, nombre, tel�fono, direcci�n, NIT) " + "values(?,?,?,?,?)";
			try {
				conexi�n.consulta(sql);
				conexi�n.getSentencia().setInt(1, inquilino.getCI());
				conexi�n.getSentencia().setString(2, inquilino.getNombre());
				conexi�n.getSentencia().setInt(3, inquilino.getTel�fono());
				conexi�n.getSentencia().setString(4, inquilino.getDirecci�n());
				conexi�n.getSentencia().setString(5, inquilino.getNIT());
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
			int nroInquilino = InputTypes.readInt("N�mero de inquilino: ", scanner);
			String sql = "delete " + "from inquilino " + "where nroInquilino = ?";
			conexi�n.consulta(sql);
			conexi�n.getSentencia().setInt(1, nroInquilino);
			conexi�n.modificacion();
		}

		/****************************
		 * Modificar categor�as
		 * 
		 * @throws SQLException *
		 ****************************/

		public void update() throws NoExisteInquilino, SQLException {
			ResultSet resultSet;
			Inquilino inquilino;
			int CI;
			String nombre;
			int tel�fono;
			String direcci�n;
			String NIT;
			int nroInquilino = InputTypes.readInt("N�mero de Inquilino: ", scanner);
			String sql = "select * from inquilino where nroInquilino = ?";
			conexi�n.consulta(sql);
			conexi�n.getSentencia().setInt(1, nroInquilino);
			resultSet = conexi�n.resultado();
			if (resultSet.next()) {
				CI = resultSet.getInt("CI");
				nombre = resultSet.getString("nombre");
				tel�fono = resultSet.getInt("tel�fono");
				direcci�n = resultSet.getString("direcci�n");
				NIT = resultSet.getString("NIT");
				inquilino = new Inquilino(nroInquilino, CI, nombre, tel�fono, direcci�n, NIT);
			} else {
				throw new NoExisteInquilino();
			}

			System.out.println(inquilino);
			Men�.men�Modificar(scanner, inquilino);

			sql = "update inquilino set CI = ?, nombre = ?, tel�fono = ?, direcci�n = ?, NIT = ? where nroInquilino = ?";

			conexi�n.consulta(sql);
			conexi�n.getSentencia().setInt(1, inquilino.getCI());
			conexi�n.getSentencia().setString(2, inquilino.getNombre());
			conexi�n.getSentencia().setInt(3, inquilino.getTel�fono());
			conexi�n.getSentencia().setString(4, inquilino.getDirecci�n());
			conexi�n.getSentencia().setString(5, inquilino.getNIT());
			conexi�n.getSentencia().setInt(6, inquilino.getNroInquilino());
			conexi�n.modificacion();
		}

		/****************************
		 * Listar titulares
		 * 
		 ****************************/

		public void list() throws SQLException {
			Inquilino inquilino;
			String sql = "select * from inquilino ";
			conexi�n.consulta(sql);
			ResultSet resultSet = conexi�n.resultado();
			while (resultSet.next()) {
				inquilino = new Inquilino(resultSet.getInt("nroInquilino"), resultSet.getInt("CI"),
						resultSet.getString("nombre"), resultSet.getInt("tel�fono"),
						resultSet.getString("direcci�n"), resultSet.getString("NIT"));
				System.out.println(inquilino);
			}
		}

		/****************************
		 * Listar Oficinas .
		 * 
		 * @throws NoExisteTitular
		 * @throws SQLException *
		 ****************************/

		public void listAlquiler() throws NoExisteInquilino,NoExisteAlquiler, SQLException {
			ResultSet resultSet;
			Inquilino inquilino;
			int CI;
			String nombre;
			int tel�fono;
			String direcci�n;
			String NIT;
			int nroInquilino = InputTypes.readInt("N�mero de Inquilino: ", scanner);
			String sql = "select * from inquilino where nroInquilino = ?";
			conexi�n.consulta(sql);
			conexi�n.getSentencia().setInt(1, nroInquilino);
			resultSet = conexi�n.resultado();
			if (resultSet.next()) {
				CI = resultSet.getInt("CI");
				nombre = resultSet.getString("nombre");
				tel�fono = resultSet.getInt("tel�fono");
				direcci�n = resultSet.getString("direcci�n");
				NIT = resultSet.getString("NIT");
				inquilino = new Inquilino(nroInquilino, CI, nombre, tel�fono, direcci�n, NIT);
			} else {
				throw new NoExisteInquilino();
			}
			System.out.println(inquilino);

			Alquiler alquiler;
			int nroAlquiler;
			String fecha;

			String sql1 = "select * from oficina where nroInquilino = ?";
			conexi�n.consulta(sql1);
			conexi�n.getSentencia().setInt(1, nroInquilino);
			resultSet = conexi�n.resultado();
			while (resultSet.next()) {
				nroAlquiler = resultSet.getInt("nroAlquiler");
				fecha = resultSet.getString("fecha");
				alquiler = new Alquiler(nroAlquiler, nroInquilino, fecha);
				System.out.println(alquiler);
			} //else {
				//throw new NoExisteAlquiler();
			//}
		}


}

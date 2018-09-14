package inquilino.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import alquiler.entity.Alquiler;
import alquiler.entity.NoExisteAlquiler;
import control.Conexión;
import inquilino.entity.Inquilino;
import inquilino.entity.NoExisteInquilino;
import view.InputTypes;

public class InquilinosIO {
		private Conexión conexión;
		private Scanner scanner;

		/****************************
		 * Constructor *
		 ****************************/

		public InquilinosIO(Conexión conexión, Scanner scanner) {
			this.conexión = conexión;
			this.scanner = scanner;
		}

		/****************************
		 * Agregar titulares *
		 ****************************/

		public void add() {
			Inquilino inquilino = InquilinoIO.ingresar(scanner);
			String sql = "Insert into Inquilino (CI, nombre, teléfono, dirección, NIT) " + "values(?,?,?,?,?)";
			try {
				conexión.consulta(sql);
				conexión.getSentencia().setInt(1, inquilino.getCI());
				conexión.getSentencia().setString(2, inquilino.getNombre());
				conexión.getSentencia().setInt(3, inquilino.getTeléfono());
				conexión.getSentencia().setString(4, inquilino.getDirección());
				conexión.getSentencia().setString(5, inquilino.getNIT());
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
			int nroInquilino = InputTypes.readInt("Número de inquilino: ", scanner);
			String sql = "delete " + "from inquilino " + "where nroInquilino = ?";
			conexión.consulta(sql);
			conexión.getSentencia().setInt(1, nroInquilino);
			conexión.modificacion();
		}

		/****************************
		 * Modificar categorías
		 * 
		 * @throws SQLException *
		 ****************************/

		public void update() throws NoExisteInquilino, SQLException {
			ResultSet resultSet;
			Inquilino inquilino;
			int CI;
			String nombre;
			int teléfono;
			String dirección;
			String NIT;
			int nroInquilino = InputTypes.readInt("Número de Inquilino: ", scanner);
			String sql = "select * from inquilino where nroInquilino = ?";
			conexión.consulta(sql);
			conexión.getSentencia().setInt(1, nroInquilino);
			resultSet = conexión.resultado();
			if (resultSet.next()) {
				CI = resultSet.getInt("CI");
				nombre = resultSet.getString("nombre");
				teléfono = resultSet.getInt("teléfono");
				dirección = resultSet.getString("dirección");
				NIT = resultSet.getString("NIT");
				inquilino = new Inquilino(nroInquilino, CI, nombre, teléfono, dirección, NIT);
			} else {
				throw new NoExisteInquilino();
			}

			System.out.println(inquilino);
			Menú.menúModificar(scanner, inquilino);

			sql = "update inquilino set CI = ?, nombre = ?, teléfono = ?, dirección = ?, NIT = ? where nroInquilino = ?";

			conexión.consulta(sql);
			conexión.getSentencia().setInt(1, inquilino.getCI());
			conexión.getSentencia().setString(2, inquilino.getNombre());
			conexión.getSentencia().setInt(3, inquilino.getTeléfono());
			conexión.getSentencia().setString(4, inquilino.getDirección());
			conexión.getSentencia().setString(5, inquilino.getNIT());
			conexión.getSentencia().setInt(6, inquilino.getNroInquilino());
			conexión.modificacion();
		}

		/****************************
		 * Listar titulares
		 * 
		 ****************************/

		public void list() throws SQLException {
			Inquilino inquilino;
			String sql = "select * from inquilino ";
			conexión.consulta(sql);
			ResultSet resultSet = conexión.resultado();
			while (resultSet.next()) {
				inquilino = new Inquilino(resultSet.getInt("nroInquilino"), resultSet.getInt("CI"),
						resultSet.getString("nombre"), resultSet.getInt("teléfono"),
						resultSet.getString("dirección"), resultSet.getString("NIT"));
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
			int teléfono;
			String dirección;
			String NIT;
			int nroInquilino = InputTypes.readInt("Número de Inquilino: ", scanner);
			String sql = "select * from inquilino where nroInquilino = ?";
			conexión.consulta(sql);
			conexión.getSentencia().setInt(1, nroInquilino);
			resultSet = conexión.resultado();
			if (resultSet.next()) {
				CI = resultSet.getInt("CI");
				nombre = resultSet.getString("nombre");
				teléfono = resultSet.getInt("teléfono");
				dirección = resultSet.getString("dirección");
				NIT = resultSet.getString("NIT");
				inquilino = new Inquilino(nroInquilino, CI, nombre, teléfono, dirección, NIT);
			} else {
				throw new NoExisteInquilino();
			}
			System.out.println(inquilino);

			Alquiler alquiler;
			int nroAlquiler;
			String fecha;

			String sql1 = "select * from oficina where nroInquilino = ?";
			conexión.consulta(sql1);
			conexión.getSentencia().setInt(1, nroInquilino);
			resultSet = conexión.resultado();
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

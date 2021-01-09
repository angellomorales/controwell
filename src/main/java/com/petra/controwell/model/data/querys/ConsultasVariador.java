package com.petra.controwell.model.data.querys;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;

import com.petra.controwell.model.data.Proceso;
import com.petra.controwell.model.data.Variador;
import com.petra.controwell.model.data.bdstruct.Consultas;
import com.petra.controwell.model.utilities.Utilities;

/**
 *
 * @author Angello Morales
 */
public class ConsultasVariador {

	public boolean buscarUltimoEstado(Variador var) throws SQLException {

		// creacion de variables para la consulta
		Consultas consultas = new Consultas();
		ArrayList arrayVar = new ArrayList();
		ResultSet rs;
		boolean estado = false;

		// consulta a realizar
		String query = "SELECT * FROM variador WHERE idPozo=? ORDER BY consecutivo DESC LIMIT 1";

		// crear arraylist con objeto a consultar, agregar en el orden de la consulta
		arrayVar.add(var.getIdPozo());

		// ejecutar consulta y almacenar resultados en rs si se requiere
		rs = consultas.readSQL(query, arrayVar);

		// asignar resultados a setter de objeto
		try {
			if (rs != null) {
				var.setFecha(rs.getDate("fecha"));
				var.setHora(rs.getTime("hora"));
				var.setFrecuencia(rs.getDouble("frecuencia"));
				var.setPip(rs.getDouble("pip"));
				var.setPdp(rs.getDouble("pdp"));
				var.settIntake(rs.getDouble("tIntake"));
				var.settMotor(rs.getDouble("tMotor"));
				var.setVolt(rs.getDouble("volt"));
				var.setAmp(rs.getDouble("amp"));

				// consulta exitosa
				estado = true;
			} else {
				System.err.println("No hay datos relacionados");
			}
			// para consultas que tienen rs se debe cerrar la conexion en cada
			// funcion
			consultas.cerrarConexion();
		} catch (SQLException e) {
			System.err.println("ERROR " + e);
		}

		return estado;
	}

	public boolean buscarXFecha(Variador var) throws SQLException {

		// creacion de variables para la consulta
		Consultas consultas = new Consultas();
		ArrayList arrayVar = new ArrayList();
		ResultSet rs;
		boolean estado = false;

		// consulta a realizar
		String query = "SELECT fecha,idPozo, AVG(frecuencia)AS frecuencia, AVG(pip) AS pip, AVG(pdp) AS pdp, AVG(tIntake) AS tIntake, AVG(tMotor) AS tMotor, AVG(volt) AS volt, AVG(amp) AS amp FROM variador WHERE fecha=? AND idPozo=? GROUP BY fecha";

		// crear arraylist con objeto a consultar, agregar en el orden de la consulta
		arrayVar.add(var.getFecha());
		arrayVar.add(var.getIdPozo());

		// ejecutar consulta y almacenar resultados en rs si se requiere
		rs = consultas.readSQL(query, arrayVar);

		// asignar resultados a setter de objeto
		try {
			if (rs != null) {
				// consulta exitosa
				var.setFecha(rs.getDate("fecha"));
				var.setFrecuencia(rs.getDouble("frecuencia"));
				var.setPip(rs.getDouble("pip"));
				var.setPdp(rs.getDouble("pdp"));
				var.settIntake(rs.getDouble("tIntake"));
				var.settMotor(rs.getDouble("tMotor"));
				var.setVolt(rs.getDouble("volt"));
				var.setAmp(rs.getDouble("amp"));
				// consulta exitosa
				estado = true;
			} else {
				System.err.println("No hay datos relacionados");
			}
			// para consultas que tienen rs se debe cerrar la conexion en cada
			// funcion
			consultas.cerrarConexion();

		} catch (SQLException e) {
			System.err.println("ERROR " + e);
		}

		return estado;
	}
	
	public ArrayList buscarTodosXFecha(String idPozo, Date fechaInicial) throws SQLException {

		// creacion de variables para la consulta
		Consultas consultas = new Consultas();
		ArrayList arrayVar = new ArrayList();
		ArrayList<ArrayList> arrayVariables = new ArrayList<>();
		ArrayList arrayDatos = new ArrayList();
		ArrayList arrayTitulos = new ArrayList();
		ResultSet rs;

		String query = null;

		// consulta a realizar


			query = "SELECT * FROM variador WHERE fecha=? AND idPozo=?;";
			arrayVar.clear();
			arrayVar.add(fechaInicial);
			arrayVar.add(idPozo);

		// ejecutar consulta y almacenar resultados en rs si se requiere
		rs = consultas.readSQL(query, arrayVar);

		// asignar resultados a setter de objeto
		try {
			if (rs != null) {
				// consulta exitosa
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					if (!"consecutivo".equals(rs.getMetaData().getColumnName(i))) {
						arrayTitulos.add(rs.getMetaData().getColumnName(i));
						if (!"idPozo".equals(rs.getMetaData().getColumnName(i))
								&& !"fecha".equals(rs.getMetaData().getColumnName(i))
								&& !"hora".equals(rs.getMetaData().getColumnName(i))) {
							arrayDatos.add(rs.getDouble(i));
							while (rs.next()) {
								arrayDatos.add(rs.getDouble(i));
							}
						} else {
							if ("fecha".equals(rs.getMetaData().getColumnName(i))) {
								arrayDatos.add(rs.getDate(i));
								while (rs.next()) {
									arrayDatos.add(rs.getDate(i));
								}
							}
							if ("hora".equals(rs.getMetaData().getColumnName(i))) {
								arrayDatos.add(rs.getTime(i));
								while (rs.next()) {
									arrayDatos.add(rs.getTime(i));
								}
							}
							if ("idPozo".equals(rs.getMetaData().getColumnName(i))) {
								arrayDatos.add(rs.getString(i));
								while (rs.next()) {
									arrayDatos.add(rs.getString(i));
								}
							}
						}
						arrayVariables.add(new ArrayList(arrayDatos));
						arrayDatos.removeAll(arrayDatos);
						rs.absolute(1);
					}
				}
				arrayVariables.add(new ArrayList(arrayTitulos));
			} else {
				JOptionPane.showMessageDialog(null, "No hay datos relacionados");
			}
			// para consultas que tienen rs se debe cerrar la conexion en cada
			// funcion
			consultas.cerrarConexion();
		} catch (SQLException e) {
			System.err.println("ERROR " + e);
		}

		return arrayVariables;
	}


	public boolean buscarConsecutivoXfechayPozo(Variador var) throws SQLException {
		// creacion de variables para la consulta
		Consultas consultas = new Consultas();
		ArrayList arrayVar = new ArrayList();
		ResultSet rs;
		boolean estado = false;

		// consulta a realizar
		String query = "SELECT * FROM variador WHERE fecha=? AND hora=? AND idPozo=?";

		// crear arraylist con objeto a consultar, agregar en el orden de la consulta
		arrayVar.add(var.getFecha());
		arrayVar.add(var.getHora());
		arrayVar.add(var.getIdPozo());

		// ejecutar consulta y almacenar resultados en rs si se requiere
		rs = consultas.readSQL(query, arrayVar);

		// asignar resultados a setter de objeto
		try {
			if (rs != null) {
				// consulta exitosa
				var.setConsecutivo(rs.getInt("Consecutivo"));
				// consulta exitosa
				estado = true;
			} else {
				System.err.println("No hay datos relacionados");
			}
			// para consultas que tienen rs se debe cerrar la conexion en cada
			// funcion
			consultas.cerrarConexion();

		} catch (SQLException e) {
			System.err.println("ERROR " + e);
		}

		return estado;

	}

	public boolean modificarXArray(ArrayList arrayDatos, ArrayList arrayTitulos) throws SQLException {
		// creacion de variables para la consulta
		Consultas consultas = new Consultas();
		ArrayList arrayVar = new ArrayList();
		Variador variador = new Variador();
		boolean estado = false;
		Utilities util=new Utilities();
		StringBuilder query;

		// se realiza consulta del consecutivo para saber si modifica o ingresa
		java.util.Date utilFecha=(java.util.Date) arrayDatos.get(0);
		java.sql.Date sqlFecha = new java.sql.Date(utilFecha.getTime());		
		java.util.Date utilTime=(java.util.Date) arrayDatos.get(1);	
		
		Calendar cTime = util.asignacionFechas(utilFecha, utilTime);
		java.sql.Time sqlTime = new java.sql.Time(cTime.getTimeInMillis());
		
		variador.setFecha(sqlFecha);
		variador.setHora(sqlTime);
		variador.setIdPozo((String) arrayDatos.get(2));

		if (this.buscarConsecutivoXfechayPozo(variador)) {
			query = new StringBuilder("UPDATE variador SET fecha=?, hora=?, idPozo=?, ");
			arrayVar.add(variador.getFecha());
			arrayVar.add(variador.getHora());
			arrayVar.add(variador.getIdPozo());
			for (int i = 3; i < arrayTitulos.size(); i++) {
				if (i == arrayTitulos.size() - 1) {
					query.append(arrayTitulos.get(i).toString() + "=?");
				} else {
					query.append(arrayTitulos.get(i).toString() + "=?, ");
				}
				arrayVar.add((Double) arrayDatos.get(i));
			}
			query.append(" WHERE consecutivo=?");
			arrayVar.add(variador.getConsecutivo());
		} else {
			query = new StringBuilder("INSERT INTO variador (fecha, hora, idPozo, ");
			arrayVar.add(variador.getFecha());
			arrayVar.add(variador.getHora());
			arrayVar.add(variador.getIdPozo());
			for (int i = 3; i < arrayTitulos.size(); i++) {
				if (i == arrayTitulos.size() - 1) {
					query.append(arrayTitulos.get(i).toString() + ") VALUES (");
				} else {
					query.append(arrayTitulos.get(i).toString() + ", ");
				}
			}
			for (int i = 3; i < arrayTitulos.size(); i++) {
				if (i == arrayTitulos.size() - 1) {
					query.append("?,?,?,?)");
				} else {
					query.append("?,");
				}
				arrayVar.add((Double) arrayDatos.get(i));
			}

		}
		
		//ejecutar consulta y almacenar resultados en rs si se requiere
        estado = consultas.writeSQL(query.toString(), arrayVar);
		return estado;
	}

}

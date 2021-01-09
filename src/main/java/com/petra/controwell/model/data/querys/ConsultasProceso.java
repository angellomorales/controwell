package com.petra.controwell.model.data.querys;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import com.petra.controwell.model.data.Proceso;
import com.petra.controwell.model.data.bdstruct.Consultas;
import com.petra.controwell.model.utilities.Utilities;

/**
 *
 * @author Angello Morales
 */
public class ConsultasProceso {

	public boolean buscarUltimoEstado(Proceso proc) throws SQLException {

		// creacion de variables para la consulta
		Consultas consultas = new Consultas();
		ArrayList arrayVar = new ArrayList();
		ResultSet rs;
		boolean estado = false;

		// consulta a realizar
		String query = "SELECT * FROM proceso WHERE idPozo=? ORDER BY consecutivo DESC LIMIT 1";

		// crear arraylist con objeto a consultar, agregar en el orden de la consulta
		arrayVar.add(proc.getIdPozo());

		// ejecutar consulta y almacenar resultados en rs si se requiere
		rs = consultas.readSQL(query, arrayVar);

		// asignar resultados a setter de objeto
		try {
			if (rs != null) {
				proc.setFecha(rs.getDate("fecha"));
				proc.setHora(rs.getTime("hora"));
				proc.setPresionCabeza(rs.getDouble("presionCabeza"));
				proc.setTemperaturaCabeza(rs.getDouble("temperaturaCabeza"));
				proc.setPresionCasing(rs.getDouble("presionCasing"));
				proc.setPresionChoke(rs.getDouble("presionChoke"));
				proc.setFlujoDiluyente(rs.getDouble("flujoDiluyente"));
				proc.setPresionMezclador(rs.getDouble("presionMezclador"));
				proc.setFlujoAceiteSep(rs.getDouble("flujoAceiteSep"));
				proc.setFlujoAguaSep(rs.getDouble("flujoAguaSep"));
				proc.setPresionSep(rs.getDouble("presionSep"));
				proc.setTemperaturaSep(rs.getDouble("temperaturaSep"));
				proc.setPresionGasSep(rs.getDouble("presionGasSep"));
				proc.setTemperaturaGasSep(rs.getDouble("temperaturaGasSep"));
				proc.setFlujoGas(rs.getDouble("flujoGas"));
				proc.setPresionLinea(rs.getDouble("presionLinea"));

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

	public boolean buscarXFecha(Proceso proc) throws SQLException {

		// creacion de variables para la consulta
		Consultas consultas = new Consultas();
		ArrayList arrayVar = new ArrayList();
		ResultSet rs;
		boolean estado = false;

		// consulta a realizar
		String query = "SELECT fecha,idPozo, AVG(presionCabeza)AS presionCabeza, AVG(temperaturaCabeza) AS temperaturaCabeza, AVG(presionCasing) AS presionCasing, AVG(presionChoke) AS presionChoke, AVG(flujoDiluyente) AS flujoDiluyente, AVG(presionMezclador) AS presionMezclador, AVG(flujoAceiteSep) AS flujoAceiteSep, AVG(flujoAguaSep) AS flujoAguaSep, AVG(presionSep) AS presionSep, AVG(temperaturaSep) AS temperaturaSep, AVG(presionGasSep) AS presionGasSep, AVG(temperaturaGasSep) AS temperaturaGasSep, AVG(flujoGas) AS flujoGas, AVG(presionLinea) AS presionLinea FROM proceso WHERE fecha=? AND idPozo=? GROUP BY fecha;";

		// crear arraylist con objeto a consultar, agregar en el orden de la consulta
		arrayVar.add(proc.getFecha());
		arrayVar.add(proc.getIdPozo());

		// ejecutar consulta y almacenar resultados en rs si se requiere
		rs = consultas.readSQL(query, arrayVar);

		// asignar resultados a setter de objeto
		try {
			if (rs != null) {
				// consulta exitosa
				proc.setFecha(rs.getDate("fecha"));
				proc.setPresionCabeza(rs.getDouble("presionCabeza"));
				proc.setTemperaturaCabeza(rs.getDouble("temperaturaCabeza"));
				proc.setPresionCasing(rs.getDouble("presionCasing"));
				proc.setPresionChoke(rs.getDouble("presionChoke"));
				proc.setFlujoDiluyente(rs.getDouble("flujoDiluyente"));
				proc.setPresionMezclador(rs.getDouble("presionMezclador"));
				proc.setFlujoAceiteSep(rs.getDouble("flujoAceiteSep"));
				proc.setFlujoAguaSep(rs.getDouble("flujoAguaSep"));
				proc.setPresionSep(rs.getDouble("presionSep"));
				proc.setTemperaturaSep(rs.getDouble("temperaturaSep"));
				proc.setPresionGasSep(rs.getDouble("presionGasSep"));
				proc.setTemperaturaGasSep(rs.getDouble("temperaturaGasSep"));
				proc.setFlujoGas(rs.getDouble("flujoGas"));
				proc.setPresionLinea(rs.getDouble("presionLinea"));
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

	public boolean buscarConsecutivoXfechayPozo(Proceso proc) throws SQLException {
		// creacion de variables para la consulta
		Consultas consultas = new Consultas();
		ArrayList arrayVar = new ArrayList();
		ResultSet rs;
		boolean estado = false;

		// consulta a realizar
		String query = "SELECT * FROM proceso WHERE fecha=? AND hora=? AND idPozo=?";

		// crear arraylist con objeto a consultar, agregar en el orden de la consulta
		arrayVar.add(proc.getFecha());
		arrayVar.add(proc.getHora());
		arrayVar.add(proc.getIdPozo());

		// ejecutar consulta y almacenar resultados en rs si se requiere
		rs = consultas.readSQL(query, arrayVar);

		// asignar resultados a setter de objeto
		try {
			if (rs != null) {
				// consulta exitosa
				proc.setConsecutivo(rs.getInt("Consecutivo"));
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
		Proceso proceso = new Proceso();
		boolean estado = false;
		Utilities util=new Utilities();
		StringBuilder query;

		// se realiza consulta del consecutivo para saber si modifica o ingresa
		java.util.Date utilFecha=(java.util.Date) arrayDatos.get(0);
		java.sql.Date sqlFecha = new java.sql.Date(utilFecha.getTime());		
		java.util.Date utilTime=(java.util.Date) arrayDatos.get(1);	
		
		Calendar cTime = util.asignacionFechas(utilFecha, utilTime);
		java.sql.Time sqlTime = new java.sql.Time(cTime.getTimeInMillis());
		
		proceso.setFecha(sqlFecha);
		proceso.setHora(sqlTime);
		proceso.setIdPozo((String) arrayDatos.get(2));

		if (this.buscarConsecutivoXfechayPozo(proceso)) {
			query = new StringBuilder("UPDATE proceso SET fecha=?, hora=?, idPozo=?, ");
			arrayVar.add(proceso.getFecha());
			arrayVar.add(proceso.getHora());
			arrayVar.add(proceso.getIdPozo());
			for (int i = 3; i < arrayTitulos.size(); i++) {
				if (i == arrayTitulos.size() - 1) {
					query.append(arrayTitulos.get(i).toString() + "=?");
				} else {
					query.append(arrayTitulos.get(i).toString() + "=?, ");
				}
				arrayVar.add((Double) arrayDatos.get(i));
			}
			query.append(" WHERE consecutivo=?");
			arrayVar.add(proceso.getConsecutivo());
		} else {
			query = new StringBuilder("INSERT INTO proceso (fecha, hora, idPozo, ");
			arrayVar.add(proceso.getFecha());
			arrayVar.add(proceso.getHora());
			arrayVar.add(proceso.getIdPozo());
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

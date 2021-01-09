package com.petra.controwell.model.data.querys;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JOptionPane;

import com.petra.controwell.model.SeriesGrafica;
import com.petra.controwell.model.data.bdstruct.Consultas;

/**
 *
 * @author Angello Morales
 */
public class ConsultasProcesoProduccionArray {

	private final int XDIA = 2;
	private final int PROMEDIOFECHAS = 0;
	private final int TODO = 1;

	public ArrayList buscarTodosProcesoXFecha(String idPozo, Date fechaInicial, Date fechaFinal, int tipoHora,
			boolean consultarProduccion) throws SQLException {

		// creacion de variables para la consulta
		Consultas consultas = new Consultas();
		ArrayList arrayVar = new ArrayList();
		ArrayList<ArrayList> arrayVariables = new ArrayList<>();
		ArrayList arrayDatos = new ArrayList();
		ArrayList arrayTitulos = new ArrayList();
		ResultSet rs;

		String query = null;

		// consulta a realizar
		switch (tipoHora) {
		case PROMEDIOFECHAS:
			query = "SELECT fecha,idPozo, AVG(presionCabeza)AS presionCabeza, AVG(temperaturaCabeza) AS temperaturaCabeza, AVG(presionCasing) AS presionCasing, AVG(presionChoke) AS presionChoke, AVG(flujoDiluyente) AS flujoDiluyente, AVG(presionMezclador) AS presionMezclador, AVG(flujoAceiteSep) AS flujoAceiteSep, AVG(flujoAguaSep) AS flujoAguaSep, AVG(presionSep) AS presionSep, AVG(temperaturaSep) AS temperaturaSep, AVG(presionGasSep) AS presionGasSep, AVG(temperaturaGasSep) AS temperaturaGasSep, AVG(flujoGas) AS flujoGas, AVG(presionLinea) AS presionLinea FROM proceso WHERE fecha>=? AND fecha<=? AND idPozo=? GROUP BY fecha;";
			// crear arraylist con objeto a consultar, agregar en el orden de la consulta
			arrayVar.add(fechaInicial);
			arrayVar.add(fechaFinal);
			arrayVar.add(idPozo);
			break;
		case XDIA:
			query = "SELECT * FROM proceso WHERE fecha=? AND idPozo=?;";
			arrayVar.clear();
			arrayVar.add(fechaInicial);
			arrayVar.add(idPozo);
			break;
		case TODO:
			query = "SELECT * FROM proceso WHERE fecha>=? AND fecha<=? AND idPozo=?;";
			// crear arraylist con objeto a consultar, agregar en el orden de la consulta
			arrayVar.add(fechaInicial);
			arrayVar.add(fechaFinal);
			arrayVar.add(idPozo);
			break;
		}
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
				if (consultarProduccion) {
					ArrayList segundoQ = new ArrayList(
							this.buscarTodosProduccionXFecha(idPozo, fechaInicial, fechaFinal, tipoHora));
					segundoQ.forEach((_item) -> {
						arrayVariables.add((ArrayList) _item);
					});
					ArrayList titulosProduccion = arrayVariables.get(arrayVariables.size() - 1);
					arrayVariables.remove(arrayVariables.size() - 1);
					titulosProduccion.forEach((_item) -> {
						arrayTitulos.add(_item);
					});
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

	public ArrayList buscarTodosProduccionXFecha(String idPozo, Date fechaInicial, Date fechaFinal, int tipoHora)
			throws SQLException {

		// creacion de variables para la consulta
		Consultas consultas = new Consultas();
		ArrayList arrayVar = new ArrayList();
		ArrayList<ArrayList> arrayVariables = new ArrayList<>();
		ArrayList arrayDatos = new ArrayList();
		ArrayList arrayTitulos = new ArrayList();
		ResultSet rs;

		String query = null;

		// consulta a realizar
		switch (tipoHora) {
		case PROMEDIOFECHAS:
			query = "SELECT fecha,idPozo,recibo AS NSVconDiluyente,aceiteProducido,aguaProducida,inyeccionDiluyente AS diluyente, sYw,gas,recibo24H AS NSVconDiluyente24H,aceiteProducido24H,aguaProducida24H,inyeccionDiluyente24H AS diluyente24H, sYw24H,gas24H FROM balance WHERE fecha>=? AND fecha<=? AND idPozo=? GROUP BY fecha";
			// crear arraylist con objeto a consultar, agregar en el orden de la consulta
			arrayVar.add(fechaInicial);
			arrayVar.add(fechaFinal);
			arrayVar.add(idPozo);
			break;
		case XDIA:
			query = "SELECT fecha,idPozo,recibo AS NSVconDiluyente,aceiteProducido,aguaProducida,inyeccionDiluyente AS diluyente, sYw,gas,recibo24H AS NSVconDiluyente24H,aceiteProducido24H,aguaProducida24H,inyeccionDiluyente24H AS diluyente24H, sYw24H,gas24H FROM balance WHERE fecha=? AND idPozo=?;";
			arrayVar.clear();
			arrayVar.add(fechaInicial);
			arrayVar.add(idPozo);
			break;
		case TODO:
			query = "SELECT fecha,idPozo,recibo AS NSVconDiluyente,aceiteProducido,aguaProducida,inyeccionDiluyente AS diluyente, sYw,gas,recibo24H AS NSVconDiluyente24H,aceiteProducido24H,aguaProducida24H,inyeccionDiluyente24H AS diluyente24H, sYw24H,gas24H FROM balance WHERE fecha>=? AND fecha<=? AND idPozo=?;";
			// crear arraylist con objeto a consultar, agregar en el orden de la consulta
			arrayVar.add(fechaInicial);
			arrayVar.add(fechaFinal);
			arrayVar.add(idPozo);
			break;
		}
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

	public ArrayList<ArrayList> buscarArrayPromedioProcesoXRangoFechas(String idPozo,
			Map<Integer, SeriesGrafica> arrayMapSeries, Date fechaInicial, Date fechaFinal, int tipoHora)
			throws SQLException {

		// creacion de variables para la consulta
		Consultas consultas = new Consultas();
		ArrayList arrayVar = new ArrayList();
		ArrayList<ArrayList> arrayVariables = new ArrayList<>();
		ArrayList arrayDatos = new ArrayList();
		ArrayList arrayClave = new ArrayList();
		ResultSet rs;
		int segundoQuery = 0;

		// consulta a realizar
//        String query = "SELECT * FROM proceso WHERE idPozo=?";
		String query = "SELECT fecha, AVG(presionCabeza)AS presionCabeza, AVG(temperaturaCabeza) AS temperaturaCabeza, AVG(presionCasing) AS presionCasing, AVG(presionChoke) AS presionChoke, AVG(flujoDiluyente) AS flujoDiluyente, AVG(presionMezclador) AS presionMezclador, AVG(flujoAceiteSep) AS flujoAceiteSep, AVG(flujoAguaSep) AS flujoAguaSep, AVG(presionSep) AS presionSep, AVG(temperaturaSep) AS temperaturaSep, AVG(presionGasSep) AS presionGasSep, AVG(temperaturaGasSep) AS temperaturaGasSep, AVG(flujoGas) AS flujoGas, AVG(presionLinea) AS presionLinea FROM proceso WHERE fecha>=? AND fecha<=? AND idPozo=? GROUP BY fecha;";
		// crear arraylist con objeto a consultar, agregar en el orden de la consulta
		arrayVar.add(fechaInicial);
		arrayVar.add(fechaFinal);
		arrayVar.add(idPozo);
		if (tipoHora == 1) {
			query = "SELECT * FROM proceso WHERE fecha=? AND idPozo=?;";
			arrayVar.clear();
			arrayVar.add(fechaInicial);
			arrayVar.add(idPozo);
		}

		// ejecutar consulta y almacenar resultados en rs si se requiere
		rs = consultas.readSQL(query, arrayVar);

		// asignar resultados a setter de objeto
		try {
			if (rs != null) {
				// consulta exitosa
				Iterator it = arrayMapSeries.keySet().iterator();
				while (it.hasNext()) {
					Integer key = (Integer) it.next();
					if (key < 15) {
						arrayClave.add(key);
						if (!"fecha".equals(arrayMapSeries.get(key).getNombreColumnaBD())
								&& !"hora".equals(arrayMapSeries.get(key).getNombreColumnaBD())) {
							arrayDatos.add(rs.getDouble(arrayMapSeries.get(key).getNombreColumnaBD()));
							while (rs.next()) {
								arrayDatos.add(rs.getDouble(arrayMapSeries.get(key).getNombreColumnaBD()));
							}
						} else {
							if ("fecha".equals(arrayMapSeries.get(key).getNombreColumnaBD())) {
								arrayDatos.add(rs.getDate(arrayMapSeries.get(key).getNombreColumnaBD()));
								while (rs.next()) {
									arrayDatos.add(rs.getDate(arrayMapSeries.get(key).getNombreColumnaBD()));
								}
							}
							if ("hora".equals(arrayMapSeries.get(key).getNombreColumnaBD())) {
								arrayDatos.add(rs.getTime(arrayMapSeries.get(key).getNombreColumnaBD()));
								while (rs.next()) {
									arrayDatos.add(rs.getTime(arrayMapSeries.get(key).getNombreColumnaBD()));
								}
							}
						}
						arrayVariables.add(new ArrayList(arrayDatos));
						arrayDatos.removeAll(arrayDatos);
						rs.absolute(1);
					} else {
						if (tipoHora == 1) {
							segundoQuery = 2;
							break;
						} else {
							segundoQuery = 1;
						}
					}

				}
				if (segundoQuery == 1) {
					ArrayList segundoQ = new ArrayList(this.buscarArrayProduccionXRangoFechas(idPozo, arrayMapSeries,
							fechaInicial, fechaFinal, tipoHora));
					segundoQ.forEach((_item) -> {
						arrayVariables.add((ArrayList) _item);
					});
					ArrayList titulosProduccion = arrayVariables.get(arrayVariables.size() - 1);
					arrayVariables.remove(arrayVariables.size() - 1);
					titulosProduccion.forEach((_item) -> {
						arrayClave.add(_item);
					});
				}
				arrayVariables.add(new ArrayList(arrayClave));
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

	public ArrayList<ArrayList> buscarArrayProduccionXRangoFechas(String idPozo,
			Map<Integer, SeriesGrafica> arrayMapSeries, Date fechaInicial, Date fechaFinal, int tipoHora)
			throws SQLException {

		// creacion de variables para la consulta
		Consultas consultas = new Consultas();
		ArrayList arrayVar = new ArrayList();
		ArrayList<ArrayList> arrayVariables = new ArrayList<>();
		ArrayList arrayDatos = new ArrayList();
		ArrayList arrayClave = new ArrayList();
		ResultSet rs;

		// consulta a realizar
//      String query = "SELECT aceiteProducido, aguaProducida, inyeccionDiluyente, recibo, sYw, gas , tiempoPrueba FROM balance WHERE fecha>=? AND fecha<=? AND idPozo=? GROUP BY fecha";
		String query = "SELECT * FROM balance WHERE fecha>=? AND fecha<=? AND idPozo=? GROUP BY fecha";

		// crear arraylist con objeto a consultar, agregar en el orden de la consulta
		arrayVar.add(fechaInicial);
		arrayVar.add(fechaFinal);
		arrayVar.add(idPozo);
		if (tipoHora == 1) {
			query = "SELECT * FROM balance WHERE fecha= ? AND idPozo=?";
			arrayVar.clear();
			arrayVar.add(fechaInicial);
			arrayVar.add(idPozo);
		}
		// ejecutar consulta y almacenar resultados en rs si se requiere
		rs = consultas.readSQL(query, arrayVar);

		// asignar resultados a setter de objeto
		try {
			if (rs != null) {
				// consulta exitosa
				Iterator it = arrayMapSeries.keySet().iterator();
				while (it.hasNext()) {
					Integer key = (Integer) it.next();
					if (key == 0) {
						arrayClave.add(key);
						if ("fecha".equals(arrayMapSeries.get(key).getNombreColumnaBD())) {
							arrayDatos.add(rs.getDate(arrayMapSeries.get(key).getNombreColumnaBD()));
							while (rs.next()) {
								arrayDatos.add(rs.getDate(arrayMapSeries.get(key).getNombreColumnaBD()));
							}
						}
						if ("hora".equals(arrayMapSeries.get(key).getNombreColumnaBD())) {
							arrayDatos.add(rs.getTime(arrayMapSeries.get(key).getNombreColumnaBD()));
							while (rs.next()) {
								arrayDatos.add(rs.getTime(arrayMapSeries.get(key).getNombreColumnaBD()));
							}
						}
						arrayVariables.add(new ArrayList(arrayDatos));
						arrayDatos.removeAll(arrayDatos);
						rs.absolute(1);
					}
					if (key >= 15) {
						arrayClave.add(key);
						if (!"fecha".equals(arrayMapSeries.get(key).getNombreColumnaBD())
								&& !"hora".equals(arrayMapSeries.get(key).getNombreColumnaBD())) {
							arrayDatos.add(rs.getDouble(arrayMapSeries.get(key).getNombreColumnaBD()));
							while (rs.next()) {
								arrayDatos.add(rs.getDouble(arrayMapSeries.get(key).getNombreColumnaBD()));
							}
						} else {
							if ("fecha".equals(arrayMapSeries.get(key).getNombreColumnaBD())) {
								arrayDatos.add(rs.getDate(arrayMapSeries.get(key).getNombreColumnaBD()));
								while (rs.next()) {
									arrayDatos.add(rs.getDate(arrayMapSeries.get(key).getNombreColumnaBD()));
								}
							}
							if ("hora".equals(arrayMapSeries.get(key).getNombreColumnaBD())) {
								arrayDatos.add(rs.getTime(arrayMapSeries.get(key).getNombreColumnaBD()));
								while (rs.next()) {
									arrayDatos.add(rs.getTime(arrayMapSeries.get(key).getNombreColumnaBD()));
								}
							}
						}

						arrayVariables.add(new ArrayList(arrayDatos));
						arrayDatos.removeAll(arrayDatos);
						rs.absolute(1);
					}
				}
				arrayVariables.add(new ArrayList(arrayClave));
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

	public int getXDIA() {
		return XDIA;
	}

	public int getPROMEDIOFECHAS() {
		return PROMEDIOFECHAS;
	}

	public int getTODO() {
		return TODO;
	}

}

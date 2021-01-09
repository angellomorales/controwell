package com.petra.controwell.model.data.querys;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

import com.petra.controwell.model.data.OperacionTk;
import com.petra.controwell.model.data.bdstruct.Consultas;

/**
 *
 * @author Angello Morales
 */
public class ConsultasOperacionTk {

	public boolean buscarUltimoXTk(OperacionTk op) throws SQLException {

		// creacion de variables para la consulta
		Consultas consultas = new Consultas();
		ArrayList arrayVar = new ArrayList();
		ResultSet rs;
		boolean estado = false;

		// consulta a realizar
		String query = "SELECT * FROM operaciontk WHERE  idTanque=? ORDER BY consecutivo DESC LIMIT 1";

		// crear arraylist con objeto a consultar, agregar en el orden de la consulta
		arrayVar.add(op.getIdTanque());

		// ejecutar consulta y almacenar resultados en rs si se requiere
		rs = consultas.readSQL(query, arrayVar);

		// asignar resultados a setter de objeto
		try {
			if (rs != null) {
//                op.setConsecutivo(rs.getInt("consecutivo"));
				op.setIdPozo(rs.getString("idPozo"));
				op.setFecha(rs.getDate("fecha"));
				op.setHora(rs.getTime("hora"));
				op.setTipo(rs.getString("tipo"));
				op.setNivel(rs.getDouble("nivel"));
//                op.setTov(rs.getDouble("tov"));
				op.setInterfase(rs.getDouble("interfase"));
//                op.setFw(rs.getDouble("fw"));
//                op.setGov(rs.getDouble("gov"));
				op.setApi(rs.getDouble("api"));
				op.setTempFluido(rs.getDouble("tempFluido"));
				op.setTempAmbiente(rs.getDouble("tempAmbiente"));
//                op.setCtsh(rs.getDouble("ctsh"));
//                op.setCtl(rs.getDouble("ctl"));
				op.setsYw(rs.getDouble("sYw"));
				op.setNsv(rs.getDouble("nsv"));
				op.setAgua(rs.getDouble("agua"));
//                op.setRecibo(rs.getDouble("recibo"));
//                op.setEntrega(rs.getDouble("entrega"));
//                op.setInyeccion(rs.getDouble("inyeccion"));
//                op.setTransferencia(rs.getDouble("transferencia"));
//                op.setDrenaje(rs.getDouble("drenaje"));
//                op.setConsumo(rs.getDouble("consumo"));
//                op.setRecibo(rs.getDouble("reciboAgua"));
//                op.setEntrega(rs.getDouble("entregaAgua"));
//                op.setInyeccion(rs.getDouble("inyeccionAgua"));
//                op.setTransferencia(rs.getDouble("transferenciaAgua"));
//                op.setDrenaje(rs.getDouble("drenajeAgua"));
//                op.setConsumo(rs.getDouble("consumoAgua"));
				op.setFluido(rs.getString("fluido"));

				// consulta exitosa
				estado = true;
			}
			// para consultas que tienen rs se debe cerrar la conexion en cada
			// funcion
			consultas.cerrarConexion();
		} catch (SQLException e) {
			System.err.println("ERROR " + e);
		}

		return estado;
	}

	public boolean buscarUltimaFecha(OperacionTk op) throws SQLException {

		// creacion de variables para la consulta
		Consultas consultas = new Consultas();
		ArrayList arrayVar = new ArrayList();
		ResultSet rs;
		boolean estado = false;

		// consulta a realizar
		String query = "SELECT * FROM operaciontk ORDER BY consecutivo DESC LIMIT 1";

		// crear arraylist con objeto a consultar, agregar en el orden de la consulta
		// arrayVar.add(1);

		// ejecutar consulta y almacenar resultados en rs si se requiere
		rs = consultas.readSQL(query, arrayVar);

		// asignar resultados a setter de objeto
		try {
			if (rs != null) {
//                op.setConsecutivo(rs.getInt("consecutivo"));
//                op.setIdPozo(rs.getString("idPozo"));
				op.setFecha(rs.getDate("fecha"));
				op.setHora(rs.getTime("hora"));
//                op.setTipo(rs.getString("tipo"));
//                op.setNivel(rs.getDouble("nivel"));
//                op.setTov(rs.getDouble("tov"));
//                op.setInterfase(rs.getDouble("interfase"));
//                op.setFw(rs.getDouble("fw"));
//                op.setGov(rs.getDouble("gov"));
//                op.setApi(rs.getDouble("api"));
//                op.setTempFluido(rs.getDouble("tempFluido"));
//                op.setTempAmbiente(rs.getDouble("tempAmbiente"));
//                op.setCtsh(rs.getDouble("ctsh"));
//                op.setCtl(rs.getDouble("ctl"));
//                op.setsYw(rs.getDouble("sYw"));
//                op.setNsv(rs.getDouble("nsv"));
//                op.setAgua(rs.getDouble("agua"));
//                op.setRecibo(rs.getDouble("recibo"));
//                op.setEntrega(rs.getDouble("entrega"));
//                op.setInyeccion(rs.getDouble("inyeccion"));
//                op.setTransferencia(rs.getDouble("transferencia"));
//                op.setDrenaje(rs.getDouble("drenaje"));
//                op.setConsumo(rs.getDouble("consumo"));
//                op.setReciboAgua(rs.getDouble("reciboAgua"));
//                op.setEntregaAgua(rs.getDouble("entregaAgua"));
//                op.setInyeccionAgua(rs.getDouble("inyeccionAgua"));
//                op.setTransferenciaAgua(rs.getDouble("transferenciaAgua"));
//                op.setDrenajeAgua(rs.getDouble("drenajeAgua"));
//                op.setConsumoAgua(rs.getDouble("consumoAgua"));
//                op.setFluido(rs.getString("fluido"));

				// consulta exitosa
				estado = true;
			}
			// para consultas que tienen rs se debe cerrar la conexion en cada
			// funcion
			consultas.cerrarConexion();
		} catch (SQLException e) {
			System.err.println("ERROR " + e);
		}

		return estado;
	}

	public boolean agregarDatos(OperacionTk op) throws SQLException {

		// creacion de variables para la consulta
		Consultas consultas = new Consultas();
		ArrayList arrayVar = new ArrayList();
		boolean estado = false;

		// consulta a realizar
		String query = "INSERT INTO operaciontk(fecha, hora, idTanque, idPozo, tipo, nivel, tov, interfase, fw, gov, api, tempFluido, tempAmbiente, ctsh, ctl, gsv, sYw, csw, nsv, agua,recibo,entrega,inyeccion,transferencia,drenaje,consumo,reciboAgua,entregaAgua,inyeccionAgua,transferenciaAgua,drenajeAgua,consumoAgua,fluido) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		// crear arraylist con objeto a consultar, agregar en el orden de la consulta
		arrayVar.add(op.getFecha());
		arrayVar.add(op.getHora());
		arrayVar.add(op.getIdTanque());
		arrayVar.add(op.getIdPozo());
		arrayVar.add(op.getTipo());
		arrayVar.add(op.getNivel());
		arrayVar.add(op.getTov());
		arrayVar.add(op.getInterfase());
		arrayVar.add(op.getFw());
		arrayVar.add(op.getGov());
		arrayVar.add(op.getApi());
		arrayVar.add(op.getTempFluido());
		arrayVar.add(op.getTempAmbiente());
		arrayVar.add(op.getCtsh());
		arrayVar.add(op.getCtl());
		arrayVar.add(op.getGsv());
		arrayVar.add(op.getsYw());
		arrayVar.add(op.getCsw());
		arrayVar.add(op.getNsv());
		arrayVar.add(op.getAgua());
		arrayVar.add(op.getRecibo());
		arrayVar.add(op.getEntrega());
		arrayVar.add(op.getInyeccion());
		arrayVar.add(op.getTransferencia());
		arrayVar.add(op.getDrenaje());
		arrayVar.add(op.getConsumo());
		arrayVar.add(op.getReciboAgua());
		arrayVar.add(op.getEntregaAgua());
		arrayVar.add(op.getInyeccionAgua());
		arrayVar.add(op.getTransferenciaAgua());
		arrayVar.add(op.getDrenajeAgua());
		arrayVar.add(op.getConsumoAgua());
		arrayVar.add(op.getFluido());

		// ejecutar consulta y almacenar resultados en rs si se requiere
		estado = consultas.writeSQL(query, arrayVar);
		return estado;
	}

	public boolean editarDatos(OperacionTk op) throws SQLException {

		// creacion de variables para la consulta
		Consultas consultas = new Consultas();
		ArrayList arrayVar = new ArrayList();
		boolean estado = false;

		// consulta a realizar
		String query = "UPDATE operaciontk SET fecha=?, hora=?, tipo=?, nivel=?, tov=?, interfase=?, fw=?, gov=?, api=?, tempFluido=?, tempAmbiente=?, ctsh=?, ctl=?, gsv=?, sYw=?, csw=?, nsv=?, agua=?,recibo=?,entrega=?,inyeccion=?,transferencia=?,drenaje=?,consumo=?,reciboAgua=?,entregaAgua=?,inyeccionAgua=?,transferenciaAgua=?,drenajeAgua=?,consumoAgua=?,fluido=? WHERE idTanque=? AND idPozo=? AND consecutivo=?";

		// crear arraylist con objeto a consultar, agregar en el orden de la consulta
		arrayVar.add(op.getFecha());
		arrayVar.add(op.getHora());
		arrayVar.add(op.getTipo());
		arrayVar.add(op.getNivel());
		arrayVar.add(op.getTov());
		arrayVar.add(op.getInterfase());
		arrayVar.add(op.getFw());
		arrayVar.add(op.getGov());
		arrayVar.add(op.getApi());
		arrayVar.add(op.getTempFluido());
		arrayVar.add(op.getTempAmbiente());
		arrayVar.add(op.getCtsh());
		arrayVar.add(op.getCtl());
		arrayVar.add(op.getGsv());
		arrayVar.add(op.getsYw());
		arrayVar.add(op.getCsw());
		arrayVar.add(op.getNsv());
		arrayVar.add(op.getAgua());
		arrayVar.add(op.getRecibo());
		arrayVar.add(op.getEntrega());
		arrayVar.add(op.getInyeccion());
		arrayVar.add(op.getTransferencia());
		arrayVar.add(op.getDrenaje());
		arrayVar.add(op.getConsumo());
		arrayVar.add(op.getReciboAgua());
		arrayVar.add(op.getEntregaAgua());
		arrayVar.add(op.getInyeccionAgua());
		arrayVar.add(op.getTransferenciaAgua());
		arrayVar.add(op.getDrenajeAgua());
		arrayVar.add(op.getConsumoAgua());
		arrayVar.add(op.getFluido());
		arrayVar.add(op.getIdTanque());
		arrayVar.add(op.getIdPozo());
		arrayVar.add(op.getConsecutivo());

		// ejecutar consulta y almacenar resultados en rs si se requiere
		estado = consultas.writeSQL(query, arrayVar);
		return estado;
	}

	public boolean eliminarDatos(OperacionTk op) throws SQLException {

		// creacion de variables para la consulta
		Consultas consultas = new Consultas();
		ArrayList arrayVar = new ArrayList();
		boolean estado = false;

		// consulta a realizar
		String query = "DELETE FROM operaciontk WHERE consecutivo=?";

		// crear arraylist con objeto a consultar, agregar en el orden de la consulta
		arrayVar.add(op.getConsecutivo());

		// ejecutar consulta y almacenar resultados en rs si se requiere
		estado = consultas.writeSQL(query, arrayVar);
		return estado;
	}

	public DefaultTableModel listarMovimientosDelDia(OperacionTk op) throws SQLException {

		// creacion de variables para la consulta
		Consultas consultas = new Consultas();
		ArrayList arrayVar = new ArrayList();
		ResultSet rs;
		// modelo de la tabla
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new Object[] { "pozo", "fecha", "hora", "tipo", "nivel", "tov", "interfase", "fw",
				"api", "tempFluido", "tempAmbiente", "sYw", "nsv", "agua", "fluido" });

		// consulta a realizar
		String query = "SELECT consecutivo,idPozo,fecha,hora,tipo,nivel,tov,interfase,fw,api,tempFluido,tempAmbiente,sYw,nsv,agua,fluido FROM operaciontk WHERE idTanque=? AND fecha=? ORDER BY consecutivo DESC";

		// crear arraylist con objeto a consultar, agregar en el orden de la consulta
		arrayVar.add(op.getIdTanque());
		arrayVar.add(op.getFecha());

		// ejecutar consulta y almacenar resultados en rs si se requiere
		rs = consultas.readSQL(query, arrayVar);

		// asignar resultados a modelo de la tabla
		try {
			if (rs != null) {
				modelo.addRow(new Object[] { rs.getString("idPozo"), rs.getDate("fecha"), rs.getTime("hora"),
						rs.getString("tipo"), rs.getDouble("nivel"), rs.getDouble("tov"), rs.getDouble("interfase"),
						rs.getDouble("fw"), rs.getDouble("api"), rs.getDouble("tempFluido"),
						rs.getDouble("tempAmbiente"), rs.getDouble("sYw"), rs.getDouble("nsv"), rs.getDouble("agua"),
						rs.getString("fluido") });
				while (rs.next()) {
					modelo.addRow(new Object[] { rs.getString("idPozo"), rs.getDate("fecha"), rs.getTime("hora"),
							rs.getString("tipo"), rs.getDouble("nivel"), rs.getDouble("tov"), rs.getDouble("interfase"),
							rs.getDouble("fw"), rs.getDouble("api"), rs.getDouble("tempFluido"),
							rs.getDouble("tempAmbiente"), rs.getDouble("sYw"), rs.getDouble("nsv"),
							rs.getDouble("agua"), rs.getString("fluido") });
				}
			}
			// consulta exitosa
			// para consultas que tienen rs se debe cerrar la conexion en cada
			// funcion
			consultas.cerrarConexion();
		} catch (SQLException e) {
			System.err.println("ERROR " + e);
		}

		return modelo;
	}

	public boolean buscarUltimosXfechaParaBalance(OperacionTk op) throws SQLException {

		// creacion de variables para la consulta
		Consultas consultas = new Consultas();
		ArrayList arrayVar = new ArrayList();
		ResultSet rs;
		boolean estado = false;
		String query;

		// consulta a realizar
		if (!op.getIdPozo().isBlank()) {
			query = "SELECT * FROM operaciontk WHERE  idTanque=? AND idPozo=? AND fecha<=? ORDER BY consecutivo DESC LIMIT 1";

			// crear arraylist con objeto a consultar, agregar en el orden de la consulta
			arrayVar.add(op.getIdTanque());
			arrayVar.add(op.getIdPozo());
			arrayVar.add(op.getFecha());
		} else {
			query = "SELECT * FROM operaciontk WHERE  idTanque=? AND fecha<=? ORDER BY consecutivo DESC LIMIT 1";

			// crear arraylist con objeto a consultar, agregar en el orden de la consulta
			arrayVar.add(op.getIdTanque());
			arrayVar.add(op.getFecha());
		}

		// ejecutar consulta y almacenar resultados en rs si se requiere
		rs = consultas.readSQL(query, arrayVar);

		// asignar resultados a setter de objeto
		try {
			if (rs != null) {
//                op.setConsecutivo(rs.getInt("consecutivo"));
				op.setIdPozo(rs.getString("idPozo"));
				op.setFecha(rs.getDate("fecha"));
//                op.setHora(rs.getTime("hora"));
//                op.setTipo(rs.getString("tipo"));
                op.setNivel(rs.getDouble("nivel"));
                op.setTov(rs.getDouble("tov"));
                op.setInterfase(rs.getDouble("interfase"));
//                op.setFw(rs.getDouble("fw"));
                op.setGov(rs.getDouble("gov"));
//                op.setApi(rs.getDouble("api"));
//                op.setTempFluido(rs.getDouble("tempFluido"));
//                op.setTempAmbiente(rs.getDouble("tempAmbiente"));
//                op.setCtsh(rs.getDouble("ctsh"));
//                op.setCtl(rs.getDouble("ctl"));
                op.setGsv(rs.getDouble("gsv"));
//                op.setsYw(rs.getDouble("sYw"));
				op.setNsv(rs.getDouble("nsv"));
				op.setAgua(rs.getDouble("agua"));
//                op.setRecibo(rs.getDouble("recibo"));
//                op.setEntrega(rs.getDouble("entrega"));
//                op.setInyeccion(rs.getDouble("inyeccion"));
//                op.setTransferencia(rs.getDouble("transferencia"));
//                op.setDrenaje(rs.getDouble("drenaje"));
//                op.setConsumo(rs.getDouble("consumo"));
//                op.setRecibo(rs.getDouble("reciboAgua"));
//                op.setEntrega(rs.getDouble("entregaAgua"));
//                op.setInyeccion(rs.getDouble("inyeccionAgua"));
//                op.setTransferencia(rs.getDouble("transferenciaAgua"));
//                op.setDrenaje(rs.getDouble("drenajeAgua"));
//                op.setConsumo(rs.getDouble("consumoAgua"));
				op.setFluido(rs.getString("fluido"));

				// consulta exitosa
				estado = true;
			}
			// para consultas que tienen rs se debe cerrar la conexion en cada
			// funcion
			consultas.cerrarConexion();
		} catch (SQLException e) {
			System.err.println("ERROR " + e);
		}

		return estado;
	}

	public boolean buscarPrimerosXfechaParaBalance(OperacionTk op) throws SQLException {

		// creacion de variables para la consulta
		Consultas consultas = new Consultas();
		ArrayList arrayVar = new ArrayList();
		ResultSet rs;
		boolean estado = false;
		String query;

		// consulta a realizar
		if (!op.getIdPozo().isBlank()) {
			query = "SELECT * FROM operaciontk WHERE  idTanque=? AND idPozo=? AND fecha<=? ORDER BY consecutivo ASC LIMIT 1";

			// crear arraylist con objeto a consultar, agregar en el orden de la consulta
			arrayVar.add(op.getIdTanque());
			arrayVar.add(op.getIdPozo());
			arrayVar.add(op.getFecha());
		} else {
			query = "SELECT * FROM operaciontk WHERE  idTanque=? AND idPozo=? AND fecha<=? ORDER BY consecutivo ASC LIMIT 1";

			// crear arraylist con objeto a consultar, agregar en el orden de la consulta
			arrayVar.add(op.getIdTanque());
			arrayVar.add(op.getIdPozo());
			arrayVar.add(op.getFecha());
		}

		// ejecutar consulta y almacenar resultados en rs si se requiere
		rs = consultas.readSQL(query, arrayVar);

		// asignar resultados a setter de objeto
		try {
			if (rs != null) {
//                op.setConsecutivo(rs.getInt("consecutivo"));
                op.setIdPozo(rs.getString("idPozo"));
				op.setFecha(rs.getDate("fecha"));
//                op.setHora(rs.getTime("hora"));
//                op.setTipo(rs.getString("tipo"));
                op.setNivel(rs.getDouble("nivel"));
                op.setTov(rs.getDouble("tov"));
                op.setInterfase(rs.getDouble("interfase"));
//                op.setFw(rs.getDouble("fw"));
                op.setGov(rs.getDouble("gov"));
//                op.setApi(rs.getDouble("api"));
//                op.setTempFluido(rs.getDouble("tempFluido"));
//                op.setTempAmbiente(rs.getDouble("tempAmbiente"));
//                op.setCtsh(rs.getDouble("ctsh"));
//                op.setCtl(rs.getDouble("ctl"));
                op.setGsv(rs.getDouble("gsv"));
//                op.setsYw(rs.getDouble("sYw"));
				op.setNsv(rs.getDouble("nsv"));
				op.setAgua(rs.getDouble("agua"));
//                op.setRecibo(rs.getDouble("recibo"));
//                op.setEntrega(rs.getDouble("entrega"));
//                op.setInyeccion(rs.getDouble("inyeccion"));
//                op.setTransferencia(rs.getDouble("transferencia"));
//                op.setDrenaje(rs.getDouble("drenaje"));
//                op.setConsumo(rs.getDouble("consumo"));
//                op.setReciboAgua(rs.getDouble("reciboAgua"));
//                op.setEntregaAgua(rs.getDouble("entregaAgua"));
//                op.setInyeccionAgua(rs.getDouble("inyeccionAgua"));
//                op.setTransferenciaAgua(rs.getDouble("transferenciaAgua"));
//                op.setDrenajeAgua(rs.getDouble("drenajeAgua"));
//                op.setConsumoAgua(rs.getDouble("consumoAgua"));
				op.setFluido(rs.getString("fluido"));

				// consulta exitosa
				estado = true;
			}
			// para consultas que tienen rs se debe cerrar la conexion en cada
			// funcion
			consultas.cerrarConexion();
		} catch (SQLException e) {
			System.err.println("ERROR " + e);
		}

		return estado;
	}

	public boolean buscarPrimerosdelDiaParaBalance(OperacionTk op) throws SQLException {

		// creacion de variables para la consulta
		Consultas consultas = new Consultas();
		ArrayList arrayVar = new ArrayList();
		ResultSet rs;
		boolean estado = false;

		// consulta a realizar
		String query = "SELECT * FROM operaciontk WHERE  idTanque=? AND idPozo=? AND fecha=? ORDER BY consecutivo ASC LIMIT 1";

		// crear arraylist con objeto a consultar, agregar en el orden de la consulta
		arrayVar.add(op.getIdTanque());
		arrayVar.add(op.getIdPozo());
		arrayVar.add(op.getFecha());

		// ejecutar consulta y almacenar resultados en rs si se requiere
		rs = consultas.readSQL(query, arrayVar);

		// asignar resultados a setter de objeto
		try {
			if (rs != null) {
//                op.setConsecutivo(rs.getInt("consecutivo"));
//                op.setIdPozo(rs.getString("idPozo"));
				op.setFecha(rs.getDate("fecha"));
//                op.setHora(rs.getTime("hora"));
//                op.setTipo(rs.getString("tipo"));
//                op.setNivel(rs.getDouble("nivel"));
//                op.setTov(rs.getDouble("tov"));
//                op.setInterfase(rs.getDouble("interfase"));
//                op.setFw(rs.getDouble("fw"));
//                op.setGov(rs.getDouble("gov"));
//                op.setApi(rs.getDouble("api"));
//                op.setTempFluido(rs.getDouble("tempFluido"));
//                op.setTempAmbiente(rs.getDouble("tempAmbiente"));
//                op.setCtsh(rs.getDouble("ctsh"));
//                op.setCtl(rs.getDouble("ctl"));
//                op.setGsv(rs.getDouble("gsv"));
//                op.setsYw(rs.getDouble("sYw"));
				op.setNsv(rs.getDouble("nsv"));
				op.setAgua(rs.getDouble("agua"));
//                op.setRecibo(rs.getDouble("recibo"));
//                op.setEntrega(rs.getDouble("entrega"));
//                op.setInyeccion(rs.getDouble("inyeccion"));
//                op.setTransferencia(rs.getDouble("transferencia"));
//                op.setDrenaje(rs.getDouble("drenaje"));
//                op.setConsumo(rs.getDouble("consumo"));
//                op.setReciboAgua(rs.getDouble("reciboAgua"));
//                op.setEntregaAgua(rs.getDouble("entregaAgua"));
//                op.setInyeccionAgua(rs.getDouble("inyeccionAgua"));
//                op.setTransferenciaAgua(rs.getDouble("transferenciaAgua"));
//                op.setDrenajeAgua(rs.getDouble("drenajeAgua"));
//                op.setConsumoAgua(rs.getDouble("consumoAgua"));
//                op.setFluido(rs.getString("fluido"));

				// consulta exitosa
				estado = true;
			}
			// para consultas que tienen rs se debe cerrar la conexion en cada
			// funcion
			consultas.cerrarConexion();
		} catch (SQLException e) {
			System.err.println("ERROR " + e);
		}

		return estado;
	}

	public boolean buscarsumaDiaXTk(OperacionTk op) throws SQLException {

		// creacion de variables para la consulta
		Consultas consultas = new Consultas();
		ArrayList arrayVar = new ArrayList();
		ResultSet rs;
		boolean estado = false;

		// consulta a realizar
		String query = "SELECT fecha, SUM(recibo) AS recibo, SUM(entrega) AS entrega, SUM(inyeccion) AS inyeccion, SUM(transferencia) AS transferencia, SUM(drenaje) AS drenaje, SUM(consumo) AS consumo, SUM(reciboAgua) AS reciboAgua, SUM(entregaAgua) AS entregaAgua, SUM(inyeccionAgua) AS inyeccionAgua, SUM(transferenciaAgua) AS transferenciaAgua, SUM(drenajeAgua) AS drenajeAgua, SUM(consumoAgua) AS consumoAgua, fluido FROM operaciontk WHERE  idTanque=? AND idPozo=? AND fecha=?";

		// crear arraylist con objeto a consultar, agregar en el orden de la consulta
		arrayVar.add(op.getIdTanque());
		arrayVar.add(op.getIdPozo());
		arrayVar.add(op.getFecha());

		// ejecutar consulta y almacenar resultados en rs si se requiere
		rs = consultas.readSQL(query, arrayVar);

		// asignar resultados a setter de objeto
		try {
			if (rs != null) {
//                op.setConsecutivo(rs.getInt("consecutivo"));
//                op.setIdPozo(rs.getString("idPozo"));
//                op.setFecha(rs.getDate("fecha"));
//                op.setHora(rs.getTime("hora"));
//                op.setTipo(rs.getString("tipo"));
//                op.setNivel(rs.getDouble("nivel"));
//                op.setTov(rs.getDouble("tov"));
//                op.setInterfase(rs.getDouble("interfase"));
//                op.setFw(rs.getDouble("fw"));
//                op.setGov(rs.getDouble("gov"));
//                op.setApi(rs.getDouble("api"));
//                op.setTempFluido(rs.getDouble("tempFluido"));
//                op.setTempAmbiente(rs.getDouble("tempAmbiente"));
//                op.setCtsh(rs.getDouble("ctsh"));
//                op.setCtl(rs.getDouble("ctl"));
//                op.setGsv(rs.getDouble("gsv"));
//                op.setsYw(rs.getDouble("sYw"));
//                op.setNsv(rs.getDouble("nsv"));
//                op.setAgua(rs.getDouble("agua"));
				op.setRecibo(rs.getDouble("recibo"));
				op.setEntrega(rs.getDouble("entrega"));
				op.setInyeccion(rs.getDouble("inyeccion"));
				op.setTransferencia(rs.getDouble("transferencia"));
				op.setDrenaje(rs.getDouble("drenaje"));
				op.setConsumo(rs.getDouble("consumo"));
				op.setReciboAgua(rs.getDouble("reciboAgua"));
				op.setEntregaAgua(rs.getDouble("entregaAgua"));
				op.setInyeccionAgua(rs.getDouble("inyeccionAgua"));
				op.setTransferenciaAgua(rs.getDouble("transferenciaAgua"));
				op.setDrenajeAgua(rs.getDouble("drenajeAgua"));
				op.setConsumoAgua(rs.getDouble("consumoAgua"));
				op.setFluido(rs.getString("fluido"));

				// consulta exitosa
				estado = true;
			}
			// para consultas que tienen rs se debe cerrar la conexion en cada
			// funcion
			consultas.cerrarConexion();
		} catch (SQLException e) {
			System.err.println("ERROR " + e);
		}

		return estado;
	}

	public boolean buscarSumaDiaTotal(OperacionTk op) throws SQLException {

		// creacion de variables para la consulta
		Consultas consultas = new Consultas();
		ArrayList arrayVar = new ArrayList();
		ResultSet rs;
		boolean estado = false;

		// consulta a realizar
		String query = "SELECT fecha, SUM(recibo) AS recibo, SUM(entrega) AS entrega, SUM(inyeccion) AS inyeccion, SUM(transferencia) AS transferencia, SUM(drenaje) AS drenaje, SUM(consumo) AS consumo, SUM(reciboAgua) AS reciboAgua, SUM(entregaAgua) AS entregaAgua, SUM(inyeccionAgua) AS inyeccionAgua, SUM(transferenciaAgua) AS transferenciaAgua, SUM(drenajeAgua) AS drenajeAgua, SUM(consumoAgua) AS consumoAgua FROM operaciontk WHERE idPozo=? AND fecha=? AND fluido=?";

		// crear arraylist con objeto a consultar, agregar en el orden de la consulta
		arrayVar.add(op.getIdPozo());
		arrayVar.add(op.getFecha());
		arrayVar.add(op.getFluido());

		// ejecutar consulta y almacenar resultados en rs si se requiere
		rs = consultas.readSQL(query, arrayVar);

		// asignar resultados a setter de objeto
		try {
			if (rs != null) {
//                op.setConsecutivo(rs.getInt("consecutivo"));
//                op.setIdPozo(rs.getString("idPozo"));
//                op.setFecha(rs.getDate("fecha"));
//                op.setHora(rs.getTime("hora"));
//                op.setTipo(rs.getString("tipo"));
//                op.setNivel(rs.getDouble("nivel"));
//                op.setTov(rs.getDouble("tov"));
//                op.setInterfase(rs.getDouble("interfase"));
//                op.setFw(rs.getDouble("fw"));
//                op.setGov(rs.getDouble("gov"));
//                op.setApi(rs.getDouble("api"));
//                op.setTempFluido(rs.getDouble("tempFluido"));
//                op.setTempAmbiente(rs.getDouble("tempAmbiente"));
//                op.setCtsh(rs.getDouble("ctsh"));
//                op.setCtl(rs.getDouble("ctl"));
//                op.setGsv(rs.getDouble("gsv"));
//                op.setsYw(rs.getDouble("sYw"));
//                op.setNsv(rs.getDouble("nsv"));
//                op.setAgua(rs.getDouble("agua"));
				op.setRecibo(rs.getDouble("recibo"));
				op.setEntrega(rs.getDouble("entrega"));
				op.setInyeccion(rs.getDouble("inyeccion"));
				op.setTransferencia(rs.getDouble("transferencia"));
				op.setDrenaje(rs.getDouble("drenaje"));
				op.setConsumo(rs.getDouble("consumo"));
				op.setReciboAgua(rs.getDouble("reciboAgua"));
				op.setEntregaAgua(rs.getDouble("entregaAgua"));
				op.setInyeccionAgua(rs.getDouble("inyeccionAgua"));
				op.setTransferenciaAgua(rs.getDouble("transferenciaAgua"));
				op.setDrenajeAgua(rs.getDouble("drenajeAgua"));
				op.setConsumoAgua(rs.getDouble("consumoAgua"));
//                op.setFluido(rs.getString("fluido"));

				// consulta exitosa
				estado = true;
			}
			// para consultas que tienen rs se debe cerrar la conexion en cada
			// funcion
			consultas.cerrarConexion();
		} catch (SQLException e) {
			System.err.println("ERROR " + e);
		}

		return estado;
	}

	public boolean buscarPromedioDiaAPI(OperacionTk op) throws SQLException {

		// creacion de variables para la consulta
		Consultas consultas = new Consultas();
		ArrayList arrayVar = new ArrayList();
		ResultSet rs;
		boolean estado = false;

		// consulta a realizar
		String query = "SELECT fecha, AVG(api) AS api FROM operaciontk WHERE idPozo=? AND fecha=? AND fluido=? AND tipo=?";

		// crear arraylist con objeto a consultar, agregar en el orden de la consulta
		arrayVar.add(op.getIdPozo());
		arrayVar.add(op.getFecha());
		arrayVar.add(op.getFluido());
		arrayVar.add("Recibo");

		// ejecutar consulta y almacenar resultados en rs si se requiere
		rs = consultas.readSQL(query, arrayVar);

		// asignar resultados a setter de objeto
		try {
			if (rs != null) {
//                op.setConsecutivo(rs.getInt("consecutivo"));
//                op.setIdPozo(rs.getString("idPozo"));
//                op.setFecha(rs.getDate("fecha"));
//                op.setHora(rs.getTime("hora"));
//                op.setTipo(rs.getString("tipo"));
//                op.setNivel(rs.getDouble("nivel"));
//                op.setTov(rs.getDouble("tov"));
//                op.setInterfase(rs.getDouble("interfase"));
//                op.setFw(rs.getDouble("fw"));
//                op.setGov(rs.getDouble("gov"));
				op.setApi(rs.getDouble("api"));
//                op.setTempFluido(rs.getDouble("tempFluido"));
//                op.setTempAmbiente(rs.getDouble("tempAmbiente"));
//                op.setCtsh(rs.getDouble("ctsh"));
//                op.setCtl(rs.getDouble("ctl"));
//                op.setGsv(rs.getDouble("gsv"));
//                op.setsYw(rs.getDouble("sYw"));
//                op.setNsv(rs.getDouble("nsv"));
//                op.setAgua(rs.getDouble("agua"));
//                op.setRecibo(rs.getDouble("recibo"));
//                op.setEntrega(rs.getDouble("entrega"));
//                op.setInyeccion(rs.getDouble("inyeccion"));
//                op.setTransferencia(rs.getDouble("transferencia"));
//                op.setDrenaje(rs.getDouble("drenaje"));
//                op.setConsumo(rs.getDouble("consumo"));
//                op.setReciboAgua(rs.getDouble("reciboAgua"));
//                op.setEntregaAgua(rs.getDouble("entregaAgua"));
//                op.setInyeccionAgua(rs.getDouble("inyeccionAgua"));
//                op.setTransferenciaAgua(rs.getDouble("transferenciaAgua"));
//                op.setDrenajeAgua(rs.getDouble("drenajeAgua"));
//                op.setConsumoAgua(rs.getDouble("consumoAgua"));
////                op.setFluido(rs.getString("fluido"));

				// consulta exitosa
				estado = true;
			}
			// para consultas que tienen rs se debe cerrar la conexion en cada
			// funcion
			consultas.cerrarConexion();
		} catch (SQLException e) {
			System.err.println("ERROR " + e);
		}

		return estado;
	}

	public boolean buscarUltimoXPozoYTk(OperacionTk op) throws SQLException {

		// creacion de variables para la consulta
		Consultas consultas = new Consultas();
		ArrayList arrayVar = new ArrayList();
		ResultSet rs;
		boolean estado = false;

		// consulta a realizar
		String query = "SELECT * FROM operaciontk WHERE  idTanque=? AND idPozo=? ORDER BY consecutivo DESC LIMIT 1";

		// crear arraylist con objeto a consultar, agregar en el orden de la consulta
		arrayVar.add(op.getIdTanque());
		arrayVar.add(op.getIdPozo());

		// ejecutar consulta y almacenar resultados en rs si se requiere
		rs = consultas.readSQL(query, arrayVar);

		// asignar resultados a setter de objeto
		try {
			if (rs != null) {
//                op.setConsecutivo(rs.getInt("consecutivo"));
//                op.setIdPozo(rs.getString("idPozo"));
				op.setFecha(rs.getDate("fecha"));
				op.setHora(rs.getTime("hora"));
				op.setTipo(rs.getString("tipo"));
				op.setNivel(rs.getDouble("nivel"));
//                op.setTov(rs.getDouble("tov"));
				op.setInterfase(rs.getDouble("interfase"));
//                op.setFw(rs.getDouble("fw"));
//                op.setGov(rs.getDouble("gov"));
				op.setApi(rs.getDouble("api"));
				op.setTempFluido(rs.getDouble("tempFluido"));
				op.setTempAmbiente(rs.getDouble("tempAmbiente"));
//                op.setCtsh(rs.getDouble("ctsh"));
//                op.setCtl(rs.getDouble("ctl"));
//                op.setGsv(rs.getDouble("gsv"));
				op.setsYw(rs.getDouble("sYw"));
				op.setNsv(rs.getDouble("nsv"));
				op.setAgua(rs.getDouble("agua"));
//                op.setRecibo(rs.getDouble("recibo"));
//                op.setEntrega(rs.getDouble("entrega"));
//                op.setInyeccion(rs.getDouble("inyeccion"));
//                op.setTransferencia(rs.getDouble("transferencia"));
//                op.setDrenaje(rs.getDouble("drenaje"));
//                op.setConsumo(rs.getDouble("consumo"));
//                op.setRecibo(rs.getDouble("reciboAgua"));
//                op.setEntrega(rs.getDouble("entregaAgua"));
//                op.setInyeccion(rs.getDouble("inyeccionAgua"));
//                op.setTransferencia(rs.getDouble("transferenciaAgua"));
//                op.setDrenaje(rs.getDouble("drenajeAgua"));
//                op.setConsumo(rs.getDouble("consumoAgua"));
				op.setFluido(rs.getString("fluido"));

				// consulta exitosa
				estado = true;
			}
			// para consultas que tienen rs se debe cerrar la conexion en cada
			// funcion
			consultas.cerrarConexion();
		} catch (SQLException e) {
			System.err.println("ERROR " + e);
		}

		return estado;
	}

	public boolean buscarUltimoSinTk(OperacionTk op) throws SQLException {

		// creacion de variables para la consulta
		Consultas consultas = new Consultas();
		ArrayList arrayVar = new ArrayList();
		ResultSet rs;
		boolean estado = false;

		// consulta a realizar
		String query = "SELECT fecha,hora,idTanque,idPozo FROM operaciontk AS t1 INNER JOIN (SELECT MAX(fecha)AS fecha1 from operaciontk)AS t2 ON t1.fecha=t2.fecha1 ORDER BY hora DESC LIMIT 1";

		// crear arraylist con objeto a consultar, agregar en el orden de la consulta
		// arrayVar.add(op.getIdTanque());

		// ejecutar consulta y almacenar resultados en rs si se requiere
		rs = consultas.readSQL(query, arrayVar);

		// asignar resultados a setter de objeto
		try {
			if (rs != null) {
//                op.setConsecutivo(rs.getInt("consecutivo"));
				op.setIdTanque(rs.getString("idTanque"));
				op.setIdPozo(rs.getString("idPozo"));
				op.setFecha(rs.getDate("fecha"));
				op.setHora(rs.getTime("hora"));
//                op.setTipo(rs.getString("tipo"));
//                op.setNivel(rs.getDouble("nivel"));
//                op.setTov(rs.getDouble("tov"));
//                op.setInterfase(rs.getDouble("interfase"));
//                op.setFw(rs.getDouble("fw"));
//                op.setGov(rs.getDouble("gov"));
//                op.setApi(rs.getDouble("api"));
//                op.setTempFluido(rs.getDouble("tempFluido"));
//                op.setTempAmbiente(rs.getDouble("tempAmbiente"));
//                op.setCtsh(rs.getDouble("ctsh"));
//                op.setCtl(rs.getDouble("ctl"));
//                op.setGsv(rs.getDouble("gsv"));
//                op.setsYw(rs.getDouble("sYw"));
//                op.setNsv(rs.getDouble("nsv"));
//                op.setAgua(rs.getDouble("agua"));
//                op.setRecibo(rs.getDouble("recibo"));
//                op.setEntrega(rs.getDouble("entrega"));
//                op.setInyeccion(rs.getDouble("inyeccion"));
//                op.setTransferencia(rs.getDouble("transferencia"));
//                op.setDrenaje(rs.getDouble("drenaje"));
//                op.setConsumo(rs.getDouble("consumo"));
//                op.setRecibo(rs.getDouble("reciboAgua"));
//                op.setEntrega(rs.getDouble("entregaAgua"));
//                op.setInyeccion(rs.getDouble("inyeccionAgua"));
//                op.setTransferencia(rs.getDouble("transferenciaAgua"));
//                op.setDrenaje(rs.getDouble("drenajeAgua"));
//                op.setConsumo(rs.getDouble("consumoAgua"));
//                op.setFluido(rs.getString("fluido"));

				// consulta exitosa
				estado = true;
			}
			// para consultas que tienen rs se debe cerrar la conexion en cada
			// funcion
			consultas.cerrarConexion();
		} catch (SQLException e) {
			System.err.println("ERROR " + e);
		}

		return estado;
	}

	public boolean buscarUltimoXPozo(OperacionTk op) throws SQLException {

		// creacion de variables para la consulta
		Consultas consultas = new Consultas();
		ArrayList arrayVar = new ArrayList();
		ResultSet rs;
		boolean estado = false;

		// consulta a realizar
		String query = "SELECT * FROM operaciontk WHERE idPozo=? ORDER BY consecutivo DESC LIMIT 1";

		// crear arraylist con objeto a consultar, agregar en el orden de la consulta
		arrayVar.add(op.getIdPozo());

		// ejecutar consulta y almacenar resultados en rs si se requiere
		rs = consultas.readSQL(query, arrayVar);

		// asignar resultados a setter de objeto
		try {
			if (rs != null) {
				op.setConsecutivo(rs.getInt("consecutivo"));
//                op.setIdPozo(rs.getString("idPozo"));
				op.setFecha(rs.getDate("fecha"));
//                op.setHora(rs.getTime("hora"));
//                op.setTipo(rs.getString("tipo"));
//                op.setNivel(rs.getDouble("nivel"));
//                op.setTov(rs.getDouble("tov"));
//                op.setInterfase(rs.getDouble("interfase"));
//                op.setFw(rs.getDouble("fw"));
//                op.setGov(rs.getDouble("gov"));
//                op.setApi(rs.getDouble("api"));
//                op.setTempFluido(rs.getDouble("tempFluido"));
//                op.setTempAmbiente(rs.getDouble("tempAmbiente"));
//                op.setCtsh(rs.getDouble("ctsh"));
//                op.setCtl(rs.getDouble("ctl"));
//                op.setGsv(rs.getDouble("gsv"));
//                op.setsYw(rs.getDouble("sYw"));
//                op.setNsv(rs.getDouble("nsv"));
//                op.setAgua(rs.getDouble("agua"));
//                op.setRecibo(rs.getDouble("recibo"));
//                op.setEntrega(rs.getDouble("entrega"));
//                op.setInyeccion(rs.getDouble("inyeccion"));
//                op.setTransferencia(rs.getDouble("transferencia"));
//                op.setDrenaje(rs.getDouble("drenaje"));
//                op.setConsumo(rs.getDouble("consumo"));
//                op.setRecibo(rs.getDouble("reciboAgua"));
//                op.setEntrega(rs.getDouble("entregaAgua"));
//                op.setInyeccion(rs.getDouble("inyeccionAgua"));
//                op.setTransferencia(rs.getDouble("transferenciaAgua"));
//                op.setDrenaje(rs.getDouble("drenajeAgua"));
//                op.setConsumo(rs.getDouble("consumoAgua"));
//                op.setFluido(rs.getString("fluido"));

				// consulta exitosa
				estado = true;
			}
			// para consultas que tienen rs se debe cerrar la conexion en cada
			// funcion
			consultas.cerrarConexion();
		} catch (SQLException e) {
			System.err.println("ERROR " + e);
		}

		return estado;
	}

	public boolean buscaSiHayInicial(OperacionTk op) throws SQLException {

		// creacion de variables para la consulta
		Consultas consultas = new Consultas();
		ArrayList arrayVar = new ArrayList();
		ResultSet rs;
		boolean estado = false;

		// consulta a realizar
		String query = "SELECT * FROM operaciontk WHERE idPozo=? AND tipo=\"Inicial\" ORDER BY consecutivo DESC LIMIT 1";

		// crear arraylist con objeto a consultar, agregar en el orden de la consulta
		arrayVar.add(op.getIdPozo());

		// ejecutar consulta y almacenar resultados en rs si se requiere
		rs = consultas.readSQL(query, arrayVar);

		// asignar resultados a setter de objeto
		try {
			if (rs != null) {
				// op.setConsecutivo(rs.getInt("consecutivo"));
//                op.setIdPozo(rs.getString("idPozo"));
				op.setFecha(rs.getDate("fecha"));
//                op.setHora(rs.getTime("hora"));
//                op.setTipo(rs.getString("tipo"));
//                op.setNivel(rs.getDouble("nivel"));
//                op.setTov(rs.getDouble("tov"));
//                op.setInterfase(rs.getDouble("interfase"));
//                op.setFw(rs.getDouble("fw"));
//                op.setGov(rs.getDouble("gov"));
//                op.setApi(rs.getDouble("api"));
//                op.setTempFluido(rs.getDouble("tempFluido"));
//                op.setTempAmbiente(rs.getDouble("tempAmbiente"));
//                op.setCtsh(rs.getDouble("ctsh"));
//                op.setCtl(rs.getDouble("ctl"));
//                op.setGsv(rs.getDouble("gsv"));
//                op.setsYw(rs.getDouble("sYw"));
//                op.setNsv(rs.getDouble("nsv"));
//                op.setAgua(rs.getDouble("agua"));
//                op.setRecibo(rs.getDouble("recibo"));
//                op.setEntrega(rs.getDouble("entrega"));
//                op.setInyeccion(rs.getDouble("inyeccion"));
//                op.setTransferencia(rs.getDouble("transferencia"));
//                op.setDrenaje(rs.getDouble("drenaje"));
//                op.setConsumo(rs.getDouble("consumo"));
//                op.setRecibo(rs.getDouble("reciboAgua"));
//                op.setEntrega(rs.getDouble("entregaAgua"));
//                op.setInyeccion(rs.getDouble("inyeccionAgua"));
//                op.setTransferencia(rs.getDouble("transferenciaAgua"));
//                op.setDrenaje(rs.getDouble("drenajeAgua"));
//                op.setConsumo(rs.getDouble("consumoAgua"));
//                op.setFluido(rs.getString("fluido"));

				// consulta exitosa
				estado = true;
			}
			// para consultas que tienen rs se debe cerrar la conexion en cada
			// funcion
			consultas.cerrarConexion();
		} catch (SQLException e) {
			System.err.println("ERROR " + e);
		}

		return estado;
	}

	public boolean buscarSumaInicialTotal(OperacionTk op) throws SQLException {

		// creacion de variables para la consulta
		Consultas consultas = new Consultas();
		ArrayList arrayVar = new ArrayList();
		ResultSet rs;
		boolean estado = false;

		// consulta a realizar
		String query = "SELECT fecha, SUM(nsv) AS nsv, SUM(agua) AS agua FROM operaciontk WHERE idPozo=? AND fecha=? AND fluido=? AND tipo=\"Inicial\"";

		// crear arraylist con objeto a consultar, agregar en el orden de la consulta
		arrayVar.add(op.getIdPozo());
		arrayVar.add(op.getFecha());
		arrayVar.add(op.getFluido());

		// ejecutar consulta y almacenar resultados en rs si se requiere
		rs = consultas.readSQL(query, arrayVar);

		// asignar resultados a setter de objeto
		try {
			if (rs != null) {
//                op.setConsecutivo(rs.getInt("consecutivo"));
//                op.setIdPozo(rs.getString("idPozo"));
//                op.setFecha(rs.getDate("fecha"));
//                op.setHora(rs.getTime("hora"));
//                op.setTipo(rs.getString("tipo"));
//                op.setNivel(rs.getDouble("nivel"));
//                op.setTov(rs.getDouble("tov"));
//                op.setInterfase(rs.getDouble("interfase"));
//                op.setFw(rs.getDouble("fw"));
//                op.setGov(rs.getDouble("gov"));
//                op.setApi(rs.getDouble("api"));
//                op.setTempFluido(rs.getDouble("tempFluido"));
//                op.setTempAmbiente(rs.getDouble("tempAmbiente"));
//                op.setCtsh(rs.getDouble("ctsh"));
//                op.setCtl(rs.getDouble("ctl"));
//                op.setGsv(rs.getDouble("gsv"));
//                op.setsYw(rs.getDouble("sYw"));
				op.setNsv(rs.getDouble("nsv"));
				op.setAgua(rs.getDouble("agua"));
//                op.setRecibo(rs.getDouble("recibo"));
//                op.setEntrega(rs.getDouble("entrega"));
//                op.setInyeccion(rs.getDouble("inyeccion"));
//                op.setTransferencia(rs.getDouble("transferencia"));
//                op.setDrenaje(rs.getDouble("drenaje"));
//                op.setConsumo(rs.getDouble("consumo"));
//                op.setReciboAgua(rs.getDouble("reciboAgua"));
//                op.setEntregaAgua(rs.getDouble("entregaAgua"));
//                op.setInyeccionAgua(rs.getDouble("inyeccionAgua"));
//                op.setTransferenciaAgua(rs.getDouble("transferenciaAgua"));
//                op.setDrenajeAgua(rs.getDouble("drenajeAgua"));
//                op.setConsumoAgua(rs.getDouble("consumoAgua"));
//                op.setFluido(rs.getString("fluido"));

				// consulta exitosa
				estado = true;
			}
			// para consultas que tienen rs se debe cerrar la conexion en cada
			// funcion
			consultas.cerrarConexion();
		} catch (SQLException e) {
			System.err.println("ERROR " + e);
		}

		return estado;
	}

}

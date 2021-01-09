package com.petra.controwell.model.data.querys;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.petra.controwell.model.data.Balance;
import com.petra.controwell.model.data.bdstruct.Consultas;

/**
 *
 * @author Angello Morales
 */
public class ConsultasBalance {

	public boolean buscarBalanceXFecha(Balance bal) throws SQLException {

		// creacion de variables para la consulta
		Consultas consultas = new Consultas();
		ArrayList arrayVar = new ArrayList();
		ResultSet rs;
		boolean estado = false;
		String query;

		// consulta a realizar
		if (!bal.getIdPozo().isBlank()) {
			query = "SELECT * FROM balance WHERE  idPozo=? AND fecha=?";

			// crear arraylist con objeto a consultar, agregar en el orden de la consulta
			arrayVar.add(bal.getIdPozo());
			arrayVar.add(bal.getFecha());
		} else {
			query = "SELECT * FROM balance WHERE fecha=?";

			// crear arraylist con objeto a consultar, agregar en el orden de la consulta
			arrayVar.add(bal.getFecha());
		}

		// ejecutar consulta y almacenar resultados en rs si se requiere
		rs = consultas.readSQL(query, arrayVar);

		// asignar resultados a setter de objeto
		try {
			if (rs != null) {
				// bal.setConsecutivo(rs.getInt("consecutivo"));
				bal.setIdPozo(rs.getString("idPozo"));
				bal.setFecha(rs.getDate("fecha"));
				bal.setIniciales(rs.getDouble("iniciales"));
				bal.setInicialesAgua(rs.getDouble("inicialesAgua"));
				bal.setInicialesDiluyente(rs.getDouble("inicialesDiluyente"));
				bal.setInicialesAguaDiluyente(rs.getDouble("inicialesAguaDiluyente"));
				bal.setFinales(rs.getDouble("finales"));
				bal.setFinalesAgua(rs.getDouble("finalesAgua"));
				bal.setFinalesDiluyente(rs.getDouble("finalesDiluyente"));
				bal.setFinalesAguaDiluyente(rs.getDouble("finalesAguaDiluyente"));
				bal.setRecibo(rs.getDouble("recibo"));
				bal.setEntrega(rs.getDouble("entrega"));
				bal.setInyeccion(rs.getDouble("inyeccion"));
				bal.setTransferencia(rs.getDouble("transferencia"));
				bal.setDrenaje(rs.getDouble("drenaje"));
				bal.setConsumo(rs.getDouble("consumo"));
				bal.setReciboDiluyente(rs.getDouble("reciboDiluyente"));
				bal.setEntregaDiluyente(rs.getDouble("entregaDiluyente"));
				bal.setInyeccionDiluyente(rs.getDouble("inyeccionDiluyente"));
				bal.setTransferenciaDiluyente(rs.getDouble("transferenciaDiluyente"));
				bal.setDrenajeDiluyente(rs.getDouble("drenajeDiluyente"));
				bal.setConsumoDiluyente(rs.getDouble("consumoDiluyente"));
				bal.setReciboAgua(rs.getDouble("reciboAgua"));
				bal.setEntregaAgua(rs.getDouble("entregaAgua"));
				bal.setInyeccionAgua(rs.getDouble("inyeccionAgua"));
				bal.setTransferenciaAgua(rs.getDouble("transferenciaAgua"));
				bal.setDrenajeAgua(rs.getDouble("drenajeAgua"));
				bal.setConsumoAgua(rs.getDouble("consumoAgua"));
				bal.setReciboAguaDiluyente(rs.getDouble("reciboAguaDiluyente"));
				bal.setEntregaAguaDiluyente(rs.getDouble("entregaAguaDiluyente"));
				bal.setInyeccionAguaDiluyente(rs.getDouble("inyeccionAguaDiluyente"));
				bal.setTransferenciaAguaDiluyente(rs.getDouble("transferenciaAguaDiluyente"));
				bal.setDrenajeAguaDiluyente(rs.getDouble("drenajeAguaDiluyente"));
				bal.setConsumoAguaDiluyente(rs.getDouble("consumoAguaDiluyente"));
				bal.setAceiteProducido(rs.getDouble("aceiteProducido"));
				bal.setGas(rs.getDouble("gas"));
				bal.setAguaProducida(rs.getDouble("aguaProducida"));
				bal.setComentarios(rs.getString("comentarios"));
				bal.setsYw(rs.getDouble("sYw"));
				bal.setRecibo24H(rs.getDouble("recibo24H"));
				bal.setAceiteProducido24H(rs.getDouble("aceiteProducido24H"));
				bal.setAguaProducida24H(rs.getDouble("aguaProducida24H"));
				bal.setInyeccionDiluyente24H(rs.getDouble("inyeccionDiluyente24H"));
				bal.setsYw24H(rs.getDouble("sYw24H"));
				bal.setGas24H(rs.getDouble("gas24H"));
				bal.setTiempoPrueba(rs.getDouble("tiempoPrueba"));
				bal.setGor(rs.getDouble("gor"));
				bal.setGor24H(rs.getDouble("gor24H"));
				bal.setFluidoTotal(rs.getDouble("fluidoTotal"));
				bal.setFluidoTotal24H(rs.getDouble("fluidoTotal24H"));
				bal.setApiMezcla(rs.getDouble("apiMezcla"));
				bal.setApiCabeza(rs.getDouble("apiCabeza"));
				bal.setViscocidad(rs.getDouble("viscocidad"));
				bal.setTempViscocidad(rs.getDouble("tempViscocidad"));
				bal.setSalinidad(rs.getDouble("salinidad"));
				bal.setCloruros(rs.getDouble("cloruros"));
				bal.setPh(rs.getDouble("ph"));
				bal.setChoke(rs.getDouble("choke"));

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

	public boolean agregarDatosBalance(Balance bal) throws SQLException {

		// creacion de variables para la consulta
		Consultas consultas = new Consultas();
		ArrayList arrayVar = new ArrayList();
		boolean estado = false;

		// consulta a realizar
		String query = "INSERT INTO balance(fecha, idPozo,iniciales,inicialesAgua,inicialesDiluyente,inicialesAguaDiluyente,finales,finalesAgua,finalesDiluyente,finalesAguaDiluyente,recibo,entrega,inyeccion,transferencia,drenaje,consumo,reciboDiluyente,entregaDiluyente,inyeccionDiluyente,transferenciaDiluyente,drenajeDiluyente,consumoDiluyente,reciboAgua,entregaAgua,inyeccionAgua,transferenciaAgua,drenajeAgua,consumoAgua,reciboAguaDiluyente,entregaAguaDiluyente,inyeccionAguaDiluyente,transferenciaAguaDiluyente,drenajeAguaDiluyente,consumoAguaDiluyente,aceiteProducido,gas,aguaProducida,comentarios,sYw,recibo24H,aceiteProducido24H,aguaProducida24H,inyeccionDiluyente24H,sYw24H,gas24H,tiempoPrueba,gor,gor24H,fluidoTotal,fluidoTotal24H,apiMezcla,apiCabeza,viscocidad,tempViscocidad,salinidad,cloruros,ph,choke) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		// crear arraylist con objeto a consultar, agregar en el orden de la consulta
		arrayVar.add(bal.getFecha());
		arrayVar.add(bal.getIdPozo());
		arrayVar.add(bal.getIniciales());
		arrayVar.add(bal.getInicialesAgua());
		arrayVar.add(bal.getInicialesDiluyente());
		arrayVar.add(bal.getInicialesAguaDiluyente());
		arrayVar.add(bal.getFinales());
		arrayVar.add(bal.getFinalesAgua());
		arrayVar.add(bal.getFinalesDiluyente());
		arrayVar.add(bal.getFinalesAguaDiluyente());
		arrayVar.add(bal.getRecibo());
		arrayVar.add(bal.getEntrega());
		arrayVar.add(bal.getInyeccion());
		arrayVar.add(bal.getTransferencia());
		arrayVar.add(bal.getDrenaje());
		arrayVar.add(bal.getConsumo());
		arrayVar.add(bal.getReciboDiluyente());
		arrayVar.add(bal.getEntregaDiluyente());
		arrayVar.add(bal.getInyeccionDiluyente());
		arrayVar.add(bal.getTransferenciaDiluyente());
		arrayVar.add(bal.getDrenajeDiluyente());
		arrayVar.add(bal.getConsumoDiluyente());
		arrayVar.add(bal.getReciboAgua());
		arrayVar.add(bal.getEntregaAgua());
		arrayVar.add(bal.getInyeccionAgua());
		arrayVar.add(bal.getTransferenciaAgua());
		arrayVar.add(bal.getDrenajeAgua());
		arrayVar.add(bal.getConsumoAgua());
		arrayVar.add(bal.getReciboAguaDiluyente());
		arrayVar.add(bal.getEntregaAguaDiluyente());
		arrayVar.add(bal.getInyeccionAguaDiluyente());
		arrayVar.add(bal.getTransferenciaAguaDiluyente());
		arrayVar.add(bal.getDrenajeAguaDiluyente());
		arrayVar.add(bal.getConsumoAguaDiluyente());
		arrayVar.add(bal.getAceiteProducido());
		arrayVar.add(bal.getGas());
		arrayVar.add(bal.getAguaProducida());
		arrayVar.add(bal.getComentarios());
		arrayVar.add(bal.getsYw());
		arrayVar.add(bal.getRecibo24H());
		arrayVar.add(bal.getAceiteProducido24H());
		arrayVar.add(bal.getAguaProducida24H());
		arrayVar.add(bal.getInyeccionDiluyente24H());
		arrayVar.add(bal.getsYw24H());
		arrayVar.add(bal.getGas24H());
		arrayVar.add(bal.getTiempoPrueba());
		arrayVar.add(bal.getGor());
		arrayVar.add(bal.getGor24H());
		arrayVar.add(bal.getFluidoTotal());
		arrayVar.add(bal.getFluidoTotal24H());
		arrayVar.add(bal.getApiMezcla());
		arrayVar.add(bal.getApiCabeza());
		arrayVar.add(bal.getViscocidad());
		arrayVar.add(bal.getTempViscocidad());
		arrayVar.add(bal.getSalinidad());
		arrayVar.add(bal.getCloruros());
		arrayVar.add(bal.getPh());
		arrayVar.add(bal.getChoke());

		// ejecutar consulta y almacenar resultados en rs si se requiere
		estado = consultas.writeSQL(query, arrayVar);
		return estado;
	}

	public boolean eliminarDatosBalance(Balance bal) throws SQLException {

		// creacion de variables para la consulta
		Consultas consultas = new Consultas();
		ArrayList arrayVar = new ArrayList();
		boolean estado = false;

		// consulta a realizar
		String query = "DELETE FROM balance WHERE  consecutivo=?";

		// crear arraylist con objeto a consultar, agregar en el orden de la consulta
		arrayVar.add(bal.getConsecutivo());

		// ejecutar consulta y almacenar resultados en rs si se requiere
		estado = consultas.writeSQL(query, arrayVar);
		return estado;
	}

	public boolean buscarUltimoXFecha(Balance bal) throws SQLException {

		// creacion de variables para la consulta
		Consultas consultas = new Consultas();
		ArrayList arrayVar = new ArrayList();
		ResultSet rs;
		boolean estado = false;
		String query;

		// consulta a realizar
		if (!bal.getIdPozo().isBlank()) {
			query = "SELECT * FROM balance WHERE  idPozo=? AND fecha<=? ORDER BY consecutivo DESC LIMIT 1";

			// crear arraylist con objeto a consultar, agregar en el orden de la consulta
			arrayVar.add(bal.getIdPozo());
			arrayVar.add(bal.getFecha());
		} else {
			query = "SELECT * FROM balance WHERE fecha<=? ORDER BY consecutivo DESC LIMIT 1";

			// crear arraylist con objeto a consultar, agregar en el orden de la consulta
			arrayVar.add(bal.getFecha());
		}

		// ejecutar consulta y almacenar resultados en rs si se requiere
		rs = consultas.readSQL(query, arrayVar);

		// asignar resultados a setter de objeto
		try {
			if (rs != null) {
				// bal.setConsecutivo(rs.getInt("consecutivo"));
				bal.setIdPozo(rs.getString("idPozo"));
				bal.setFecha(rs.getDate("fecha"));
				bal.setIniciales(rs.getDouble("iniciales"));
				bal.setInicialesAgua(rs.getDouble("inicialesAgua"));
				bal.setInicialesDiluyente(rs.getDouble("inicialesDiluyente"));
				bal.setInicialesAguaDiluyente(rs.getDouble("inicialesAguaDiluyente"));
				bal.setFinales(rs.getDouble("finales"));
				bal.setFinalesAgua(rs.getDouble("finalesAgua"));
				bal.setFinalesDiluyente(rs.getDouble("finalesDiluyente"));
				bal.setFinalesAguaDiluyente(rs.getDouble("finalesAguaDiluyente"));
				bal.setRecibo(rs.getDouble("recibo"));
				bal.setEntrega(rs.getDouble("entrega"));
				bal.setInyeccion(rs.getDouble("inyeccion"));
				bal.setTransferencia(rs.getDouble("transferencia"));
				bal.setDrenaje(rs.getDouble("drenaje"));
				bal.setConsumo(rs.getDouble("consumo"));
				bal.setReciboDiluyente(rs.getDouble("reciboDiluyente"));
				bal.setEntregaDiluyente(rs.getDouble("entregaDiluyente"));
				bal.setInyeccionDiluyente(rs.getDouble("inyeccionDiluyente"));
				bal.setTransferenciaDiluyente(rs.getDouble("transferenciaDiluyente"));
				bal.setDrenajeDiluyente(rs.getDouble("drenajeDiluyente"));
				bal.setConsumoDiluyente(rs.getDouble("consumoDiluyente"));
				bal.setReciboAgua(rs.getDouble("reciboAgua"));
				bal.setEntregaAgua(rs.getDouble("entregaAgua"));
				bal.setInyeccionAgua(rs.getDouble("inyeccionAgua"));
				bal.setTransferenciaAgua(rs.getDouble("transferenciaAgua"));
				bal.setDrenajeAgua(rs.getDouble("drenajeAgua"));
				bal.setConsumoAgua(rs.getDouble("consumoAgua"));
				bal.setReciboAguaDiluyente(rs.getDouble("reciboAguaDiluyente"));
				bal.setEntregaAguaDiluyente(rs.getDouble("entregaAguaDiluyente"));
				bal.setInyeccionAguaDiluyente(rs.getDouble("inyeccionAguaDiluyente"));
				bal.setTransferenciaAguaDiluyente(rs.getDouble("transferenciaAguaDiluyente"));
				bal.setDrenajeAguaDiluyente(rs.getDouble("drenajeAguaDiluyente"));
				bal.setConsumoAguaDiluyente(rs.getDouble("consumoAguaDiluyente"));
				bal.setAceiteProducido(rs.getDouble("aceiteProducido"));
				bal.setGas(rs.getDouble("gas"));
				bal.setAguaProducida(rs.getDouble("aguaProducida"));
				bal.setComentarios(rs.getString("comentarios"));
				bal.setsYw(rs.getDouble("sYw"));
				bal.setRecibo24H(rs.getDouble("recibo24H"));
				bal.setAceiteProducido24H(rs.getDouble("aceiteProducido24H"));
				bal.setAguaProducida24H(rs.getDouble("aguaProducida24H"));
				bal.setInyeccionDiluyente24H(rs.getDouble("inyeccionDiluyente24H"));
				bal.setsYw24H(rs.getDouble("sYw24H"));
				bal.setGas24H(rs.getDouble("gas24H"));
				bal.setTiempoPrueba(rs.getDouble("tiempoPrueba"));
				bal.setGor(rs.getDouble("gor"));
				bal.setGor24H(rs.getDouble("gor24H"));
				bal.setFluidoTotal(rs.getDouble("fluidoTotal"));
				bal.setFluidoTotal24H(rs.getDouble("fluidoTotal24H"));
				bal.setApiMezcla(rs.getDouble("apiMezcla"));
				bal.setApiCabeza(rs.getDouble("apiCabeza"));
				bal.setViscocidad(rs.getDouble("viscocidad"));
				bal.setTempViscocidad(rs.getDouble("tempViscocidad"));
				bal.setSalinidad(rs.getDouble("salinidad"));
				bal.setCloruros(rs.getDouble("cloruros"));
				bal.setPh(rs.getDouble("ph"));
				bal.setChoke(rs.getDouble("choke"));

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

	public boolean buscarUltimo(Balance bal) throws SQLException {

		// creacion de variables para la consulta
		Consultas consultas = new Consultas();
		ArrayList arrayVar = new ArrayList();
		ResultSet rs;
		boolean estado = false;

		// consulta a realizar
		String query = "SELECT * FROM balance ORDER BY fecha DESC LIMIT 1";

		// crear arraylist con objeto a consultar, agregar en el orden de la consulta
		// arrayVar.add(1);
		// ejecutar consulta y almacenar resultados en rs si se requiere
		rs = consultas.readSQL(query, arrayVar);

		// asignar resultados a setter de objeto
		try {
			if (rs != null) {
				// bal.setConsecutivo(rs.getInt("consecutivo"));
				bal.setIdPozo(rs.getString("idPozo"));
				bal.setFecha(rs.getDate("fecha"));
//                bal.setIniciales(rs.getDouble("iniciales"));
//                bal.setInicialesAgua(rs.getDouble("inicialesAgua"));
//                bal.setInicialesDiluyente(rs.getDouble("inicialesDiluyente"));
//                bal.setInicialesAguaDiluyente(rs.getDouble("inicialesAguaDiluyente"));
//                bal.setFinales(rs.getDouble("finales"));
//                bal.setFinalesAgua(rs.getDouble("finalesAgua"));
//                bal.setFinalesDiluyente(rs.getDouble("finalesDiluyente"));
//                bal.setFinalesAguaDiluyente(rs.getDouble("finalesAguaDiluyente"));
//                bal.setRecibo(rs.getDouble("recibo"));
//                bal.setEntrega(rs.getDouble("entrega"));
//                bal.setInyeccion(rs.getDouble("inyeccion"));
//                bal.setTransferencia(rs.getDouble("transferencia"));
//                bal.setDrenaje(rs.getDouble("drenaje"));
//                bal.setConsumo(rs.getDouble("consumo"));
//                bal.setReciboDiluyente(rs.getDouble("reciboDiluyente"));
//                bal.setEntregaDiluyente(rs.getDouble("entregaDiluyente"));
//                bal.setInyeccionDiluyente(rs.getDouble("inyeccionDiluyente"));
//                bal.setTransferenciaDiluyente(rs.getDouble("transferenciaDiluyente"));
//                bal.setDrenajeDiluyente(rs.getDouble("drenajeDiluyente"));
//                bal.setConsumoDiluyente(rs.getDouble("consumoDiluyente"));
//                bal.setReciboAgua(rs.getDouble("reciboAgua"));
//                bal.setEntregaAgua(rs.getDouble("entregaAgua"));
//                bal.setInyeccionAgua(rs.getDouble("inyeccionAgua"));
//                bal.setTransferenciaAgua(rs.getDouble("transferenciaAgua"));
//                bal.setDrenajeAgua(rs.getDouble("drenajeAgua"));
//                bal.setConsumoAgua(rs.getDouble("consumoAgua"));
//                bal.setReciboAguaDiluyente(rs.getDouble("reciboAguaDiluyente"));
//                bal.setEntregaAguaDiluyente(rs.getDouble("entregaAguaDiluyente"));
//                bal.setInyeccionAguaDiluyente(rs.getDouble("inyeccionAguaDiluyente"));
//                bal.setTransferenciaAguaDiluyente(rs.getDouble("transferenciaAguaDiluyente"));
//                bal.setDrenajeAguaDiluyente(rs.getDouble("drenajeAguaDiluyente"));
//                bal.setConsumoAguaDiluyente(rs.getDouble("consumoAguaDiluyente"));
//                bal.setAceiteProducido(rs.getDouble("aceiteProducido"));
//                bal.setGas(rs.getDouble("gas"));
//                bal.setAguaProducida(rs.getDouble("aguaProducida"));
//                bal.setComentarios(rs.getString("comentarios"));
//                bal.setsYw(rs.getDouble("sYw"));
//                bal.setRecibo24H(rs.getDouble("recibo24H"));
//                bal.setAceiteProducido24H(rs.getDouble("aceiteProducido24H"));
//                bal.setAguaProducida24H(rs.getDouble("aguaProducida24H"));
//                bal.setInyeccionDiluyente24H(rs.getDouble("inyeccionDiluyente24H"));
//                bal.setsYw24H(rs.getDouble("sYw24H"));
//                bal.setGas24H(rs.getDouble("gas24H"));
//                bal.setTiempoPrueba(rs.getDouble("tiempoPrueba"));
//                bal.setGor(rs.getDouble("gor"));
//                bal.setGor24H(rs.getDouble("gor24H"));
//                bal.setFluidoTotal(rs.getDouble("fluidoTotal"));
//                bal.setFluidoTotal24H(rs.getDouble("fluidoTotal24H"));
//                bal.setApiMezcla(rs.getDouble("apiMezcla"));
//                bal.setApiCabeza(rs.getDouble("apiCabeza"));
//                bal.setViscocidad(rs.getDouble("viscocidad"));
//                bal.setTempViscocidad(rs.getDouble("tempViscocidad"));
//                bal.setSalinidad(rs.getDouble("salinidad"));
//                bal.setCloruros(rs.getDouble("cloruros"));
//                bal.setPh(rs.getDouble("ph"));
//                bal.setChoke(rs.getDouble("choke"));

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

	public boolean buscarUltimoXPozo(Balance bal) throws SQLException {

		// creacion de variables para la consulta
		Consultas consultas = new Consultas();
		ArrayList arrayVar = new ArrayList();
		ResultSet rs;
		boolean estado = false;

		// consulta a realizar
		String query = "SELECT * FROM balance WHERE idPozo=? ORDER BY fecha DESC LIMIT 1";

		// crear arraylist con objeto a consultar, agregar en el orden de la consulta
		arrayVar.add(bal.getIdPozo());

		// ejecutar consulta y almacenar resultados en rs si se requiere
		rs = consultas.readSQL(query, arrayVar);

		// asignar resultados a setter de objeto
		try {
			if (rs != null) {
				bal.setConsecutivo(rs.getInt("consecutivo"));
//                bal.setIdPozo(rs.getString("idPozo"));
				bal.setFecha(rs.getDate("fecha"));
//                bal.setIniciales(rs.getDouble("iniciales"));
//                bal.setInicialesAgua(rs.getDouble("inicialesAgua"));
//                bal.setInicialesDiluyente(rs.getDouble("inicialesDiluyente"));
//                bal.setInicialesAguaDiluyente(rs.getDouble("inicialesAguaDiluyente"));
//                bal.setFinales(rs.getDouble("finales"));
//                bal.setFinalesAgua(rs.getDouble("finalesAgua"));
//                bal.setFinalesDiluyente(rs.getDouble("finalesDiluyente"));
//                bal.setFinalesAguaDiluyente(rs.getDouble("finalesAguaDiluyente"));
//                bal.setRecibo(rs.getDouble("recibo"));
//                bal.setEntrega(rs.getDouble("entrega"));
//                bal.setInyeccion(rs.getDouble("inyeccion"));
//                bal.setTransferencia(rs.getDouble("transferencia"));
//                bal.setDrenaje(rs.getDouble("drenaje"));
//                bal.setConsumo(rs.getDouble("consumo"));
//                bal.setReciboDiluyente(rs.getDouble("reciboDiluyente"));
//                bal.setEntregaDiluyente(rs.getDouble("entregaDiluyente"));
//                bal.setInyeccionDiluyente(rs.getDouble("inyeccionDiluyente"));
//                bal.setTransferenciaDiluyente(rs.getDouble("transferenciaDiluyente"));
//                bal.setDrenajeDiluyente(rs.getDouble("drenajeDiluyente"));
//                bal.setConsumoDiluyente(rs.getDouble("consumoDiluyente"));
//                bal.setReciboAgua(rs.getDouble("reciboAgua"));
//                bal.setEntregaAgua(rs.getDouble("entregaAgua"));
//                bal.setInyeccionAgua(rs.getDouble("inyeccionAgua"));
//                bal.setTransferenciaAgua(rs.getDouble("transferenciaAgua"));
//                bal.setDrenajeAgua(rs.getDouble("drenajeAgua"));
//                bal.setConsumoAgua(rs.getDouble("consumoAgua"));
//                bal.setReciboAguaDiluyente(rs.getDouble("reciboAguaDiluyente"));
//                bal.setEntregaAguaDiluyente(rs.getDouble("entregaAguaDiluyente"));
//                bal.setInyeccionAguaDiluyente(rs.getDouble("inyeccionAguaDiluyente"));
//                bal.setTransferenciaAguaDiluyente(rs.getDouble("transferenciaAguaDiluyente"));
//                bal.setDrenajeAguaDiluyente(rs.getDouble("drenajeAguaDiluyente"));
//                bal.setConsumoAguaDiluyente(rs.getDouble("consumoAguaDiluyente"));
//                bal.setAceiteProducido(rs.getDouble("aceiteProducido"));
//                bal.setGas(rs.getDouble("gas"));
//                bal.setAguaProducida(rs.getDouble("aguaProducida"));
				bal.setComentarios(rs.getString("comentarios"));
//                bal.setsYw(rs.getDouble("sYw"));
//                bal.setRecibo24H(rs.getDouble("recibo24H"));
//                bal.setAceiteProducido24H(rs.getDouble("aceiteProducido24H"));
//                bal.setAguaProducida24H(rs.getDouble("aguaProducida24H"));
//                bal.setInyeccionDiluyente24H(rs.getDouble("inyeccionDiluyente24H"));
//                bal.setsYw24H(rs.getDouble("sYw24H"));
//                bal.setGas24H(rs.getDouble("gas24H"));
//                bal.setTiempoPrueba(rs.getDouble("tiempoPrueba"));
//                bal.setGor(rs.getDouble("gor"));
//                bal.setGor24H(rs.getDouble("gor24H"));
//                bal.setFluidoTotal(rs.getDouble("fluidoTotal"));
//                bal.setFluidoTotal24H(rs.getDouble("fluidoTotal24H"));
//                bal.setApiMezcla(rs.getDouble("apiMezcla"));
				bal.setApiCabeza(rs.getDouble("apiCabeza"));
				bal.setViscocidad(rs.getDouble("viscocidad"));
				bal.setTempViscocidad(rs.getDouble("tempViscocidad"));
				bal.setSalinidad(rs.getDouble("salinidad"));
				bal.setCloruros(rs.getDouble("cloruros"));
				bal.setPh(rs.getDouble("ph"));
				bal.setChoke(rs.getDouble("choke"));

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

	public ArrayList buscarAcumuladosxPozoYFecha(String idPozo, Date fecha) throws SQLException {

		// creacion de variables para la consulta
		Consultas consultas = new Consultas();
		ArrayList arrayVar = new ArrayList();
		ArrayList<ArrayList> arrayVariables = new ArrayList<>();
		ArrayList arrayDatos = new ArrayList();
		ArrayList arrayTitulos = new ArrayList();
		ResultSet rs;

		String query = null;

		// consulta a realizar
		query = "SELECT fecha,idPozo,recibo AS netos,reciboAgua AS agua FROM balance WHERE idPozo=? AND fecha<=?";
		// crear arraylist con objeto a consultar, agregar en el orden de la consulta
		arrayVar.add(idPozo);
		arrayVar.add(fecha);

		// ejecutar consulta y almacenar resultados en rs si se requiere
		rs = consultas.readSQL(query, arrayVar);

		// asignar resultados a arrayList
		try {
			if (rs != null) {
				// consulta exitosa
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					if (!"consecutivo".equals(rs.getMetaData().getColumnLabel(i))) {
						arrayTitulos.add(rs.getMetaData().getColumnLabel(i));
						if (!"idPozo".equals(rs.getMetaData().getColumnLabel(i))
								&& !"fecha".equals(rs.getMetaData().getColumnLabel(i))
								&& !"hora".equals(rs.getMetaData().getColumnLabel(i))) {
							arrayDatos.add(rs.getDouble(i));
							while (rs.next()) {
								arrayDatos.add(rs.getDouble(i));
							}
						} else {
							if ("fecha".equals(rs.getMetaData().getColumnLabel(i))) {
								arrayDatos.add(rs.getDate(i));
								while (rs.next()) {
									arrayDatos.add(rs.getDate(i));
								}
							}
							if ("hora".equals(rs.getMetaData().getColumnLabel(i))) {
								arrayDatos.add(rs.getTime(i));
								while (rs.next()) {
									arrayDatos.add(rs.getTime(i));
								}
							}
							if ("idPozo".equals(rs.getMetaData().getColumnLabel(i))) {
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
				System.out.println("No hay datos relacionados");
			}
			// para consultas que tienen rs se debe cerrar la conexion en cada
			// funcion
			consultas.cerrarConexion();
		} catch (SQLException e) {
			System.err.println("ERROR " + e);
		}

		return arrayVariables;
	}

}

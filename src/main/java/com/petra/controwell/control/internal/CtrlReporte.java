package com.petra.controwell.control.internal;

import com.petra.controwell.model.Calculos;
import com.petra.controwell.model.Graficas;
import com.petra.controwell.model.Reporte;
import com.petra.controwell.model.data.AforoTk;
import com.petra.controwell.model.data.Balance;
import com.petra.controwell.model.data.Proceso;
import com.petra.controwell.model.data.Tanques;
import com.petra.controwell.model.data.Variador;
import com.petra.controwell.model.utilities.Utilities;
import com.petra.controwell.view.internal.FrmReporte;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

/**
 *
 * @author Angello Morales
 */
public class CtrlReporte implements ActionListener {

	// vista
	public FrmReporte frmReporte;

	// modelo BD
	// modelo
	public Reporte reporte;

	// controlador;
	public Utilities utilities;
	public CtrlBalance ctrlBalance;
	public CtrlTanques ctrlTanques;
	public CtrlPozos ctrlPozos;
	public CtrlProceso ctrlProceso;
	public CtrlVariador ctrlVariador;
	// variables
	private final int PRODUCCION = 1;
	private final int LABORATORIO = 2;
	private final int PROCESO = 3;
	private final int VARIADOR = 4;
	private final int DESPACHOS = 5;

	public CtrlReporte(FrmReporte frmReporte, Utilities utilities, CtrlBalance ctrlBalance,
			CtrlTanques ctrlTanques, CtrlPozos ctrlPozos, CtrlProceso ctrlProceso, CtrlVariador ctrlVariador) {
		this.frmReporte = frmReporte;
		this.utilities = utilities;
		this.ctrlBalance = ctrlBalance;
		this.ctrlTanques = ctrlTanques;
		this.ctrlPozos = ctrlPozos;
		this.ctrlProceso = ctrlProceso;
		this.ctrlVariador = ctrlVariador;

		// instanciar objetos
		try {
			reporte = new Reporte(this);
		} catch (IOException ex) {
			Logger.getLogger(CtrlReporte.class.getName()).log(Level.SEVERE, null, ex);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		// agregar listener a los botones dentro del constructor
		this.frmReporte.btnAceptar.addActionListener(this);

		// PopertychangeListener particular para spinner
		this.frmReporte.dtchFecha.addPropertyChangeListener((PropertyChangeEvent e) -> {
			if ("date".equals(e.getPropertyName())) {
				Calendar fechaRequerida = this.frmReporte.dtchFecha.getCalendar();
				try {
					frmReporte.txtComentarios.setText("");
					this.actualizarIniciales(fechaRequerida);
					this.actualizarFinales(fechaRequerida);
					this.actualizarProduccion(fechaRequerida);
					this.actualizarLaboratorio(fechaRequerida);
					this.actualizarProceso(fechaRequerida);
					this.actualizarVariador(fechaRequerida);
					this.actualizarDespachos(fechaRequerida);
					this.actualizarAcumulados(fechaRequerida);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	public void iniciar() throws PropertyVetoException {
		frmReporte.setTitle("Reportes");
		frmReporte.setVisible(true);
		frmReporte.toFront();
		frmReporte.setSelected(true);
//        frmReporte.btnAceptar.setEnabled(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// acciones a ejecutar cuando se presiona un elemento en la pantalla
		// if por cada elemento para detectar cual se presiono

		// -----Agregar-----
		if (e.getSource() == frmReporte.btnAceptar) {
			Calendar fechaRequerida = this.frmReporte.dtchFecha.getCalendar();
			java.sql.Date sqlFecha = new java.sql.Date(fechaRequerida.getTime().getTime());
			String ruta = this.utilities.seleccionarArchivoSalida("Archivos Pdf (.pdf)", "pdf", "reporte "+sqlFecha);
			File pdfNewFile = new File(ruta);
			try {
				reporte.createPDF(pdfNewFile, sqlFecha);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void actualizarIniciales(Calendar fechaRequerida) throws SQLException {
		DefaultTableModel modelo = new DefaultTableModel();
		String idPozo = "";
		String fluido = "";
		Calculos volumenTotal = new Calculos();
		;
		modelo.setColumnIdentifiers(new Object[] { "ID Tanques", "Fluido", "Pozo", "Nivel", "Interfase", "TOV", "GOV",
				"GSV", "NSV", "AGUA" });
		ctrlBalance.buscarIniciales(idPozo, fluido, fechaRequerida, modelo, volumenTotal);
		frmReporte.tbInventarioInicial.setModel(modelo);
	}

	public void actualizarFinales(Calendar fechaRequerida) throws SQLException {
		DefaultTableModel modelo = new DefaultTableModel();
		String idPozo = "";
		String fluido = "";
		Calculos volumenTotal = new Calculos();
		ArrayList listadoTks = ctrlTanques.tanquesC.listarTanques();
		modelo.setColumnIdentifiers(new Object[] { "ID Tanques", "Fluido", "Pozo", "Nivel", "Interfase", "TOV", "GOV",
				"GSV", "NSV", "AGUA" });
		ctrlBalance.buscarFinales(listadoTks, fechaRequerida, idPozo, modelo, fluido, volumenTotal, null, null);
		frmReporte.tbInventarioFinal.setModel(modelo);
		this.actualizarCapacidad(modelo);
	}

	public void actualizarProduccion(Calendar fechaRequerida) throws SQLException {
		DefaultTableModel modelo = this.buscarTabla(fechaRequerida, PRODUCCION);
		frmReporte.tbProduccion.setModel(modelo);
	}

	public void actualizarLaboratorio(Calendar fechaRequerida) throws SQLException {
		DefaultTableModel modelo = this.buscarTabla(fechaRequerida, LABORATORIO);
		frmReporte.tbLaboratorio.setModel(modelo);
	}

	public void actualizarProceso(Calendar fechaRequerida) throws SQLException {
		DefaultTableModel modelo = this.buscarTabla(fechaRequerida, PROCESO);
		frmReporte.tbVariablesProceso.setModel(modelo);
	}

	public void actualizarVariador(Calendar fechaRequerida) throws SQLException {
		DefaultTableModel modelo = this.buscarTabla(fechaRequerida, VARIADOR);
		frmReporte.tbVariador.setModel(modelo);
	}

	public void actualizarDespachos(Calendar fechaRequerida) throws SQLException {
		DefaultTableModel modelo = this.buscarTabla(fechaRequerida, DESPACHOS);
		frmReporte.tbDespachos.setModel(modelo);
	}

	public void actualizarCapacidad(DefaultTableModel modeloFinales) throws SQLException {
		DefaultTableModel modelo = this.buscarCapacidad(modeloFinales);
		frmReporte.tbCapacidad.setModel(modelo);
	}

	public void actualizarAcumulados(Calendar fechaRequerida) throws SQLException {
		frmReporte.panelGraficas.removeAll();
		frmReporte.panelGraficas.add(new ChartPanel(this.graficarAcumulados(fechaRequerida)), BorderLayout.CENTER);
		frmReporte.panelGraficas.validate();
	}

	public DefaultTableModel buscarTabla(Calendar fechaRequerida, int nombreTabla) throws SQLException {
		Balance ultimoBalance = new Balance();
		Proceso ultimoProceso = new Proceso();
		Variador ultimoVariador = new Variador();
		java.sql.Date sqlFecha = new java.sql.Date(fechaRequerida.getTime().getTime());
		ultimoBalance.setFecha(sqlFecha);
		ultimoProceso.setFecha(sqlFecha);
		ultimoVariador.setFecha(sqlFecha);
		ArrayList listadoPozos = ctrlPozos.ListarPozos();
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(cabeceraTabla(nombreTabla));
		for (Object listadoPozo : listadoPozos) {
			ultimoBalance.setIdPozo(listadoPozo.toString());
			ultimoProceso.setIdPozo(listadoPozo.toString());
			ultimoVariador.setIdPozo(listadoPozo.toString());
			switch (nombreTabla) {
			case PRODUCCION:
				if (ctrlBalance.balanceC.buscarBalanceXFecha(ultimoBalance)) {
					modelo.addRow(contenidoTabla(ultimoBalance, null, null, nombreTabla));
					frmReporte.txtComentarios
							.setText(ultimoBalance.getIdPozo() + ": " + ultimoBalance.getComentarios());
				}
				break;
			case LABORATORIO:
				if (ctrlBalance.balanceC.buscarBalanceXFecha(ultimoBalance)) {
					modelo.addRow(contenidoTabla(ultimoBalance, null, null, nombreTabla));
				}
				break;
			case PROCESO:
				if (ctrlBalance.balanceC.buscarBalanceXFecha(ultimoBalance)) {
					if (ctrlProceso.procesoC.buscarXFecha(ultimoProceso)) {
						modelo.addRow(contenidoTabla(ultimoBalance, ultimoProceso, null, nombreTabla));
					}
				}
				break;
			case VARIADOR:
				if (ctrlVariador.variadorC.buscarXFecha(ultimoVariador)) {
					modelo.addRow(contenidoTabla(null, null, ultimoVariador, nombreTabla));
				}
				break;
			case DESPACHOS:
				if (ctrlBalance.balanceC.buscarBalanceXFecha(ultimoBalance)) {
					modelo.addRow(contenidoTabla(ultimoBalance, null, null, nombreTabla));
				}
				break;
			}
		}
		return modelo;
	}

	public Object[] contenidoTabla(Balance ultimoBalance, Proceso ultimoProceso, Variador ultimoVariador,
			int nombreTabla) {
		Object[] tabla = null;

		switch (nombreTabla) {
		case PRODUCCION:
			tabla = new Object[] { ultimoBalance.getIdPozo(), ultimoBalance.getTiempoPrueba(),
					ultimoBalance.getFluidoTotal(), ultimoBalance.getAceiteProducido(),
					ultimoBalance.getAguaProducida(), ultimoBalance.getGas(), ultimoBalance.getGor(),
					ultimoBalance.getInyeccionDiluyente() };
			break;
		case LABORATORIO:
			tabla = new Object[] { ultimoBalance.getIdPozo(), ultimoBalance.getsYw(), ultimoBalance.getApiCabeza(),
					ultimoBalance.getApiMezcla(), ultimoBalance.getCloruros(), ultimoBalance.getPh(),
					ultimoBalance.getViscocidad(), ultimoBalance.getSalinidad() };
			break;
		case PROCESO:
			tabla = new Object[] { ultimoProceso.getIdPozo(), ultimoProceso.getPresionCabeza(),
					ultimoProceso.getTemperaturaCabeza(), ultimoProceso.getPresionCasing(), ultimoBalance.getChoke(),
					ultimoProceso.getPresionSep(), ultimoProceso.getTemperaturaSep() };
			break;
		case VARIADOR:
			tabla = new Object[] { ultimoVariador.getIdPozo(), ultimoVariador.getFrecuencia(), ultimoVariador.getPip(),
					ultimoVariador.getPdp(), ultimoVariador.gettIntake(), ultimoVariador.gettMotor(),
					ultimoVariador.getVolt(), ultimoVariador.getAmp() };
			break;
		case DESPACHOS:
			double fluidoTotal = ctrlBalance.ctrlOperacionTk.calculos
					.formatearDecimales(ultimoBalance.getEntrega() + ultimoBalance.getEntregaAgua(), 2);
			double syw = ctrlBalance.ctrlOperacionTk.calculos
					.formatearDecimales((ultimoBalance.getEntregaAgua() / fluidoTotal) * 100, 2);
			tabla = new Object[] { ultimoBalance.getIdPozo(), fluidoTotal, ultimoBalance.getEntrega(),
					ultimoBalance.getEntregaAgua(), syw };
			break;
		}
		return tabla;
	}

	public Object[] cabeceraTabla(int nombreTabla) {
		Object[] tabla = null;
		switch (nombreTabla) {
		case PRODUCCION:
			tabla = new Object[] { "ID Pozo", "tiempo", "FluidoTotal", "NSV", "Agua", "Gas", "Gor", "NSV Inyectado" };
			break;
		case LABORATORIO:
			tabla = new Object[] { "ID Pozo", "S&W", "Api Cabeza @60", "Api Mezcla @60", "Cloruros", "PH", "Viscocidad",
					"Salinidad" };
			break;
		case PROCESO:
			tabla = new Object[] { "ID Pozo", "WHP", "WHT", "CHP", "Choke", "P Separador", "T Separador" };
			break;
		case VARIADOR:
			tabla = new Object[] { "ID Pozo", "Frec", "PIP", "PDP", "T Intake", "T motor", "Volt", "Amp" };
			break;
		case DESPACHOS:
			tabla = new Object[] { "Id Pozo", "Fluido Total", "Nsv", "Agua", "% S&W" };
			break;
		}
		return tabla;
	}

	public DefaultTableModel buscarCapacidad(DefaultTableModel modeloFinales) throws SQLException {
		DefaultTableModel modeloTabla = new DefaultTableModel();
		AforoTk tksInfo = new AforoTk();
		String idTanque;
		double capacidad;
		double disponible;
		double disponiblePercent;
		modeloTabla.setColumnIdentifiers(new Object[] { "ID Tanques", "Capacidad", "Vol Disponible", "% Disponible" });
		for (int row = 0; row < modeloFinales.getRowCount(); row++) {
			tksInfo.setIdTanque((String) modeloFinales.getValueAt(row, 0));
			ctrlBalance.ctrlOperacionTk.ctrlAforoTk.aforoTkC.buscarUltimoXTanque(tksInfo);
			idTanque = tksInfo.getIdTanque();
			capacidad = tksInfo.getVolumen();
			disponible = ctrlBalance.ctrlOperacionTk.calculos
					.formatearDecimales(capacidad - Double.parseDouble(modeloFinales.getValueAt(row, 5).toString()), 2);
			disponiblePercent = ctrlBalance.ctrlOperacionTk.calculos.formatearDecimales(
					(0.8 - Double.parseDouble(modeloFinales.getValueAt(row, 5).toString()) / capacidad) * 100, 2);
			disponiblePercent = (disponiblePercent <= 0) ? 0 : disponiblePercent;
			modeloTabla.addRow(new Object[] { idTanque, capacidad, disponible, disponiblePercent });
		}
		return modeloTabla;
	}

	public JFreeChart graficarAcumulados(Calendar fechaRequerida) throws SQLException {
		Graficas grafica = new Graficas();
		ArrayList<java.sql.Date> arrayValoresX = new ArrayList<java.sql.Date>();
		ArrayList<ArrayList<Double>> seriesDatos = new ArrayList<ArrayList<Double>>();
		ArrayList<Double> series = new ArrayList<Double>();
		ArrayList<String> titulos = new ArrayList<String>();
		java.sql.Date sqlFecha = new java.sql.Date(fechaRequerida.getTime().getTime());
		ArrayList listadoPozos = ctrlPozos.ListarPozos();
		grafica.setTipoGrafica(grafica.SERIETIEMPO);
		for (Object listadoPozo : listadoPozos) {
			seriesDatos = ctrlBalance.balanceC.buscarAcumuladosxPozoYFecha(listadoPozo.toString(), sqlFecha);
			if (!seriesDatos.isEmpty()) {
				arrayValoresX = utilities.evaluarArrayInterno(seriesDatos, 0);
				grafica.setArrayValoresX((ArrayList) arrayValoresX);
				titulos = utilities.evaluarArrayInterno(seriesDatos, seriesDatos.size() - 1);
				for (int i = 2; i < seriesDatos.size() - 1; i++) {
					series = utilities.evaluarArrayInterno(seriesDatos, i);
					grafica.cargarArrayValoresY(series, utilities.evaluarArrayString(titulos, i)+" del pozo "+listadoPozo.toString());
					grafica.actualizarDatosGrafica(grafica.EJE_PRINCIPAL);
				}
				grafica.construirGrafica("Acumulado dia-dia", "Bbls", "Valores Y2", "Dia", grafica.EJE_PRINCIPAL);
			}
		}

		return grafica.getGrafica();

	}

}

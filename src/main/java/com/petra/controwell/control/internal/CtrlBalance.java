package com.petra.controwell.control.internal;

import com.petra.controwell.model.CalculoApi;
import com.petra.controwell.model.Calculos;
import com.petra.controwell.model.data.Balance;
import com.petra.controwell.model.data.OperacionTk;
import com.petra.controwell.model.data.querys.ConsultasBalance;
import com.petra.controwell.model.data.querys.ConsultasOperacionTk;
import com.petra.controwell.model.utilities.Utilities;
import com.petra.controwell.view.internal.FrmApi;
import com.petra.controwell.view.internal.FrmBalance;
import com.petra.controwell.view.internal.FrmOperacionTk;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Angello Morales
 */
public class CtrlBalance implements ActionListener {

	// vista
	public FrmBalance frmBalance;

	// modelo BD
	public Balance balance;
	public ConsultasBalance balanceC;
	// modelo
	// controlador;
	public CtrlOperacionTk ctrlOperacionTk;
	public CtrlTanques ctrlTanques;
	public Utilities ctrlUtilities;
	// variables
	public java.sql.Date fechaUltimoMovimiento;
	public String ultimoTkMovimiento;

	public CtrlBalance(FrmBalance frmBalance, FrmOperacionTk frmOperacionTk, OperacionTk operacionTk, Calculos calculos,
			ConsultasOperacionTk operacionTkC, Utilities ctrlUtilities, CtrlAforoTk ctrlAforoTk,
			CtrlTanques ctrlTanques, FrmApi frmApi, CalculoApi calculoApi, Balance balance, ConsultasBalance balanceC) {
		this.frmBalance = frmBalance;
		this.ctrlOperacionTk = new CtrlOperacionTk(frmOperacionTk, operacionTk, calculos, operacionTkC, ctrlUtilities,
				ctrlAforoTk, ctrlTanques, frmApi, calculoApi, this);
		this.ctrlTanques = ctrlTanques;
		this.balance = balance;
		this.balanceC = balanceC;
		this.ctrlUtilities = ctrlUtilities;
		// instanciar librerias
		this.actualizarFechas();

		// agregar listener a los botones dentro del constructor
		this.frmBalance.btnMovimientos.addActionListener(this);
		this.frmBalance.btnLiquidar.addActionListener(this);
		this.frmBalance.btnBorrarUltimo.addActionListener(this);
		this.frmBalance.btnAPI.addActionListener(this);

		// actionlistener para tablas crear en una nueva clase
		// listlistener cuando cambia algo en la lista
//        frmBalance.tbEstadoTanques.getSelectionModel().addListSelectionListener((new ListSelectionListener() {
//            @Override
//            public void valueChanged(ListSelectionEvent e) {
//                String pozo;
//                String tanque;
//                pozo = frmBalance.tbEstadoTanques.getValueAt(frmBalance.tbEstadoTanques.getSelectedRow(), 0).toString();
//                tanque = frmBalance.tbEstadoTanques.getValueAt(frmBalance.tbEstadoTanques.getSelectedRow(), 1).toString();
//                if (pozo != null && tanque != null) {
//                    ctrlOperacionTk.frmOperacionTk.cmbxIdPozo.setSelectedItem(pozo);
//                    ctrlOperacionTk.frmOperacionTk.cmbxIdTanque.setSelectedItem(tanque);
//                }
//
//            }
//        }));
		// mouse listener particular cuando se hace un evento de mouse en la tabla
		frmBalance.tbEstadoTanques.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String pozo;
				String tanque;
				pozo = frmBalance.tbEstadoTanques.getValueAt(frmBalance.tbEstadoTanques.getSelectedRow(), 0).toString();
				tanque = frmBalance.tbEstadoTanques.getValueAt(frmBalance.tbEstadoTanques.getSelectedRow(), 1)
						.toString();
				if (pozo != null && tanque != null) {
					ctrlOperacionTk.frmOperacionTk.cmbxIdPozo.setSelectedItem(pozo);
					ctrlOperacionTk.frmOperacionTk.cmbxIdTanque.setSelectedItem(tanque);
				}
				try {
					ctrlOperacionTk.iniciar();
				} catch (PropertyVetoException ex) {
					Logger.getLogger(CtrlBalance.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		});

		// itemListener particular para combobox
		this.frmBalance.cmbxIdPozo.addItemListener((ItemEvent itemEvent) -> {
			int state = itemEvent.getStateChange();
			if (state == ItemEvent.SELECTED) {
				try {
					if (!this.ctrlTanques.tanquesC.listarTanques().isEmpty()) {
						this.actualizarBalance();
						this.actualizarFechas();
					}
				} catch (SQLException ex) {
					Logger.getLogger(CtrlBalance.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		});
		this.frmBalance.cmbxFluido.addItemListener((ItemEvent itemEvent) -> {
			int state = itemEvent.getStateChange();
			if (state == ItemEvent.SELECTED) {
				this.actualizarBalance();
			}
		});

		// changeListener particular para spinner
//        this.frmBalance.spnFecha.addChangeListener((ChangeEvent e) -> {
//            this.actualizarBalance();
//        });
		// focusListener particular para textbox
		this.frmBalance.txtHorasPrueba.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
			}

			@Override
			public void focusLost(FocusEvent e) {
				actualizarBalance();
			}

		});

		// PopertychangeListener particular para spinner
		this.frmBalance.dtchFecha.addPropertyChangeListener((PropertyChangeEvent e) -> {
			if ("date".equals(e.getPropertyName())) {
				actualizarBalance();
				esBalanceCerrado();
			}
		});

	}

	public void iniciar() {
		frmBalance.lblCerrado.setVisible(false);
		frmBalance.setTitle("Estado de tanques");
		frmBalance.setVisible(true);
		frmBalance.btnMovimientos.setText("<html>Realizar<br>Movimientos</html>");
		this.actualizarEstadoTanques();
		this.frmBalance.btnLiquidar.setEnabled(false);
		this.actualizarBalance();
		this.esBalanceCerrado();
		frmBalance.lblDiferenciaBalanceAgua.setVisible(false);
		frmBalance.lblDiferenciaBalanceNSV.setVisible(false);
		frmBalance.lblDiferenciaAgua.setVisible(false);
		frmBalance.lblDiferenciaNSV.setVisible(false);
		frmBalance.lblDiferencia.setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// acciones a ejecutar cuando se presiona un elemento en la pantalla
		// if por cada elemento para detectar cual se presiono

		// --------------movimientos--------------------
		if (e.getSource() == frmBalance.btnMovimientos) {
			try {
				ctrlOperacionTk.iniciar();
			} catch (PropertyVetoException ex) {
				Logger.getLogger(CtrlBalance.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

		// -----------------borrar-----------------
		if (e.getSource() == frmBalance.btnBorrarUltimo) {
			Balance ultimoBal = new Balance();
			OperacionTk ultimaOp = new OperacionTk();
			Calendar fechaUltimoMov = null;
			Calendar fechaUltimoBal = null;
			String idPozo = frmBalance.cmbxIdPozo.getSelectedItem().toString();
			ultimoBal.setIdPozo(idPozo);
			ultimaOp.setIdPozo(idPozo);
			try {
				if (this.balanceC.buscarUltimoXPozo(ultimoBal)) {
					fechaUltimoBal = ctrlUtilities.asignacionFechas(ultimoBal.getFecha(), ultimoBal.getFecha());
					if (this.ctrlOperacionTk.operacionTkC.buscarUltimoXPozo(ultimaOp)) {
						fechaUltimoMov = ctrlUtilities.asignacionFechas(ultimaOp.getFecha(), ultimaOp.getFecha());
						if ("IGUAL".equals(this.verificarDia(fechaUltimoBal, fechaUltimoMov))
								|| "MAYOR".equals(this.verificarDia(fechaUltimoBal, fechaUltimoMov))) {
							int seguro = JOptionPane.showConfirmDialog(null,
									"Seguro que desea eliminar el ultimo balance generado, ESTA OPCION NO SE PUEDE DESHACER");
							if (seguro == 0) {
								if (this.balanceC.eliminarDatosBalance(ultimoBal)) {
									JOptionPane.showMessageDialog(null, "Registro eliminado");
								} else {
									JOptionPane.showMessageDialog(null, "no se puede eliminar el registro");
								}
							}
						} else {
							JOptionPane.showMessageDialog(null,
									"no se puede eliminar el registro, verifique los movimientos del dia");
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"no se puede eliminar el registro, no se encuentra el ultimo movimiento");
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"no se puede eliminar el registro, no se encuentra el ultimo balance");
				}
				this.actualizarFechas();
			} catch (SQLException ex) {
				Logger.getLogger(CtrlBalance.class.getName()).log(Level.SEVERE, null, ex);
			}

		}

		// -----------------------generar balance-----------------
		if (e.getSource() == frmBalance.btnLiquidar) {
			this.actualizarBalance();
			Balance ultimoBal = new Balance();
			OperacionTk ultimaOp = new OperacionTk();
			Calendar fechaUltimoMov = ctrlUtilities.asignacionFechas(fechaUltimoMovimiento, fechaUltimoMovimiento);
			// Calendar fechaRequerida = ctrlUtilities.asignacionFechas((java.util.Date)
			// frmBalance.spnFecha.getValue(), (java.util.Date)
			// frmBalance.spnFecha.getValue());
			Calendar fechaRequerida = this.frmBalance.dtchFecha.getCalendar();
			java.sql.Date sqlFecha = new java.sql.Date(fechaRequerida.getTime().getTime());
			String idPozo = frmBalance.cmbxIdPozo.getSelectedItem().toString();
			ultimoBal.setIdPozo(idPozo);
			ultimoBal.setFecha(sqlFecha);
			this.balance.setComentarios(this.frmBalance.txtComentarios.getText());
			try {
				if (this.balanceC.buscarBalanceXFecha(ultimoBal)) {
					JOptionPane.showMessageDialog(null, "ya se ha generado el balance, Seleccione otra fecha");
				} else {
					if ("IGUAL".equals(this.verificarDia(fechaUltimoMov, fechaRequerida))) {
						if (this.ctrlOperacionTk.calculos.calcularBalance(balance)) {
							int result = JOptionPane.showConfirmDialog(null,
									"Si genera el balance del dia no podra agregar mas movimientos para este dia en los tanques");
							if (result == 0) {
								if (this.balanceC.agregarDatosBalance(balance)) {
									this.frmBalance.btnLiquidar.setEnabled(false);
									JOptionPane.showMessageDialog(null, "se ha generado el balance del dia");
									this.frmBalance.lblDiferenciaBalanceAgua.setVisible(false);
									this.frmBalance.lblDiferenciaBalanceNSV.setVisible(false);
									this.frmBalance.lblDiferenciaAgua.setVisible(false);
									this.frmBalance.lblDiferenciaNSV.setVisible(false);
									this.frmBalance.lblDiferencia.setVisible(false);
									this.frmBalance.txtComentarios.setText(null);
								} else {
									JOptionPane.showMessageDialog(null,
											"error al agregar los datos NO se generó el balance del día");
								}
							}
						} else {
							JOptionPane.showMessageDialog(null,
									"error en el balance verifique los movimientos del dia");
							if (this.ctrlOperacionTk.calculos.getBalanceOil() > 0.5
									|| this.ctrlOperacionTk.calculos.getBalanceAgua() > 0.5
									|| this.ctrlOperacionTk.calculos.getBalanceOil() < -0.5
									|| this.ctrlOperacionTk.calculos.getBalanceAgua() < -0.5) {
								this.frmBalance.lblDiferenciaBalanceNSV.setForeground(Color.black);
								this.frmBalance.lblDiferenciaBalanceAgua
										.setText(String.valueOf(this.ctrlOperacionTk.calculos.getBalanceAgua()));
								this.frmBalance.lblDiferenciaBalanceNSV
										.setText(String.valueOf(this.ctrlOperacionTk.calculos.getBalanceOil()));
							} else {
								if (this.ctrlOperacionTk.calculos.getBalanceDiluyente() > 0.5
										|| this.ctrlOperacionTk.calculos.getBalanceAguaDiluyente() > 0.5
										|| this.ctrlOperacionTk.calculos.getBalanceDiluyente() < -0.5
										|| this.ctrlOperacionTk.calculos.getBalanceAguaDiluyente() < -0.5) {
									this.frmBalance.lblDiferenciaBalanceNSV.setForeground(Color.gray);
									this.frmBalance.lblDiferenciaBalanceAgua.setText(
											String.valueOf(this.ctrlOperacionTk.calculos.getBalanceAguaDiluyente()));
									this.frmBalance.lblDiferenciaBalanceNSV.setText(
											String.valueOf(this.ctrlOperacionTk.calculos.getBalanceDiluyente()));
								}
							}
							this.frmBalance.lblDiferenciaBalanceAgua.setVisible(true);
							this.frmBalance.lblDiferenciaBalanceNSV.setVisible(true);
							this.frmBalance.lblDiferenciaAgua.setVisible(true);
							this.frmBalance.lblDiferenciaNSV.setVisible(true);
							this.frmBalance.lblDiferencia.setVisible(true);

						}
					} else {
						if ("MAYOR".equals(this.verificarDia(fechaUltimoMov, fechaRequerida))) {
							JOptionPane.showMessageDialog(null, "verifique la fecha seleccionada");
						} else {
							ultimoBal.setFecha(fechaUltimoMovimiento);
							if (this.balanceC.buscarBalanceXFecha(ultimoBal)) {
								ultimaOp.setIdTanque(this.ultimoTkMovimiento);
								ultimaOp.setFecha(fechaUltimoMovimiento);
								ultimaOp.setIdPozo(idPozo);
								if (this.ctrlOperacionTk.operacionTkC.buscarUltimoXPozoYTk(ultimaOp)) {
									if ("IGUAL".equals(this.verificarDia(this.ctrlUtilities.asignacionFechas(
											ultimaOp.getFecha(), ultimaOp.getFecha()), fechaRequerida))) {
										int result = JOptionPane.showConfirmDialog(null,
												"Si genera el balance del dia no podra agregar mas movimientos para este dia en los tanques");
										if (result == 0) {
											if (this.balanceC.agregarDatosBalance(balance)) {
												JOptionPane.showMessageDialog(null,
														"se ha generado el balance del dia");
												this.frmBalance.btnLiquidar.setEnabled(false);
												this.frmBalance.txtComentarios.setText(null);
											} else {
												JOptionPane.showMessageDialog(null,
														"error al agregar los datos NO se generó el balance del día");
											}
										}
									} else {
										int result = JOptionPane.showConfirmDialog(null,
												"Desea agregar un dia sin produccion");
										if (result == 0) {
											this.balance.setFecha(sqlFecha);
											this.limpiarBalance();
											if (this.balanceC.agregarDatosBalance(balance)) {
												JOptionPane.showMessageDialog(null,
														"se ha generado el balance del dia");
												this.frmBalance.btnLiquidar.setEnabled(false);
												this.frmBalance.txtComentarios.setText(null);
											} else {
												JOptionPane.showMessageDialog(null,
														"error al agregar los datos NO se generó el balance del día");
											}
										}
									}
								}
							} else {
								JOptionPane.showMessageDialog(null,
										"el dia o el pozo seleccionado no corresponde a la fecha del ultimo movimiento");
							}
						}
					}
				}
				this.actualizarFechas();
			} catch (SQLException ex) {
				Logger.getLogger(CtrlBalance.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

		// -----------------------btn API-----------------
		if (e.getSource() == frmBalance.btnAPI) {
			try {
				// cargar datos al modelo si es necesario(cajas de texto etc...)
				ctrlOperacionTk.ctrlApi.iniciar(ctrlOperacionTk.ctrlApi.BALANCE);
			} catch (PropertyVetoException ex) {
				Logger.getLogger(CtrlOperacionTk.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	public void actualizarEstadoTanques() {
		ArrayList listadoTks;
		OperacionTk datosUltimoMov = new OperacionTk();
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new Object[] { "Pozo", "Tanque", "Ultimo Movimiento", "nivel", "interfase", "sYw",
				"nsv", "agua", "fluido", "fecha", "hora" });

		try {
			listadoTks = ctrlTanques.tanquesC.listarTanques();

			for (Object listadoTk : listadoTks) {
				datosUltimoMov.setIdTanque(listadoTk.toString());
				if (ctrlOperacionTk.operacionTkC.buscarUltimoXTk(datosUltimoMov)) {
					// toma de datos
					modelo.addRow(new Object[] { datosUltimoMov.getIdPozo(), datosUltimoMov.getIdTanque(),
							datosUltimoMov.getTipo(), datosUltimoMov.getNivel(), datosUltimoMov.getInterfase(),
							datosUltimoMov.getsYw(), datosUltimoMov.getNsv(), datosUltimoMov.getAgua(),
							datosUltimoMov.getFluido(), datosUltimoMov.getFecha(), datosUltimoMov.getHora() });
				}
			}
			frmBalance.tbEstadoTanques.setModel(modelo);
		} catch (SQLException ex) {
			Logger.getLogger(CtrlBalance.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public void actualizarIniciales() {
		Calculos volumenTotal = new Calculos();
		// Calendar fechaRequerida = ctrlUtilities.asignacionFechas((java.util.Date)
		// frmBalance.spnFecha.getValue(), (java.util.Date)
		// frmBalance.spnFecha.getValue());
		Calendar fechaRequerida = this.frmBalance.dtchFecha.getCalendar();
		String idPozo = frmBalance.cmbxIdPozo.getSelectedItem().toString();
		String fluido = frmBalance.cmbxFluido.getSelectedItem().toString();
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new Object[] { "Tanque", "NSV", "agua" });

		try {
			this.buscarIniciales(idPozo, fluido, fechaRequerida, modelo, volumenTotal);
			frmBalance.tbInicial.setModel(modelo);
			this.balance.setIniciales(ctrlOperacionTk.calculos.formatearDecimales(volumenTotal.getTotalNsv(), 2));
			this.balance.setInicialesAgua(ctrlOperacionTk.calculos.formatearDecimales(volumenTotal.getTotalAgua(), 2));
			this.balance.setInicialesDiluyente(
					ctrlOperacionTk.calculos.formatearDecimales(volumenTotal.getTotalNsvDiluyente(), 2));
			this.balance.setInicialesAguaDiluyente(
					ctrlOperacionTk.calculos.formatearDecimales(volumenTotal.getTotalAguaDiluyente(), 2));
		} catch (SQLException ex) {
			Logger.getLogger(CtrlBalance.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public void actualizarFinales() {
		ArrayList listadoTks;
		OperacionTk ultimaOp = new OperacionTk();
		Calculos volumenTotal = new Calculos();
		java.sql.Date fechaUltimoM = null;
		String ultimoTk = null;
		// Calendar fecha = ctrlUtilities.asignacionFechas((java.util.Date)
		// frmBalance.spnFecha.getValue(), (java.util.Date)
		// frmBalance.spnFecha.getValue());
		Calendar fecha = this.frmBalance.dtchFecha.getCalendar();
		java.sql.Date sqlFecha = new java.sql.Date(fecha.getTime().getTime());
		String idPozo = frmBalance.cmbxIdPozo.getSelectedItem().toString();
		String fluido = frmBalance.cmbxFluido.getSelectedItem().toString();

		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new Object[] { "Tanque", "NSV", "agua" });

		try {
			listadoTks = ctrlTanques.tanquesC.listarTanques();

			// cargar objetos para la consulta
			ultimaOp.setIdPozo(idPozo);
			ultimaOp.setFecha(sqlFecha);

			ultimaOp.setIdTanque(listadoTks.get(0).toString());
			if (ctrlOperacionTk.operacionTkC.buscarUltimosXfechaParaBalance(ultimaOp)) {
				fechaUltimoM = ultimaOp.getFecha();
				ultimoTk = ultimaOp.getIdTanque();
			} else {
				if (ctrlOperacionTk.operacionTkC.buscarUltimoXPozoYTk(ultimaOp)) {
					fechaUltimoM = ultimaOp.getFecha();
					ultimoTk = ultimaOp.getIdTanque();
				}

			}

			this.buscarFinales(listadoTks, fecha, idPozo, modelo, fluido, volumenTotal, fechaUltimoM, ultimoTk);
			frmBalance.tbFinal.setModel(modelo);
			this.balance.setFinales(ctrlOperacionTk.calculos.formatearDecimales(volumenTotal.getTotalNsv(), 2));
			this.balance.setFinalesAgua(ctrlOperacionTk.calculos.formatearDecimales(volumenTotal.getTotalAgua(), 2));
			this.balance.setFinalesDiluyente(
					ctrlOperacionTk.calculos.formatearDecimales(volumenTotal.getTotalNsvDiluyente(), 2));
			this.balance.setFinalesAguaDiluyente(
					ctrlOperacionTk.calculos.formatearDecimales(volumenTotal.getTotalAguaDiluyente(), 2));

			// actualiza los movimientos del dia
			this.actualizarMovimientos(sqlFecha);

		} catch (SQLException ex) {
			Logger.getLogger(CtrlBalance.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void actualizarMovimientos(java.sql.Date sqlFecha) {
		ArrayList listadoTks;
		OperacionTk ultimoMov = new OperacionTk();
		String idPozo = frmBalance.cmbxIdPozo.getSelectedItem().toString();
		String fluido = frmBalance.cmbxFluido.getSelectedItem().toString();
		this.ctrlUtilities.setTextFieldOk(true);
		double horasPrueba = Double.parseDouble(this.ctrlUtilities.VerificarTextField(this.frmBalance.txtHorasPrueba));
		double apiCabeza = Double.parseDouble(this.ctrlUtilities.VerificarTextField(this.frmBalance.txtApiCabeza));
		double viscocidad = Double.parseDouble(this.ctrlUtilities.VerificarTextField(this.frmBalance.txtViscocidad));
		double tempViscocidad = Double
				.parseDouble(this.ctrlUtilities.VerificarTextField(this.frmBalance.txtTempViscocidad));
		double salinidad = Double.parseDouble(this.ctrlUtilities.VerificarTextField(this.frmBalance.txtSalinidad));
		double cloruros = Double.parseDouble(this.ctrlUtilities.VerificarTextField(this.frmBalance.txtCloruros));
		double ph = Double.parseDouble(this.ctrlUtilities.VerificarTextField(this.frmBalance.txtPh));
		double choke = Double.parseDouble(this.ctrlUtilities.VerificarTextField(this.frmBalance.txtChoke));
		if (this.ctrlUtilities.isTextFieldOk()) {
			this.frmBalance.btnLiquidar.setEnabled(true);
			if (!(horasPrueba <= 24 && horasPrueba > 0 && (horasPrueba % 0.25) == 0)) {
				horasPrueba = 24;
				this.frmBalance.txtHorasPrueba.setText("24");
				JOptionPane.showMessageDialog(null,
						"Debe ingresar números mayores a 0 y menores o iguales a 24 estos pueden contener decimales de cuarto  de fracción(0.25-0.5-0.75), SE UTILIZARÁ POR DEFECTO 24H PARA REALIZAR EL CÁLCULO");
			}
		} else {
			this.frmBalance.btnLiquidar.setEnabled(false);
			JOptionPane.showMessageDialog(null, "Ingrese Valores Numéricos si no tiene datos ingrese N/A");
		}
		DefaultTableModel modeloNSV = new DefaultTableModel();
		DefaultTableModel modeloAgua = new DefaultTableModel();
		DefaultTableModel modeloProduccion = new DefaultTableModel();
		modeloNSV.setColumnIdentifiers(
				new Object[] { "Tanque", "Recibo", "Entrega", "Inyeccion", "Transferencia", "Consumo", "Drenaje" });
		modeloAgua.setColumnIdentifiers(
				new Object[] { "Tanque", "Recibo", "Entrega", "Inyeccion", "Transferencia", "Consumo", "Drenaje" });
		modeloProduccion.setColumnIdentifiers(new Object[] { "<html><b>VOLUMEN</b></html>",
				"<html><b>PRODUCCION</b></html>", "<html><b>PROYECTADO</b></html>" });

		try {
			listadoTks = ctrlTanques.tanquesC.listarTanques();
			ultimoMov.setIdPozo(idPozo);
			ultimoMov.setFecha(sqlFecha);
			ultimoMov.setFluido(fluido);
			for (Object listadoTk : listadoTks) {
				// toma de datos

				ultimoMov.setIdTanque(listadoTk.toString());

				if (ctrlOperacionTk.operacionTkC.buscarsumaDiaXTk(ultimoMov)) {
					if ("Crudo".equals(fluido) && "Crudo".equals(ultimoMov.getFluido())) {
						modeloNSV.addRow(new Object[] { ultimoMov.getIdTanque(), ultimoMov.getRecibo(),
								ultimoMov.getEntrega(), ultimoMov.getInyeccion(), ultimoMov.getTransferencia(),
								ultimoMov.getConsumo(), ultimoMov.getDrenaje() });
						modeloAgua.addRow(new Object[] { ultimoMov.getIdTanque(), ultimoMov.getReciboAgua(),
								ultimoMov.getEntregaAgua(), ultimoMov.getInyeccionAgua(),
								ultimoMov.getTransferenciaAgua(), ultimoMov.getConsumoAgua(),
								ultimoMov.getDrenajeAgua() });
					} else {
						if ("Diluyente".equals(fluido) && "Diluyente".equals(ultimoMov.getFluido())) {
							modeloNSV.addRow(new Object[] { ultimoMov.getIdTanque(), ultimoMov.getRecibo(),
									ultimoMov.getEntrega(), ultimoMov.getInyeccion(), ultimoMov.getTransferencia(),
									ultimoMov.getConsumo(), ultimoMov.getDrenaje() });
							modeloAgua.addRow(new Object[] { ultimoMov.getIdTanque(), ultimoMov.getReciboAgua(),
									ultimoMov.getEntregaAgua(), ultimoMov.getInyeccionAgua(),
									ultimoMov.getTransferenciaAgua(), ultimoMov.getConsumoAgua(),
									ultimoMov.getDrenajeAgua() });
						}
					}
				}
			}
			this.balance.setFecha(sqlFecha);
			this.balance.setIdPozo(idPozo);
			ultimoMov.setFluido("Crudo");
			if (ctrlOperacionTk.operacionTkC.buscarSumaDiaTotal(ultimoMov)) {
				this.balance.setRecibo(ultimoMov.getRecibo());
				this.balance.setEntrega(ultimoMov.getEntrega());
				this.balance.setInyeccion(ultimoMov.getInyeccion());
				this.balance.setTransferencia(ultimoMov.getTransferencia());
				this.balance.setDrenaje(ultimoMov.getDrenaje());
				this.balance.setConsumo(ultimoMov.getConsumo());
				this.balance.setReciboAgua(ultimoMov.getReciboAgua());
				this.balance.setEntregaAgua(ultimoMov.getEntregaAgua());
				this.balance.setInyeccionAgua(ultimoMov.getInyeccionAgua());
				this.balance.setTransferenciaAgua(ultimoMov.getTransferenciaAgua());
				this.balance.setDrenajeAgua(ultimoMov.getDrenajeAgua());
				this.balance.setConsumoAgua(ultimoMov.getConsumoAgua());
				if (ctrlOperacionTk.operacionTkC.buscarPromedioDiaAPI(ultimoMov)) {
					this.balance.setApiMezcla(ultimoMov.getApi());
				}
			}
			ultimoMov.setFluido("Diluyente");
			if (ctrlOperacionTk.operacionTkC.buscarSumaDiaTotal(ultimoMov)) {
				this.balance.setReciboDiluyente(ultimoMov.getRecibo());
				this.balance.setEntregaDiluyente(ultimoMov.getEntrega());
				this.balance.setInyeccionDiluyente(ultimoMov.getInyeccion());
				this.balance.setTransferenciaDiluyente(ultimoMov.getTransferencia());
				this.balance.setDrenajeDiluyente(ultimoMov.getDrenaje());
				this.balance.setConsumoDiluyente(ultimoMov.getConsumo());
				this.balance.setReciboAguaDiluyente(ultimoMov.getReciboAgua());
				this.balance.setEntregaAguaDiluyente(ultimoMov.getEntregaAgua());
				this.balance.setInyeccionAguaDiluyente(ultimoMov.getInyeccionAgua());
				this.balance.setTransferenciaAguaDiluyente(ultimoMov.getTransferenciaAgua());
				this.balance.setDrenajeAguaDiluyente(ultimoMov.getDrenajeAgua());
				this.balance.setConsumoAguaDiluyente(ultimoMov.getConsumoAgua());
			}
			this.balance.setAceiteProducido(this.ctrlOperacionTk.calculos
					.formatearDecimales((this.balance.getRecibo() - this.balance.getInyeccionDiluyente()), 2));
			this.balance.setAguaProducida(this.ctrlOperacionTk.calculos
					.formatearDecimales((this.balance.getReciboAgua() - this.balance.getInyeccionAguaDiluyente()), 2));
			double calcularsYw = (this.balance.getAguaProducida())
					/ (this.balance.getAceiteProducido() + this.balance.getAguaProducida());
			this.balance.setsYw(this.ctrlOperacionTk.calculos.formatearDecimales(calcularsYw * 100, 2));
			double calcularGor = this.balance.getGas() / this.balance.getAceiteProducido();
			this.balance.setGor(calcularGor);
			double calcularFluidoTotal = this.balance.getAceiteProducido() + this.balance.getAguaProducida();
			this.balance.setFluidoTotal(calcularFluidoTotal);
			this.balance.setApiCabeza(apiCabeza);
			this.balance.setViscocidad(viscocidad);
			this.balance.setTempViscocidad(tempViscocidad);
			this.balance.setSalinidad(salinidad);
			this.balance.setCloruros(cloruros);
			this.balance.setPh(ph);
			this.balance.setChoke(choke);

			// proyeccion 24 horas
			this.balance.setAceiteProducido24H(this.ctrlOperacionTk.calculos
					.formatearDecimales(this.balance.getAceiteProducido() * 24 / horasPrueba, 2));
			this.balance.setAguaProducida24H(this.ctrlOperacionTk.calculos
					.formatearDecimales(this.balance.getAguaProducida() * 24 / horasPrueba, 2));
			this.balance.setRecibo24H(
					this.ctrlOperacionTk.calculos.formatearDecimales(this.balance.getRecibo() * 24 / horasPrueba, 2));
			this.balance.setInyeccionDiluyente24H(this.ctrlOperacionTk.calculos
					.formatearDecimales(this.balance.getInyeccionDiluyente() * 24 / horasPrueba, 2));
			double calcularsYw24H = (this.balance.getAguaProducida24H())
					/ (this.balance.getAceiteProducido24H() + this.balance.getAguaProducida24H());
			this.balance.setsYw24H(this.ctrlOperacionTk.calculos.formatearDecimales(calcularsYw24H * 100, 2));
			this.balance.setGas24H(
					this.ctrlOperacionTk.calculos.formatearDecimales(this.balance.getGas() * 24 / horasPrueba, 2));
			double calcularGor24H = this.balance.getGas24H() / this.balance.getAceiteProducido24H();
			this.balance.setGor24H(calcularGor24H);
			double calcularFluidoTotal24H = this.balance.getAceiteProducido24H() + this.balance.getAguaProducida24H();
			this.balance.setFluidoTotal24H(calcularFluidoTotal24H);
			this.balance.setTiempoPrueba(horasPrueba);

			// mostrar variables
			this.mostrarBalance(fluido);
			if ("Crudo".equals(fluido)) {
				modeloNSV.addRow(new Object[] { "<html><b>TOTAL</b></html>",
						"<html><b>" + this.balance.getRecibo() + "</b></html>",
						"<html><b>" + this.balance.getEntrega() + "</b></html>",
						"<html><b>" + this.balance.getInyeccion() + "</b></html>",
						"<html><b>" + this.balance.getTransferencia() + "</b></html>",
						"<html><b>" + this.balance.getConsumo() + "</b></html>",
						"<html><b>" + this.balance.getDrenaje() + "</b></html>" });
				modeloAgua.addRow(new Object[] { "<html><b><p style=\"color:rgb(0,0,153);\">TOTAL</p></b></html>",
						"<html><b><p style=\"color:rgb(0,0,153);\">" + this.balance.getReciboAgua() + "</p></b></html>",
						"<html><b><p style=\"color:rgb(0,0,153);\">" + this.balance.getEntregaAgua()
								+ "</p></b></html>",
						"<html><b><p style=\"color:rgb(0,0,153);\">" + this.balance.getInyeccionAgua()
								+ "</p></b></html>",
						"<html><b><p style=\"color:rgb(0,0,153);\">" + this.balance.getTransferenciaAgua()
								+ "</p></b></html>",
						"<html><b><p style=\"color:rgb(0,0,153);\">" + this.balance.getConsumoAgua()
								+ "</p></b></html>",
						"<html><b><p style=\"color:rgb(0,0,153);\">" + this.balance.getDrenajeAgua()
								+ "</p></b></html>" });
			} else {
				modeloNSV.addRow(new Object[] { "<html><b><p style=\"color:gray;\">TOTAL</p></b></html>",
						"<html><b><p style=\"color:gray;\">" + this.balance.getReciboDiluyente() + "</p></b></html>",
						"<html><b><p style=\"color:gray;\">" + this.balance.getEntregaDiluyente() + "</p></b></html>",
						"<html><b><p style=\"color:gray;\">" + this.balance.getInyeccionDiluyente() + "</p></b></html>",
						"<html><b><p style=\"color:gray;\">" + this.balance.getTransferenciaDiluyente()
								+ "</p></b></html>",
						"<html><b><p style=\"color:gray;\">" + this.balance.getConsumoDiluyente() + "</p></b></html>",
						"<html><b><p style=\"color:gray;\">" + this.balance.getDrenajeDiluyente()
								+ "</p></b></html>" });
				modeloAgua.addRow(new Object[] { "<html><b><p style=\"color:rgb(0,0,153);\">TOTAL</p></b></html>",
						"<html><b><p style=\"color:rgb(0,0,153);\">" + this.balance.getReciboAguaDiluyente()
								+ "</p></b></html>",
						"<html><b><p style=\"color:rgb(0,0,153);\">" + this.balance.getEntregaAguaDiluyente()
								+ "</p></b></html>",
						"<html><b><p style=\"color:rgb(0,0,153);\">" + this.balance.getInyeccionAguaDiluyente()
								+ "</p></b></html>",
						"<html><b><p style=\"color:rgb(0,0,153);\">" + this.balance.getTransferenciaAguaDiluyente()
								+ "</p></b></html>",
						"<html><b><p style=\"color:rgb(0,0,153);\">" + this.balance.getConsumoAguaDiluyente()
								+ "</p></b></html>",
						"<html><b><p style=\"color:rgb(0,0,153);\">" + this.balance.getDrenajeAguaDiluyente()
								+ "</p></b></html>" });
			}
			modeloProduccion.addRow(
					new Object[] { "NSV con Diluyente", this.balance.getRecibo(), this.balance.getRecibo24H() });
			modeloProduccion.addRow(new Object[] { "Aceite producido", this.balance.getAceiteProducido(),
					this.balance.getAceiteProducido24H() });
			modeloProduccion.addRow(new Object[] { "Agua producida", this.balance.getAguaProducida(),
					this.balance.getAguaProducida24H() });
			modeloProduccion.addRow(new Object[] { "Diluyente", this.balance.getInyeccionDiluyente(),
					this.balance.getInyeccionDiluyente24H() });
			modeloProduccion.addRow(new Object[] { "% SYW", this.balance.getsYw(), this.balance.getsYw24H() });
			modeloProduccion.addRow(new Object[] { "Gas", this.balance.getGas(), this.balance.getGas24H() });

			frmBalance.tbMovimientosNSV.setModel(modeloNSV);
			frmBalance.tbMovimientosAgua.setModel(modeloAgua);
			frmBalance.tbProduccion.setModel(modeloProduccion);
		} catch (SQLException ex) {
			Logger.getLogger(CtrlBalance.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void actualizarBalance() {
		this.actualizarIniciales();
		this.actualizarFinales();
		this.frmBalance.btnLiquidar.setEnabled(true);
	}

	public void mostrarBalance(String fluido) {
		if ("Crudo".equals(fluido)) {
			this.frmBalance.lblTotalNSVInicial.setForeground(Color.black);
			this.frmBalance.lblTotalNSVFinal.setForeground(Color.black);
			this.frmBalance.lblTotalNSVInicial.setText(String.valueOf(this.balance.getIniciales()));
			this.frmBalance.lblTotalAguaInicial.setText(String.valueOf(this.balance.getInicialesAgua()));
			this.frmBalance.lblTotalNSVFinal.setText(String.valueOf(this.balance.getFinales()));
			this.frmBalance.lblTotalAguaFinal.setText(String.valueOf(this.balance.getFinalesAgua()));
		} else {
			this.frmBalance.lblTotalNSVInicial.setForeground(Color.gray);
			this.frmBalance.lblTotalNSVFinal.setForeground(Color.gray);
			this.frmBalance.lblTotalNSVInicial.setText(String.valueOf(this.balance.getInicialesDiluyente()));
			this.frmBalance.lblTotalAguaInicial.setText(String.valueOf(this.balance.getInicialesAguaDiluyente()));
			this.frmBalance.lblTotalNSVFinal.setText(String.valueOf(this.balance.getFinalesDiluyente()));
			this.frmBalance.lblTotalAguaFinal.setText(String.valueOf(this.balance.getFinalesAguaDiluyente()));
		}
	}

	public void limpiarBalance() {
		this.balance.setRecibo(0);
		this.balance.setEntrega(0);
		this.balance.setInyeccion(0);
		this.balance.setTransferencia(0);
		this.balance.setDrenaje(0);
		this.balance.setConsumo(0);
		this.balance.setReciboAgua(0);
		this.balance.setEntregaAgua(0);
		this.balance.setInyeccionAgua(0);
		this.balance.setTransferenciaAgua(0);
		this.balance.setDrenajeAgua(0);
		this.balance.setConsumoAgua(0);

		this.balance.setReciboDiluyente(0);
		this.balance.setEntregaDiluyente(0);
		this.balance.setInyeccionDiluyente(0);
		this.balance.setTransferenciaDiluyente(0);
		this.balance.setDrenajeDiluyente(0);
		this.balance.setConsumoDiluyente(0);
		this.balance.setReciboAguaDiluyente(0);
		this.balance.setEntregaAguaDiluyente(0);
		this.balance.setInyeccionAguaDiluyente(0);
		this.balance.setTransferenciaAguaDiluyente(0);
		this.balance.setDrenajeAguaDiluyente(0);
		this.balance.setConsumoAguaDiluyente(0);
	}

	public String verificarDia(Calendar fechaAComparar, Calendar fechaDeComparacion) {
		String resultado = null;
		if (fechaAComparar.get(Calendar.DAY_OF_YEAR) == fechaDeComparacion.get(Calendar.DAY_OF_YEAR)) {
			resultado = "IGUAL";
		}
		if (fechaAComparar.get(Calendar.DAY_OF_YEAR) > fechaDeComparacion.get(Calendar.DAY_OF_YEAR)) {
			resultado = "MAYOR";
		}
		if (fechaAComparar.get(Calendar.DAY_OF_YEAR) < fechaDeComparacion.get(Calendar.DAY_OF_YEAR)) {
			resultado = "MENOR";
		}
		return resultado;
	}

	public boolean hayBalance(Calendar fechaXEvaluar, String idPozo) {
		boolean estado = false;
		Calendar fechaUltimoBal;
		Balance ultimoBal = new Balance();
		ultimoBal.setIdPozo(idPozo);
		java.sql.Date sqlFecha = new java.sql.Date(fechaXEvaluar.getTime().getTime());
		ultimoBal.setFecha(sqlFecha);

		try {
			if (this.balanceC.buscarUltimoXFecha(ultimoBal)) {
				fechaUltimoBal = ctrlUtilities.asignacionFechas(ultimoBal.getFecha(), ultimoBal.getFecha());
				if ("IGUAL".equals(this.verificarDia(fechaUltimoBal, fechaXEvaluar))) {
					estado = true;
					this.frmBalance.txtApiCabeza.setText(String.valueOf(ultimoBal.getApiCabeza()));
					this.frmBalance.txtViscocidad.setText(String.valueOf(ultimoBal.getViscocidad()));
					this.frmBalance.txtTempViscocidad.setText(String.valueOf(ultimoBal.getTempViscocidad()));
					this.frmBalance.txtSalinidad.setText(String.valueOf(ultimoBal.getSalinidad()));
					this.frmBalance.txtCloruros.setText(String.valueOf(ultimoBal.getCloruros()));
					this.frmBalance.txtPh.setText(String.valueOf(ultimoBal.getPh()));
					this.frmBalance.txtChoke.setText(String.valueOf(ultimoBal.getChoke()));
					this.frmBalance.txtComentarios.setText(String.valueOf(ultimoBal.getComentarios()));
				}
			}
		} catch (SQLException ex) {
			Logger.getLogger(CtrlBalance.class.getName()).log(Level.SEVERE, null, ex);
		}
		return estado;
	}

	public final Balance obtenerFechaXPozoUltimoMov() {
		Balance bal = new Balance();
		String idPozo = this.frmBalance.cmbxIdPozo.getSelectedItem().toString();
		bal.setIdPozo(idPozo);
		try {
			if (this.balanceC.buscarUltimoXPozo(bal)) {

			}
		} catch (SQLException ex) {
			Logger.getLogger(CtrlBalance.class.getName()).log(Level.SEVERE, null, ex);
		}

		return bal;
	}

	public void esBalanceCerrado() {
		Calendar fechaXEvaluar = frmBalance.dtchFecha.getCalendar();
		String idPozo = frmBalance.cmbxIdPozo.getSelectedItem().toString();
		if (hayBalance(fechaXEvaluar, idPozo)) {
			frmBalance.lblCerrado.setVisible(true);
		} else {
			frmBalance.lblCerrado.setVisible(false);
		}
	}

	private void actualizarFechas() {
		Balance datosUltimoMov = this.obtenerFechaXPozoUltimoMov();
		if (datosUltimoMov.getFecha() != null) {
			// SpinnerDateModel fechaModel = new SpinnerDateModel(datosUltimoMov.getFecha(),
			// null, null, Calendar.MONTH);
			// this.frmBalance.spnFecha.setModel(fechaModel);
			// jcalendar
			this.frmBalance.dtchFecha.setDate(datosUltimoMov.getFecha());
			this.frmBalance.txtApiCabeza.setText(String.valueOf(datosUltimoMov.getApiCabeza()));
			this.frmBalance.txtViscocidad.setText(String.valueOf(datosUltimoMov.getViscocidad()));
			this.frmBalance.txtTempViscocidad.setText(String.valueOf(datosUltimoMov.getTempViscocidad()));
			this.frmBalance.txtSalinidad.setText(String.valueOf(datosUltimoMov.getSalinidad()));
			this.frmBalance.txtCloruros.setText(String.valueOf(datosUltimoMov.getCloruros()));
			this.frmBalance.txtPh.setText(String.valueOf(datosUltimoMov.getPh()));
			this.frmBalance.txtChoke.setText(String.valueOf(datosUltimoMov.getChoke()));
			this.frmBalance.txtComentarios.setText(String.valueOf(datosUltimoMov.getComentarios()));

		} else {
			// SpinnerDateModel fechaModel = new
			// SpinnerDateModel(this.ctrlUtilities.getFechaActual(), null, null,
			// Calendar.MONTH);
			// this.frmBalance.spnFecha.setModel(fechaModel);
			// jcalendar
			this.frmBalance.dtchFecha.setDate(this.ctrlUtilities.getFechaActual());
		}
		// JSpinner.DateEditor ded = new JSpinner.DateEditor(this.frmBalance.spnFecha,
		// "EEE, d MMM yyyy");
		// this.frmBalance.spnFecha.setEditor(ded);
	}

	public void calcularCrudoDiluyente(DefaultTableModel modelo, String fluido, OperacionTk ultimaOp,
			Calculos volumenTotal) {
		double totalNsv = volumenTotal.getTotalNsv();
		double totalAgua = volumenTotal.getTotalAgua();
		double totalNsvDiluyente = volumenTotal.getTotalNsvDiluyente();
		double totalAguaDiluyente = volumenTotal.getTotalAguaDiluyente();
		if ("Crudo".equals(fluido) && "Crudo".equals(ultimaOp.getFluido())) {
			modelo.addRow(new Object[] { ultimaOp.getIdTanque(), ultimaOp.getNsv(), ultimaOp.getAgua() });
		} else {
			if ("Diluyente".equals(fluido) && "Diluyente".equals(ultimaOp.getFluido())) {
				modelo.addRow(new Object[] { ultimaOp.getIdTanque(), ultimaOp.getNsv(), ultimaOp.getAgua() });
			} else {
//				 "ID Tanques", "Fluido", "Pozo", "Nivel", "Interfase", "TOV", "GOV", "GSV", "NSV", "AGUA"
				modelo.addRow(new Object[] { ultimaOp.getIdTanque(), ultimaOp.getFluido(), ultimaOp.getIdPozo(),
						ultimaOp.getNivel(), ultimaOp.getInterfase(), volumenTotal.formatearDecimales(ultimaOp.getTov(),2),
						volumenTotal.formatearDecimales(ultimaOp.getGov(), 2), volumenTotal.formatearDecimales(ultimaOp.getGsv(), 2), ultimaOp.getNsv(),
						ultimaOp.getAgua() });
			}
		}
		if ("Crudo".equals(ultimaOp.getFluido())) {
			totalNsv = totalNsv + ultimaOp.getNsv();
			totalAgua = totalAgua + ultimaOp.getAgua();
		} else {
			if ("Diluyente".equals(ultimaOp.getFluido())) {
				totalNsvDiluyente = totalNsvDiluyente + ultimaOp.getNsv();
				totalAguaDiluyente = totalAguaDiluyente + ultimaOp.getAgua();
			}
		}
		volumenTotal.setTotalNsv(totalNsv);
		volumenTotal.setTotalAgua(totalAgua);
		volumenTotal.setTotalNsvDiluyente(totalNsvDiluyente);
		volumenTotal.setTotalAguaDiluyente(totalAguaDiluyente);
	}

	public void buscarIniciales(String idPozo, String fluido, Calendar fechaRequerida, DefaultTableModel modelo,
			Calculos volumenTotal) throws SQLException {
		ArrayList listadoTks;
		OperacionTk ultimaOp = new OperacionTk();
		Balance ultimoBal = new Balance();
		Calendar convertirFecha = null;
		java.sql.Date sqlFecha = new java.sql.Date(fechaRequerida.getTime().getTime());

		listadoTks = ctrlTanques.tanquesC.listarTanques();
		for (Object listadoTk : listadoTks) {

			// cargar objetos para la consulta
			ultimaOp.setIdPozo(idPozo);
			ultimoBal.setIdPozo(idPozo);
			ultimoBal.setFecha(sqlFecha);
			ultimaOp.setFecha(sqlFecha);
			ultimaOp.setIdTanque(listadoTk.toString());

			if (balanceC.buscarUltimoXFecha(ultimoBal)) {
				if (ctrlOperacionTk.operacionTkC.buscarUltimosXfechaParaBalance(ultimaOp)) {
					if ("IGUAL".equals(this.verificarDia(
							this.ctrlUtilities.asignacionFechas(ultimaOp.getFecha(), ultimaOp.getFecha()),
							fechaRequerida))) {
						convertirFecha = ctrlUtilities.asignacionFechas(sqlFecha, sqlFecha);
						int dia = convertirFecha.get(Calendar.DAY_OF_YEAR);
						convertirFecha.set(Calendar.DAY_OF_YEAR, dia - 1);
						java.sql.Date sqlConvertirFecha = new java.sql.Date(convertirFecha.getTime().getTime());
						ultimaOp.setFecha(sqlConvertirFecha);
						if (ctrlOperacionTk.operacionTkC.buscarUltimosXfechaParaBalance(ultimaOp)) {
							this.calcularCrudoDiluyente(modelo, fluido, ultimaOp, volumenTotal);
						} else {
							ultimaOp.setFecha(sqlFecha);
							if (ctrlOperacionTk.operacionTkC.buscarPrimerosXfechaParaBalance(ultimaOp)) {
								this.calcularCrudoDiluyente(modelo, fluido, ultimaOp, volumenTotal);
							}
						}
					} else {
						if ("MENOR".equals(this.verificarDia(
								this.ctrlUtilities.asignacionFechas(ultimaOp.getFecha(), ultimaOp.getFecha()),
								fechaRequerida))) {
							if (ctrlOperacionTk.operacionTkC.buscarUltimosXfechaParaBalance(ultimaOp)) {
								this.calcularCrudoDiluyente(modelo, fluido, ultimaOp, volumenTotal);
							}
						}
					}
				}
			} else {
				if (ctrlOperacionTk.operacionTkC.buscarPrimerosXfechaParaBalance(ultimaOp)) {
					this.calcularCrudoDiluyente(modelo, fluido, ultimaOp, volumenTotal);
				}
			}
		}
	}

	public void buscarFinales(ArrayList listadoTks, Calendar fecha, String idPozo, DefaultTableModel modelo,
			String fluido, Calculos volumenTotal, java.sql.Date fechaUltimoM, String ultimoTk) throws SQLException {
		java.sql.Date sqlFecha = new java.sql.Date(fecha.getTime().getTime());
		OperacionTk ultimaOp = new OperacionTk();
		for (Object listadoTk : listadoTks) {
			// toma de datos
			ultimaOp.setFecha(sqlFecha);
			ultimaOp.setIdPozo(idPozo);
			ultimaOp.setIdTanque(listadoTk.toString());
			if (ctrlOperacionTk.operacionTkC.buscarUltimosXfechaParaBalance(ultimaOp)) {
				this.calcularCrudoDiluyente(modelo, fluido, ultimaOp, volumenTotal);
				if (fechaUltimoM != null) {
					if ("MENOR"
							.equals(this.verificarDia(this.ctrlUtilities.asignacionFechas(fechaUltimoM, fechaUltimoM),
									this.ctrlUtilities.asignacionFechas(ultimaOp.getFecha(), ultimaOp.getFecha())))) {
						fechaUltimoM = ultimaOp.getFecha();
						ultimoTk = ultimaOp.getIdTanque();
					}
				} else {
					fechaUltimoM = ultimaOp.getFecha();
					ultimoTk = ultimaOp.getIdTanque();
				}
			} else {
				if (ctrlOperacionTk.operacionTkC.buscarUltimoXPozoYTk(ultimaOp)) {
					if (fechaUltimoM != null) {
						if ("MENOR".equals(this.verificarDia(
								this.ctrlUtilities.asignacionFechas(fechaUltimoM, fechaUltimoM),
								this.ctrlUtilities.asignacionFechas(ultimaOp.getFecha(), ultimaOp.getFecha())))) {
							fechaUltimoM = ultimaOp.getFecha();
							ultimoTk = ultimaOp.getIdTanque();
						}
					} else {
						fechaUltimoM = ultimaOp.getFecha();
						ultimoTk = ultimaOp.getIdTanque();
					}
				}
			}
			this.fechaUltimoMovimiento = fechaUltimoM;
			this.ultimoTkMovimiento = ultimoTk;
		}
	}

}

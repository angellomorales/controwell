package com.petra.controwell.control.internal;

import com.petra.controwell.model.CalculoApi;
import com.petra.controwell.model.Calculos;
import com.petra.controwell.model.data.Balance;
import com.petra.controwell.model.data.OperacionTk;
import com.petra.controwell.model.data.querys.ConsultasOperacionTk;
import com.petra.controwell.model.utilities.Utilities;
import com.petra.controwell.view.internal.FrmApi;
import com.petra.controwell.view.internal.FrmOperacionTk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

/**
 *
 * @author Angello Morales
 */
public class CtrlOperacionTk implements ActionListener {

	// vista
	public FrmOperacionTk frmOperacionTk;

	// modelo BD
	public OperacionTk operacionTk;
	public ConsultasOperacionTk operacionTkC;

	// modelo
	public Calculos calculos;
	// controlador
	public Utilities ctrlUtilities;
	public CtrlAforoTk ctrlAforoTk;
	public CtrlTanques ctrlTanques;
	public CtrlApi ctrlApi;
	public CtrlBalance ctrlBalance;
	// variables
	private double ultimoNSV;
	private double ultimoAgua;
	private double enOperacionNSV;
	private double enOperacionAgua;

	public CtrlOperacionTk(FrmOperacionTk frmOperacionTk, OperacionTk operacionTk, Calculos calculos,
			ConsultasOperacionTk operacionTkC, Utilities ctrlUtilities, CtrlAforoTk ctrlAforoTk,
			CtrlTanques ctrlTanques, FrmApi frmApi, CalculoApi calculoApi, CtrlBalance ctrlBalance) {
		this.frmOperacionTk = frmOperacionTk;
		this.operacionTk = operacionTk;
		this.operacionTkC = operacionTkC;
		this.calculos = calculos;
		this.ctrlUtilities = ctrlUtilities;
		this.ctrlAforoTk = ctrlAforoTk;
		this.ctrlTanques = ctrlTanques;
		this.ctrlBalance = ctrlBalance;
		this.ctrlApi = new CtrlApi(frmApi, calculoApi, ctrlUtilities, ctrlBalance, this);

		// agregar listener a los botones dentro del constructor
		this.frmOperacionTk.btnAPI.addActionListener(this);
		this.frmOperacionTk.btnGuardar.addActionListener(this);
		this.frmOperacionTk.btnCerrar.addActionListener(this);
		this.frmOperacionTk.btnCalcular.addActionListener(this);
		this.frmOperacionTk.btnBorrarUltimo.addActionListener(this);

		// instanciar librerias;
		OperacionTk datosUltimoMov = this.obtenerFechayPozoUltimoMov();
		if (datosUltimoMov.getFecha() != null) {
			SpinnerDateModel horaModel = new SpinnerDateModel(datosUltimoMov.getHora(), null, null,
					Calendar.HOUR_OF_DAY);
			this.frmOperacionTk.spnHora.setModel(horaModel);
//            SpinnerDateModel fechaModel = new SpinnerDateModel(datosUltimoMov.getFecha(), null, null, Calendar.MONTH);
//            this.frmOperacionTk.spnFecha.setModel(fechaModel);
			this.frmOperacionTk.dtchFecha.setDate(datosUltimoMov.getFecha());
		} else {
			SpinnerDateModel horaModel = new SpinnerDateModel(this.ctrlUtilities.getFechaActual(), null, null,
					Calendar.HOUR_OF_DAY);
			this.frmOperacionTk.spnHora.setModel(horaModel);
//            SpinnerDateModel fechaModel = new SpinnerDateModel(this.ctrlUtilities.getFechaActual(), null, null, Calendar.MONTH);
//            this.frmOperacionTk.spnFecha.setModel(fechaModel);
			this.frmOperacionTk.dtchFecha.setDate(this.ctrlUtilities.getFechaActual());
		}
		JSpinner.DateEditor deh = new JSpinner.DateEditor(this.frmOperacionTk.spnHora, "h:mm:ss a");
		this.frmOperacionTk.spnHora.setEditor(deh);
//        JSpinner.DateEditor ded = new JSpinner.DateEditor(this.frmOperacionTk.spnFecha, "EEE, d MMM yyyy");
//        this.frmOperacionTk.spnFecha.setEditor(ded);
	}

	public void iniciar() throws PropertyVetoException {
		frmOperacionTk.setTitle("Realizar Movimientos");
		frmOperacionTk.setVisible(true);
		frmOperacionTk.toFront();
		frmOperacionTk.setSelected(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// acciones a ejecutar cuando se presiona un elemento en la pantalla
		// if por cada elemento para detectar cual se presiono
		// --------------Calcular--------------
		if (e.getSource() == frmOperacionTk.btnCalcular) {
			frmOperacionTk.btnGuardar.setEnabled(true);
			this.vaciarOperaciones();
			this.ejecutarCalculo();

		}
		// --------------Guardar--------------
		if (e.getSource() == frmOperacionTk.btnGuardar) {
			// cargar datos al modelo si es necesario(cajas de texto etc...)

			// ejecutar consultas en base de datos y asigna a la ventana
			OperacionTk verificarOperacionTK = new OperacionTk();
			// variables para verificacion fecha
			Calendar fechaAnterior;
			Calendar fechaActual;
			Time horaActual = ctrlUtilities.getHoraActual();
			verificarOperacionTK.setIdPozo(operacionTk.getIdPozo());
			verificarOperacionTK.setIdTanque(operacionTk.getIdTanque());
			verificarOperacionTK.setNivel(operacionTk.getNivel());
			try {
				if (operacionTkC.buscarUltimoXPozoYTk(verificarOperacionTK)) {
					if (operacionTk.getNivel() == verificarOperacionTK.getNivel()) {
						JOptionPane.showMessageDialog(null, "Registro repetido verifique los valores");

					} else {
						// asignacion de fechas
						// fechaActual = ctrlUtilities.asignacionFechas((java.util.Date)
						// frmOperacionTk.spnFecha.getValue(), (java.util.Date)
						// frmOperacionTk.spnHora.getValue());
						fechaActual = ctrlUtilities.asignacionFechas(frmOperacionTk.dtchFecha.getDate(),
								(java.util.Date) frmOperacionTk.spnHora.getValue());
						fechaAnterior = ctrlUtilities.asignacionFechas(verificarOperacionTK.getFecha(),
								verificarOperacionTK.getHora());
						// verificacion de fechas
						this.verificacionFecha(fechaActual, fechaAnterior, horaActual, false);
					}
				} else {
					// asignacion de fechas
					if (operacionTkC.buscarUltimaFecha(verificarOperacionTK)) {
						// fechaActual = ctrlUtilities.asignacionFechas((java.util.Date)
						// frmOperacionTk.spnFecha.getValue(), (java.util.Date)
						// frmOperacionTk.spnHora.getValue());
						fechaActual = ctrlUtilities.asignacionFechas(frmOperacionTk.dtchFecha.getDate(),
								(java.util.Date) frmOperacionTk.spnHora.getValue());
						fechaAnterior = ctrlUtilities.asignacionFechas(verificarOperacionTK.getFecha(),
								verificarOperacionTK.getHora());
						// verificacion de fechas
						this.verificacionFecha(fechaActual, fechaAnterior, horaActual, true);
					} else {
						if (operacionTk.getTipo().equals("Inicial")) {
							//se pone por el error cuando usa el gethora del ctrlutilites ya que por alguna razon cambia el valor de la hora de operacionTK
			                Time autoHora=ctrlUtilities.getHoraActual();
			                java.util.Date myHora= (java.util.Date) frmOperacionTk.spnHora.getValue();
			                autoHora.setTime(myHora.getTime());
			                operacionTk.setHora(autoHora);
						}
						if (operacionTkC.agregarDatos(operacionTk)) {
							JOptionPane.showMessageDialog(null, "Registro inicial almacenado");
						}
					}
				}
				frmOperacionTk.tbUltimaOp.setModel(operacionTkC.listarMovimientosDelDia(operacionTk));
				ctrlBalance.actualizarEstadoTanques();
				frmOperacionTk.btnGuardar.setEnabled(false);
			} catch (SQLException ex) {
				System.err.println("Error al guardar: " + ex);
			}

		}
		// --------------Abrir API--------------
		if (e.getSource() == frmOperacionTk.btnAPI) {
			try {
				// cargar datos al modelo si es necesario(cajas de texto etc...)
				ctrlApi.iniciar(ctrlApi.OPERACIONTK);
			} catch (PropertyVetoException ex) {
				Logger.getLogger(CtrlOperacionTk.class.getName()).log(Level.SEVERE, null, ex);
			}

		}
		// --------------cerrar--------------
		if (e.getSource() == frmOperacionTk.btnCerrar) {
			this.frmOperacionTk.hide();
			this.limpiar();
		}
		// --------------borrar--------------
		if (e.getSource() == frmOperacionTk.btnBorrarUltimo) {
			Balance ultimoBal = new Balance();
			OperacionTk ultimaOp = new OperacionTk();
			Calendar fechaUltimoMov = null;
			Calendar fechaUltimoBal = null;
			int seguro;
			String idPozo = this.frmOperacionTk.cmbxIdPozo.getSelectedItem().toString();
			ultimoBal.setIdPozo(idPozo);
			ultimaOp.setIdPozo(idPozo);
			try {
				if (this.ctrlBalance.balanceC.buscarUltimoXPozo(ultimoBal)) {
					fechaUltimoBal = ctrlUtilities.asignacionFechas(ultimoBal.getFecha(), ultimoBal.getFecha());
					if (this.operacionTkC.buscarUltimoXPozo(ultimaOp)) {
						fechaUltimoMov = ctrlUtilities.asignacionFechas(ultimaOp.getFecha(), ultimaOp.getFecha());
						if ("MENOR".equals(this.ctrlBalance.verificarDia(fechaUltimoBal, fechaUltimoMov))) {
							seguro = JOptionPane.showConfirmDialog(null,
									"Seguro que desea eliminar el ultimo movimiento, ESTA OPCION NO SE PUEDE DESHACER");
							if (seguro == 0) {
								if (this.operacionTkC.eliminarDatos(ultimaOp)) {
									JOptionPane.showMessageDialog(null, "Registro eliminado");
									frmOperacionTk.tbUltimaOp
											.setModel(operacionTkC.listarMovimientosDelDia(operacionTk));
									ctrlBalance.actualizarEstadoTanques();
								} else {
									JOptionPane.showMessageDialog(null, "no se puede eliminar el registro");
								}
							}
						} else {
							JOptionPane.showMessageDialog(null,
									"no se puede eliminar el registro, verifique que no se haya generado el balance");
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"no se puede eliminar el registro, no se encuentra el ultimo movimiento");
					}
				} else {
					if (this.operacionTkC.buscaSiHayInicial(ultimaOp)) {
						if (this.operacionTkC.buscarUltimoXPozo(ultimaOp)) {
							seguro = JOptionPane.showConfirmDialog(null,
									"Seguro que desea eliminar el ultimo movimiento, ESTA OPCION NO SE PUEDE DESHACER");
							if (seguro == 0) {
								if (this.operacionTkC.eliminarDatos(ultimaOp)) {
									JOptionPane.showMessageDialog(null, "Registro eliminado");
									frmOperacionTk.tbUltimaOp
											.setModel(operacionTkC.listarMovimientosDelDia(operacionTk));
									ctrlBalance.actualizarEstadoTanques();
								} else {
									JOptionPane.showMessageDialog(null, "no se puede eliminar el registro");
								}
							} else {
								JOptionPane.showMessageDialog(null,
										"no se puede eliminar el registro, no se encuentra el ultimo movimiento");
							}
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"no se puede eliminar el registro, no se encuentra el ultimo balance");
					}
				}

			} catch (SQLException ex) {
				Logger.getLogger(CtrlBalance.class.getName()).log(Level.SEVERE, null, ex);
			}

		}
	}

	public double getUltimoNSV() {
		return ultimoNSV;
	}

	public void setUltimoNSV(double ultimoNSV) {
		this.ultimoNSV = ultimoNSV;
	}

	public double getUltimoAgua() {
		return ultimoAgua;
	}

	public void setUltimoAgua(double ultimoAgua) {
		this.ultimoAgua = ultimoAgua;
	}

	public double getEnOperacionNSV() {
		return enOperacionNSV;
	}

	public void setEnOperacionNSV(double enOperacionNSV) {
		this.enOperacionNSV = enOperacionNSV;
	}

	public double getEnOperacionAgua() {
		return enOperacionAgua;
	}

	public void setEnOperacionAgua(double enOperacionAgua) {
		this.enOperacionAgua = enOperacionAgua;
	}

	public void vaciarOperaciones() {
		operacionTk.setRecibo(0);
		operacionTk.setReciboAgua(0);
		operacionTk.setEntrega(0);
		operacionTk.setEntregaAgua(0);
		operacionTk.setInyeccion(0);
		operacionTk.setInyeccionAgua(0);
		operacionTk.setTransferencia(0);
		operacionTk.setTransferenciaAgua(0);
		operacionTk.setDrenaje(0);
		operacionTk.setDrenajeAgua(0);
		operacionTk.setConsumo(0);
		operacionTk.setConsumoAgua(0);
	}

	public void limpiar() {
		frmOperacionTk.txtNivel.setText("");
		frmOperacionTk.txtInterfase.setText("");
		frmOperacionTk.txtAPI.setText("");
		frmOperacionTk.txtSYW.setText("");
		frmOperacionTk.txtTempAmbiente.setText("");
		frmOperacionTk.txtTempFluido.setText("");
		frmOperacionTk.lblTOV.setText("0");
		frmOperacionTk.lblGOV.setText("0");
		frmOperacionTk.lblGSV.setText("0");
		frmOperacionTk.lblCTSh.setText("0");
		frmOperacionTk.lblCTL.setText("0");
		frmOperacionTk.lblFW.setText("0");
		frmOperacionTk.lblCSW.setText("0");
		frmOperacionTk.lblAgua.setText("0");
		frmOperacionTk.lblNSV.setText("0");
		frmOperacionTk.lblOperacionNSV.setText("0");
		frmOperacionTk.lblOperacionAgua.setText("0");
		frmOperacionTk.btnGuardar.setEnabled(false);
	}

	public void tomarDatos() {
		String tipo;
		double nivelAnterior;
		tipo = operacionTk.getTipo();
		nivelAnterior = operacionTk.getNivel();
		ctrlUtilities.setTextFieldOk(true);
		operacionTk.setNivel(Double.parseDouble(ctrlUtilities.VerificarTextField(frmOperacionTk.txtNivel)));
		operacionTk.setInterfase(Double.parseDouble(ctrlUtilities.VerificarTextField(frmOperacionTk.txtInterfase)));
		if ("Inicial".equals(tipo) || "Recibo".equals(tipo)
				|| ("Transferencia".equals(tipo) && nivelAnterior < operacionTk.getNivel())) {
			operacionTk.setApi(Double.parseDouble(ctrlUtilities.VerificarTextField(frmOperacionTk.txtAPI)));
			operacionTk.setsYw(Double.parseDouble(ctrlUtilities.VerificarTextField(frmOperacionTk.txtSYW)));
			operacionTk
					.setTempFluido(Double.parseDouble(ctrlUtilities.VerificarTextField(frmOperacionTk.txtTempFluido)));
			operacionTk.setTempAmbiente(
					Double.parseDouble(ctrlUtilities.VerificarTextField(frmOperacionTk.txtTempAmbiente)));
		} else {
			frmOperacionTk.txtAPI.setText(String.valueOf(calculos.formatearDecimales(operacionTk.getApi(), 2)));
			frmOperacionTk.txtSYW.setText(String.valueOf(calculos.formatearDecimales(operacionTk.getsYw(), 2)));
			frmOperacionTk.txtTempFluido
					.setText(String.valueOf(calculos.formatearDecimales(operacionTk.getTempFluido(), 1)));
			frmOperacionTk.txtTempAmbiente
					.setText(String.valueOf(calculos.formatearDecimales(operacionTk.getTempAmbiente(), 1)));
		}

	}

	public void calcularVariables() {
		String tipo;

		operacionTk.setCtsh(calculos.calcularCtsh(operacionTk.getTempFluido(), operacionTk.getTempAmbiente(),
				ctrlAforoTk.aforoTk.getTemperaturaBase(), ctrlAforoTk.aforoTk.getMaterial()));
		operacionTk.setGov(calculos.calcularGOV(operacionTk.getTov(), operacionTk.getFw(), operacionTk.getCtsh()));

		ctrlTanques.tanques.setIdTanque(operacionTk.getIdTanque());
		try {
			ctrlTanques.tanquesC.buscarTanques(ctrlTanques.tanques);
			operacionTk.setCtl(calculos.calcularCTL(operacionTk.getApi(), operacionTk.getTempFluido(),
					ctrlTanques.tanques.getTipoFluido()));
			switch (ctrlTanques.tanques.getTipoFluido()) {
			case "crudo":
				operacionTk.setFluido("Crudo");
				break;
			case "refinado":
				operacionTk.setFluido("Diluyente");
				break;
			case "lubricante":
				operacionTk.setFluido("Lubricante");
				break;
			default:
				throw new AssertionError();
			}
		} catch (SQLException ex) {
			System.err.println("Error al tipo de fluido: " + ex);
		}

		operacionTk.setGsv(calculos.calcularGSV(operacionTk.getGov(), operacionTk.getCtl()));
		operacionTk.setCsw(calculos.calcularCSW(operacionTk.getsYw()));
		operacionTk.setNsv(calculos.calcularNSV(operacionTk.getCsw(), operacionTk.getGsv()));
		operacionTk.setAgua(calculos.calcularAgua(operacionTk.getCsw(), operacionTk.getGsv(), operacionTk.getFw()));

		tipo = operacionTk.getTipo();
		switch (tipo) {
		case "Recibo":
			if (operacionTk.getNsv() >= getUltimoNSV() && operacionTk.getAgua() >= getUltimoAgua()) {
				setEnOperacionNSV(operacionTk.getNsv() - getUltimoNSV());
				setEnOperacionAgua(operacionTk.getAgua() - getUltimoAgua());
				operacionTk.setRecibo(calculos.formatearDecimales(getEnOperacionNSV(), 2));
				operacionTk.setReciboAgua(calculos.formatearDecimales(getEnOperacionAgua(), 2));
			} else {
				JOptionPane.showMessageDialog(null, "operacion inconsistente, revise los valores");
				frmOperacionTk.btnGuardar.setEnabled(false);
			}
			break;
		case "Transferencia":
			if (operacionTk.getNsv() >= getUltimoNSV() && operacionTk.getAgua() >= getUltimoAgua()) {
				setEnOperacionNSV(operacionTk.getNsv() - getUltimoNSV());
				setEnOperacionAgua(operacionTk.getAgua() - getUltimoAgua());
			} else {
				setEnOperacionNSV((getUltimoNSV() - operacionTk.getNsv()) * -1);
				setEnOperacionAgua((getUltimoAgua() - operacionTk.getAgua()) * -1);
			}
			operacionTk.setTransferencia(calculos.formatearDecimales(getEnOperacionNSV(), 2));
			operacionTk.setTransferenciaAgua(calculos.formatearDecimales(getEnOperacionAgua(), 2));
			break;
		case "Entrega":
			if (operacionTk.getNsv() <= getUltimoNSV() && operacionTk.getAgua() <= getUltimoAgua()) {
				setEnOperacionNSV(getUltimoNSV() - operacionTk.getNsv());
				setEnOperacionAgua(getUltimoAgua() - operacionTk.getAgua());
				operacionTk.setEntrega(calculos.formatearDecimales(getEnOperacionNSV(), 2));
				operacionTk.setEntregaAgua(calculos.formatearDecimales(getEnOperacionAgua(), 2));
			} else {
				JOptionPane.showMessageDialog(null, "operacion inconsistente, revise los valores");
				frmOperacionTk.btnGuardar.setEnabled(false);
			}
			break;
		case "Inyeccion":
			if (operacionTk.getNsv() <= getUltimoNSV() && operacionTk.getAgua() <= getUltimoAgua()) {
				setEnOperacionNSV(getUltimoNSV() - operacionTk.getNsv());
				setEnOperacionAgua(getUltimoAgua() - operacionTk.getAgua());
				operacionTk.setInyeccion(calculos.formatearDecimales(getEnOperacionNSV(), 2));
				operacionTk.setInyeccionAgua(calculos.formatearDecimales(getEnOperacionAgua(), 2));
			} else {
				JOptionPane.showMessageDialog(null, "operacion inconsistente, revise los valores");
				frmOperacionTk.btnGuardar.setEnabled(false);
			}
			break;
		case "Drenaje":
			if (operacionTk.getNsv() <= getUltimoNSV() && operacionTk.getAgua() <= getUltimoAgua()) {
				setEnOperacionNSV(getUltimoNSV() - operacionTk.getNsv());
				setEnOperacionAgua(getUltimoAgua() - operacionTk.getAgua());
				operacionTk.setDrenaje(calculos.formatearDecimales(getEnOperacionNSV(), 2));
				operacionTk.setDrenajeAgua(calculos.formatearDecimales(getEnOperacionAgua(), 2));
			} else {
				JOptionPane.showMessageDialog(null, "operacion inconsistente, revise los valores");
				frmOperacionTk.btnGuardar.setEnabled(false);
			}
			break;
		case "Consumo":
			if (operacionTk.getNsv() <= getUltimoNSV() && operacionTk.getAgua() <= getUltimoAgua()) {
				setEnOperacionNSV(getUltimoNSV() - operacionTk.getNsv());
				setEnOperacionAgua(getUltimoAgua() - operacionTk.getAgua());
				operacionTk.setConsumo(calculos.formatearDecimales(getEnOperacionNSV(), 2));
				operacionTk.setConsumoAgua(calculos.formatearDecimales(getEnOperacionAgua(), 2));
			} else {
				JOptionPane.showMessageDialog(null, "operacion inconsistente, revise los valores");
				frmOperacionTk.btnGuardar.setEnabled(false);
			}
			break;
		default:
			setEnOperacionNSV(operacionTk.getNsv());
			setEnOperacionAgua(operacionTk.getAgua());
			break;
		}
		if (getEnOperacionNSV() == 0 && getEnOperacionAgua() == 0) {
			frmOperacionTk.btnGuardar.setEnabled(false);
		}
		// asignar fecha y hora de ultimo movimimiento
		if (frmOperacionTk.rdbtnFechaUltimo.isSelected()) {
			OperacionTk datosUltimoMov = this.obtenerFechayPozoUltimoMov();
			if (datosUltimoMov.getFecha() != null) {
				operacionTk.setFecha(datosUltimoMov.getFecha());
				operacionTk.setHora(datosUltimoMov.getHora());
			} else {
				operacionTk.setFecha(ctrlUtilities.getFechaActual());
				operacionTk.setHora(ctrlUtilities.getHoraActual());
			}
		} else {
			if (operacionTk.getTipo().equals("Inicial")) {
				Calendar autoFecha = ctrlUtilities.asignacionFechas(frmOperacionTk.dtchFecha.getDate(), (java.util.Date) frmOperacionTk.spnHora.getValue());
    			java.sql.Date sqlFecha = new java.sql.Date(autoFecha.getTime().getTime());
                operacionTk.setFecha(sqlFecha);
                Time autoHora=ctrlUtilities.getHoraActual();
                java.util.Date myHora= (java.util.Date) frmOperacionTk.spnHora.getValue();
                autoHora.setTime(myHora.getTime());
                operacionTk.setHora(autoHora);
			} else {
				operacionTk.setFecha(ctrlUtilities.getFechaActual());
				operacionTk.setHora(ctrlUtilities.getHoraActual());
			}
		}
	}

	public void mostrarVariables() {
		frmOperacionTk.lblTOV.setText(String.valueOf(calculos.formatearDecimales(operacionTk.getTov(), 2)));
		frmOperacionTk.lblGOV.setText(String.valueOf(calculos.formatearDecimales(operacionTk.getGov(), 2)));
		frmOperacionTk.lblGSV.setText(String.valueOf(calculos.formatearDecimales(operacionTk.getGsv(), 2)));
		frmOperacionTk.lblCTSh.setText(String.valueOf(operacionTk.getCtsh()));
		frmOperacionTk.lblCTL.setText(String.valueOf(operacionTk.getCtl()));
		frmOperacionTk.lblFW.setText(String.valueOf(calculos.formatearDecimales(operacionTk.getFw(), 2)));
		frmOperacionTk.lblCSW.setText(String.valueOf(operacionTk.getCsw()));
		frmOperacionTk.lblAgua.setText(String.valueOf(operacionTk.getAgua()));
		frmOperacionTk.lblNSV.setText(String.valueOf(operacionTk.getNsv()));
		frmOperacionTk.lblOperacionNSV.setText(String.valueOf(calculos.formatearDecimales(getEnOperacionNSV(), 2)));
		frmOperacionTk.lblOperacionAgua.setText(String.valueOf(calculos.formatearDecimales(getEnOperacionAgua(), 2)));
		// frmOperacionTk.spnFecha.setValue(operacionTk.getFecha());
		frmOperacionTk.dtchFecha.setDate(operacionTk.getFecha());
		frmOperacionTk.spnHora.setValue(operacionTk.getHora());

	}

	public void ejecutarCalculo() {
		double volumen = 0;
//        double incrementoSiguiente;
//        double decimal;
		String idPozo;

		// cargar datos al modelo si es necesario(cajas de texto etc...)
		operacionTk.setIdTanque(frmOperacionTk.cmbxIdTanque.getSelectedItem().toString());
		// ejecutar consultas en base de datos y asigna a la ventana
		try {

			if (operacionTkC.buscarUltimoXTk(operacionTk)) {
				// toma de datos
				operacionTk.setTipo(frmOperacionTk.cmbxTipo.getSelectedItem().toString());
				setUltimoNSV(operacionTk.getNsv());
				setUltimoAgua(operacionTk.getAgua());
				frmOperacionTk.tbUltimaOp.setModel(operacionTkC.listarMovimientosDelDia(operacionTk));
				idPozo = operacionTk.getIdPozo();
				if (!idPozo.equals(frmOperacionTk.cmbxIdPozo.getSelectedItem().toString())) {
//                    if ("Recibo".equals(operacionTk.getTipo())) {
//                        JOptionPane.showMessageDialog(null, "Advertencia Verificar el pozo  ¡no coincide con el ultimo movimiento¡¡¡");
//                    } else {
					JOptionPane.showMessageDialog(null, "Error  ¡no coincide el pozo con el ultimo movimiento¡¡¡");
					frmOperacionTk.btnGuardar.setEnabled(false);
//                    }
				}
			} else {
				JOptionPane.showMessageDialog(null,
						"Se registrara este movimiento como valor inicial, no se tendra en cuenta para el balance del dia");
				operacionTk.setTipo("Inicial");
				operacionTk.setNsv(0);
				operacionTk.setAgua(0);
				setUltimoAgua(0);
				setUltimoNSV(0);
			}
			operacionTk.setIdPozo(frmOperacionTk.cmbxIdPozo.getSelectedItem().toString());
			this.tomarDatos();
			if (ctrlUtilities.isTextFieldOk()) {
				// Calculos
				// TOV
				ctrlAforoTk.aforoTk.setIdTanque(operacionTk.getIdTanque());
//                para aforos en cm                
//                ctrlAforoTk.aforoTk.setNivel(calculos.getEntero(operacionTk.getNivel()));
//                volumen = ctrlAforoTk.aforoTkC.buscarVolumenAforo(ctrlAforoTk.aforoTk);
//                incrementoSiguiente = ctrlAforoTk.aforoTkC.buscarIncrementoAforo(ctrlAforoTk.aforoTk);
//                decimal = calculos.getDecimal(operacionTk.getNivel());
//                operacionTk.setTov(calculos.calcularTOV(decimal, volumen, incrementoSiguiente));
				ctrlAforoTk.aforoTk.setNivel((int) (operacionTk.getNivel() * 10));
				volumen = ctrlAforoTk.aforoTkC.buscarVolumenAforo(ctrlAforoTk.aforoTk);
				operacionTk.setTov(volumen);

				// FW
//                para aforos en cm   
//                ctrlAforoTk.aforoTk.setNivel(calculos.getEntero(operacionTk.getInterfase()));
//                volumen = ctrlAforoTk.aforoTkC.buscarVolumenAforo(ctrlAforoTk.aforoTk);
//                incrementoSiguiente = ctrlAforoTk.aforoTkC.buscarIncrementoAforo(ctrlAforoTk.aforoTk);
//                decimal = calculos.getDecimal(operacionTk.getInterfase());
//                operacionTk.setFw(calculos.calcularFW(decimal, volumen, incrementoSiguiente));
				ctrlAforoTk.aforoTk.setNivel((int) (operacionTk.getInterfase() * 10));
				volumen = ctrlAforoTk.aforoTkC.buscarVolumenAforo(ctrlAforoTk.aforoTk);
				operacionTk.setFw(volumen);
				if (operacionTk.getTov() >= operacionTk.getFw()) {
					if (ctrlAforoTk.aforoTkC.buscarAforoXnivel(ctrlAforoTk.aforoTk)) {
						this.calcularVariables();

						// asignacion de variables al form
						this.mostrarVariables();
					}

				} else {
					JOptionPane.showMessageDialog(null, "operacion inconsistente, revise los valores");
					frmOperacionTk.btnGuardar.setEnabled(false);
				}

			} else {
				JOptionPane.showMessageDialog(null, "Ingrese Valores Numéricos");
				frmOperacionTk.btnGuardar.setEnabled(false);
			}

		} catch (SQLException ex) {
			System.err.println("Error al guardar: " + ex);
		}

	}

	public void verificacionFecha(Calendar fechaActual, Calendar fechaAnterior, Time hora, boolean esInicial) {
		// verificacion de fechas
		Balance verificarUltimoBalance = new Balance();
		Calendar verificarFechaUltimoBalance = null;
		try {
			if (ctrlBalance.balanceC.buscarUltimo(verificarUltimoBalance)) {
				verificarFechaUltimoBalance = ctrlUtilities.asignacionFechas(verificarUltimoBalance.getFecha(),
						verificarUltimoBalance.getFecha());
			} else {
				verificarFechaUltimoBalance = fechaAnterior;
			}
			if (fechaAnterior.getTimeInMillis() < fechaActual.getTimeInMillis()) {
//            	if (fechaAnterior.getTimeInMillis() < fechaActual.getTimeInMillis()) {
				hora.setTime(fechaActual.getTimeInMillis());
				operacionTk.setHora(hora);
				java.sql.Date sqlFecha = new java.sql.Date(fechaActual.getTime().getTime());
				operacionTk.setFecha(sqlFecha);
				if (fechaAnterior.get(Calendar.DAY_OF_YEAR) == fechaActual.get(Calendar.DAY_OF_YEAR)) {
					if (!ctrlBalance.hayBalance(fechaActual, operacionTk.getIdPozo())) {
						if (operacionTkC.agregarDatos(operacionTk)) {
							if (esInicial) {
								JOptionPane.showMessageDialog(null, "Registro inicial almacenado");
							} else {
								JOptionPane.showMessageDialog(null, "Registro almacenado");
							}
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"el balance ya fue realizado, no puede agregar mas movimientos al dia");
					}
				} else {
					if (ctrlBalance.hayBalance(fechaAnterior, operacionTk.getIdPozo())) {
						if ("MENOR".equals(ctrlBalance.verificarDia(verificarFechaUltimoBalance, fechaActual))) {
							if (!ctrlBalance.hayBalance(fechaActual, operacionTk.getIdPozo())) {
								if (operacionTkC.agregarDatos(operacionTk)) {
									if (esInicial) {
										JOptionPane.showMessageDialog(null, "Registro inicial almacenado");
									} else {
										JOptionPane.showMessageDialog(null, "Registro almacenado");
									}
								}
							} else {
								JOptionPane.showMessageDialog(null, "no puede agregar mas movimientos al dia");
							}
						} else {
							JOptionPane.showMessageDialog(null,
									"No se puede agregar el movimiento, verifique las fecha del ultimo balance generado ");
						}
					} else {
						JOptionPane.showMessageDialog(null, "No se ha generado el balance del dia");
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "Verifique la fecha ingresada");
			}
		} catch (SQLException ex) {
			System.err.println("Error al guardar: " + ex);
		}
	}

	public final OperacionTk obtenerFechayPozoUltimoMov() {
		OperacionTk op = new OperacionTk();
		try {
			if (this.operacionTkC.buscarUltimoSinTk(op)) {

			}
		} catch (SQLException ex) {
			Logger.getLogger(CtrlBalance.class.getName()).log(Level.SEVERE, null, ex);
		}
		return op;
	}
}

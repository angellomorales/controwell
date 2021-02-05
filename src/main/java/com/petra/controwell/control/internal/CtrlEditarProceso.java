package com.petra.controwell.control.internal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.petra.controwell.control.threads.CtrlCargando;
import com.petra.controwell.model.data.AforoTk;
import com.petra.controwell.model.data.querys.ConsultasProceso;
import com.petra.controwell.model.data.querys.ConsultasVariador;
import com.petra.controwell.model.utilities.Utilities;
import com.petra.controwell.view.FrmCargando;
import com.petra.controwell.view.internal.FrmEditarProceso;

public class CtrlEditarProceso implements ActionListener {

	// vista
	public FrmEditarProceso frmEditarProceso;

	// modelo BD
	public ConsultasVariador variadorC;
	public ConsultasProceso procesoC;
	// modelo
	// controlador
	CtrlGraficas ctrlGraficas;
	Utilities utilities;
	CtrlCargando ctrlCargando;
	// variables
	public File archivo;
	public final int SELECTORPROCESO = 0;
	public final int SELECTORVARIADOR = 0;

	public CtrlEditarProceso(FrmEditarProceso frmEditarProceso, CtrlGraficas ctrlGraficas, Utilities utilities,
			ConsultasVariador variadorC, ConsultasProceso procesoC, FrmCargando frmCargando) {
		this.frmEditarProceso = frmEditarProceso;
		this.ctrlGraficas = ctrlGraficas;
		this.utilities = utilities;
		this.variadorC = variadorC;
		this.procesoC = procesoC;

		// instanciar librerias
		this.ctrlCargando = new CtrlCargando(frmCargando, this);

		// agregar listener a los botones dentro del constructor
		this.frmEditarProceso.btnCargar.addActionListener(this);
		this.frmEditarProceso.btnDescargar.addActionListener(this);

		// PopertychangeListener particular para fecha
		this.frmEditarProceso.dtchFecha.addPropertyChangeListener((PropertyChangeEvent e) -> {
			if ("date".equals(e.getPropertyName())) {
				Date fecha = null;
				fecha = new Date(this.frmEditarProceso.dtchFecha.getDate().getTime());
				try {
					this.cargarDatos(fecha);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		// itemListener particular para combobox
		this.frmEditarProceso.cmbxIdPozo.addItemListener((ItemEvent itemEvent) -> {
			int state = itemEvent.getStateChange();
			if (state == ItemEvent.SELECTED) {

				try {
					if (!(this.frmEditarProceso.dtchFecha.getDate() == null)) {
						Date fecha = null;
						fecha = new Date(this.frmEditarProceso.dtchFecha.getDate().getTime());
						this.cargarDatos(fecha);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		// changeListener particular para los tabpanne
		this.frmEditarProceso.tabDatos.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				try {
					if (!(frmEditarProceso.dtchFecha.getDate() == null)) {
						Date fecha = null;
						fecha = new Date(frmEditarProceso.dtchFecha.getDate().getTime());
						cargarDatos(fecha);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	public void iniciar() throws PropertyVetoException {

		frmEditarProceso.setTitle("Edición de Variables");
		frmEditarProceso.setVisible(true);
		frmEditarProceso.toFront();
		frmEditarProceso.setSelected(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

//		--------------boton descargar------------------
		if (e.getSource() == frmEditarProceso.btnDescargar) {
			ArrayList arrayDatos = new ArrayList();
			if (!(frmEditarProceso.dtchFecha.getDate() == null)) {
				Date fecha = null;
				fecha = new Date(frmEditarProceso.dtchFecha.getDate().getTime());
				if (frmEditarProceso.tabDatos.getSelectedIndex() == 0) {
					try {
						arrayDatos = cargarInformacionProceso(fecha);
						ctrlGraficas.writeExcel(arrayDatos, 0, "dataProcesoExport " + fecha);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				if (frmEditarProceso.tabDatos.getSelectedIndex() == 1) {
					try {
						arrayDatos = cargarInformacionVariador(fecha);
						ctrlGraficas.writeExcel(arrayDatos, 0, "dataVariadorExport " + fecha);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "diligencie la fecha");
			}
		}

//		-----------------------boton Cargar-------------------------
		if (e.getSource() == frmEditarProceso.btnCargar) {
			JFileChooser fileChooser = new JFileChooser();
			FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos Excel", "xlsx");
			this.setArchivo(utilities.seleccionarArchivoEntrada(fileChooser, filtro));
			try {
				if (frmEditarProceso.tabDatos.getSelectedIndex() == 0) {
					this.realizarConsulta(this.evualuarXLSX(this.getArchivo()), this.SELECTORPROCESO);
				} else {
					this.realizarConsulta(this.evualuarXLSX(this.getArchivo()), this.SELECTORVARIADOR);
				}
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
		}

	}

	public void cargarDatos(Date fechaInicial) throws SQLException {
		frmEditarProceso.btnDescargar.setEnabled(true);
		cargarInformacionProceso(fechaInicial);
		cargarInformacionVariador(fechaInicial);
	}

	public ArrayList cargarInformacionProceso(Date fechaInicial) throws SQLException {
		ArrayList arrayDatos = new ArrayList();
		ArrayList<String> arrayTitulos = new ArrayList<String>();
		String idPozo = frmEditarProceso.cmbxIdPozo.getSelectedItem().toString();
		arrayDatos = ctrlGraficas.graficaC.buscarTodosProcesoXFecha(idPozo, fechaInicial, fechaInicial,
				ctrlGraficas.graficaC.getXDIA(), false);
		if (!arrayDatos.isEmpty()) {
			arrayTitulos = utilities.evaluarArrayInterno(arrayDatos, arrayDatos.size() - 1);
			DefaultTableModel modelo = tabular(arrayTitulos, arrayDatos);
			frmEditarProceso.tbProceso.setModel(modelo);
		} else {
			DefaultTableModel modelo0 = (DefaultTableModel) frmEditarProceso.tbProceso.getModel();
			modelo0.setRowCount(0);
			frmEditarProceso.tbProceso.setModel(modelo0);
			if (frmEditarProceso.tabDatos.getSelectedIndex() == 0) {
				frmEditarProceso.btnDescargar.setEnabled(false);
			}
		}
		return arrayDatos;
	}

	public ArrayList cargarInformacionVariador(Date fechaInicial) throws SQLException {
		ArrayList arrayDatos = new ArrayList();
		ArrayList<String> arrayTitulos = new ArrayList<String>();
		String idPozo = frmEditarProceso.cmbxIdPozo.getSelectedItem().toString();
		arrayDatos = variadorC.buscarTodosXFecha(idPozo, fechaInicial);
		if (!arrayDatos.isEmpty()) {
			arrayTitulos = utilities.evaluarArrayInterno(arrayDatos, arrayDatos.size() - 1);
			DefaultTableModel modelo = tabular(arrayTitulos, arrayDatos);
			frmEditarProceso.tbVariador.setModel(modelo);
		} else {
			DefaultTableModel modelo0 = (DefaultTableModel) frmEditarProceso.tbVariador.getModel();
			modelo0.setRowCount(0);
			frmEditarProceso.tbVariador.setModel(modelo0);
			if (frmEditarProceso.tabDatos.getSelectedIndex() == 1) {
				frmEditarProceso.btnDescargar.setEnabled(false);
			}
		}
		return arrayDatos;
	}

	public DefaultTableModel tabular(ArrayList arrayTitulos, ArrayList arrayDatos) {
		DefaultTableModel modeloTabla = new DefaultTableModel();
		modeloTabla.setColumnIdentifiers(cabeceraTabla(arrayTitulos));
		for (int row = 0; row < utilities.evaluarArrayInterno(arrayDatos, 2).size(); row++) {
			modeloTabla.addRow(contenidoTabla(arrayDatos, row));
		}
		return modeloTabla;
	}

	public Object[] cabeceraTabla(ArrayList<String> arrayTitulos) {
		Object[] tabla = new Object[arrayTitulos.size()];

		for (int i = 0; i < arrayTitulos.size(); i++) {
			tabla[i] = arrayTitulos.get(i);
		}
		return tabla;

	}

	public Object[] contenidoTabla(ArrayList<ArrayList> arrayDatos, int row) {
		Object[] tabla = new Object[arrayDatos.size()];
		for (int i = 0; i < arrayDatos.size() - 1; i++) {
			tabla[i] = utilities.evaluarArrayInterno(arrayDatos, i).get(row);
		}
		return tabla;

	}

	public ArrayList evualuarXLSX(File archivo) {

		int contadorFilas = 0;
		int contadorCeldas = 0;
		ArrayList<ArrayList> arrayDatos = new ArrayList<>();
		ArrayList arrayFila = new ArrayList();
		ArrayList<String> arrayEncabezados = new ArrayList<String>();
		try (XSSFWorkbook libro = new XSSFWorkbook(archivo)) {
			XSSFSheet hoja = libro.getSheetAt(0);
			Iterator<Row> filas = hoja.iterator();
			Iterator<Cell> celdas;
			Row fila;
			Cell celda;
			// recorre en cada fila todas las columnas
			while (filas.hasNext()) {
				fila = filas.next();
				celdas = fila.cellIterator();
				if (contadorFilas == 1) {
					contadorFilas++;
					continue;
				}
				while (celdas.hasNext()) {
					celda = celdas.next();
					if (contadorFilas == 0) {
						arrayEncabezados.add(celda.getStringCellValue());
					} else {
						switch (contadorCeldas) {
						case 0: {
							if (celda.getDateCellValue() != null)
								arrayFila.add(celda.getDateCellValue());
							contadorCeldas++;
							break;
						}
						case 1: {
							if (celda.getDateCellValue() != null)
								arrayFila.add(celda.getDateCellValue());
							contadorCeldas++;
							break;
						}
						case 2: {
							if (!celda.getStringCellValue().isEmpty())
								arrayFila.add(celda.getStringCellValue());
							contadorCeldas++;
							break;
						}
						case 3: {
								if (celda.getCellType() == CellType.NUMERIC) {
									arrayFila.add(celda.getNumericCellValue());
							}
							break;
						}
						}
					}
				}
				if (!arrayFila.isEmpty()) {
					arrayDatos.add(new ArrayList(arrayFila));
					arrayFila.clear();
					contadorCeldas = 0;
				}
				contadorFilas++;
			}
			arrayDatos.add(new ArrayList(arrayEncabezados));
			// cerramos el libro
			libro.close();
		} catch (Exception e) {
			System.err.println("Error archivo excel: " + e);
		}
		System.out.println(arrayDatos);
		return arrayDatos;
	}

	public void realizarConsulta(ArrayList arrayDatos, int selectorProcesoVariador) throws SQLException {
		ArrayList arrayInterno = new ArrayList();
		ArrayList arrayTitulos = new ArrayList();
		if (!arrayDatos.isEmpty()) {
			arrayTitulos = utilities.evaluarArrayInterno(arrayDatos, arrayDatos.size() - 1);
			for (int i = 0; i < arrayDatos.size() - 1; i++) {
				arrayInterno = utilities.evaluarArrayInterno(arrayDatos, i);
				if (arrayTitulos.size() == 17) {
					if (this.procesoC.modificarXArray(arrayInterno, arrayTitulos)) {

					} else {
						JOptionPane.showMessageDialog(null, "error al cargar los registros");
					}
				} else {
					if (this.variadorC.modificarXArray(arrayInterno, arrayTitulos)) {

					} else {
						JOptionPane.showMessageDialog(null, "error al cargar los registros");
					}
				}
			}
			JOptionPane.showMessageDialog(null, "proceso finalizado");
		}
	}

	public File getArchivo() {
		return archivo;
	}

	public void setArchivo(File archivo) {
		this.archivo = archivo;
	}

}

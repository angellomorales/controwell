package com.petra.controwell.control.internal;

import com.petra.controwell.control.threads.CtrlCargando;
import com.petra.controwell.model.data.AforoTk;
import com.petra.controwell.model.data.querys.ConsultasAforoTk;
import com.petra.controwell.model.utilities.Utilities;
import com.petra.controwell.view.FrmCargando;
import com.petra.controwell.view.internal.FrmAforoTk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Angello Morales
 */
public class CtrlAforoTk implements ActionListener {

	// vista
	public FrmAforoTk frmAforoTk;
	// modelo BD
	public AforoTk aforoTk;
	public ConsultasAforoTk aforoTkC;

	// modelo
	// controlador
	public CtrlCargando ctrlCargando;
	public Utilities ctrlUtilities;
	// variables
	private final JFileChooser fileChooser;
	private final FileNameExtensionFilter filtro;
	public File archivo;

	public CtrlAforoTk(FrmAforoTk frmAforoTk, AforoTk aforoTk, ConsultasAforoTk aforoTkC, FrmCargando frmCargando,
			Utilities ctrlUtilities) {
		this.frmAforoTk = frmAforoTk;
		this.aforoTk = aforoTk;
		this.aforoTkC = aforoTkC;
		this.ctrlUtilities = ctrlUtilities;

		// agregar listener a los botones dentro del constructor
		this.frmAforoTk.btnCargar.addActionListener(this);
		this.frmAforoTk.btnCerrar.addActionListener(this);

		// instanciar librerias
		this.fileChooser = new JFileChooser();
		this.filtro = new FileNameExtensionFilter("Archivos Excel", "xlsx");
		this.ctrlCargando = new CtrlCargando(frmCargando, this);

		// itemListener particular para combobox
		this.frmAforoTk.cmbxIdTanque.addItemListener((ItemEvent itemEvent) -> {
			int state = itemEvent.getStateChange();
			if (state == ItemEvent.SELECTED) {
				if (!(this.frmAforoTk.cmbxIdTanque.getSelectedItem().toString().isEmpty())) {
					this.actualizarTabla(this.frmAforoTk.cmbxIdTanque.getSelectedItem().toString());
				}
			}
		});

	}

	public void iniciar() throws PropertyVetoException {

		frmAforoTk.setTitle("Edición de Aforos");
		frmAforoTk.setVisible(true);
		frmAforoTk.toFront();
		frmAforoTk.setSelected(true);

	}

	public File getArchivo() {
		return archivo;
	}

	public void setArchivo(File archivo) {
		this.archivo = archivo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// acciones a ejecutar cuando se presiona un elemento en la pantalla
		// if por cada elemento para detectar cual se presiono
		// --------------Agregar--------------
		if (e.getSource() == frmAforoTk.btnCargar) {
			ctrlUtilities.setTextFieldOk(true);
			this.setArchivo(ctrlUtilities.seleccionarArchivoEntrada(fileChooser, filtro));
			aforoTk.setIdTanque(frmAforoTk.cmbxIdTanque.getSelectedItem().toString());
			aforoTk.setMaterial(frmAforoTk.cmbxMaterial.getSelectedItem().toString());
			aforoTk.setTemperaturaBase(
					Double.parseDouble(ctrlUtilities.VerificarTextField(frmAforoTk.txtTemperaturaBase)));
			if (ctrlUtilities.isTextFieldOk()) {
				ctrlCargando.show();
			} else {
				JOptionPane.showMessageDialog(null, "Ingrese Valores Numericos");
			}

		}
		// --------------cerrar--------------
		if (e.getSource() == frmAforoTk.btnCerrar) {
			this.frmAforoTk.hide();
		}

	}

	public void evualuarXLSX(File archivo) {
		int contador = 0;
		try (XSSFWorkbook libro = new XSSFWorkbook(archivo)) {
			XSSFSheet hoja = libro.getSheetAt(0);
			Iterator<Row> filas = hoja.iterator();
			Iterator<Cell> celdas;
			ArrayList<AforoTk> medidasAforo = new ArrayList<AforoTk>();
			aforoTk.setIncremento(0);

			Row fila;
			Cell celda;
			// recorre en cada fila todas las columnas
			while (filas.hasNext()) {
				fila = filas.next();
				celdas = fila.cellIterator();
				while (celdas.hasNext()) {
					celda = celdas.next();
					if (celda.getCellType() == CellType.NUMERIC) {
						switch (contador) {
						case 0:
							aforoTk.setNivel((int) celda.getNumericCellValue());
							contador++;
							break;
						case 1:
							aforoTk.setVolumen(celda.getNumericCellValue());
//                                para archivos con aforos en cm
//                                contador++;
//                                break;
//                            case 2:
//                                aforoTk.setIncremento(celda.getNumericCellValue());
//                                ejecuta la consulta cuando tiene todos los valores
//                                try {
//                                    aforoTkC.almacenarAforoTanque(aforoTk);..
//                                } catch (SQLException ex) {
//                                    System.err.println("Error al agregar aforo: " + ex);
//                                }
							medidasAforo.add(new AforoTk(aforoTk.getIdTanque(), aforoTk.getNivel(),
									aforoTk.getVolumen(), aforoTk.getIncremento(), aforoTk.getTemperaturaBase(),
									aforoTk.getMaterial()));
							contador = 0;
							break;
						}
					}
				}
			}
			try {
				aforoTkC.almacenarAforoTanqueXArray(medidasAforo);
				medidasAforo.clear();
			} catch (SQLException ex) {
				System.err.println("Error al agregar aforo: " + ex);
			}
			// cerramos el libro
			libro.close();
			JOptionPane.showMessageDialog(null, "Registro Actualizado");
			if (!(this.frmAforoTk.cmbxIdTanque.getSelectedItem().toString().isEmpty())) {
				this.actualizarTabla(this.frmAforoTk.cmbxIdTanque.getSelectedItem().toString());
			}
		} catch (Exception e) {
			System.err.println("Error archivo excel: " + e);
		}

	}

	public void eliminarDatos() {
		try {
			aforoTkC.eliminarAforoTanque(aforoTk);
		} catch (SQLException ex) {
			System.err.println("Error al eliminar: " + ex);
		}
	}

	public void actualizarTabla(String tanque) {
		ArrayList<AforoTk> listadoAfk;
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new Object[] { "Nivel (mm)", "Volumen (Bbls)" });
		try {
			listadoAfk = this.aforoTkC.listarMedidas(tanque);

			for (int i = 0; i < listadoAfk.size(); i++) {
				// toma de datos
				modelo.addRow(new Object[] { listadoAfk.get(i).getNivel(), listadoAfk.get(i).getVolumen() });
			}
			frmAforoTk.cmbxMaterial.setSelectedItem(listadoAfk.get(0).getMaterial());
			frmAforoTk.txtTemperaturaBase.setText(String.valueOf(listadoAfk.get(0).getTemperaturaBase()));
			this.frmAforoTk.tbAforo.setModel(modelo);
		} catch (SQLException ex) {
			Logger.getLogger(CtrlBalance.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/*
	 * public class _cargar implements Runnable {
	 * 
	 * public void show() { new Thread(this).start(); }
	 * 
	 * @Override public void run() { ctrlCargando.iniciar(); eliminarDatos();
	 * evualuarXLSX(archivo); ctrlCargando.detener(); } }
	 */
}

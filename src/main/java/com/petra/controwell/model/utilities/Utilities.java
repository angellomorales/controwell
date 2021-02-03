package com.petra.controwell.model.utilities;

import java.awt.Color;
import java.io.File;
import java.lang.reflect.Array;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;

/**
 *
 * @author Angello Morales
 */
public class Utilities {

	// Variables
	public final boolean ALTA = true;
	public final boolean BAJA = false;
	public final boolean ACTIVO = true;
	public final boolean INACTIVO = false;

	private boolean textFieldOk;
	private final Date fecha;
	private final Time hora;

	public Utilities() {
		this.textFieldOk = false;
		this.fecha = new Date(System.currentTimeMillis());
		this.hora = new Time(System.currentTimeMillis());
	}

	public boolean isTextFieldOk() {
		return textFieldOk;
	}

	public void setTextFieldOk(boolean textFieldOk) {
		this.textFieldOk = textFieldOk;
	}

	public String VerificarTextField(JTextField textbox) {

		String texto = null;
		texto = textbox.getText();
		if (texto.contains(",") && texto.contains(".")) {
			texto = texto.replaceAll("\\.", "");
			texto = texto.replace(',', '.');
		}
		if (texto.contains(",")) {
			texto = texto.replace(',', '.');
		}
		if (texto.contains(" ")) {
			texto = texto.replaceAll(" ", "");
		}
		if (!isNumeric(texto)) {
			switch (texto) {
			case "N/A":
				break;
			case "N/a":
				break;
			case "n/A":
				break;
			case "n/a":
				break;
			default:
				this.setTextFieldOk(false);
			}
			texto = "0";
		}
		return texto;
	}

	public static boolean isNumeric(String texto) {

		boolean resultado;

		try {
			Double.parseDouble(texto);
			resultado = true;
		} catch (NumberFormatException ex) {
			resultado = false;
		}

		return resultado;
	}

	public Date getFechaActual() {
		this.fecha.setTime(System.currentTimeMillis());
		return fecha;
	}

	public Time getHoraActual() {
		hora.setTime(System.currentTimeMillis());
		return hora;
	}

	public JLabel activarAlarma(JLabel texto, boolean estado, boolean alta) {
		if (estado) {
			if (alta) {
				if (texto.getForeground() == Color.BLACK) {
					texto.setForeground(Color.RED);
				} else {
					texto.setForeground(Color.BLACK);
				}
			} else {
				if (texto.getForeground() == Color.BLACK) {
					texto.setForeground(Color.BLUE);
				} else {
					texto.setForeground(Color.BLACK);
				}
			}

		} else {
			texto.setForeground(Color.BLACK);
		}
		return texto;
	}

	public static void pause(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			System.err.format("IOException: %s%n", e);
		}
	}

	public Calendar asignacionFechas(java.util.Date fecha, java.util.Date hora) {
		Calendar fechaA = Calendar.getInstance();
		Calendar fechaInicial = Calendar.getInstance();
		Calendar horaA = Calendar.getInstance();
		fechaA.setTime(fecha);
		horaA.setTime(hora);
		if (!(fechaInicial.getTime() == fechaA.getTime())) {
			if ((fechaA.get(Calendar.HOUR_OF_DAY) == 0 && fechaA.get(Calendar.MINUTE) == 0
					&& fechaA.get(Calendar.SECOND) == 0)) {
				fechaA.add(Calendar.HOUR_OF_DAY, horaA.get(Calendar.HOUR_OF_DAY));
				fechaA.add(Calendar.MINUTE, horaA.get(Calendar.MINUTE));
				fechaA.add(Calendar.SECOND, horaA.get(Calendar.SECOND));
				fechaA.add(Calendar.MILLISECOND, horaA.get(Calendar.MILLISECOND));
				// System.out.println(fechaA.get(Calendar.YEAR) + " " +
				// fechaA.get(Calendar.MONTH) + " " + fechaA.get(Calendar.DAY_OF_MONTH) + " " +
				// fechaA.get(Calendar.HOUR_OF_DAY) + " " + fechaA.get(Calendar.MINUTE) + " " +
				// fechaA.get(Calendar.SECOND));
			}
		}
		return fechaA;
	}

	public String VerificarTextFieldNull(JTextField textbox) {
		String texto = null;
		if (!textbox.getText().isEmpty()) {
			texto = textbox.getText();
		}
		return texto;
	}

	public String seleccionarArchivoSalida(String descripcionTipo, String extension, String nombreSalida) {
		JFileChooser selectedFile = new JFileChooser();
		File archivo = null;
		FileNameExtensionFilter filtro = new FileNameExtensionFilter(descripcionTipo, extension);
		String ruta = null;
		String laExtension = null;
		selectedFile.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		selectedFile.setFileFilter(filtro);
		selectedFile.setSelectedFile(new File(nombreSalida));
		int resul = selectedFile.showSaveDialog(null);
		if (resul == 0) {
			archivo = selectedFile.getSelectedFile();
			ruta = archivo.getAbsolutePath();
			laExtension = (String) Array.get(filtro.getExtensions(), 0);
			ruta = ruta + "." + laExtension;

		}
		return ruta;
	}

	public File seleccionarArchivoEntrada(JFileChooser fileChooser, FileNameExtensionFilter filtro) {
		String ruta = null;
		File archivo = null;
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setFileFilter(filtro);
		int resul = fileChooser.showOpenDialog(new JFileChooser());
		if (resul == 0) {
			archivo = fileChooser.getSelectedFile();
			if ((archivo == null) || (archivo.getName().equals("")) || !archivo.exists()) {
				JOptionPane.showMessageDialog(null, "Nombre de archivo inválido", "Nombre de archivo inválido",
						JOptionPane.ERROR_MESSAGE);
			} else {
				ruta = archivo.getAbsolutePath();
				System.out.println(ruta);
			}
		}
		return archivo;
	}

	public ArrayList evaluarArrayInterno(ArrayList ar, int pos) {
		ArrayList res = new ArrayList((Collection) ar.get(pos));
		return res;

	}

	public int evaluarArrayIntOClaveo(ArrayList ar, int pos) {
		int res;
		res = (int) ar.get(pos);
		return res;

	}

	public String evaluarArrayString(ArrayList ar, int pos) {
		String res = ar.get(pos).toString();
		return res;

	}

	public long contarDias(Date fechaInicial, Date fechaFinal) {

		LocalDate myDate = fechaInicial.toLocalDate();
		LocalDate currentDate = fechaFinal.toLocalDate();
		long numberOFDays = java.time.temporal.ChronoUnit.DAYS.between(myDate, currentDate);
		return numberOFDays;
	}

}

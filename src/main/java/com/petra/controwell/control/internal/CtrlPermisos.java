package com.petra.controwell.control.internal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.sql.Date;
import java.sql.SQLException;

import com.petra.controwell.model.data.Permisos;
import com.petra.controwell.model.data.querys.ConsultasPermisos;
import com.petra.controwell.model.utilities.Utilities;

public class CtrlPermisos {
	// vista

	// modelo BD
	public Permisos permisos;
	public ConsultasPermisos permisosC;
	public Utilities utilities;

	// modelo
	// controlador
	// variables

	public CtrlPermisos(Permisos permisos, ConsultasPermisos permisosC, Utilities utilities) {
		this.permisos = permisos;
		this.permisosC = permisosC;
		this.utilities=utilities;
	}

	public boolean concederAcceso() throws SQLException {
		boolean status = false;
		String filePass = null;
		String idBoard = null;
		String pass = null;
		String fechaActivacionStr = null;
		Date fechaActivacion = null;
		Date fechaActual=utilities.getFechaActual();
		int diasActivacion = 0;
		long numDiasVigentes=0;
		permisos.setIdBoard(this.getMotherboardSN());
//		*ControWell#2020-V1-1_YD05MR3U_2021-01-28_180* estructura de licensia inicia y termina en * y separado por_
//		ControWell#2020-V1-1 ControWell#2020+version+contador
//		YD05MR3U serial de la board del pc
//		2021/01/28 fecha de activacion yyyy/mm/dd
//		180 dias de licencia
//		se instala en la ruta "C:\Program Files\Controwell\License\license.flt" con la extension .flt
		if (this.permisosC.buscarPermisos(permisos)) {
			filePass = this.leerArchivo();
			pass = filePass.substring(filePass.indexOf("*") + 1, filePass.indexOf("_", filePass.indexOf("*")));
			idBoard = filePass.substring(filePass.indexOf("_", filePass.indexOf(pass)) + 1,
					filePass.indexOf("_", filePass.indexOf("_", filePass.indexOf(pass)) + 1));
			fechaActivacionStr = filePass.substring(filePass.indexOf("_", filePass.indexOf(idBoard)) + 1,
					filePass.indexOf("_", filePass.indexOf("_", filePass.indexOf(idBoard)) + 1));
			fechaActivacion = Date.valueOf(fechaActivacionStr);
			diasActivacion = Integer
					.valueOf(filePass.substring(filePass.indexOf("_", filePass.indexOf(fechaActivacionStr)) + 1,
							filePass.indexOf("*", filePass.indexOf("_", filePass.indexOf(fechaActivacionStr)) + 1)));
			if (permisos.getFilePassword().equals(pass) && permisos.getIdBoard().equals(idBoard)
					&& permisos.getFechaActivacion().equals(fechaActivacion)
					&& permisos.getVigenciaDias() == diasActivacion) {
				//tipos Permanente: siempre activa
				//Prueba: 30 dias vigencia
				//Vencimiento: compara los dias de activacion
				if (permisos.getTipo().equals("Vencimiento")) {
					numDiasVigentes=utilities.contarDias(fechaActivacion, fechaActual);
					if (numDiasVigentes<=permisos.getVigenciaDias()) {
						status = true;
					}
				}else if(permisos.getTipo().equals("Prueba")) {
					numDiasVigentes=utilities.contarDias(fechaActivacion, fechaActual);
					if (numDiasVigentes<=15) {
						status = true;
					}
				}else {
					status = true;
				}

			}

		}

		return status;
	}

	public String getMotherboardSN() {
		String result = "";
		try {
			File file = File.createTempFile("realhowto", ".vbs");
			file.deleteOnExit();
			FileWriter fw = new java.io.FileWriter(file);

			String vbs = "Set objWMIService = GetObject(\"winmgmts:\\\\.\\root\\cimv2\")\n"
					+ "Set colItems = objWMIService.ExecQuery _ \n" + "   (\"Select * from Win32_BaseBoard\") \n"
					+ "For Each objItem in colItems \n" + "    Wscript.Echo objItem.SerialNumber \n"
					+ "    exit for  ' do the first cpu only! \n" + "Next \n";

			fw.write(vbs);
			fw.close();
			Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while ((line = input.readLine()) != null) {
				result += line;
			}
			input.close();
		} catch (Exception e) {
			System.err.println("ERROR " + e);
		}
		return result.trim();
	}

	private String leerArchivo() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		String filePass = null;

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File("C:\\Program Files\\Controwell\\License\\license.flt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			while ((linea = br.readLine()) != null)
//				System.out.println(linea)
				filePass = linea;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
		return filePass;
	}

}

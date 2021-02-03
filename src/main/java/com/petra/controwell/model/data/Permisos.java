
package com.petra.controwell.model.data;

import java.sql.Date;

/**
 *
 * @author Angello Morales
 */
public class Permisos {

	private int consecutivo;
	private Date fechaActivacion;
	private String idBoard;
	private String filePassword;
	private String tipo;
	private int vigenciaDias;
	
	public int getConsecutivo() {
		return consecutivo;
	}
	public void setConsecutivo(int consecutivo) {
		this.consecutivo = consecutivo;
	}
	public Date getFechaActivacion() {
		return fechaActivacion;
	}
	public void setFechaActivacion(Date fechaActivacion) {
		this.fechaActivacion = fechaActivacion;
	}
	public String getIdBoard() {
		return idBoard;
	}
	public void setIdBoard(String iDboard) {
		idBoard = iDboard;
	}
	public String getFilePassword() {
		return filePassword;
	}
	public void setFilePassword(String filePassword) {
		this.filePassword = filePassword;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getVigenciaDias() {
		return vigenciaDias;
	}
	public void setVigenciaDias(int vigenciaDias) {
		this.vigenciaDias = vigenciaDias;
	}
	

}

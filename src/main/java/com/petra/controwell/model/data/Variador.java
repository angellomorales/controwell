package com.petra.controwell.model.data;

import java.sql.Date;
import java.sql.Time;

public class Variador {
	
	private int consecutivo;
    private Date fecha;
    private Time hora;
    private String idPozo;
    private double frecuencia;
    private double pip;
    private double pdp;
    private double tIntake;
    private double tMotor;
    private double volt;
    private double amp;
    
	public int getConsecutivo() {
		return consecutivo;
	}
	public void setConsecutivo(int consecutivo) {
		this.consecutivo = consecutivo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Time getHora() {
		return hora;
	}
	public void setHora(Time hora) {
		this.hora = hora;
	}
	public String getIdPozo() {
		return idPozo;
	}
	public void setIdPozo(String idPozo) {
		this.idPozo = idPozo;
	}
	public double getFrecuencia() {
		return frecuencia;
	}
	public void setFrecuencia(double frecuencia) {
		this.frecuencia = frecuencia;
	}
	public double getPip() {
		return pip;
	}
	public void setPip(double pip) {
		this.pip = pip;
	}
	public double getPdp() {
		return pdp;
	}
	public void setPdp(double pdp) {
		this.pdp = pdp;
	}
	public double gettIntake() {
		return tIntake;
	}
	public void settIntake(double tIntake) {
		this.tIntake = tIntake;
	}
	public double gettMotor() {
		return tMotor;
	}
	public void settMotor(double tMotor) {
		this.tMotor = tMotor;
	}
	public double getVolt() {
		return volt;
	}
	public void setVolt(double volt) {
		this.volt = volt;
	}
	public double getAmp() {
		return amp;
	}
	public void setAmp(double amp) {
		this.amp = amp;
	}
    
    

}


package com.petra.controwell.model.data;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Angello Morales
 */
public class Proceso {
    //puedo buscar por fecha+hora & por pozo o por consecutivo & pozo(traer el ultimo) o
        //por pozo, siempre va a ser select*
    private int consecutivo;
    private Date fecha;
    private Time hora;
    private String idPozo;
    private double presionCabeza;
    private double temperaturaCabeza;
    private double presionCasing;
    private double presionChoke;
    private double flujoDiluyente;
    private double presionMezclador;
    private double flujoAceiteSep;
    private double flujoAguaSep;
    private double presionSep;
    private double temperaturaSep;
    private double presionGasSep;
    private double temperaturaGasSep;
    private double flujoGas;
    private double presionLinea;

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

    public double getPresionCabeza() {
        return presionCabeza;
    }

    public void setPresionCabeza(double presionCabeza) {
        this.presionCabeza = presionCabeza;
    }

    public double getTemperaturaCabeza() {
        return temperaturaCabeza;
    }

    public void setTemperaturaCabeza(double temperaturaCabeza) {
        this.temperaturaCabeza = temperaturaCabeza;
    }

    public double getPresionCasing() {
        return presionCasing;
    }

    public void setPresionCasing(double presionCasing) {
        this.presionCasing = presionCasing;
    }

    public double getPresionChoke() {
        return presionChoke;
    }

    public void setPresionChoke(double presionChoke) {
        this.presionChoke = presionChoke;
    }

    public double getFlujoDiluyente() {
        return flujoDiluyente;
    }

    public void setFlujoDiluyente(double flujoDiluyente) {
        this.flujoDiluyente = flujoDiluyente;
    }

    public double getPresionMezclador() {
        return presionMezclador;
    }

    public void setPresionMezclador(double presionMezclador) {
        this.presionMezclador = presionMezclador;
    }

    public double getFlujoAceiteSep() {
        return flujoAceiteSep;
    }

    public void setFlujoAceiteSep(double flujoAceiteSep) {
        this.flujoAceiteSep = flujoAceiteSep;
    }

    public double getFlujoAguaSep() {
        return flujoAguaSep;
    }

    public void setFlujoAguaSep(double flujoAguaSep) {
        this.flujoAguaSep = flujoAguaSep;
    }

    public double getPresionSep() {
        return presionSep;
    }

    public void setPresionSep(double presionSep) {
        this.presionSep = presionSep;
    }

    public double getTemperaturaSep() {
        return temperaturaSep;
    }

    public void setTemperaturaSep(double temperaturaSep) {
        this.temperaturaSep = temperaturaSep;
    }

    public double getPresionGasSep() {
        return presionGasSep;
    }

    public void setPresionGasSep(double presionGasSep) {
        this.presionGasSep = presionGasSep;
    }

    public double getTemperaturaGasSep() {
        return temperaturaGasSep;
    }

    public void setTemperaturaGasSep(double temperaturaGasSep) {
        this.temperaturaGasSep = temperaturaGasSep;
    }

    public double getFlujoGas() {
        return flujoGas;
    }

    public void setFlujoGas(double flujoGas) {
        this.flujoGas = flujoGas;
    }

    public double getPresionLinea() {
        return presionLinea;
    }

    public void setPresionLinea(double presionLinea) {
        this.presionLinea = presionLinea;
    }

    
}

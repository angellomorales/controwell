
package com.petra.controwell.model.data;

/**
 *
 * @author Angello Morales
 */
public class AforoTk {
    
    private int consecutivo;
    private String idTanque;
    private int nivel;
    private double volumen;
    private double incremento;
    private double temperaturaBase;
    private String material;

    public AforoTk(String idTanque, int nivel, double volumen, double incremento, double temperaturaBase, String material) {
        this.idTanque = idTanque;
        this.nivel = nivel;
        this.volumen = volumen;
        this.incremento = incremento;
        this.temperaturaBase = temperaturaBase;
        this.material = material;
    }

    public AforoTk() {
    }

    public int getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }

    public String getIdTanque() {
        return idTanque;
    }

    public void setIdTanque(String idTanque) {
        this.idTanque = idTanque;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public double getIncremento() {
        return incremento;
    }

    public void setIncremento(double incremento) {
        this.incremento = incremento;
    }

    public double getTemperaturaBase() {
        return temperaturaBase;
    }

    public void setTemperaturaBase(double temperaturaBase) {
        this.temperaturaBase = temperaturaBase;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
    
       
}

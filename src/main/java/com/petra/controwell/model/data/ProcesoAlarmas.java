package com.petra.controwell.model.data;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Angello Morales
 */
public class ProcesoAlarmas {

    private int consecutivo;
    private String idPozo;
    private double presionCabezaMin;
    private double presionCabezaMax;
    private boolean presionCabezaEnable;
    private double temperaturaCabezaMin;
    private double temperaturaCabezaMax;
    private boolean temperaturaCabezaEnable;
    private double presionCasingMin;
    private double presionCasingMax;
    private boolean presionCasingEnable;
    private double presionChokeMin;
    private double presionChokeMax;
    private boolean presionChokeEnable;
    private double flujoDiluyenteMin;
    private double flujoDiluyenteMax;
    private boolean flujoDiluyenteEnable;
    private double presionMezcladorMin;
    private double presionMezcladorMax;
    private boolean presionMezcladorEnable;
    private double flujoAceiteSepMin;
    private double flujoAceiteSepMax;
    private boolean flujoAceiteSepEnable;
    private double flujoAguaSepMin;
    private double flujoAguaSepMax;
    private boolean flujoAguaSepEnable;
    private double presionSepMin;
    private double presionSepMax;
    private boolean presionSepEnable;
    private double temperaturaSepMin;
    private double temperaturaSepMax;
    private boolean temperaturaSepEnable;
    private double presionGasSepMin;
    private double presionGasSepMax;
    private boolean presionGasSepEnable;
    private double temperaturaGasSepMin;
    private double temperaturaGasSepMax;
    private boolean temperaturaGasSepEnable;
    private double flujoGasMin;
    private double flujoGasMax;
    private boolean flujoGasEnable;
    private double presionLineaMin;
    private double presionLineaMax;
    private boolean presionLineaEnable;
    private Date fecha;
    private Time hora;
    private boolean presionCabezaActive;
    private boolean temperaturaCabezaActive;
    private boolean presionCasingActive;
    private boolean presionChokeActive;
    private boolean flujoDiluyenteActive;
    private boolean presionMezcladorActive;
    private boolean flujoAceiteSepActive;
    private boolean flujoAguaSepActive;
    private boolean presionSepActive;
    private boolean temperaturaSepActive;
    private boolean presionGasSepActive;
    private boolean temperaturaGasSepActive;
    private boolean flujoGasActive;
    private boolean presionLineaActive;

    public int getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }

    public String getIdPozo() {
        return idPozo;
    }

    public void setIdPozo(String idPozo) {
        this.idPozo = idPozo;
    }

    public double getPresionCabezaMin() {
        return presionCabezaMin;
    }

    public void setPresionCabezaMin(double presionCabezaMin) {
        this.presionCabezaMin = presionCabezaMin;
    }

    public double getPresionCabezaMax() {
        return presionCabezaMax;
    }

    public void setPresionCabezaMax(double presionCabezaMax) {
        this.presionCabezaMax = presionCabezaMax;
    }

    public boolean isPresionCabezaEnable() {
        return presionCabezaEnable;
    }

    public void setPresionCabezaEnable(boolean presionCabezaEnable) {
        this.presionCabezaEnable = presionCabezaEnable;
    }

    public double getTemperaturaCabezaMin() {
        return temperaturaCabezaMin;
    }

    public void setTemperaturaCabezaMin(double temperaturaCabezaMin) {
        this.temperaturaCabezaMin = temperaturaCabezaMin;
    }

    public double getTemperaturaCabezaMax() {
        return temperaturaCabezaMax;
    }

    public void setTemperaturaCabezaMax(double temperaturaCabezaMax) {
        this.temperaturaCabezaMax = temperaturaCabezaMax;
    }

    public boolean isTemperaturaCabezaEnable() {
        return temperaturaCabezaEnable;
    }

    public void setTemperaturaCabezaEnable(boolean temperaturaCabezaEnable) {
        this.temperaturaCabezaEnable = temperaturaCabezaEnable;
    }

    public double getPresionCasingMin() {
        return presionCasingMin;
    }

    public void setPresionCasingMin(double presionCasingMin) {
        this.presionCasingMin = presionCasingMin;
    }

    public double getPresionCasingMax() {
        return presionCasingMax;
    }

    public void setPresionCasingMax(double presionCasingMax) {
        this.presionCasingMax = presionCasingMax;
    }

    public boolean isPresionCasingEnable() {
        return presionCasingEnable;
    }

    public void setPresionCasingEnable(boolean presionCasingEnable) {
        this.presionCasingEnable = presionCasingEnable;
    }

    public double getPresionChokeMin() {
        return presionChokeMin;
    }

    public void setPresionChokeMin(double presionChokeMin) {
        this.presionChokeMin = presionChokeMin;
    }

    public double getPresionChokeMax() {
        return presionChokeMax;
    }

    public void setPresionChokeMax(double presionChokeMax) {
        this.presionChokeMax = presionChokeMax;
    }

    public boolean isPresionChokeEnable() {
        return presionChokeEnable;
    }

    public void setPresionChokeEnable(boolean presionChokeEnable) {
        this.presionChokeEnable = presionChokeEnable;
    }

    public double getFlujoDiluyenteMin() {
        return flujoDiluyenteMin;
    }

    public void setFlujoDiluyenteMin(double flujoDiluyenteMin) {
        this.flujoDiluyenteMin = flujoDiluyenteMin;
    }

    public double getFlujoDiluyenteMax() {
        return flujoDiluyenteMax;
    }

    public void setFlujoDiluyenteMax(double flujoDiluyenteMax) {
        this.flujoDiluyenteMax = flujoDiluyenteMax;
    }

    public boolean isFlujoDiluyenteEnable() {
        return flujoDiluyenteEnable;
    }

    public void setFlujoDiluyenteEnable(boolean flujoDiluyenteEnable) {
        this.flujoDiluyenteEnable = flujoDiluyenteEnable;
    }

    public double getPresionMezcladorMin() {
        return presionMezcladorMin;
    }

    public void setPresionMezcladorMin(double presionMezcladorMin) {
        this.presionMezcladorMin = presionMezcladorMin;
    }

    public double getPresionMezcladorMax() {
        return presionMezcladorMax;
    }

    public void setPresionMezcladorMax(double presionMezcladorMax) {
        this.presionMezcladorMax = presionMezcladorMax;
    }

    public boolean isPresionMezcladorEnable() {
        return presionMezcladorEnable;
    }

    public void setPresionMezcladorEnable(boolean presionMezcladorEnable) {
        this.presionMezcladorEnable = presionMezcladorEnable;
    }

    public double getFlujoAceiteSepMin() {
        return flujoAceiteSepMin;
    }

    public void setFlujoAceiteSepMin(double flujoAceiteSepMin) {
        this.flujoAceiteSepMin = flujoAceiteSepMin;
    }

    public double getFlujoAceiteSepMax() {
        return flujoAceiteSepMax;
    }

    public void setFlujoAceiteSepMax(double flujoAceiteSepMax) {
        this.flujoAceiteSepMax = flujoAceiteSepMax;
    }

    public boolean isFlujoAceiteSepEnable() {
        return flujoAceiteSepEnable;
    }

    public void setFlujoAceiteSepEnable(boolean flujoAceiteSepEnable) {
        this.flujoAceiteSepEnable = flujoAceiteSepEnable;
    }

    public double getFlujoAguaSepMin() {
        return flujoAguaSepMin;
    }

    public void setFlujoAguaSepMin(double flujoAguaSepMin) {
        this.flujoAguaSepMin = flujoAguaSepMin;
    }

    public double getFlujoAguaSepMax() {
        return flujoAguaSepMax;
    }

    public void setFlujoAguaSepMax(double flujoAguaSepMax) {
        this.flujoAguaSepMax = flujoAguaSepMax;
    }

    public boolean isFlujoAguaSepEnable() {
        return flujoAguaSepEnable;
    }

    public void setFlujoAguaSepEnable(boolean flujoAguaSepEnable) {
        this.flujoAguaSepEnable = flujoAguaSepEnable;
    }

    public double getPresionSepMin() {
        return presionSepMin;
    }

    public void setPresionSepMin(double presionSepMin) {
        this.presionSepMin = presionSepMin;
    }

    public double getPresionSepMax() {
        return presionSepMax;
    }

    public void setPresionSepMax(double presionSepMax) {
        this.presionSepMax = presionSepMax;
    }

    public boolean isPresionSepEnable() {
        return presionSepEnable;
    }

    public void setPresionSepEnable(boolean presionSepEnable) {
        this.presionSepEnable = presionSepEnable;
    }

    public double getTemperaturaSepMin() {
        return temperaturaSepMin;
    }

    public void setTemperaturaSepMin(double temperaturaSepMin) {
        this.temperaturaSepMin = temperaturaSepMin;
    }

    public double getTemperaturaSepMax() {
        return temperaturaSepMax;
    }

    public void setTemperaturaSepMax(double temperaturaSepMax) {
        this.temperaturaSepMax = temperaturaSepMax;
    }

    public boolean isTemperaturaSepEnable() {
        return temperaturaSepEnable;
    }

    public void setTemperaturaSepEnable(boolean temperaturaSepEnable) {
        this.temperaturaSepEnable = temperaturaSepEnable;
    }

    public double getPresionGasSepMin() {
        return presionGasSepMin;
    }

    public void setPresionGasSepMin(double presionGasSepMin) {
        this.presionGasSepMin = presionGasSepMin;
    }

    public double getPresionGasSepMax() {
        return presionGasSepMax;
    }

    public void setPresionGasSepMax(double presionGasSepMax) {
        this.presionGasSepMax = presionGasSepMax;
    }

    public boolean isPresionGasSepEnable() {
        return presionGasSepEnable;
    }

    public void setPresionGasSepEnable(boolean presionGasSepEnable) {
        this.presionGasSepEnable = presionGasSepEnable;
    }

    public double getTemperaturaGasSepMin() {
        return temperaturaGasSepMin;
    }

    public void setTemperaturaGasSepMin(double temperaturaGasSepMin) {
        this.temperaturaGasSepMin = temperaturaGasSepMin;
    }

    public double getTemperaturaGasSepMax() {
        return temperaturaGasSepMax;
    }

    public void setTemperaturaGasSepMax(double temperaturaGasSepMax) {
        this.temperaturaGasSepMax = temperaturaGasSepMax;
    }

    public boolean isTemperaturaGasSepEnable() {
        return temperaturaGasSepEnable;
    }

    public void setTemperaturaGasSepEnable(boolean temperaturaGasSepEnable) {
        this.temperaturaGasSepEnable = temperaturaGasSepEnable;
    }

    public double getFlujoGasMin() {
        return flujoGasMin;
    }

    public void setFlujoGasMin(double flujoGasMin) {
        this.flujoGasMin = flujoGasMin;
    }

    public double getFlujoGasMax() {
        return flujoGasMax;
    }

    public void setFlujoGasMax(double flujoGasMax) {
        this.flujoGasMax = flujoGasMax;
    }

    public boolean isFlujoGasEnable() {
        return flujoGasEnable;
    }

    public void setFlujoGasEnable(boolean flujoGasEnable) {
        this.flujoGasEnable = flujoGasEnable;
    }

    public double getPresionLineaMin() {
        return presionLineaMin;
    }

    public void setPresionLineaMin(double presionLineaMin) {
        this.presionLineaMin = presionLineaMin;
    }

    public double getPresionLineaMax() {
        return presionLineaMax;
    }

    public void setPresionLineaMax(double presionLineaMax) {
        this.presionLineaMax = presionLineaMax;
    }

    public boolean isPresionLineaEnable() {
        return presionLineaEnable;
    }

    public void setPresionLineaEnable(boolean presionLineaEnable) {
        this.presionLineaEnable = presionLineaEnable;
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

    public boolean isPresionCabezaActive() {
        return presionCabezaActive;
    }

    public void setPresionCabezaActive(boolean presionCabezaActive) {
        this.presionCabezaActive = presionCabezaActive;
    }

    public boolean isTemperaturaCabezaActive() {
        return temperaturaCabezaActive;
    }

    public void setTemperaturaCabezaActive(boolean temperaturaCabezaActive) {
        this.temperaturaCabezaActive = temperaturaCabezaActive;
    }

    public boolean isPresionCasingActive() {
        return presionCasingActive;
    }

    public void setPresionCasingActive(boolean presionCasingActive) {
        this.presionCasingActive = presionCasingActive;
    }

    public boolean isPresionChokeActive() {
        return presionChokeActive;
    }

    public void setPresionChokeActive(boolean presionChokeActive) {
        this.presionChokeActive = presionChokeActive;
    }

    public boolean isFlujoDiluyenteActive() {
        return flujoDiluyenteActive;
    }

    public void setFlujoDiluyenteActive(boolean flujoDiluyenteActive) {
        this.flujoDiluyenteActive = flujoDiluyenteActive;
    }

    public boolean isPresionMezcladorActive() {
        return presionMezcladorActive;
    }

    public void setPresionMezcladorActive(boolean presionMezcladorActive) {
        this.presionMezcladorActive = presionMezcladorActive;
    }

    public boolean isFlujoAceiteSepActive() {
        return flujoAceiteSepActive;
    }

    public void setFlujoAceiteSepActive(boolean flujoAceiteSepActive) {
        this.flujoAceiteSepActive = flujoAceiteSepActive;
    }

    public boolean isFlujoAguaSepActive() {
        return flujoAguaSepActive;
    }

    public void setFlujoAguaSepActive(boolean flujoAguaSepActive) {
        this.flujoAguaSepActive = flujoAguaSepActive;
    }

    public boolean isPresionSepActive() {
        return presionSepActive;
    }

    public void setPresionSepActive(boolean presionSepActive) {
        this.presionSepActive = presionSepActive;
    }

    public boolean isTemperaturaSepActive() {
        return temperaturaSepActive;
    }

    public void setTemperaturaSepActive(boolean temperaturaSepActive) {
        this.temperaturaSepActive = temperaturaSepActive;
    }

    public boolean isPresionGasSepActive() {
        return presionGasSepActive;
    }

    public void setPresionGasSepActive(boolean presionGasSepActive) {
        this.presionGasSepActive = presionGasSepActive;
    }

    public boolean isTemperaturaGasSepActive() {
        return temperaturaGasSepActive;
    }

    public void setTemperaturaGasSepActive(boolean temperaturaGasSepActive) {
        this.temperaturaGasSepActive = temperaturaGasSepActive;
    }

    public boolean isFlujoGasActive() {
        return flujoGasActive;
    }

    public void setFlujoGasActive(boolean flujoGasActive) {
        this.flujoGasActive = flujoGasActive;
    }

    public boolean isPresionLineaActive() {
        return presionLineaActive;
    }

    public void setPresionLineaActive(boolean presionLineaActive) {
        this.presionLineaActive = presionLineaActive;
    }
    
    
}

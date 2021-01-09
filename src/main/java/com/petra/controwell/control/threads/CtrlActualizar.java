package com.petra.controwell.control.threads;

import java.sql.SQLException;
import javax.swing.JComboBox;

import com.petra.controwell.control.internal.CtrlProceso;
import com.petra.controwell.control.internal.CtrlProcesoAlarmas;

/**
 *
 * @author Angello Morales
 *
 */
public final class CtrlActualizar extends Thread {

    //Variables
    private final int FRECUENCIA = 1000;//milisegundos

    //vista
    //modelo BD
    //modelo
    //controlador;
    public CtrlProceso ctrlProceso;
    public CtrlProcesoAlarmas ctrlProcesoAlarmas;

    public CtrlActualizar(CtrlProceso ctrlProceso, CtrlProcesoAlarmas ctrlProcesoAlarmas) {
        this.ctrlProceso = ctrlProceso;
        this.ctrlProcesoAlarmas = ctrlProcesoAlarmas;

    }

    /**
     * metodo que compara el tiempo transcurrido
     */
    @Override
    public void run() {
        long inic;
        while (true) {
            esperarXtiempo(FRECUENCIA);
            inic = System.currentTimeMillis();
            this.actualizarVariablesProceso();
            System.out.println("ejecutando, tiempo de ciclo: "+(System.currentTimeMillis() - inic));
            //Tiempo en segundos
            //tiempoActual = (System.currentTimeMillis() / 1000);//dividir entre 60 para minutos
            //System.out.println("inicia..." + getTiempoInicial());
            //System.out.println("tiempo de espera..." + tiempoActual);
            //System.out.println("transcurrido..." + (tiempoActual - getTiempoInicial()));
        }
    }

    /**
     * Metodo para hacer delay al hilo
     *
     * @param tiempo tiempo del delay en milisegundos
     */
    private void esperarXtiempo(long tiempo) {
        try {
            Thread.sleep(tiempo);
        } catch (InterruptedException e) {
            System.err.println("ERROR THREAD " + e);
            Thread.currentThread().interrupt();
        }
    }

    public void actualizarVariablesProceso() {
        String valcmbx;
        valcmbx = this.verificarAlarmasActivas(ctrlProceso.frmProceso.cmbxIdPozo);
        ctrlProceso.proceso.setIdPozo(valcmbx);
        ctrlProcesoAlarmas.procesoAlarmas.setIdPozo(valcmbx);
        //ejecutar consultas en base de datos y asigna a la ventana
        try {
            if (valcmbx != null) {
                ctrlProceso.visualizarVariablesProceso(valcmbx);
                if (ctrlProceso.procesoC.buscarUltimoEstado(ctrlProceso.proceso)) {
                    ctrlProceso.asignacionVariables();
                } else {
                    ctrlProceso.ceroAVariables();
                }
                if (ctrlProcesoAlarmas.procesoAlarmasC.buscarAlarmas(ctrlProcesoAlarmas.procesoAlarmas)) {
                    ctrlProceso.activarAlertaAlarma();
                }
            }
        } catch (SQLException ex) {
            System.err.println("No hay datos relacionados error: " + ex);
        }
    }

    public String verificarAlarmasActivas(JComboBox pozos) {
        String pozoAlarma = null;
        if (pozos.getSelectedItem() != null) {
            pozoAlarma = pozos.getSelectedItem().toString();
        }
        String item;
        int size = pozos.getItemCount();
        for (int i = 0; i < size; i++) {
            item = pozos.getItemAt(i).toString();
            if (hayAlarmaEnVariable(item, "presionCabeza")) {
                pozoAlarma = item;
                ctrlProceso.frmProceso.cmbxIdPozo.setSelectedIndex(i);
                break;
            }
            if (hayAlarmaEnVariable(item, "temperaturaCabeza")) {
                pozoAlarma = item;
                ctrlProceso.frmProceso.cmbxIdPozo.setSelectedIndex(i);
                break;
            }
            if (hayAlarmaEnVariable(item, "presionCasing")) {
                pozoAlarma = item;
                ctrlProceso.frmProceso.cmbxIdPozo.setSelectedIndex(i);
                break;
            }
            if (hayAlarmaEnVariable(item, "presionChoke")) {
                pozoAlarma = item;
                ctrlProceso.frmProceso.cmbxIdPozo.setSelectedIndex(i);
                break;
            }
            if (hayAlarmaEnVariable(item, "flujoDiluyente")) {
                pozoAlarma = item;
                ctrlProceso.frmProceso.cmbxIdPozo.setSelectedIndex(i);
                break;
            }
            if (hayAlarmaEnVariable(item, "presionMezclador")) {
                pozoAlarma = item;
                ctrlProceso.frmProceso.cmbxIdPozo.setSelectedIndex(i);
                break;
            }
            if (hayAlarmaEnVariable(item, "flujoAceiteSep")) {
                pozoAlarma = item;
                ctrlProceso.frmProceso.cmbxIdPozo.setSelectedIndex(i);
                break;
            }
            if (hayAlarmaEnVariable(item, "flujoAguaSep")) {
                pozoAlarma = item;
                ctrlProceso.frmProceso.cmbxIdPozo.setSelectedIndex(i);
                break;
            }
            if (hayAlarmaEnVariable(item, "presionSep")) {
                pozoAlarma = item;
                ctrlProceso.frmProceso.cmbxIdPozo.setSelectedIndex(i);
                break;
            }
            if (hayAlarmaEnVariable(item, "temperaturaSep")) {
                pozoAlarma = item;
                ctrlProceso.frmProceso.cmbxIdPozo.setSelectedIndex(i);
                break;
            }
            if (hayAlarmaEnVariable(item, "presionGasSep")) {
                pozoAlarma = item;
                ctrlProceso.frmProceso.cmbxIdPozo.setSelectedIndex(i);
                break;
            }
            if (hayAlarmaEnVariable(item, "temperaturaGasSep")) {
                pozoAlarma = item;
                ctrlProceso.frmProceso.cmbxIdPozo.setSelectedIndex(i);
                break;
            }
            if (hayAlarmaEnVariable(item, "flujoGas")) {
                pozoAlarma = item;
                ctrlProceso.frmProceso.cmbxIdPozo.setSelectedIndex(i);
                break;
            }
            if (hayAlarmaEnVariable(item, "presionLinea")) {
                pozoAlarma = item;
                ctrlProceso.frmProceso.cmbxIdPozo.setSelectedIndex(i);
                break;
            }
        }
        return pozoAlarma;
    }

    public boolean hayAlarmaEnVariable(String pozo, String variable) {
        boolean flag = false;
        try {
            if (!ctrlProcesoAlarmas.procesoAlarmasC.noHayAlarma(pozo, variable)) {
                flag = true;
            }
        } catch (SQLException ex) {
            System.err.println("No hay alarmas error: " + ex);
        }

        return flag;
    }

}

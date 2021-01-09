package com.petra.controwell.control.threads;

import com.petra.controwell.control.internal.CtrlAforoTk;
import com.petra.controwell.control.internal.CtrlEditarProceso;
import com.petra.controwell.view.FrmCargando;

import javax.swing.JOptionPane;

/**
 *
 * @author Angello Morales
 */
public class CtrlCargando implements Runnable {

    //vista
    public FrmCargando frmCargando;

    //modelo BD
    //modelo
    //controlador
    CtrlAforoTk ctrlAforoTk;
    CtrlEditarProceso ctrlEditarProceso;

    public CtrlCargando(FrmCargando frmCargando, CtrlAforoTk ctrlAforoTk) {
        this.frmCargando = frmCargando;
        this.ctrlAforoTk = ctrlAforoTk;
    }
    
    public CtrlCargando(FrmCargando frmCargando, CtrlEditarProceso ctrlEditarProceso) {
        this.frmCargando = frmCargando;
        this.ctrlEditarProceso= ctrlEditarProceso;
    }

    public void iniciar() {
      
        frmCargando.setVisible(true);
        frmCargando.setLocationRelativeTo(null);
        frmCargando.toFront();

    }

    public void detener() {
        frmCargando.setVisible(false);

    }

    public void show() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        this.iniciar();
        ctrlAforoTk.eliminarDatos();
        ctrlAforoTk.evualuarXLSX(ctrlAforoTk.getArchivo());
        this.detener();
    }

}

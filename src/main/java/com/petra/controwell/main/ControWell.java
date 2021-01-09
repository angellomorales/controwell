package com.petra.controwell.main;

import com.petra.controwell.control.CtrlPrincipal;
import com.petra.controwell.control.CtrlPrincipalTanques;
import com.petra.controwell.control.internal.CtrlAforoTk;
import com.petra.controwell.control.internal.CtrlBalance;
import com.petra.controwell.control.internal.CtrlEditarProceso;
import com.petra.controwell.control.internal.CtrlGraficas;
import com.petra.controwell.control.internal.CtrlPozos;
import com.petra.controwell.control.internal.CtrlProceso;
import com.petra.controwell.control.internal.CtrlProcesoAlarmas;
import com.petra.controwell.control.internal.CtrlReporte;
import com.petra.controwell.control.internal.CtrlTanques;
import com.petra.controwell.control.internal.CtrlVariador;
import com.petra.controwell.control.threads.CtrlActualizar;
import com.petra.controwell.model.CalculoApi;
import com.petra.controwell.model.Calculos;
import com.petra.controwell.model.data.AforoTk;
import com.petra.controwell.model.data.Balance;
import com.petra.controwell.model.data.OperacionTk;
import com.petra.controwell.model.data.Proceso;
import com.petra.controwell.model.data.ProcesoAlarmas;
import com.petra.controwell.model.data.Tanques;
import com.petra.controwell.model.data.Variador;
import com.petra.controwell.model.data.WellInfo;
import com.petra.controwell.model.data.querys.ConsultasAforoTk;
import com.petra.controwell.model.data.querys.ConsultasBalance;
import com.petra.controwell.model.data.querys.ConsultasProcesoProduccionArray;
import com.petra.controwell.model.data.querys.ConsultasOperacionTk;
import com.petra.controwell.model.data.querys.ConsultasProceso;
import com.petra.controwell.model.data.querys.ConsultasProcesoAlarmas;
import com.petra.controwell.model.data.querys.ConsultasTanques;
import com.petra.controwell.model.data.querys.ConsultasVariador;
import com.petra.controwell.model.data.querys.ConsultasWellInfo;
import com.petra.controwell.model.utilities.Utilities;
import com.petra.controwell.view.FrmCargando;
import com.petra.controwell.view.FrmPrincipal;
import com.petra.controwell.view.FrmPrincipalTanques;
import com.petra.controwell.view.internal.FrmAforoTk;
import com.petra.controwell.view.internal.FrmApi;
import com.petra.controwell.view.internal.FrmBalance;
import com.petra.controwell.view.internal.FrmEditarProceso;
import com.petra.controwell.view.internal.FrmGraficas;
import com.petra.controwell.view.internal.FrmOperacionTk;
import com.petra.controwell.view.internal.FrmPozos;
import com.petra.controwell.view.internal.FrmProceso;
import com.petra.controwell.view.internal.FrmProcesoAlarmas;
import com.petra.controwell.view.internal.FrmReporte;
import com.petra.controwell.view.internal.FrmSeries;
import com.petra.controwell.view.internal.FrmTanques;

/**
 *
 * @author Angello Morales
 */
public class ControWell {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        //</editor-fold>
        //Variables
        //modelo BD
        Proceso proceso = new Proceso();
        WellInfo wellinfo = new WellInfo();
        ProcesoAlarmas procesoAlarmas = new ProcesoAlarmas();
        AforoTk aforoTk = new AforoTk();
        Tanques tanques = new Tanques();
        OperacionTk operacionTk = new OperacionTk();
        Balance balance = new Balance();
        Variador variador= new Variador();

        //modelo Consultas
        ConsultasProceso procesoC = new ConsultasProceso();
        ConsultasWellInfo wellinfoC = new ConsultasWellInfo();
        ConsultasProcesoAlarmas procesoAlarmasC = new ConsultasProcesoAlarmas();
        ConsultasAforoTk aforoTkC = new ConsultasAforoTk();
        ConsultasTanques tanquesC = new ConsultasTanques();
        ConsultasOperacionTk operacionTkC = new ConsultasOperacionTk();
        ConsultasBalance balanceC = new ConsultasBalance();
        ConsultasProcesoProduccionArray graficaC = new ConsultasProcesoProduccionArray();
        ConsultasVariador variadorC= new ConsultasVariador();

        //modelo
        Calculos calculos = new Calculos();
        CalculoApi calculoApi = new CalculoApi();

        //vista
        FrmPrincipal frmPrincipal = new FrmPrincipal();
        FrmPrincipalTanques frmPrincipalTanques = new FrmPrincipalTanques();
        FrmCargando frmCargando = new FrmCargando();
        FrmPozos frmPozos = new FrmPozos();
        FrmProceso frmProceso = new FrmProceso();
        FrmProcesoAlarmas frmProcesoAlarmas = new FrmProcesoAlarmas();
        FrmTanques frmTanques = new FrmTanques();
        FrmAforoTk frmAforoTk = new FrmAforoTk();
        FrmBalance frmBalance = new FrmBalance();
        FrmOperacionTk frmOperacionTk = new FrmOperacionTk();
        FrmApi frmApi = new FrmApi();
        FrmGraficas frmGraficas = new FrmGraficas();
        FrmReporte frmReporte = new FrmReporte();
        FrmSeries frmSeries = new FrmSeries();
        FrmEditarProceso frmEditarProceso= new FrmEditarProceso();

        //controlador
        Utilities utilities = new Utilities();

        CtrlPozos ctrlPozos = new CtrlPozos(frmPozos, frmProceso, frmProcesoAlarmas, frmOperacionTk, frmBalance, frmGraficas,frmEditarProceso, wellinfo, wellinfoC, utilities);
        CtrlTanques ctrlTanques = new CtrlTanques(frmTanques, frmAforoTk, frmOperacionTk, tanques, tanquesC, utilities);
        CtrlAforoTk ctrlAforoTk = new CtrlAforoTk(frmAforoTk, aforoTk, aforoTkC, frmCargando, utilities);

        CtrlProcesoAlarmas ctrlProcesoAlarmas = new CtrlProcesoAlarmas(frmProcesoAlarmas, procesoAlarmas, procesoAlarmasC, utilities);
        CtrlBalance ctrlBalance = new CtrlBalance(frmBalance, frmOperacionTk, operacionTk, calculos, operacionTkC, utilities, ctrlAforoTk, ctrlTanques, frmApi, calculoApi, balance, balanceC);

        CtrlPrincipalTanques ctrlPrincipalTanques = new CtrlPrincipalTanques(frmPrincipalTanques, frmBalance, frmOperacionTk, frmApi, ctrlBalance);
        CtrlProceso ctrlProceso = new CtrlProceso(frmProceso, proceso, procesoC, procesoAlarmas, utilities, ctrlPrincipalTanques, ctrlProcesoAlarmas);
        CtrlVariador ctrlVariador=new CtrlVariador(variador, variadorC, utilities);
        CtrlGraficas ctrlGraficas = new CtrlGraficas(frmGraficas, frmSeries, graficaC, utilities);
        CtrlEditarProceso ctrlEditarProceso= new CtrlEditarProceso(frmEditarProceso,ctrlGraficas,utilities,variadorC,procesoC,frmCargando);
        CtrlReporte ctrlReporte = new CtrlReporte(frmReporte,utilities,ctrlBalance,ctrlTanques,ctrlPozos,ctrlProceso,ctrlVariador);
        CtrlActualizar ctrlActualizar = new CtrlActualizar(ctrlProceso, ctrlProcesoAlarmas);
        CtrlPrincipal ctrlPrincipal = new CtrlPrincipal(frmPrincipal, frmProceso, frmProcesoAlarmas, frmPozos, frmAforoTk, frmTanques, frmGraficas, frmReporte, frmSeries,frmEditarProceso, ctrlPozos, ctrlProceso, ctrlProcesoAlarmas, ctrlActualizar, ctrlAforoTk, ctrlTanques, ctrlGraficas, ctrlReporte, ctrlEditarProceso);

        //ejecucion
        ctrlPrincipal.iniciar();

    }

}

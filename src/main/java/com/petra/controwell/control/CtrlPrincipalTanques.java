package com.petra.controwell.control;

import com.petra.controwell.control.internal.CtrlBalance;
import com.petra.controwell.view.FrmPrincipalTanques;
import com.petra.controwell.view.internal.FrmApi;
import com.petra.controwell.view.internal.FrmBalance;
import com.petra.controwell.view.internal.FrmOperacionTk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Angello Morales
 */
public class CtrlPrincipalTanques implements ActionListener {

    //vista
    public FrmPrincipalTanques frmPrincipalTanques;

    //modelo BD
    //modelo
    //controlador
    public CtrlBalance ctrlEstadoTanques;

    public CtrlPrincipalTanques(FrmPrincipalTanques frmPrincipalTanques,FrmBalance frmEstadoTanques, FrmOperacionTk frmOperacionTk, FrmApi frmApi,CtrlBalance ctrlEstadoTanques) {
        this.frmPrincipalTanques = frmPrincipalTanques;
        this.ctrlEstadoTanques= ctrlEstadoTanques;

        //agregar listener a los botones dentro del constructor
        //this.frmPrincipalTanques.mnuPozos.addActionListener(this);


        //agregar ventanas
        frmPrincipalTanques.escritorio.add(frmEstadoTanques);
        frmPrincipalTanques.escritorio.add(frmOperacionTk);
        frmPrincipalTanques.escritorio.add(frmApi);

        
        

    }

    public void iniciar() {
        frmPrincipalTanques.setTitle("ControWell-Tanques");
        frmPrincipalTanques.setLocationRelativeTo(null);
        frmPrincipalTanques.setVisible(true);
        this.ventanaDefault();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //acciones a ejecutar cuando se presiona un elemento en la pantalla 
        //if por cada elemento para detectar cual se presiono
        //--------Menu---------
//        if (e.getSource() == frmPrincipalTanques.mnuPozos) {
//
//            try {
//                ctrlPozos.iniciar();
//            } catch (PropertyVetoException ex) {
//                Logger.getLogger(CtrlPrincipalTanques.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        
    }

    public void ventanaDefault() {
        ctrlEstadoTanques.iniciar();


    }
}

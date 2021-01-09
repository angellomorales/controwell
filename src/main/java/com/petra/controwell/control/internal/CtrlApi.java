package com.petra.controwell.control.internal;

import com.petra.controwell.model.CalculoApi;
import com.petra.controwell.model.utilities.Utilities;
import com.petra.controwell.view.internal.FrmApi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

/**
 *
 * @author Angello Morales
 */
public class CtrlApi implements ActionListener {

    //vista
    public FrmApi frmApi;

    //modelo BD
    //modelo
    public CalculoApi calculoApi;

    //controlador
    public Utilities ctrlUtilities;
    public CtrlOperacionTk ctrlOperacionTk;
    public CtrlBalance ctrlBalance;
    //variables
    public final int OPERACIONTK = 1;
    public final int BALANCE = 2;
    public int ventana;

    public CtrlApi(FrmApi frmApi, CalculoApi calculoApi, Utilities ctrlUtilities, CtrlBalance ctrlBalance, CtrlOperacionTk ctrlOperacionTk) {
        this.frmApi = frmApi;
        this.calculoApi = calculoApi;
        this.ctrlUtilities = ctrlUtilities;
        this.ctrlOperacionTk = ctrlOperacionTk;
        this.ctrlBalance = ctrlBalance;

        //agregar listener a los botones dentro del constructor
        this.frmApi.btnAceptar.addActionListener(this);

        //instanciar librerias
    }

    public void iniciar(int ventana) throws PropertyVetoException {
        frmApi.setTitle("Calcular Api Corregido");
        frmApi.setVisible(true);
        frmApi.toFront();
        frmApi.setSelected(true);
        this.setVentana(ventana);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //acciones a ejecutar cuando se presiona un elemento en la pantalla 
        //if por cada elemento para detectar cual se presiono
        //--------------Agregar--------------
        if (e.getSource() == frmApi.btnAceptar) {
            double apiObs;
            double tempObs;
            double res;
            apiObs = Double.parseDouble(ctrlUtilities.VerificarTextField(frmApi.txtApiObs));
            tempObs = Double.parseDouble(ctrlUtilities.VerificarTextField(frmApi.txtTempObs));
            calculoApi.setCorreccionAPI(apiObs, tempObs);
            res = calculoApi.getCorreccionAPI();
            if (getVentana() == OPERACIONTK) {
                ctrlOperacionTk.frmOperacionTk.txtAPI.setText(String.valueOf(res));
            } else {
                ctrlBalance.frmBalance.txtApiCabeza.setText(String.valueOf(res));
            }
            this.frmApi.hide();
        }

    }

    public void limpiar() {
        frmApi.txtApiObs.setText("");
        frmApi.txtTempObs.setText("");
    }

    public int getVentana() {
        return ventana;
    }

    public void setVentana(int ventana) {
        this.ventana = ventana;
    }

}

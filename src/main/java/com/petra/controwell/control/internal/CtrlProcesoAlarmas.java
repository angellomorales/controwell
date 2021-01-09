package com.petra.controwell.control.internal;

import com.petra.controwell.model.data.ProcesoAlarmas;
import com.petra.controwell.model.data.querys.ConsultasProcesoAlarmas;
import com.petra.controwell.model.utilities.Utilities;
import com.petra.controwell.view.internal.FrmProcesoAlarmas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Angello Morales
 */
public class CtrlProcesoAlarmas implements ActionListener {

    //vista
    public FrmProcesoAlarmas frmProcesoAlarmas;

    //modelo BD
    public ProcesoAlarmas procesoAlarmas;
    public ConsultasProcesoAlarmas procesoAlarmasC;

    //modelo
    //controlador;
    public Utilities ctrlUtilities;

    public CtrlProcesoAlarmas(FrmProcesoAlarmas frmProcesoAlarm, ProcesoAlarmas procesoAlarm, ConsultasProcesoAlarmas procesoAlarmC, Utilities ctrlUtilities) {
        this.frmProcesoAlarmas = frmProcesoAlarm;
        this.procesoAlarmas = procesoAlarm;
        this.procesoAlarmasC = procesoAlarmC;
        this.ctrlUtilities = ctrlUtilities;
        //
        this.frmProcesoAlarmas.cmbxIdPozo.removeAllItems();

        //agregar listener a los botones dentro del constructor
        this.frmProcesoAlarmas.btnAceptar.addActionListener(this);
        this.frmProcesoAlarmas.btnBorrar.addActionListener(this);
        this.frmProcesoAlarmas.chkPresionCabezaActive.addActionListener(this);
        this.frmProcesoAlarmas.chkTemperaturaCabezaActive.addActionListener(this);
        this.frmProcesoAlarmas.chkPresionCasingActive.addActionListener(this);
        this.frmProcesoAlarmas.chkPresionChokeActive.addActionListener(this);
        this.frmProcesoAlarmas.chkFlujoDiluyenteActive.addActionListener(this);
        this.frmProcesoAlarmas.chkPresionMezcladorActive.addActionListener(this);
        this.frmProcesoAlarmas.chkFlujoAceiteSepActive.addActionListener(this);
        this.frmProcesoAlarmas.chkFlujoAguaSepActive.addActionListener(this);
        this.frmProcesoAlarmas.chkPresionSepActive.addActionListener(this);
        this.frmProcesoAlarmas.chkTemperaturaSepActive.addActionListener(this);
        this.frmProcesoAlarmas.chkPresionGasSepActive.addActionListener(this);
        this.frmProcesoAlarmas.chkTemperaturaGasSepActive.addActionListener(this);
        this.frmProcesoAlarmas.chkFlujoGasActive.addActionListener(this);
        this.frmProcesoAlarmas.chkPresionLineaActive.addActionListener(this);

        //itemListener particular para combobox
        this.frmProcesoAlarmas.cmbxIdPozo.addItemListener((ItemEvent itemEvent) -> {
            int state = itemEvent.getStateChange();
            String valcmbx;
            valcmbx = frmProcesoAlarmas.cmbxIdPozo.getSelectedItem().toString();          
            if (state == ItemEvent.SELECTED) {
                if (!valcmbx.isEmpty()) {
                    procesoAlarmas.setIdPozo(valcmbx);
                    this.cargarInformacion();
                }

            }
        });
    }

    public void iniciar() throws PropertyVetoException {
        frmProcesoAlarmas.setTitle("Configuracion de Variables de Proceso");
        frmProcesoAlarmas.setVisible(true);
        frmProcesoAlarmas.toFront();
        frmProcesoAlarmas.setSelected(true);
        frmProcesoAlarmas.btnAceptar.setEnabled(false);
        frmProcesoAlarmas.btnBorrar.setEnabled(false);
        this.limpiar();
        this.checkeoVariables();
        String valcmbx= frmProcesoAlarmas.cmbxIdPozo.getSelectedItem().toString();
        if(!valcmbx.isEmpty()){
            procesoAlarmas.setIdPozo(valcmbx);
            this.cargarInformacion();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //acciones a ejecutar cuando se presiona un elemento en la pantalla 
        //if por cada elemento para detectar cual se presiono

        //-----Agregar-----
        if (e.getSource() == frmProcesoAlarmas.btnAceptar) {
            String valcmbx;
            valcmbx = frmProcesoAlarmas.cmbxIdPozo.getSelectedItem().toString();
            procesoAlarmas.setIdPozo(valcmbx);
            ctrlUtilities.setTextFieldOk(true);

            procesoAlarmas.setPresionCabezaMin(Double.parseDouble(ctrlUtilities.VerificarTextField(frmProcesoAlarmas.txtPresionCabezaMin)));
            procesoAlarmas.setPresionCabezaMax(Double.parseDouble(ctrlUtilities.VerificarTextField(frmProcesoAlarmas.txtPresionCabezaMax)));
            procesoAlarmas.setPresionCabezaEnable(frmProcesoAlarmas.chkPresionCabezaEnable.isSelected());
            procesoAlarmas.setTemperaturaCabezaMin(Double.parseDouble(ctrlUtilities.VerificarTextField(frmProcesoAlarmas.txtTemperaturaCabezaMin)));
            procesoAlarmas.setTemperaturaCabezaMax(Double.parseDouble(ctrlUtilities.VerificarTextField(frmProcesoAlarmas.txtTemperaturaCabezaMax)));
            procesoAlarmas.setTemperaturaCabezaEnable(frmProcesoAlarmas.chkTemperaturaCabezaEnable.isSelected());
            procesoAlarmas.setPresionCasingMin(Double.parseDouble(ctrlUtilities.VerificarTextField(frmProcesoAlarmas.txtPresionCasingMin)));
            procesoAlarmas.setPresionCasingMax(Double.parseDouble(ctrlUtilities.VerificarTextField(frmProcesoAlarmas.txtPresionCasingMax)));
            procesoAlarmas.setPresionCasingEnable(frmProcesoAlarmas.chkPresionCasingEnable.isSelected());
            procesoAlarmas.setPresionChokeMin(Double.parseDouble(ctrlUtilities.VerificarTextField(frmProcesoAlarmas.txtPresionChokeMin)));
            procesoAlarmas.setPresionChokeMax(Double.parseDouble(ctrlUtilities.VerificarTextField(frmProcesoAlarmas.txtPresionChokeMax)));
            procesoAlarmas.setPresionChokeEnable(frmProcesoAlarmas.chkPresionChokeEnable.isSelected());
            procesoAlarmas.setFlujoDiluyenteMin(Double.parseDouble(ctrlUtilities.VerificarTextField(frmProcesoAlarmas.txtFlujoDiluyenteMin)));
            procesoAlarmas.setFlujoDiluyenteMax(Double.parseDouble(ctrlUtilities.VerificarTextField(frmProcesoAlarmas.txtFlujoDiluyenteMax)));
            procesoAlarmas.setFlujoDiluyenteEnable(frmProcesoAlarmas.chkFlujoDiluyenteEnable.isSelected());
            procesoAlarmas.setPresionMezcladorMin(Double.parseDouble(ctrlUtilities.VerificarTextField(frmProcesoAlarmas.txtPresionMezcladorMin)));
            procesoAlarmas.setPresionMezcladorMax(Double.parseDouble(ctrlUtilities.VerificarTextField(frmProcesoAlarmas.txtPresionMezcladorMax)));
            procesoAlarmas.setPresionMezcladorEnable(frmProcesoAlarmas.chkPresionMezcladorEnable.isSelected());
            procesoAlarmas.setFlujoAceiteSepMin(Double.parseDouble(ctrlUtilities.VerificarTextField(frmProcesoAlarmas.txtFlujoAceiteSepMin)));
            procesoAlarmas.setFlujoAceiteSepMax(Double.parseDouble(ctrlUtilities.VerificarTextField(frmProcesoAlarmas.txtFlujoAceiteSepMax)));
            procesoAlarmas.setFlujoAceiteSepEnable(frmProcesoAlarmas.chkFlujoAceiteSepEnable.isSelected());
            procesoAlarmas.setFlujoAguaSepMin(Double.parseDouble(ctrlUtilities.VerificarTextField(frmProcesoAlarmas.txtFlujoAguaSepMin)));
            procesoAlarmas.setFlujoAguaSepMax(Double.parseDouble(ctrlUtilities.VerificarTextField(frmProcesoAlarmas.txtFlujoAguaSepMax)));
            procesoAlarmas.setFlujoAguaSepEnable(frmProcesoAlarmas.chkFlujoAguaSepEnable.isSelected());
            procesoAlarmas.setPresionSepMin(Double.parseDouble(ctrlUtilities.VerificarTextField(frmProcesoAlarmas.txtPresionSepMin)));
            procesoAlarmas.setPresionSepMax(Double.parseDouble(ctrlUtilities.VerificarTextField(frmProcesoAlarmas.txtPresionSepMax)));
            procesoAlarmas.setPresionSepEnable(frmProcesoAlarmas.chkPresionSepEnable.isSelected());
            procesoAlarmas.setTemperaturaSepMin(Double.parseDouble(ctrlUtilities.VerificarTextField(frmProcesoAlarmas.txtTemperaturaSepMin)));
            procesoAlarmas.setTemperaturaSepMax(Double.parseDouble(ctrlUtilities.VerificarTextField(frmProcesoAlarmas.txtTemperaturaSepMax)));
            procesoAlarmas.setTemperaturaSepEnable(frmProcesoAlarmas.chkTemperaturaSepEnable.isSelected());
            procesoAlarmas.setPresionGasSepMin(Double.parseDouble(ctrlUtilities.VerificarTextField(frmProcesoAlarmas.txtPresionGasSepMin)));
            procesoAlarmas.setPresionGasSepMax(Double.parseDouble(ctrlUtilities.VerificarTextField(frmProcesoAlarmas.txtPresionGasSepMax)));
            procesoAlarmas.setPresionGasSepEnable(frmProcesoAlarmas.chkPresionGasSepEnable.isSelected());
            procesoAlarmas.setTemperaturaGasSepMin(Double.parseDouble(ctrlUtilities.VerificarTextField(frmProcesoAlarmas.txtTemperaturaGasSepMin)));
            procesoAlarmas.setTemperaturaGasSepMax(Double.parseDouble(ctrlUtilities.VerificarTextField(frmProcesoAlarmas.txtTemperaturaGasSepMax)));
            procesoAlarmas.setTemperaturaGasSepEnable(frmProcesoAlarmas.chkTemperaturaGasSepEnable.isSelected());
            procesoAlarmas.setFlujoGasMin(Double.parseDouble(ctrlUtilities.VerificarTextField(frmProcesoAlarmas.txtFlujoGasMin)));
            procesoAlarmas.setFlujoGasMax(Double.parseDouble(ctrlUtilities.VerificarTextField(frmProcesoAlarmas.txtFlujoGasMax)));
            procesoAlarmas.setFlujoGasEnable(frmProcesoAlarmas.chkFlujoGasEnable.isSelected());
            procesoAlarmas.setPresionLineaMin(Double.parseDouble(ctrlUtilities.VerificarTextField(frmProcesoAlarmas.txtPresionLineaMin)));
            procesoAlarmas.setPresionLineaMax(Double.parseDouble(ctrlUtilities.VerificarTextField(frmProcesoAlarmas.txtPresionLineaMax)));
            procesoAlarmas.setPresionLineaEnable(frmProcesoAlarmas.chkPresionLineaEnable.isSelected());
            procesoAlarmas.setFecha(ctrlUtilities.getFechaActual());
            procesoAlarmas.setHora(ctrlUtilities.getHoraActual());
            procesoAlarmas.setPresionCabezaActive(frmProcesoAlarmas.chkPresionCabezaActive.isSelected());
            procesoAlarmas.setTemperaturaCabezaActive(frmProcesoAlarmas.chkTemperaturaCabezaActive.isSelected());
            procesoAlarmas.setPresionCasingActive(frmProcesoAlarmas.chkPresionCasingActive.isSelected());
            procesoAlarmas.setPresionChokeActive(frmProcesoAlarmas.chkPresionChokeActive.isSelected());
            procesoAlarmas.setFlujoDiluyenteActive(frmProcesoAlarmas.chkFlujoDiluyenteActive.isSelected());
            procesoAlarmas.setPresionMezcladorActive(frmProcesoAlarmas.chkPresionMezcladorActive.isSelected());
            procesoAlarmas.setFlujoAceiteSepActive(frmProcesoAlarmas.chkFlujoAceiteSepActive.isSelected());
            procesoAlarmas.setFlujoAguaSepActive(frmProcesoAlarmas.chkFlujoAguaSepActive.isSelected());
            procesoAlarmas.setPresionSepActive(frmProcesoAlarmas.chkPresionSepActive.isSelected());
            procesoAlarmas.setTemperaturaSepActive(frmProcesoAlarmas.chkTemperaturaSepActive.isSelected());
            procesoAlarmas.setPresionGasSepActive(frmProcesoAlarmas.chkPresionGasSepActive.isSelected());
            procesoAlarmas.setTemperaturaGasSepActive(frmProcesoAlarmas.chkTemperaturaGasSepActive.isSelected());
            procesoAlarmas.setFlujoGasActive(frmProcesoAlarmas.chkFlujoGasActive.isSelected());
            procesoAlarmas.setPresionLineaActive(frmProcesoAlarmas.chkPresionLineaActive.isSelected());

            //ejecutar consultas en base de datos y asigna a la ventana
            if (ctrlUtilities.isTextFieldOk()) {
                try {
                    if (procesoAlarmasC.editarAlarmas(procesoAlarmas)) {
                        JOptionPane.showMessageDialog(null, "Registro actualizado");
                        ctrlUtilities.setTextFieldOk(false);
                        frmProcesoAlarmas.hide();
                        this.limpiar();
                    } else {
                        if (procesoAlarmasC.agregarAlarmas(procesoAlarmas)) {
                            JOptionPane.showMessageDialog(null, "Registro guardado");
                            ctrlUtilities.setTextFieldOk(false);
                            frmProcesoAlarmas.hide();
                            this.limpiar();
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al guardar verifique los datos ingresados");
                        }
                    }
                } catch (SQLException ex) {
                    System.err.println("No hay datos relacionados error: " + ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese Valores Numéricos");
            }
        }
        //------Eliminar-----
        if (e.getSource() == frmProcesoAlarmas.btnBorrar) {
            String valcmbx;
            valcmbx = frmProcesoAlarmas.cmbxIdPozo.getSelectedItem().toString();
            procesoAlarmas.setIdPozo(valcmbx);
            //ejecutar consultas en base de datos y asigna a la ventana
            try {
                if (procesoAlarmasC.eliminarAlarmas(procesoAlarmas)) {
                    JOptionPane.showMessageDialog(null, "Registro Eliminado");
                    this.limpiar();
                    this.frmProcesoAlarmas.btnAceptar.setEnabled(true);
                    this.frmProcesoAlarmas.btnBorrar.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar");
                }
            } catch (SQLException ex) {
                System.err.println("Error al eliminar error: " + ex);
            }
        }
        //------------checkbutton variables-----------------
        if (e.getSource() == frmProcesoAlarmas.chkPresionCabezaActive) {
            this.checkeoVariables();
        }
        if (e.getSource() == frmProcesoAlarmas.chkTemperaturaCabezaActive) {
            this.checkeoVariables();
        }
        if (e.getSource() == frmProcesoAlarmas.chkPresionCasingActive) {
            this.checkeoVariables();
        }
        if (e.getSource() == frmProcesoAlarmas.chkPresionChokeActive) {
            this.checkeoVariables();
        }
        if (e.getSource() == frmProcesoAlarmas.chkFlujoDiluyenteActive) {
            this.checkeoVariables();
        }
        if (e.getSource() == frmProcesoAlarmas.chkPresionMezcladorActive) {
            this.checkeoVariables();
        }
        if (e.getSource() == frmProcesoAlarmas.chkFlujoAceiteSepActive) {
            this.checkeoVariables();
        }
        if (e.getSource() == frmProcesoAlarmas.chkFlujoAguaSepActive) {
            this.checkeoVariables();
        }
        if (e.getSource() == frmProcesoAlarmas.chkPresionSepActive) {
            this.checkeoVariables();
        }
        if (e.getSource() == frmProcesoAlarmas.chkTemperaturaSepActive) {
            this.checkeoVariables();
        }
        if (e.getSource() == frmProcesoAlarmas.chkPresionGasSepActive) {
            this.checkeoVariables();
        }
        if (e.getSource() == frmProcesoAlarmas.chkTemperaturaGasSepActive) {
            this.checkeoVariables();
        }
        if (e.getSource() == frmProcesoAlarmas.chkFlujoGasActive) {
            this.checkeoVariables();
        }
        if (e.getSource() == frmProcesoAlarmas.chkPresionLineaActive) {
            this.checkeoVariables();
        }
    }

    public void asignacionTextBox() {
        frmProcesoAlarmas.txtPresionCabezaMin.setText(Double.toString(procesoAlarmas.getPresionCabezaMin()));
        frmProcesoAlarmas.txtPresionCabezaMax.setText(Double.toString(procesoAlarmas.getPresionCabezaMax()));
        frmProcesoAlarmas.chkPresionCabezaEnable.setSelected(procesoAlarmas.isPresionCabezaEnable());
        frmProcesoAlarmas.txtTemperaturaCabezaMin.setText(Double.toString(procesoAlarmas.getTemperaturaCabezaMin()));
        frmProcesoAlarmas.txtTemperaturaCabezaMax.setText(Double.toString(procesoAlarmas.getTemperaturaCabezaMax()));
        frmProcesoAlarmas.chkTemperaturaCabezaEnable.setSelected(procesoAlarmas.isTemperaturaCabezaEnable());
        frmProcesoAlarmas.txtPresionCasingMin.setText(Double.toString(procesoAlarmas.getPresionCasingMin()));
        frmProcesoAlarmas.txtPresionCasingMax.setText(Double.toString(procesoAlarmas.getPresionCasingMax()));
        frmProcesoAlarmas.chkPresionCasingEnable.setSelected(procesoAlarmas.isPresionCasingEnable());
        frmProcesoAlarmas.txtPresionChokeMin.setText(Double.toString(procesoAlarmas.getPresionChokeMin()));
        frmProcesoAlarmas.txtPresionChokeMax.setText(Double.toString(procesoAlarmas.getPresionChokeMax()));
        frmProcesoAlarmas.chkPresionChokeEnable.setSelected(procesoAlarmas.isPresionChokeEnable());
        frmProcesoAlarmas.txtFlujoDiluyenteMin.setText(Double.toString(procesoAlarmas.getFlujoDiluyenteMin()));
        frmProcesoAlarmas.txtFlujoDiluyenteMax.setText(Double.toString(procesoAlarmas.getFlujoDiluyenteMax()));
        frmProcesoAlarmas.chkFlujoDiluyenteEnable.setSelected(procesoAlarmas.isFlujoDiluyenteEnable());
        frmProcesoAlarmas.txtPresionMezcladorMin.setText(Double.toString(procesoAlarmas.getPresionMezcladorMin()));
        frmProcesoAlarmas.txtPresionMezcladorMax.setText(Double.toString(procesoAlarmas.getPresionMezcladorMax()));
        frmProcesoAlarmas.chkPresionMezcladorEnable.setSelected(procesoAlarmas.isPresionMezcladorEnable());
        frmProcesoAlarmas.txtFlujoAceiteSepMin.setText(Double.toString(procesoAlarmas.getFlujoAceiteSepMin()));
        frmProcesoAlarmas.txtFlujoAceiteSepMax.setText(Double.toString(procesoAlarmas.getFlujoAceiteSepMax()));
        frmProcesoAlarmas.chkFlujoAceiteSepEnable.setSelected(procesoAlarmas.isFlujoAceiteSepEnable());
        frmProcesoAlarmas.txtFlujoAguaSepMin.setText(Double.toString(procesoAlarmas.getFlujoAguaSepMin()));
        frmProcesoAlarmas.txtFlujoAguaSepMax.setText(Double.toString(procesoAlarmas.getFlujoAguaSepMax()));
        frmProcesoAlarmas.chkFlujoAguaSepEnable.setSelected(procesoAlarmas.isFlujoAguaSepEnable());
        frmProcesoAlarmas.txtPresionSepMin.setText(Double.toString(procesoAlarmas.getPresionSepMin()));
        frmProcesoAlarmas.txtPresionSepMax.setText(Double.toString(procesoAlarmas.getPresionSepMax()));
        frmProcesoAlarmas.chkPresionSepEnable.setSelected(procesoAlarmas.isPresionSepEnable());
        frmProcesoAlarmas.txtTemperaturaSepMin.setText(Double.toString(procesoAlarmas.getTemperaturaSepMin()));
        frmProcesoAlarmas.txtTemperaturaSepMax.setText(Double.toString(procesoAlarmas.getTemperaturaSepMax()));
        frmProcesoAlarmas.chkTemperaturaSepEnable.setSelected(procesoAlarmas.isTemperaturaSepEnable());
        frmProcesoAlarmas.txtPresionGasSepMin.setText(Double.toString(procesoAlarmas.getPresionGasSepMin()));
        frmProcesoAlarmas.txtPresionGasSepMax.setText(Double.toString(procesoAlarmas.getPresionGasSepMax()));
        frmProcesoAlarmas.chkPresionGasSepEnable.setSelected(procesoAlarmas.isPresionGasSepEnable());
        frmProcesoAlarmas.txtTemperaturaGasSepMin.setText(Double.toString(procesoAlarmas.getTemperaturaGasSepMin()));
        frmProcesoAlarmas.txtTemperaturaGasSepMax.setText(Double.toString(procesoAlarmas.getTemperaturaGasSepMax()));
        frmProcesoAlarmas.chkTemperaturaGasSepEnable.setSelected(procesoAlarmas.isTemperaturaGasSepEnable());
        frmProcesoAlarmas.txtFlujoGasMin.setText(Double.toString(procesoAlarmas.getFlujoGasMin()));
        frmProcesoAlarmas.txtFlujoGasMax.setText(Double.toString(procesoAlarmas.getFlujoGasMax()));
        frmProcesoAlarmas.chkFlujoGasEnable.setSelected(procesoAlarmas.isFlujoGasEnable());
        frmProcesoAlarmas.txtPresionLineaMin.setText(Double.toString(procesoAlarmas.getPresionLineaMin()));
        frmProcesoAlarmas.txtPresionLineaMax.setText(Double.toString(procesoAlarmas.getPresionLineaMax()));
        frmProcesoAlarmas.chkPresionLineaEnable.setSelected(procesoAlarmas.isPresionLineaEnable());
        frmProcesoAlarmas.lblFecha.setText("Fecha: " + String.valueOf(procesoAlarmas.getFecha()));
        frmProcesoAlarmas.lblHora.setText("Hora: " + String.valueOf(procesoAlarmas.getHora()));
        frmProcesoAlarmas.chkPresionCabezaActive.setSelected(procesoAlarmas.isPresionCabezaActive());
        frmProcesoAlarmas.chkTemperaturaCabezaActive.setSelected(procesoAlarmas.isTemperaturaCabezaActive());
        frmProcesoAlarmas.chkPresionCasingActive.setSelected(procesoAlarmas.isPresionCasingActive());
        frmProcesoAlarmas.chkPresionChokeActive.setSelected(procesoAlarmas.isPresionChokeActive());
        frmProcesoAlarmas.chkFlujoDiluyenteActive.setSelected(procesoAlarmas.isFlujoDiluyenteActive());
        frmProcesoAlarmas.chkPresionMezcladorActive.setSelected(procesoAlarmas.isPresionMezcladorActive());
        frmProcesoAlarmas.chkFlujoAceiteSepActive.setSelected(procesoAlarmas.isFlujoAceiteSepActive());
        frmProcesoAlarmas.chkFlujoAguaSepActive.setSelected(procesoAlarmas.isFlujoAguaSepActive());
        frmProcesoAlarmas.chkPresionSepActive.setSelected(procesoAlarmas.isPresionSepActive());
        frmProcesoAlarmas.chkTemperaturaSepActive.setSelected(procesoAlarmas.isTemperaturaSepActive());
        frmProcesoAlarmas.chkPresionGasSepActive.setSelected(procesoAlarmas.isPresionGasSepActive());
        frmProcesoAlarmas.chkTemperaturaGasSepActive.setSelected(procesoAlarmas.isTemperaturaGasSepActive());
        frmProcesoAlarmas.chkFlujoGasActive.setSelected(procesoAlarmas.isFlujoGasActive());
        frmProcesoAlarmas.chkPresionLineaActive.setSelected(procesoAlarmas.isPresionLineaActive());

    }

    public void limpiar() {
        frmProcesoAlarmas.txtPresionCabezaMin.setText("0");
        frmProcesoAlarmas.txtPresionCabezaMax.setText("0");
        frmProcesoAlarmas.chkPresionCabezaEnable.setSelected(false);
        frmProcesoAlarmas.txtTemperaturaCabezaMin.setText("0");
        frmProcesoAlarmas.txtTemperaturaCabezaMax.setText("0");
        frmProcesoAlarmas.chkTemperaturaCabezaEnable.setSelected(false);
        frmProcesoAlarmas.txtPresionCasingMin.setText("0");
        frmProcesoAlarmas.txtPresionCasingMax.setText("0");
        frmProcesoAlarmas.chkPresionCasingEnable.setSelected(false);
        frmProcesoAlarmas.txtPresionChokeMin.setText("0");
        frmProcesoAlarmas.txtPresionChokeMax.setText("0");
        frmProcesoAlarmas.chkPresionChokeEnable.setSelected(false);
        frmProcesoAlarmas.txtFlujoDiluyenteMin.setText("0");
        frmProcesoAlarmas.txtFlujoDiluyenteMax.setText("0");
        frmProcesoAlarmas.chkFlujoDiluyenteEnable.setSelected(false);
        frmProcesoAlarmas.txtPresionMezcladorMin.setText("0");
        frmProcesoAlarmas.txtPresionMezcladorMax.setText("0");
        frmProcesoAlarmas.chkPresionMezcladorEnable.setSelected(false);
        frmProcesoAlarmas.txtFlujoAceiteSepMin.setText("0");
        frmProcesoAlarmas.txtFlujoAceiteSepMax.setText("0");
        frmProcesoAlarmas.chkFlujoAceiteSepEnable.setSelected(false);
        frmProcesoAlarmas.txtFlujoAguaSepMin.setText("0");
        frmProcesoAlarmas.txtFlujoAguaSepMax.setText("0");
        frmProcesoAlarmas.chkFlujoAguaSepEnable.setSelected(false);
        frmProcesoAlarmas.txtPresionSepMin.setText("0");
        frmProcesoAlarmas.txtPresionSepMax.setText("0");
        frmProcesoAlarmas.chkPresionSepEnable.setSelected(false);
        frmProcesoAlarmas.txtTemperaturaSepMin.setText("0");
        frmProcesoAlarmas.txtTemperaturaSepMax.setText("0");
        frmProcesoAlarmas.chkTemperaturaSepEnable.setSelected(false);
        frmProcesoAlarmas.txtPresionGasSepMin.setText("0");
        frmProcesoAlarmas.txtPresionGasSepMax.setText("0");
        frmProcesoAlarmas.chkPresionGasSepEnable.setSelected(false);
        frmProcesoAlarmas.txtTemperaturaGasSepMin.setText("0");
        frmProcesoAlarmas.txtTemperaturaGasSepMax.setText("0");
        frmProcesoAlarmas.chkTemperaturaGasSepEnable.setSelected(false);
        frmProcesoAlarmas.txtFlujoGasMin.setText("0");
        frmProcesoAlarmas.txtFlujoGasMax.setText("0");
        frmProcesoAlarmas.chkFlujoGasEnable.setSelected(false);
        frmProcesoAlarmas.txtPresionLineaMin.setText("0");
        frmProcesoAlarmas.txtPresionLineaMax.setText("0");
        frmProcesoAlarmas.chkPresionLineaEnable.setSelected(false);
        frmProcesoAlarmas.lblFecha.setText("-");
        frmProcesoAlarmas.lblHora.setText("-");
        frmProcesoAlarmas.chkPresionCabezaActive.setSelected(false);
        frmProcesoAlarmas.chkTemperaturaCabezaActive.setSelected(false);
        frmProcesoAlarmas.chkPresionCasingActive.setSelected(false);
        frmProcesoAlarmas.chkPresionChokeActive.setSelected(false);
        frmProcesoAlarmas.chkFlujoDiluyenteActive.setSelected(false);
        frmProcesoAlarmas.chkPresionMezcladorActive.setSelected(false);
        frmProcesoAlarmas.chkFlujoAceiteSepActive.setSelected(false);
        frmProcesoAlarmas.chkFlujoAguaSepActive.setSelected(false);
        frmProcesoAlarmas.chkPresionSepActive.setSelected(false);
        frmProcesoAlarmas.chkTemperaturaSepActive.setSelected(false);
        frmProcesoAlarmas.chkPresionGasSepActive.setSelected(false);
        frmProcesoAlarmas.chkTemperaturaGasSepActive.setSelected(false);
        frmProcesoAlarmas.chkFlujoGasActive.setSelected(false);
        frmProcesoAlarmas.chkPresionLineaActive.setSelected(false);
    }

    public void checkeoVariables() {
        if (frmProcesoAlarmas.chkPresionCabezaActive.isSelected()) {
            frmProcesoAlarmas.txtPresionCabezaMin.setEnabled(true);
            frmProcesoAlarmas.txtPresionCabezaMax.setEnabled(true);
            frmProcesoAlarmas.chkPresionCabezaEnable.setEnabled(true);
        } else {
            frmProcesoAlarmas.txtPresionCabezaMin.setEnabled(false);
            frmProcesoAlarmas.txtPresionCabezaMax.setEnabled(false);
            frmProcesoAlarmas.chkPresionCabezaEnable.setEnabled(false);
            frmProcesoAlarmas.chkPresionCabezaEnable.setSelected(false);
        }
        if (frmProcesoAlarmas.chkTemperaturaCabezaActive.isSelected()) {
            frmProcesoAlarmas.txtTemperaturaCabezaMin.setEnabled(true);
            frmProcesoAlarmas.txtTemperaturaCabezaMax.setEnabled(true);
            frmProcesoAlarmas.chkTemperaturaCabezaEnable.setEnabled(true);
        } else {
            frmProcesoAlarmas.txtTemperaturaCabezaMin.setEnabled(false);
            frmProcesoAlarmas.txtTemperaturaCabezaMax.setEnabled(false);
            frmProcesoAlarmas.chkTemperaturaCabezaEnable.setEnabled(false);
            frmProcesoAlarmas.chkTemperaturaCabezaEnable.setSelected(false);
        }
        if (frmProcesoAlarmas.chkPresionCasingActive.isSelected()) {
            frmProcesoAlarmas.txtPresionCasingMin.setEnabled(true);
            frmProcesoAlarmas.txtPresionCasingMax.setEnabled(true);
            frmProcesoAlarmas.chkPresionCasingEnable.setEnabled(true);
        } else {
            frmProcesoAlarmas.txtPresionCasingMin.setEnabled(false);
            frmProcesoAlarmas.txtPresionCasingMax.setEnabled(false);
            frmProcesoAlarmas.chkPresionCasingEnable.setEnabled(false);
            frmProcesoAlarmas.chkPresionCasingEnable.setSelected(false);
        }
        if (frmProcesoAlarmas.chkPresionChokeActive.isSelected()) {
            frmProcesoAlarmas.txtPresionChokeMin.setEnabled(true);
            frmProcesoAlarmas.txtPresionChokeMax.setEnabled(true);
            frmProcesoAlarmas.chkPresionChokeEnable.setEnabled(true);
        } else {
            frmProcesoAlarmas.txtPresionChokeMin.setEnabled(false);
            frmProcesoAlarmas.txtPresionChokeMax.setEnabled(false);
            frmProcesoAlarmas.chkPresionChokeEnable.setEnabled(false);
            frmProcesoAlarmas.chkPresionChokeEnable.setSelected(false);
        }
        if (frmProcesoAlarmas.chkFlujoDiluyenteActive.isSelected()) {
            frmProcesoAlarmas.txtFlujoDiluyenteMin.setEnabled(true);
            frmProcesoAlarmas.txtFlujoDiluyenteMax.setEnabled(true);
            frmProcesoAlarmas.chkFlujoDiluyenteEnable.setEnabled(true);
        } else {
            frmProcesoAlarmas.txtFlujoDiluyenteMin.setEnabled(false);
            frmProcesoAlarmas.txtFlujoDiluyenteMax.setEnabled(false);
            frmProcesoAlarmas.chkFlujoDiluyenteEnable.setEnabled(false);
            frmProcesoAlarmas.chkFlujoDiluyenteEnable.setSelected(false);
        }
        if (frmProcesoAlarmas.chkPresionMezcladorActive.isSelected()) {
            frmProcesoAlarmas.txtPresionMezcladorMin.setEnabled(true);
            frmProcesoAlarmas.txtPresionMezcladorMax.setEnabled(true);
            frmProcesoAlarmas.chkPresionMezcladorEnable.setEnabled(true);
        } else {
            frmProcesoAlarmas.txtPresionMezcladorMin.setEnabled(false);
            frmProcesoAlarmas.txtPresionMezcladorMax.setEnabled(false);
            frmProcesoAlarmas.chkPresionMezcladorEnable.setEnabled(false);
            frmProcesoAlarmas.chkPresionMezcladorEnable.setSelected(false);
        }
        if (frmProcesoAlarmas.chkPresionSepActive.isSelected()) {
            frmProcesoAlarmas.txtPresionSepMin.setEnabled(true);
            frmProcesoAlarmas.txtPresionSepMax.setEnabled(true);
            frmProcesoAlarmas.chkPresionSepEnable.setEnabled(true);
        } else {
            frmProcesoAlarmas.txtPresionSepMin.setEnabled(false);
            frmProcesoAlarmas.txtPresionSepMax.setEnabled(false);
            frmProcesoAlarmas.chkPresionSepEnable.setEnabled(false);
            frmProcesoAlarmas.chkPresionSepEnable.setSelected(false);
        }
        if (frmProcesoAlarmas.chkTemperaturaSepActive.isSelected()) {
            frmProcesoAlarmas.txtTemperaturaSepMin.setEnabled(true);
            frmProcesoAlarmas.txtTemperaturaSepMax.setEnabled(true);
            frmProcesoAlarmas.chkTemperaturaSepEnable.setEnabled(true);
        } else {
            frmProcesoAlarmas.txtTemperaturaSepMin.setEnabled(false);
            frmProcesoAlarmas.txtTemperaturaSepMax.setEnabled(false);
            frmProcesoAlarmas.chkTemperaturaSepEnable.setEnabled(false);
            frmProcesoAlarmas.chkTemperaturaSepEnable.setSelected(false);
        }
        if (frmProcesoAlarmas.chkFlujoAceiteSepActive.isSelected()) {
            frmProcesoAlarmas.txtFlujoAceiteSepMin.setEnabled(true);
            frmProcesoAlarmas.txtFlujoAceiteSepMax.setEnabled(true);
            frmProcesoAlarmas.chkFlujoAceiteSepEnable.setEnabled(true);
        } else {
            frmProcesoAlarmas.txtFlujoAceiteSepMin.setEnabled(false);
            frmProcesoAlarmas.txtFlujoAceiteSepMax.setEnabled(false);
            frmProcesoAlarmas.chkFlujoAceiteSepEnable.setEnabled(false);
            frmProcesoAlarmas.chkFlujoAceiteSepEnable.setSelected(false);
        }
        if (frmProcesoAlarmas.chkFlujoAguaSepActive.isSelected()) {
            frmProcesoAlarmas.txtFlujoAguaSepMin.setEnabled(true);
            frmProcesoAlarmas.txtFlujoAguaSepMax.setEnabled(true);
            frmProcesoAlarmas.chkFlujoAguaSepEnable.setEnabled(true);
        } else {
            frmProcesoAlarmas.txtFlujoAguaSepMin.setEnabled(false);
            frmProcesoAlarmas.txtFlujoAguaSepMax.setEnabled(false);
            frmProcesoAlarmas.chkFlujoAguaSepEnable.setEnabled(false);
            frmProcesoAlarmas.chkFlujoAguaSepEnable.setSelected(false);
        }
        if (frmProcesoAlarmas.chkPresionGasSepActive.isSelected()) {
            frmProcesoAlarmas.txtPresionGasSepMin.setEnabled(true);
            frmProcesoAlarmas.txtPresionGasSepMax.setEnabled(true);
            frmProcesoAlarmas.chkPresionGasSepEnable.setEnabled(true);
        } else {
            frmProcesoAlarmas.txtPresionGasSepMin.setEnabled(false);
            frmProcesoAlarmas.txtPresionGasSepMax.setEnabled(false);
            frmProcesoAlarmas.chkPresionGasSepEnable.setEnabled(false);
            frmProcesoAlarmas.chkPresionGasSepEnable.setSelected(false);
        }
        if (frmProcesoAlarmas.chkTemperaturaGasSepActive.isSelected()) {
            frmProcesoAlarmas.txtTemperaturaGasSepMin.setEnabled(true);
            frmProcesoAlarmas.txtTemperaturaGasSepMax.setEnabled(true);
            frmProcesoAlarmas.chkTemperaturaGasSepEnable.setEnabled(true);
        } else {
            frmProcesoAlarmas.txtTemperaturaGasSepMin.setEnabled(false);
            frmProcesoAlarmas.txtTemperaturaGasSepMax.setEnabled(false);
            frmProcesoAlarmas.chkTemperaturaGasSepEnable.setEnabled(false);
            frmProcesoAlarmas.chkTemperaturaGasSepEnable.setSelected(false);
        }
        if (frmProcesoAlarmas.chkFlujoGasActive.isSelected()) {
            frmProcesoAlarmas.txtFlujoGasMin.setEnabled(true);
            frmProcesoAlarmas.txtFlujoGasMax.setEnabled(true);
            frmProcesoAlarmas.chkFlujoGasEnable.setEnabled(true);
        } else {
            frmProcesoAlarmas.txtFlujoGasMin.setEnabled(false);
            frmProcesoAlarmas.txtFlujoGasMax.setEnabled(false);
            frmProcesoAlarmas.chkFlujoGasEnable.setEnabled(false);
            frmProcesoAlarmas.chkFlujoGasEnable.setSelected(false);
        }
        if (frmProcesoAlarmas.chkPresionLineaActive.isSelected()) {
            frmProcesoAlarmas.txtPresionLineaMin.setEnabled(true);
            frmProcesoAlarmas.txtPresionLineaMax.setEnabled(true);
            frmProcesoAlarmas.chkPresionLineaEnable.setEnabled(true);
        } else {
            frmProcesoAlarmas.txtPresionLineaMin.setEnabled(false);
            frmProcesoAlarmas.txtPresionLineaMax.setEnabled(false);
            frmProcesoAlarmas.chkPresionLineaEnable.setEnabled(false);
            frmProcesoAlarmas.chkPresionLineaEnable.setSelected(false);
        }
    }

    public void cargarInformacion() {
        //ejecutar consultas en base de datos y asigna a la ventana
        try {
            if (procesoAlarmasC.buscarAlarmas(procesoAlarmas)) {
                this.asignacionTextBox();
            } else {
                this.limpiar();
            }
        } catch (SQLException ex) {
            System.err.println("No hay datos relacionados error: " + ex);
        }
        this.checkeoVariables();
        this.frmProcesoAlarmas.btnAceptar.setEnabled(true);
        this.frmProcesoAlarmas.btnBorrar.setEnabled(true);
    }
}

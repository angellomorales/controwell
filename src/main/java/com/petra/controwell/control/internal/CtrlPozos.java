package com.petra.controwell.control.internal;

import com.mxrck.autocompleter.TextAutoCompleter;
import com.petra.controwell.model.data.WellInfo;
import com.petra.controwell.model.data.querys.ConsultasWellInfo;
import com.petra.controwell.model.utilities.Utilities;
import com.petra.controwell.view.internal.FrmBalance;
import com.petra.controwell.view.internal.FrmEditarProceso;
import com.petra.controwell.view.internal.FrmGraficas;
import com.petra.controwell.view.internal.FrmOperacionTk;
import com.petra.controwell.view.internal.FrmPozos;
import com.petra.controwell.view.internal.FrmProceso;
import com.petra.controwell.view.internal.FrmProcesoAlarmas;
import com.petra.controwell.view.internal.FrmReporte;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Angello Morales
 */
public class CtrlPozos implements ActionListener {

    //vista
    public FrmPozos frmPozos;
    public FrmProceso frmProceso;
    public FrmProcesoAlarmas frmProcesoAlarmas;
    public FrmOperacionTk frmOperacionTk;
    public FrmBalance frmBalance;
    public FrmGraficas frmGraficas;
    public FrmEditarProceso frmEditarProceso;

    //modelo BD
    public WellInfo wellinfo;
    public ConsultasWellInfo wellinfoC;

    //modelo
    //controlador
    public Utilities ctrlUtilities;
    //variables
    private final TextAutoCompleter autocompletarPozo;

    public CtrlPozos(FrmPozos frmPozos, FrmProceso frmProceso, FrmProcesoAlarmas frmProcesoAlarmas,FrmOperacionTk frmOperacionTk,FrmBalance frmBalance,FrmGraficas frmGraficas,FrmEditarProceso frmEditarProceso, WellInfo wellinfo, ConsultasWellInfo wellinfoC,Utilities ctrlUtilities) {
        this.frmPozos = frmPozos;
        this.wellinfo = wellinfo;
        this.wellinfoC = wellinfoC;
        this.frmProceso = frmProceso;
        this.frmProcesoAlarmas=frmProcesoAlarmas;
        this.frmOperacionTk= frmOperacionTk;
        this.frmBalance=frmBalance;
        this.frmGraficas= frmGraficas;
        this.frmEditarProceso= frmEditarProceso;
        this.ctrlUtilities=ctrlUtilities;

        //agregar listener a los botones dentro del constructor
        this.frmPozos.btnBuscar.addActionListener(this);
        this.frmPozos.btnAgregar.addActionListener(this);
        this.frmPozos.btnModificar.addActionListener(this);
        this.frmPozos.btnEliminar.addActionListener(this);
        this.frmPozos.btnCerrar.addActionListener(this);

        //instanciar librerias
        this.autocompletarPozo = new TextAutoCompleter(this.frmPozos.txtIdPozo);

    }

    public void iniciar() throws PropertyVetoException {
        frmPozos.setTitle("Edición de Pozos");
        frmPozos.btnModificar.setEnabled(false);
        frmPozos.btnEliminar.setEnabled(false);
        frmPozos.btnAgregar.setEnabled(false);
        frmPozos.setVisible(true);
        frmPozos.toFront();
        frmPozos.setSelected(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //acciones a ejecutar cuando se presiona un elemento en la pantalla 
        //if por cada elemento para detectar cual se presiono
        //--------------Agregar--------------
        if (e.getSource() == frmPozos.btnAgregar) {
            // cargar datos al modelo si es necesario(cajas de texto etc...)
            wellinfo.setIdPozo(ctrlUtilities.VerificarTextFieldNull(frmPozos.txtIdPozo));
            wellinfo.setUbicacion(ctrlUtilities.VerificarTextFieldNull(frmPozos.txtUbicacion));
            wellinfo.setOperadora(ctrlUtilities.VerificarTextFieldNull(frmPozos.txtOperadora));
            wellinfo.setComentarios(frmPozos.txtAComentarios.getText());

            //ejecutar consultas en base de datos y asigna a la ventana
            try {
                if (wellinfoC.agregarPozo(wellinfo)) {
                    JOptionPane.showMessageDialog(null, "Registro guardado");
                    this.actualizarListado();
                } else {
                    JOptionPane.showMessageDialog(null, "No se agregó registro");
                }
            } catch (SQLException ex) {
                System.err.println("Error al guardar: " + ex);
            }

        }
        //--------------Modificar--------------
        if (e.getSource() == frmPozos.btnModificar) {
            // cargar datos al modelo si es necesario(cajas de texto etc...)
            wellinfo.setIdPozo(ctrlUtilities.VerificarTextFieldNull(frmPozos.txtIdPozo));
            wellinfo.setUbicacion(ctrlUtilities.VerificarTextFieldNull(frmPozos.txtUbicacion));
            wellinfo.setOperadora(ctrlUtilities.VerificarTextFieldNull(frmPozos.txtOperadora));
            wellinfo.setComentarios(frmPozos.txtAComentarios.getText());

            //ejecutar consultas en base de datos y asigna a la ventana
            try {
                if (wellinfoC.modificarPozo(wellinfo)) {
                    JOptionPane.showMessageDialog(null, "Registro modificado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al modificar");
                }
            } catch (SQLException ex) {
                System.err.println("Error al modificar: " + ex);
            }
        }
        //--------------Eliminar--------------
        if (e.getSource() == frmPozos.btnEliminar) {
            // cargar datos al modelo si es necesario(cajas de texto etc...)
            wellinfo.setIdPozo(frmPozos.txtIdPozo.getText());

            //ejecutar consultas en base de datos y asigna a la ventana
            try {
                if (wellinfoC.eliminarPozo(wellinfo)) {
                    JOptionPane.showMessageDialog(null, "Registro Eliminado");
                    this.limpiar();
                    this.actualizarListado();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar");
                }
            } catch (SQLException ex) {
                System.err.println("Error al eliminar: " + ex);
            }
        }
        //--------------Buscar--------------
        if (e.getSource() == frmPozos.btnBuscar) {
            // cargar datos al modelo si es necesario(cajas de texto etc...)
            wellinfo.setIdPozo(frmPozos.txtIdPozo.getText());

            //ejecutar consultas en base de datos y asigna a la ventana
            try {
                if (wellinfoC.buscarPozos(wellinfo)) {
                    frmPozos.txtOperadora.setText(wellinfo.getOperadora());
                    frmPozos.txtUbicacion.setText(wellinfo.getUbicacion());
                    frmPozos.txtAComentarios.setText(wellinfo.getComentarios());
                    frmPozos.btnModificar.setEnabled(true);
                    frmPozos.btnEliminar.setEnabled(true);
                } else {
                    frmPozos.btnAgregar.setEnabled(true);
                }
            } catch (SQLException ex) {
                System.err.println("Error al buscar: " + ex);
            }
        }
        //--------------cerrar--------------
        if (e.getSource() == frmPozos.btnCerrar) {
            this.frmPozos.hide();
            this.limpiar();
        }
    }

    public void limpiar() {
        frmPozos.txtIdPozo.setText(null);
        frmPozos.txtUbicacion.setText(null);
        frmPozos.txtOperadora.setText(null);
        frmPozos.txtAComentarios.setText(null);
        frmPozos.btnModificar.setEnabled(false);
        frmPozos.btnEliminar.setEnabled(false);
        frmPozos.btnAgregar.setEnabled(false);
    }

    public ArrayList ListarPozos() throws SQLException {
    	ArrayList listado;
        listado = wellinfoC.listarPozos();
        return listado;
    }

    public void actualizarListado() {
        try {
            actualizarCombos(ListarPozos());
        } catch (SQLException ex) {
            System.err.println("Error al Listar: " + ex);
        }
    }

    public void actualizarCombos(ArrayList lista) {
        frmProceso.cmbxIdPozo.removeAllItems();
        frmProcesoAlarmas.cmbxIdPozo.removeAllItems();
        frmOperacionTk.cmbxIdPozo.removeAllItems();
        frmBalance.cmbxIdPozo.removeAllItems();
        frmGraficas.cmbxIdPozo.removeAllItems();
        frmEditarProceso.cmbxIdPozo.removeAllItems();
        this.autocompletarPozo.removeAllItems();
        lista.forEach((object) -> {
            frmProceso.cmbxIdPozo.addItem(object.toString());
            frmProcesoAlarmas.cmbxIdPozo.addItem(object.toString());
            frmOperacionTk.cmbxIdPozo.addItem(object.toString());
            frmBalance.cmbxIdPozo.addItem(object.toString());
            frmGraficas.cmbxIdPozo.addItem(object.toString());
            frmEditarProceso.cmbxIdPozo.addItem(object.toString());
            autocompletarPozo.addItem(object.toString());
        });
    }
}

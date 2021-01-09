package com.petra.controwell.control.internal;

import com.mxrck.autocompleter.TextAutoCompleter;
import com.petra.controwell.model.data.Tanques;
import com.petra.controwell.model.data.querys.ConsultasTanques;
import com.petra.controwell.model.utilities.Utilities;
import com.petra.controwell.view.internal.FrmAforoTk;
import com.petra.controwell.view.internal.FrmOperacionTk;
import com.petra.controwell.view.internal.FrmTanques;

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
public class CtrlTanques implements ActionListener {

    //vista
    public FrmTanques frmTanques;
    public FrmAforoTk frmAforoTk;
    public FrmOperacionTk frmOperacionTk;

    //modelo BD
    public Tanques tanques;
    public ConsultasTanques tanquesC;

    //modelo
    //controlador
    public Utilities ctrlUtilities;
    //variables
    private ArrayList listado = new ArrayList();
    private final TextAutoCompleter autocompletarPozo;

    public CtrlTanques(FrmTanques frmTanques, FrmAforoTk frmAforoTk, FrmOperacionTk frmOperacionTk, Tanques tanques, ConsultasTanques tanquesC, Utilities ctrlUtilities) {
        this.frmTanques = frmTanques;
        this.tanques = tanques;
        this.tanquesC = tanquesC;
        this.frmAforoTk = frmAforoTk;
        this.frmOperacionTk = frmOperacionTk;
        this.ctrlUtilities=ctrlUtilities;

        //agregar listener a los botones dentro del constructor
        this.frmTanques.btnBuscar.addActionListener(this);
        this.frmTanques.btnAgregar.addActionListener(this);
        this.frmTanques.btnModificar.addActionListener(this);
        this.frmTanques.btnEliminar.addActionListener(this);
        this.frmTanques.btnCerrar.addActionListener(this);

        //instanciar librerias
        this.autocompletarPozo = new TextAutoCompleter(this.frmTanques.txtIdTanques);

    }

    public void iniciar() throws PropertyVetoException {
        frmTanques.setTitle("Edición de Tanques");
        frmTanques.btnModificar.setEnabled(false);
        frmTanques.btnEliminar.setEnabled(false);
        frmTanques.btnAgregar.setEnabled(false);
        frmTanques.setVisible(true);
        frmTanques.toFront();
        frmTanques.setSelected(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //acciones a ejecutar cuando se presiona un elemento en la pantalla 
        //if por cada elemento para detectar cual se presiono
        //--------------Agregar--------------
        if (e.getSource() == frmTanques.btnAgregar) {
            // cargar datos al modelo si es necesario(cajas de texto etc...)
            tanques.setIdTanque(ctrlUtilities.VerificarTextFieldNull(frmTanques.txtIdTanques));
            tanques.setCapacidad(Integer.parseInt(ctrlUtilities.VerificarTextField(frmTanques.txtCapacidad)));
            if (frmTanques.rdbtnCrudo.isSelected()) {
                tanques.setTipoFluido("crudo");
            }
            if (frmTanques.rdbtnRefinado.isSelected()) {
                tanques.setTipoFluido("refinado");
            }
            if (frmTanques.rdbtnLubricante.isSelected()) {
                tanques.setTipoFluido("lubricante");
            }

            //ejecutar consultas en base de datos y asigna a la ventana
            try {
                if (tanquesC.agregarTanque(tanques)) {
                    JOptionPane.showMessageDialog(null, "Registro guardado");
                    this.actualizarListado();
                } else {
                    JOptionPane.showMessageDialog(null, "No se agrego registro");
                }
            } catch (SQLException ex) {
                System.err.println("Error al guardar: " + ex);
            }

        }
        //--------------Modificar--------------
        if (e.getSource() == frmTanques.btnModificar) {
            // cargar datos al modelo si es necesario(cajas de texto etc...)
            tanques.setIdTanque(frmTanques.txtIdTanques.getText());
            tanques.setCapacidad(Integer.parseInt(frmTanques.txtCapacidad.getText()));
            if (frmTanques.rdbtnCrudo.isSelected()) {
                tanques.setTipoFluido("crudo");
            }
            if (frmTanques.rdbtnRefinado.isSelected()) {
                tanques.setTipoFluido("refinado");
            }
            if (frmTanques.rdbtnLubricante.isSelected()) {
                tanques.setTipoFluido("lubricante");
            }

            //ejecutar consultas en base de datos y asigna a la ventana
            try {
                if (tanquesC.modificarTanques(tanques)) {
                    JOptionPane.showMessageDialog(null, "Registro modificado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al modificar");
                }
            } catch (SQLException ex) {
                System.err.println("Error al modificar: " + ex);
            }
        }
        //--------------Eliminar--------------
        if (e.getSource() == frmTanques.btnEliminar) {
            // cargar datos al modelo si es necesario(cajas de texto etc...)
            tanques.setIdTanque(frmTanques.txtIdTanques.getText());

            //ejecutar consultas en base de datos y asigna a la ventana
            try {
                if (tanquesC.eliminarTanque(tanques)) {
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
        if (e.getSource() == frmTanques.btnBuscar) {
            // cargar datos al modelo si es necesario(cajas de texto etc...)
            tanques.setIdTanque(frmTanques.txtIdTanques.getText());

            //ejecutar consultas en base de datos y asigna a la ventana
            try {
                if (tanquesC.buscarTanques(tanques)) {
                    frmTanques.txtCapacidad.setText(String.valueOf(tanques.getCapacidad()));
                    if ("crudo".equals(tanques.getTipoFluido())) {
                        frmTanques.rdbtnCrudo.setSelected(true);
                    }
                    if ("refinado".equals(tanques.getTipoFluido())) {
                        frmTanques.rdbtnRefinado.setSelected(true);
                    }
                    if ("lubricante".equals(tanques.getTipoFluido())) {
                        frmTanques.rdbtnLubricante.setSelected(true);
                    }
                    frmTanques.btnModificar.setEnabled(true);
                    frmTanques.btnEliminar.setEnabled(true);
                } else {
                    frmTanques.btnAgregar.setEnabled(true);
                }
            } catch (SQLException ex) {
                System.err.println("Error al buscar: " + ex);
            }
        }
        //--------------cerrar--------------
        if (e.getSource() == frmTanques.btnCerrar) {
            this.frmTanques.hide();
            this.limpiar();
        }
    }

    public void limpiar() {
        frmTanques.txtIdTanques.setText(null);
        frmTanques.txtCapacidad.setText(null);
        frmTanques.btnModificar.setEnabled(false);
        frmTanques.btnEliminar.setEnabled(false);
        frmTanques.btnAgregar.setEnabled(false);
    }

    public ArrayList getListado() {
        return listado;
    }

    public void setListado(ArrayList listado) {
        this.listado = listado;
    }

    public void actualizarListado() {
        try {
            if (!this.tanquesC.listarTanques().isEmpty()) {
                setListado(tanquesC.listarTanques());
                actualizarCombos(getListado());
            }
        } catch (SQLException ex) {
            System.err.println("Error al Listar: " + ex);
        }
    }

    public void actualizarCombos(ArrayList lista) {
        frmAforoTk.cmbxIdTanque.removeAllItems();
        frmOperacionTk.cmbxIdTanque.removeAllItems();
        this.autocompletarPozo.removeAllItems();
        lista.forEach((object) -> {
            frmAforoTk.cmbxIdTanque.addItem(object.toString());
            frmOperacionTk.cmbxIdTanque.addItem(object.toString());
            autocompletarPozo.addItem(object.toString());
        });
    }
}

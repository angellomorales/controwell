package com.petra.controwell.control.internal;

import com.petra.controwell.model.SeriesGrafica;
import com.petra.controwell.model.data.ProcesoAlarmas;
import com.petra.controwell.model.data.querys.ConsultasProcesoAlarmas;
import com.petra.controwell.model.utilities.Utilities;
import com.petra.controwell.view.internal.FrmSeries;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Angello Morales
 */
public class CtrlSeries implements ActionListener {

    //vista
    public FrmSeries frmSeries;

    //modelo BD
    //modelo
    //controlador
    public Utilities ctrlUtilities;
    public CtrlGraficas ctrlGraficas;

    //variables
    public boolean ejePrincipal;
    public String tituloEjePrincipal;
    public String tituloEjeSecundario;
    private final boolean DESHABILITAR = true;
    private final boolean HABILITAR = false;
    //listado paneles
    public final int PANEL_PRESION = 1;
    public final int PANEL_TEMPERATURA = 2;
    public final int PANEL_FLUJO = 3;
    public final int PANEL_PRODUCCION_VOLUMEN = 4;
    public final int PANEL_PRESION_INH2O = 5;
    public final int PANEL_PRODUCCION_GAS = 6;
    public final int PANEL_PRODUCCION_SYW = 7;
    public final int PANEL_PRODUCCION_HORAS = 8;
    //listado Claves
    private final int CLAVE_PRESION_CABEZA = 1;
    private final int CLAVE_PRESION_CASING = 2;
    private final int CLAVE_PRESION_CHOKE = 3;
    private final int CLAVE_PRESION_SEPARADOR = 4;
    private final int CLAVE_PRESION_LINEA = 5;
    private final int CLAVE_PRESION_GAS = 6;
    private final int CLAVE_PRESION_MEZCLADOR = 7;
    private final int CLAVE_TEMPERATURA_CABEZA = 8;
    private final int CLAVE_TEMPERATURA_GAS = 9;
    private final int CLAVE_TEMPERATURA_SEPARADOR = 10;
    private final int CLAVE_FLUJO_ACEITE = 11;
    private final int CLAVE_FLUJO_AGUA = 12;
    private final int CLAVE_FLUJO_GAS = 13;
    private final int CLAVE_FLUJO_DILUYENTE = 14;
    private final int CLAVE_PRODUCCION_ACEITE = 15;
    private final int CLAVE_PRODUCCION_AGUA = 16;
    private final int CLAVE_PRODUCCION_DILUYENTE_INYECTADO = 17;
    private final int CLAVE_PRODUCCION_NSV_CON_DILUYENTE = 18;
    private final int CLAVE_PRODUCCION_SYW = 19;
    private final int CLAVE_PRODUCCION_GAS_PRODUCIDO = 20;
    private final int CLAVE_PRODUCCION_HORAS = 21;
    //arrays
    private Map<Integer, SeriesGrafica> arrayMapSeries = new TreeMap<>();

    public CtrlSeries(FrmSeries frmSeries, Utilities ctrlUtilities, CtrlGraficas ctrlGraficas) {
        this.frmSeries = frmSeries;
        this.ctrlUtilities = ctrlUtilities;
        this.ctrlGraficas = ctrlGraficas;

        //agregar listener a los botones dentro del constructor
        this.frmSeries.btnAceptar.addActionListener(this);
        this.frmSeries.chkPresionCabeza.addActionListener(this);
        this.frmSeries.chkPresionCasing.addActionListener(this);
        this.frmSeries.chkPresionChoke.addActionListener(this);
        this.frmSeries.chkPresionSeparador.addActionListener(this);
        this.frmSeries.chkPresionLinea.addActionListener(this);
        this.frmSeries.chkPresionGas.addActionListener(this);
        this.frmSeries.chkPresionMezclador.addActionListener(this);
        this.frmSeries.chkTemperaturaCabeza.addActionListener(this);
        this.frmSeries.chkTemperaturaGas.addActionListener(this);
        this.frmSeries.chkTemperaturaSeparador.addActionListener(this);
        this.frmSeries.chkFlujoAceite.addActionListener(this);
        this.frmSeries.chkFlujoAgua.addActionListener(this);
        this.frmSeries.chkFlujoGas.addActionListener(this);
        this.frmSeries.chkFlujoDiluyente.addActionListener(this);
        this.frmSeries.chkAceiteProducido.addActionListener(this);
        this.frmSeries.chkAguaProducida.addActionListener(this);
        this.frmSeries.chkDiluyenteInyectado.addActionListener(this);
        this.frmSeries.chkNSVconDiluyente.addActionListener(this);
        this.frmSeries.chkSYW.addActionListener(this);
        this.frmSeries.chkGasProducido.addActionListener(this);
        this.frmSeries.chkHoras.addActionListener(this);

        //instanciar librerias
    }

    public void iniciar(boolean usarEjePrincipal) throws PropertyVetoException {
        frmSeries.setTitle("Selección de Variables");
        frmSeries.setVisible(true);
        frmSeries.toFront();
        frmSeries.setSelected(true);

        this.setEjePrincipal(usarEjePrincipal);
        this.verificarActivadosAnteriormente(usarEjePrincipal);
        arrayMapSeries.put(0, new SeriesGrafica("fecha", "Fecha", isEjePrincipal()));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //acciones a ejecutar cuando se presiona un elemento en la pantalla 
        //if por cada elemento para detectar cual se presiono
        //--------------Agregar--------------
        if (e.getSource() == frmSeries.btnAceptar) {
            this.frmSeries.hide();
            this.ctrlGraficas.habilitarBtnGraficar();
        }

        //--------------checkbox--------------
        if (e.getSource() == frmSeries.chkPresionCabeza) {
            int clave = CLAVE_PRESION_CABEZA;
            int panel = PANEL_PRESION;
            String columnaBD = "presionCabeza";
            String tituloSerie = "Presion Cabeza";
            this.asignarChkbox(frmSeries.chkPresionCabeza, clave, panel, columnaBD, tituloSerie);
        }
        if (e.getSource() == frmSeries.chkPresionCasing) {
            int clave = CLAVE_PRESION_CASING;
            int panel = PANEL_PRESION;
            String columnaBD = "presionCasing";
            String tituloSerie = "Presion Casing";
            this.asignarChkbox(frmSeries.chkPresionCasing, clave, panel, columnaBD, tituloSerie);
        }
        if (e.getSource() == frmSeries.chkPresionChoke) {
            int clave = CLAVE_PRESION_CHOKE;
            int panel = PANEL_PRESION;
            String columnaBD = "presionChoke";
            String tituloSerie = "Presion Choke";
            this.asignarChkbox(frmSeries.chkPresionChoke, clave, panel, columnaBD, tituloSerie);
        }
        if (e.getSource() == frmSeries.chkPresionSeparador) {
            int clave = CLAVE_PRESION_SEPARADOR;
            int panel = PANEL_PRESION;
            String columnaBD = "presionSep";
            String tituloSerie = "Presion Separador";
            this.asignarChkbox(frmSeries.chkPresionSeparador, clave, panel, columnaBD, tituloSerie);
        }
        if (e.getSource() == frmSeries.chkPresionLinea) {
            int clave = CLAVE_PRESION_LINEA;
            ;
            int panel = PANEL_PRESION;
            String columnaBD = "presionLinea";
            String tituloSerie = "Presion Linea";
            this.asignarChkbox(frmSeries.chkPresionLinea, clave, panel, columnaBD, tituloSerie);
        }
        if (e.getSource() == frmSeries.chkPresionGas) {
            int clave = CLAVE_PRESION_GAS;
            int panel = PANEL_PRESION_INH2O;
            String columnaBD = "presionGasSep";
            String tituloSerie = "Presion Gas";
            this.asignarChkbox(frmSeries.chkPresionGas, clave, panel, columnaBD, tituloSerie);
        }
        if (e.getSource() == frmSeries.chkPresionMezclador) {
            int clave = CLAVE_PRESION_MEZCLADOR;
            int panel = PANEL_PRESION_INH2O;
            String columnaBD = "presionMezclador";
            String tituloSerie = "Presion Mezclador";
            this.asignarChkbox(frmSeries.chkPresionMezclador, clave, panel, columnaBD, tituloSerie);
        }
        if (e.getSource() == frmSeries.chkTemperaturaCabeza) {
            int clave = CLAVE_TEMPERATURA_CABEZA;
            int panel = PANEL_TEMPERATURA;
            String columnaBD = "temperaturaCabeza";
            String tituloSerie = "Temperatura Cabeza";
            this.asignarChkbox(frmSeries.chkTemperaturaCabeza, clave, panel, columnaBD, tituloSerie);
        }
        if (e.getSource() == frmSeries.chkTemperaturaGas) {
            int clave = CLAVE_TEMPERATURA_GAS;
            int panel = PANEL_TEMPERATURA;
            String columnaBD = "temperaturaGasSep";
            String tituloSerie = "Temperatura Gas";
            this.asignarChkbox(frmSeries.chkTemperaturaGas, clave, panel, columnaBD, tituloSerie);
        }
        if (e.getSource() == frmSeries.chkTemperaturaSeparador) {
            int clave = CLAVE_TEMPERATURA_SEPARADOR;
            int panel = PANEL_TEMPERATURA;
            String columnaBD = "temperaturaSep";
            String tituloSerie = "Temperatura Separador";
            this.asignarChkbox(frmSeries.chkTemperaturaSeparador, clave, panel, columnaBD, tituloSerie);
        }
        if (e.getSource() == frmSeries.chkFlujoAceite) {
            int clave = CLAVE_FLUJO_ACEITE;
            int panel = PANEL_FLUJO;
            String columnaBD = "flujoAceiteSep";
            String tituloSerie = "Flujo Aceite";
            this.asignarChkbox(frmSeries.chkFlujoAceite, clave, panel, columnaBD, tituloSerie);
        }
        if (e.getSource() == frmSeries.chkFlujoAgua) {
            int clave = CLAVE_FLUJO_AGUA;
            int panel = PANEL_FLUJO;
            String columnaBD = "flujoAguaSep";
            String tituloSerie = "Flujo Agua";
            this.asignarChkbox(frmSeries.chkFlujoAgua, clave, panel, columnaBD, tituloSerie);
        }
        if (e.getSource() == frmSeries.chkFlujoGas) {
            int clave = CLAVE_FLUJO_GAS;
            int panel = PANEL_FLUJO;
            String columnaBD = "flujoGas";
            String tituloSerie = "Flujo Gas";
            this.asignarChkbox(frmSeries.chkFlujoGas, clave, panel, columnaBD, tituloSerie);
        }
        if (e.getSource() == frmSeries.chkFlujoDiluyente) {
            int clave = CLAVE_FLUJO_DILUYENTE;
            int panel = PANEL_FLUJO;
            String columnaBD = "flujoDiluyente";
            String tituloSerie = "Flujo Diluyente";
            this.asignarChkbox(frmSeries.chkFlujoDiluyente, clave, panel, columnaBD, tituloSerie);
        }
        if (e.getSource() == frmSeries.chkAceiteProducido) {
            int clave = CLAVE_PRODUCCION_ACEITE;
            int panel = PANEL_PRODUCCION_VOLUMEN;
            String columnaBD = "aceiteProducido";
            String tituloSerie = "Aceite Producido";
            this.asignarChkbox(frmSeries.chkAceiteProducido, clave, panel, columnaBD, tituloSerie);
        }
        if (e.getSource() == frmSeries.chkAguaProducida) {
            int clave = CLAVE_PRODUCCION_AGUA;
            int panel = PANEL_PRODUCCION_VOLUMEN;
            String columnaBD = "aguaProducida";
            String tituloSerie = "Agua Producida";
            this.asignarChkbox(frmSeries.chkAguaProducida, clave, panel, columnaBD, tituloSerie);
        }
        if (e.getSource() == frmSeries.chkDiluyenteInyectado) {
            int clave = CLAVE_PRODUCCION_DILUYENTE_INYECTADO;
            int panel = PANEL_PRODUCCION_VOLUMEN;
            String columnaBD = "inyeccionDiluyente";
            String tituloSerie = "Diluyente Inyectado";
            this.asignarChkbox(frmSeries.chkDiluyenteInyectado, clave, panel, columnaBD, tituloSerie);
        }
        if (e.getSource() == frmSeries.chkNSVconDiluyente) {
            int clave = CLAVE_PRODUCCION_NSV_CON_DILUYENTE;
            int panel = PANEL_PRODUCCION_VOLUMEN;
            String columnaBD = "recibo";
            String tituloSerie = "NSV con Diluyente";
            this.asignarChkbox(frmSeries.chkNSVconDiluyente, clave, panel, columnaBD, tituloSerie);
        }
        if (e.getSource() == frmSeries.chkSYW) {
            int clave = CLAVE_PRODUCCION_SYW;
            int panel = PANEL_PRODUCCION_SYW;
            String columnaBD = "sYw";
            String tituloSerie = "% S&W";
            this.asignarChkbox(frmSeries.chkSYW, clave, panel, columnaBD, tituloSerie);
        }
        if (e.getSource() == frmSeries.chkGasProducido) {
            int clave = CLAVE_PRODUCCION_GAS_PRODUCIDO;
            int panel = PANEL_PRODUCCION_GAS;
            String columnaBD = "gas";
            String tituloSerie = "Gas Producido";
            this.asignarChkbox(frmSeries.chkGasProducido, clave, panel, columnaBD, tituloSerie);
        }
        if (e.getSource() == frmSeries.chkHoras) {
            int clave = CLAVE_PRODUCCION_HORAS;
            int panel = PANEL_PRODUCCION_HORAS;
            String columnaBD = "tiempoPrueba";
            String tituloSerie = "Horas de producción";
            this.asignarChkbox(frmSeries.chkHoras, clave, panel, columnaBD, tituloSerie);
        }
    }

    public void asignarChkbox(JCheckBox chkbox, int clave, int panel, String columnaBD, String tituloSerie) {
        if (chkbox.isSelected()) {
            arrayMapSeries.put(clave, new SeriesGrafica(columnaBD, tituloSerie, isEjePrincipal()));
            this.habilitarDeshabilitarAllPanel(panel, HABILITAR);
        } else {

            arrayMapSeries.remove(clave);
            this.verificarPanelActivo(panel);
        }
    }

    public void habilitarDeshabilitarAllPanel(int panel, boolean deshabilitar) {
        ConsultasProcesoAlarmas verificarActivosC = new ConsultasProcesoAlarmas();
        ProcesoAlarmas verificarActivos = new ProcesoAlarmas();
        verificarActivos.setIdPozo(ctrlGraficas.frmGraficas.cmbxIdPozo.getSelectedItem().toString());

        //ejecutar consultas en base de datos y asigna a la ventana
        try {
            if (verificarActivosC.buscarAlarmas(verificarActivos)) {
                switch (panel) {
                    case PANEL_PRESION:
                        this.frmSeries.chkPresionCabeza.setEnabled((verificarActivos.isPresionCabezaActive() ^ deshabilitar) && verificarActivos.isPresionCabezaActive());
                        this.frmSeries.chkPresionCasing.setEnabled((verificarActivos.isPresionCasingActive() ^ deshabilitar) && verificarActivos.isPresionCasingActive());
                        this.frmSeries.chkPresionChoke.setEnabled((verificarActivos.isPresionChokeActive() ^ deshabilitar) && verificarActivos.isPresionChokeActive());
                        this.frmSeries.chkPresionSeparador.setEnabled((verificarActivos.isPresionSepActive() ^ deshabilitar) && verificarActivos.isPresionGasSepActive());
                        this.frmSeries.chkPresionLinea.setEnabled((verificarActivos.isPresionLineaActive() ^ deshabilitar) && verificarActivos.isPresionLineaActive());
                        this.frmSeries.chkPresionGas.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkPresionMezclador.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkTemperaturaCabeza.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkTemperaturaGas.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkTemperaturaSeparador.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkFlujoAceite.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkFlujoAgua.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkFlujoGas.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkFlujoDiluyente.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkAceiteProducido.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkAguaProducida.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkSYW.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkGasProducido.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkDiluyenteInyectado.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkNSVconDiluyente.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkHoras.setEnabled((false ^ deshabilitar));
                        if (this.isEjePrincipal()) {
                            this.setTituloEjePrincipal("PRESIÓN (PSI)");
                        } else {
                            this.setTituloEjeSecundario("PRESIÓN (PSI)");
                        }
                        break;
                    case PANEL_TEMPERATURA:
                        this.frmSeries.chkPresionCabeza.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkPresionCasing.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkPresionChoke.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkPresionSeparador.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkPresionLinea.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkPresionGas.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkPresionMezclador.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkTemperaturaCabeza.setEnabled((verificarActivos.isTemperaturaCabezaActive() ^ deshabilitar) && verificarActivos.isTemperaturaCabezaActive());
                        this.frmSeries.chkTemperaturaGas.setEnabled((verificarActivos.isTemperaturaGasSepActive() ^ deshabilitar) && verificarActivos.isTemperaturaGasSepActive());
                        this.frmSeries.chkTemperaturaSeparador.setEnabled((verificarActivos.isTemperaturaSepActive() ^ deshabilitar) && verificarActivos.isTemperaturaGasSepActive());
                        this.frmSeries.chkFlujoAceite.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkFlujoAgua.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkFlujoGas.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkFlujoDiluyente.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkAceiteProducido.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkAguaProducida.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkSYW.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkGasProducido.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkDiluyenteInyectado.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkNSVconDiluyente.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkHoras.setEnabled((false ^ deshabilitar));
                        if (this.isEjePrincipal()) {
                            this.setTituloEjePrincipal("TEMPERATURA (°F)");
                        } else {
                            this.setTituloEjeSecundario("TEMPERATURA (°F)");
                        }
                        break;
                    case PANEL_FLUJO:
                        this.frmSeries.chkPresionCabeza.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkPresionCasing.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkPresionChoke.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkPresionSeparador.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkPresionLinea.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkPresionGas.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkPresionMezclador.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkTemperaturaCabeza.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkTemperaturaGas.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkTemperaturaSeparador.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkFlujoAceite.setEnabled((verificarActivos.isFlujoAceiteSepActive() ^ deshabilitar) && verificarActivos.isFlujoAceiteSepActive());
                        this.frmSeries.chkFlujoAgua.setEnabled((verificarActivos.isFlujoAguaSepActive() ^ deshabilitar) && verificarActivos.isFlujoAguaSepActive());
                        this.frmSeries.chkFlujoGas.setEnabled((verificarActivos.isFlujoGasActive() ^ deshabilitar) && verificarActivos.isFlujoGasActive());
                        this.frmSeries.chkFlujoDiluyente.setEnabled((verificarActivos.isFlujoDiluyenteActive() ^ deshabilitar) && verificarActivos.isFlujoDiluyenteActive());
                        this.frmSeries.chkAceiteProducido.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkAguaProducida.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkSYW.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkGasProducido.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkDiluyenteInyectado.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkNSVconDiluyente.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkHoras.setEnabled((false ^ deshabilitar));
                        if (this.isEjePrincipal()) {
                            this.setTituloEjePrincipal("CAUDAL (BPD)");
                        } else {
                            this.setTituloEjeSecundario("CAUDAL (BPD)");
                        }
                        break;
                    case PANEL_PRODUCCION_VOLUMEN:
                        this.frmSeries.chkPresionCabeza.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkPresionCasing.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkPresionChoke.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkPresionSeparador.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkPresionLinea.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkPresionGas.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkPresionMezclador.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkTemperaturaCabeza.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkTemperaturaGas.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkTemperaturaSeparador.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkFlujoAceite.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkFlujoAgua.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkFlujoGas.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkFlujoDiluyente.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkAceiteProducido.setEnabled((true ^ deshabilitar) && true);
                        this.frmSeries.chkAguaProducida.setEnabled((true ^ deshabilitar) && true);
                        this.frmSeries.chkSYW.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkGasProducido.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkDiluyenteInyectado.setEnabled((true ^ deshabilitar) && true);
                        this.frmSeries.chkNSVconDiluyente.setEnabled((true ^ deshabilitar) && true);
                        this.frmSeries.chkHoras.setEnabled((false ^ deshabilitar));
                        if (this.isEjePrincipal()) {
                            this.setTituloEjePrincipal("VOLUMEN (BBLS)");
                        } else {
                            this.setTituloEjeSecundario("VOLUMEN (BBLS)");
                        }
                        break;
                    case PANEL_PRESION_INH2O:
                        this.frmSeries.chkPresionCabeza.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkPresionCasing.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkPresionChoke.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkPresionSeparador.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkPresionLinea.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkPresionGas.setEnabled((verificarActivos.isPresionGasSepActive() ^ deshabilitar) && verificarActivos.isPresionGasSepActive());
                        this.frmSeries.chkPresionMezclador.setEnabled((verificarActivos.isPresionMezcladorActive() ^ deshabilitar) && verificarActivos.isPresionMezcladorActive());
                        this.frmSeries.chkTemperaturaCabeza.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkTemperaturaGas.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkTemperaturaSeparador.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkFlujoAceite.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkFlujoAgua.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkFlujoGas.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkFlujoDiluyente.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkAceiteProducido.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkAguaProducida.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkSYW.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkGasProducido.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkDiluyenteInyectado.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkNSVconDiluyente.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkHoras.setEnabled((false ^ deshabilitar));
                        if (this.isEjePrincipal()) {
                            this.setTituloEjePrincipal("PRESIÓN (INH2O)");
                        } else {
                            this.setTituloEjeSecundario("PRESIÓN (INH2O)");
                        }
                        break;
                    case PANEL_PRODUCCION_GAS:
                        this.frmSeries.chkPresionCabeza.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkPresionCasing.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkPresionChoke.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkPresionSeparador.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkPresionLinea.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkPresionGas.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkPresionMezclador.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkTemperaturaCabeza.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkTemperaturaGas.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkTemperaturaSeparador.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkFlujoAceite.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkFlujoAgua.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkFlujoGas.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkFlujoDiluyente.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkAceiteProducido.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkAguaProducida.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkSYW.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkGasProducido.setEnabled((true ^ deshabilitar) && true);
                        this.frmSeries.chkDiluyenteInyectado.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkNSVconDiluyente.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkHoras.setEnabled((false ^ deshabilitar));
                        if (this.isEjePrincipal()) {
                            this.setTituloEjePrincipal("VOLUMEN (MSCFD)");
                        } else {
                            this.setTituloEjeSecundario("VOLUMEN (MSCFD)");
                        }
                        break;
                    case PANEL_PRODUCCION_SYW:
                        this.frmSeries.chkPresionCabeza.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkPresionCasing.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkPresionChoke.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkPresionSeparador.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkPresionLinea.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkPresionGas.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkPresionMezclador.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkTemperaturaCabeza.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkTemperaturaGas.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkTemperaturaSeparador.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkFlujoAceite.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkFlujoAgua.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkFlujoGas.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkFlujoDiluyente.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkAceiteProducido.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkAguaProducida.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkSYW.setEnabled((true ^ deshabilitar) && true);
                        this.frmSeries.chkGasProducido.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkDiluyenteInyectado.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkNSVconDiluyente.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkHoras.setEnabled((false ^ deshabilitar));
                        if (this.isEjePrincipal()) {
                            this.setTituloEjePrincipal("% S&W");
                        } else {
                            this.setTituloEjeSecundario("% S&W");
                        }
                        break;
                    case PANEL_PRODUCCION_HORAS:
                        this.frmSeries.chkPresionCabeza.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkPresionCasing.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkPresionChoke.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkPresionSeparador.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkPresionLinea.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkPresionGas.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkPresionMezclador.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkTemperaturaCabeza.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkTemperaturaGas.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkTemperaturaSeparador.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkFlujoAceite.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkFlujoAgua.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkFlujoGas.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkFlujoDiluyente.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkAceiteProducido.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkAguaProducida.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkSYW.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkGasProducido.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkDiluyenteInyectado.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkNSVconDiluyente.setEnabled((false ^ deshabilitar));
                        this.frmSeries.chkHoras.setEnabled((true ^ deshabilitar) && true);
                        if (this.isEjePrincipal()) {
                            this.setTituloEjePrincipal("HORAS DE PRODUCCIÓN");
                        } else {
                            this.setTituloEjeSecundario("HORASL DE PRODUCCIÓN");
                        }
                        break;
                    default:
                        this.frmSeries.chkPresionCabeza.setEnabled((verificarActivos.isPresionCabezaActive() ^ deshabilitar) && verificarActivos.isPresionCabezaActive());
                        this.frmSeries.chkPresionCasing.setEnabled((verificarActivos.isPresionCasingActive() ^ deshabilitar) && verificarActivos.isPresionCasingActive());
                        this.frmSeries.chkPresionChoke.setEnabled((verificarActivos.isPresionChokeActive() ^ deshabilitar) && verificarActivos.isPresionChokeActive());
                        this.frmSeries.chkPresionSeparador.setEnabled((verificarActivos.isPresionSepActive() ^ deshabilitar) && verificarActivos.isPresionSepActive());
                        this.frmSeries.chkPresionLinea.setEnabled((verificarActivos.isPresionLineaActive() ^ deshabilitar) && verificarActivos.isPresionLineaActive());
                        this.frmSeries.chkPresionGas.setEnabled((verificarActivos.isPresionGasSepActive() ^ deshabilitar) && verificarActivos.isPresionGasSepActive());
                        this.frmSeries.chkPresionMezclador.setEnabled((verificarActivos.isPresionMezcladorActive() ^ deshabilitar) && verificarActivos.isPresionMezcladorActive());
                        this.frmSeries.chkTemperaturaCabeza.setEnabled((verificarActivos.isTemperaturaCabezaActive() ^ deshabilitar) && verificarActivos.isTemperaturaCabezaActive());
                        this.frmSeries.chkTemperaturaGas.setEnabled((verificarActivos.isTemperaturaGasSepActive() ^ deshabilitar) && verificarActivos.isTemperaturaGasSepActive());
                        this.frmSeries.chkTemperaturaSeparador.setEnabled((verificarActivos.isTemperaturaSepActive() ^ deshabilitar) && verificarActivos.isTemperaturaSepActive());
                        this.frmSeries.chkFlujoAceite.setEnabled((verificarActivos.isFlujoAceiteSepActive() ^ deshabilitar) && verificarActivos.isFlujoAceiteSepActive());
                        this.frmSeries.chkFlujoAgua.setEnabled((verificarActivos.isFlujoAguaSepActive() ^ deshabilitar) && verificarActivos.isFlujoAguaSepActive());
                        this.frmSeries.chkFlujoGas.setEnabled((verificarActivos.isFlujoGasActive() ^ deshabilitar) && verificarActivos.isFlujoGasActive());
                        this.frmSeries.chkFlujoDiluyente.setEnabled((verificarActivos.isFlujoDiluyenteActive() ^ deshabilitar) && verificarActivos.isFlujoDiluyenteActive());
                        this.frmSeries.chkAceiteProducido.setEnabled((true ^ deshabilitar) && true);
                        this.frmSeries.chkAguaProducida.setEnabled((true ^ deshabilitar) && true);
                        this.frmSeries.chkSYW.setEnabled((true ^ deshabilitar) && true);
                        this.frmSeries.chkGasProducido.setEnabled((true ^ deshabilitar) && true);
                        this.frmSeries.chkDiluyenteInyectado.setEnabled((true ^ deshabilitar) && true);
                        this.frmSeries.chkNSVconDiluyente.setEnabled((true ^ deshabilitar) && true);
                        this.frmSeries.chkHoras.setEnabled((true ^ deshabilitar) && true);
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "No hay variables agregadas verifique las variables de proceso");
                this.frmSeries.chkPresionCabeza.setEnabled((false ^ deshabilitar) && false);
                this.frmSeries.chkPresionCasing.setEnabled((false ^ deshabilitar) && false);
                this.frmSeries.chkPresionChoke.setEnabled((false ^ deshabilitar) && false);
                this.frmSeries.chkPresionSeparador.setEnabled((false ^ deshabilitar) && false);
                this.frmSeries.chkPresionLinea.setEnabled((false ^ deshabilitar) && false);
                this.frmSeries.chkPresionGas.setEnabled((false ^ deshabilitar) && false);
                this.frmSeries.chkPresionMezclador.setEnabled((false ^ deshabilitar) && false);
                this.frmSeries.chkTemperaturaCabeza.setEnabled((false ^ deshabilitar) && false);
                this.frmSeries.chkTemperaturaGas.setEnabled((false ^ deshabilitar) && false);
                this.frmSeries.chkTemperaturaSeparador.setEnabled((false ^ deshabilitar) && false);
                this.frmSeries.chkFlujoAceite.setEnabled((false ^ deshabilitar) && false);
                this.frmSeries.chkFlujoAgua.setEnabled((false ^ deshabilitar) && false);
                this.frmSeries.chkFlujoGas.setEnabled((false ^ deshabilitar) && false);
                this.frmSeries.chkFlujoDiluyente.setEnabled((false ^ deshabilitar) && false);
            }
        } catch (SQLException ex) {
            System.err.println("Error al buscar las variables activas: " + ex);
        }

    }

    public void reset() {
        this.frmSeries.chkPresionCabeza.setSelected(false);
        this.frmSeries.chkPresionCasing.setSelected(false);
        this.frmSeries.chkPresionChoke.setSelected(false);
        this.frmSeries.chkPresionSeparador.setSelected(false);
        this.frmSeries.chkPresionLinea.setSelected(false);
        this.frmSeries.chkPresionGas.setSelected(false);
        this.frmSeries.chkPresionMezclador.setSelected(false);
        this.frmSeries.chkTemperaturaCabeza.setSelected(false);
        this.frmSeries.chkTemperaturaGas.setSelected(false);
        this.frmSeries.chkTemperaturaSeparador.setSelected(false);
        this.frmSeries.chkFlujoAceite.setSelected(false);
        this.frmSeries.chkFlujoAgua.setSelected(false);
        this.frmSeries.chkFlujoGas.setSelected(false);
        this.frmSeries.chkFlujoDiluyente.setSelected(false);
        this.frmSeries.chkAceiteProducido.setSelected(false);
        this.frmSeries.chkAguaProducida.setSelected(false);
        this.frmSeries.chkSYW.setSelected(false);
        this.frmSeries.chkGasProducido.setSelected(false);
        this.frmSeries.chkDiluyenteInyectado.setSelected(false);
        this.frmSeries.chkNSVconDiluyente.setSelected(false);
        this.frmSeries.chkHoras.setSelected(false);
        this.habilitarDeshabilitarAllPanel(0, HABILITAR);
        this.arrayMapSeries.clear();
    }

    public void verificarPanelActivo(int panel) {
        switch (panel) {
            case PANEL_PRESION:
                recorrerArrayVerificador(1, 5, panel);
                break;
            case PANEL_TEMPERATURA:
                recorrerArrayVerificador(8, 10, panel);
                break;
            case PANEL_FLUJO:
                recorrerArrayVerificador(11, 14, panel);
                break;
            case PANEL_PRODUCCION_VOLUMEN:
                recorrerArrayVerificador(15, 18, panel);
                break;
            case PANEL_PRESION_INH2O:
                recorrerArrayVerificador(6, 7, panel);
                break;
            case PANEL_PRODUCCION_GAS:
                recorrerArrayVerificador(20, 20, panel);
                break;
            case PANEL_PRODUCCION_SYW:
                recorrerArrayVerificador(19, 19, panel);
                break;
            case PANEL_PRODUCCION_HORAS:
                recorrerArrayVerificador(21, 21, panel);
                break;
            default:
                break;
        }
    }

    public void recorrerArrayVerificador(int min, int max, int panel) {
        Iterator it = this.arrayMapSeries.keySet().iterator();
        while (it.hasNext()) {
            Integer key = (Integer) it.next();
            if (key >= min && key <= max) {
                if (this.getArrayMapSeries().get(key).isEjePrincipal() && this.isEjePrincipal()) {
                    this.habilitarDeshabilitarAllPanel(panel, HABILITAR);
                } else {
                    this.habilitarDeshabilitarAllPanel(0, HABILITAR);
                }
            } else {
                this.habilitarDeshabilitarAllPanel(0, HABILITAR);
                this.verificarActivadosAnteriormente(ejePrincipal);
            }
        }
    }

    public void verificarActivadosAnteriormente(boolean isEjePrincipal) {
        if (!this.getArrayMapSeries().isEmpty()) {
            Iterator it = this.arrayMapSeries.keySet().iterator();
            while (it.hasNext()) {
                Integer key = (Integer) it.next();
                if (key > 0) {
                    if (key >= 1 && key < 6) {
                        if (this.arrayMapSeries.get(key).isEjePrincipal() != isEjePrincipal) {
                            habilitarDeshabilitarAllPanel(PANEL_PRESION, DESHABILITAR);
                        } else {
                            habilitarDeshabilitarAllPanel(PANEL_PRESION, HABILITAR);
                            break;
                        }
                    }
                    if (key >= 6 && key < 8) {
                        if (this.arrayMapSeries.get(key).isEjePrincipal() != isEjePrincipal) {
                            habilitarDeshabilitarAllPanel(PANEL_PRESION_INH2O, DESHABILITAR);
                        } else {
                            habilitarDeshabilitarAllPanel(PANEL_PRESION_INH2O, HABILITAR);
                            break;
                        }
                    }
                    if (key >= 8 && key < 11) {
                        if (this.arrayMapSeries.get(key).isEjePrincipal() != isEjePrincipal) {
                            habilitarDeshabilitarAllPanel(PANEL_TEMPERATURA, DESHABILITAR);
                        } else {
                            habilitarDeshabilitarAllPanel(PANEL_TEMPERATURA, HABILITAR);
                            break;
                        }
                    }
                    if (key >= 11 && key < 15) {
                        if (this.arrayMapSeries.get(key).isEjePrincipal() != isEjePrincipal) {
                            habilitarDeshabilitarAllPanel(PANEL_FLUJO, DESHABILITAR);
                        } else {
                            habilitarDeshabilitarAllPanel(PANEL_FLUJO, HABILITAR);
                            break;
                        }
                    }
                    if (key >= 15 && key < 19) {
                        if (this.arrayMapSeries.get(key).isEjePrincipal() != isEjePrincipal) {
                            habilitarDeshabilitarAllPanel(PANEL_PRODUCCION_VOLUMEN, DESHABILITAR);
                        } else {
                            habilitarDeshabilitarAllPanel(PANEL_PRODUCCION_VOLUMEN, HABILITAR);
                            break;
                        }
                    }
                    if (key == 19) {
                        if (this.arrayMapSeries.get(key).isEjePrincipal() != isEjePrincipal) {
                            habilitarDeshabilitarAllPanel(PANEL_PRODUCCION_SYW, DESHABILITAR);
                        } else {
                            habilitarDeshabilitarAllPanel(PANEL_PRODUCCION_SYW, HABILITAR);
                            break;
                        }
                    }
                    if (key == 20) {
                        if (this.arrayMapSeries.get(key).isEjePrincipal() != isEjePrincipal) {
                            habilitarDeshabilitarAllPanel(PANEL_PRODUCCION_GAS, DESHABILITAR);
                        } else {
                            habilitarDeshabilitarAllPanel(PANEL_PRODUCCION_GAS, HABILITAR);
                            break;
                        }
                    }
                    if (key == 21) {
                        if (this.arrayMapSeries.get(key).isEjePrincipal() != isEjePrincipal) {
                            habilitarDeshabilitarAllPanel(PANEL_PRODUCCION_HORAS, DESHABILITAR);
                        } else {
                            habilitarDeshabilitarAllPanel(PANEL_PRODUCCION_HORAS, HABILITAR);
                            break;
                        }
                    }
                }
            }
        } else {
            this.habilitarDeshabilitarAllPanel(0, HABILITAR);
        }
    }

    public boolean isEjePrincipal() {
        return ejePrincipal;
    }

    public void setEjePrincipal(boolean ejePrincipal) {
        this.ejePrincipal = ejePrincipal;
    }

    public String getTituloEjePrincipal() {
        return tituloEjePrincipal;
    }

    public void setTituloEjePrincipal(String tituloEjePrincipal) {
        this.tituloEjePrincipal = tituloEjePrincipal;
    }

    public String getTituloEjeSecundario() {
        return tituloEjeSecundario;
    }

    public void setTituloEjeSecundario(String tituloEjeSecundario) {
        this.tituloEjeSecundario = tituloEjeSecundario;
    }

    public Map<Integer, SeriesGrafica> getArrayMapSeries() {
        return arrayMapSeries;
    }

    public void setArrayMapSeries(Map<Integer, SeriesGrafica> arrayMapSeries) {
        this.arrayMapSeries = arrayMapSeries;
    }

}

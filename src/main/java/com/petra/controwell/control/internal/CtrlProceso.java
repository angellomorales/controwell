package com.petra.controwell.control.internal;

import com.petra.controwell.control.CtrlPrincipalTanques;
import com.petra.controwell.model.UnidadesMedicion;
import com.petra.controwell.model.data.Proceso;
import com.petra.controwell.model.data.ProcesoAlarmas;
import com.petra.controwell.model.data.querys.ConsultasProceso;
import com.petra.controwell.model.utilities.Utilities;
import com.petra.controwell.view.internal.FrmProceso;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 *
 * @author Angello Morales
 */
public class CtrlProceso implements ActionListener {

    //vista
    public FrmProceso frmProceso;

    //modelo BD
    public Proceso proceso;
    public ConsultasProceso procesoC;
    public ProcesoAlarmas procesoAlarmas;

    //modelo
    public UnidadesMedicion um = new UnidadesMedicion("PSI", "Gpm", "°F", "BBL", "inH20", "mmSCF");

    //controlador;
    public Utilities ctrlUtilities;
    public CtrlPrincipalTanques ctrlPrincipalTanques;
    public CtrlProcesoAlarmas ctrlProcesoAlarmas;

    public CtrlProceso(FrmProceso frmProceso, Proceso proceso, ConsultasProceso procesoC, ProcesoAlarmas procesoAlarmas, Utilities ctrlUtilities, CtrlPrincipalTanques ctrlPrincipalTanques, CtrlProcesoAlarmas ctrlProcesoAlarmas) {
        this.frmProceso = frmProceso;
        this.proceso = proceso;
        this.procesoC = procesoC;
        this.procesoAlarmas = procesoAlarmas;
        this.ctrlUtilities = ctrlUtilities;
        this.ctrlPrincipalTanques = ctrlPrincipalTanques;
        this.ctrlProcesoAlarmas = ctrlProcesoAlarmas;

        this.frmProceso.cmbxIdPozo.removeAllItems();

        //agregar listener a los botones dentro del constructor
        //this.frmProceso.cmbxIdPozo.addActionListener(this);
        this.frmProceso.btnLiquidacionTk.addActionListener(this);

    }

    public void iniciar() {
        frmProceso.setTitle("Variables de Proceso");
        frmProceso.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //acciones a ejecutar cuando se presiona un elemento en la pantalla 
        //if por cada elemento para detectar cual se presiono
        if (e.getSource() == frmProceso.btnLiquidacionTk) {
            ctrlPrincipalTanques.iniciar();
        }
    }

    public void asignacionVariables() {
        frmProceso.lblFecha.setText("Fecha: " + String.valueOf(proceso.getFecha()));
        frmProceso.lblHora.setText("Hora: " + String.valueOf(proceso.getHora()));
        frmProceso.lblPresionCabeza.setText("<html>Presion Cabeza:<br>" + String.valueOf(proceso.getPresionCabeza()) + " " + um.getUnidadPresion() + "</html>");
        frmProceso.lblTemperaturaCabeza.setText("<html>Temperatura Cabeza:<br>" + String.valueOf(proceso.getTemperaturaCabeza()) + " " + um.getUnidadTemperatura() + "</html>");
        frmProceso.lblPresionCasing.setText("<html>Presion Casing:<br>" + String.valueOf(proceso.getPresionCasing()) + " " + um.getUnidadPresion() + "</html>");
        frmProceso.lblPresionChoke.setText("<html>Presion Choke:<br>" + String.valueOf(proceso.getPresionChoke()) + " " + um.getUnidadPresion() + "</html>");
        frmProceso.lblFlujoDiluyente.setText("<html>Diluyente:<br>" + String.valueOf(proceso.getFlujoDiluyente()) + " " + um.getUnidadCaudal() + "</html>");
        frmProceso.lblPresionMezclador.setText("<html>Presion Mezclador:<br>" + String.valueOf(proceso.getPresionMezclador()) + " " + um.getUnidadPresionDif() + "</html>");
        frmProceso.lblFlujoAceiteSep.setText("<html>Aceite:<br>" + String.valueOf(proceso.getFlujoAceiteSep()) + " " + um.getUnidadCaudal() + "</html>");
        frmProceso.lblFlujoAguaSep.setText("<html>Agua:<br>" + String.valueOf(proceso.getFlujoAguaSep()) + " " + um.getUnidadCaudal() + "</html>");
        frmProceso.lblPresionSep.setText("<html>Presion Separador:<br>" + String.valueOf(proceso.getPresionSep()) + " " + um.getUnidadPresion() + "</html>");
        frmProceso.lblTemperaturaSep.setText("<html>Temperatura Separador:<br>" + String.valueOf(proceso.getTemperaturaSep()) + " " + um.getUnidadTemperatura() + "</html>");
        frmProceso.lblPresionGasSep.setText("<html>Presion Gas:<br>" + String.valueOf(proceso.getPresionGasSep()) + " " + um.getUnidadPresionDif() + "</html>");
        frmProceso.lblTemperaturaGasSep.setText("<html>Temperatura Gas:<br>" + String.valueOf(proceso.getTemperaturaGasSep()) + " " + um.getUnidadTemperatura() + "</html>");
        frmProceso.lblFlujoGas.setText("<html>Gas:<br>" + String.valueOf(proceso.getFlujoGas()) + " " + um.getUnidadCaudalGas() + "</html>");
        frmProceso.lblPresionLinea.setText("<html>Presion Troncal:<br>" + String.valueOf(proceso.getPresionLinea()) + " " + um.getUnidadPresion() + "</html>");
    }

    public void ceroAVariables() {
        frmProceso.lblFecha.setText("Fecha: aaaa-mm-dd");
        frmProceso.lblHora.setText("Hora: hh:mm:ss");
        frmProceso.lblPresionCabeza.setText("<html>Presion Cabeza:<br>" + "0.0" + " " + um.getUnidadPresion() + "</html>");
        frmProceso.lblTemperaturaCabeza.setText("<html>Temperatura Cabeza:<br>" + "0.0" + " " + um.getUnidadTemperatura() + "</html>");
        frmProceso.lblPresionCasing.setText("<html>Presion Casing:<br>" + "0.0" + " " + um.getUnidadPresion() + "</html>");
        frmProceso.lblPresionChoke.setText("<html>Presion Choke:<br>" + "0.0" + " " + um.getUnidadPresion() + "</html>");
        frmProceso.lblFlujoDiluyente.setText("<html>Diluyente:<br>" + "0.0" + " " + um.getUnidadCaudal() + "</html>");
        frmProceso.lblPresionMezclador.setText("<html>Presion Mezclador:<br>" + "0.0" + " " + um.getUnidadPresionDif() + "</html>");
        frmProceso.lblFlujoAceiteSep.setText("<html>Aceite:<br>" + "0.0" + " " + um.getUnidadCaudal() + "</html>");
        frmProceso.lblFlujoAguaSep.setText("<html>Agua:<br>" + "0.0" + " " + um.getUnidadCaudal() + "</html>");
        frmProceso.lblPresionSep.setText("<html>Presion Separador:<br>" + "0.0" + " " + um.getUnidadPresion() + "</html>");
        frmProceso.lblTemperaturaSep.setText("<html>Temperatura Separador:<br>" + "0.0" + " " + um.getUnidadTemperatura() + "</html>");
        frmProceso.lblPresionGasSep.setText("<html>Presion Gas:<br>" + "0.0" + " " + um.getUnidadPresionDif() + "</html>");
        frmProceso.lblTemperaturaGasSep.setText("<html>Temperatura Gas:<br>" + "0.0" + " " + um.getUnidadTemperatura() + "</html>");
        frmProceso.lblFlujoGas.setText("<html>Gas:<br>" + "0.0" + " " + um.getUnidadCaudalGas() + "</html>");
        frmProceso.lblPresionLinea.setText("<html>Presion Troncal:<br>" + "0.0" + " " + um.getUnidadPresion() + "</html>");
    }

    public void activarAlertaAlarma() {

        //Presion Cabeza
        if (proceso.getPresionCabeza() > procesoAlarmas.getPresionCabezaMax() && procesoAlarmas.isPresionCabezaEnable()) {
            frmProceso.lblPresionCabeza = ctrlUtilities.activarAlarma(frmProceso.lblPresionCabeza, ctrlUtilities.ACTIVO, ctrlUtilities.ALTA);
        } else if (proceso.getPresionCabeza() < procesoAlarmas.getPresionCabezaMin() && procesoAlarmas.isPresionCabezaEnable()) {
            frmProceso.lblPresionCabeza = ctrlUtilities.activarAlarma(frmProceso.lblPresionCabeza, ctrlUtilities.ACTIVO, ctrlUtilities.BAJA);
        } else {
            frmProceso.lblPresionCabeza = ctrlUtilities.activarAlarma(frmProceso.lblPresionCabeza, ctrlUtilities.INACTIVO, ctrlUtilities.INACTIVO);
        }
        //Temperatura Cabeza
        if (proceso.getTemperaturaCabeza() > procesoAlarmas.getTemperaturaCabezaMax() && procesoAlarmas.isTemperaturaCabezaEnable()) {
            frmProceso.lblTemperaturaCabeza = ctrlUtilities.activarAlarma(frmProceso.lblTemperaturaCabeza, ctrlUtilities.ACTIVO, ctrlUtilities.ALTA);
        } else if (proceso.getTemperaturaCabeza() < procesoAlarmas.getTemperaturaCabezaMin() && procesoAlarmas.isTemperaturaCabezaEnable()) {
            frmProceso.lblTemperaturaCabeza = ctrlUtilities.activarAlarma(frmProceso.lblTemperaturaCabeza, ctrlUtilities.ACTIVO, ctrlUtilities.BAJA);
        } else {
            frmProceso.lblTemperaturaCabeza = ctrlUtilities.activarAlarma(frmProceso.lblTemperaturaCabeza, ctrlUtilities.INACTIVO, ctrlUtilities.INACTIVO);
        }
        //Presion Casing
        if (proceso.getPresionCasing() > procesoAlarmas.getPresionCasingMax() && procesoAlarmas.isPresionCasingEnable()) {
            frmProceso.lblPresionCasing = ctrlUtilities.activarAlarma(frmProceso.lblPresionCasing, ctrlUtilities.ACTIVO, ctrlUtilities.ALTA);
        } else if (proceso.getPresionCasing() < procesoAlarmas.getPresionCasingMin() && procesoAlarmas.isPresionCasingEnable()) {
            frmProceso.lblPresionCasing = ctrlUtilities.activarAlarma(frmProceso.lblPresionCasing, ctrlUtilities.ACTIVO, ctrlUtilities.BAJA);
        } else {
            frmProceso.lblPresionCasing = ctrlUtilities.activarAlarma(frmProceso.lblPresionCasing, ctrlUtilities.INACTIVO, ctrlUtilities.INACTIVO);
        }
        //Presion Choke
        if (proceso.getPresionChoke() > procesoAlarmas.getPresionChokeMax() && procesoAlarmas.isPresionChokeEnable()) {
            frmProceso.lblPresionChoke = ctrlUtilities.activarAlarma(frmProceso.lblPresionChoke, ctrlUtilities.ACTIVO, ctrlUtilities.ALTA);
        } else if (proceso.getPresionChoke() < procesoAlarmas.getPresionChokeMin() && procesoAlarmas.isPresionChokeEnable()) {
            frmProceso.lblPresionChoke = ctrlUtilities.activarAlarma(frmProceso.lblPresionChoke, ctrlUtilities.ACTIVO, ctrlUtilities.BAJA);
        } else {
            frmProceso.lblPresionChoke = ctrlUtilities.activarAlarma(frmProceso.lblPresionChoke, ctrlUtilities.INACTIVO, ctrlUtilities.INACTIVO);
        }
        //Flujo Diluyente
        if (proceso.getFlujoDiluyente() > procesoAlarmas.getFlujoDiluyenteMax() && procesoAlarmas.isFlujoDiluyenteEnable()) {
            frmProceso.lblFlujoDiluyente = ctrlUtilities.activarAlarma(frmProceso.lblFlujoDiluyente, ctrlUtilities.ACTIVO, ctrlUtilities.ALTA);
        } else if (proceso.getFlujoDiluyente() < procesoAlarmas.getFlujoDiluyenteMin() && procesoAlarmas.isFlujoDiluyenteEnable()) {
            frmProceso.lblFlujoDiluyente = ctrlUtilities.activarAlarma(frmProceso.lblFlujoDiluyente, ctrlUtilities.ACTIVO, ctrlUtilities.BAJA);
        } else {
            frmProceso.lblFlujoDiluyente = ctrlUtilities.activarAlarma(frmProceso.lblFlujoDiluyente, ctrlUtilities.INACTIVO, ctrlUtilities.INACTIVO);
        }
        //Presion Mezclador
        if (proceso.getPresionMezclador() > procesoAlarmas.getPresionMezcladorMax() && procesoAlarmas.isPresionMezcladorEnable()) {
            frmProceso.lblPresionMezclador = ctrlUtilities.activarAlarma(frmProceso.lblPresionMezclador, ctrlUtilities.ACTIVO, ctrlUtilities.ALTA);
        } else if (proceso.getPresionMezclador() < procesoAlarmas.getPresionMezcladorMin() && procesoAlarmas.isPresionMezcladorEnable()) {
            frmProceso.lblPresionMezclador = ctrlUtilities.activarAlarma(frmProceso.lblPresionMezclador, ctrlUtilities.ACTIVO, ctrlUtilities.BAJA);
        } else {
            frmProceso.lblPresionMezclador = ctrlUtilities.activarAlarma(frmProceso.lblPresionMezclador, ctrlUtilities.INACTIVO, ctrlUtilities.INACTIVO);
        }
        //Flujo Aceite Sep
        if (proceso.getFlujoAceiteSep() > procesoAlarmas.getFlujoAceiteSepMax() && procesoAlarmas.isFlujoAceiteSepEnable()) {
            frmProceso.lblFlujoAceiteSep = ctrlUtilities.activarAlarma(frmProceso.lblFlujoAceiteSep, ctrlUtilities.ACTIVO, ctrlUtilities.ALTA);
        } else if (proceso.getFlujoAceiteSep() < procesoAlarmas.getFlujoAceiteSepMin() && procesoAlarmas.isFlujoAceiteSepEnable()) {
            frmProceso.lblFlujoAceiteSep = ctrlUtilities.activarAlarma(frmProceso.lblFlujoAceiteSep, ctrlUtilities.ACTIVO, ctrlUtilities.BAJA);
        } else {
            frmProceso.lblFlujoAceiteSep = ctrlUtilities.activarAlarma(frmProceso.lblFlujoAceiteSep, ctrlUtilities.INACTIVO, ctrlUtilities.INACTIVO);
        }
        //Flujo Agua Sep
        if (proceso.getFlujoAguaSep() > procesoAlarmas.getFlujoAguaSepMax() && procesoAlarmas.isFlujoAguaSepEnable()) {
            frmProceso.lblFlujoAguaSep = ctrlUtilities.activarAlarma(frmProceso.lblFlujoAguaSep, ctrlUtilities.ACTIVO, ctrlUtilities.ALTA);
        } else if (proceso.getFlujoAguaSep() < procesoAlarmas.getFlujoAguaSepMin() && procesoAlarmas.isFlujoAguaSepEnable()) {
            frmProceso.lblFlujoAguaSep = ctrlUtilities.activarAlarma(frmProceso.lblFlujoAguaSep, ctrlUtilities.ACTIVO, ctrlUtilities.BAJA);
        } else {
            frmProceso.lblFlujoAguaSep = ctrlUtilities.activarAlarma(frmProceso.lblFlujoAguaSep, ctrlUtilities.INACTIVO, ctrlUtilities.INACTIVO);
        }
        //Presion Sep
        if (proceso.getPresionSep() > procesoAlarmas.getPresionSepMax() && procesoAlarmas.isPresionSepEnable()) {
            frmProceso.lblPresionSep = ctrlUtilities.activarAlarma(frmProceso.lblPresionSep, ctrlUtilities.ACTIVO, ctrlUtilities.ALTA);
        } else if (proceso.getPresionSep() < procesoAlarmas.getPresionSepMin() && procesoAlarmas.isPresionSepEnable()) {
            frmProceso.lblPresionSep = ctrlUtilities.activarAlarma(frmProceso.lblPresionSep, ctrlUtilities.ACTIVO, ctrlUtilities.BAJA);
        } else {
            frmProceso.lblPresionSep = ctrlUtilities.activarAlarma(frmProceso.lblPresionSep, ctrlUtilities.INACTIVO, ctrlUtilities.INACTIVO);
        }
        //Temperatura Sep
        if (proceso.getTemperaturaSep() > procesoAlarmas.getTemperaturaSepMax() && procesoAlarmas.isTemperaturaSepEnable()) {
            frmProceso.lblTemperaturaSep = ctrlUtilities.activarAlarma(frmProceso.lblTemperaturaSep, ctrlUtilities.ACTIVO, ctrlUtilities.ALTA);
        } else if (proceso.getTemperaturaSep() < procesoAlarmas.getTemperaturaSepMin() && procesoAlarmas.isTemperaturaSepEnable()) {
            frmProceso.lblTemperaturaSep = ctrlUtilities.activarAlarma(frmProceso.lblTemperaturaSep, ctrlUtilities.ACTIVO, ctrlUtilities.BAJA);
        } else {
            frmProceso.lblTemperaturaSep = ctrlUtilities.activarAlarma(frmProceso.lblTemperaturaSep, ctrlUtilities.INACTIVO, ctrlUtilities.INACTIVO);
        }
        //Presion Gas Sep
        if (proceso.getPresionGasSep() > procesoAlarmas.getPresionGasSepMax() && procesoAlarmas.isPresionGasSepEnable()) {
            frmProceso.lblPresionGasSep = ctrlUtilities.activarAlarma(frmProceso.lblPresionGasSep, ctrlUtilities.ACTIVO, ctrlUtilities.ALTA);
        } else if (proceso.getPresionGasSep() < procesoAlarmas.getPresionGasSepMin() && procesoAlarmas.isPresionGasSepEnable()) {
            frmProceso.lblPresionGasSep = ctrlUtilities.activarAlarma(frmProceso.lblPresionGasSep, ctrlUtilities.ACTIVO, ctrlUtilities.BAJA);
        } else {
            frmProceso.lblPresionGasSep = ctrlUtilities.activarAlarma(frmProceso.lblPresionGasSep, ctrlUtilities.INACTIVO, ctrlUtilities.INACTIVO);
        }
        //Temperatura Gas Sep
        if (proceso.getTemperaturaGasSep() > procesoAlarmas.getTemperaturaGasSepMax() && procesoAlarmas.isTemperaturaGasSepEnable()) {
            frmProceso.lblTemperaturaGasSep = ctrlUtilities.activarAlarma(frmProceso.lblTemperaturaGasSep, ctrlUtilities.ACTIVO, ctrlUtilities.ALTA);
        } else if (proceso.getTemperaturaGasSep() < procesoAlarmas.getTemperaturaGasSepMin() && procesoAlarmas.isTemperaturaGasSepEnable()) {
            frmProceso.lblTemperaturaGasSep = ctrlUtilities.activarAlarma(frmProceso.lblTemperaturaGasSep, ctrlUtilities.ACTIVO, ctrlUtilities.BAJA);
        } else {
            frmProceso.lblTemperaturaGasSep = ctrlUtilities.activarAlarma(frmProceso.lblTemperaturaGasSep, ctrlUtilities.INACTIVO, ctrlUtilities.INACTIVO);
        }
        //Flujo Gas
        if (proceso.getFlujoGas() > procesoAlarmas.getFlujoGasMax() && procesoAlarmas.isFlujoGasEnable()) {
            frmProceso.lblFlujoGas = ctrlUtilities.activarAlarma(frmProceso.lblFlujoGas, ctrlUtilities.ACTIVO, ctrlUtilities.ALTA);
        } else if (proceso.getFlujoGas() < procesoAlarmas.getFlujoGasMin() && procesoAlarmas.isFlujoGasEnable()) {
            frmProceso.lblFlujoGas = ctrlUtilities.activarAlarma(frmProceso.lblFlujoGas, ctrlUtilities.ACTIVO, ctrlUtilities.BAJA);
        } else {
            frmProceso.lblFlujoGas = ctrlUtilities.activarAlarma(frmProceso.lblFlujoGas, ctrlUtilities.INACTIVO, ctrlUtilities.INACTIVO);
        }
        //Presion Linea
        if (proceso.getPresionLinea() > procesoAlarmas.getPresionLineaMax() && procesoAlarmas.isPresionLineaEnable()) {
            frmProceso.lblPresionLinea = ctrlUtilities.activarAlarma(frmProceso.lblPresionLinea, ctrlUtilities.ACTIVO, ctrlUtilities.ALTA);
        } else if (proceso.getPresionLinea() < procesoAlarmas.getPresionLineaMin() && procesoAlarmas.isPresionLineaEnable()) {
            frmProceso.lblPresionLinea = ctrlUtilities.activarAlarma(frmProceso.lblPresionLinea, ctrlUtilities.ACTIVO, ctrlUtilities.BAJA);
        } else {
            frmProceso.lblPresionLinea = ctrlUtilities.activarAlarma(frmProceso.lblPresionLinea, ctrlUtilities.INACTIVO, ctrlUtilities.INACTIVO);
        }
    }

    public void visualizarVariablesProceso(String idPozo) {
        ProcesoAlarmas verificarVariables = new ProcesoAlarmas();
        verificarVariables.setIdPozo(idPozo);
        try {
            if (ctrlProcesoAlarmas.procesoAlarmasC.buscarAlarmas(verificarVariables)) {
                if (verificarVariables.isPresionCabezaActive()) {
                    frmProceso.lblPresionCabeza.setVisible(true);
                } else {
                    frmProceso.lblPresionCabeza.setVisible(false);
                }
                if (verificarVariables.isTemperaturaCabezaActive()) {
                    frmProceso.lblTemperaturaCabeza.setVisible(true);
                } else {
                    frmProceso.lblTemperaturaCabeza.setVisible(false);
                }
                if (verificarVariables.isPresionCasingActive()) {
                    frmProceso.lblPresionCasing.setVisible(true);
                } else {
                    frmProceso.lblPresionCasing.setVisible(false);
                }
                if (verificarVariables.isPresionChokeActive()) {
                    frmProceso.lblPresionChoke.setVisible(true);
                } else {
                    frmProceso.lblPresionChoke.setVisible(false);
                }
                if (verificarVariables.isFlujoDiluyenteActive()) {
                    frmProceso.lblFlujoDiluyente.setVisible(true);
                } else {
                    frmProceso.lblFlujoDiluyente.setVisible(false);
                }
                if (verificarVariables.isPresionMezcladorActive()) {
                    frmProceso.lblPresionMezclador.setVisible(true);
                } else {
                    frmProceso.lblPresionMezclador.setVisible(false);
                }
                if (verificarVariables.isPresionSepActive()) {
                    frmProceso.lblPresionSep.setVisible(true);
                } else {
                    frmProceso.lblPresionSep.setVisible(false);
                }
                if (verificarVariables.isTemperaturaSepActive()) {
                    frmProceso.lblTemperaturaSep.setVisible(true);
                } else {
                    frmProceso.lblTemperaturaSep.setVisible(false);
                }
                if (verificarVariables.isFlujoAceiteSepActive()) {
                    frmProceso.lblFlujoAceiteSep.setVisible(true);
                } else {
                    frmProceso.lblFlujoAceiteSep.setVisible(false);
                }
                if (verificarVariables.isFlujoAguaSepActive()) {
                    frmProceso.lblFlujoAguaSep.setVisible(true);
                } else {
                    frmProceso.lblFlujoAguaSep.setVisible(false);
                }
                if (verificarVariables.isPresionGasSepActive()) {
                    frmProceso.lblPresionGasSep.setVisible(true);
                } else {
                    frmProceso.lblPresionGasSep.setVisible(false);
                }
                if (verificarVariables.isTemperaturaGasSepActive()) {
                    frmProceso.lblTemperaturaGasSep.setVisible(true);
                } else {
                    frmProceso.lblTemperaturaGasSep.setVisible(false);
                }
                if (verificarVariables.isFlujoGasActive()) {
                    frmProceso.lblFlujoGas.setVisible(true);
                } else {
                    frmProceso.lblFlujoGas.setVisible(false);
                }
                if (verificarVariables.isPresionLineaActive()) {
                    frmProceso.lblPresionLinea.setVisible(true);
                } else {
                    frmProceso.lblPresionLinea.setVisible(false);

                }
            }
        } catch (SQLException ex) {
            System.err.println("Error al visualizar variables de proceso: " + ex);
        }
    }

}

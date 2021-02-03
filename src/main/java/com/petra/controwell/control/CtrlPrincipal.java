package com.petra.controwell.control;

import com.petra.controwell.control.internal.CtrlAforoTk;
import com.petra.controwell.control.internal.CtrlEditarProceso;
import com.petra.controwell.control.internal.CtrlGraficas;
import com.petra.controwell.control.internal.CtrlPermisos;
import com.petra.controwell.control.internal.CtrlPozos;
import com.petra.controwell.control.internal.CtrlProceso;
import com.petra.controwell.control.internal.CtrlProcesoAlarmas;
import com.petra.controwell.control.internal.CtrlReporte;
import com.petra.controwell.control.internal.CtrlTanques;
import com.petra.controwell.control.threads.CtrlActualizar;
import com.petra.controwell.view.FrmPrincipal;
import com.petra.controwell.view.internal.FrmAforoTk;
import com.petra.controwell.view.internal.FrmEditarProceso;
import com.petra.controwell.view.internal.FrmGraficas;
import com.petra.controwell.view.internal.FrmPozos;
import com.petra.controwell.view.internal.FrmProceso;
import com.petra.controwell.view.internal.FrmProcesoAlarmas;
import com.petra.controwell.view.internal.FrmReporte;
import com.petra.controwell.view.internal.FrmSeries;
import com.petra.controwell.view.internal.FrmTanques;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

/**
 *
 * @author Angello Morales
 */
public class CtrlPrincipal implements ActionListener {

	// vista
	public FrmPrincipal frmPrincipal;

	// modelo BD
	// modelo
	// controlador
	public CtrlPozos ctrlPozos;
	public CtrlProceso ctrlProceso;
	public CtrlProcesoAlarmas ctrlProcesoAlarmas;
	public CtrlActualizar ctrlActualizar;
	public CtrlAforoTk ctrlAforoTk;
	public CtrlTanques ctrlTanques;
	public CtrlGraficas ctrlGraficas;
	public CtrlReporte ctrlReporte;
	public CtrlEditarProceso ctrlEditarProceso;
	public CtrlPermisos ctrlPermisos;

	public CtrlPrincipal(FrmPrincipal frmPrincipal, FrmProceso frmProceso, FrmProcesoAlarmas frmProcesoAlarmas,
			FrmPozos frmPozos, FrmAforoTk frmAforoTk, FrmTanques frmTanques, FrmGraficas frmGraficas,
			FrmReporte frmReporte, FrmSeries frmSeries, FrmEditarProceso frmEditarProceso, CtrlPozos ctrlPozos,
			CtrlProceso ctrlProceso, CtrlProcesoAlarmas ctrlProcesoAlarmas, CtrlActualizar ctrlActualizar,
			CtrlAforoTk ctrlAforoTk, CtrlTanques ctrlTanques, CtrlGraficas ctrlGraficas, CtrlReporte ctrlReporte,
			CtrlEditarProceso ctrlEditarProceso, CtrlPermisos ctrlPermisos) {
		this.frmPrincipal = frmPrincipal;
		this.ctrlPozos = ctrlPozos;
		this.ctrlProceso = ctrlProceso;
		this.ctrlProcesoAlarmas = ctrlProcesoAlarmas;
		this.ctrlActualizar = ctrlActualizar;
		this.ctrlAforoTk = ctrlAforoTk;
		this.ctrlTanques = ctrlTanques;
		this.ctrlGraficas = ctrlGraficas;
		this.ctrlReporte = ctrlReporte;
		this.ctrlEditarProceso = ctrlEditarProceso;
		this.ctrlPermisos = ctrlPermisos;

		// agregar listener a los botones dentro del constructor
		this.frmPrincipal.mntmPozos.addActionListener(this);
		this.frmPrincipal.mntmAlarmProceso.addActionListener(this);
		this.frmPrincipal.mntmAforoTk.addActionListener(this);
		this.frmPrincipal.mntmEditarTanques.addActionListener(this);
		this.frmPrincipal.mntmGraficas.addActionListener(this);
		this.frmPrincipal.mntmReporte.addActionListener(this);
		this.frmPrincipal.mntmEditarVariables.addActionListener(this);

		// agregar ventanas
		frmPrincipal.escritorio.add(frmProceso);
		frmPrincipal.escritorio.add(frmPozos);
		frmPrincipal.escritorio.add(frmProcesoAlarmas);
		frmPrincipal.escritorio.add(frmAforoTk);
		frmPrincipal.escritorio.add(frmTanques);
		frmPrincipal.escritorio.add(frmGraficas);
		frmPrincipal.escritorio.add(frmReporte);
		frmPrincipal.escritorio.add(frmSeries);
		frmPrincipal.escritorio.add(frmEditarProceso);

	}

	public void iniciar() throws HeadlessException, SQLException {
		if (ctrlPermisos.concederAcceso()) {
			frmPrincipal.setTitle("ControWell");
			frmPrincipal.setLocationRelativeTo(null);
			frmPrincipal.setVisible(true);
			this.ventanaDefault();
		}else {
			JOptionPane.showMessageDialog(null, "no se encontro licencia valida");
			System.exit(0);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// acciones a ejecutar cuando se presiona un elemento en la pantalla
		// if por cada elemento para detectar cual se presiono
		// --------Menu Pozos---------
		if (e.getSource() == frmPrincipal.mntmPozos) {

			try {
				ctrlPozos.iniciar();
			} catch (PropertyVetoException ex) {
				Logger.getLogger(CtrlPrincipal.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		// --------Menu Variables de Proceso---------
		if (e.getSource() == frmPrincipal.mntmAlarmProceso) {

			try {
				ctrlProcesoAlarmas.iniciar();
			} catch (PropertyVetoException ex) {
				Logger.getLogger(CtrlPrincipal.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		// --------Menu Aforos---------
		if (e.getSource() == frmPrincipal.mntmAforoTk) {

			try {
				ctrlAforoTk.iniciar();
			} catch (PropertyVetoException ex) {
				Logger.getLogger(CtrlPrincipal.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		// --------Menu Tanques---------
		if (e.getSource() == frmPrincipal.mntmEditarTanques) {

			try {
				ctrlTanques.iniciar();
			} catch (PropertyVetoException ex) {
				Logger.getLogger(CtrlPrincipal.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		// --------Menu Graficas---------
		if (e.getSource() == frmPrincipal.mntmGraficas) {

			try {
				ctrlGraficas.iniciar();
			} catch (PropertyVetoException ex) {
				Logger.getLogger(CtrlPrincipal.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		// --------Menu Reportes---------
		if (e.getSource() == frmPrincipal.mntmReporte) {

			try {
				ctrlReporte.iniciar();
			} catch (PropertyVetoException ex) {
				Logger.getLogger(CtrlPrincipal.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		// --------Menu Editar Proceso---------
		if (e.getSource() == frmPrincipal.mntmEditarVariables) {

			try {
				ctrlEditarProceso.iniciar();
			} catch (PropertyVetoException ex) {
				Logger.getLogger(CtrlPrincipal.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	public void ventanaDefault() {
		ctrlProceso.iniciar();
		ctrlPozos.actualizarListado();
		ctrlTanques.actualizarListado();

		// --------hilo de actualizacion------
		// ctrlActualizar.start();

	}
}

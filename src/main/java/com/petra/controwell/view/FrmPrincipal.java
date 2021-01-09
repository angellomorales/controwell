package com.petra.controwell.view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;

public class FrmPrincipal extends JFrame {

	public JDesktopPane escritorio;
	public JMenuItem mntmAforoTk;
	public JMenu mnAnalisis;
	public JMenu mnConfig;
	public JMenuItem mntmGraficas;
	public JMenuItem mntmPozos;
	public JMenuBar mnPrincipal;
	public JMenuItem mntmReporte;
	public JMenu mnTanque;
	public JMenuItem mntmEditarTanques;
	public JMenuItem mntmAlarmProceso;
	public JMenu mnVariablesProceso;
	public JMenuItem mntmEditarVariables;

	public FrmPrincipal() {
		initComponents();
	}

	private void initComponents() {

		escritorio = new JDesktopPane();
		mnPrincipal = new JMenuBar();
		mnAnalisis = new JMenu("Análisis");
		mntmGraficas = new JMenuItem("Gráficas");
		mntmReporte = new JMenuItem("Reportes");
		mnConfig = new JMenu("Configuración");
		mnTanque = new JMenu("Tanques");
		mntmEditarTanques = new JMenuItem("Editar Tanques");
		mntmAforoTk = new JMenuItem("Cargar Aforos");
		mntmPozos = new JMenuItem("Pozos...");
		mntmAlarmProceso = new JMenuItem("Alarmas de Proceso");
		mnVariablesProceso = new JMenu("Variables Proceso");
		mntmEditarVariables = new JMenuItem("Editar Variables");

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBackground(new Color(255, 255, 255));
		setIconImage(new ImageIcon(getClass().getResource("/img/ico.png")).getImage());
		setResizable(false);
		setSize(new java.awt.Dimension(1280, 768));
		getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
		getContentPane().add(escritorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1298, 627));
		escritorio.getAccessibleContext().setAccessibleDescription("");
		
		mnAnalisis.add(mntmGraficas);
		mnAnalisis.add(mntmReporte);

		mnTanque.add(mntmEditarTanques);
		mnTanque.add(mntmAforoTk);

		mnConfig.add(mnTanque);
		mnConfig.add(mntmPozos);
		mnConfig.add(mnVariablesProceso);

		mnVariablesProceso.add(mntmAlarmProceso);
		mnVariablesProceso.add(mntmEditarVariables);
		
		mnPrincipal.add(mnAnalisis);
		mnPrincipal.add(mnConfig);
		setJMenuBar(mnPrincipal);

		pack();
	}
}

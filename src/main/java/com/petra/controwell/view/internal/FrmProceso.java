package com.petra.controwell.view.internal;

import javax.swing.JInternalFrame;

public class FrmProceso extends JInternalFrame {

	public javax.swing.JButton btnLiquidacionTk;
	public javax.swing.JComboBox<String> cmbxIdPozo;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel lblBackground;
	public javax.swing.JLabel lblFecha;
	public javax.swing.JLabel lblFlujoAceiteSep;
	public javax.swing.JLabel lblFlujoAguaSep;
	public javax.swing.JLabel lblFlujoDiluyente;
	public javax.swing.JLabel lblFlujoGas;
	public javax.swing.JLabel lblHora;
	public javax.swing.JLabel lblPresionCabeza;
	public javax.swing.JLabel lblPresionCasing;
	public javax.swing.JLabel lblPresionChoke;
	public javax.swing.JLabel lblPresionGasSep;
	public javax.swing.JLabel lblPresionLinea;
	public javax.swing.JLabel lblPresionMezclador;
	public javax.swing.JLabel lblPresionSep;
	public javax.swing.JLabel lblTemperaturaCabeza;
	public javax.swing.JLabel lblTemperaturaGasSep;
	public javax.swing.JLabel lblTemperaturaSep;

	public FrmProceso() {
		initComponents();
	}

	private void initComponents() {

		lblPresionCabeza = new javax.swing.JLabel();
		lblTemperaturaCabeza = new javax.swing.JLabel();
		lblPresionCasing = new javax.swing.JLabel();
		lblPresionChoke = new javax.swing.JLabel();
		lblFlujoDiluyente = new javax.swing.JLabel();
		lblPresionMezclador = new javax.swing.JLabel();
		lblFlujoAguaSep = new javax.swing.JLabel();
		lblTemperaturaSep = new javax.swing.JLabel();
		lblPresionSep = new javax.swing.JLabel();
		lblFlujoAceiteSep = new javax.swing.JLabel();
		lblPresionGasSep = new javax.swing.JLabel();
		lblTemperaturaGasSep = new javax.swing.JLabel();
		lblPresionLinea = new javax.swing.JLabel();
		lblFlujoGas = new javax.swing.JLabel();
		btnLiquidacionTk = new javax.swing.JButton();
		jLabel3 = new javax.swing.JLabel();
		cmbxIdPozo = new javax.swing.JComboBox<>();
		lblFecha = new javax.swing.JLabel();
		lblHora = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		lblBackground = new javax.swing.JLabel();

		getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		lblPresionCabeza.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		lblPresionCabeza.setText("HeadPress");
		getContentPane().add(lblPresionCabeza, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 450, -1, 30));

		lblTemperaturaCabeza.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		lblTemperaturaCabeza.setText("HeadTemp");
		getContentPane().add(lblTemperaturaCabeza,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 400, -1, 30));

		lblPresionCasing.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		lblPresionCasing.setText("CasingPress");
		getContentPane().add(lblPresionCasing, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 550, -1, 30));

		lblPresionChoke.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		lblPresionChoke.setText("ChokePress");
		getContentPane().add(lblPresionChoke, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 420, -1, 30));

		lblFlujoDiluyente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		lblFlujoDiluyente.setText("DiluentFlow");
		getContentPane().add(lblFlujoDiluyente, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 370, -1, 30));

		lblPresionMezclador.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		lblPresionMezclador.setText("MixedPress");
		getContentPane().add(lblPresionMezclador, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 440, -1, 30));

		lblFlujoAguaSep.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		lblFlujoAguaSep.setText("WaterFlow");
		getContentPane().add(lblFlujoAguaSep, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, -1, 30));

		lblTemperaturaSep.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		lblTemperaturaSep.setText("SepTemp");
		getContentPane().add(lblTemperaturaSep, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, 30));

		lblPresionSep.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		lblPresionSep.setText("SepPress");
		getContentPane().add(lblPresionSep, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, 30));

		lblFlujoAceiteSep.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		lblFlujoAceiteSep.setText("OilFlow");
		getContentPane().add(lblFlujoAceiteSep, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, -1, 30));

		lblPresionGasSep.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		lblPresionGasSep.setText("GasPress");
		getContentPane().add(lblPresionGasSep, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, -1, 30));

		lblTemperaturaGasSep.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		lblTemperaturaGasSep.setText("GasTemp");
		getContentPane().add(lblTemperaturaGasSep, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, -1, 30));

		lblPresionLinea.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		lblPresionLinea.setText("LinePress");
		getContentPane().add(lblPresionLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 230, -1, 30));

		lblFlujoGas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		lblFlujoGas.setText("GasFlow");
		getContentPane().add(lblFlujoGas, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, -1, 30));

		btnLiquidacionTk.setText("Tanques");
		getContentPane().add(btnLiquidacionTk, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 280, -1, -1));

		jLabel3.setText("Pozo:");
		getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

		getContentPane().add(cmbxIdPozo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 100, -1));

		lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblFecha.setText("fecha");
		getContentPane().add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 170, -1));

		lblHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblHora.setText("hora");
		getContentPane().add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 160, -1));

		jLabel4.setText("Ultima actualización:");
		getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

		lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Background.png"))); // NOI18N
		getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, -1, -1));

		pack();
	}
}

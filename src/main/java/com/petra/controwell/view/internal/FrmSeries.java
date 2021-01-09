package com.petra.controwell.view.internal;

import javax.swing.JInternalFrame;

public class FrmSeries extends JInternalFrame {

	public javax.swing.JButton btnAceptar;
	public javax.swing.JCheckBox chkAceiteProducido;
	public javax.swing.JCheckBox chkAguaProducida;
	public javax.swing.JCheckBox chkDiluyenteInyectado;
	public javax.swing.JCheckBox chkFlujoAceite;
	public javax.swing.JCheckBox chkFlujoAgua;
	public javax.swing.JCheckBox chkFlujoDiluyente;
	public javax.swing.JCheckBox chkFlujoGas;
	public javax.swing.JCheckBox chkGasProducido;
	public javax.swing.JCheckBox chkHoras;
	public javax.swing.JCheckBox chkNSVconDiluyente;
	public javax.swing.JCheckBox chkPresionCabeza;
	public javax.swing.JCheckBox chkPresionCasing;
	public javax.swing.JCheckBox chkPresionChoke;
	public javax.swing.JCheckBox chkPresionGas;
	public javax.swing.JCheckBox chkPresionLinea;
	public javax.swing.JCheckBox chkPresionMezclador;
	public javax.swing.JCheckBox chkPresionSeparador;
	public javax.swing.JCheckBox chkSYW;
	public javax.swing.JCheckBox chkTemperaturaCabeza;
	public javax.swing.JCheckBox chkTemperaturaGas;
	public javax.swing.JCheckBox chkTemperaturaSeparador;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JSeparator jSeparator2;
	public javax.swing.JPanel panelFlujo;
	public javax.swing.JPanel panelPresion;
	public javax.swing.JPanel panelProduccion;
	public javax.swing.JPanel panelTemperatura;

	public FrmSeries() {
		initComponents();
	}

	private void initComponents() {

		btnAceptar = new javax.swing.JButton();
		panelPresion = new javax.swing.JPanel();
		chkPresionCabeza = new javax.swing.JCheckBox();
		chkPresionCasing = new javax.swing.JCheckBox();
		chkPresionChoke = new javax.swing.JCheckBox();
		chkPresionLinea = new javax.swing.JCheckBox();
		chkPresionMezclador = new javax.swing.JCheckBox();
		chkPresionGas = new javax.swing.JCheckBox();
		chkPresionSeparador = new javax.swing.JCheckBox();
		jSeparator1 = new javax.swing.JSeparator();
		panelTemperatura = new javax.swing.JPanel();
		chkTemperaturaCabeza = new javax.swing.JCheckBox();
		chkTemperaturaGas = new javax.swing.JCheckBox();
		chkTemperaturaSeparador = new javax.swing.JCheckBox();
		panelFlujo = new javax.swing.JPanel();
		chkFlujoAceite = new javax.swing.JCheckBox();
		chkFlujoAgua = new javax.swing.JCheckBox();
		chkFlujoGas = new javax.swing.JCheckBox();
		chkFlujoDiluyente = new javax.swing.JCheckBox();
		panelProduccion = new javax.swing.JPanel();
		jSeparator2 = new javax.swing.JSeparator();
		chkAceiteProducido = new javax.swing.JCheckBox();
		chkAguaProducida = new javax.swing.JCheckBox();
		chkNSVconDiluyente = new javax.swing.JCheckBox();
		chkDiluyenteInyectado = new javax.swing.JCheckBox();
		chkSYW = new javax.swing.JCheckBox();
		chkGasProducido = new javax.swing.JCheckBox();
		chkHoras = new javax.swing.JCheckBox();
		jLabel1 = new javax.swing.JLabel();

		setClosable(true);
		setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
		setPreferredSize(new java.awt.Dimension(300, 570));
		getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		btnAceptar.setText("Aceptar");
		getContentPane().add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 510, -1, -1));

		panelPresion.setBorder(javax.swing.BorderFactory.createTitledBorder("Variables Presión"));
		panelPresion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		chkPresionCabeza.setText("Presión Cabeza");
		panelPresion.add(chkPresionCabeza, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

		chkPresionCasing.setText("Presión Casing");
		panelPresion.add(chkPresionCasing, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

		chkPresionChoke.setText("Presión Choke");
		panelPresion.add(chkPresionChoke, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

		chkPresionLinea.setText("Presión Línea");
		panelPresion.add(chkPresionLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

		chkPresionMezclador.setText("Presión Mezclador");
		panelPresion.add(chkPresionMezclador, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, -1, -1));

		chkPresionGas.setText("Presión Gas");
		panelPresion.add(chkPresionGas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

		chkPresionSeparador.setText("Presión Separador");
		panelPresion.add(chkPresionSeparador, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, -1, -1));
		panelPresion.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 108, 230, -1));

		getContentPane().add(panelPresion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 260, 140));

		panelTemperatura.setBorder(javax.swing.BorderFactory.createTitledBorder("Variables Temperatura"));
		panelTemperatura.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		chkTemperaturaCabeza.setText("Temperatura Cabeza");
		panelTemperatura.add(chkTemperaturaCabeza, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

		chkTemperaturaGas.setText("Temperatura Gas");
		panelTemperatura.add(chkTemperaturaGas, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

		chkTemperaturaSeparador.setText("Temperatura Separador");
		panelTemperatura.add(chkTemperaturaSeparador,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

		getContentPane().add(panelTemperatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 260, 80));

		panelFlujo.setBorder(javax.swing.BorderFactory.createTitledBorder("Variables Flujo"));
		panelFlujo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		chkFlujoAceite.setText("Flujo Aceite");
		panelFlujo.add(chkFlujoAceite, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

		chkFlujoAgua.setText("Flujo Agua");
		panelFlujo.add(chkFlujoAgua, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

		chkFlujoGas.setText("Flujo Gas");
		panelFlujo.add(chkFlujoGas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

		chkFlujoDiluyente.setText("Flujo Diluyente");
		panelFlujo.add(chkFlujoDiluyente, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, -1, -1));

		getContentPane().add(panelFlujo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 260, 80));

		panelProduccion.setBorder(javax.swing.BorderFactory.createTitledBorder("Producción"));
		panelProduccion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
		panelProduccion.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 230, 10));

		chkAceiteProducido.setText("Aceite Producido");
		panelProduccion.add(chkAceiteProducido, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

		chkAguaProducida.setText("Agua Producida");
		panelProduccion.add(chkAguaProducida, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

		chkNSVconDiluyente.setText("NSV con Diluyente");
		panelProduccion.add(chkNSVconDiluyente, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, -1, -1));

		chkDiluyenteInyectado.setText("Diluyente Inyectado");
		panelProduccion.add(chkDiluyenteInyectado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

		chkSYW.setText("% SYW");
		panelProduccion.add(chkSYW, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 83, -1, 20));

		chkGasProducido.setText("Gas Producido");
		panelProduccion.add(chkGasProducido, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 83, -1, 20));

		chkHoras.setText("Horas Operación");
		panelProduccion.add(chkHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

		getContentPane().add(panelProduccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 260, 140));

		jLabel1.setText("Seleccione las variables que desea Graficar:");
		getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

		pack();
	}

}

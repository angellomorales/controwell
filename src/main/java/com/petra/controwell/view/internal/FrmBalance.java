package com.petra.controwell.view.internal;

import javax.swing.JInternalFrame;

public class FrmBalance extends JInternalFrame {

	public javax.swing.JButton btnAPI;
	public javax.swing.JButton btnBorrarUltimo;
	public javax.swing.JButton btnLiquidar;
	public javax.swing.JButton btnMovimientos;
	public javax.swing.JComboBox<String> cmbxFluido;
	public javax.swing.JComboBox<String> cmbxIdPozo;
	public com.toedter.calendar.JDateChooser dtchFecha;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel15;
	private javax.swing.JLabel jLabel16;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel22;
	private javax.swing.JLabel jLabel23;
	private javax.swing.JLabel jLabel24;
	private javax.swing.JLabel jLabel25;
	private javax.swing.JLabel jLabel26;
	private javax.swing.JLabel jLabel27;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel31;
	private javax.swing.JLabel jLabel32;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JScrollPane jScrollPane4;
	private javax.swing.JScrollPane jScrollPane5;
	private javax.swing.JScrollPane jScrollPane6;
	private javax.swing.JScrollPane jScrollPane7;
	private javax.swing.JScrollPane jScrollPane8;
	public javax.swing.JLabel lblCerrado;
	public javax.swing.JLabel lblDiferencia;
	public javax.swing.JLabel lblDiferenciaAgua;
	public javax.swing.JLabel lblDiferenciaBalanceAgua;
	public javax.swing.JLabel lblDiferenciaBalanceNSV;
	public javax.swing.JLabel lblDiferenciaNSV;
	public javax.swing.JLabel lblTotalAguaFinal;
	public javax.swing.JLabel lblTotalAguaInicial;
	public javax.swing.JLabel lblTotalNSVFinal;
	public javax.swing.JLabel lblTotalNSVInicial;
	public javax.swing.JPanel panelBalance;
	private javax.swing.JPanel panelContenedor;
	private javax.swing.JPanel panelDatos;
	private javax.swing.JPanel panelEstadoActual;
	public javax.swing.JPanel panelFinal;
	public javax.swing.JPanel panelInicial;
	private javax.swing.JPanel panelLaboratorio;
	public javax.swing.JPanel panelMovimientosAgua;
	public javax.swing.JPanel panelMovimientosNSV;
	public javax.swing.JPanel panelProduccionDiaria;
	private javax.swing.JPanel panelTanques;
	public javax.swing.JTable tbEstadoTanques;
	public javax.swing.JTable tbFinal;
	public javax.swing.JTable tbInicial;
	public javax.swing.JTable tbMovimientosAgua;
	public javax.swing.JTable tbMovimientosNSV;
	public javax.swing.JTable tbProduccion;
	public javax.swing.JTextField txtApiCabeza;
	public javax.swing.JTextField txtChoke;
	public javax.swing.JTextField txtCloruros;
	public javax.swing.JTextArea txtComentarios;
	public javax.swing.JTextField txtHorasPrueba;
	public javax.swing.JTextField txtPh;
	public javax.swing.JTextField txtSalinidad;
	public javax.swing.JTextField txtTempViscocidad;
	public javax.swing.JTextField txtViscocidad;

	public FrmBalance() {
		initComponents();

	}

	private void initComponents() {

		jScrollPane8 = new javax.swing.JScrollPane();
		panelContenedor = new javax.swing.JPanel();
		panelEstadoActual = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		tbEstadoTanques = new javax.swing.JTable();
		btnMovimientos = new javax.swing.JButton();
		panelBalance = new javax.swing.JPanel();
		panelProduccionDiaria = new javax.swing.JPanel();
		jScrollPane6 = new javax.swing.JScrollPane();
		tbProduccion = new javax.swing.JTable();
		btnLiquidar = new javax.swing.JButton();
		btnBorrarUltimo = new javax.swing.JButton();
		lblDiferencia = new javax.swing.JLabel();
		lblDiferenciaBalanceNSV = new javax.swing.JLabel();
		lblDiferenciaNSV = new javax.swing.JLabel();
		lblDiferenciaAgua = new javax.swing.JLabel();
		lblDiferenciaBalanceAgua = new javax.swing.JLabel();
		panelDatos = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		cmbxIdPozo = new javax.swing.JComboBox<>();
		jLabel31 = new javax.swing.JLabel();
		dtchFecha = new com.toedter.calendar.JDateChooser();
		lblCerrado = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		txtHorasPrueba = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		jLabel32 = new javax.swing.JLabel();
		jScrollPane7 = new javax.swing.JScrollPane();
		txtComentarios = new javax.swing.JTextArea();
		jLabel7 = new javax.swing.JLabel();
		txtChoke = new javax.swing.JTextField();
		jLabel10 = new javax.swing.JLabel();
		panelTanques = new javax.swing.JPanel();
		panelInicial = new javax.swing.JPanel();
		jScrollPane2 = new javax.swing.JScrollPane();
		tbInicial = new javax.swing.JTable();
		jLabel22 = new javax.swing.JLabel();
		lblTotalNSVInicial = new javax.swing.JLabel();
		jLabel23 = new javax.swing.JLabel();
		lblTotalAguaInicial = new javax.swing.JLabel();
		jLabel24 = new javax.swing.JLabel();
		panelFinal = new javax.swing.JPanel();
		jScrollPane3 = new javax.swing.JScrollPane();
		tbFinal = new javax.swing.JTable();
		jLabel25 = new javax.swing.JLabel();
		lblTotalNSVFinal = new javax.swing.JLabel();
		jLabel26 = new javax.swing.JLabel();
		jLabel27 = new javax.swing.JLabel();
		lblTotalAguaFinal = new javax.swing.JLabel();
		panelMovimientosNSV = new javax.swing.JPanel();
		jScrollPane4 = new javax.swing.JScrollPane();
		tbMovimientosNSV = new javax.swing.JTable();
		panelMovimientosAgua = new javax.swing.JPanel();
		jScrollPane5 = new javax.swing.JScrollPane();
		tbMovimientosAgua = new javax.swing.JTable();
		jLabel4 = new javax.swing.JLabel();
		cmbxFluido = new javax.swing.JComboBox<>();
		panelLaboratorio = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		txtApiCabeza = new javax.swing.JTextField();
		btnAPI = new javax.swing.JButton();
		jLabel2 = new javax.swing.JLabel();
		txtCloruros = new javax.swing.JTextField();
		jLabel8 = new javax.swing.JLabel();
		txtPh = new javax.swing.JTextField();
		jLabel9 = new javax.swing.JLabel();
		txtViscocidad = new javax.swing.JTextField();
		jLabel13 = new javax.swing.JLabel();
		jLabel14 = new javax.swing.JLabel();
		txtSalinidad = new javax.swing.JTextField();
		jLabel15 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		txtTempViscocidad = new javax.swing.JTextField();
		jLabel16 = new javax.swing.JLabel();

		setPreferredSize(new java.awt.Dimension(980, 600));
		setVisible(true);

		panelContenedor.setPreferredSize(new java.awt.Dimension(970, 729));
		panelContenedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		panelEstadoActual.setBorder(javax.swing.BorderFactory.createTitledBorder("Estado Actual de los Tanques"));
		panelEstadoActual.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jScrollPane1.setAutoscrolls(true);

		tbEstadoTanques.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null } },
				new String[] { "ID Tanques", "ID Pozo", "Nivel", "Interfase", "S&W", "NSV", "Agua",
						"Ultimo Movimiento" }));
		jScrollPane1.setViewportView(tbEstadoTanques);

		panelEstadoActual.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 780, 120));

		panelContenedor.add(panelEstadoActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 800, 150));

		btnMovimientos.setText("Realizar Movimiento");
		panelContenedor.add(btnMovimientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 50, 100, 50));

		panelBalance.setBorder(javax.swing.BorderFactory.createTitledBorder("Balance"));
		panelBalance.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		panelProduccionDiaria.setBorder(javax.swing.BorderFactory.createTitledBorder("Produccion Diaria"));
		panelProduccionDiaria.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jScrollPane6.setAutoscrolls(true);

		tbProduccion
				.setModel(
						new javax.swing.table.DefaultTableModel(
								new Object[][] { { "NSV con diluyente", null, null }, { "NSV aceite", null, null },
										{ "Agua", null, null }, { "Diluyente", null, null }, { "%SYW", null, null },
										{ "Gas", null, null } },
								new String[] { "VOLUMEN", "PRODUCCION", "PROYECTADO 24H" }));
		tbProduccion.setEnabled(false);
		jScrollPane6.setViewportView(tbProduccion);

		panelProduccionDiaria.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 260, 130));

		btnLiquidar.setText("Registrar Día");
		btnLiquidar.setEnabled(false);
		panelProduccionDiaria.add(btnLiquidar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 100, 20));

		btnBorrarUltimo.setText("Borrar último");
		panelProduccionDiaria.add(btnBorrarUltimo,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 100, 20));

		lblDiferencia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		lblDiferencia.setText("Diferencia:");
		panelProduccionDiaria.add(lblDiferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, 10));

		lblDiferenciaBalanceNSV.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		lblDiferenciaBalanceNSV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblDiferenciaBalanceNSV.setText("0");
		lblDiferenciaBalanceNSV.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
		panelProduccionDiaria.add(lblDiferenciaBalanceNSV,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 40, -1));

		lblDiferenciaNSV.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		lblDiferenciaNSV.setText("NSV");
		panelProduccionDiaria.add(lblDiferenciaNSV, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, -1, -1));

		lblDiferenciaAgua.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		lblDiferenciaAgua.setForeground(new java.awt.Color(0, 0, 153));
		lblDiferenciaAgua.setText("AGUA");
		panelProduccionDiaria.add(lblDiferenciaAgua,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, -1, -1));

		lblDiferenciaBalanceAgua.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		lblDiferenciaBalanceAgua.setForeground(new java.awt.Color(0, 0, 153));
		lblDiferenciaBalanceAgua.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblDiferenciaBalanceAgua.setText("0");
		lblDiferenciaBalanceAgua.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 153), 1, true));
		panelProduccionDiaria.add(lblDiferenciaBalanceAgua,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 40, -1));

		panelBalance.add(panelProduccionDiaria, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 370, 200));

		panelDatos.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));
		panelDatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jLabel3.setText("Pozo:");
		panelDatos.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

		cmbxIdPozo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Well 1", "Well 2", "Well 3" }));
		panelDatos.add(cmbxIdPozo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

		jLabel31.setText("Fecha:");
		panelDatos.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));
		panelDatos.add(dtchFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 90, -1));

		lblCerrado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		lblCerrado.setForeground(new java.awt.Color(255, 0, 0));
		lblCerrado.setText(" DIA CERRADO");
		panelDatos.add(lblCerrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));

		jLabel6.setText("Tiempo de prueba:");
		panelDatos.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

		txtHorasPrueba.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		txtHorasPrueba.setText("24");
		panelDatos.add(txtHorasPrueba, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 30, -1));

		jLabel5.setText(" /64");
		panelDatos.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, -1, -1));

		jLabel32.setText("Comentarios:");
		panelDatos.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 70, -1));

		txtComentarios.setColumns(20);
		txtComentarios.setRows(5);
		jScrollPane7.setViewportView(txtComentarios);

		panelDatos.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 350, 50));

		jLabel7.setText("Choke:");
		panelDatos.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, -1, -1));

		txtChoke.setText("N/A");
		panelDatos.add(txtChoke, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 40, -1));

		jLabel10.setText("  Horas");
		panelDatos.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, -1, -1));

		panelBalance.add(panelDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 370, 170));

		panelTanques.setBorder(javax.swing.BorderFactory.createTitledBorder("Tanques"));
		panelTanques.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		panelInicial.setBorder(javax.swing.BorderFactory.createTitledBorder("Inicial"));
		panelInicial.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jScrollPane2.setAutoscrolls(true);

		tbInicial.setModel(
				new javax.swing.table.DefaultTableModel(new Object[][] { { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null } }, new String[] { "ID Tanques", "NSV", "Agua" }));
		tbInicial.setEnabled(false);
		jScrollPane2.setViewportView(tbInicial);

		panelInicial.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 200, 100));

		jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		jLabel22.setText("TOTAL:");
		panelInicial.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, 10));

		lblTotalNSVInicial.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		lblTotalNSVInicial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblTotalNSVInicial.setText("0");
		lblTotalNSVInicial.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
		panelInicial.add(lblTotalNSVInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 60, -1));

		jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		jLabel23.setText("NSV");
		panelInicial.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, -1, -1));

		lblTotalAguaInicial.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		lblTotalAguaInicial.setForeground(new java.awt.Color(0, 0, 153));
		lblTotalAguaInicial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblTotalAguaInicial.setText("0");
		lblTotalAguaInicial.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 153), 1, true));
		panelInicial.add(lblTotalAguaInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 60, -1));

		jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		jLabel24.setForeground(new java.awt.Color(0, 0, 153));
		jLabel24.setText("AGUA");
		panelInicial.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, -1, -1));

		panelTanques.add(panelInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 220, 180));

		panelFinal.setBorder(javax.swing.BorderFactory.createTitledBorder("Final"));
		panelFinal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jScrollPane3.setAutoscrolls(true);

		tbFinal.setModel(
				new javax.swing.table.DefaultTableModel(new Object[][] { { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null } }, new String[] { "ID Tanques", "NSV", "Agua" }));
		tbFinal.setEnabled(false);
		jScrollPane3.setViewportView(tbFinal);

		panelFinal.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 200, 100));

		jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		jLabel25.setText("TOTAL:");
		panelFinal.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, 10));

		lblTotalNSVFinal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		lblTotalNSVFinal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblTotalNSVFinal.setText("0");
		lblTotalNSVFinal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
		panelFinal.add(lblTotalNSVFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 60, -1));

		jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		jLabel26.setText("NSV");
		panelFinal.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, -1, -1));

		jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		jLabel27.setForeground(new java.awt.Color(0, 0, 153));
		jLabel27.setText("AGUA");
		panelFinal.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, -1, -1));

		lblTotalAguaFinal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		lblTotalAguaFinal.setForeground(new java.awt.Color(0, 0, 153));
		lblTotalAguaFinal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblTotalAguaFinal.setText("0");
		lblTotalAguaFinal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 153), 1, true));
		panelFinal.add(lblTotalAguaFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 60, -1));

		panelTanques.add(panelFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 220, 180));

		panelMovimientosNSV.setBorder(javax.swing.BorderFactory.createTitledBorder("Movimientos NSV"));
		panelMovimientosNSV.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jScrollPane4.setAutoscrolls(true);

		tbMovimientosNSV.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null } },
				new String[] { "ID Tanques", "Recibo", "Entrega", "Inyeccion", "Transferencia", "Drenaje",
						"Consumo" }));
		tbMovimientosNSV.setEnabled(false);
		jScrollPane4.setViewportView(tbMovimientosNSV);

		panelMovimientosNSV.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 450, 100));

		panelTanques.add(panelMovimientosNSV, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 470, 130));

		panelMovimientosAgua.setBorder(javax.swing.BorderFactory.createTitledBorder("Movimientos Agua"));
		panelMovimientosAgua.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jScrollPane5.setAutoscrolls(true);

		tbMovimientosAgua.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null } },
				new String[] { "ID Tanques", "Recibo", "Entrega", "Inyeccion", "Transferencia", "Drenaje",
						"Consumo" }));
		tbMovimientosAgua.setEnabled(false);
		jScrollPane5.setViewportView(tbMovimientosAgua);

		panelMovimientosAgua.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 450, 100));

		panelTanques.add(panelMovimientosAgua, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 470, 130));

		jLabel4.setText("Fluido:");
		panelTanques.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

		cmbxFluido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Crudo", "Diluyente" }));
		panelTanques.add(cmbxFluido, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

		panelBalance.add(panelTanques, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 490, 520));

		panelLaboratorio.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del día Laboratorio"));
		panelLaboratorio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jLabel1.setText("API@60 Cabeza:");
		panelLaboratorio.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

		txtApiCabeza.setText("N/A");
		panelLaboratorio.add(txtApiCabeza, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 40, -1));

		btnAPI.setText("API obs");
		panelLaboratorio.add(btnAPI, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, -1, -1));

		jLabel2.setText("Cloruros:");
		panelLaboratorio.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

		txtCloruros.setText("N/A");
		panelLaboratorio.add(txtCloruros, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 40, -1));

		jLabel8.setText("Ph:");
		panelLaboratorio.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, -1, -1));

		txtPh.setText("N/A");
		panelLaboratorio.add(txtPh, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 40, -1));

		jLabel9.setText("Viscocidad:");
		panelLaboratorio.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

		txtViscocidad.setText("N/A");
		panelLaboratorio.add(txtViscocidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 40, -1));

		jLabel13.setText(" ppm");
		panelLaboratorio.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, -1, -1));

		jLabel14.setText("Salinidad:");
		panelLaboratorio.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));

		txtSalinidad.setText("N/A");
		panelLaboratorio.add(txtSalinidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 30, -1));

		jLabel15.setText(" PTB");
		panelLaboratorio.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, -1));

		jLabel11.setText(" Cp @ Temp:");
		panelLaboratorio.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

		txtTempViscocidad.setText("N/A");
		panelLaboratorio.add(txtTempViscocidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 40, -1));

		jLabel16.setText("°F");
		panelLaboratorio.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));

		panelBalance.add(panelLaboratorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 370, 130));

		panelContenedor.add(panelBalance, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 910, 550));

		jScrollPane8.setViewportView(panelContenedor);

		getContentPane().add(jScrollPane8, java.awt.BorderLayout.CENTER);

		pack();
	}

}

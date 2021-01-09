package com.petra.controwell.view.internal;

import javax.swing.JInternalFrame;

public class FrmOperacionTk extends JInternalFrame {

	public javax.swing.JButton btnAPI;
	public javax.swing.JButton btnBorrarUltimo;
	public javax.swing.JButton btnCalcular;
	public javax.swing.JButton btnCerrar;
	public javax.swing.JButton btnGuardar;
	public javax.swing.ButtonGroup btngrpFecha;
	public javax.swing.JComboBox<String> cmbxIdPozo;
	public javax.swing.JComboBox<String> cmbxIdTanque;
	public javax.swing.JComboBox<String> cmbxTipo;
	public com.toedter.calendar.JDateChooser dtchFecha;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel15;
	private javax.swing.JLabel jLabel16;
	private javax.swing.JLabel jLabel17;
	private javax.swing.JLabel jLabel18;
	private javax.swing.JLabel jLabel19;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel20;
	private javax.swing.JLabel jLabel21;
	private javax.swing.JLabel jLabel22;
	private javax.swing.JLabel jLabel23;
	private javax.swing.JLabel jLabel24;
	private javax.swing.JLabel jLabel25;
	private javax.swing.JLabel jLabel26;
	private javax.swing.JLabel jLabel27;
	private javax.swing.JLabel jLabel28;
	private javax.swing.JLabel jLabel29;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel30;
	private javax.swing.JLabel jLabel31;
	private javax.swing.JLabel jLabel32;
	private javax.swing.JLabel jLabel33;
	private javax.swing.JLabel jLabel34;
	private javax.swing.JLabel jLabel35;
	private javax.swing.JLabel jLabel36;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JScrollPane jScrollPane1;
	public javax.swing.JLabel lblAgua;
	public javax.swing.JLabel lblCSW;
	public javax.swing.JLabel lblCTL;
	public javax.swing.JLabel lblCTSh;
	public javax.swing.JLabel lblFW;
	public javax.swing.JLabel lblGOV;
	public javax.swing.JLabel lblGSV;
	public javax.swing.JLabel lblImagen;
	public javax.swing.JLabel lblNSV;
	public javax.swing.JLabel lblOperacionAgua;
	public javax.swing.JLabel lblOperacionNSV;
	public javax.swing.JLabel lblTOV;
	public javax.swing.JPanel panelCalculado;
	public javax.swing.JPanel panelDatos;
	public javax.swing.JPanel panelMovimientosDiarios;
	public javax.swing.JPanel panelVariables;
	public javax.swing.JRadioButton rdbtnFechaActual;
	public javax.swing.JRadioButton rdbtnFechaUltimo;
	public javax.swing.JSpinner spnHora;
	public javax.swing.JTable tbUltimaOp;
	public javax.swing.JTextField txtAPI;
	public javax.swing.JTextField txtInterfase;
	public javax.swing.JTextField txtNivel;
	public javax.swing.JTextField txtSYW;
	public javax.swing.JTextField txtTempAmbiente;
	public javax.swing.JTextField txtTempFluido;

	public FrmOperacionTk() {
		initComponents();
	}

	private void initComponents() {

		btngrpFecha = new javax.swing.ButtonGroup();
		btnCerrar = new javax.swing.JButton();
		panelVariables = new javax.swing.JPanel();
		jLabel10 = new javax.swing.JLabel();
		jLabel13 = new javax.swing.JLabel();
		jLabel16 = new javax.swing.JLabel();
		lblTOV = new javax.swing.JLabel();
		lblCTSh = new javax.swing.JLabel();
		lblCSW = new javax.swing.JLabel();
		lblGOV = new javax.swing.JLabel();
		jLabel12 = new javax.swing.JLabel();
		jLabel14 = new javax.swing.JLabel();
		lblCTL = new javax.swing.JLabel();
		jLabel18 = new javax.swing.JLabel();
		lblAgua = new javax.swing.JLabel();
		jLabel17 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		jLabel15 = new javax.swing.JLabel();
		lblGSV = new javax.swing.JLabel();
		lblFW = new javax.swing.JLabel();
		lblNSV = new javax.swing.JLabel();
		jLabel23 = new javax.swing.JLabel();
		jLabel30 = new javax.swing.JLabel();
		jLabel31 = new javax.swing.JLabel();
		jLabel32 = new javax.swing.JLabel();
		jLabel33 = new javax.swing.JLabel();
		jLabel34 = new javax.swing.JLabel();
		panelCalculado = new javax.swing.JPanel();
		lblOperacionNSV = new javax.swing.JLabel();
		lblOperacionAgua = new javax.swing.JLabel();
		jLabel20 = new javax.swing.JLabel();
		jLabel21 = new javax.swing.JLabel();
		btnGuardar = new javax.swing.JButton();
		jLabel19 = new javax.swing.JLabel();
		jLabel35 = new javax.swing.JLabel();
		jLabel36 = new javax.swing.JLabel();
		jLabel22 = new javax.swing.JLabel();
		spnHora = new javax.swing.JSpinner();
		jLabel24 = new javax.swing.JLabel();
		panelDatos = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		cmbxIdTanque = new javax.swing.JComboBox<>();
		jLabel3 = new javax.swing.JLabel();
		cmbxIdPozo = new javax.swing.JComboBox<>();
		cmbxTipo = new javax.swing.JComboBox<>();
		jLabel2 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		txtNivel = new javax.swing.JTextField();
		btnAPI = new javax.swing.JButton();
		txtInterfase = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		txtAPI = new javax.swing.JTextField();
		jLabel9 = new javax.swing.JLabel();
		txtSYW = new javax.swing.JTextField();
		jLabel7 = new javax.swing.JLabel();
		txtTempAmbiente = new javax.swing.JTextField();
		jLabel8 = new javax.swing.JLabel();
		txtTempFluido = new javax.swing.JTextField();
		btnCalcular = new javax.swing.JButton();
		btnBorrarUltimo = new javax.swing.JButton();
		jLabel25 = new javax.swing.JLabel();
		jLabel26 = new javax.swing.JLabel();
		jLabel27 = new javax.swing.JLabel();
		jLabel28 = new javax.swing.JLabel();
		jLabel29 = new javax.swing.JLabel();
		panelMovimientosDiarios = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		tbUltimaOp = new javax.swing.JTable();
		rdbtnFechaUltimo = new javax.swing.JRadioButton();
		rdbtnFechaActual = new javax.swing.JRadioButton();
		dtchFecha = new com.toedter.calendar.JDateChooser();
		lblImagen = new javax.swing.JLabel();

		setClosable(true);
		setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
		setIconifiable(true);
		setPreferredSize(new java.awt.Dimension(980, 487));
		getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		btnCerrar.setText("Cerrar");
		getContentPane().add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 30, -1, -1));

		panelVariables.setBorder(javax.swing.BorderFactory.createTitledBorder("Variables"));
		panelVariables.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jLabel10.setText("TOV:");
		panelVariables.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

		jLabel13.setText("CTSh:");
		panelVariables.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

		jLabel16.setText("CSW:");
		panelVariables.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, -1, -1));

		lblTOV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblTOV.setText("0");
		lblTOV.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
		panelVariables.add(lblTOV, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 60, -1));

		lblCTSh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblCTSh.setText("0");
		lblCTSh.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
		panelVariables.add(lblCTSh, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 60, -1));

		lblCSW.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblCSW.setText("0");
		lblCSW.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
		panelVariables.add(lblCSW, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 60, -1));

		lblGOV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblGOV.setText("0");
		lblGOV.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
		panelVariables.add(lblGOV, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 60, -1));

		jLabel12.setText("GOV:");
		panelVariables.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

		jLabel14.setText("  CTL:");
		panelVariables.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, -1, -1));

		lblCTL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblCTL.setText("0");
		lblCTL.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
		panelVariables.add(lblCTL, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 60, -1));

		jLabel18.setText("AGUA:");
		panelVariables.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, -1, -1));

		lblAgua.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblAgua.setText("0");
		lblAgua.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
		panelVariables.add(lblAgua, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 60, -1));

		jLabel17.setText("NSV:");
		panelVariables.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, -1, -1));

		jLabel11.setText("FW:");
		panelVariables.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, -1));

		jLabel15.setText("GSV:");
		panelVariables.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

		lblGSV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblGSV.setText("0");
		lblGSV.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
		panelVariables.add(lblGSV, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 60, -1));

		lblFW.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblFW.setText("0");
		lblFW.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
		panelVariables.add(lblFW, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 60, -1));

		lblNSV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblNSV.setText("0");
		lblNSV.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
		panelVariables.add(lblNSV, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 60, -1));

		jLabel23.setText(" Bbls");
		panelVariables.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

		jLabel30.setText(" Bbls");
		panelVariables.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, -1, -1));

		jLabel31.setText(" Bbls");
		panelVariables.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, -1, -1));

		jLabel32.setText(" Bbls");
		panelVariables.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, -1, -1));

		jLabel33.setText(" Bbls");
		panelVariables.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, -1, -1));

		jLabel34.setText(" Bbls");
		panelVariables.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, -1, -1));

		getContentPane().add(panelVariables, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 320, 150));

		panelCalculado.setBorder(javax.swing.BorderFactory.createTitledBorder("En Operacion"));
		panelCalculado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		lblOperacionNSV.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		lblOperacionNSV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblOperacionNSV.setText("0");
		lblOperacionNSV.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
		panelCalculado.add(lblOperacionNSV, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 60, -1));

		lblOperacionAgua.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		lblOperacionAgua.setForeground(new java.awt.Color(0, 0, 153));
		lblOperacionAgua.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblOperacionAgua.setText("0");
		lblOperacionAgua.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 153), 1, true));
		panelCalculado.add(lblOperacionAgua, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 60, -1));

		jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		jLabel20.setText("NSV");
		panelCalculado.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

		jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		jLabel21.setForeground(new java.awt.Color(0, 0, 153));
		jLabel21.setText("AGUA");
		panelCalculado.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

		btnGuardar.setText("Guardar");
		btnGuardar.setEnabled(false);
		panelCalculado.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, -1, -1));

		jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		jLabel19.setText("TOTAL:");
		panelCalculado.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 10));

		jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		jLabel35.setText(" Bbls");
		panelCalculado.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, -1));

		jLabel36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		jLabel36.setForeground(new java.awt.Color(0, 0, 153));
		jLabel36.setText(" Bbls");
		panelCalculado.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, -1, -1));

		getContentPane().add(panelCalculado, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, 320, 80));

		jLabel22.setText("Hora:");
		getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, -1, -1));
		getContentPane().add(spnHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 90, -1));

		jLabel24.setText("Fecha:");
		getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, -1, -1));

		panelDatos.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingreso de Datos"));
		panelDatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jLabel1.setText("Tanque:");
		panelDatos.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

		cmbxIdTanque.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { "Tanque 1", "Tanque 2", "Tanque 3", "Tanque 4" }));
		panelDatos.add(cmbxIdTanque, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

		jLabel3.setText("Pozo:");
		panelDatos.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

		cmbxIdPozo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Well 1", "Well 2", "Well 3" }));
		panelDatos.add(cmbxIdPozo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));

		cmbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { "Recibo", "Entrega", "Inyeccion", "Transferencia", "Drenaje", "Consumo" }));
		panelDatos.add(cmbxTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, -1, -1));

		jLabel2.setText("Tipo:");
		panelDatos.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

		jLabel4.setText("Nivel:");
		panelDatos.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

		txtNivel.setText("6,5");
		panelDatos.add(txtNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 50, -1));

		btnAPI.setText("API obs");
		panelDatos.add(btnAPI, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, -1, -1));

		txtInterfase.setText("3");
		panelDatos.add(txtInterfase, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 50, -1));

		jLabel5.setText("Interfase:");
		panelDatos.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

		jLabel6.setText("API@60:");
		panelDatos.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

		txtAPI.setText("43,2");
		panelDatos.add(txtAPI, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 50, -1));

		jLabel9.setText("S&W:");
		panelDatos.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

		txtSYW.setText("0.3");
		panelDatos.add(txtSYW, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 50, -1));

		jLabel7.setText("T Ambiente:");
		panelDatos.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

		txtTempAmbiente.setText("90");
		panelDatos.add(txtTempAmbiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 50, -1));

		jLabel8.setText("T Fluido:");
		panelDatos.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

		txtTempFluido.setText("120");
		panelDatos.add(txtTempFluido, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 50, -1));

		btnCalcular.setText("Calcular");
		panelDatos.add(btnCalcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 100, 20));

		btnBorrarUltimo.setText("Borrar ultimo");
		panelDatos.add(btnBorrarUltimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 233, 100, 20));

		jLabel25.setText(" °F");
		panelDatos.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, -1, 20));

		jLabel26.setText(" cm");
		panelDatos.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, -1, 20));

		jLabel27.setText(" cm");
		panelDatos.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, -1, 20));

		jLabel28.setText(" %");
		panelDatos.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, -1, 20));

		jLabel29.setText(" °F");
		panelDatos.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, -1, 20));

		getContentPane().add(panelDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 290, 300));

		panelMovimientosDiarios.setBorder(javax.swing.BorderFactory.createTitledBorder("Movimientos del último día"));
		panelMovimientosDiarios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jScrollPane1.setAutoscrolls(true);

		tbUltimaOp.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null } },
				new String[] { "Fecha", "Hora", "Tipo de Movimiento", "Nivel", "TOV", "Interfase", "FW", "API@60",
						"T Fluido", "T amb", "S&W", "NSV", "Agua" }));
		jScrollPane1.setViewportView(tbUltimaOp);

		panelMovimientosDiarios.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 930, 110));

		getContentPane().add(panelMovimientosDiarios,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 950, 140));

		btngrpFecha.add(rdbtnFechaUltimo);
		rdbtnFechaUltimo.setText("Fecha Ultimo Movimiento");
		getContentPane().add(rdbtnFechaUltimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, -1, -1));

		btngrpFecha.add(rdbtnFechaActual);
		rdbtnFechaActual.setSelected(true);
		rdbtnFechaActual.setText("Fecha Actual");
		getContentPane().add(rdbtnFechaActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, -1));
		getContentPane().add(dtchFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 120, -1));

		lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tk.png"))); // NOI18N
		getContentPane().add(lblImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 100, 310, 180));

		pack();
	}

}

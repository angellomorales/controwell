package com.petra.controwell.view.internal;

import javax.swing.JInternalFrame;

public class FrmReporte extends JInternalFrame {

	public javax.swing.JButton btnAceptar;
	public com.toedter.calendar.JDateChooser dtchFecha;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane10;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JScrollPane jScrollPane4;
	private javax.swing.JScrollPane jScrollPane5;
	private javax.swing.JScrollPane jScrollPane6;
	private javax.swing.JScrollPane jScrollPane7;
	private javax.swing.JScrollPane jScrollPane8;
	private javax.swing.JScrollPane jScrollPane9;
	private javax.swing.JPanel panelCapacidad;
	private javax.swing.JPanel panelComentarios;
	private javax.swing.JPanel panelDespachos;
	public javax.swing.JPanel panelGraficas;
	private javax.swing.JPanel panelInventarioFinal;
	private javax.swing.JPanel panelInventarioInicial;
	private javax.swing.JPanel panelProduccion;
	private javax.swing.JPanel panelProduccion1;
	public javax.swing.JPanel panelReporte;
	private javax.swing.JPanel panelVariables;
	private javax.swing.JPanel panelVariador;
	public javax.swing.JTable tbCapacidad;
	public javax.swing.JTable tbDespachos;
	public javax.swing.JTable tbInventarioFinal;
	public javax.swing.JTable tbInventarioInicial;
	public javax.swing.JTable tbLaboratorio;
	public javax.swing.JTable tbProduccion;
	public javax.swing.JTable tbVariablesProceso;
	public javax.swing.JTable tbVariador;
	public javax.swing.JTextArea txtComentarios;

	public FrmReporte() {
		initComponents();
	}

	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		panelReporte = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		dtchFecha = new com.toedter.calendar.JDateChooser();
		btnAceptar = new javax.swing.JButton();
		panelGraficas = new javax.swing.JPanel();
		panelInventarioInicial = new javax.swing.JPanel();
		jScrollPane2 = new javax.swing.JScrollPane();
		tbInventarioInicial = new javax.swing.JTable();
		panelInventarioFinal = new javax.swing.JPanel();
		jScrollPane3 = new javax.swing.JScrollPane();
		tbInventarioFinal = new javax.swing.JTable();
		panelCapacidad = new javax.swing.JPanel();
		jScrollPane4 = new javax.swing.JScrollPane();
		tbCapacidad = new javax.swing.JTable();
		panelProduccion = new javax.swing.JPanel();
		jScrollPane5 = new javax.swing.JScrollPane();
		tbProduccion = new javax.swing.JTable();
		panelDespachos = new javax.swing.JPanel();
		jScrollPane6 = new javax.swing.JScrollPane();
		tbDespachos = new javax.swing.JTable();
		panelVariables = new javax.swing.JPanel();
		jScrollPane7 = new javax.swing.JScrollPane();
		tbVariablesProceso = new javax.swing.JTable();
		panelProduccion1 = new javax.swing.JPanel();
		jScrollPane8 = new javax.swing.JScrollPane();
		tbLaboratorio = new javax.swing.JTable();
		panelComentarios = new javax.swing.JPanel();
		jScrollPane9 = new javax.swing.JScrollPane();
		txtComentarios = new javax.swing.JTextArea();
		panelVariador = new javax.swing.JPanel();
		jScrollPane10 = new javax.swing.JScrollPane();
		tbVariador = new javax.swing.JTable();

		setClosable(true);
		setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
		setIconifiable(true);
		setPreferredSize(new java.awt.Dimension(1178, 537));
		getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

		jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		panelReporte.setPreferredSize(new java.awt.Dimension(1200, 750));
		panelReporte.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jLabel1.setText("fecha:");
		panelReporte.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 40, 20));
		panelReporte.add(dtchFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 120, -1));

		btnAceptar.setText("Generar");
		panelReporte.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 80, 20));

		panelGraficas.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
		panelGraficas.setLayout(new java.awt.BorderLayout());
		panelReporte.add(panelGraficas, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 480, 550, 260));

		panelInventarioInicial.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED),
				"Inventario Inicial"));
		panelInventarioInicial.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jScrollPane2.setAutoscrolls(true);

		tbInventarioInicial.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null } },
				new String[] { "ID Tanques", "Fluido", "Nivel", "Interfase", "TOV", "GOV", "GSV", "NSV", "AGUA" }));
		tbInventarioInicial.setEnabled(false);
		jScrollPane2.setViewportView(tbInventarioInicial);

		panelInventarioInicial.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 540, 100));

		panelReporte.add(panelInventarioInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 560, 130));

		panelInventarioFinal.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED),
				"Inventario Final"));
		panelInventarioFinal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jScrollPane3.setAutoscrolls(true);

		tbInventarioFinal.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null } },
				new String[] { "ID Tanques", "Fluido", "Nivel", "Interfase", "TOV", "GOV", "GSV", "NSV", "AGUA" }));
		tbInventarioFinal.setEnabled(false);
		jScrollPane3.setViewportView(tbInventarioFinal);

		panelInventarioFinal.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 540, 100));

		panelReporte.add(panelInventarioFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, 560, 130));

		panelCapacidad.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED),
				"Capacidad Disponible"));
		panelCapacidad.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jScrollPane4.setAutoscrolls(true);

		tbCapacidad.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null } },
				new String[] { "ID Tanques", "Capacidad", "Disponible", "% Disponible" }));
		tbCapacidad.setEnabled(false);
		jScrollPane4.setViewportView(tbCapacidad);

		panelCapacidad.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 260, 100));

		panelReporte.add(panelCapacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 280, 130));

		panelProduccion.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Producción"));
		panelProduccion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jScrollPane5.setAutoscrolls(true);

		tbProduccion.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null } },
				new String[] { "ID Pozo", "tiempo", "FluidoTotal", "NSV", "Agua", "Gas", "Gor", "NSV Inyectado" }));
		tbProduccion.setEnabled(false);
		jScrollPane5.setViewportView(tbProduccion);

		panelProduccion.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 540, 100));

		panelReporte.add(panelProduccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 560, 130));

		panelDespachos.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Despachos"));
		panelDespachos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jScrollPane6.setAutoscrolls(true);

		tbDespachos.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null } },
				new String[] { "Id Pozo", "Fluido Total", "Nsv", "Agua", "% S&W" }));
		tbDespachos.setEnabled(false);
		jScrollPane6.setViewportView(tbDespachos);

		panelDespachos.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 260, 100));

		panelReporte.add(panelDespachos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, 280, 130));

		panelVariables.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED),
				"Variables de Proceso"));
		panelVariables.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jScrollPane7.setAutoscrolls(true);

		tbVariablesProceso.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null } },
				new String[] { "ID Pozo", "WHP", "WHT", "CHP", "Choke", "P Separador", "T Separador" }));
		tbVariablesProceso.setEnabled(false);
		jScrollPane7.setViewportView(tbVariablesProceso);

		panelVariables.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 540, 100));

		panelReporte.add(panelVariables, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 560, 130));

		panelProduccion1.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Laboratorio"));
		panelProduccion1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jScrollPane8.setAutoscrolls(true);

		tbLaboratorio.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null } },
				new String[] { "ID Pozo", "S&W", "API@60 Cabeza", "API@ 60 Mezcla", "Cloruros", "PH", "Viscocidad",
						"Salinidad" }));
		tbLaboratorio.setEnabled(false);
		jScrollPane8.setViewportView(tbLaboratorio);

		panelProduccion1.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 540, 100));

		panelReporte.add(panelProduccion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 190, 560, 130));

		panelComentarios.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Comentarios"));
		panelComentarios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		txtComentarios.setColumns(20);
		txtComentarios.setRows(5);
		jScrollPane9.setViewportView(txtComentarios);

		panelComentarios.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 260, 240));

		panelReporte.add(panelComentarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 470, 280, 270));

		panelVariador.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Variador"));
		panelVariador.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jScrollPane10.setAutoscrolls(true);

		tbVariador.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null } },
				new String[] { "ID Pozo", "Frec", "PIP", "PDP", "T Intake", "T motor", "Volt", "Amp" }));
		tbVariador.setEnabled(false);
		jScrollPane10.setViewportView(tbVariador);

		panelVariador.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 540, 100));

		panelReporte.add(panelVariador, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 330, 560, 130));

		jScrollPane1.setViewportView(panelReporte);

		getContentPane().add(jScrollPane1);

		pack();
	}

}

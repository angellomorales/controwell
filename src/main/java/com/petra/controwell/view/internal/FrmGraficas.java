package com.petra.controwell.view.internal;

import javax.swing.JInternalFrame;

public class FrmGraficas extends JInternalFrame {

	public javax.swing.JButton btnExportar;
	public javax.swing.JButton btnGraficar;
	public javax.swing.JButton btnReset;
	public javax.swing.JButton btnSeriesPrincipal;
	public javax.swing.JButton btnSeriesSecundario;
	public javax.swing.JComboBox<String> cmbxIdPozo;
	public com.toedter.calendar.JDateChooser dtchFechaFinal;
	public com.toedter.calendar.JDateChooser dtchFechaInicial;
	private javax.swing.JLabel jLabel1;
	public javax.swing.JLabel lblFechaFinal;
	public javax.swing.JLabel lblFechaInicial;
	public javax.swing.JPanel panelControlGrafica;
	public javax.swing.JPanel panelEjes;
	public javax.swing.JPanel panelFechas;
	public javax.swing.JPanel panelGraficas;
	public javax.swing.JPanel panelTipoGrafico;
	public javax.swing.JRadioButton rdbtnDia;
	public javax.swing.JRadioButton rdbtnRangoFecha;
	private javax.swing.ButtonGroup rdbtngTipo;

	public FrmGraficas() {
		initComponents();
	}

	private void initComponents() {

		rdbtngTipo = new javax.swing.ButtonGroup();
		panelGraficas = new javax.swing.JPanel();
		panelControlGrafica = new javax.swing.JPanel();
		btnExportar = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		cmbxIdPozo = new javax.swing.JComboBox<>();
		panelTipoGrafico = new javax.swing.JPanel();
		rdbtnDia = new javax.swing.JRadioButton();
		rdbtnRangoFecha = new javax.swing.JRadioButton();
		panelFechas = new javax.swing.JPanel();
		lblFechaInicial = new javax.swing.JLabel();
		dtchFechaInicial = new com.toedter.calendar.JDateChooser();
		lblFechaFinal = new javax.swing.JLabel();
		dtchFechaFinal = new com.toedter.calendar.JDateChooser();
		panelEjes = new javax.swing.JPanel();
		btnSeriesPrincipal = new javax.swing.JButton();
		btnSeriesSecundario = new javax.swing.JButton();
		btnReset = new javax.swing.JButton();
		btnGraficar = new javax.swing.JButton();

		setClosable(true);
		setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
		setIconifiable(true);
		setPreferredSize(new java.awt.Dimension(620, 465));
		getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		panelGraficas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		panelGraficas.setLayout(new java.awt.BorderLayout());
		getContentPane().add(panelGraficas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 580, 280));

		panelControlGrafica.setBorder(javax.swing.BorderFactory.createTitledBorder("Controles Gráfica"));
		panelControlGrafica.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		btnExportar.setText("Exportar Datos");
		panelControlGrafica.add(btnExportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 110, -1));

		jLabel1.setText("Pozo:");
		panelControlGrafica.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

		panelControlGrafica.add(cmbxIdPozo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 60, -1));

		panelTipoGrafico.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de Gráfica"));
		panelTipoGrafico.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		rdbtngTipo.add(rdbtnDia);
		rdbtnDia.setText("Día");
		panelTipoGrafico.add(rdbtnDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

		rdbtngTipo.add(rdbtnRangoFecha);
		rdbtnRangoFecha.setSelected(true);
		rdbtnRangoFecha.setText("Rango de Fechas");
		panelTipoGrafico.add(rdbtnRangoFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

		panelControlGrafica.add(panelTipoGrafico, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 150, 80));

		panelFechas.setBorder(javax.swing.BorderFactory.createTitledBorder("Rango de Fechas"));
		panelFechas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		lblFechaInicial.setText("Fecha Inicial:");
		panelFechas.add(lblFechaInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));
		panelFechas.add(dtchFechaInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 110, -1));

		lblFechaFinal.setText("Fecha Final:");
		panelFechas.add(lblFechaFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));
		panelFechas.add(dtchFechaFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 110, -1));

		panelControlGrafica.add(panelFechas, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 240, 80));

		panelEjes.setBorder(javax.swing.BorderFactory.createTitledBorder("Selección de Datos"));
		panelEjes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		btnSeriesPrincipal.setText("Eje Principal");
		panelEjes.add(btnSeriesPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 110, -1));

		btnSeriesSecundario.setText("Eje Secundario");
		panelEjes.add(btnSeriesSecundario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 110, -1));

		btnReset.setText("Reset");
		panelEjes.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 110, -1));

		panelControlGrafica.add(panelEjes, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 130, 120));

		btnGraficar.setText("Graficar");
		panelControlGrafica.add(btnGraficar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 110, -1));

		getContentPane().add(panelControlGrafica, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 580, 140));

		pack();
	}
}

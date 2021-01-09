package com.petra.controwell.view.internal;

import javax.swing.JInternalFrame;

public class FrmAforoTk extends JInternalFrame {

	public javax.swing.JButton btnCargar;
	public javax.swing.JButton btnCerrar;
	public javax.swing.JComboBox<String> cmbxIdTanque;
	public javax.swing.JComboBox<String> cmbxMaterial;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane2;
	public javax.swing.JTable tbAforo;
	public javax.swing.JTextField txtTemperaturaBase;

	public FrmAforoTk() {
		initComponents();

	}

	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		btnCargar = new javax.swing.JButton();
		btnCerrar = new javax.swing.JButton();
		cmbxIdTanque = new javax.swing.JComboBox<>();
		jPanel1 = new javax.swing.JPanel();
		jScrollPane2 = new javax.swing.JScrollPane();
		tbAforo = new javax.swing.JTable();
		jLabel2 = new javax.swing.JLabel();
		cmbxMaterial = new javax.swing.JComboBox<>();
		jLabel4 = new javax.swing.JLabel();
		txtTemperaturaBase = new javax.swing.JTextField();

		setClosable(true);
		setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
		setIconifiable(true);
		setPreferredSize(new java.awt.Dimension(375, 260));
		setRequestFocusEnabled(false);
		getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jLabel1.setText("Tanque:");
		getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

		btnCargar.setText("Cargar");
		getContentPane().add(btnCargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 70, -1));

		btnCerrar.setText("Cerrar");
		getContentPane().add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, -1, -1));

		cmbxIdTanque.setModel(
				new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
		getContentPane().add(cmbxIdTanque, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabla de Aforo"));
		jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jScrollPane2.setAutoscrolls(true);

		tbAforo.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null } },
				new String[] { "Nivel", "Volumen", "Incremento", "Temperatura Base", "Material" }));
		tbAforo.setEnabled(false);
		jScrollPane2.setViewportView(tbAforo);

		jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 320, 100));

		getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 340, 130));

		jLabel2.setText("Material:");
		getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

		cmbxMaterial.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { "Mild Carbon", "304 Stainless", "316 Stainless", "17-4PH Stainless", "N/A" }));
		getContentPane().add(cmbxMaterial, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

		jLabel4.setText("Temperatura Base:");
		getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

		txtTemperaturaBase.setText("6,5");
		getContentPane().add(txtTemperaturaBase, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 50, -1));

		pack();
	}

}

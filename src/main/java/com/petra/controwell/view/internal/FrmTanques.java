package com.petra.controwell.view.internal;

import javax.swing.JInternalFrame;

public class FrmTanques extends JInternalFrame {

	public javax.swing.JButton btnAgregar;
	public javax.swing.JButton btnBuscar;
	public javax.swing.JButton btnCerrar;
	public javax.swing.JButton btnEliminar;
	public javax.swing.JButton btnModificar;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	public javax.swing.JPanel panelTipoProducto;
	public javax.swing.JRadioButton rdbtnCrudo;
	public javax.swing.JRadioButton rdbtnLubricante;
	public javax.swing.JRadioButton rdbtnRefinado;
	private javax.swing.ButtonGroup rdbtngrpTipoProducto;
	public javax.swing.JTextField txtCapacidad;
	public javax.swing.JTextField txtIdTanques;

	public FrmTanques() {
		initComponents();
	}

	private void initComponents() {

		rdbtngrpTipoProducto = new javax.swing.ButtonGroup();
		jLabel1 = new javax.swing.JLabel();
		txtIdTanques = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		txtCapacidad = new javax.swing.JTextField();
		btnBuscar = new javax.swing.JButton();
		btnAgregar = new javax.swing.JButton();
		btnModificar = new javax.swing.JButton();
		btnEliminar = new javax.swing.JButton();
		btnCerrar = new javax.swing.JButton();
		panelTipoProducto = new javax.swing.JPanel();
		rdbtnCrudo = new javax.swing.JRadioButton();
		rdbtnRefinado = new javax.swing.JRadioButton();
		rdbtnLubricante = new javax.swing.JRadioButton();

		setClosable(true);
		setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
		setIconifiable(true);
		setPreferredSize(new java.awt.Dimension(400, 190));
		getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jLabel1.setText("Tanque:");
		getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));
		getContentPane().add(txtIdTanques, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 70, -1));

		jLabel2.setText("Capacidad:");
		getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));
		getContentPane().add(txtCapacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 70, -1));

		btnBuscar.setText("Buscar");
		getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 80, -1));

		btnAgregar.setText("Agregar");
		getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 80, -1));

		btnModificar.setText("Modificar");
		getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 80, -1));

		btnEliminar.setText("Eliminar");
		getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 80, -1));

		btnCerrar.setText("Cerrar");
		getContentPane().add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, -1, -1));

		panelTipoProducto.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de Producto"));

		rdbtngrpTipoProducto.add(rdbtnCrudo);
		rdbtnCrudo.setSelected(true);
		rdbtnCrudo.setText("Crudo");
		panelTipoProducto.add(rdbtnCrudo);

		rdbtngrpTipoProducto.add(rdbtnRefinado);
		rdbtnRefinado.setText("Refinado");
		panelTipoProducto.add(rdbtnRefinado);

		rdbtngrpTipoProducto.add(rdbtnLubricante);
		rdbtnLubricante.setText("Lubricante");
		panelTipoProducto.add(rdbtnLubricante);

		getContentPane().add(panelTipoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 240, 50));

		pack();
	}

}

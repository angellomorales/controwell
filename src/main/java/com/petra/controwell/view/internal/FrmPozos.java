package com.petra.controwell.view.internal;

import javax.swing.JInternalFrame;

public class FrmPozos extends JInternalFrame {

	public javax.swing.JButton btnAgregar;
	public javax.swing.JButton btnBuscar;
	public javax.swing.JButton btnCerrar;
	public javax.swing.JButton btnEliminar;
	public javax.swing.JButton btnModificar;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	public javax.swing.JScrollPane jScrollPane1;
	public javax.swing.JTextArea txtAComentarios;
	public javax.swing.JTextField txtIdPozo;
	public javax.swing.JTextField txtOperadora;
	public javax.swing.JTextField txtUbicacion;

	public FrmPozos() {
		initComponents();
	}

	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		txtIdPozo = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		txtUbicacion = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		txtOperadora = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		txtAComentarios = new javax.swing.JTextArea();
		btnBuscar = new javax.swing.JButton();
		btnAgregar = new javax.swing.JButton();
		btnModificar = new javax.swing.JButton();
		btnEliminar = new javax.swing.JButton();
		btnCerrar = new javax.swing.JButton();

		setClosable(true);
		setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
		setIconifiable(true);
		setPreferredSize(new java.awt.Dimension(400, 300));
		getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jLabel1.setText("Pozo:");
		getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));
		getContentPane().add(txtIdPozo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 70, -1));

		jLabel2.setText("Ubicacion:");
		getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));
		getContentPane().add(txtUbicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 70, -1));

		jLabel3.setText("Operadora:");
		getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));
		getContentPane().add(txtOperadora, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 70, -1));

		jLabel4.setText("Comentarios:");
		getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

		txtAComentarios.setColumns(20);
		txtAComentarios.setRows(5);
		jScrollPane1.setViewportView(txtAComentarios);

		getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 270, 100));

		btnBuscar.setText("Buscar");
		getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 80, -1));

		btnAgregar.setText("Agregar");
		getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 80, -1));

		btnModificar.setText("Modificar");
		getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 80, -1));

		btnEliminar.setText("Eliminar");
		getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 80, -1));

		btnCerrar.setText("Cerrar");
		getContentPane().add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, -1, -1));

		pack();
	}
}

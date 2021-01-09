package com.petra.controwell.view.internal;

import javax.swing.JInternalFrame;

public class FrmApi extends JInternalFrame {

	public javax.swing.JButton btnAceptar;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	public javax.swing.JLabel lblLogo;
	public javax.swing.JTextField txtApiObs;
	public javax.swing.JTextField txtTempObs;

	public FrmApi() {
		initComponents();

	}

	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		btnAceptar = new javax.swing.JButton();
		txtApiObs = new javax.swing.JTextField();
		txtTempObs = new javax.swing.JTextField();
		lblLogo = new javax.swing.JLabel();

		setClosable(true);
		setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
		getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jLabel1.setText("Api observado:");
		getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

		jLabel2.setText("Temperatura observada (°f):");
		getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

		btnAceptar.setText("Aceptar");
		getContentPane().add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, -1, -1));

		txtApiObs.setText("80");
		getContentPane().add(txtApiObs, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 71, -1));

		txtTempObs.setText("67");
		getContentPane().add(txtTempObs, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 71, -1));

		lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hidrometro.gif"))); // NOI18N
		getContentPane().add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 60, 200));

		pack();
	}

}

package com.petra.controwell.view;

import javax.swing.JFrame;

public class FrmCargando extends JFrame {

	public javax.swing.JLabel lblCargando;

	public FrmCargando() {
		initComponents();
	}

	private void initComponents() {

		lblCargando = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBackground(new java.awt.Color(255, 255, 255));
		setUndecorated(true);

		lblCargando.setBackground(new java.awt.Color(255, 255, 255));
		lblCargando.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cargando.gif"))); // NOI18N
		lblCargando.setPreferredSize(new java.awt.Dimension(161, 161));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lblCargando,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lblCargando,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}

}

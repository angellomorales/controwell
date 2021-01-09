package com.petra.controwell.view;

import javax.swing.JFrame;

public class FrmPrincipalTanques extends JFrame {

	public javax.swing.JDesktopPane escritorio;

	public FrmPrincipalTanques() {
		initComponents();
	}

	private void initComponents() {

		escritorio = new javax.swing.JDesktopPane();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setResizable(false);

		javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
		escritorio.setLayout(escritorioLayout);
		escritorioLayout.setHorizontalGroup(escritorioLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 982, Short.MAX_VALUE));
		escritorioLayout.setVerticalGroup(escritorioLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 600, Short.MAX_VALUE));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(escritorio));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(escritorio));

		pack();
	}

}

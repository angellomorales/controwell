package com.petra.controwell.view.internal;

import javax.swing.JInternalFrame;

public class FrmProcesoAlarmas extends JInternalFrame {

	public javax.swing.JButton btnAceptar;
	public javax.swing.JButton btnBorrar;
	public javax.swing.JCheckBox chkFlujoAceiteSepActive;
	public javax.swing.JCheckBox chkFlujoAceiteSepEnable;
	public javax.swing.JCheckBox chkFlujoAguaSepActive;
	public javax.swing.JCheckBox chkFlujoAguaSepEnable;
	public javax.swing.JCheckBox chkFlujoDiluyenteActive;
	public javax.swing.JCheckBox chkFlujoDiluyenteEnable;
	public javax.swing.JCheckBox chkFlujoGasActive;
	public javax.swing.JCheckBox chkFlujoGasEnable;
	public javax.swing.JCheckBox chkPresionCabezaActive;
	public javax.swing.JCheckBox chkPresionCabezaEnable;
	public javax.swing.JCheckBox chkPresionCasingActive;
	public javax.swing.JCheckBox chkPresionCasingEnable;
	public javax.swing.JCheckBox chkPresionChokeActive;
	public javax.swing.JCheckBox chkPresionChokeEnable;
	public javax.swing.JCheckBox chkPresionGasSepActive;
	public javax.swing.JCheckBox chkPresionGasSepEnable;
	public javax.swing.JCheckBox chkPresionLineaActive;
	public javax.swing.JCheckBox chkPresionLineaEnable;
	public javax.swing.JCheckBox chkPresionMezcladorActive;
	public javax.swing.JCheckBox chkPresionMezcladorEnable;
	public javax.swing.JCheckBox chkPresionSepActive;
	public javax.swing.JCheckBox chkPresionSepEnable;
	public javax.swing.JCheckBox chkTemperaturaCabezaActive;
	public javax.swing.JCheckBox chkTemperaturaCabezaEnable;
	public javax.swing.JCheckBox chkTemperaturaGasSepActive;
	public javax.swing.JCheckBox chkTemperaturaGasSepEnable;
	public javax.swing.JCheckBox chkTemperaturaSepActive;
	public javax.swing.JCheckBox chkTemperaturaSepEnable;
	public javax.swing.JComboBox<String> cmbxIdPozo;
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
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JScrollPane jScrollPane1;
	public javax.swing.JLabel lblFecha;
	public javax.swing.JLabel lblHora;
	public javax.swing.JPanel pnCabeza;
	public javax.swing.JPanel pnCasing;
	public javax.swing.JPanel pnChoke;
	public javax.swing.JPanel pnFlujoAceiteSep;
	public javax.swing.JPanel pnFlujoAguaSep;
	public javax.swing.JPanel pnFlujoDiluyente;
	public javax.swing.JPanel pnFlujoGas;
	public javax.swing.JPanel pnGas;
	public javax.swing.JPanel pnLinea;
	public javax.swing.JPanel pnMezclador;
	public javax.swing.JPanel pnPresionCabeza;
	public javax.swing.JPanel pnPresionCasing;
	public javax.swing.JPanel pnPresionChoke;
	public javax.swing.JPanel pnPresionGasSep;
	public javax.swing.JPanel pnPresionLinea;
	public javax.swing.JPanel pnPresionMezclador;
	public javax.swing.JPanel pnPresionSep;
	public javax.swing.JPanel pnSeparador;
	public javax.swing.JPanel pnTemperaturaCabeza;
	public javax.swing.JPanel pnTemperaturaGasSep;
	public javax.swing.JPanel pnTemperaturaSep;
	private javax.swing.JPanel pnVariablesProceso;
	public javax.swing.JTextField txtFlujoAceiteSepMax;
	public javax.swing.JTextField txtFlujoAceiteSepMin;
	public javax.swing.JTextField txtFlujoAguaSepMax;
	public javax.swing.JTextField txtFlujoAguaSepMin;
	public javax.swing.JTextField txtFlujoDiluyenteMax;
	public javax.swing.JTextField txtFlujoDiluyenteMin;
	public javax.swing.JTextField txtFlujoGasMax;
	public javax.swing.JTextField txtFlujoGasMin;
	public javax.swing.JTextField txtPresionCabezaMax;
	public javax.swing.JTextField txtPresionCabezaMin;
	public javax.swing.JTextField txtPresionCasingMax;
	public javax.swing.JTextField txtPresionCasingMin;
	public javax.swing.JTextField txtPresionChokeMax;
	public javax.swing.JTextField txtPresionChokeMin;
	public javax.swing.JTextField txtPresionGasSepMax;
	public javax.swing.JTextField txtPresionGasSepMin;
	public javax.swing.JTextField txtPresionLineaMax;
	public javax.swing.JTextField txtPresionLineaMin;
	public javax.swing.JTextField txtPresionMezcladorMax;
	public javax.swing.JTextField txtPresionMezcladorMin;
	public javax.swing.JTextField txtPresionSepMax;
	public javax.swing.JTextField txtPresionSepMin;
	public javax.swing.JTextField txtTemperaturaCabezaMax;
	public javax.swing.JTextField txtTemperaturaCabezaMin;
	public javax.swing.JTextField txtTemperaturaGasSepMax;
	public javax.swing.JTextField txtTemperaturaGasSepMin;
	public javax.swing.JTextField txtTemperaturaSepMax;
	public javax.swing.JTextField txtTemperaturaSepMin;

	public FrmProcesoAlarmas() {
		initComponents();
	}

	private void initComponents() {

		jLabel30 = new javax.swing.JLabel();
		lblFecha = new javax.swing.JLabel();
		lblHora = new javax.swing.JLabel();
		jLabel15 = new javax.swing.JLabel();
		cmbxIdPozo = new javax.swing.JComboBox<>();
		btnAceptar = new javax.swing.JButton();
		btnBorrar = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		pnVariablesProceso = new javax.swing.JPanel();
		pnCabeza = new javax.swing.JPanel();
		chkPresionCabezaActive = new javax.swing.JCheckBox();
		chkTemperaturaCabezaActive = new javax.swing.JCheckBox();
		pnPresionCabeza = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		txtPresionCabezaMin = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		chkPresionCabezaEnable = new javax.swing.JCheckBox();
		txtPresionCabezaMax = new javax.swing.JTextField();
		pnTemperaturaCabeza = new javax.swing.JPanel();
		txtTemperaturaCabezaMax = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		txtTemperaturaCabezaMin = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		chkTemperaturaCabezaEnable = new javax.swing.JCheckBox();
		pnCasing = new javax.swing.JPanel();
		chkPresionCasingActive = new javax.swing.JCheckBox();
		pnPresionCasing = new javax.swing.JPanel();
		txtPresionCasingMax = new javax.swing.JTextField();
		jLabel18 = new javax.swing.JLabel();
		txtPresionCasingMin = new javax.swing.JTextField();
		jLabel19 = new javax.swing.JLabel();
		chkPresionCasingEnable = new javax.swing.JCheckBox();
		pnChoke = new javax.swing.JPanel();
		chkPresionChokeActive = new javax.swing.JCheckBox();
		pnPresionChoke = new javax.swing.JPanel();
		txtPresionChokeMax = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		txtPresionChokeMin = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		chkPresionChokeEnable = new javax.swing.JCheckBox();
		pnGas = new javax.swing.JPanel();
		chkPresionGasSepActive = new javax.swing.JCheckBox();
		chkFlujoGasActive = new javax.swing.JCheckBox();
		chkTemperaturaGasSepActive = new javax.swing.JCheckBox();
		pnPresionGasSep = new javax.swing.JPanel();
		txtPresionGasSepMax = new javax.swing.JTextField();
		jLabel9 = new javax.swing.JLabel();
		txtPresionGasSepMin = new javax.swing.JTextField();
		jLabel10 = new javax.swing.JLabel();
		chkPresionGasSepEnable = new javax.swing.JCheckBox();
		pnTemperaturaGasSep = new javax.swing.JPanel();
		txtTemperaturaGasSepMax = new javax.swing.JTextField();
		jLabel20 = new javax.swing.JLabel();
		txtTemperaturaGasSepMin = new javax.swing.JTextField();
		jLabel21 = new javax.swing.JLabel();
		chkTemperaturaGasSepEnable = new javax.swing.JCheckBox();
		pnFlujoGas = new javax.swing.JPanel();
		txtFlujoGasMax = new javax.swing.JTextField();
		jLabel28 = new javax.swing.JLabel();
		txtFlujoGasMin = new javax.swing.JTextField();
		jLabel29 = new javax.swing.JLabel();
		chkFlujoGasEnable = new javax.swing.JCheckBox();
		pnSeparador = new javax.swing.JPanel();
		chkPresionSepActive = new javax.swing.JCheckBox();
		chkFlujoAceiteSepActive = new javax.swing.JCheckBox();
		chkFlujoAguaSepActive = new javax.swing.JCheckBox();
		chkTemperaturaSepActive = new javax.swing.JCheckBox();
		pnTemperaturaSep = new javax.swing.JPanel();
		txtTemperaturaSepMax = new javax.swing.JTextField();
		jLabel16 = new javax.swing.JLabel();
		txtTemperaturaSepMin = new javax.swing.JTextField();
		jLabel17 = new javax.swing.JLabel();
		chkTemperaturaSepEnable = new javax.swing.JCheckBox();
		pnPresionSep = new javax.swing.JPanel();
		txtPresionSepMax = new javax.swing.JTextField();
		jLabel7 = new javax.swing.JLabel();
		txtPresionSepMin = new javax.swing.JTextField();
		jLabel8 = new javax.swing.JLabel();
		chkPresionSepEnable = new javax.swing.JCheckBox();
		pnFlujoAceiteSep = new javax.swing.JPanel();
		txtFlujoAceiteSepMax = new javax.swing.JTextField();
		jLabel22 = new javax.swing.JLabel();
		txtFlujoAceiteSepMin = new javax.swing.JTextField();
		jLabel23 = new javax.swing.JLabel();
		chkFlujoAceiteSepEnable = new javax.swing.JCheckBox();
		pnFlujoAguaSep = new javax.swing.JPanel();
		txtFlujoAguaSepMax = new javax.swing.JTextField();
		jLabel24 = new javax.swing.JLabel();
		txtFlujoAguaSepMin = new javax.swing.JTextField();
		jLabel25 = new javax.swing.JLabel();
		chkFlujoAguaSepEnable = new javax.swing.JCheckBox();
		pnLinea = new javax.swing.JPanel();
		chkPresionLineaActive = new javax.swing.JCheckBox();
		pnPresionLinea = new javax.swing.JPanel();
		txtPresionLineaMax = new javax.swing.JTextField();
		jLabel11 = new javax.swing.JLabel();
		txtPresionLineaMin = new javax.swing.JTextField();
		jLabel12 = new javax.swing.JLabel();
		chkPresionLineaEnable = new javax.swing.JCheckBox();
		pnMezclador = new javax.swing.JPanel();
		chkPresionMezcladorActive = new javax.swing.JCheckBox();
		chkFlujoDiluyenteActive = new javax.swing.JCheckBox();
		pnFlujoDiluyente = new javax.swing.JPanel();
		txtFlujoDiluyenteMax = new javax.swing.JTextField();
		jLabel26 = new javax.swing.JLabel();
		txtFlujoDiluyenteMin = new javax.swing.JTextField();
		jLabel27 = new javax.swing.JLabel();
		chkFlujoDiluyenteEnable = new javax.swing.JCheckBox();
		pnPresionMezclador = new javax.swing.JPanel();
		txtPresionMezcladorMax = new javax.swing.JTextField();
		jLabel13 = new javax.swing.JLabel();
		txtPresionMezcladorMin = new javax.swing.JTextField();
		jLabel14 = new javax.swing.JLabel();
		chkPresionMezcladorEnable = new javax.swing.JCheckBox();

		setClosable(true);
		setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
		setIconifiable(true);
		setPreferredSize(new java.awt.Dimension(800, 550));
		getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jLabel30.setText("Ultima actualización:");
		getContentPane().add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

		lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblFecha.setText("fecha");
		getContentPane().add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 170, -1));

		lblHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblHora.setText("hora");
		getContentPane().add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 160, -1));

		jLabel15.setText("Pozo:");
		getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

		getContentPane().add(cmbxIdPozo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 100, -1));

		btnAceptar.setText("Actualizar");
		getContentPane().add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, -1));

		btnBorrar.setText("Borrar registro");
		getContentPane().add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, -1, -1));

		pnVariablesProceso.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		pnCabeza.setBorder(javax.swing.BorderFactory.createTitledBorder("Cabeza de Pozo"));
		pnCabeza.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		chkPresionCabezaActive.setText("Habilitar Presión Cabeza");
		pnCabeza.add(chkPresionCabezaActive, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

		chkTemperaturaCabezaActive.setText("Habilitar Temperatura Cabeza");
		pnCabeza.add(chkTemperaturaCabezaActive, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, -1));

		pnPresionCabeza.setBorder(javax.swing.BorderFactory.createTitledBorder("Presión"));
		pnPresionCabeza.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jLabel1.setText("Max:");
		pnPresionCabeza.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));
		pnPresionCabeza.add(txtPresionCabezaMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 70, -1));

		jLabel3.setText("Min:");
		pnPresionCabeza.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

		chkPresionCabezaEnable.setText("Activar Alarma");
		pnPresionCabeza.add(chkPresionCabezaEnable, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));
		pnPresionCabeza.add(txtPresionCabezaMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 70, -1));

		pnCabeza.add(pnPresionCabeza, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 330, 50));

		pnTemperaturaCabeza.setBorder(javax.swing.BorderFactory.createTitledBorder("Temperatura"));
		pnTemperaturaCabeza.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
		pnTemperaturaCabeza.add(txtTemperaturaCabezaMax,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 70, -1));

		jLabel2.setText("Max:");
		pnTemperaturaCabeza.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));
		pnTemperaturaCabeza.add(txtTemperaturaCabezaMin,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 70, -1));

		jLabel4.setText("Min:");
		pnTemperaturaCabeza.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

		chkTemperaturaCabezaEnable.setText("Activar Alarma");
		pnTemperaturaCabeza.add(chkTemperaturaCabezaEnable,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

		pnCabeza.add(pnTemperaturaCabeza, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 330, 50));

		pnVariablesProceso.add(pnCabeza, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 710, 110));

		pnCasing.setBorder(javax.swing.BorderFactory.createTitledBorder("Casing de Pozo"));
		pnCasing.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		chkPresionCasingActive.setText("Habilitar Presión Casing");
		pnCasing.add(chkPresionCasingActive, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

		pnPresionCasing.setBorder(javax.swing.BorderFactory.createTitledBorder("Presión"));
		pnPresionCasing.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
		pnPresionCasing.add(txtPresionCasingMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 70, -1));

		jLabel18.setText("Max:");
		pnPresionCasing.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));
		pnPresionCasing.add(txtPresionCasingMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 70, -1));

		jLabel19.setText("Min:");
		pnPresionCasing.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

		chkPresionCasingEnable.setText("Activar Alarma");
		pnPresionCasing.add(chkPresionCasingEnable, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

		pnCasing.add(pnPresionCasing, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 330, 50));

		pnVariablesProceso.add(pnCasing, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 350, 110));

		pnChoke.setBorder(javax.swing.BorderFactory.createTitledBorder("Choke Manifold"));
		pnChoke.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		chkPresionChokeActive.setText("Habilitar Presión Choke");
		pnChoke.add(chkPresionChokeActive, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

		pnPresionChoke.setBorder(javax.swing.BorderFactory.createTitledBorder("Presión"));
		pnPresionChoke.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
		pnPresionChoke.add(txtPresionChokeMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 70, -1));

		jLabel5.setText("Max:");
		pnPresionChoke.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));
		pnPresionChoke.add(txtPresionChokeMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 70, -1));

		jLabel6.setText("Min:");
		pnPresionChoke.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

		chkPresionChokeEnable.setText("Activar Alarma");
		pnPresionChoke.add(chkPresionChokeEnable, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

		pnChoke.add(pnPresionChoke, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 330, 50));

		pnVariablesProceso.add(pnChoke, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 350, 110));

		pnGas.setBorder(javax.swing.BorderFactory.createTitledBorder("Gas"));
		pnGas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		chkPresionGasSepActive.setText("Habilitar Presión Diferencial Gas Separador");
		pnGas.add(chkPresionGasSepActive, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

		chkFlujoGasActive.setText("Habilitar Flujometro Gas");
		pnGas.add(chkFlujoGasActive, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

		chkTemperaturaGasSepActive.setText("Habilitar Temperatura Gas Separador");
		pnGas.add(chkTemperaturaGasSepActive, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, -1));

		pnPresionGasSep.setBorder(javax.swing.BorderFactory.createTitledBorder("Presión"));
		pnPresionGasSep.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
		pnPresionGasSep.add(txtPresionGasSepMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 70, -1));

		jLabel9.setText("Max:");
		pnPresionGasSep.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));
		pnPresionGasSep.add(txtPresionGasSepMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 70, -1));

		jLabel10.setText("Min:");
		pnPresionGasSep.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

		chkPresionGasSepEnable.setText("Activar Alarma");
		pnPresionGasSep.add(chkPresionGasSepEnable, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

		pnGas.add(pnPresionGasSep, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 330, 50));

		pnTemperaturaGasSep.setBorder(javax.swing.BorderFactory.createTitledBorder("Temperatura"));
		pnTemperaturaGasSep.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
		pnTemperaturaGasSep.add(txtTemperaturaGasSepMax,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 70, -1));

		jLabel20.setText("Max:");
		pnTemperaturaGasSep.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));
		pnTemperaturaGasSep.add(txtTemperaturaGasSepMin,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 70, -1));

		jLabel21.setText("Min:");
		pnTemperaturaGasSep.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

		chkTemperaturaGasSepEnable.setText("Activar Alarma");
		pnTemperaturaGasSep.add(chkTemperaturaGasSepEnable,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

		pnGas.add(pnTemperaturaGasSep, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 330, 50));

		pnFlujoGas.setBorder(javax.swing.BorderFactory.createTitledBorder("Flujometro"));
		pnFlujoGas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
		pnFlujoGas.add(txtFlujoGasMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 70, -1));

		jLabel28.setText("Max:");
		pnFlujoGas.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));
		pnFlujoGas.add(txtFlujoGasMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 70, -1));

		jLabel29.setText("Min:");
		pnFlujoGas.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

		chkFlujoGasEnable.setText("Activar Alarma");
		pnFlujoGas.add(chkFlujoGasEnable, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

		pnGas.add(pnFlujoGas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 330, 50));

		pnVariablesProceso.add(pnGas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 710, 200));

		pnSeparador.setBorder(javax.swing.BorderFactory.createTitledBorder("Separador"));
		pnSeparador.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		chkPresionSepActive.setText("Habilitar Presión Separador");
		pnSeparador.add(chkPresionSepActive, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

		chkFlujoAceiteSepActive.setText("Habilitar Flujometro Aceite Separador");
		pnSeparador.add(chkFlujoAceiteSepActive, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

		chkFlujoAguaSepActive.setText("Habilitar Flujometro Agua Separador");
		pnSeparador.add(chkFlujoAguaSepActive, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, -1, -1));

		chkTemperaturaSepActive.setText("Habilitar Temperatura Separador");
		pnSeparador.add(chkTemperaturaSepActive, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, -1));

		pnTemperaturaSep.setBorder(javax.swing.BorderFactory.createTitledBorder("Temperatura"));
		pnTemperaturaSep.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
		pnTemperaturaSep.add(txtTemperaturaSepMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 70, -1));

		jLabel16.setText("Max:");
		pnTemperaturaSep.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));
		pnTemperaturaSep.add(txtTemperaturaSepMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 70, -1));

		jLabel17.setText("Min:");
		pnTemperaturaSep.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

		chkTemperaturaSepEnable.setText("Activar Alarma");
		pnTemperaturaSep.add(chkTemperaturaSepEnable,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

		pnSeparador.add(pnTemperaturaSep, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 330, 50));

		pnPresionSep.setBorder(javax.swing.BorderFactory.createTitledBorder("Presión"));
		pnPresionSep.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
		pnPresionSep.add(txtPresionSepMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 70, -1));

		jLabel7.setText("Max:");
		pnPresionSep.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));
		pnPresionSep.add(txtPresionSepMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 70, -1));

		jLabel8.setText("Min:");
		pnPresionSep.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

		chkPresionSepEnable.setText("Activar Alarma");
		pnPresionSep.add(chkPresionSepEnable, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

		pnSeparador.add(pnPresionSep, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 330, 50));

		pnFlujoAceiteSep.setBorder(javax.swing.BorderFactory.createTitledBorder("Flujometro Aceite"));
		pnFlujoAceiteSep.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
		pnFlujoAceiteSep.add(txtFlujoAceiteSepMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 70, -1));

		jLabel22.setText("Max:");
		pnFlujoAceiteSep.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));
		pnFlujoAceiteSep.add(txtFlujoAceiteSepMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 70, -1));

		jLabel23.setText("Min:");
		pnFlujoAceiteSep.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

		chkFlujoAceiteSepEnable.setText("Activar Alarma");
		pnFlujoAceiteSep.add(chkFlujoAceiteSepEnable,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

		pnSeparador.add(pnFlujoAceiteSep, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 330, 50));

		pnFlujoAguaSep.setBorder(javax.swing.BorderFactory.createTitledBorder("Flujometro Agua"));
		pnFlujoAguaSep.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
		pnFlujoAguaSep.add(txtFlujoAguaSepMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 70, -1));

		jLabel24.setText("Max:");
		pnFlujoAguaSep.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));
		pnFlujoAguaSep.add(txtFlujoAguaSepMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 70, -1));

		jLabel25.setText("Min:");
		pnFlujoAguaSep.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

		chkFlujoAguaSepEnable.setText("Activar Alarma");
		pnFlujoAguaSep.add(chkFlujoAguaSepEnable, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

		pnSeparador.add(pnFlujoAguaSep, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 330, 50));

		pnVariablesProceso.add(pnSeparador, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 710, 200));

		pnLinea.setBorder(javax.swing.BorderFactory.createTitledBorder("Línea Troncal"));
		pnLinea.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		chkPresionLineaActive.setText("Habilitar Presión Línea Troncal");
		pnLinea.add(chkPresionLineaActive, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

		pnPresionLinea.setBorder(javax.swing.BorderFactory.createTitledBorder("Presión"));
		pnPresionLinea.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
		pnPresionLinea.add(txtPresionLineaMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 70, -1));

		jLabel11.setText("Max:");
		pnPresionLinea.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));
		pnPresionLinea.add(txtPresionLineaMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 70, -1));

		jLabel12.setText("Min:");
		pnPresionLinea.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

		chkPresionLineaEnable.setText("Activar Alarma");
		pnPresionLinea.add(chkPresionLineaEnable, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

		pnLinea.add(pnPresionLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 330, 50));

		pnVariablesProceso.add(pnLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 790, 710, 110));

		pnMezclador.setBorder(javax.swing.BorderFactory.createTitledBorder("Mezclador Diluyente"));
		pnMezclador.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		chkPresionMezcladorActive.setText("Habilitar Presión Mezclador");
		pnMezclador.add(chkPresionMezcladorActive, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

		chkFlujoDiluyenteActive.setText("Habilitar Flujometro Diluyente");
		pnMezclador.add(chkFlujoDiluyenteActive, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, -1));

		pnFlujoDiluyente.setBorder(javax.swing.BorderFactory.createTitledBorder("Flujometro"));
		pnFlujoDiluyente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
		pnFlujoDiluyente.add(txtFlujoDiluyenteMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 70, -1));

		jLabel26.setText("Max:");
		pnFlujoDiluyente.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));
		pnFlujoDiluyente.add(txtFlujoDiluyenteMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 70, -1));

		jLabel27.setText("Min:");
		pnFlujoDiluyente.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

		chkFlujoDiluyenteEnable.setText("Activar Alarma");
		pnFlujoDiluyente.add(chkFlujoDiluyenteEnable,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

		pnMezclador.add(pnFlujoDiluyente, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 330, 50));

		pnPresionMezclador.setBorder(javax.swing.BorderFactory.createTitledBorder("Presión"));
		pnPresionMezclador.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
		pnPresionMezclador.add(txtPresionMezcladorMax,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 70, -1));

		jLabel13.setText("Max:");
		pnPresionMezclador.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));
		pnPresionMezclador.add(txtPresionMezcladorMin,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 70, -1));

		jLabel14.setText("Min:");
		pnPresionMezclador.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

		chkPresionMezcladorEnable.setText("Activar Alarma");
		pnPresionMezclador.add(chkPresionMezcladorEnable,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

		pnMezclador.add(pnPresionMezclador, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 330, 50));

		pnVariablesProceso.add(pnMezclador, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 670, 710, 110));

		jScrollPane1.setViewportView(pnVariablesProceso);

		getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 760, 440));

		pack();
	}

}

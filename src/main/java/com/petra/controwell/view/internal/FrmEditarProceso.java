package com.petra.controwell.view.internal;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import com.toedter.calendar.JDateChooser;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class FrmEditarProceso extends JInternalFrame {
	public JTable tbProceso;
	public JTable tbVariador;
	public JScrollPane scrollPaneProceso;
	public JScrollPane scrollPaneVariador;
	public JScrollPane scrollPaneDatos;
	public JTabbedPane tabDatos;
	public JPanel pnDatos;
	public JDateChooser dtchFecha;
	public JButton btnDescargar;
	public JButton btnCargar;
	public JComboBox cmbxIdPozo;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel1;

	public FrmEditarProceso() {
		initComponents();

	}

	private void initComponents() {
		scrollPaneProceso = new JScrollPane();
		scrollPaneVariador = new JScrollPane();
		scrollPaneDatos = new JScrollPane();
		tbProceso = new JTable();
		tbVariador = new JTable();
		tabDatos = new JTabbedPane(JTabbedPane.TOP);		
		pnDatos = new JPanel();
		dtchFecha = new JDateChooser();
		btnDescargar = new JButton("Descargar");
		btnCargar = new JButton("Cargar");
		cmbxIdPozo = new JComboBox<>();
		lblNewLabel = new JLabel("Fecha:");
		lblNewLabel1 = new JLabel("Pozo:");

		setBounds(100, 100, 564, 324);
		setClosable(true);
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		setIconifiable(true);
		setPreferredSize(new Dimension(564, 324));
		setRequestFocusEnabled(false);
		getContentPane().setLayout(null);

		tabDatos.setBounds(26, 21, 457, 180);
		tabDatos.addTab("Proceso", scrollPaneProceso);
		tabDatos.addTab("Variador", scrollPaneVariador);

		scrollPaneProceso.setViewportView(tbProceso);
		scrollPaneProceso.setAutoscrolls(true);
		scrollPaneProceso.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		scrollPaneVariador.setViewportView(tbVariador);
		scrollPaneVariador.setAutoscrolls(true);
		scrollPaneVariador.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		tbProceso.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null } },
				new String[] { "fecha", "hora", "idPozo", "presionCabeza", "temperaturaCabeza", "presionCasing",
						"presionChoke", "flujoDiluyente", "presionMezclador", "flujoAceiteSep", "flujoAguaSep",
						"presionSep", "temperaturaSep", "presionGasSep", "temperaturaGasSep", "flujoGas",
						"presionLinea" }));
		TableColumn column = null;
		for (int col = 0; col < tbProceso.getColumnCount(); col++) {
			column = tbProceso.getColumnModel().getColumn(col);
			column.setPreferredWidth (50); 
		}
		tbProceso.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tbProceso.setEnabled(false);

		tbVariador.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null } },
				new String[] { " fecha", " hora", " idPozo", " frecuencia", " pip", " pdp", " tIntake", " tMotor",
						" volt", "amp" }));
		tbVariador.setEnabled(false);

		pnDatos.setBounds(10, 73, 528, 210);
		pnDatos.setBorder(BorderFactory.createTitledBorder("Datos Variador"));
		pnDatos.setLayout(null);
		pnDatos.add(tabDatos);

		scrollPaneDatos.setBounds(10, 73, 528, 210);
		scrollPaneDatos.setViewportView(pnDatos);
		getContentPane().add(scrollPaneDatos);

		cmbxIdPozo.setBounds(80, 42, 132, 20);
		getContentPane().add(cmbxIdPozo);

		dtchFecha.setBounds(80, 11, 132, 20);
		getContentPane().add(dtchFecha);

		btnDescargar.setBounds(294, 11, 89, 23);
		getContentPane().add(btnDescargar);

		btnCargar.setBounds(403, 11, 89, 23);
		getContentPane().add(btnCargar);

		lblNewLabel.setBounds(37, 11, 46, 14);
		getContentPane().add(lblNewLabel);

		lblNewLabel1.setBounds(37, 42, 46, 14);
		getContentPane().add(lblNewLabel1);

		pack();

	}
}

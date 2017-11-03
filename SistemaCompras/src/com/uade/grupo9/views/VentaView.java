package com.uade.grupo9.views;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.uade.grupo9.controller.UsuariosController;




/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class VentaView extends JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JPanel pnlContenedor;
	private JPanel pnlCentro;
	private JButton btnGuardar;
	private JLabel lblTitulo;
	private JLabel lblNombre;
	private JCheckBox chkTransferencia;
	private JCheckBox chkEfectivo;
	private JCheckBox chkContratacionUnicaVez;
	private JCheckBox chkContratacionPorAbono;
	private JCheckBox chkGarantiaExtendida;
	private JCheckBox chkGarantiaMensual;
	private JCheckBox chkGarantiaAnual;
	private JButton Volver;
	private JCheckBox chkTarjeta;
	private JLabel lblDescripcion;
	private JLabel lblGarantiaCantidad;
	private JLabel lblPrecio;
	private JLabel lblFormasDePago;
	private JLabel lblContratacion;
	private JLabel lblGarantia;
	private JTextField txtNombre;
	private JTextField txtDescripcion;
	private JTextField txtPrecio;
	private JTextField txtGarantiaCantidad;
	private String tipoOperacion;
	private String tipoPublicacion;
	private String stepDescription;

	public VentaView(String tipoPublicacion, String tipoOperacion) {

		this.tipoPublicacion = tipoPublicacion;
		this.tipoOperacion = tipoOperacion;
		this.setStepDescription();
		// Establecer el titulo de la ventana
		UsuariosController uController = UsuariosController.get();
		this.setTitle("Usuario: " + uController.getCurrentUser().getNombreUsuario().toUpperCase() + " ( " + uController.getCurrentUser().getNombre().toUpperCase() + " " + uController.getCurrentUser().getApellido().toUpperCase() + " ) - " + this.stepDescription);
		// Establecer la dimension de la ventana (ancho, alto)
		this.setSize(839, 493);
		// Establecer NO dimensionable la ventana
		this.setResizable(false);
		// Ubicar la ventana en el centro de la pantalla
		this.setLocationRelativeTo(null);
		// Agregar el panel al JFrame
		this.getContentPane().add(this.getPanelContenedor());
		// Mostrar la ventana
		this.setVisible(true);
	}

	private JPanel getPanelContenedor() {
		pnlContenedor = new JPanel();
		pnlContenedor.setLayout(new BorderLayout());
		
		lblTitulo = new JLabel(this.stepDescription);
		
		lblTitulo.setFont(new Font("Serif", Font.BOLD, 20));
		lblTitulo.setHorizontalAlignment(JLabel.CENTER);
		pnlContenedor.add(lblTitulo, BorderLayout.PAGE_START);
		pnlContenedor.add(getPanelCentro(), BorderLayout.CENTER);
		return pnlContenedor;
	}

	private JPanel getPanelCentro() {
		pnlCentro = new JPanel();
		pnlCentro.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(JLabel.RIGHT);
		gbc.gridx = 0; // número columna
		gbc.gridy = 0; // número fila
		gbc.gridwidth = 1; // numero de columnas de ancho
		gbc.gridheight = 1; // numero de filas de ancho
		gbc.weightx = 0.1;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL; // rellenar la celda en ambos sentidos (horizontal y vertical)
		gbc.insets = new Insets(3, 3, 3, 3); // definir el relleno exterior
		pnlCentro.add(lblNombre, gbc); // agregar el label al panel contenedor

		txtNombre = new JTextField();
		gbc.gridx = 1; // número columna
		gbc.gridy = 0; // número fila
		gbc.weightx = 0.9;
		pnlCentro.add(txtNombre, gbc); // agregar el textField al panel contenedor

		lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setHorizontalAlignment(JLabel.RIGHT);
		gbc.gridx = 0; // número columna
		gbc.gridy = 1; // número fila
		gbc.weightx = 0.1;
		pnlCentro.add(lblDescripcion, gbc); // agregar el label al panel contenedor

		txtDescripcion = new JTextField();
		gbc.gridx = 1; // número columna
		gbc.gridy = 1; // número fila
		gbc.weightx = 0.9;
		pnlCentro.add(txtDescripcion, gbc); // agregar el textField al panel contenedor
		
		lblPrecio = new JLabel(tipoOperacion == "Subasta" ? "Precio inicial:" : "Precio:");
		lblPrecio.setHorizontalAlignment(JLabel.RIGHT);
		gbc.gridx = 0; // número columna
		gbc.gridy = 2; // número fila
		gbc.weightx = 0.1;
		pnlCentro.add(lblPrecio, gbc); // agregar el label al panel contenedor

		txtPrecio = new JTextField();
		gbc.gridx = 1; // número columna
		gbc.gridy = 2; // número fila
		gbc.weightx = 0.9;
		pnlCentro.add(txtPrecio, gbc); // agregar el textField al panel contenedor

		lblFormasDePago = new JLabel("Formas de pago:");
		lblFormasDePago.setHorizontalAlignment(JLabel.RIGHT);
		gbc.gridx = 0; // número columna
		gbc.gridy = 3; // número fila
		gbc.weightx = 0.1;
		pnlCentro.add(lblFormasDePago, gbc); // agregar el label al panel contenedor

		gbc.gridx = 1; // número columna
		gbc.gridy = 3; // número fila
		gbc.weightx = 0.9;
		
		int cantidadFilas = 5;
		if(tipoPublicacion == "Servicio"){
			lblContratacion = new JLabel("Tipo contratación: ");
			lblContratacion.setHorizontalAlignment(JLabel.RIGHT);
			gbc.gridx = 0; // número columna
			gbc.gridy = 4; // número fila
			gbc.weightx = 0.1;
			pnlCentro.add(lblContratacion, gbc); // agregar el label al panel contenedor
		}else{
			lblGarantia = new JLabel("Garantía: ");
			lblGarantia.setHorizontalAlignment(JLabel.RIGHT);
			gbc.gridx = 0; // número columna
			gbc.gridy = 4; // número fila
			gbc.weightx = 0.1;
			pnlCentro.add(lblGarantia, gbc); // agregar el label al panel contenedor
			cantidadFilas = 6;
			
			lblGarantiaCantidad = new JLabel("Garantía tiempo:");
			lblGarantiaCantidad.setHorizontalAlignment(JLabel.RIGHT);
			gbc.gridx = 0; // número columna
			gbc.gridy = 5; // número fila
			gbc.weightx = 0.1;
			pnlCentro.add(lblGarantiaCantidad, gbc); // agregar el label al panel contenedor

			txtGarantiaCantidad = new JTextField();
			gbc.gridx = 1; // número columna
			gbc.gridy = 5; // número fila
			gbc.weightx = 0.9;
			pnlCentro.add(txtGarantiaCantidad, gbc); // agregar el textField al panel contenedor
			
		}
		

		
		btnGuardar = new JButton("Publicar");		
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNombre.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Por favor ingrese el nombre");
					txtNombre.requestFocusInWindow();
					return;
				}
				

				if(txtDescripcion.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Por favor ingrese la descripción");
					txtDescripcion.requestFocusInWindow();
					return;
				}
				

				if(txtPrecio.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Por favor ingrese el precio");
					txtPrecio.requestFocusInWindow();
					return;
				}
				
				if(!txtPrecio.getText().matches("^[0-9]+$")){
					JOptionPane.showMessageDialog(null,
							"Por favor ingrese sólo números en el precio");
					txtPrecio.setText("");
					txtPrecio.requestFocusInWindow();
					return;
				}
				
				if(!chkEfectivo.isSelected() && !chkTransferencia.isSelected() && !chkTarjeta.isSelected()){
					JOptionPane.showMessageDialog(null,
							"Por favor seleccione una forma de pago");
					return;
				}
				
				if(tipoPublicacion == "Servicio"){
					if(!chkContratacionUnicaVez.isSelected() && !chkContratacionPorAbono.isSelected()){
						JOptionPane.showMessageDialog(null,
								"Por favor seleccione un tipo de contratación.");
						return;
					}
				}else{
					if(!chkGarantiaExtendida.isSelected() && !chkGarantiaMensual.isSelected() && !chkGarantiaAnual.isSelected()){
						JOptionPane.showMessageDialog(null,
								"Por favor seleccione un tipo de garantía.");
						return;
					}
					
					if(!chkGarantiaExtendida.isSelected()){
						
						if(txtGarantiaCantidad.getText().equals("")) {
							JOptionPane.showMessageDialog(null,
									"Por favor ingrese el tiempo de garantía.");
							txtGarantiaCantidad.requestFocusInWindow();
							return;
						}
						
						if(!txtGarantiaCantidad.getText().matches("^[0-9]+$")){
							JOptionPane.showMessageDialog(null,
									"Por favor ingrese sólo números en el tiempo de garantía.");
							txtGarantiaCantidad.setText("");
							txtGarantiaCantidad.requestFocusInWindow();
							return;
						}
						
					}
				}
				
				closeWin();
			}
		});

		gbc.gridx = 0; // número columna
		gbc.gridy = cantidadFilas; // número fila
		gbc.gridwidth = 2; // numero de columnas de ancho
		gbc.fill = GridBagConstraints.NONE; // rellenar la celda en ambos sentidos (horizontal y vertical)
		
		pnlCentro.add(getForPagTar(), new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		pnlCentro.add(getJCheckBox1(), new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		pnlCentro.add(getTransferencia(), new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		pnlCentro.add(btnGuardar, gbc); // agregar el textField al panel contenedor
		pnlCentro.add(getVolver(), new GridBagConstraints(1, gbc.gridy, 2, 1, 0.9, 1.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(3, 3, 3, 3), 0, 0));
		if(tipoPublicacion == "Servicio"){
			pnlCentro.add(getChkContratacionPorAbono(), new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			pnlCentro.add(getChkContratacionUnicaVez(), new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		}else{
			pnlCentro.add(getChkGarantiaExtendida(), new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			pnlCentro.add(getChkGarantiaAnual(), new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			pnlCentro.add(getChkGarantiaMensual(), new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		}
		return pnlCentro;
	}

	private void closeWin() {
		this.setVisible(false);
		this.dispose();
	    JFrame.getFrames()[1].setVisible(true);
	}
	
	private JCheckBox getForPagTar() {
		if(chkTarjeta == null) {
 		chkTarjeta = new JCheckBox();
			chkTarjeta.setText("Tarjeta de Crédito");
		}
		return chkTarjeta;
	}

	private JCheckBox getJCheckBox1() {
		if(chkEfectivo == null) {
			chkEfectivo = new JCheckBox();
			chkEfectivo.setText("Efectivo");
		}
		return chkEfectivo;
	}
	
	private JCheckBox getTransferencia() {
		if(chkTransferencia == null) {
			chkTransferencia = new JCheckBox();
			chkTransferencia.setText("Transferencia Bancaria");
		}
		return chkTransferencia;
	}
	
	private void setStepDescription(){
		String titlePrefix = "";
		if(tipoOperacion == "Subasta"){
			titlePrefix = "Subastar ";
		}else{
			titlePrefix = "Vender ";
		}
		this.stepDescription = titlePrefix + tipoPublicacion;
		
	}
	
	private JButton getVolver() {
		if(Volver == null) {
			Volver = new JButton();
			Volver.setText("Volver");
			Volver.setBounds(76, 62, 65, 23);
			Volver.addActionListener((ActionEvent event) -> {
				closeWin();
			});
		}
		return Volver;
	}
	
	private JCheckBox getChkContratacionPorAbono() {
		if(chkContratacionPorAbono == null) {
			chkContratacionPorAbono = new JCheckBox();
			chkContratacionPorAbono.setText("PorAbono");
			chkContratacionPorAbono.addActionListener((ActionEvent event) -> {
				chkContratacionUnicaVez.setSelected(false);
			});
		}
		return chkContratacionPorAbono;
	}
	
	private JCheckBox getChkContratacionUnicaVez() {
		if(chkContratacionUnicaVez == null) {
			chkContratacionUnicaVez = new JCheckBox();
			chkContratacionUnicaVez.setText("Por única vez");
			chkContratacionUnicaVez.addActionListener((ActionEvent event) -> {
				chkContratacionPorAbono.setSelected(false);
			});
		}
		return chkContratacionUnicaVez;
	}
	
	private JCheckBox getChkGarantiaExtendida() {
		if(chkGarantiaExtendida == null) {
			chkGarantiaExtendida = new JCheckBox();
			chkGarantiaExtendida.setText("Extendida");
			chkGarantiaExtendida.addActionListener((ActionEvent event) -> {
				chkGarantiaMensual.setSelected(false);
				chkGarantiaAnual.setSelected(false);
			});
		}
		return chkGarantiaExtendida;
	}
	
	private JCheckBox getChkGarantiaMensual() {
		if(chkGarantiaMensual == null) {
			chkGarantiaMensual = new JCheckBox();
			chkGarantiaMensual.setText("Mensual");
			chkGarantiaMensual.addActionListener((ActionEvent event) -> {
				chkGarantiaExtendida.setSelected(false);
				chkGarantiaAnual.setSelected(false);
			});
		}
		return chkGarantiaMensual;
	}
	
	private JCheckBox getChkGarantiaAnual() {
		if(chkGarantiaAnual == null) {
			chkGarantiaAnual = new JCheckBox();
			chkGarantiaAnual.setText("Anual");
			chkGarantiaAnual.addActionListener((ActionEvent event) -> {
				chkGarantiaExtendida.setSelected(false);
				chkGarantiaMensual.setSelected(false);
			});
		}
		return chkGarantiaAnual;
	}
}


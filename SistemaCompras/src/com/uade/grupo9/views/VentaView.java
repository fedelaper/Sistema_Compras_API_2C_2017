package com.uade.grupo9.views;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JButton Volver;
	private JCheckBox chkTarjeta;
	private JLabel lblDescripcion;
	private JLabel lblPrecio;
	private JLabel lblMail;
	private JTextField txtNombre;
	private JTextField txtDescripcion;
	private JTextField txtPrecio;
	private String tipoOperacion;
	private String tipoPublicacion;
	private String stepDescription;
	private int id;

	public VentaView(String tipoPublicacion, String tipoOperacion) {

		this.tipoPublicacion = tipoPublicacion;
		this.tipoOperacion = tipoOperacion;
		this.setStepDescription();
		// Establecer el titulo de la ventana
		UsuariosController uController = UsuariosController.get();
		this.setTitle("Usuario: " + uController.getCurrentUser().getNombreUsuario().toUpperCase() + " ( " + uController.getCurrentUser().getNombre().toUpperCase() + " " + uController.getCurrentUser().getApellido().toUpperCase() + " ) - " + this.stepDescription);
		// Establecer la dimension de la ventana (ancho, alto)
		this.setSize(839, 393);
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

		lblMail = new JLabel("Formas de pago:");
		lblMail.setHorizontalAlignment(JLabel.RIGHT);
		gbc.gridx = 0; // número columna
		gbc.gridy = 3; // número fila
		gbc.weightx = 0.1;
		pnlCentro.add(lblMail, gbc); // agregar el label al panel contenedor

		gbc.gridx = 1; // número columna
		gbc.gridy = 3; // número fila
		gbc.weightx = 0.9;

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
				
				if(!txtPrecio.getText().matches("\\d")){
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
				
				
				
				closeWin();
			}
		});

		gbc.gridx = 0; // número columna
		gbc.gridy = 4; // número fila
		gbc.gridwidth = 2; // numero de columnas de ancho
		gbc.fill = GridBagConstraints.NONE; // rellenar la celda en ambos sentidos (horizontal y vertical)
		pnlCentro.add(btnGuardar, gbc); // agregar el textField al panel contenedor
		pnlCentro.add(getForPagTar(), new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		pnlCentro.add(getJCheckBox1(), new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		pnlCentro.add(getTransferencia(), new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		pnlCentro.add(getVolver(), new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

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

}


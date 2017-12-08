package com.uade.grupo9.views;

import javax.swing.WindowConstants;

import com.uade.grupo9.controller.UsuariosController;

import javax.swing.SwingUtilities;

public class CompraView extends javax.swing.JFrame {

	/**
	* Auto-generated main method to display this JFrame
	*/

	private String tipoOperacion;
	private String tipoPublicacion;
	private String stepDescription;
	
	public CompraView(String tipoPublicacion, String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
		this.tipoPublicacion = tipoPublicacion;
		initGUI();
	}
	
	private void initGUI() {
		try {
			// Establecer el titulo de la ventana
			UsuariosController uController = UsuariosController.get();
			this.setTitle("Usuario: " + uController.getCurrentUser().getNombreUsuario().toUpperCase() + " ( " + uController.getCurrentUser().getNombre().toUpperCase() + " " + uController.getCurrentUser().getApellido().toUpperCase() + " ) - " + this.stepDescription);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	private void setStepDescription(){
		String titlePrefix = "";
		if(tipoOperacion == "Subasta"){
			titlePrefix = "Subastar ";
		}else{
			titlePrefix = "Comprar ";
		}
		this.stepDescription = titlePrefix + tipoPublicacion;
		
	}

}

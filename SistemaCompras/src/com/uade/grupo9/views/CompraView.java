package com.uade.grupo9.views;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

public class CompraView extends javax.swing.JFrame {

	/**
	* Auto-generated main method to display this JFrame
	*/
		
	public CompraView() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}

package com.uade.grupo9.views;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.uade.grupo9.controller.LoginController;
import javax.swing.SwingUtilities;


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
public class LoginView extends javax.swing.JFrame {
	private JTextPane DispatcherViewTitle;
	private JButton DispatcherViewSubmitButton;
	private JTextField DispatcherViewUser;
	private JPanel jPanel1;
	private JPasswordField DispatcherViewPassword;

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				LoginView inst = new LoginView();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public LoginView() {
		super();
		initGUI();
	}
	
	@SuppressWarnings("deprecation")
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setAutoRequestFocus(false);
			this.setTitle("Venta y subasta de productos y servicios");
			{
				DispatcherViewTitle = new JTextPane();
				getContentPane().add(DispatcherViewTitle, BorderLayout.NORTH);
				DispatcherViewTitle.setText("Ingresá usuario y clave");
				DispatcherViewTitle.setFont(new java.awt.Font("Segoe UI",1,12));
				DispatcherViewTitle.setPreferredSize(new java.awt.Dimension(381, 24));
				DispatcherViewTitle.setFocusable(false);
				DispatcherViewTitle.setEditable(false);
			}
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1, BorderLayout.EAST);
				jPanel1.setPreferredSize(new java.awt.Dimension(297, 116));
				{
					DispatcherViewUser = new JTextField();
					jPanel1.add(DispatcherViewUser);
					DispatcherViewUser.setPreferredSize(new java.awt.Dimension(128, 28));
					DispatcherViewUser.setText("Usuario");
				}
				{
					DispatcherViewPassword = new JPasswordField();
					jPanel1.add(DispatcherViewPassword);
					DispatcherViewPassword.setText("Clave");
					DispatcherViewPassword.setToolTipText("Clave");
					DispatcherViewPassword.setPreferredSize(new java.awt.Dimension(135, 29));
				}
				{
					DispatcherViewSubmitButton = new JButton();
					jPanel1.add(DispatcherViewSubmitButton);
					DispatcherViewSubmitButton.setText("Ingresar");
					DispatcherViewSubmitButton.addActionListener((ActionEvent event) -> {
					    LoginController loginController = new LoginController();
					    if(!loginController.validarFormatoContraseniaUsuario(DispatcherViewPassword.getText())){
					    	JOptionPane.showMessageDialog(null, "Contraseña inválida. La misma debe cumplir los siguientes requisitos: \n - Tener de 8 a 20 caracteres. \n - Tener al menos un carácter numérico y al menos un carácter mayúscula");
					    }else{
					    	
					    }
					});
					}
				}
			
			pack();
			this.setSize(397, 161);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}

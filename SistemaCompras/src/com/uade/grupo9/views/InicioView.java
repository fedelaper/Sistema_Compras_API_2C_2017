package com.uade.grupo9.views;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

import javax.swing.WindowConstants;

import com.uade.grupo9.controller.LoginController;
import com.uade.grupo9.controller.UsuariosController;

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
public class InicioView extends JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JMenuBar jMenuBar1;
	private JMenu jMenu1;
	private JMenuItem jMenuComprar;
	private JMenuItem jMenuVender;
	private UsuariosController uController;
	private JLabel jLabel_IL;

	public InicioView(String usuario) {
		super();
		uController = new UsuariosController();
		if(!uController.existeUsuario(usuario)){
			JOptionPane.showMessageDialog(null, "Usuario " + usuario + " inexistente.");
		}else{
			uController.setCurrentUser(usuario);
			//oculto frame de login
			JFrame.getFrames()[0].setVisible(false);
			initGUI();
		}
		
	}
	
	private void initGUI() {
		try {
			// Load the background image
            BufferedImage img = ImageIO.read(new File(System.getProperty("user.dir") + "\\img\\imagen.jpg"));
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					jMenu1 = new JMenu();
					jMenuBar1.add(jMenu1);
					jMenu1.setText("Operar");
					{
						jMenuComprar = new JMenuItem();
						jMenu1.add(jMenuComprar);
						jMenuComprar.setText("Comprar");
						jMenuVender = new JMenuItem();
						jMenu1.add(jMenuVender);
						jMenuVender.setText("Vender");
						jMenuVender.addActionListener((ActionEvent event) -> {
							this.setVisible(false);
						    new VentaView(uController);
						});
					}
				}
			}
			pack();
			this.setSize(398, 361);
			this.setVisible(true);
			this.setTitle("Inicio");
			{
				jLabel_IL = new JLabel(new ImageIcon(img));
				this.setContentPane(jLabel_IL);
				jLabel_IL.setPreferredSize(new java.awt.Dimension(419, 306));
			}
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
}

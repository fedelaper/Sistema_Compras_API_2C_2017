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
	private JMenuItem jMenuSubastarProducto;
	private JMenuItem jMenuVenderProducto;
	private JMenuItem jMenuSubastarServicio;
	private JMenuItem jMenuVenderServicio;
	private JLabel jLabel_IL;
	private JMenuItem jMenuItem4;
	private JMenuItem jMenuItem3;
	private JMenu jMenu2;
	private JMenuItem jMenuItem2;
	private JMenuItem jMenuItem1;
	private JMenu Comprar;

	public InicioView(String usuario) {
		super();
		UsuariosController uController = UsuariosController.get();
		if(!uController.existeUsuario(usuario)){
			JOptionPane.showMessageDialog(null, "Usuario " + usuario + " inexistente.");
		}else{
			//oculto frame de login
			JFrame.getFrames()[0].setVisible(false);
			initGUI();
			this.setTitle("Usuario: " + uController.getCurrentUser().getNombreUsuario().toUpperCase() + " ( " + uController.getCurrentUser().getNombre().toUpperCase() + " " + uController.getCurrentUser().getApellido().toUpperCase() + " ) - Inicio");
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
					jMenu1.setText("Publicar");
					{
						jMenuSubastarProducto = new JMenuItem();
						jMenu1.add(jMenuSubastarProducto);
						jMenuSubastarProducto.setText("Subastar producto");
						jMenuSubastarProducto.addActionListener((ActionEvent event) -> {
							JOptionPane.showMessageDialog(null,
									"Funcionalidad en desarrollo.");
						    //new VentaView("Producto", "Subasta");
						});
						jMenuVenderProducto = new JMenuItem();
						jMenu1.add(jMenuVenderProducto);
						jMenuVenderProducto.setText("Vender producto");
						jMenuVenderProducto.addActionListener((ActionEvent event) -> {
						    new VentaView("Producto", "Venta");
						});
						jMenuSubastarServicio = new JMenuItem();
						jMenu1.add(jMenuSubastarServicio);
						jMenuSubastarServicio.setText("Subastar servicio");
						jMenuSubastarServicio.addActionListener((ActionEvent event) -> {
							JOptionPane.showMessageDialog(null,
									"Funcionalidad en desarrollo.");
						    //new VentaView("Servicio", "Subasta");
						});
						jMenuVenderServicio = new JMenuItem();
						jMenu1.add(jMenuVenderServicio);
						jMenuVenderServicio.setText("Vender servicio");
						jMenuVenderServicio.addActionListener((ActionEvent event) -> {
							this.setVisible(false);
						    new VentaView("Servicio", "Venta");
						});
					}
				}
				{
					Comprar = new JMenu();
					jMenuBar1.add(Comprar);
					Comprar.setText("Comprar");
					{
						jMenuItem1 = new JMenuItem();
						Comprar.add(jMenuItem1);
						jMenuItem1.setText("Producto");
						jMenuVenderServicio.addActionListener((ActionEvent event) -> {
							this.setVisible(false);
						    new CompraView("Servicio", "Venta");
						});
					}
					{
						jMenuItem2 = new JMenuItem();
						Comprar.add(jMenuItem2);
						jMenuItem2.setText("Servicio");
					}
				}
				{
					jMenu2 = new JMenu();
					jMenuBar1.add(jMenu2);
					jMenu2.setText("Subastar");
					{
						jMenuItem3 = new JMenuItem();
						jMenu2.add(jMenuItem3);
						jMenuItem3.setText("Producto");
						jMenuItem3.addActionListener((ActionEvent event) -> {
							JOptionPane.showMessageDialog(null,
									"Funcionalidad en desarrollo.");
						    //new VentaView("Servicio", "Subasta");
						});
					}
					
					{
						jMenuItem4 = new JMenuItem();
						jMenu2.add(jMenuItem4);
						jMenuItem4.setText("Servicio");
						jMenuItem4.addActionListener((ActionEvent event) -> {
							JOptionPane.showMessageDialog(null,
									"Funcionalidad en desarrollo.");
						    //new VentaView("Servicio", "Subasta");
						});
					}
				}
			}
			pack();
			this.setSize(398, 361);
			// Establecer NO dimensionable la ventana
			this.setResizable(false);
			// Ubicar la ventana en el centro de la pantalla
			this.setLocationRelativeTo(null);
			
			this.setVisible(true);
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

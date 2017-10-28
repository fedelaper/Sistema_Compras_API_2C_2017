package com.uade.grupo9.views;
import java.awt.BorderLayout;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

import javax.swing.WindowConstants;
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
public class InicioView extends javax.swing.JFrame {
	private JMenuBar jMenuBar1;
	private JMenu jMenu1;
	private JMenuItem jMenuComprar;
	private JMenuItem jMenuVender;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				InicioView inst = new InicioView();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public InicioView() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
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
					}
				}
			}
			pack();
			this.setSize(552, 438);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}

/*
 * 
 */
package pl.ftims.zaawJava.View;

import java.awt.Dialog.ModalExclusionType;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;

// TODO: Auto-generated Javadoc
/**
 *RowerReport wyswietla okno wyboru roweru dla ktorego chcemy wygenerowac raport
 */
public class RowerReport extends JFrame{
	
	public JButton btnOk = new JButton("OK");
	public JComboBox comboBox = new JComboBox();
	
	/**
	 * Tworzy nowy obiekt RowerReport
	 */
	public RowerReport(){
		setVisible(true);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 300, 244, 176);
		setResizable(false);
		setTitle("Wybierz rower");
		getContentPane().setLayout(null);
				
		comboBox.setBounds(127, 11, 47, 20);
		getContentPane().add(comboBox);
		
		btnOk.setBounds(71, 96, 89, 23);
		getContentPane().add(btnOk);
		
		JLabel lblNumerRoweru = new JLabel("Numer roweru");
		lblNumerRoweru.setBounds(23, 14, 115, 14);
		getContentPane().add(lblNumerRoweru);
		
	}
}

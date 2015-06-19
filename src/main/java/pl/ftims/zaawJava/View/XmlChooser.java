/*
 * 
 */
package pl.ftims.zaawJava.View;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Dialog.ModalExclusionType;

// TODO: Auto-generated Javadoc
/**
 * XmlChooser rysuje okno wyboru zapisu list obiektow do plikow XML.
 */
public class XmlChooser extends JFrame {
	
	public JButton btnOk = new JButton("OK");
	
	public JCheckBox chckbxKlienci = new JCheckBox("Klienci");
	
	public JCheckBox chckbxRowery = new JCheckBox("Rowery");
	
	public JCheckBox chckbxWypozyczenia = new JCheckBox("Wypozyczenia");
	
	public JCheckBox chckbxZdarzenia = new JCheckBox("Zdarzenia");
	
	/**
	 * Tworzy nowy obiekt XmlChooser
	 */
	public XmlChooser() {
		setVisible(true);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 300, 300, 210);
		setResizable(false);
		setTitle("Wybierz elementy");
		getContentPane().setLayout(null);
		
		JLabel lblZaznaczElementyKtore = new JLabel("Zaznacz elementy, ktore chcesz serializowac");
		lblZaznaczElementyKtore.setBounds(10, 11, 269, 14);
		getContentPane().add(lblZaznaczElementyKtore);
		
		
		chckbxKlienci.setBounds(20, 32, 97, 23);
		getContentPane().add(chckbxKlienci);
		
		
		chckbxRowery.setBounds(20, 58, 97, 23);
		getContentPane().add(chckbxRowery);
		
		
		chckbxWypozyczenia.setBounds(20, 84, 133, 23);
		getContentPane().add(chckbxWypozyczenia);
		
		
		chckbxZdarzenia.setBounds(20, 110, 97, 23);
		getContentPane().add(chckbxZdarzenia);
		
		
		btnOk.setBounds(109, 153, 89, 23);
		getContentPane().add(btnOk);
	}
}

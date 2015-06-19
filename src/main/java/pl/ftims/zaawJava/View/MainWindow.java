/*
 * 
 */
package pl.ftims.zaawJava.View;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


// TODO: Auto-generated Javadoc
/**
 * MainWindow reprezentuje okno glowne aplikacji
 */
public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	public JFileChooser files = new JFileChooser();
	FileNameExtensionFilter filter = new FileNameExtensionFilter("Plik bazy danych mdb","mdb");
    public TextField textField_1 = new TextField();
    public TextField textField_2 = new TextField();
    public TextField textField_3 = new TextField();
    public TextField textField_4 = new TextField();
    public TextField textField_5 = new TextField();
    public TextField textField_6 = new TextField();
    public TextField textField_7 = new TextField();
    public TextField textField_8 = new TextField();
    public TextField textField_10 = new TextField();
    public TextField textField_9 = new TextField();
    public TextField textField_11 = new TextField();
    public TextField textField_12 = new TextField();
    public TextField textField_13 = new TextField();
    public TextField textField_14 = new TextField();
    public TextField textField_15 = new TextField();
    public TextField textField_16 = new TextField();
	public TextField textField_17 = new TextField();
	public TextField textField_18 = new TextField();
	public TextField textField_19 = new TextField();
	public TextField textField_20 = new TextField();
	public TextField textField_21 = new TextField();
	public TextField textField_22 = new TextField();
	
	

	public JMenuItem mntmWczytajBazeDanych = new JMenuItem("Wczytaj baze danych");
	public JMenuItem mntmZapiszDoXml = new JMenuItem("Zapisz do XML");
    public JMenuItem mntmWczytajZXml = new JMenuItem("Wczytaj z XML");
    public JMenuItem mntmGenerujRaport = new JMenuItem("Generuj Raport Finansowy");
    public JMenuItem mntmGenerujRaport2 = new JMenuItem("Generuj Raport Finansowy z okresu");
    public JMenuItem mntmGenerujRaportRoweru = new JMenuItem("Generuj Raport Roweru");
    public JMenuItem mntmWindows = new JMenuItem("Windows");
    public JMenuItem mntmMetal = new JMenuItem("Metal");
    public JMenuItem mntmNimbus = new JMenuItem("Nimbus");
    public JMenuItem mntmCd = new JMenuItem("CDE/Motif");
    public JMenuItem mntmWindowsClassic = new JMenuItem("Windows Classic");
    
    public JComboBox<String> comboBox = new JComboBox<String>();
    public JComboBox<String> comboBox_1 = new JComboBox<String>();
    public JComboBox<String> comboBox_2 = new JComboBox<String>();
    public JComboBox<String> comboBox_3 = new JComboBox<String>();
	public JComboBox<String> comboBox_4 = new JComboBox<String>();

    public Button button = new Button("Edytuj");
    public Button button_1 = new Button("Dodaj");
    //Button button_2 = new Button("Usun");
    public Button button_3 = new Button("Zapisz");
    public Button button_4 = new Button("Zapisz");
    //Button button_5 = new Button("Usun");
    public Button button_6 = new Button("Dodaj");
    public Button button_7 = new Button("Zapisz");
    //Button button_8 = new Button("Usun");
    public Button button_9 = new Button("Dodaj");
	public Button button_10 = new Button("Dodaj");
	public Button button_11 = new Button("Zapisz");
	public Button button_12 = new Button("Usun");
	public Button button_13 = new Button("Generuj");
	
	/**
	 * Tworzy okno glowne
	 */
	public MainWindow(){
	
	files.setFileFilter(filter);
	setResizable(false);
	setTitle("Wypozyczalnia Rowerow 2015.05.27");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    setSize(544, 469);
    setLocation(400, 200);
    getContentPane().setBackground(new Color(200,200,200));
    getContentPane().setLayout(null);
    
    JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
    tabbedPane.setBounds(0, 0, 538, 419);
    getContentPane().add(tabbedPane);
    
    JPanel panel = new JPanel();
    panel.setToolTipText("Zawiera dane dotyczace klientow");
    tabbedPane.addTab("Klienci", null, panel, null);
    panel.setLayout(null);
    
    Label label = new Label("Imie");
    label.setBounds(10, 23, 69, 23);
    panel.add(label);
    
    TextField textField = new TextField();
    textField.setBounds(55, 23, 24, 23);
    panel.add(textField);
    

    textField_1.setBounds(86, 23, 170, 23);
    panel.add(textField_1);
    
    Label label_1 = new Label("Nazwisko");
    label_1.setBounds(10, 52, 69, 23);
    panel.add(label_1);
    
    
    textField_2.setBounds(86, 52, 170, 23);
    panel.add(textField_2);
    
    Label label_2 = new Label("Adres");
    label_2.setBounds(10, 81, 69, 23);
    panel.add(label_2);
    
    
    textField_3.setBounds(86, 81, 170, 23);
    panel.add(textField_3);
    
    Label label_3 = new Label("PESEL");
    label_3.setBounds(10, 110, 69, 23);
    panel.add(label_3);
    
    
    textField_4.setBounds(86, 110, 170, 23);
    panel.add(textField_4);
    
    Label label_4 = new Label("Uwagi");
    label_4.setBounds(10, 139, 69, 23);
    panel.add(label_4);
    
    
    textField_5.setBounds(86, 139, 170, 88);
    panel.add(textField_5);
    
    button_1.setBounds(278, 23, 76, 23);
    panel.add(button_1);
    
    //button_2.setBounds(278, 81, 76, 23);
    //panel.add(button_2);
    
    button_3.setBounds(278, 52, 76, 23);
    panel.add(button_3);
    
    comboBox.setBounds(370, 50, 134, 25);
    panel.add(comboBox);
    
    Label label_5 = new Label("Klient");
    label_5.setBounds(405, 23, 69, 23);
    panel.add(label_5);
    
    JPanel panel_1 = new JPanel();
    tabbedPane.addTab("Rowery", null, panel_1, null);
    panel_1.setLayout(null);
    
    Label label_6 = new Label("Model");
    label_6.setBounds(10, 10, 69, 23);
    panel_1.add(label_6);
    
    textField_6.setBounds(86, 10, 170, 23);
    panel_1.add(textField_6);
    
    
    textField_7.setBounds(86, 39, 170, 23);
    panel_1.add(textField_7);
    
    Label label_7 = new Label("Nr. Seryjny");
    label_7.setBounds(10, 39, 69, 23);
    panel_1.add(label_7);
    
    Label label_8 = new Label("Przebieg");
    label_8.setBounds(10, 68, 69, 23);
    panel_1.add(label_8);
    
    
    textField_8.setBounds(86, 68, 170, 23);
    panel_1.add(textField_8);
    
    Label label_9 = new Label("Dostepny");
    label_9.setBounds(10, 97, 69, 23);
    panel_1.add(label_9);
    
    Label label_10 = new Label("Uwagi");
    label_10.setBounds(10, 126, 69, 23);
    panel_1.add(label_10);
    
    
    textField_10.setBounds(86, 126, 170, 88);
    panel_1.add(textField_10);
    
    button_4.setBounds(278, 39, 76, 23);
    panel_1.add(button_4);
    
    //button_5.setBounds(278, 68, 76, 23);
    //panel_1.add(button_5);
    
    button_6.setBounds(278, 10, 76, 23);
    panel_1.add(button_6);
    
    Label label_11 = new Label("Rower");
    label_11.setBounds(405, 10, 69, 23);
    panel_1.add(label_11);
    
    comboBox_1.setBounds(370, 37, 134, 25);
    panel_1.add(comboBox_1);
    
    
    comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"TAK", "NIE"}));
    comboBox_2.setBounds(86, 95, 169, 25);
    panel_1.add(comboBox_2);
    
    JPanel panel_2 = new JPanel();
    tabbedPane.addTab("Wypozyczenia", null, panel_2, null);
    panel_2.setLayout(null);
    
    Label label_12 = new Label("Klient");
    label_12.setBounds(10, 10, 69, 23);
    panel_2.add(label_12);
    
    textField_9.setBounds(86, 10, 170, 23);
    panel_2.add(textField_9);
    
    textField_11.setBounds(86, 39, 170, 23);
    panel_2.add(textField_11);
    
    Label label_13 = new Label("Rower");
    label_13.setBounds(10, 39, 69, 23);
    panel_2.add(label_13);
    
    Label label_14 = new Label("Data wypozyczenia");
    label_14.setBounds(10, 68, 69, 23);
    panel_2.add(label_14);
    
    textField_12.setBounds(86, 68, 170, 23);
    panel_2.add(textField_12);
     
    textField_13.setBounds(86, 97, 170, 23);
    panel_2.add(textField_13);
    
    Label label_15 = new Label("Data zwrotu");
    label_15.setBounds(10, 97, 69, 23);
    panel_2.add(label_15);
    
    Label label_16 = new Label("Uwagi");
    label_16.setBounds(10, 186, 69, 23);
    panel_2.add(label_16);
    
    
    textField_14.setBounds(86, 186, 170, 88);
    panel_2.add(textField_14);
    
    button_7.setBounds(278, 39, 76, 23);
    panel_2.add(button_7);
    
    //button_8.setBounds(278, 68, 76, 23);
    //panel_2.add(button_8);
    
    button_9.setBounds(278, 10, 76, 23);
    panel_2.add(button_9);
    
    Label label_17 = new Label("Wypozyczenie");
    label_17.setBounds(405, 10, 81, 23);
    panel_2.add(label_17);
    
    comboBox_3.setBounds(370, 37, 134, 25);
    panel_2.add(comboBox_3);
    
    Label label_18 = new Label("Stawka");
    label_18.setBounds(10, 126, 69, 23);
    panel_2.add(label_18);
    
    textField_15.setBounds(86, 126, 170, 23);
    panel_2.add(textField_15);
    
    Label label_19 = new Label("Wartosc");
    label_19.setBounds(10, 157, 69, 23);
    panel_2.add(label_19);
    
    
    textField_16.setBounds(86, 157, 170, 23);
    panel_2.add(textField_16);
    
    JPanel panel_3 = new JPanel();
    tabbedPane.addTab("Wydarzenia", null, panel_3, null);
    panel_3.setLayout(null);
    
    
    textField_17.setBounds(86, 10, 170, 23);
    panel_3.add(textField_17);
    
    Label label_20 = new Label("Tytul");
    label_20.setBounds(10, 10, 69, 23);
    panel_3.add(label_20);
    
    button_10.setBounds(278, 10, 76, 23);
    panel_3.add(button_10);
    
    Label label_21 = new Label("Data");
    label_21.setBounds(10, 39, 69, 23);
    panel_3.add(label_21);
    textField_18.setEditable(false);
    
    
    textField_18.setBounds(86, 39, 170, 23);
    panel_3.add(textField_18);
    
    Label label_22 = new Label("Opis");
    label_22.setBounds(10, 96, 69, 23);
    panel_3.add(label_22);
    
    
    textField_19.setBounds(86, 96, 170, 120);
    panel_3.add(textField_19);
    
    Label label_23 = new Label("Wartosc");
    label_23.setBounds(10, 67, 69, 23);
    panel_3.add(label_23);
    
    textField_20.setBounds(86, 67, 170, 23);
    panel_3.add(textField_20);
    
    button_11.setBounds(278, 39, 76, 23);
    panel_3.add(button_11);
    
    Label label_24 = new Label("Wydarzenie");
    label_24.setBounds(408, 10, 81, 23);
    panel_3.add(label_24);
    
    comboBox_4.setBounds(373, 37, 134, 25);
    panel_3.add(comboBox_4);
    
    
    button_12.setBounds(278, 96, 76, 23);
    panel_3.add(button_12);
    
    button.setBounds(278, 67, 76, 23);
    panel_3.add(button);
    
    JMenuBar menuBar = new JMenuBar();
    setJMenuBar(menuBar);
    
    JMenu mnPlik = new JMenu("Plik");
    menuBar.add(mnPlik);
    
    JMenu mnOtworz = new JMenu("Otworz");
    mnPlik.add(mnOtworz);
    
    
    mnOtworz.add(mntmWczytajBazeDanych);
    
    

    mnOtworz.add(mntmWczytajZXml);
    
    JMenu mnZapisz = new JMenu("Zapisz");
    mnPlik.add(mnZapisz);
    
    mnZapisz.add(mntmZapiszDoXml);
    
    JSeparator separator = new JSeparator();
    mnPlik.add(separator);
    
    JMenuItem mntmZamknij = new JMenuItem("Zamknij");
    mnPlik.add(mntmZamknij);
    
    JMenu mnEdycja = new JMenu("Raporty");
    menuBar.add(mnEdycja);
    
    mnEdycja.add(mntmGenerujRaportRoweru);
    
    mnEdycja.add(mntmGenerujRaport);

    mnEdycja.add(mntmGenerujRaport2);
    
    JMenu mnOpcje = new JMenu("Opcje");
    menuBar.add(mnOpcje);
    
    JMenu mnStyl = new JMenu("Styl");
    mnOpcje.add(mnStyl);
    
    mnStyl.add(mntmMetal);
    mnStyl.add(mntmNimbus);
    mnStyl.add(mntmCd);
    mnStyl.add(mntmWindows);
    mnStyl.add(mntmWindowsClassic);
    
    JMenu mnPomoc = new JMenu("Pomoc");
    menuBar.add(mnPomoc);
    
    JMenuItem mntmOProgramie = new JMenuItem("O Programie");
    mntmOProgramie.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		JOptionPane.showMessageDialog(null, "Wypozyczalnia rowerow 2015","O Programie",JOptionPane.INFORMATION_MESSAGE);
        
    	}
    });
    mnPomoc.add(mntmOProgramie);
    
    JMenuItem mntmOAutorach = new JMenuItem("Autor");
    mntmOAutorach.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		JOptionPane.showMessageDialog(null, "Jakub Kepa 180582","O Autorze",JOptionPane.INFORMATION_MESSAGE);
    	}
    });
    mnPomoc.add(mntmOAutorach);
	}
	
    /**
     * Tworzy komunikat o bledzie
     *
     * @param errorMessage wiadomosc o bledzie
     */
    public void displayErrorMessage(String errorMessage){
	         
        JOptionPane.showMessageDialog(this, errorMessage,"Blad!",JOptionPane.ERROR_MESSAGE);
        }
}

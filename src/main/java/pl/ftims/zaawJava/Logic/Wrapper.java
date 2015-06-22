/*
 * 
 */
package pl.ftims.zaawJava.Logic;

import java.util.*;

import javax.swing.JOptionPane;

import pl.ftims.zaawJava.DAO.*;
import pl.ftims.zaawJava.View.MainWindow;

// TODO: Auto-generated Javadoc
/**
 * WypozyczalniaWrapper zawiera widok, model i kontroler aplikacji, wykorzystywana jako opakowanie dla calej aplikacji
 */
public class Wrapper {
	
	/** model */
	public Database database;
	
	/** kontroler */
	public Controller controller;
	
	/** widok*/
	public MainWindow mainwindow;
	
	/**
	 * Tworzy nowy wrapper dla calej wypozyczalni zawierajacy model, widok i kontroler, widok korzysta z bazy, kontroler korzysta z bazy danych i widoku
	 */
	public Wrapper() {
		database = new Database();
		mainwindow = new MainWindow();
		controller = new Controller(database,mainwindow);
		controller.loadData(database);
		
	}

}

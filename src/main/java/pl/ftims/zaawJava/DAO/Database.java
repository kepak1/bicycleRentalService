/*
 * 
 */
package pl.ftims.zaawJava.DAO;

import java.io.File;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.*;

import javax.swing.*;

import pl.ftims.zaawJava.Entities.*;

// TODO: Auto-generated Javadoc
/**
 * Database zajmuje sie obsluga bazy danych tj. pobieraniem i zapisywaniem
 * danych
 */
public class Database {

	/** Polaczenie z baza danych */
	private Connection conn;

	/** ResultSet do przechowywania tabeli klientow */
	private ResultSet klienci;

	/** ResultSet do przechowywania tabeli rowerow */
	private ResultSet rowery;

	/** ResultSet do przechowywania tabeli wypozyczen */
	private ResultSet wypozyczenia;

	/** ResultSet do przechowywania tabeli wydarzen */
	private ResultSet wydarzenia;

	/**
	 * Tworzy baze danych
	 * 
	 * @param dbfile
	 *            nazwa pliku .mdb z baza danych
	 */
	public void initDatabase(String dbfile) {

		String file = new File(dbfile).getAbsolutePath();
		try {

			conn = DriverManager
					.getConnection("JDBC:ODBC:DRIVER={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="
							+ file);

			Statement klient = conn
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			klienci = klient.executeQuery("SELECT * FROM Klienci");
			Statement rower = conn
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			rowery = rower.executeQuery("SELECT * FROM Rowery");
			Statement wypozyczenie = conn
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			wypozyczenia = wypozyczenie
					.executeQuery("SELECT * FROM Wypozyczenia");
			Statement wydarzenie = conn
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			wydarzenia = wydarzenie.executeQuery("SELECT * FROM Zdarzenia");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.toString(), "Blad!",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Odczytaj klientow.
	 * 
	 * @param dbfile
	 *            nazwa pliku z baza danych
	 * @return the array zwracana lista klientow
	 * @throws SQLException
	 *             wyjatek SQL
	 */
	public ArrayList<Client> readClients(String dbfile)
			throws SQLException {
		initDatabase(dbfile);
		try {

			klienci.first();
			ArrayList<Client> bufor = new ArrayList<Client>();
			do {
				bufor.add(new Client(klienci.getInt("ID_Klienta"), klienci
						.getString("Imie"), klienci.getString("Nazwisko"),
						klienci.getString("Adres"), klienci.getInt("PESEL"),
						klienci.getString("Uwagi")));
				klienci.next();
			} while (!klienci.isAfterLast());

			return bufor;
		} catch (SQLException e) {
			throw e;
		} finally {
			if (conn != null) {
				conn.close();
			}
		}

	}

	/**
	 * Odczytaj rowery.
	 * 
	 * @param dbfile
	 *            nazwa pliku z baza danych
	 * @return the array zwracana lista rowerow
	 * @throws SQLException
	 *             wyjatek SQL
	 */
	public ArrayList<Bicycles> readBicycles(String dbfile) throws SQLException {
		initDatabase(dbfile);
		try {

			rowery.first();
			ArrayList<Bicycles> bufor = new ArrayList<Bicycles>();
			do {
				bufor.add(new Bicycles(rowery.getInt("ID_Roweru"), rowery
						.getString("Model"), rowery.getString("Nr_Seryjny"),
						rowery.getInt("Przebieg"), rowery
								.getBoolean("Dostepny"), rowery
								.getString("Uwagi")));
				rowery.next();
			} while (!rowery.isAfterLast());

			return bufor;
		} catch (SQLException e) {
			throw e;
		} finally {
			if (conn != null) {
				conn.close();
			}
		}

	}

	/**
	 * Odczytaj wypozyczenia.
	 * 
	 * @param dbfile
	 *            nazwa pliku z baza danych
	 * @return the array zwracana lista wypozyczen
	 * @throws SQLException
	 *             wyjatek SQL
	 */
	public ArrayList<Rent> readRents(String dbfile)
			throws SQLException {
		initDatabase(dbfile);
		try {

			wypozyczenia.first();
			ArrayList<Rent> bufor = new ArrayList<Rent>();
			do {
				bufor.add(new Rent(wypozyczenia
						.getInt("ID_Wypozyczenia"), wypozyczenia
						.getInt("Klient"), wypozyczenia.getInt("Rower"),
						wypozyczenia.getString("Data_wyp"), wypozyczenia
								.getString("Data_zwr"), wypozyczenia
								.getDouble("Stawka"), wypozyczenia
								.getDouble("Wartosc"), wypozyczenia
								.getString("Uwagi")));
				wypozyczenia.next();
			} while (!wypozyczenia.isAfterLast());

			return bufor;
		} catch (SQLException e) {
			throw e;
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	/**
	 * Odczytaj zdarzenia.
	 * 
	 * @param dbfile
	 *            nazwa pliku z baza danych
	 * @return the array zwracana lista zdarzen
	 * @throws SQLException
	 *             wyjatek SQL
	 */
	public ArrayList<Zdarzenie> readEvents(String dbfile)
			throws SQLException {
		initDatabase(dbfile);
		try {

			wydarzenia.first();
			ArrayList<Zdarzenie> bufor = new ArrayList<Zdarzenie>();
			do {
				bufor.add(new Zdarzenie(wydarzenia.getInt("ID_Zdarzenia"),
						wydarzenia.getString("Tytul"), wydarzenia
								.getString("Data"), wydarzenia
								.getDouble("Wartosc"), wydarzenia
								.getString("Opis")));
				wydarzenia.next();
			} while (!wydarzenia.isAfterLast());

			return bufor;
		} catch (SQLException e) {
			throw e;
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	/**
	 * Zapisz zdarzenia.
	 * 
	 * @param EventsChanged
	 *            zmieniona lista zdarzen
	 * @param dbfile
	 *            nazwa pliku z baza danych
	 */
	public void saveEvents(ArrayList<Zdarzenie> EventsChanged,
			String dbfile) {

		try {
			initDatabase(dbfile);
			Statement wyda = conn
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			for (int i = 0; i < EventsChanged.size(); i++) {
				if (EventsChanged.get(i).getID() != null) {
					wyda.executeUpdate("UPDATE Zdarzenia SET Tytul='"
							+ EventsChanged.get(i).getTytul() 
							+"', Data='"+ EventsChanged.get(i).getData() 
							+ "', Wartosc=" + EventsChanged.get(i).getWartosc() 
							+ ", Opis='" + EventsChanged.get(i).getOpis()
							+ "' WHERE ID_Zdarzenia="
							+ EventsChanged.get(i).getID() + "");
					
				} else {
					wyda.executeUpdate("INSERT INTO Zdarzenia (Tytul,Data,Wartosc,Opis) VALUES ('"
							+ EventsChanged.get(i).getTytul()
							+ "','"
							+ EventsChanged.get(i).getData()
							+ "','"
							+ EventsChanged.get(i).getWartosc()
							+ "','"
							+ EventsChanged.get(i).getOpis() + "')");
				}
			}
			JOptionPane.showMessageDialog(null,
					"Pomyslnie zrobiono update bazy danych",
					"Operacja zakonczona",
					JOptionPane.INFORMATION_MESSAGE);
			conn.close();
		} 
		catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.toString(), "Blad!",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Zapisz klientow.
	 * 
	 * @param ClientsChanged
	 *            zmieniona lista klientow
	 * @param dbfile
	 *            nazwa pliku z baza danych
	 */
	public void saveClients(ArrayList<Client> ClientsChanged, String dbfile) {
		try {
			initDatabase(dbfile);
			Statement kli = conn
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			for (int i = 0; i < ClientsChanged.size(); i++) {
				if (ClientsChanged.get(i).getID() != null) {
					kli.executeUpdate("UPDATE Klienci SET Imie='"
							+ ClientsChanged.get(i).getFirstName() 
							+ "', Nazwisko='" + ClientsChanged.get(i).getLastName()
							+ "', Adres='" + ClientsChanged.get(i).getAdress()
							+ "', PESEL=" + ClientsChanged.get(i).getPESEL()
							+ ", Uwagi='" + ClientsChanged.get(i).getComments()
							+ "' WHERE ID_Klienta =" + ClientsChanged.get(i).getID()
							+ "");
				} else {
					kli.executeUpdate("INSERT INTO Klienci (Imie,Nazwisko,Adres,PESEL,Uwagi) VALUES ('"
							+ ClientsChanged.get(i).getFirstName()
							+ "','"
							+ ClientsChanged.get(i).getLastName()
							+ "','"
							+ ClientsChanged.get(i).getAdress()
							+ "',"
							+ ClientsChanged.get(i).getPESEL()
							+ ",'"
							+ ClientsChanged.get(i).getComments() + "')");
				}
			}
			JOptionPane.showMessageDialog(null,
					"Pomyslnie zrobiono update bazy danych",
					"Operacja zakonczona",
					JOptionPane.INFORMATION_MESSAGE);
			conn.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.toString(), "Blad!",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * Zapisz rowery.
	 * 
	 * @param BicyclesChanged
	 *            zmieniona lista rowerow
	 * @param dbfile
	 *            nazwa pliku z baza danych
	 */
	public void saveBicycles(ArrayList<Bicycles> BicyclesChanged, String dbfile) {
		try {
			initDatabase(dbfile);
			Statement row = conn
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			for (int i = 0; i < BicyclesChanged.size(); i++) {
				if (BicyclesChanged.get(i).getID() != null) {
					row.executeUpdate("UPDATE Rowery SET Model='"
							+ BicyclesChanged.get(i).getModel()
							+ "', Nr_seryjny='"
							+ BicyclesChanged.get(i).getSerialNumber()
							+ "', Przebieg="
							+ BicyclesChanged.get(i).getMileAge()
							+ ", Dostepny="
							+ BicyclesChanged.get(i).getAvailable() + ", Uwagi='"
							+ BicyclesChanged.get(i).getComments() + "' WHERE ID_Roweru="
							+ BicyclesChanged.get(i).getID() + "");
				} else {
					row.executeUpdate("INSERT INTO Rowery (Model,Nr_seryjny,Przebieg,Dostepny,Uwagi) VALUES ('"
							+ BicyclesChanged.get(i).getModel()
							+ "','"
							+ BicyclesChanged.get(i).getSerialNumber()
							+ "',"
							+ BicyclesChanged.get(i).getMileAge()
							+ ","
							+ BicyclesChanged.get(i).getAvailable()
							+ ",'"
							+ BicyclesChanged.get(i).getComments() + "')");
				}
			}
			JOptionPane.showMessageDialog(null,
					"Pomyslnie zrobiono update bazy danych",
					"Operacja zakonczona",
					JOptionPane.INFORMATION_MESSAGE);
			conn.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.toString(), "Blad!",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * Zapisz wypozyczenia.
	 * 
	 * @param rentsChanged
	 *            zmieniona lista wypozyczen
	 * @param dbfile
	 *            nazwa pliku z baza danych
	 */
	public void saveRents(ArrayList<Rent> rentsChanged,
			String dbfile) {
		try {
			initDatabase(dbfile);
			Statement wyp = conn
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			for (int i = 0; i < rentsChanged.size(); i++) {
				if (rentsChanged.get(i).getID() != null) {
					wyp.executeUpdate("UPDATE Wypozyczenia SET Klient='"
							+ rentsChanged.get(i).getClient()
							+ "', Rower='"
							+ rentsChanged.get(i).getBicycle()
							+ "', Data_wyp='"
							+ rentsChanged.get(i).getStartDate()
							+ "', Data_zwr='"
							+ rentsChanged.get(i).getStopDate()
							+ "', Stawka='"
							+ rentsChanged.get(i).getPrice()
							+ "', Wartosc='"
							+ rentsChanged.get(i).getValue()
							+ "', Uwagi='"
							+ rentsChanged.get(i).getComments()
							+ "' WHERE ID_Wypozyczenia="
							+ rentsChanged.get(i).getID() + "");
				} else {
					wyp.executeUpdate("INSERT INTO Wypozyczenia (Klient,Rower,Data_wyp,Data_zwr,Stawka,Wartosc,Uwagi) VALUES ('"
							+ rentsChanged.get(i).getClient()
							+ "','"
							+ rentsChanged.get(i).getBicycle()
							+ "','"
							+ rentsChanged.get(i).getStartDate()
							+ "','"
							+ rentsChanged.get(i).getStopDate()
							+ "',"
							+ rentsChanged.get(i).getPrice()
							+ ","
							+ rentsChanged.get(i).getValue()
							+ ",'"
							+ rentsChanged.get(i).getComments() + "')");
				}
			}
			JOptionPane.showMessageDialog(null,
					"Pomyslnie zrobiono update bazy danych",
					"Operacja zakonczona",
					JOptionPane.INFORMATION_MESSAGE);
			conn.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.toString(), "Blad!",
					JOptionPane.ERROR_MESSAGE);
		}

	}
	
	/**
	 * Usun rower.
	 * 
	 * @param bicycle
	 *            rower do usuniecia z bazy
	 * @param db
	 *            nazwa pliku z baza danych
	 */
	public void deleteBicycle(Bicycles bicycle, String db){
		try {
			initDatabase(db);
			Statement row = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			row.execute("DELETE FROM Rowery WHERE ID_Roweru=" + bicycle.getID());
			JOptionPane.showMessageDialog(null,
					"Pomyslnie usunieto rower z bazy danych",
					"Operacja zakonczona",
					JOptionPane.INFORMATION_MESSAGE);
			conn.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.toString(), "Blad!",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	/**
	 * Usun zdarzenie.
	 * 
	 * @param event
	 *            zdarzenie do usuniecia z bazy
	 * @param db
	 *            nazwa pliku z baza danych
	 */
	public void deleteEvents(Zdarzenie event, String db){
		try {
			initDatabase(db);
			Statement row = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			row.execute("DELETE FROM Zdarzenia WHERE ID_Zdarzenia=" + event.getID());
			JOptionPane.showMessageDialog(null,
					"Pomyslnie usunieto zdarzenie z bazy danych",
					"Operacja zakonczona",
					JOptionPane.INFORMATION_MESSAGE);
			conn.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.toString(), "Blad!",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
}

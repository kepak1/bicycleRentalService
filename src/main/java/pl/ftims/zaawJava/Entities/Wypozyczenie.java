/*
 * 
 */
package pl.ftims.zaawJava.Entities;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Currency;
// TODO: Auto-generated Javadoc

/**
 * Klasa reprezentuje wypozyczenie.
 */
public class Wypozyczenie implements Serializable, Comparable<Wypozyczenie>,
		Comparator<Wypozyczenie> {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3233755371929141768L;
	
	/** ID wypozyczenia */
	private Integer ID;
	
	/** ID klienta */
	private Integer klient;
	
	/** ID roweru */
	private Integer rower;
	
	/** data wypozyczenia */
	private String Data_wyp;
	
	/** data zwrotu */
	private String Data_zwr;
	
	/** stawka wypozyczenia */
	private Double stawka;
	
	/** wartosc wypozyczenia */
	private Double wartosc;
	
	/** uwagi */
	private String uwagi;

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Integer getKlient() {
		return klient;
	}

	public void setKlient(Integer klient) {
		this.klient = klient;
	}

	public Integer getRower() {
		return rower;
	}

	public void setRower(Integer rower) {
		this.rower = rower;
	}

	public String getData_wyp() {
		return Data_wyp;
	}

	public void setData_wyp(String data_wyp) {
		Data_wyp = data_wyp;
	}

	public String getData_zwr() {
		return Data_zwr;
	}

	public void setData_zwr(String data_zwr) {
		Data_zwr = data_zwr;
	}

	public Double getStawka() {
		return stawka;
	}

	public void setStawka(Double stawka) {
		this.stawka = stawka;
	}

	public Double getWartosc() {
		return wartosc;
	}

	public void setWartosc(Double wartosc) {
		this.wartosc = wartosc;
	}

	public String getUwagi() {
		return uwagi;
	}

	public void setUwagi(String uwagi) {
		this.uwagi = uwagi;
	}
	
	/**
	 * konstruktor bezparametrowy wymagany przy serializacji
	 */
	public Wypozyczenie(){
		
	}
	
	/**
	 * Instantiates a new wypozyczenie.
	 *
	 * @param iD ID wypozyczenia
	 * @param klient ID klienta
	 * @param rower ID roweru
	 * @param data_wyp data wypozyczenia
	 * @param data_zwr data zwrotu
	 * @param stawka stawka
	 * @param wartosc wartosc
	 * @param uwagi uwagi
	 */
	public Wypozyczenie(Integer iD, Integer klient, Integer rower,
			String data_wyp, String data_zwr, Double stawka, Double wartosc,
			String uwagi) {
		this.ID = iD;
		this.klient = klient;
		this.rower = rower;
		this.Data_wyp = data_wyp;
		this.Data_zwr = data_zwr;
		this.stawka = stawka;
		this.wartosc = wartosc;
		this.uwagi = uwagi;
	}

	/**
	 * 
	 * metoda porownojaca obiekty po ID.
	 * 
	 * @param o1
	 *            obiekt do porownania
	 * @param o2
	 *            drugi obiekt do porownania
	 * @return int wynik porownania (-1 - mniejszy,0 - rowny,1 - wiekszy)
	 */
	
	public int compare(Wypozyczenie o1, Wypozyczenie o2) {
		return o1.ID - o2.ID;
	}

	/**
	 *  
	 * metoda porownojaca obiekty po wartosci, nastepnie po ID.
	 *
	 * @param o obiekt do porownania
	 * @return int wynik porownania (-1 - mniejszy,0 - rowny,1 - wiekszy)
	 */
	
	public int compareTo(Wypozyczenie o) {
		int compareWartosc = this.wartosc.compareTo(o.wartosc);
		if (compareWartosc == 0) {
			return this.ID.compareTo(o.ID);
		}
		return compareWartosc;
	}

}

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
public class Rent implements Serializable, Comparable<Rent>,
		Comparator<Rent> {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3233755371929141768L;
	
	/** ID wypozyczenia */
	private Integer ID;
	
	/** ID klienta */
	private Integer client;
	
	/** ID roweru */
	private Integer bicycle;
	
	/** data wypozyczenia */
	private String startDate;
	
	/** data zwrotu */
	private String stopDate;
	
	/** stawka wypozyczenia */
	private Double price;
	
	/** wartosc wypozyczenia */
	private Double value;
	
	/** uwagi */
	private String comments;

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Integer getClient() {
		return client;
	}

	public void setClient(Integer client) {
		this.client = client;
	}

	public Integer getBicycle() {
		return bicycle;
	}

	public void setBicycle(Integer rower) {
		this.bicycle = rower;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate=startDate;
	}

	public String getStopDate() {
		return stopDate;
	}

	public void setStopDate(String stopDate) {
		this.stopDate = stopDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	/**
	 * konstruktor bezparametrowy wymagany przy serializacji
	 */
	public Rent(){
		
	}
	
	/**
	 * Instantiates a new wypozyczenie.
	 *
	 * @param iD ID wypozyczenia
	 * @param client ID klienta
	 * @param bicycle ID roweru
	 * @param startDate data wypozyczenia
	 * @param stopDate data zwrotu
	 * @param price stawka
	 * @param value wartosc
	 * @param comments uwagi
	 */
	public Rent(Integer iD, Integer client, Integer bicycle,
			String startDate, String stopDate, Double price, Double value,
			String comments) {
		this.ID = iD;
		this.client = client;
		this.bicycle = bicycle;
		this.startDate = startDate;
		this.stopDate = stopDate;
		this.price = price;
		this.value = value;
		this.comments = comments;
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
	
	public int compare(Rent o1, Rent o2) {
		return o1.ID - o2.ID;
	}

	/**
	 *  
	 * metoda porownojaca obiekty po wartosci, nastepnie po ID.
	 *
	 * @param o obiekt do porownania
	 * @return int wynik porownania (-1 - mniejszy,0 - rowny,1 - wiekszy)
	 */
	
	public int compareTo(Rent o) {
		int compareWartosc = this.value.compareTo(o.value);
		if (compareWartosc == 0) {
			return this.ID.compareTo(o.ID);
		}
		return compareWartosc;
	}

}

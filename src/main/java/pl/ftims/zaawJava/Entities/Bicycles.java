/*
 * 
 */
package pl.ftims.zaawJava.Entities;

import java.io.Serializable;
import java.util.Comparator;
// TODO: Auto-generated Javadoc

/**
 * Klasa reprezentujaca rower.
 */
public class Bicycles implements Comparable<Bicycles>, Serializable,Comparator<Bicycles>{


	/** The pole serializacji */
	private static final long serialVersionUID = 1124745485575895010L;
	
	/** ID roweru */
	private Integer ID;
	
	/** Model roweru */
	private String model;
	
	/** Numer seryjny/inwentazowy roweru */
	private String serialNumber;
	
	/** przebieg */
	private Integer mileAge;
	
	/** czy jest dostepny */
	private Boolean available;
	
	/**  uwagi do roweru. */
	private String comments;

	public Integer getID() {
		return ID;
	}
	
	public void setID(Integer iD) {
		ID = iD;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getSerialNumber() {
		return serialNumber;
	}
	
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	public Integer getMileAge() {
		return mileAge;
	}
	
	public void setMileAge(Integer mileAge) {
		this.mileAge = mileAge;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean dostepny) {
		available = dostepny;
	}
	
	public String getComments() {
		return comments;
	}
	
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	/**
	 * konstruktor bezparametrowy - wymagany przy serializacji
	 */
	public Bicycles(){
		
	}
	
	/**
	 * Zwraca wartosc liczbowa 0 jezeli rower jest niedostepny, 1 jezeli dostepny
	 *
	 * @return the dostepny index
	 */
	public Integer getAvailableIndex() {
		if(available){
			return 0;
		}
		return 1;
	}
	
	/**
	 * Instantiates a new rower.
	 *
	 * @param iD the i d
	 * @param model the model
	 * @param nr_seryjny the nr_seryjny
	 * @param przebieg the przebieg
	 * @param dostepny the dostepny
	 * @param uwagi the uwagi
	 */
	public Bicycles(Integer iD, String model, String nr_seryjny, Integer przebieg,
			Boolean dostepny, String uwagi) {
		
		this.ID = iD;
		this.model = model;
		this.serialNumber = nr_seryjny;
		this.mileAge = przebieg;
		this.available = dostepny;
		this.comments = uwagi;
	}
	
	/**
	 *  
	 * metoda porownojaca obiekty po ID.
	 *
	 * @param o1 obiekt do porownania
	 * @param o2 drugi obiekt do porownania
	 * @return int wynik porownania (-1 - mniejszy,0 - rowny,1 - wiekszy)
	 */
	public int compare(Bicycles o1, Bicycles o2) {
		return o1.ID-o2.ID;
	}
	
	/**
	 *  
	 * metoda porownojaca obiekty po numerze seryjnym, nastepnie po ID.
	 *
	 * @param o obiekt do porownania
	 * @return int wynik porownania (-1 - mniejszy,0 - rowny,1 - wiekszy)
	 */
	public int compareTo(Bicycles o) {
		int compareNr_seryjny = this.serialNumber.compareTo(o.serialNumber);
		if(compareNr_seryjny==0){
			return this.ID.compareTo(o.ID);	
		}
		return compareNr_seryjny;
	}
}

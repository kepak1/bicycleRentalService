/*
 * 
 */
package pl.ftims.zaawJava.Entities;

import java.io.Serializable;
import java.util.Comparator;
/**
* Klasa reprezentujaca klientow
*/
public class Client implements Comparable<Client>, Serializable,Comparator<Client>{
	/**
	 * 
	 */
	/** pole do serializacji*/
	private static final long serialVersionUID = -8637169591076388136L;
	/** numer id klienta */
	private Integer ID;
	/** imie klienta */
	private String firstName;
	/** nazwisko klienta */
	private String lastName;
	/** adres klienta */
	private String adress;
	/** numer PESEL klienta */
	private Integer PESEL;
	/** uwagi na temat klienta */
	private String comments;
	
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String nazwisko) {
		this.lastName = nazwisko;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public Integer getPESEL() {
		return PESEL;
	}
	public void setPESEL(Integer pESEL) {
		PESEL = pESEL;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	/** konstruktor bezparametrowy wymagany przy serializacji*/
	public Client(){
		
	}
	
	/**
	 * Instantiates a new klient.
	 *
	 * @param id id klienta
	 * @param im imie
	 * @param naz nazwisko
	 * @param adr adres
	 * @param pesel numer pesel
	 * @param uwagi uwagi nt klienta
	 */
	public Client(Integer id, String im, String naz, String adr, Integer pesel, String uwagi){
		this.ID=id;
		this.firstName=im;
		this.lastName=naz;
		this.adress=adr;
		this.PESEL=pesel;
		this.comments=uwagi;
	}
	/**
	 *  
	 * metoda porownojaca obiekty po numerze PESEL, nastepnie po ID.
	 *
	 * @param o obiekt do porownania
	 * @return int wynik porownania (-1 - mniejszy,0 - rowny,1 - wiekszy)
	 */
	public int compareTo(Client o) {
		int comparePESEL = this.PESEL.compareTo(o.PESEL);
		if(comparePESEL==0){
			return this.ID.compareTo(o.ID);	
		}
		return comparePESEL;
	}
	
	/**
	 *  
	 * metoda porownojaca obiekty po ID.
	 *
	 * @param o1 obiekt do porownania
	 * @param o2 drugi obiekt do porownania
	 * @return int wynik porownania (-1 - mniejszy,0 - rowny,1 - wiekszy)
	 */
	public int compare(Client o1, Client o2) {
		return o1.ID-o2.ID;
	}

}

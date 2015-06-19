/*
 * 
 */
package pl.ftims.zaawJava.Entities;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * Klasa reprezentujaca zdarzenia w wypozyczalni.
 */
public class Zdarzenie implements Serializable,Comparable<Zdarzenie>,Comparator<Zdarzenie>{
	
	/**  pole do serializacji. */
	private static final long serialVersionUID = 123456789L;
	
/**  ID zdarzenia. */
private Integer ID;

/**  Nazwa zdarzenia. */
private String tytul;

/**  Data zdarzenia. */
private String data;

/**  Koszt. */
private Double wartosc;

/**  Uwagi. */
private String opis;


public Integer getID() {
	return ID;
}

public void setID(Integer iD) {
	ID = iD;
}

public String getTytul() {
	return tytul;
}

public void setTytul(String tytul) {
	this.tytul = tytul;
}

public String getData() {
	return data;
}

public void setData(String data) {
	this.data = data;
}

public Double getWartosc() {
	return wartosc;
}

public void setWartosc(Double wartosc) {
	this.wartosc = wartosc;
}

public String getOpis() {
	return opis;
}

public void setOpis(String opis) {
	this.opis = opis;
}

/**
 * Konstruktor bezparametrowy potrzebny do serializacji obiektow klasy.
 */
public Zdarzenie(){
	
}

/**
 * Konstruktor nowego zdarzenia.
 *
 * @param iD kolejny numer zdarzenia
 * @param tytul nazwa zdarzenia
 * @param wartosc koszt (dodatni jezeli uzyskano przychod, ujemny jezeli strata)
 * @param opis uwagi na temat zdarzenia
 */
public Zdarzenie(Integer iD, String tytul, Double wartosc,
		String opis) {
	Date data2 = new Date();
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	this.ID = iD;
	this.tytul = tytul;
	this.data = format.format(data2);
	this.wartosc = wartosc;
	this.opis = opis;
}
/**
 * Konstruktor nowego zdarzenia.
 *
 * @param iD kolejny numer zdarzenia
 * @param tytul nazwa zdarzenia
 * @param data data wystapienia zdarzenia
 * @param wartosc koszt (dodatni jezeli uzyskano przychod, ujemny jezeli strata)
 * @param opis uwagi na temat zdarzenia
 */
public Zdarzenie(Integer iD, String tytul, String data, Double wartosc,
		String opis) {
	this.ID = iD;
	this.tytul = tytul;
	this.data = data;
	this.wartosc = wartosc;
	this.opis = opis;
}

/**
 *  
 * metoda porownojaca obiekty po wartosci, nastepnie po ID.
 *
 * @param o obiekt do porownania
 * @return int wynik porownania (-1 - mniejszy,0 - rowny,1 - wiekszy)
 */
public int compareTo(Zdarzenie o) {
	int compareWartosc = this.wartosc.compareTo(o.wartosc);
	if(compareWartosc==0){
		return this.ID.compareTo(o.ID);	
	}
	return compareWartosc;
}


/**
 *  
 * metoda porownojaca obiekty po ID.
 *
 * @param o1 obiekt do porownania
 * @param o2 drugi obiekt do porownania
 * @return int wynik porownania (-1 - mniejszy,0 - rowny,1 - wiekszy)
 */
public int compare(Zdarzenie o1, Zdarzenie o2) {
	return o1.ID-o2.ID;
}


}

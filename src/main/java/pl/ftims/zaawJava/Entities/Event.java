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
public class Event implements Serializable,Comparable<Event>,Comparator<Event>{
	
	/**  pole do serializacji. */
	private static final long serialVersionUID = 123456789L;
	
/**  ID zdarzenia. */
private Integer ID;

/**  Nazwa zdarzenia. */
private String title;

/**  Data zdarzenia. */
private String date;

/**  Koszt. */
private Double value;

/**  Uwagi. */
private String comment;


public Integer getID() {
	return ID;
}

public void setID(Integer iD) {
	ID = iD;
}

public String getTittle() {
	return title;
}

public void setTittle(String tittlel) {
	this.title = tittlel;
}

public String getDate() {
	return date;
}

public void setData(String date) {
	this.date = date;
}

public Double getValue() {
	return value;
}

public void setValue(Double value) {
	this.value = value;
}

public String getComment() {
	return comment;
}

public void setOpis(String opis) {
	this.comment = opis;
}

/**
 * Konstruktor bezparametrowy potrzebny do serializacji obiektow klasy.
 */
public Event(){
	
}

/**
 * Konstruktor nowego zdarzenia.
 *
 * @param iD kolejny numer zdarzenia
 * @param tittle nazwa zdarzenia
 * @param value koszt (dodatni jezeli uzyskano przychod, ujemny jezeli strata)
 * @param comment uwagi na temat zdarzenia
 */
public Event(Integer iD, String tittle, Double value,
		String comment) {
	Date data2 = new Date();
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	this.ID = iD;
	this.title = tittle;
	this.date = format.format(data2);
	this.value = value;
	this.comment = comment;
}
/**
 * Konstruktor nowego zdarzenia.
 *
 * @param iD kolejny numer zdarzenia
 * @param tittle nazwa zdarzenia
 * @param date data wystapienia zdarzenia
 * @param value koszt (dodatni jezeli uzyskano przychod, ujemny jezeli strata)
 * @param comment uwagi na temat zdarzenia
 */
public Event(Integer iD, String tittle, String date, Double value,
		String comment) {
	this.ID = iD;
	this.title = tittle;
	this.date = date;
	this.value = value;
	this.comment = comment;
}

/**
 *  
 * metoda porownojaca obiekty po wartosci, nastepnie po ID.
 *
 * @param o obiekt do porownania
 * @return int wynik porownania (-1 - mniejszy,0 - rowny,1 - wiekszy)
 */
public int compareTo(Event o) {
	int compareWartosc = this.value.compareTo(o.value);
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
public int compare(Event o1, Event o2) {
	return o1.ID-o2.ID;
}


}

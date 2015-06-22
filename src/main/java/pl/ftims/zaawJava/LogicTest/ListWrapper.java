/*
 * 
 */
package pl.ftims.zaawJava.LogicTest;

import java.util.ArrayList;

import pl.ftims.zaawJava.Entities.*;

// TODO: Auto-generated Javadoc
/**
 * ListWrapper zawiera ArrayListy do przechowywania danych wypozyczalni po wczytaniu ich z bazy danych
 */
public class ListWrapper {
	
	/** lista reprezentujaca klientow */
	private ArrayList<Client> clients;
	
	/** lista reprezentujaca rowery */
	private ArrayList<Bicycles> bicycles;
	
	/** lista reprezentujaca wypozyczenia */
	private ArrayList<Rent> rents;
	
	/** lista reprezentujaca zdarzenia */
	private ArrayList<Zdarzenie> events;
	
	public ArrayList<Client> getKlienci() {
		return clients;
	}

	public void setKlienci(ArrayList<Client> clients) {
		this.clients = clients;
	}

	public ArrayList<Bicycles> getBicycles() {
		return bicycles;
	}

	public void setBicycles(ArrayList<Bicycles> bicycles) {
		this.bicycles = bicycles;
	}

	public ArrayList<Rent> getRents() {
		return rents;
	}

	public void setRents(ArrayList<Rent> rents) {
		this.rents = rents;
	}

	public ArrayList<Zdarzenie> getEvents() {
		return events;
	}

	public void setEvents(ArrayList<Zdarzenie> events) {
		this.events = events;
	}

	/**
	 * Tworzy nowy obiekt wrappera, inicjalizuje puste listy.
	 */
	public ListWrapper() {
		clients = new ArrayList<Client>();
		bicycles = new ArrayList<Bicycles>();
		rents = new ArrayList<Rent>();
		events = new ArrayList<Zdarzenie>();
	}
   
   /**
    * Funkcja generyczna dodajaca element do jednej z list
    *
    * @param <T> typ generyczny (Klient,Rower,Wypozyczenie,Zdarzenie)
    * @param list docelowa lista
    * @param item element do dodania
    */
   public static <T> void addItem(ArrayList<T> list,T item){
	   list.add(item);
   }
   
   /**
    * Usuwa element z list na okreslonej pozycji.
    *
    * @param <T> typ generyczny (Klient,Rower,Wypozyczenie,Zdarzenie)
    * @param list the list
    * @param index the index
    */
   public <T> void removeItem(ArrayList<T> list, int index){
	   list.remove(index);
   }
   
   /**
    * Czysci cala liste.
    *
    * @param <T> typ generyczny (Klient,Rower,Wypozyczenie,Zdarzenie)
    * @param list lista przeznaczona do wyczyszczenia
    */
   public <T> void clearList(ArrayList<T> list){
	   list.clear();
   }
}

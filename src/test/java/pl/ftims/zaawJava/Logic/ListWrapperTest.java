package pl.ftims.zaawJava.Logic;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import pl.ftims.zaawJava.Entities.Bicycles;
import pl.ftims.zaawJava.Entities.Client;
import pl.ftims.zaawJava.Entities.Event;
import pl.ftims.zaawJava.Entities.Rent;

@RunWith(MockitoJUnitRunner.class)
public class ListWrapperTest {
	@Mock
	private ArrayList<Bicycles> bicycles;

	@Mock
	private ArrayList<Event> events;

	@Mock
	private ArrayList<Client> klienci;

	@Mock
	private ArrayList<Rent> rents;
	@InjectMocks
	private ListWrapper listWrapper;

	@Test
	public void testGetKlienci() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testSetKlienci() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testGetBicycles() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testSetBicycles() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testGetRents() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testSetRents() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testGetEvents() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testSetEvents() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testListWrapper() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testAddItem() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testRemoveItem() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testClearList() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

}

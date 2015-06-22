package pl.ftims.zaawJava.DAO;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import pl.ftims.zaawJava.Entities.*;
import pl.ftims.zaawJava.Logic.*;

import org.junit.Test;

public class DatabaseTest {
	private Database dat;
	private String db="copy.mdb";
	Mock<ListWrapper> mock = new Mock<ListWrapper>();


	@Before
	public void init(){
		
		dat=new Database();
	    mock.Setup(m => m.Products).Returns(new Client[] {
	        new Client { Name = "Monitor", Value = 399.99M },
	        new Client { Name = "Myszka", Value = 69.59M }
		
	}
	@Test
	public void shouldNotThrewException() throws Exception {
		dat.initDatabase(db);
	}
	@Test
	public void shouldThrewException() throws Exception {
		dat.initDatabase("aaa");
	}

	@Test
	public void shouldReadClients() throws Exception {
		List <Client> test= new ArrayList<Client>();
		test=dat.readClients(db);
		assertNotEquals(0,test.size());
		

	}

	@Test
	public void shouldReadBicycles() throws Exception {
		List <Bicycles> test= new ArrayList<Bicycles>();
		test=dat.readBicycles(db);
		assertNotEquals(0,test.size());	
		}

	@Test
	public void shouldReadRents() throws Exception {
		List <Rent> test= new ArrayList<Rent>();
		test=dat.readRents(db);
		assertNotEquals(0,test.size());		}


	@Test
	public void shouldSaveEvents() throws Exception {
		dat.s
		
	}

	@Test
	public void testSaveClients() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testSaveBicycles() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testSaveRents() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testDeleteBicycle() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testDeleteEvents() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

}

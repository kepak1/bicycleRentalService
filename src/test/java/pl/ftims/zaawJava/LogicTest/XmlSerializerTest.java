package pl.ftims.zaawJava.LogicTest;



import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pl.ftims.zaawJava.Entities.Bicycles;


public class XmlSerializerTest {
	private XmlSerializer sut;
	private pl.ftims.zaawJava.Entities.Bicycles row;
	
	@Before
	public void init(){
		sut=new XmlSerializer();
		row=new Bicycles(1,"aaa","bbb",2,true,"ccc");
	}

	@Test
	public void shouldSerializeToXML() throws Exception {
		sut.serializeToXML("aaa.xml", row);
	}

	@Test
	public void testDeserializeFromXML() throws Exception {
		Bicycles row2=(Bicycles) sut.deserializeFromXML("aaa.xml");
		
		assertEquals(row.getID(),row2.getID());
	}

}

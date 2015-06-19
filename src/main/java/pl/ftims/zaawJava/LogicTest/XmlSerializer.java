/*
 * 
 */
package pl.ftims.zaawJava.LogicTest;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
// TODO: Auto-generated Javadoc

/**
 * XmlSerializer jest odpowiedzialny za oblsuge serializacji i deserializacji obiektow
 */
public class XmlSerializer {

	/**
	 * Metoda serializujaca obiekt do pliku XML.
	 *
	 * @param xmlFileLocation lokalizacja pliku wynikowego
	 * @param objectToSerialize obiekt przeznaczony do serializacji
	 * @throws Exception wyjatek rzucany przez serializator
	 */
	public void serializeToXML(String xmlFileLocation,
            Object objectToSerialize) throws Exception {
        FileOutputStream os = new FileOutputStream(xmlFileLocation);
        XMLEncoder encoder = new XMLEncoder(os);
        encoder.writeObject(objectToSerialize);
        encoder.close();
    }
	
	/**
	 * Metoda deserializujaca obiekt z pliku XML.
	 *
	 * @param xmlFileLocation lokalizacja pliku do wczytania
	 * @return object zwracany obiekt 
	 * @throws Exception wyjatek rzucany przez serializator
	 */
	public Object deserializeFromXML(String xmlFileLocation)
            throws Exception {
        FileInputStream os = new FileInputStream(xmlFileLocation);
        XMLDecoder decoder = new XMLDecoder(os);
        Object deSerializedObject = decoder.readObject();
        decoder.close();
 
        return deSerializedObject;
    }
}

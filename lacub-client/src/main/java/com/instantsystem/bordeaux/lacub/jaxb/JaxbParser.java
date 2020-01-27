package com.instantsystem.bordeaux.lacub.jaxb;

import com.instantsystem.bordeaux.lacub.model.ObjectFactory;
import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JaxbParser {

  public static Object parseXmlString(String xmlString) throws XMLStreamException, JAXBException {
    XMLStreamReader xsr = XMLInputFactory.newFactory().createXMLStreamReader(new StringReader(xmlString));
    XMLReaderWithoutNamespace xr = new XMLReaderWithoutNamespace(xsr);
    JAXBContext jc = JAXBContext.newInstance(ObjectFactory.class);
    return jc.createUnmarshaller().unmarshal(xr);
  }
}

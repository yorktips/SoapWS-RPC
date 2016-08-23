package com.york.soap.client;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.york.ws.HelloWorld;
import com.york.ws.PersonService;
import com.york.jaxws.beans.*;

public class SoapClient {
	   public static void main(String[] args) throws Exception {

		   URL url = new URL("http://localhost:9999/ws/hello?wsdl");
		   URL url2 = new URL("http://localhost:9999/ws/person?wsdl");
		   
		   
			//1st argument service URI, refer to wsdl document above
			//2nd argument is service name, refer to wsdl document above
			QName qname = new QName("http://ws.york.com/", "HelloWorldImplService");
			QName qname2 = new QName("http://service.jaxws.york.com/", "PersonServiceImplService");
			
			Service service = Service.create(url, qname);
			Service service2 = Service.create(url2, qname2);
			
			HelloWorld hello = service.getPort(HelloWorld.class);
			PersonService ps = service2.getPort(PersonService.class);
			
			System.out.println(hello.getHelloWorldAsString("York Chen"));

			Person person = new Person();
			person.setName("york1");
			person.setAge(111);
			person.setId(1);
			//ps.addPerson(person);

			Person person2 = new Person();
			person2.setName("york2");
			person2.setAge(112);
			person2.setId(2);
			//ps.addPerson(person2);

			
			Person[] persons=ps.getAllPersons();
			for (Person pp:persons) {
				System.out.println(pp.getName());
			}
/*		   
		   SOAPMessage message = MessageFactory.newInstance().createMessage();
	        SOAPHeader header = message.getSOAPHeader();
	        header.detachNode();
	        SOAPBody body = message.getSOAPBody();
	        QName bodyName = new QName("http://test.omii.ac.uk","showOneClass","ns");
	        SOAPBodyElement bodyElement = body.addBodyElement(bodyName);
	        //-----------
	 
	        SOAPConnection connection = SOAPConnectionFactory.newInstance().createConnection();
	        String endpoint = "http://localhost:8080/HelloBeanService/HelloBean";
	        SOAPMessage response = connection.call(message, endpoint);connection.close();
	        //--------------
	 
	        SOAPBody responseBody = response.getSOAPBody();
	        SOAPBodyElement responseElement = (SOAPBodyElement)responseBody.getChildElements().next();
	        SOAPBodyElement returnElement = (SOAPBodyElement)responseElement.getChildElements().next();
	        System.out.println("Data of getNodeName = " + returnElement.getNodeName()); //result of this is "return"
	        System.out.println("Data of getValue = " + returnElement.getValue()); //result of this is "null"
	        
*/
		   
	    }  
}

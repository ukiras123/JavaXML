package package1.Functions;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLFunctions
{
//XMLValidation
 public String XMLValidationtest(String file, String schema){	 
	 String file1 = file;
	 String schema1 = schema;
	 String outcome = null;
		try {      
		      SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
		      Schema sch= schemaFactory .newSchema(new StreamSource(schema1));
		      Validator validator = sch.newValidator();
		      validator.validate(new StreamSource(file1));		      
		      outcome = "XML is Successfully validated";
		  } catch (Exception e) {
		    outcome = e.getMessage();
		  }
		return outcome; 
	}
 //Get Element Value
 		//Save the URL response to a file
	 public void fileCreation(String url1) throws IOException, ParserConfigurationException, SAXException, TransformerException {
	        URL url = new URL(url1);
	        URLConnection conn = url.openConnection();
	        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder = factory.newDocumentBuilder();
	        Document doc = builder.parse(conn.getInputStream());
	        TransformerFactory tfactory = TransformerFactory.newInstance();
	        Transformer xform = tfactory.newTransformer();
	        //xform.transform(new DOMSource(doc), new StreamResult(System.out));
	        File myOutput = new File("C:\\Users\\Kiran\\Desktop\\XML XSD Validation\\javaOutput.xml");
	        xform.transform(new DOMSource(doc), new StreamResult(myOutput));
	    }
	 
	 	//Read the Response
		 public String elementValue (String xmlPath, String tagName, String elementName) throws IOException, ParserConfigurationException, SAXException, TransformerException{			 
			 //fileCreate.fileCreation(xmlPath);
			 String xmlFilePath = xmlPath;		
			 String tagName1 = tagName;
			 String elementName1 = elementName;
			 String output = "\n";		 
			 try {
					File xmlFile = new File(xmlFilePath);
					DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
					DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
					Document doc = documentBuilder.parse(xmlFile);
					doc.getDocumentElement().normalize();
					NodeList nodeList = doc.getElementsByTagName(tagName1);
					for (int itr = 0; itr < nodeList.getLength(); itr++) {
						Node node = nodeList.item(itr);
						if (node.getNodeType() == Node.ELEMENT_NODE) 
						{
							Element eElement = (Element) node;		
							for (int i = 0; i < eElement.getElementsByTagName(elementName1).getLength(); i++)
							{
							String out = eElement.getElementsByTagName(elementName1).item(i).getTextContent();
							output = output + out + "\n";
							}		
						}
					}
				} catch (Exception e) {
					return e.getMessage();
				}			
				return output; 
		 }
		 
//CountXMLElements		 
		 public String XMLCount(String URL, String Element) throws IOException{
		    	String URL1 = URL;
		    	String Element1 = Element;
		    	String outcome = null;
		        try {               
		        	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		        	Document doc = factory.newDocumentBuilder().parse(URL1);                  
		            String element = Element1;             
		            NodeList nodes = doc.getElementsByTagName(element);
		            outcome = "Total nulber of \"" + Element1 + "\" elements is " + nodes.getLength() + " \n"; 
		        } catch (Exception e) {
		           outcome = e.getMessage();
		        }
				return outcome;
		    }
}
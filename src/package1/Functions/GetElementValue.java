package package1.Functions;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class GetElementValue {

	 public static void main(String[] args) {		 
		
	}
	 
	 public String elementValue (String xmlPath, String tagName, String elementName){
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

				//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

				NodeList nodeList = doc.getElementsByTagName(tagName1);

				for (int itr = 0; itr < nodeList.getLength(); itr++) {

					Node node = nodeList.item(itr);

					//System.out.println("\nNode Name :" + node.getNodeName());

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
}
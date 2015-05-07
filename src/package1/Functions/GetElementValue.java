package package1.Functions;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class GetElementValue {

	 public static void main(String[] args) throws IOException {
		 
		String xmlFilePath = "C:\\Users\\Kiran\\Desktop\\XML XSD Validation\\catalogResponse.xml";

		try {
	
			File xmlFile = new File(xmlFilePath);

			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

			Document doc = documentBuilder.parse(xmlFile);

			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			NodeList nodeList = doc.getElementsByTagName("catalog");

			for (int itr = 0; itr < nodeList.getLength(); itr++) {

				Node node = nodeList.item(itr);

				System.out.println("\nNode Name :" + node.getNodeName());

				if (node.getNodeType() == Node.ELEMENT_NODE) 
				{
					Element eElement = (Element) node;
					NodeList nodeList2 = doc.getElementsByTagName("priceGroups");									
					System.out.println(eElement.getElementsByTagName("priceGroups").item(0).getTextContent());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
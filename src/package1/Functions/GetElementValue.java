package package1.Functions;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class GetElementValue {

   public static void main(String argv[]) {

    }
   
    public void getEmelent(String URL, String element){

    	String URL1 = URL;
    	String output = null;
    	String output1 = null;
    try {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    Document doc = factory.newDocumentBuilder().parse(URL1); 
     doc.getDocumentElement().normalize();      
     NodeList nList = doc.getElementsByTagName(element);     
     for (int temp = 0; temp < nList.getLength(); temp++) {
     Node nNode = nList.item(temp);
          if (nNode.getNodeType() == Node.ELEMENT_NODE) {
     Element eElement = (Element) nNode; 
     output = eElement.getElementsByTagName(element).item(0).getTextContent();
     output1 = output1  + output;
        }
     }
    } catch (Exception e) {
    	System.out.println(e);
     //return e.getMessage();
    }
	System.out.println(output1); 
}
}
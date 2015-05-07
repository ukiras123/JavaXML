package package1.Functions;
 
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

 
public class CountXMLElements {
 
    public static void main(String[] args) throws IOException {
        
    }
    
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
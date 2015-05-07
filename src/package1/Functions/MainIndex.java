package package1.Functions;
import java.io.IOException;

public class MainIndex 
{

	public static void main(String[] args) 
	{		
		//For Counting the number of elements in the response
		String URL = "http://csapi-catalog-qa.cloudhub.io/snapshot/catalogs?filter=status:in(V)";
		String element = "catalog";
		//Schema Validation
		String Schema = "C:\\Users\\Kiran\\Desktop\\XML XSD Validation\\catalogSchema.xsd";
		String File = "C:\\Users\\Kiran\\Desktop\\XML XSD Validation\\catalogResponse.xml";		
		CountXMLElements count = new CountXMLElements();
		XMLValidation xml = new XMLValidation();		
		try {
			count.XMLCount(URL ,element);
			xml.XMLValidationtest(Schema,File);
		} catch (IOException e) {
						e.printStackTrace();
		}		
	}

}

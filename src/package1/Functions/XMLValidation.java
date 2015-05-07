package package1.Functions;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

public class XMLValidation
{
	
 public static void main(String[] args)
 {
	
 } 
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
}
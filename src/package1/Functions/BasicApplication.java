package package1.Functions;

import java.awt.EventQueue;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
//THis is from Home
public class BasicApplication {

	private JFrame frame;
	private final Action action = new SwingAction();
	private JTextField textURL;
	private JTextField textElement;
	private JLabel lblUrl;
	private JLabel lblElement;
	XMLFunctions drive = new XMLFunctions();
	resetSnapshotDB runSQL = new resetSnapshotDB();
	
	private JButton btnSubmit2;
	TextArea textOutput;
	private JTextField textElement1;
	private JTextField textPass;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					BasicApplication window = new BasicApplication();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BasicApplication() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 652, 417);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnSubmit1 = new JButton("eCount / Magic");
		btnSubmit1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {        //******************** Element Count
				String input1, input2, outcome;
				//xml.XMLValidationtest(Schema,File);
				try{
					String filePath = textURL.getText();
					String tagName = textElement.getText();
					String element = textElement1.getText();
					String passw = textPass.getText();
					String shortString;
					if(filePath.equals("") && tagName.equals("") && element.equals("") && passw.equals(""))					
					{
						textOutput.setText("Keep \n Calm \n And \n Insert \n Some \n Data\n ");
					}
					else if(filePath.equals("") && tagName.equals("") && element.equals("") && passw.equals("do the magic"))
					{
						runSQL.JDBCConnection();
						textOutput.setText("Snapshot DB refreshed");
					}
					else if(filePath.equals("") && tagName.equals("") && !element.equals("") && passw.equals(""))
					{
						String output = runSQL.sqlQuery(element);
						textOutput.setText(output);
					}
					else if(filePath.equals("") && tagName.equals("") && element.equals("") && !passw.equals("do the magic"))
					{
						textOutput.setText("Warning! Wrong Password");
					}
					else if (!filePath.equals(""))
					{
					shortString = filePath.substring(0, 4);	
					if(shortString.equals("http"))
					{
						drive.fileCreation(filePath);
						String filePath1 = "C:\\Users\\Kiran\\Desktop\\XML XSD Validation\\javaOutput.xml";
						filePath = filePath1;
						input2 = textElement.getText();						
						outcome = drive.XMLCount(filePath ,input2)	;			
						textOutput.setText(outcome); 
					}	
					else
					{
				input1 = textURL.getText();
				input2 = textElement.getText();
				outcome = drive.XMLCount(input1 ,input2);
				textOutput.setText(outcome); 
				}
				}
				}
				catch(Exception e){
				e.printStackTrace();
				}
				
			}
		});
		btnSubmit1.setBounds(126, 190, 147, 23);
		frame.getContentPane().add(btnSubmit1);
		
		textURL = new JTextField();
		textURL.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//String URL = textURL.getText();                     ///////////////////
			}
		});
		textURL.setBounds(126, 36, 419, 28);
		frame.getContentPane().add(textURL);
		textURL.setColumns(10);
		
		textElement = new JTextField();
		textElement.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//String element = textElement.getText();               ////////////////
			}
		});
		textElement.setBounds(126, 76, 419, 28);
		frame.getContentPane().add(textElement);
		textElement.setColumns(10);
		
		 lblUrl = new JLabel("URL / XMLFile");
		lblUrl.setBounds(10, 29, 106, 42);
		frame.getContentPane().add(lblUrl);
		
		lblElement = new JLabel("Element / SchemaFile");
		lblElement.setBounds(10, 76, 106, 42);
		frame.getContentPane().add(lblElement);
		
		btnSubmit2 = new JButton("XSD Validation");
		btnSubmit2.addActionListener(new ActionListener() {                //******************* Schema Validation
			@Override
			public void actionPerformed(ActionEvent e) {				
				String filePath = textURL.getText();
				String schema, outcome;
				try{			
					String tagName = textElement.getText();
					String element = textElement1.getText();
					String shortString;
					if(filePath.equals("") && tagName.equals("") && element.equals(""))					
					{
						textOutput.setText("Keep \n Calm \n And \n Insert \n Some \n Data\n ");
					}
					else if (!filePath.equals(""))
					{
					shortString = filePath.substring(0, 4);	
					if(shortString.equals("http"))
					{
						drive.fileCreation(filePath);
						String filePath1 = "C:\\Users\\Kiran\\Desktop\\XML XSD Validation\\javaOutput.xml";
						filePath = filePath1;
						schema = "C:\\Users\\Kiran\\Desktop\\XML XSD Validation\\" + textElement.getText() + ".xsd";
						outcome = drive.XMLValidationtest(filePath,schema);				
						textOutput.setText(outcome); 
					}					
					else
					{
				filePath = "C:\\Users\\Kiran\\Desktop\\XML XSD Validation\\" + textURL.getText() + ".xml";
				schema = "C:\\Users\\Kiran\\Desktop\\XML XSD Validation\\" + textElement.getText() + ".xsd";
				outcome = drive.XMLValidationtest(filePath,schema);				
				textOutput.setText(outcome); 				
				}
					}}
				catch(Exception e1){
				e1.printStackTrace();
				}				
			}
			
		});
		btnSubmit2.setBounds(416, 190, 129, 23);
		frame.getContentPane().add(btnSubmit2);
		
		textOutput = new TextArea();
		textOutput.setBounds(126, 238, 419, 130);
		frame.getContentPane().add(textOutput);
		
		JButton btnGetElement = new JButton("Element Value");
		btnGetElement.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {						//************************** Get the element value
				String filePath, tagName, element, outcome;
				try{
				filePath = textURL.getText();				
				tagName = textElement.getText();
				element = textElement1.getText();
				String shortString = null;
				if (!filePath.equals(""))
				{
				shortString = filePath.substring(0, 4);				
				}
				if (filePath.equals("") && tagName.equals("") && element.equals(""))
				{
					textOutput.setText("Keep \n Calm \n And \n Insert \n Some \n Data\n ");
				}
				else if(shortString.equals("http") && tagName != null && element != null)
				{
					drive.fileCreation(filePath);
				String filePath1 = "C:\\Users\\Kiran\\Desktop\\XML XSD Validation\\javaOutput.xml";
				outcome = drive.elementValue(filePath1, tagName, element);
				textOutput.setText(outcome); 
				}
				else if (shortString.equals("http") && tagName == null && element == null)
				{
					drive.fileCreation(filePath);
				outcome = "Response file has been created. \n C:\\Users\\Kiran\\Desktop\\XML XSD Validation\\javaOutput.xml";
				textOutput.setText(outcome);
				}
				else if (!shortString.equals("http") && tagName != null && element != null)
				{
					filePath = "C:\\Users\\Kiran\\Desktop\\XML XSD Validation\\" + textURL.getText() + ".xml";
					outcome = drive.elementValue(filePath, tagName, element);				
					textOutput.setText(outcome); 
					
				}				
								
				}
				catch(Exception e1){
				outcome = e1.getMessage();
				textOutput.setText(outcome);
				}			
				
				
				
			}
		});
		btnGetElement.setBounds(283, 190, 123, 23);
		frame.getContentPane().add(btnGetElement);
		
		textElement1 = new JTextField();
		textElement1.setColumns(10);
		textElement1.setBounds(126, 112, 419, 28);
		frame.getContentPane().add(textElement1);
		
		JLabel lblElementYouWant = new JLabel("Element you want");
		lblElementYouWant.setBounds(10, 116, 106, 21);
		frame.getContentPane().add(lblElementYouWant);
		
		textPass = new JPasswordField();
		textPass.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {             //pass
			}
		});
		textPass.setColumns(10);
		textPass.setBounds(126, 151, 419, 28);
		frame.getContentPane().add(textPass);
		
		JLabel lblMagicCode = new JLabel("Magic Code");
		lblMagicCode.setBounds(10, 148, 106, 42);
		frame.getContentPane().add(lblMagicCode);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		@Override
		public void actionPerformed(ActionEvent e) {
		}
	}
}

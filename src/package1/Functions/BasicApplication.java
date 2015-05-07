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
import javax.swing.JTextField;

public class BasicApplication {

	private JFrame frame;
	private final Action action = new SwingAction();
	private JTextField textURL;
	private JTextField textElement;
	private JLabel lblUrl;
	private JLabel lblElement;
	CountXMLElements count = new CountXMLElements();
	XMLValidation xml = new XMLValidation();
	GetElementValue getValue = new GetElementValue();
	private JButton btnSubmit2;
	TextArea textOutput;
	private JTextField textElement1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
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
		
		JButton btnSubmit1 = new JButton("Element Count");
		btnSubmit1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {        //******************** Element Count
				String input1;
				String input2;
				String outcome;
				//xml.XMLValidationtest(Schema,File);
				try{
				input1 = textURL.getText();
				input2 = textElement.getText();
				outcome = count.XMLCount(input1 ,input2);
				textOutput.setText(outcome); 
				}
				catch(Exception e){
				e.printStackTrace();
				}
				
			}
		});
		btnSubmit1.setBounds(126, 148, 147, 23);
		frame.getContentPane().add(btnSubmit1);
		
		textURL = new JTextField();
		textURL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String URL = textURL.getText();                     ///////////////////
			}
		});
		textURL.setBounds(126, 36, 419, 28);
		frame.getContentPane().add(textURL);
		textURL.setColumns(10);
		
		textElement = new JTextField();
		textElement.addActionListener(new ActionListener() {
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
			public void actionPerformed(ActionEvent e) {				
				String input1;
				String input2;
				String outcome;
				try{				
				input1 = "C:\\Users\\Kiran\\Desktop\\XML XSD Validation\\" + textURL.getText() + ".xml";
				input2 = "C:\\Users\\Kiran\\Desktop\\XML XSD Validation\\" + textElement.getText() + ".xsd";
				outcome = xml.XMLValidationtest(input1,input2);				
				textOutput.setText(outcome); 				
				}
				catch(Exception e1){
				e1.printStackTrace();
				}				
			}
			
		});
		btnSubmit2.setBounds(416, 148, 129, 23);
		frame.getContentPane().add(btnSubmit2);
		
		textOutput = new TextArea();
		textOutput.setBounds(126, 203, 419, 165);
		frame.getContentPane().add(textOutput);
		
		JButton btnGetElement = new JButton("Element Value");
		btnGetElement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {						//************************** Get the element value
				String filePath;
				String tagName;
				String element;
				String outcome;
				try{				
				filePath = "C:\\Users\\Kiran\\Desktop\\XML XSD Validation\\" + textURL.getText() + ".xml";
				tagName = textElement.getText();
				element = textElement1.getText();
				outcome = getValue.elementValue(filePath, tagName, element);				
				textOutput.setText(outcome); 				
				}
				catch(Exception e1){
				e1.printStackTrace();
				}			
				
				
				
			}
		});
		btnGetElement.setBounds(283, 148, 123, 23);
		frame.getContentPane().add(btnGetElement);
		
		textElement1 = new JTextField();
		textElement1.setColumns(10);
		textElement1.setBounds(126, 112, 419, 28);
		frame.getContentPane().add(textElement1);
		
		JLabel lblElementYouWant = new JLabel("Element you want");
		lblElementYouWant.setBounds(10, 116, 106, 21);
		frame.getContentPane().add(lblElementYouWant);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Text;
 
public class FeedbackFrame extends JFrame implements ActionListener{
		
	JLabel labelName=new JLabel("Student name:"); 
	JTextField textName=new JTextField(13);
	JComboBox course1=new JComboBox(new String[]{"XML","Database","ASP.net","Software","ICT English"});
	JComboBox course2=new JComboBox(new String[]{"XML","Database","ASP.net","Software","ICT English"});
	JComboBox course3=new JComboBox(new String[]{"XML","Database","ASP.net","Software","ICT English"});
	JComboBox course4=new JComboBox(new String[]{"XML","Database","ASP.net","Software","ICT English"});
	JComboBox course5=new JComboBox(new String[]{"XML","Database","ASP.net","Software","ICT English"});
	JComboBox grade1=new JComboBox(new String[]{"1","2","3","4","5"});
	JComboBox grade2=new JComboBox(new String[]{"1","2","3","4","5"});
	JComboBox grade3=new JComboBox(new String[]{"1","2","3","4","5"});
	JComboBox grade4=new JComboBox(new String[]{"1","2","3","4","5"});
	JComboBox grade5=new JComboBox(new String[]{"1","2","3","4","5"});
	JButton buttonObj1=new JButton("Submit");
	JButton buttonObj2=new JButton("Exit");
	
 public void init() {
	 	 		
		this.setVisible(true);
		this.setSize(600, 400);
		this.setLocation(200, 200);
				
		JPanel panelObj=new JPanel();
	    panelObj.setBackground(Color.white);  
	    panelObj.setPreferredSize(new Dimension(300, 300));  
        this.getContentPane().add(panelObj, BorderLayout.CENTER);
	    //getContentPane().add(panelObj);
		
		panelObj.add(labelName);
		panelObj.add(textName);
		panelObj.add(course1);
		panelObj.add(course2);
		panelObj.add(course3);
		panelObj.add(course4);
		panelObj.add(course5);
		panelObj.add(grade1);
		panelObj.add(grade2);
		panelObj.add(grade3);
		panelObj.add(grade4);
		panelObj.add(grade5);
		panelObj.add(buttonObj1);
		panelObj.add(buttonObj2);
		
		buttonObj1.addActionListener(this);
		buttonObj2.addActionListener(this);
				
		GridBagLayout gbLayoutObj;
		GridBagConstraints gbcObj;
		
		gbLayoutObj=new GridBagLayout();
		gbcObj=new GridBagConstraints();
		panelObj.setLayout(gbLayoutObj);
		
		gbcObj.anchor=GridBagConstraints.EAST;
		gbcObj.gridx=1;
		gbcObj.gridy=1;
		gbLayoutObj.setConstraints(labelName, gbcObj);
		gbcObj.gridy=2;
		gbLayoutObj.setConstraints(course1, gbcObj);
		gbcObj.gridy=3;
		gbLayoutObj.setConstraints(course2, gbcObj);
		gbcObj.gridy=4;
		gbLayoutObj.setConstraints(course3, gbcObj);
		gbcObj.gridy=5;
		gbLayoutObj.setConstraints(course4, gbcObj);
		gbcObj.gridy=6;
		gbLayoutObj.setConstraints(course5, gbcObj);
		gbcObj.gridy=7;
		gbLayoutObj.setConstraints(buttonObj1, gbcObj);
		
		gbcObj.anchor=GridBagConstraints.WEST;
		gbcObj.gridx=2;
		gbcObj.gridy=1;
		gbLayoutObj.setConstraints(textName, gbcObj);
		gbcObj.gridy=2;
		gbLayoutObj.setConstraints(grade1, gbcObj);
		gbcObj.gridy=3;
		gbLayoutObj.setConstraints(grade2, gbcObj);
		gbcObj.gridy=4;
		gbLayoutObj.setConstraints(grade3, gbcObj);
		gbcObj.gridy=5;
		gbLayoutObj.setConstraints(grade4, gbcObj);
		gbcObj.gridy=6;
		gbLayoutObj.setConstraints(grade5, gbcObj);
			
		gbcObj.anchor=GridBagConstraints.EAST;
		gbcObj.gridy=7;
		gbLayoutObj.setConstraints(buttonObj2, gbcObj);
	
}

	public static void main(String[] args){
		FeedbackFrame fb=new FeedbackFrame();
		fb.init();		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		
		Object object = e.getSource(); 
		 if (object == buttonObj1) {
			 try { 
				 
			 System.out.println("This is the summary of feedback information of the student ");
			 System.out.println();			 
			 System.out.println("Student name : "+textName.getText());
			 System.out.println();		 
			 
			 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

			 DocumentBuilder documentBuilder;
			 documentBuilder = factory.newDocumentBuilder();
			 Document xmlDoc = documentBuilder.newDocument();
			 			 
			 Comment comment = xmlDoc.createComment("This is the root element");
			 xmlDoc.appendChild(comment);
			 org.w3c.dom.Element root = xmlDoc.createElement("feedback");
			 xmlDoc.appendChild(root);    

			 String[] itemNames = new String[]{(String) course1.getSelectedItem(), (String) course2.getSelectedItem(), (String) course3.getSelectedItem(), (String) course4.getSelectedItem(),(String) course5.getSelectedItem()};
			 String[] gradeScore = new String[]{(String) grade1.getSelectedItem(), (String) grade2.getSelectedItem(), (String) grade3.getSelectedItem(), (String) grade4.getSelectedItem(),(String) grade5.getSelectedItem()};
			 
			 for(int i=0; i<itemNames.length; i++) {
			      // Here we create child element "name"
			      org.w3c.dom.Element itemElement = xmlDoc.createElement("course");
			      root.appendChild(itemElement);
              
			      org.w3c.dom.Element nameElement = xmlDoc.createElement("name");
			      Text nameText = xmlDoc.createTextNode("" +itemNames[i]);
			      nameElement.appendChild(nameText);
			      itemElement.appendChild(nameElement);
			      
			      org.w3c.dom.Element gradeElement = xmlDoc.createElement("grade");
			      Text gradeText = xmlDoc.createTextNode("" + gradeScore[i]);
			      gradeElement.appendChild(gradeText);
			      itemElement.appendChild(gradeElement);
			   		      
			 }
			 
			 TransformerFactory transformerFactory = TransformerFactory.newInstance();		
			 Transformer transformer = transformerFactory.newTransformer();			 
			 DOMSource src = new DOMSource(xmlDoc);

			 //save data to feedback.html
			    File file = new File("feedback.xml"); 

	            if (!file.exists()) {
	                file.createNewFile();
	            }         
			 
	            FileOutputStream out = new FileOutputStream(file);                 
	            StreamResult xmlResult = new StreamResult(out);            	            	         
			    transformer.transform(src, xmlResult);                       	                         	            
			    transformer.setOutputProperty("{/encoding/}","GB2312/");
	            ByteArrayOutputStream boc  = new ByteArrayOutputStream();
	            transformer.transform(new DOMSource(xmlDoc), new StreamResult(boc));
	            
	            
	            //Display summary of feedback information on the console
		        Result output = new StreamResult(System.out);
		        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		        transformer.transform(src, output);			 
		        
		        System.out.println();
		        System.out.println("Hint: when you want to see the data saved on feedback.xml(after you click submit), you double-click on feedback.xml, and wait for 2 or 3second,it can shows out! ");
		        
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage());
			}			 
		 }
		 
		 else if(object == buttonObj2){			 
			 System.exit(0);
		 }
	}

	
}
	
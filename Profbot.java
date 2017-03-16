//Main file for Probot
//Authors: Jonathan D'Alonzo & Stephen Canzanese
//Rowan University Artifical Intelligence Semester Project

package profbot.Profbot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.paint.Color;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;


 /**
  * Main file for Profbot
  * Rowan University Artifical Intelligence Semester Project
  * @author Jonathan D'Alonzo & Stephen Canzanese
  */
public class Profbot extends JFrame {

	//Typing Area:
	private JTextField txtEnter = new JTextField();
	
	//Chat Area:
	private JTextArea txtChat = new JTextArea();
	
	public Profbot() {
		//Frame Attributes:
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 600);
		this.setVisible(true);
		this.setResizable(false);
		this.setLayout(null);
		this.setTitle("Java AI");
                txtEnter.setBackground(java.awt.Color.yellow);
		
		//txtEnter Attributes:
		txtEnter.setLocation(2, 540);
		txtEnter.setSize(590, 30);
		
		//txtEnter Action Event:
		txtEnter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				String uText = txtEnter.getText();
				txtChat.append("You: " + uText + "\n");
				
				/**
                                 * This is the section where we can call a method
                                 * which will take care of the parsing and the
                                 * deciding of what to say.
                                 */
                                parseText(uText);
                                
				txtEnter.setText("");
			}
		});
		
		//txtChat Attributes:
		txtChat.setLocation(15, 5);
		txtChat.setSize(560, 510);
		txtChat.setEditable(false);
		
		//Add Items To Frame:
		this.add(txtEnter);
		this.add(txtChat);
	}
	
	public void botSay(String s){
		txtChat.append("Profbot: " + s + "\n");
	}
	
	public static void main(String[] args){
		new Profbot();
	}
        
        public void parseText(String sentence) {
            String[] words = sentence.split(" ");
            
        }

}

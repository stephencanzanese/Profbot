package profbot.Profbot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.scene.paint.Color;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

 
/**
  * Main file for Profbot
  * Rowan University Artifical Intelligence Semester Project
  * @author Jonathan D'Alonzo & Stephen Canzanese
  */
public class Profbot extends JFrame {
    //Brain
    String[] keywords;
    String[] sixWs;
    String[] professors;
    String[] emails;
    
    //Typing Area:
    private JTextField txtEnter = new JTextField();
    //Chat Area:
    private JTextArea txtChat = new JTextArea();

    public Profbot() {
        //Brain's Attributes:
        professors = new String[]{"myers", "chien", "hnatyshin", "xu",
                                  "schillo","poolos", "coughlin", "baliga",
                                  "breitzman", "chu", "haddad", "ho", "hristescu",
                                  "bergmann", "kay", "lobo", "mansaray", "mckee",
                                  "provine", 
                                  "myers", "robinson", "shahzad", "tinkham", "weissman"
        };     
        emails = new String[]{    "myersjac@rowan.edu", "chien@rowan.edu",
                                  "hnatyshin@rowan.edu", "xu@rowan.edu",
                                  "schillo@rowan.edu","Poolos24@rowan.edu",
                                  "coughlin@rowan.edu","baliga@rowan.edu",
                                  "breitzman@rowan.edu", "chum@rowan.edu",
                                  "haddada@rowan.edu", "hos@rowan.edu",
                                  "hristescu@rowan.edu", "bergmann@rowan.edu",
                                  "kay@rowan.edu", "lobo@rowan.edu",
                                  "mansaray@rowan.edu", "mckeep82@rowan.edu", "kilroy@elvis.rowan.edu", "robinsonj@rowan.edu", "shahzad@rowan.edu", "nlt@elvis.rowan.edu", "weissmans@rowan.edu"
        };
                                  
        sixWs = new String[]{"who", "what", "where", "when", "why", "how"};
        keywords = new String[]{"tutoring", "professor", "help", "acm", "acmw", "internship",
                                "job", "research", "news", "events", "contest", "email", "contact",
                                "difference", "ba", "bs", "minor", "prerequisites", "prereqs",
                                "prereq", "guide", "schedule", "specializations"}; 

        
        
        
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
                        uText = uText.toLowerCase().trim();
                        
                        /**
                         * This is the section where we can call a method
                         * which will take care of the parsing and the
                         * deciding of what to say.
                         */
                        findMatches(uText.split("\\b+"));

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

    public void botSay(String s) {
        txtChat.append("Profbot: " + s + "\n");
    }

    public void findMatches(String[] sentence) {
        //first find keywords 
        //use hashmap<string><int> of keywords to cycle over the sentence
        //and increase the keyword's 
        ArrayList<String> matches = new ArrayList<>();
        for (int i = 0; i < sentence.length; i++) {
            for (String wKeyword : sixWs) {
                if (sentence[i].equals(wKeyword)) {
                    matches.add(wKeyword);
                }
            }
            for (String keyword : keywords) {
                if (sentence[i].equals(keyword)) {
                    matches.add(keyword);
                }
            }
            for (String professor : professors) {
                if (sentence[i].equals(professor)) {
                    matches.add(professor);
                }
            }
        }
        for (String match : matches) {
            System.out.print(match + " ");
        }
        //TO DO LIST:
        //use keywords to narrow down responses
        //collect responses in array for further pruning.
    }
    
    protected String[] tokenize(String sentence) {
        sentence = sentence.trim().toLowerCase();
        String words[] = sentence.split("\\b+"); //split on word boundries
        return words;
    }

    
    public static void main(String[] args){
        new Profbot();
    }
    
}

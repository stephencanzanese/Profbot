package profbot.Profbot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
////TO DO:
//Take a look at first comment in findMatches

 
/**
  * Main file for PBController
 Rowan University Artifical Intelligence Semester Project
  * @author Jonathan D'Alonzo & Stephen Canzanese
  */
public class PBController extends JFrame {
    //Brain
    String[] keywordArray = new String[]{""};
    HashMap<String, String> responsesMap = new HashMap<String, String>();
//    String[] keywords;
//    String[] sixWs;
//    String[] professors;
//    String[] emails;
    
    //Typing Area:
    private JTextField txtEnter = new JTextField();
    //Chat Area:
    private JTextArea txtChat = new JTextArea();

    public PBController() {
        ResponseDirectory rd = new ResponseDirectory();
        keywordArray = rd.loadFileIntoArray("resources/keywords.txt");
        responsesMap = rd.loadFileIntoMap("resources/responses.txt");
        //printArray(keywordArray);
        printMap(responsesMap);
        startChatLoop();
        
        //Brain's Attributes:
//        professors = new String[]{"myers", "chien", "hnatyshin", "xu",
//                                  "schillo","poolos", "coughlin", "baliga",
//                                  "breitzman", "chu", "haddad", "ho", "hristescu",
//                                  "bergmann", "kay", "lobo", "mansaray", "mckee",
//                                  "provine", 
//                                  "myers", "robinson", "shahzad", "tinkham", "weissman"
//        };     
//        emails = new String[]{    "myersjac@rowan.edu", "chien@rowan.edu",
//                                  "hnatyshin@rowan.edu", "xu@rowan.edu",
//                                  "schillo@rowan.edu","Poolos24@rowan.edu",
//                                  "coughlin@rowan.edu","baliga@rowan.edu",
//                                  "breitzman@rowan.edu", "chum@rowan.edu",
//                                  "haddada@rowan.edu", "hos@rowan.edu",
//                                  "hristescu@rowan.edu", "bergmann@rowan.edu",
//                                  "kay@rowan.edu", "lobo@rowan.edu",
//                                  "mansaray@rowan.edu", "mckeep82@rowan.edu", "kilroy@elvis.rowan.edu", "robinsonj@rowan.edu", "shahzad@rowan.edu", "nlt@elvis.rowan.edu", "weissmans@rowan.edu"
//        };
//                                  
//        sixWs = new String[]{"who", "what", "where", "when", "why", "how"};
//        keywords = new String[]{"tutoring", "professor", "help", "acm", "acmw", "internship",
//                                "job", "research", "news", "events", "contest", "email", "contact",
//                                "difference", "ba", "bs", "minor", "prerequisites", "prereqs",
//                                "prereq", "guide", "schedule", "specializations"}; 
    }

    public void botSay(String s) {
        txtChat.append("Profbot: " + s + "\n");
    }
    
    public void startChatLoop() {
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
        botSay("Hello, my name is Probot. How may I help you on this wonderful day?");

        //txtEnter Action Event:
        txtEnter.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent arg0) {
                        String uText = txtEnter.getText().trim();
                        txtEnter.setText("");
                        txtChat.append("You: " + uText + "\n");
                        uText = uText.toLowerCase();
                        /**
                         * This is the section where we can call a method
                         * which will take care of the parsing and the
                         * deciding of what to say.
                         */
                        
                        ////////////////////////////////////////////
                        String[] sentenceMatches = findMatches(uText.toLowerCase().split("\\b+"));
                        String line = "";
                        for (int l = 0; l < sentenceMatches.length; l++) {
                            //if find matches didn't send back a null value
                            if (sentenceMatches[l] != null)
                                //add each line into one string
                                line += sentenceMatches[l] + " "; 
                        }
                        /////Test Print
                        System.out.println("\nLine is: " + line);
                        boolean searching = true;
                        for (String key : responsesMap.keySet()) {
                            //The literal string was a test. I could not sort
                            //the sentenceMatches in the time I had, but I still
                            //wanted to see if it worked.
                            if (key.equals(line)) {
                                //retrieve and say the response that correlates
                                //to the specific key (or matching keywords)
                                botSay(responsesMap.get(key));
                                //searching is done, therefore stop
                                searching = false;
                            }
                        }
                        //if still searching after looking through the
                        //whole list
                        if (searching) {
                            //We can create a database of default answer
                            //and randomly select from them each time.
                            //Or just give them this one because it may
                            //help better.
                            botSay("I apologize, but I do not understand. "
                                    + "Please ask the question again"
                                    + "in a different way, ask me a new question"
                                    + "or say 'help'. ");
                        }
                        //////////////////////////////////////////////////
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

    public String[] findMatches(String[] sentence) {
        //the ten MUST be changed.. will throw index out of bound if
        //101 matches were found!!
        String[] matches = new String[10];
        int arrayIndex = 0;
        
        //cycle through sentence
        for (int i = 0; i < sentence.length; i++) {
            //cycle through keywords
            for (int j = 0; j < keywordArray.length; j++) {
                //if the current sentence word matches any of the keywords
                if (sentence[i].equals(keywordArray[j])) {
                    matches[arrayIndex] = keywordArray[j];
                    arrayIndex++;
                }
            }
        }
        return matches;
    }
    
    //used this to test the reader and make sure it was working properly
    public void printMap(HashMap<String, String> map) {
        for(String key : map.keySet()) {
            System.out.println(key + "--" + map.get(key));

        }
        System.out.println();
    }
    
    public void printArray(String[] a) {
        for (String aValue : a) {
            System.out.print(aValue + " ");
        }
    }
    
    public String[] sortArray(String[] array)
    {
        for (int i = 0; i < array.length - 1; ++i) {
          int minIndex = i;
          for (int j = i + 1; j < array.length; ++j) {
            // "<" changed to use of compareTo()
            if (array[j].compareTo(array[minIndex]) < 0) {
              minIndex = j;
            }
          }
          // int changed to String
          String temp = array[i];
          array[i] = array[minIndex];
          array[minIndex] = temp;
        }
        return array;
    }

    public static void main(String[] args){
        new PBController();
    }
    
}

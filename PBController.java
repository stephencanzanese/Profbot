package profbot.Profbot;
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
    
    public PBController() {
        ResponseDirectory rd = new ResponseDirectory();
        keywordArray = rd.loadFileIntoArray("resources/keywords.txt");
        responsesMap = rd.loadFileIntoMap("resources/responses.txt");
        printMap(responsesMap);
        
    }
    
    /**
     * The result is a negative integer if this String object lexicographically 
     * precedes the argument string. The result is a positive integer if this 
     * String object lexicographically follows the argument string. The result 
     * is zero if the strings are equal;
     * @param arr
     * @return 
     */
    public static String[] sortArray(String[] arr){
         
        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] != null) {
                    if (arr[j].compareToIgnoreCase(arr[index]) < 0) {
                        index = j;
                    }
                }
            String smallerNumber = arr[index]; 
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
        return arr;
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
    
    public String[] getKeywordArray() {
        return keywordArray;
    }
    
    public HashMap<String, String> getResponsesMap() {
        return responsesMap;
    }
    
}

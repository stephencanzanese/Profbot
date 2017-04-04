package profbot.Profbot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ResponseDirectory {

	//private HashMap<String, String> keyRespPairs;
        //private HashMap<String, String> keywords;
        
        public HashMap<String, String> loadFileIntoMap(String file) {
            BufferedReader bread = null;
            FileReader fread = null;
            HashMap<String, String> map = new HashMap<String, String>();
            
            try {
                String sCurrentLine;
                bread = new BufferedReader(new FileReader(file));
                while ((sCurrentLine = bread.readLine()) != null) {
                    String[] parts = sCurrentLine.split(":");//splits the line at :
                    String key = parts[0];
                    String resp = parts[1];				

                    map.put(key, resp);//adds the key/repsonse pair to the map

                    //System.out.println(response);
                    //System.out.println(keyPairing);
                }
                return map;
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
            try {
                if (bread != null) {
                    bread.close();
                }
                if (fread != null) {
                    fread.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
	}
            return null;
        }
        
        public String[] loadFileIntoArray(String file) {
            BufferedReader bread = null;
            ArrayList<String> array = new ArrayList<String>();
            
            try {
                String keywordString = "";
                String currentLine = "";
                bread = new BufferedReader(new FileReader(file));
                //read in each line and concat onto one string
                while ((currentLine = bread.readLine()) != null) {
                    if (!currentLine.contains("//")) {
                        keywordString += currentLine;
                    }
                }
                //return the concatenated string after being splited by each comma
                //separating each word into their own index.
                return keywordString.split(", ");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
            try {
                if (bread != null) {
                    bread.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
	}
            return null;
        }

	//Method to find the response that matches the given keyword set and returns it.
	//returns null if no match found
	public String getResponse(String keywords, HashMap<String, String> map) {
            if(map.containsKey(keywords)) {
                return map.get(keywords);
            } else {
                return null;
            }
	}

}

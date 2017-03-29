import java.util.ArrayList;
public class Directory {
    
    public ArrayList<Office> directory = new ArrayList<Office>; // maybe a map with the name of the office as the key??
    
    public Directory() {
  
        //populate directory with office objects. I haven't decided what would be the best way to do this yet. 
        directory.add(createAdmissions()); //something like this, for each office we make?
    
    }
    
    //example method. Do this for each professor in CS department and the CS department itself?
    
    public Office createAdmissions() {
        Office admissions = new Office();
        adimissions.setName("Admissions Office");
        admissions.setLocation("2nd Floor Savitz");
        admissions.setEmail("admissions@rowan.edu");
        admissions.setPhoneNum("5555555");
        admissions.setHours("9am-5pm");
        
    }
    
    public Office search(String name) {
     
        //a search method here would be really helpful. We can probably just use binary search if we keep the directory sorted.
        
    }
    
    
    }
    

import java.util.ArrayList;
public class Directory {
    
    public ArrayList<Office> directory;
    
    public Directory() {
        directory = new ArrayList<Office>();
        
    }
    
    public static void main(String[] args) {
    
        //populate directory with office objects. I haven't decided what would be the best way to do this yet. 
    
    }
    
    //example method. Do this for each professor in CS department and the CS department itself?
    
    public void createAdmissions() {
        Office admissions = new Office();
        adimissions.setName("Admissions Office");
        admissions.setLocation("2nd Floor Savitz");
        admissions.setEmail("admissions@rowan.edu");
        admissions.setPhoneNum("5555555");
        admissions.setHours("9am-5pm");
        
    }
    
    
    }
    

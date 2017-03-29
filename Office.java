public class Office {
    
    //We can always add more fields if needed
    String name;
    String location;
    String hours;
    String email;
    String phnum;
    
    
    //Gave us two constructor options. We can add info using the constructor or we can use the setter methods
    
    public Office(Sting name, String location, String hours, String email, String phnum) { 
        this.name = name;
        this.location = location;
        this.hours = hours;
        this.email = email;
        this.phnum = phnum;
    
    }
    
    public Office() {
    
    
    }
    
    public String getName() {
    
        return name;
    }
    
    public String getLocation() {
        return location;
    }
     
    public String getHours() {
          return hours;
    }
      
    public String getEmail() {
          return email;
    }
    
    public String getPhoneNum() {
        return phnum;
        
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public void setHours(String hours) {
        this.hours = hours;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setPhonenum (String phnum) {
        this.phnum = phnum;
    }
     

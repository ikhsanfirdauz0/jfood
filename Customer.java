    
    /**
     * this class is holding information about costumer
     *
     * @author Ikhsan Firdauz
     * @version 1.0
     * @since 27 - 2 - 2020
     */
    public class Customer
    {
        
        private int id;
        private String name;
        private String email;
        private String password;
        private String joinDate;
        
        /**
         * Constructor for objects of class Customer
         * @param id is to hold value of object's id
         * @param email is to hold value of object's email
         * @param password is to hold value of object's password
         * @param joinDate is to hold value of object's joinDate 
         */
        public Customer(int id, String email, String password, String joinDate)
        {
            this.id = id;
            this.email = email;
            this.password = password;
            this.joinDate = joinDate;
    }
    
    /**
     * this is the getter of id
     */
    public int getId()
    {
       return id; 
    }
    
    public String getName()
    {
       return name; 
    }
    
    public String getEmail()
    {
       return email; 
    }
    
    public String getPassword()
    {
       return password; 
    }
    
    public String getJoinDate()
    {
       return joinDate; 
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public void setJoinDate(String joinDate)
    {
        this.joinDate = joinDate;
    }
    
    public void printData()
    {
        System.out.println(name);
    }
    
}

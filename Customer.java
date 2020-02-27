    
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
     * this is the getter of customer's id
     * @return id of the costumer
     */
    public int getId()
    {
       return id; 
    }
    
    /**
     * this is the getter of customer's name
     * @return name of the customer
     */
    public String getName()
    {
       return name; 
    }
    
    /**
     * this is the getter of customer's email
     * @return email of the customer
     */
    public String getEmail()
    {
       return email; 
    }
    
    /**
     * this is the getter of customer's password
     * @return password of the customer
     */
    public String getPassword()
    {
       return password; 
    }
    
    /**
     * this is the getter of the customer's join date
     * @return join date of the customer 
     */
    public String getJoinDate()
    {
       return joinDate; 
    }
    
    /**
     * this is the setter of customer's id
     * @param id is the id of the customer
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     * this is the setter of customer's id
     * @param name is the name of the customer
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * this is the setter of customer's email
     * @param email is the email of the customer
     */
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    /**
     * this is the setter of customer's password
     * @param password is the password of the customer
     */
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    /**
     * this is the setter of customer's join date
     * @param joinDate is the join date of the customer
     */
    public void setJoinDate(String joinDate)
    {
        this.joinDate = joinDate;
    }
    
    /**
     * this method is to print any data in this class
     */
    public void printData()
    {
        System.out.println(name);
    }
    
}

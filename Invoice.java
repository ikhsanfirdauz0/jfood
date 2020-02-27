
/**
 * Write a description of class Invoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Invoice
{
    // instance variables - replace the example below with your own
    private int id;
    private int idFood;
    private String date;
    private int totalPrice;
    private Customer customer;
    

    public Invoice(int id, int idFood, String date, Customer customer, int totalPrice)
    {
        this.id = id;
        this.idFood = idFood;
        this.date = date;
        this.customer = customer;
        this.totalPrice = totalPrice;
    }

    public int getId()
    {
        return id;
    }
    
    public int getIdFood()
    {
        return idFood;
    }
    
    public String getDate()
    {
        return date;
    }
    
    public int getTotalPrice()
    {
        return totalPrice;
    }
    
    public void setIdFood(int idFood)
    {
        this.idFood = idFood;
    }
    
    public void setDate(String date)
    {
        this.date = date;
    }
    
    public void setTotalPrice(int totalPrice)
    {
        this.totalPrice = totalPrice;
    }
    
    public void printData()
    {
        
    }
}

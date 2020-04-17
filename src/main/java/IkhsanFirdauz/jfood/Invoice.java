package IkhsanFirdauz.jfood;
import java.util.*;
/**
 * This class contains any information for the transaction invoice for each food
 *
 * @author Ikhsan Firdauz
 * @version 1.0
 * @since 27 - 2 - 2020
 */
public abstract class Invoice
{
    // instance variables - replace the example below with your own
    private int id;
    private ArrayList<Food> foods = new ArrayList<>();
    private Calendar date;
    protected int totalPrice;
    private Customer customer;
   // private PaymentType paymentType;
    private InvoiceStatus invoiceStatus;
    
    /**
     * This is the constructor for objects of Invoice class
     * @param id is to hold the value of invoice's id
     * @param idFood is to hold the value of invoice's food id
     * @param date is to hold the value of invoice's date
     * @param customer is to hold the customer object in the current invoice
     * @param totalPrice is to hold the value of total price of the current invoice
     */
    public Invoice(int id, ArrayList<Food> foods, Customer customer)
    {
        this.id = id;
        this.foods = foods;
       // this.date = date;
        this.customer = customer;
        this.date = new GregorianCalendar();
        this.invoiceStatus = InvoiceStatus.Ongoing;
    }

    /**
     * this is the getter of invoice's id
     * @return id of the invoice
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * this is the getter of invoice's food id
     * @return food id of the invoice
     */
    public ArrayList<Food> getFoods()
    {
        return foods;
    }
    
    /**
     * this is the getter of invoice's date
     * @return date of the invoice
     */
    public Calendar getDate()
    {
        return date;
    }
    
    /**
     * this is the getter of invoice's total price
     * @return total price of the invoice 
     */
    public int getTotalPrice()
    {
        return totalPrice;
    }
    
    public Customer getCustomer()
    {
        return customer;
    }
    
    
    public abstract PaymentType getPaymentType();
    
    public InvoiceStatus getInvoiceStatus()
    {
        return invoiceStatus;
    }

    /**
     * this is the setter of the invoice's date
     * @param date is date of the invoice
     */
    public void setDate(Calendar date)
    {
        this.date = date;
    }
    
    public void setDate(int year, int month, int dayOfMonth)
    {
        this.date = new GregorianCalendar(year, month-1, dayOfMonth);
    }

    public void setFoods(ArrayList<Food> foods)
    {
        this.foods = foods;
    }
    
    /**
     * this is the setter of the invoice's total price
     * @param totalPrice is total price in the invoice 
     */
    public abstract void setTotalPrice();

    public void setInvoiceStatus(InvoiceStatus invoiceStatus)
    {
        this.invoiceStatus = invoiceStatus;
    }
    
    /**
     * this method is to print any data in this class
     */
    public abstract String toString();

    

}

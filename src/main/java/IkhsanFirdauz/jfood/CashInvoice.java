package IkhsanFirdauz.jfood;
import java.util.*;
import java.util.Date;
import java.util.Calendar;  
import java.lang.Object;
import java.text.Format;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/**
 * Write a description of class CashInvoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CashInvoice extends Invoice
{
    // instance variables - replace the example below with your own
    private static final PaymentType PAYMENT_TYPE = PaymentType.Cash;
    private int deliveryFee = 0;

    /**
     * Constructor for objects of class CashInvoice
     */
    public CashInvoice(int id, ArrayList<Food> foods, Customer customer)
    {
        super(id, foods, customer);
    }

    public CashInvoice(int id, ArrayList<Food> foods, Customer customer, int deliveryFee)
    {
        super(id, foods, customer);
        this.deliveryFee = deliveryFee;
    }

    public PaymentType getPaymentType()
    {
        return PAYMENT_TYPE;
    }
    
    public int getDeliveryFee()
    {
        return deliveryFee;
    }
    
    public void setDeliveryFee(int deliveryFee)
    {
        this.deliveryFee = deliveryFee;
    }
    
    public void setTotalPrice()
    {
        super.totalPrice = 0;
        for(Food foodList : super.getFoods())
        {
            super.totalPrice = super.totalPrice + foodList.getPrice();
        }
        if(deliveryFee > 0)
        {
            super.totalPrice = super.totalPrice + deliveryFee;
        }

    }
    
    public String toString()
    {
        //inisiasi total harga
        setTotalPrice();

        //inisiasi waktu sekarang
        String timeNow = "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        timeNow = sdf.format(super.getDate().getTime());

        //String manipulation untuk list makanan yang dibeli
        String foods = "";
        for (Food foodList : getFoods())
        {
            foods = foods + foodList.getName() + ", ";
        }
        foods = foods.substring(0, foods.length() - 2);

        //return value
        return "==========INVOICE==========\n" +
            "ID : " + super.getId() +
            "\nFoods: " + foods +
            "\nDate: " + timeNow +
            "\nCustomer: " + super.getCustomer().getName() +
            "\nTotal Delivery Fee: " + deliveryFee +
            "\nTotal Price: " + super.getTotalPrice() +
            "\nStatus: " + super.getInvoiceStatus() +
            "\nPayment Type: " + PAYMENT_TYPE + "\n";
    }
        
}

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
    public CashInvoice(int id, Food food, Customer customer,
    InvoiceStatus invoiceStatus)
    {
        super(id, food, customer, invoiceStatus);
    }

    public CashInvoice(int id, Food food, Customer customer,
    InvoiceStatus invoiceStatus, int deliveryFee)
    {
        super(id, food, customer, invoiceStatus);
        this.deliveryFee = deliveryFee;
    }
    
    @Override
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
        if(deliveryFee > 0)
        {
            super.totalPrice = getFood().getPrice() + deliveryFee;
        }            
        else 
        {
            super.totalPrice = getFood().getPrice();
        }
        
    }
    
    public String toString()
    {
        String timeNow = "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        timeNow = sdf.format(super.getDate().getTime());
            return "==========INVOICE==========\n" +
            "ID : " + super.getId() +
            "\nFood: " + super.getFood().getName() +
            "\nDate: " + timeNow +
            "\nCustomer: " + super.getCustomer().getName() +
            "\nTotal Delivery Fee: " + deliveryFee +
            "\nTotal Price: " + super.getTotalPrice() +
            "\nStatus: " + super.getInvoiceStatus() +
            "\nPayment Type: " + PAYMENT_TYPE ;
            /*
            System.out.println("==========INVOICE==========");
            System.out.println("ID: " + super.getId());
            System.out.println("Food: " + super.getFood().getName());
            System.out.println("Date: " + super.getDate());
            System.out.println("Customer: " + super.getCustomer().getName());
            System.out.println("Delivery Fee: " + deliveryFee);
            System.out.println("Total Price: " + getTotalPrice());
            System.out.println("Status: " + super.getInvoiceStatus());
            System.out.println("Payment Type: " + PAYMENT_TYPE);
        */
    }
        
}

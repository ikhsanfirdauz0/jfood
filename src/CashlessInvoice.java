import java.util.*;
import java.util.Date;
import java.util.Calendar;  
import java.lang.Object;
import java.text.Format;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/**
 * Write a description of class CashlessInvoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CashlessInvoice extends Invoice
{
    // instance variables - replace the example below with your own
    private static final PaymentType PAYMENT_TYPE = PaymentType.Cashless;
    private Promo promo;
    /**
     * Constructor for objects of class CashlessInvoice
     */
    public CashlessInvoice(int id, ArrayList<Food> foods, Customer customer)
    {
        super(id, foods, customer);
    }
    
    public CashlessInvoice(int id, ArrayList<Food> foods, Customer customer, Promo promo)
    {
        super(id, foods, customer);
        this.promo = promo;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    //@Override
    @Override
    public PaymentType getPaymentType()
    {
        return PAYMENT_TYPE;
    }
    
    public Promo getPromo()
    {
        return promo;
    }
    
    public void setPromo(Promo promo)
    {
        this.promo = promo;
    }

    public void setTotalPrice() {
        super.totalPrice=0;
        for(Food foodList : getFoods())
        {
            super.totalPrice=super.totalPrice+foodList.getPrice();
        }
        if (promo != null && getPromo().getActive() == true && super.totalPrice > getPromo().getMinPrice())
        {
            super.totalPrice = super.totalPrice  - promo.getDiscount();
        }

        else {
            super.totalPrice = super.totalPrice + 0;
        }
    }



    public String toString()
    {
        String foods = "";
        for (Food foodList : getFoods()) {
            foods = foods + foodList.getName() + ", ";
        }
        foods = foods.substring(0, foods.length() - 2);
        setTotalPrice();
        String timeNow = "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        timeNow = sdf.format(super.getDate().getTime());
        if(promo == null || promo.getActive() == false || super.totalPrice  < getPromo().getMinPrice())
        {
            return "==========INVOICE==========\n" +
                    "ID : " + super.getId() +
                    "\nFood" + foods +
                    "\nDate: " + timeNow +
                    "\nCustomer: " + super.getCustomer().getName() +
                    "\nTotal Price: " + getTotalPrice() +
                    "\nStatus: " + super.getInvoiceStatus() +
                    "\nPayment Type: " + PAYMENT_TYPE ;

        }
        else
        {
            return "==========INVOICE==========\n" +
                    "ID : " + super.getId() +
                    "\nFood: " + foods +
                    "\nDate: " + timeNow +
                    "\nPromo: " + promo.getCode() +
                    "\nCustomer: " + super.getCustomer().getName() +
                    "\nTotal Price: " + getTotalPrice() +
                    "\nStatus: " + super.getInvoiceStatus() +
                    "\nPayment Type: " + PAYMENT_TYPE ;
        }

    }   
}

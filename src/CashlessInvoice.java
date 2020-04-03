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

    public CashlessInvoice(int id, ArrayList<Food> foods, Customer customer)
    {
        super(id, foods, customer);
    }
    
    public CashlessInvoice(int id, ArrayList<Food> foods, Customer customer, Promo promo)
    {
        super(id, foods, customer);
        this.promo = promo;
    }


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

    public void setTotalPrice()
    {
        super.totalPrice = 0;
        //loop trough arraylist makanan dari Invoice
        for(Food foodList : getFoods())
        {
            //totalkan harga makanan
            super.totalPrice=super.totalPrice+foodList.getPrice();
        }
        //jika total harga memenuhi syarat promo dan promo aktif maka:
        if (promo != null && getPromo().getActive() == true && super.totalPrice > getPromo().getMinPrice())
        {
            super.totalPrice = super.totalPrice  - promo.getDiscount();
        }
        //jika tidak ada promo maka:
        else
        {
            super.totalPrice = super.totalPrice + 0;
        }
    }

    public String toString()
    {
        //String manipulation buat list makanan yang dibeli
        String foods = "";
        for (Food foodList : getFoods()) {
            foods = foods + foodList.getName() + ", ";
        }
        foods = foods.substring(0, foods.length() - 2);

        //hitung total harga
        setTotalPrice();

        //set waktu sekarang
        String timeNow = "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        timeNow = sdf.format(super.getDate().getTime());

        //return value
        //if promo tidak ada / tidak aktif / total harga tidak memenuhi syarat promo maka:
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
        //jika kondisi promo dipenuhi maka:
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

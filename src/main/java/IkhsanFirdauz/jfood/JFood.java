package IkhsanFirdauz.jfood;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * this class contains main of the whole program (driver program)
 *
 * @author Ikhsan Firdauz
 * @version 1.0
 * @since 27 - 2 - 2020
 */
@SpringBootApplication
public class JFood
{
    // instance variables - replace the example below with your own
    /**
     * this is the main program
     */
    public static void main (String[] args)
    {
        SpringApplication.run(JFood.class, args);


        //DatabaseCustomerPostgre.insertCustomer(13, "ikhsan", "ikhsan@gmail.com", "123456");

        //System.out.println(DatabaseCustomerPostgre.getLastCustomerId());

        Location objekLokasi1 = new Location("Depok", "Jawa", "Ada UI");
        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId() + 1, "Joko1", "joko1@gmail.com", "081234323", objekLokasi1));


        //add foods
        try
        {
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1,
                    "Kopi item", DatabaseSeller.getSellerById(1), 5000, FoodCategory.Beverages));
        }
        catch (SellerNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1,
                    "Cappuhino", DatabaseSeller.getSellerById(1), 12000, FoodCategory.Beverages));
        }
        catch (SellerNotFoundException e)
        {
            System.out.println(e.getMessage());
        }



    }
        /* BLOCK TEST


        Location objekLokasi2 = new Location("Tangerang", "Bantem", "Ada UI");
        Location objekLokasi3 = new Location("Jakarta", "DKI Jakarta", "Ada UI");


        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId() + 1, "Joko2", "joko2@gmail.com", "081234323", objekLokasi2));
        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId() + 1, "Joko3", "joko3@gmail.com", "081234323", objekLokasi3));

        try {
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId() + 1, "Ratna", "ratna@gmail.com", "Qwerty1234"));
            SpringApplication.run(JFood.class, args);
        } catch (EmailAlreadyExistException error) {
            error.getMessage();
        }


        try
        {
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1,
                    "Katsu Don", DatabaseSeller.getSellerById(1), 20000, FoodCategory.Japanese));
        }
        catch (SellerNotFoundException e)
        {
            System.out.println(e.getMessage());
        }


        ArrayList<Food> list1 = new ArrayList<Food>();
        try
        {
            list1.add(DatabaseFood.getFoodById(1));
        }
        catch (FoodNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

        ArrayList<Food> list2 = new ArrayList<Food>();
        try
        {
            list2.add(DatabaseFood.getFoodById(2));
            list2.add(DatabaseFood.getFoodById(3));
        }
        catch(FoodNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            DatabaseCustomer.addCustomer(new Customer (DatabaseCustomer.getLastId() + 1,
                    "Nama 1", "modul7@gmail.com", "123WQERTY!"));
        }
        catch (EmailAlreadyExistException e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1,
                    "Nama 2", "modul7@gmail.com", "321WQERTY@"));
        }
        catch (EmailAlreadyExistException e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1,
                    "Nama 3", "modul7kedua@gmail.com", "Qwerty!123"));
        }
        catch (EmailAlreadyExistException e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId() +1,
                    "Nama 3", "modul7ketiga@gmail.com", "qWerty!123"));
        }
        catch (EmailAlreadyExistException e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            DatabaseFood.removeFood(30);
        }
        catch (FoodNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            DatabaseFood.getFoodById(30);
        }
        catch (FoodNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            DatabaseCustomer.getCustomerById(30);
        }
        catch (CustomerNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            DatabaseCustomer.removeCustomer(30);
        }
        catch (CustomerNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            DatabaseSeller.removeSeller(30);
        }
        catch (SellerNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            DatabaseSeller.getSellerById(30);
        }
        catch (SellerNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            DatabasePromo.removePromo(30);
        }
        catch (PromoNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            DatabasePromo.getPromoById(30);
        }
        catch (PromoNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            DatabasePromo.addPromo(new Promo (DatabasePromo.getLastId() + 1,
                    "MODUL7", 1000, 10000, true));
        }
        catch (PromoCodeAlreadyExistsException e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId()+1,
                    "MODUL7", 1200, 30000, true));
        }
        catch (PromoCodeAlreadyExistsException e)
        {
            System.out.println(e.getMessage());
        }

        System.out.println("==========YANG MASUK DATABASE CUSTOMER============");
        for(Customer customers : DatabaseCustomer.getDatabaseCustomer())
        {
            System.out.println(customers);
            System.out.println();
        }

        System.out.println("==========YANG MASUK DATABASE PROMO============");
        for(Promo promos : DatabasePromo.getPromoDatabase())
        {
            System.out.println(promos);
            System.out.println();
        }

        System.out.println("==========YANG MASUK DATABASE FOOD============");
        for(Food foods : DatabaseFood.getFoodDatabase())
        {
            System.out.println(foods);
            System.out.println();
        }

        System.out.println("=========YANG MASUK DATABASE SELLER=========");
        for(Seller sellers : DatabaseSeller.getSellerDatabase())
        {
            System.out.println(sellers);
            System.out.println();
        }

        try
        {
            DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId() + 1,
                    list1, DatabaseCustomer.getCustomerById(1), DatabasePromo.getPromoById(1)));
        }
        catch(CustomerNotFoundException e1)
        {
            System.out.println(e1.getMessage());
        }
        catch(PromoNotFoundException e2)
        {
            System.out.println(e2.getMessage());
        }
        catch(OngoinInvoiceAlreadyExistException e3)
        {
            System.out.println(e3.getMessage());
        }

        try
        {
            DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId() + 1,
                    list2, DatabaseCustomer.getCustomerById(2)));

        }
        catch(CustomerNotFoundException e1)
        {
            System.out.println(e1.getMessage());
        }
        catch(OngoinInvoiceAlreadyExistException e3)
        {
            System.out.println(e3.getMessage());
        }


            System.out.println(e3.getMessage());
        } try
        {
            DatabaseInvoice.addInvoice(new CashInvoice(DatabaseInvoice.getLastId() + 1,
                    list2, DatabaseCustomer.getCustomerById(3), 10000));
        }
        catch(CustomerNotFoundException e1)
        {
            System.out.println(e1.getMessage());
        }
        catch(OngoinInvoiceAlreadyExistException e3)
        {


        System.out.println("=========YANG MASUK DATABASE INVOICE=========");

        for(Invoice invoices : DatabaseInvoice.getDatabaseInvoice())
        {
            new Thread(new PriceCalculator (invoices)).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(Invoice invoices : DatabaseInvoice.getDatabaseInvoice())
        {
            invoices.setTotalPrice();
            System.out.println(invoices);
            System.out.println();
        }


        try
        {
            DatabaseInvoice.removeInvoice(30);
        }
        catch (InvoiceNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            DatabaseInvoice.getInvoiceById(30);
        }
        catch (InvoiceNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            DatabaseInvoice.addInvoice(new CashInvoice(DatabaseInvoice.getLastId() + 1,
                    list2, DatabaseCustomer.getCustomerById(1), 10000));
        }
        catch (CustomerNotFoundException e1)
        {
            System.out.println(e1.getMessage());
        }
        catch (OngoinInvoiceAlreadyExistException e2)
        {
            System.out.println(e2.getMessage());
        }

        try
        {
            DatabaseInvoice.addInvoice(new CashInvoice(DatabaseInvoice.getLastId() + 1,
                    list2, DatabaseCustomer.getCustomerById(1), 10000));
        }
        catch (CustomerNotFoundException e1)
        {
            System.out.println(e1.getMessage());
        }
        catch (OngoinInvoiceAlreadyExistException e2)
        {
            System.out.println(e2.getMessage());
        }

*/



}

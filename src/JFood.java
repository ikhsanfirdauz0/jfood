import javax.xml.crypto.Data;
import java.util.*;
/**
 * this class contains main of the whole program (driver program)
 *
 * @author Ikhsan Firdauz
 * @version 1.0
 * @since 27 - 2 - 2020
 */
public class JFood
{
    // instance variables - replace the example below with your own
    /**
     * this is the main program
     */
    public static void main (String[] args)
    {

        Location objekLokasi1 = new Location("Depok", "Jawa", "Ada UI");
        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, "Tenonet",
                "tenonet@gmail.com", "081413565xxx", objekLokasi1));

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

        try
        {
            DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId() + 1,
                    list2, DatabaseCustomer.getCustomerById(2)));

        }
        catch(CustomerNotFoundException e1)
        {
            System.out.println(e1.getMessage());
        }

        try
        {
            DatabaseInvoice.addInvoice(new CashInvoice(DatabaseInvoice.getLastId() + 1,
                    list2, DatabaseCustomer.getCustomerById(3), 10000));
        }
        catch(CustomerNotFoundException e1)
        {
            System.out.println(e1.getMessage());
        }


        System.out.println("=========YANG MASUK DATABASE INVOICE=========");
        for(Invoice invoices : DatabaseInvoice.getDatabaseInvoice())
        {
            System.out.println(invoices);
            System.out.println();
        }

        for(Invoice invoices : DatabaseInvoice.getDatabaseInvoice())
        {
            new Thread(new PriceCalculator (invoices)).start();
        }

        System.out.println("\nList invoice: ");
        for(Invoice invoices : DatabaseInvoice.getDatabaseInvoice())
        {
            invoices.setTotalPrice();
            System.out.println(invoices);
            System.out.println();
        }




       //=================================BLOCK TEST LAMA========================================================

      /*

        //System.out.println(DatabaseCustomer.getDatabaseCustomer());
        for(Customer x : DatabaseCustomer.getDatabaseCustomer())
        {
            System.out.println(x);
        }


        System.out.println(DatabaseFood.getFoodByCategory(FoodCategory.Beverages));

        DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId()+1,
                "JUMATMANTAP", 1000,500 , false));
        DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId()+1,
                "JUMATMANTAP", 5000, 20000, true));

        System.out.println(DatabasePromo.getPromoDatabase());



        DatabaseInvoice.addInvoice(new CashInvoice(DatabaseInvoice.getLastId()+1,
                list1, DatabaseCustomer.getCustomerById(1), 5000));

        for (Invoice iterasi : DatabaseInvoice.getInvoiceByCustomer(1))
        {
            if(iterasi.getId() == DatabaseInvoice.getLastId())
            {
                iterasi.setTotalPrice();
            }
        }

        DatabaseInvoice.addInvoice(new CashInvoice(DatabaseInvoice.getLastId()+1,
                list2, DatabaseCustomer.getCustomerById(1),10000 ));

        for (Invoice iterasi : DatabaseInvoice.getInvoiceByCustomer(1))
        {
            if(iterasi.getId() == DatabaseInvoice.getLastId())
            {
                iterasi.setTotalPrice();
            }
        }

        System.out.println(DatabaseInvoice.getDatabaseInvoice());

        DatabaseInvoice.changeInvoiceStatus(DatabaseInvoice.getLastId(), InvoiceStatus.Finished);

        DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId()+1,
                list2, DatabaseCustomer.getCustomerById(2), DatabasePromo.getPromoById(1)));

        DatabasePromo.activePromo(1);

        for (Invoice iterasi : DatabaseInvoice.getDatabaseInvoice())
        {
            iterasi.setTotalPrice();
        }

        System.out.println(DatabaseInvoice.getDatabaseInvoice());
      Location lokasi1 = new Location("Tangerang", "Banten", "banyak makanan");                   //membuat objek lokasi
        Seller penjual1 = new Seller(1, "Ikhsan Firdauz", "example@gmail.com", "xxx", lokasi1);     //membuat objek penjual
        Food makanan1 = new Food(1, "Espresso", penjual1, 7500, FoodCategory.Beverages);                             //membuat objek makanan
        Food makanan2 = new Food(2, "Ayam Panggang", penjual1, 20000, FoodCategory.Western);
     //   Customer pelanggan1 = new Customer(1, "Timothy", "pelanggan@gmail.com", "qwerty", "28-2-2020");        //membuat objek pelanggan
        Promo objPromo1 = new Promo(1, "JFoodJumatBerkah", 2500, 10000, true);

        Customer pelanggan1 = new Customer(1, "Nama Pelanggan1", ".pelanggan1@gmail.com",
        "qwerty",new GregorianCalendar());

        Customer pelanggan2 = new Customer(2, "Nama Pelanggan2", ".pelanggan2@gmail.com",
        "qwerty",2020, 3, 19);

        Customer pelanggan3= new Customer(3, "Nama Pelanggan3", "pelanggan3@gmail.com",
        "qwer12Ty");

        System.out.println(pelanggan1.toString());
        System.out.println(pelanggan2.toString());
        System.out.println(pelanggan3.toString());

        pelanggan1.setEmail("pelanggan1@gmail.com");
        pelanggan2.setEmail("pelanggan2@gmail.com");
        pelanggan1.setPassword("qwerty123QWERTY");
        pelanggan2.setPassword("qweRTY123");

        System.out.println(pelanggan2.toString());
        System.out.println(pelanggan3.toString());
       // int id, Food food, Customer customer,
    //InvoiceStatus invoiceStatus
        Invoice einvoice = new CashlessInvoice(1, makanan1, pelanggan1, InvoiceStatus.Finished);
        Invoice invoice = new CashInvoice(2, makanan1, pelanggan1, InvoiceStatus.Finished);

        System.out.println(einvoice.toString());
        System.out.println(invoice.toString());

*/
    }



}

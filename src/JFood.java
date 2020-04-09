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

        DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Ikhsan", "ikhsan.firdauz@ui.ac.id", "Qwerty123!"));
        DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Ikhsan", "ikhsan.firdauz@ui.ac.id", "Qwerty1234!"));
        DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Djati", "Djati@ui.ac.id", "Qwerty12345!"));

        //System.out.println(DatabaseCustomer.getDatabaseCustomer());
        for(Customer x : DatabaseCustomer.getDatabaseCustomer())
        {
            System.out.println(x);
        }

        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,
                "Kopi item", DatabaseSeller.getSellerById(1), 5000, FoodCategory.Beverages));
        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,
                "Cappuhino", DatabaseSeller.getSellerById(1), 12000, FoodCategory.Beverages));
        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,
                "Katsu Don", DatabaseSeller.getSellerById(1), 20000, FoodCategory.Japanese));

        System.out.println(DatabaseFood.getFoodByCategory(FoodCategory.Beverages));

        DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId()+1,
                "JUMATMANTAP", 1000,500 , false));
        DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId()+1,
                "JUMATMANTAP", 5000, 20000, true));

        System.out.println(DatabasePromo.getPromoDatabase());

        ArrayList<Food> list1 = new ArrayList<Food>();
        list1.add(DatabaseFood.getFoodById(1));

        ArrayList<Food> list2 = new ArrayList<Food>();
        list2.add(DatabaseFood.getFoodById(2));
        list2.add(DatabaseFood.getFoodById(3));

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





       //=================================BLOCK TEST LAMA========================================================

      /*  Location lokasi1 = new Location("Tangerang", "Banten", "banyak makanan");                   //membuat objek lokasi
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

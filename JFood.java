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
        
        //  Invoice objCashless1 = new CashlessInvoice(1, makanan1, "12-Maret-2020", pelanggan1, InvoiceStatus.Ongoing);
     //   Invoice objCashless2 = new CashlessInvoice(2, makanan1, "12-Maret-2020", pelanggan1, InvoiceStatus.Ongoing, objPromo1);
      //  Invoice objCashless3 = new CashlessInvoice(3, makanan2, "12-Maret-2020", pelanggan1, InvoiceStatus.Ongoing, objPromo1);
      //  objCashless1.setTotalPrice();
     //   objCashless2.setTotalPrice();
     //   objCashless3.setTotalPrice();
       // objCashless1.printData();
       // objCashless2.printData();
       // objCashless3.printData();
        
        
     //   Invoice objCash1 = new CashInvoice(4, makanan2, "13-Maret-2020", pelanggan1, InvoiceStatus.Finished);
     //   Invoice objCash2 = new CashInvoice(5, makanan1, "13-Maret-2020", pelanggan1, InvoiceStatus.Finished, 5000);
        
    //    objCash1.setTotalPrice();
    //    objCash2.setTotalPrice();
        
     //   objCash1.printData();
    //    objCash2.printData();
        
        //  Invoice struk1 = new Invoice(1, makanan1.getId(), "28-2-2020", pelanggan1, makanan1.getPrice(), InvoiceStatus.Finished);                         //membuat objek invoice
       // System.out.println(penjual1.getName());                                                     //print nama dari objek penjual1 dengan metode getName()
       // penjual1.setName("Djati");                                                                  //mengubah value nama dari objek penjual1
       // System.out.println(penjual1.getName());                                                     //print nama dari objek penjual 1 dengan metode getName
      //  struk1.printData();
        //lokasi1.printData();
        //penjual1.printData();
        
        
        
    }

    
    
}

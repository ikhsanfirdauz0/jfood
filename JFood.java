
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
        Food makanan1 = new Food(1, "Geprek", penjual1, 15000, "Ayam");                             //membuat objek makanan
        Customer pelanggan1 = new Customer(1, "pelanggan@gmail.com", "qwerty", "28-2-2020");        //membuat objek pelanggan
        Invoice struk1 = new Invoice(1, 1, "28-2-2020", pelanggan1, 25000);                         //membuat objek invoice
        System.out.println(penjual1.getName());                                                     //print nama dari objek penjual1 dengan metode getName()
        penjual1.setName("Djati");                                                                  //mengubah value nama dari objek penjual1
        System.out.println(penjual1.getName());                                                     //print nama dari objek penjual 1 dengan metode getName
        makanan1.printData();                                                                       //print objek makanan1
        //lokasi1.printData();
        //penjual1.printData();
    }

    
    
}


/**
 * this class contains main of the whole program (driver program)
 *
 * @author Ikhsan Firdauz
 * @version 1.0
 */
public class JFood
{
    // instance variables - replace the example below with your own
    public static void main (String[] args)
    {
        Location lokasi1 = new Location("Depok", "Jawa Barat", "ada UI");
        Seller penjual1 = new Seller(1, "Ikhsan Firdauz", "example@gmail.com", "xxx", lokasi1); 
        lokasi1.printData();
        penjual1.printData();
    }

    
    
}

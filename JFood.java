
/**
 * Write a description of class JFood here.
 *
 * @author Ikhsan Firdauz
 * @version (a version number or a date)
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

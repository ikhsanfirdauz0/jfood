package IkhsanFirdauz.jfood;
/**
 * Enumeration class PaymentType - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum PaymentType
{
    Cashless("Cashless"),
    Cash("Cash");
    
    private String cara_bayar;
    
    PaymentType(String cara_bayar)
    {
        this.cara_bayar = cara_bayar;
    }
    
    public String toString()
    {
        return cara_bayar;
    }
    
}

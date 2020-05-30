package IkhsanFirdauz.jfood;
/**
 * Enumerated Class that hold every possible payment type that can be inputted into Invoice Class object paymentType field
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

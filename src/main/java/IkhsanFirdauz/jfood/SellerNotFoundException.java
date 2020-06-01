package IkhsanFirdauz.jfood;
/**
 * Exception Class to throw exception if id is out of bounds/not found seller's Id for any method that needs seller's Id as its parameter
 * @author Ikhsan Firdauz
 * @version 1.0
 * @since 27 - 2 - 2020
 */
public class SellerNotFoundException extends Exception {

    private int seller_error;

    public SellerNotFoundException (int seller_input)
    {
        super("Seller ID: ");
        this.seller_error = seller_input;
    }

    @Override
    public String getMessage()
    {
        return super.getMessage() + seller_error + " not found";
    }
}

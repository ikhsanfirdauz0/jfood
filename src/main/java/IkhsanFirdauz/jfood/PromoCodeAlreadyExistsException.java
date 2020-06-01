package IkhsanFirdauz.jfood;
/**
 * Exception Class to throw exception if any method called returns a Promo Class object that already exist in the database
 * @author Ikhsan Firdauz
 * @version 1.0
 * @since 27 - 2 - 2020
 */
public class PromoCodeAlreadyExistsException extends Exception {

    private Promo promo_error;

    public PromoCodeAlreadyExistsException(Promo promo_input)
    {
        super ("Promo Code: ");
        this.promo_error = promo_input;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + promo_error.getCode() + " already exists.";
    }
}

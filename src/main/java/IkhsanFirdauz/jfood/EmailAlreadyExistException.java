package IkhsanFirdauz.jfood;
/**
 * Exception Class to throw exception if any method called returns a Customer Class object that the email field
 * is already exist in the customer database
 * @author Ikhsan Firdauz
 * @version 1.0
 * @since 27 - 2 - 2020
 */
public class EmailAlreadyExistException extends Exception {

    private Customer customer_error;

    public EmailAlreadyExistException(Customer customer_input)
    {
        super("Customer Email: ");
        this.customer_error = customer_input;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + customer_error.getEmail() + " already exist.";
    }
}

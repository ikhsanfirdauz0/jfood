package IkhsanFirdauz.jfood;
/**
 * Exception Class to throw exception if any method called returns an Invoice Class object that the invoiceStatus field string value is "ongoing"
 * @author Ikhsan Firdauz
 * @version 1.0
 * @since 27 - 2 - 2020
 */
public class OngoinInvoiceAlreadyExistException extends Exception
{
    Invoice invoice_error;

    public OngoinInvoiceAlreadyExistException(Invoice invoice_input)
    {
        super("Ongoing Invoice");
        this.invoice_error = invoice_input;
    }

    @Override
    public String getMessage()
    {
        return super.getMessage() + " already exist " + "with " +
                "Id: " + invoice_error.getId() + ", Customer: " + invoice_error.getCustomer().getName();
    }
}

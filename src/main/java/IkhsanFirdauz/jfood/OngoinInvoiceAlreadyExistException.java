package IkhsanFirdauz.jfood;
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

package IkhsanFirdauz.jfood;
/**
 * Enumerated Class that hold every possible invoice status that can be inputted into Invoice Class object invoiceStatus field
 * @author Ikhsan Firdauz
 * @version 1.0
 * @since 27 - 2 - 2020
 */
public enum InvoiceStatus
{
    Ongoing("Ongoing"),
    Finished("Finished"),
    Cancelled("Cancelled");
    
    private String status;
    
    InvoiceStatus(String status)
    {
        this.status = status;
    }
    
    public String toString()
    {
        return status;
    }
    
}

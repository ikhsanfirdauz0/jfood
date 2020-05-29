package IkhsanFirdauz.jfood;
import java.util.ArrayList;

public class DatabaseInvoice {

    private static ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<>();
    private static int lastId = 0;

    public static ArrayList<Invoice>  getDatabaseInvoice()
    {
        return INVOICE_DATABASE;
    }

    public static int getLastId()
    {
        return lastId;
    }

    public static Invoice getInvoiceById(int id) throws InvoiceNotFoundException
    {
        for (Invoice invoice : INVOICE_DATABASE)
        {
            if (invoice.getId() == id)
            {
                return invoice;
            }
        }
        throw new InvoiceNotFoundException(id);
    }

    public static ArrayList<Invoice> getInvoiceByCustomer(int customerId)
    {
        ArrayList<Invoice> invoiceList = new ArrayList<Invoice>();
        for (Invoice invoice : INVOICE_DATABASE)
        {
            if(invoice.getCustomer().getId() == customerId)
            {
                invoiceList.add(invoice);
            }
        }
        return invoiceList;
    }

    public static boolean addInvoice(Invoice invoice) throws OngoinInvoiceAlreadyExistException
    {
        int customerId = invoice.getCustomer().getId();
        for (Invoice iterasi : INVOICE_DATABASE)
        {
            if(iterasi.getCustomer().getId() == customerId && iterasi.getInvoiceStatus() == InvoiceStatus.Ongoing)
            {
                throw new OngoinInvoiceAlreadyExistException(invoice);
            }
        }
        INVOICE_DATABASE.add(invoice);
        lastId = invoice.getId();
        return true;
    }

    public static boolean changeInvoiceStatus(int id, InvoiceStatus invoiceStatus)
    {
        for (Invoice invoice : INVOICE_DATABASE)
        {
            if(invoice.getId() == id && invoice.getInvoiceStatus().equals(InvoiceStatus.Ongoing))
            {
                invoice.setInvoiceStatus(invoiceStatus);
                return true;
            }
        }
        return false;
    }

    public static boolean removeInvoice(int id) throws InvoiceNotFoundException
    {
        for (Invoice invoice : INVOICE_DATABASE)
        {
            if(invoice.getId() == id)
            {
                INVOICE_DATABASE.remove(invoice);
                return true;
            }
        }
        throw new InvoiceNotFoundException(id);
    }

}

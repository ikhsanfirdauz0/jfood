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

    public static Invoice getInvoiceById(int id)
    {
        for (Invoice invoice : INVOICE_DATABASE)
        {
            if (invoice.getId() == id)
            {
                return invoice;
            }
        }
        return null;
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
            else
            {
                invoiceList = null;
            }
        }
        return invoiceList;
    }

    public static boolean addInvoice(Invoice invoice)
    {
        for (Invoice iterasi : INVOICE_DATABASE)
        {
            if(invoice.getCustomer().equals(iterasi.getCustomer()) && invoice.getInvoiceStatus() == InvoiceStatus.Ongoing)
            {
                return false;
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
                invoice.setInvoiceStatus(InvoiceStatus.Finished);
                return true;
            }
        }
        return false;
    }

    public static boolean removeInvoice(int id)
    {
        for (Invoice invoice : INVOICE_DATABASE)
        {
            if(invoice.getId() == id)
            {
                INVOICE_DATABASE.remove(invoice);
                return true;
            }
        }
        return false;
    }

}

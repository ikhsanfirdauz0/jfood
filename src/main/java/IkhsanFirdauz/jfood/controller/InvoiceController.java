package IkhsanFirdauz.jfood.controller;

import IkhsanFirdauz.jfood.*;
import org.springframework.web.bind.annotation.*;
import java.util.Locale;

import java.util.ArrayList;

@RequestMapping("/Invoice")
@RestController
public class InvoiceController
{
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Invoice> getAllOInvoice()
    {
        return DatabaseInvoice.getDatabaseInvoice();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Invoice getInvoiceById(@PathVariable int id) throws InvoiceNotFoundException
    {
        Invoice invoice = null;
        try
        {
            invoice = DatabaseInvoice.getInvoiceById(id);
        }
        catch (InvoiceNotFoundException e)
        {
            e.getMessage();
        }
        return invoice;
    }

    @RequestMapping(value = "/customer/{customerId}", method = RequestMethod.GET)
    public ArrayList<Invoice> getInvoiceByCustomer(@PathVariable int customerId)
    {
        ArrayList<Invoice> invoice = null;
        invoice = DatabaseInvoice.getInvoiceByCustomer(customerId);
        return invoice;
    }

    @RequestMapping(value = "/invoiceStatus/{id}", method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus(@PathVariable int id, @PathVariable InvoiceStatus status) throws InvoiceNotFoundException
    {
        Invoice invoice = null;
        DatabaseInvoice.changeInvoiceStatus(id, status);
        try
        {
            invoice = DatabaseInvoice.getInvoiceById(id);
        }
        catch (InvoiceNotFoundException e)
        {
            e.getMessage();
        }
        return invoice;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean removeInvoice(@RequestParam(value = "id") int id) throws InvoiceNotFoundException
    {
        try
        {
            DatabaseInvoice.removeInvoice(id);
        }
        catch (InvoiceNotFoundException e)
        {
            e.getMessage();
            return false;
        }
        return true;
    }


    @RequestMapping(value = "/createCashInvoice", method = RequestMethod.POST)
    public Invoice addCashInvoice(@RequestParam(value = "foods") ArrayList<Food> foods,
                                  @RequestParam(value = "customer") int customerId,
                                  @RequestParam(value = "deliveryFee") int deliveryFee) throws CustomerNotFoundException
    {
        Invoice invoice = new CashInvoice(DatabaseInvoice.getLastId() + 1,
                                            foods,
                                            DatabaseCustomer.getCustomerById(customerId),
                                            deliveryFee);;
        try
        {
            DatabaseInvoice.addInvoice(invoice);
        }
        catch (OngoinInvoiceAlreadyExistException e)
        {
            e.getMessage();
            return null;
        }
        invoice.setTotalPrice();
        return invoice;
    }


    @RequestMapping(value = "/createCashlessInvoice", method = RequestMethod.POST)
    public Invoice addCashlessInvoice(@RequestParam(value = "foods") ArrayList<Food> foods,
                                  @RequestParam(value = "customer") int customerId,
                                  @RequestParam(value = "promoCode") String promoCode) throws CustomerNotFoundException
    {
        Invoice invoice = new CashlessInvoice(DatabaseInvoice.getLastId() + 1,
                foods,
                DatabaseCustomer.getCustomerById(customerId),
                DatabasePromo.getPromoByCode(promoCode));
        try
        {
            DatabaseInvoice.addInvoice(invoice);
        }
        catch (OngoinInvoiceAlreadyExistException e)
        {
            e.getMessage();
        }
        return invoice;
    }
}

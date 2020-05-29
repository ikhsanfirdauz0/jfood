package IkhsanFirdauz.jfood.controller;

import IkhsanFirdauz.jfood.*;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/customer")
@CrossOrigin(origins = " ", allowedHeaders = "*")
@RestController
public class CustomerController
{

    @RequestMapping("")
    public String indexPage(@RequestParam(value="name", defaultValue="world") String name)
    {
        return "Hello " + name;
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable int id)
    {
        Customer customer = null;
        try
        {
            customer = DatabaseCustomerPostgre.getCustomer(id);
        }
        catch (Exception e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return customer;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Customer register(@RequestParam(value="name") String name,
                                @RequestParam(value="email") String email,
                                @RequestParam(value="password") String password)
    {
        try
        {
            DatabaseCustomerPostgre.insertCustomer(
                    DatabaseCustomerPostgre.getLastCustomerId()+1,
                    name,
                    email,
                    password);
        }
        catch (Exception e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return null;
        }

        Customer customer = new Customer(DatabaseCustomerPostgre.getLastCustomerId()+1, name, email, password);

        return customer;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Customer loginCustomer(@RequestParam(value="email") String email,
                                    @RequestParam(value="password") String password)
    {
        Customer customer = null;

        try
        {
            customer = DatabaseCustomerPostgre.getLogin(email, password);
        }
        catch (Exception e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return null;
        }
        return customer;

    }
}
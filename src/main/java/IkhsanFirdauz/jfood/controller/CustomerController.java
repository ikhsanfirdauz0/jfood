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
            customer = DatabaseCustomer.getCustomerById(id);
        }
        catch (CustomerNotFoundException e)
        {
            e.getMessage();
            return null;
        }
        return customer;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Customer register(@RequestParam(value="name") String name,
                                @RequestParam(value="email") String email,
                                @RequestParam(value="password") String password)
    {
        Customer customer = new Customer(DatabaseCustomer.getLastId()+1, name, email, password);
        try
        {
            DatabaseCustomer.addCustomer(customer);
        }
        catch (EmailAlreadyExistException e)
        {
            e.getMessage();
            return null;
        }
        return customer;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Customer loginCustomer(@RequestParam(value="email") String email,
                                    @RequestParam(value="password") String password)
    {
        Customer customer;
        try
        {
           customer = DatabaseCustomer.getCustomerLogin(email, password);
        }
        catch (Exception e)
        {
            e.getMessage();
            return null;
        }
        return customer;
    }
}
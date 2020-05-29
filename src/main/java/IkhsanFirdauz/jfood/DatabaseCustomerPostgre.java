package IkhsanFirdauz.jfood;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DatabaseCustomerPostgre
{
    public static void insertCustomer(int id, String name, String email, String password)
    {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        Date date = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date1 = sdf.format(date);


        try
        {
            Connection c = DatabaseConnectionPostgre.connection();
            Statement stmt = c.createStatement();
            String query = "INSERT INTO customer_list (id, name, email, password, join_date)"
                    + "VALUES (" + id + ",'" + name + "','"+ email + "','"+ password + "','" + date1 + "');";

            stmt.executeUpdate(query);
            stmt.close();
            c.close();
        }
        catch (Exception e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public static int getLastCustomerId()
    {

        int lastCustomerId = 0;
        try
        {
            Connection c = DatabaseConnectionPostgre.connection();
            Statement stmt = c.createStatement();
            String query = "SELECT MAX(id) FROM customer_list";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next())
            {
                int lastId = rs.getInt("max");
                lastCustomerId = lastId;
            }

            rs.close();
            stmt.close();
            c.close();
        }
        catch (Exception e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return lastCustomerId;
    }

    public static Customer getCustomer(int id)
    {
        Customer customer = null;
        try
        {
            Connection c = DatabaseConnectionPostgre.connection();
            Statement stmt = c.createStatement();
            String query = "SELECT * FROM customer_list WHERE id =" + id + ";";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next())
            {
                int currentId = rs.getInt("id");
                String currentName = rs.getString("name");
                String currentEmail = rs.getString("email");
                String currentPassword = rs.getString("password");
                Date currentJoinDate = rs.getDate("join_date");

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date fixedJoinDate = sdf.parse(String.valueOf(currentJoinDate));
                Calendar cal = Calendar.getInstance();
                cal.setTime(fixedJoinDate);

                Customer tmpCustomer = new Customer(
                        currentId,
                        currentName,
                        currentEmail,
                        currentPassword,
                        cal);

                customer = tmpCustomer;
            }

            rs.close();
            stmt.close();
            c.close();
        }
        catch (Exception e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

        return customer;
    }

    public static void removeCustomer(int id)
    {
        try
        {
            Connection c = DatabaseConnectionPostgre.connection();
            Statement stmt = c.createStatement();
            String query = "DELETE FROM customer_list WHERE id =" + id + ";";
            stmt.executeUpdate(query);
            stmt.close();
            c.close();
            System.out.println("deleted customer with id: " + id );
        }
        catch (Exception e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public static Customer getLogin(String email, String password)
    {
        String checkPassword = "";
        Customer customer = null;
        try
        {
            Connection c = DatabaseConnectionPostgre.connection();
            Statement stmt = c.createStatement();
            String query = "SELECT * FROM customer_list WHERE email = '" + email + "';";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next())
            {
                int currentId = rs.getInt("id");
                String currentName = rs.getString("name");
                String currentEmail = rs.getString("email");
                Date currentJoinDate = rs.getDate("join_date");
                String currentPassword = rs.getString("password");
                checkPassword = currentPassword;

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date fixedJoinDate = sdf.parse(String.valueOf(currentJoinDate));
                Calendar cal = Calendar.getInstance();
                cal.setTime(fixedJoinDate);

                Customer tmpCustomer = new Customer(
                        currentId,
                        currentName,
                        currentEmail,
                        currentPassword,
                        cal);

                customer = tmpCustomer;
            }
        }
        catch (Exception e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

        if(password.equals(checkPassword))
        {
            return customer;
        }

        return null;

    }
}

package IkhsanFirdauz.jfood;
import org.springframework.core.env.SystemEnvironmentPropertySource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class DatabaseConnectionPostgre
{
    public static Connection connection()
    {
        Connection c = null;
        try
        {

            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jbdc:postgresql://localhost:5432/jfood", "postgres", "120399");
        }
        catch (Exception e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return c;
    }
}

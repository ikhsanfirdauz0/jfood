package IkhsanFirdauz.jfood;
import org.springframework.core.env.SystemEnvironmentPropertySource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * this class is to connect to local PostgreSQL Database
 *
 * @author Ikhsan Firdauz
 * @version 1.0
 * @since 29 - 5 - 2020
 */
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

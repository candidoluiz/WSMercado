package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
   private static Connection con;
   
    public static Connection getConnection() throws Exception
    {
        if(con==null)
        {
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mercado?useTimezone=true&serverTimezone=UTC", "root","");
            }
            catch(ClassNotFoundException | SQLException e)
                    {
                        throw new Exception(e.getMessage());
                    }
        }
        return con;
    }
}

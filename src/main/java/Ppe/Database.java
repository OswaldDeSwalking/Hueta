package Ppe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database
{
    Connection c = null;
    Statement statement = null;
    Statement statement1 = null;
    Statement statement2 = null;

    public void Connection() throws SQLException
    {
        c = DriverManager.getConnection("jdbc:sqlite:d:\\Jobs\\arm.db");
        statement = c.createStatement();
        statement1 = c.createStatement();
        statement2 = c.createStatement();
    }

}

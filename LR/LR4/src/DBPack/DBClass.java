package DBPack;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

public class DBClass
{
    String SelectString;

    public DBClass (String str)
    {
        SelectString = str;
    }

    public void PrintResult() throws SQLException {
        ResultSet resultSet = getResult();
        while (resultSet.next())
        {
            System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
        }
    }

    public ArrayList<Point> getListPoints() throws SQLException {
        ArrayList<Point> ListPoints = new ArrayList<Point>();
        ResultSet resultSet = getResult();
        while (resultSet.next())
        {
            Point point = new Point(resultSet.getInt("x"), resultSet.getInt("y"));
            ListPoints.add(point);
        }
        return ListPoints;
    }

    private ResultSet getResult()
    {
        ResultSet resultSet = null;
        Connection connection = this.getConnection();
        if (connection != null)
        {
            try
            {
                Statement statement = connection.createStatement();
                resultSet = statement.executeQuery(SelectString);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resultSet;
    }

    private Connection getConnection()
    {
        try
        {
            return DriverManager.getConnection(getConnectionString());
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    private String getConnectionString()
    {
        return "jdbc:sqlserver://172.16.99.104\\MSSQLSERVER:1433;database=LR4;user=OrangeJava;password=OrangeJava;"
                + "encrypt=true;"
                + "trustServerCertificate=true;"
                + "loginTimeout=30;";
    }
}

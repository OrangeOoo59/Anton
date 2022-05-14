package DBPack;

import TaskPack.Tarif;

import java.sql.*;
import java.util.ArrayList;

public class DBClass
{
    String SelectString;

    public DBClass(String SelectString)
    {
        this.SelectString = SelectString;
    }

    public void PrintResult() throws SQLException {
        ResultSet resultSet = getResult();
        while (resultSet.next())
        {
            System.out.println(resultSet.getString("id") + " " + resultSet.getString("name_tarif")+ " " + resultSet.getString("cost_tarif"));
        }
    }

    public ArrayList<Tarif> getListTarif() throws SQLException {
        ArrayList<Tarif> ListTarif = new ArrayList<Tarif>();
        ResultSet resultSet = getResult();
        while (resultSet.next())
        {
            Tarif tarif = new Tarif(resultSet.getString("name_tarif"), resultSet.getInt("cost_Tarif"));
            ListTarif.add(tarif);
        }
        return ListTarif;
    }
    public ArrayList<String> getListClient() throws SQLException {
        ArrayList<String> ListClient = new ArrayList<String>();
        ResultSet resultSet = getResult();
        while (resultSet.next())
        {
            ListClient.add(resultSet.getString("name_client"));
        }
        return ListClient;
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

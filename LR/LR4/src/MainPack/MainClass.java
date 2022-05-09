package MainPack;
import java.sql.*;

public class MainClass
{
    public static void main(String[] args)
    {
        String ConnURL = "jdbc:sqlserver://127.0.0.1\\MSSQLSERVER:1433;database=LR4;user=OrangeJava;password=OrangeJava;"
            + "encrypt=true;"
            + "trustServerCertificate=true;"
            + "loginTimeout=30;";

        try(Connection connection = DriverManager.getConnection(ConnURL); Statement statement = connection.createStatement();)
        {
            ResultSet resultSet = null;
            System.out.println("conn sex end");
            String selectSql = "SELECT * FROM PointTable";
            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

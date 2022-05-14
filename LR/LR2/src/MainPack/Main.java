package MainPack;

import DBPack.DBClass;
import TaskPack.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main
{
    public static void main (String[] args) throws SQLException {
        Company C = new Company();
        DBClass D = new DBClass("select name_client from PZ7Client");
        ArrayList<String> ListClient =  D.getListClient();
        for (String nameClient : ListClient)
        {
            C.AddClient(nameClient);
        }
        System.out.println("Number of company clients: " + C.CountClients());
        C.RangeTarif(20, 40);

        //TaskFirst T = new TaskFirst();
        //TaskSecond S = new TaskSecond();
    }
}

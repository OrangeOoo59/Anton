package MainPack;
import DBPack.DBClass;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

public class MainClass
{
    public static void main(String[] args)
    {
        DBClass D = new DBClass("select * from PointTable");

        try
        {

            D.PrintResult();
            ArrayList<Point> P = D.getListPoints();
            Task1(P);
            Task2(P);
            Task3(P);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    private static void Task1(ArrayList<Point> ListPoints)
    {
        Point SetPoint = new Point(21, 100);
        Point NearPoint = ListPoints.get(0);
        double distance = Math.sqrt(Math.pow(SetPoint.x - NearPoint.x, 2)+Math.pow(SetPoint.y - NearPoint.y, 2));
        for (Point p : ListPoints)
        {
            if (distance>Math.sqrt(Math.pow(SetPoint.x - p.x, 2)+Math.pow(SetPoint.y - p.y, 2)))
            {
                distance = Math.sqrt(Math.pow(SetPoint.x - p.x, 2)+Math.pow(SetPoint.y - p.y, 2));
                NearPoint = p;
            }
        }
        System.out.println("Наиболе приближена к " + SetPoint.x +" : "+ SetPoint.y + " точка "+ NearPoint.x +" : "+ NearPoint.y);

    }
    private static void Task2(ArrayList<Point> ListPoints)
    {
        Point SetPoint = new Point(21, 100);
        Point NearPoint = ListPoints.get(0);
        double distance = Math.sqrt(Math.pow(SetPoint.x - NearPoint.x, 2)+Math.pow(SetPoint.y - NearPoint.y, 2));
        for (Point p : ListPoints)
        {
            if (distance<Math.sqrt(Math.pow(SetPoint.x - p.x, 2)+Math.pow(SetPoint.y - p.y, 2)))
            {
                distance = Math.sqrt(Math.pow(SetPoint.x - p.x, 2)+Math.pow(SetPoint.y - p.y, 2));
                NearPoint = p;
            }
        }
        System.out.println("Наиболе удалена к " + SetPoint.x +" : "+ SetPoint.y + " точка "+ NearPoint.x +" : "+ NearPoint.y);
    }
    private static void Task3(ArrayList<Point> ListPoints)
    {
        int a = 1;
        int b = -1;
        int c = 0;
        for (Point p : ListPoints)
        {
            if ((a*p.x + b*p.y + c) == 0)
            {
                System.out.println("Точка лежащая на прямой " + p.x +" : "+ p.y );
            }
        }

    }
}

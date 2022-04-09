package TaskPack;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Task
{
    HashMap<String, Double> Coordinates;
    ArrayList<HashMap<String, Double>> Points;
    ArrayList<String> EquationOfAStraightLine;
    HashMap<String, Integer> CountPointOnTheLine;

    public Task(int CountPoint, int SizeField)
    {
        Points = new ArrayList<>();
        for (int i=0; i<CountPoint; i++)
        {
            Random Rand = new Random();
            Coordinates = new HashMap<String, Double>();
//            Coordinates.put("x", Rand.nextDouble() * SizeField);
//            Coordinates.put("y", Rand.nextDouble() * SizeField);
            Coordinates.put("x", (double)(int)(Rand.nextDouble() * SizeField));
            Coordinates.put("y", (double)(int)(Rand.nextDouble() * SizeField));
            Points.add(Coordinates);
        }
    }
    public void FindTheNumberOfPointsOnOneLine()
    {
        CountPointOnTheLine = new HashMap<String, Integer>();
        for(int i=0; i<EquationOfAStraightLine.size(); i++)
        {
            int Count = 2;
            for(int j= i + 1; j<EquationOfAStraightLine.size(); j++)
            {
                if (EquationOfAStraightLine.get(i).equals(EquationOfAStraightLine.get(j)))
                {
                    Count++;
                    EquationOfAStraightLine.remove(j);
                    j--;
                }
            }
            CountPointOnTheLine.put(EquationOfAStraightLine.get(i), Count);
        }
    }
    public void PrintEquationOnConsole()
    {
        for(Map.Entry<String, Integer> E: CountPointOnTheLine.entrySet())
        {
            if (!(E.getKey().equals("0,000x - 0,000y + 0,000 = 0")))
                System.out.println(E.getKey() +"      \t| "+E.getValue());
        }
    }
    public void PrintEquationOnFile()
    {
        try(FileWriter WriteFile = new FileWriter("Equation.txt", false))
        {
            for(Map.Entry<String, Integer> E: CountPointOnTheLine.entrySet())
            {
                if (!(E.getKey().equals("0,000x - 0,000y + 0,000 = 0")))
                    WriteFile.write(E.getKey() + "       \t|Number of points on a line: " + E.getValue() + "\n");
            }
            WriteFile.flush();
        }
        catch(IOException e)
        {
            System.out.println("Problem: " + e.getMessage());
        }
    }

    public void GetAllEquationOfAStraightLine()
    {
        EquationOfAStraightLine = new ArrayList<String>();
        for(int i=0; i<Points.size()-1; i++)
        {
            for(int j = i + 1; j<Points.size(); j++)
            {
                EquationOfAStraightLine.add(GetEquationOfAStraightLine(Points.get(i), Points.get(j)));
            }
        }

    }
    private String GetEquationOfAStraightLine(HashMap<String, Double> F, HashMap<String, Double> S)
    {
        double A = S.get("y") - F.get("y");
        double B = S.get("x") - F.get("x");
        double C = F.get("y") * B - F.get("x") * A;
        return "" + String.format("%.3f", A) + "x" + ((B >= 0) ? (" - " + String.format("%.3f", B)) : (" + " + String.format("%.3f", Math.abs(B)))) + "y" + ((C >= 0) ? (" + " + String.format("%.3f", C)) : (" - " + String.format("%.3f", Math.abs(C)))) + " = 0";
    }
}

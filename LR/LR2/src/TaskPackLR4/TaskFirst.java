package TaskPackLR4;

import java.awt.List;
import java.io.*;
import java.util.*;

import static StaticPack.InsertClass.InsertIntNumber;

public class TaskFirst
{
    ArrayList Number;

    public TaskFirst()
    {
        Number = new ArrayList();
        AddFile();
        ReadFile();
        SortFile();
        PrintSortFile();
    }
    private void AddFile()
    {
        System.out.println("Insert Len/Min value/Max value: ");
        int Len = InsertIntNumber(2147483647);
        int Min = InsertIntNumber();
        int Max = InsertIntNumber();
        if (Min > Max)
        {
            System.out.println("Min value <-> Max value!");
            int save = Min;
            Min = Max;
            Max = save;
        }
        try(FileWriter WriteFile = new FileWriter("FileNumber.txt", false))
        {
            while (Len > 0)
            {
                WriteFile.write((int)((Math.random()*(Max-Min))+Min) + " ");
                Len--;
            }
            WriteFile.flush();
        }
        catch(IOException e)
        {
            System.out.println("Problem: " + e.getMessage());
        }
    }
    private void ReadFile()
    {
        try (FileReader FileRead = new FileReader("FileNumber.txt"))
        {
            Scanner Scan = new Scanner(FileRead);
            while (Scan.hasNextInt())
            {
                Number.add(Scan.next());
            }
        }
        catch (Exception ex)
        {
            System.out.println("Ошибка: " + ex.toString());
        }
    }
    private void SortFile()
    {
        Collections.sort(Number);
    }
    private void PrintSortFile()
    {
        try(FileWriter WriteFile = new FileWriter("FileSortNumber.txt", false))
        {
            for (Object i: Number)
            {
                WriteFile.write(i.toString() + "\n");
            }
            WriteFile.flush();
        }
        catch(IOException e)
        {
            System.out.println("Problem: " + e.getMessage());
        }
    }

}

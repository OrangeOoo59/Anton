package TaskPackLR4;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


public class TaskSecond
{
    ArrayList<String> List;
    public TaskSecond()
    {
        List = new ArrayList<String>();
        ReadFile("private", "public", false);
        PrintSortFile("Company.java", false);
        ReadFile("", "", true);
        PrintSortFile("ReverseTextJava.txt", true);
    }
    private void ReadFile(String str, String replace, boolean reverse)
    {
        List.clear();
        try (FileReader FileRead = new FileReader("Company.java"))
        {
            Scanner Scan = new Scanner(FileRead);
            while (Scan.hasNextLine())
            {
                String[] S = Scan.nextLine().split(" ");
                for (int i = 0; i < S.length; i++)
                {
                    if (S[i].equals(str))
                        S[i] = replace;
                }
                if (reverse)
                {
                    for (int i=0; i<S.length; i++)
                    {
                        char[] arr =  S[i].toCharArray();
                        for(int j = 0; j < arr.length / 2; j++)
                        {
                            char c = arr[j];
                            arr[j] = arr[arr.length - 1 - j];
                            arr[arr.length - 1 - j] = c;
                        }
                        S[i] = new String(arr);
                    }
                    for (int i=0; i<S.length / 2; i++)
                    {
                        String s = S[i];
                        S[i] = S[S.length - 1 - i];
                        S[S.length - 1 - i] = s;
                    }

                }
                List.add(String.join(" ", S) + "\n");
            }

        }
        catch (Exception ex)
        {
            System.out.println("Ошибка: " + ex.toString());
        }
    }
    private void PrintSortFile(String name, boolean reverse)
    {
        try(FileWriter WriteFile = new FileWriter(name, false))
        {
            for (String i: List)
            {
                WriteFile.write(i);
            }
            WriteFile.flush();
        }
        catch(IOException e)
        {
            System.out.println("Problem: " + e.getMessage());
        }
    }
}

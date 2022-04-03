package Tasks;

import java.awt.*;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

//В стихотворении найти количество слов, начинающихся и заканчивающихся
 //гласной буквой.
public class T1
{
    char[] Laters = {'а', 'е', 'ё', 'и', 'о', 'у', 'ы', 'э', 'ю', 'я' };
    List S = new List();

    public T1(String path)
    {
        try (FileReader FileRead = new FileReader(path))
        {
            Scanner Scan = new Scanner(FileRead);
            while (Scan.hasNextLine())
            {
                for(String str : Scan.nextLine().replaceAll(",", "").replaceAll(":", "").replaceAll("/.", "").split(" "))
                {
                    if (str.equals(""))
                        continue;
                    boolean f1 = false, f2 = false;
                    for (char c : Laters)
                    {
                        if (str.toLowerCase(Locale.ROOT).charAt(0) == c)
                            f1 = true;
                        if (str.toLowerCase(Locale.ROOT).charAt(str.length() - 1) == c)
                            f2 = true;
                        if (f1 && f2)
                        {
                            S.add(str);
                            break;
                        }
                    }
                }
            }
        }
        catch (Exception ex)
        {
            System.out.println("Ошибка: " + ex.toString());
        }
    }
    public void Print()
    {
        for (String s : S.getItems())
        {
            System.out.println(s);
        }
    }
}

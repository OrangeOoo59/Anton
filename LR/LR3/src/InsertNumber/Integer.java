package InsertNumber;

import java.util.Scanner;

public class Integer
{
    private static final int MinValue = -2147483648;
    private static final int MaxValue = 2147483647;
    public static int Number(int down, int up)
    {
        Scanner Scan = new Scanner(System.in);
        int insertNumber = 0;
        while (true)
        {
            try
            {
                insertNumber = Scan.nextInt();
                if (insertNumber < down || insertNumber > up)
                {
                    System.out.print("Incorrect value, please try again: ");
                }
                else
                {
                    break;
                }
            }
            catch (Exception e)
            {
                System.out.print("The entered number is not an integer, please try again: ");
                Scan.next();
            }
        }
        return insertNumber;
    }
    public static int Number()
    {
        return Number(MinValue , MaxValue);
    }
    public static int Max(int max)
    {
        return Number(MinValue , max);
    }
    public static int Min(int min)
    {
        return Number(min , MaxValue);
    }
    public static int ZeroMax(int max)
    {
        return Number(0 , max);
    }
    public static int MinZero(int min)
    {
        return Number(min , 0);
    }
}

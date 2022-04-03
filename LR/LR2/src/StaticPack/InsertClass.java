package StaticPack;

import java.util.Scanner;

public class InsertClass
{
    public static int InsertIntNumber(int down, int up)
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
    public static int InsertIntNumber()
    {
        return InsertIntNumber(-2147483648 , 2147483647);
    }
    public static int InsertIntNumber(int max)
    {
        return InsertIntNumber(1 , max);
    }
}

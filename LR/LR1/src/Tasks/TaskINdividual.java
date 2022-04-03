package Tasks;

import java.util.Scanner;

public class TaskINdividual
{
    public static void T5()
    {
        Scanner Scan = new Scanner(System.in);
        System.out.print("Введите промежуток(два целых числа min = -1000, max = 1000):");
        int Start = InsertIntNumber(-1000, 1000, false);
        int Finish = InsertIntNumber(-1000, 1000, false);
        System.out.print("Введите значения, через Enter: ");
        for (int i=0; i<3; i++)
        {
            System.out.println(InsertIntNumber(Start, Finish, true));
        }
        Scan.close();
    }
    private static int InsertIntNumber(int down, int up, boolean flag)
    {
        Scanner Scan = new Scanner(System.in);
        int insertNumber = 0;
        while (true)
        {
            try
            {
                insertNumber = Scan.nextInt();
                if (insertNumber<down || insertNumber>up)
                {
                    System.out.print("Значение не попало в промежуток: ");
                    if (flag)
                    {
                        break;
                    }
                }
                else
                {
                    if (flag)
                    {
                        System.out.print("Значение попало в промежуток: ");
                    }
                    break;
                }
            }
            catch (Exception e)
            {
                System.out.print("Введено не целое число, повторите ввод: ");
                Scan.next();
            }
        }
        return insertNumber;
    }
}

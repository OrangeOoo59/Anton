package Tasks;

public class TaskFirst
{
    public static void T1()
    {
        for (int i=1; i<=500;i++)
        {
            boolean flag = true;
            if (i%5==0)
            {
                System.out.print("fizz");
                flag = false;
            }
            if (i%7==0)
            {
                System.out.print("buzz");
                flag = false;
            }
            if (flag)
                System.out.print(i);
            System.out.println();
        }
    }
}

package Tasks;

public class TaskTheard
{
    public static void T3(int LastNumber)
    {
        int a = 0, b = 1;
        System.out.println("1");
        while ((a + b) < LastNumber)
        {
            int c = a+b;
            System.out.println(c);
            a=b;
            b=c;
        }
    }
}

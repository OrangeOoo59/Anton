package Tasks;

public class TaskSecond
{
    public static void T2(String InStr)
    {
        for (int i=InStr.length()-1; i>=0; i--)
        {
            System.out.print(InStr.charAt(i));
        }
    }
}

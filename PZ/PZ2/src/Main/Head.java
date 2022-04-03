package Main;
import Tasks.TaskFirst;
import Tasks.TaskSecond;

public class Head
{
    static public void main(String[] str)
    {
        TaskFirst T1 = new TaskFirst();
        T1.OutputTask();
        System.out.println();
        TaskSecond T2 = new TaskSecond();
        T2.OutputTask();
    }
}

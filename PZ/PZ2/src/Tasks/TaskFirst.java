package Tasks;

import java.util.Arrays;
import java.util.Random;

public class TaskFirst
{
    int[] Array;

    public TaskFirst()
    {
        Array = new int[8];
        Random R = new Random();
        for (int i=0; i<Array.length; i++)
        {
            Array[i] = R.nextInt(10) + 1;
        }
    }

    private void ReplaceOddIndex()
    {
        for (int i=1; i<Array.length; i+=2)
        {
            Array[i] = 0;
        }
    }
    private void PrintArray()
    {
        System.out.println(Arrays.toString(Array));
    }
    public void OutputTask()
    {
        System.out.println("Вывод задания 1\nМассив 8-ми случайных целочисленных значений от 1 до 10: ");
        PrintArray();
        ReplaceOddIndex();
        System.out.println("Тотже массив, элементы с нечётными индексами заменены на 0");
        PrintArray();
    }


}

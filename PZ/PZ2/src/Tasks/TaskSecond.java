package Tasks;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TaskSecond
{
    int[][] Array;
    int MinElement;
    int IndexI, IndexJ;

    public TaskSecond()
    {
        System.out.println("Вывод заданитя 2");
        System.out.print("Введите размер квадратной матрицы (3<=a<=10): ");
        int a = InsertIntNumber(3, 10);
        Array = new int[a][a];
        FillingAnArray(50);
        SearchMinElement();
    }

    private void FillingAnArray(int a)
    {
        Random R = new Random();
        for (int i=0; i<Array.length; i++)
            for (int j=0; j<Array[i].length; j++)
                Array[i][j] = R.nextInt(a) + 1;
    }
    private int InsertIntNumber(int down, int up)
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
                    System.out.print("Некоректное значение, повторите ввод: ");
                }
                else
                {
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
    private void SearchMinElement()
    {
        MinElement = Array[0][0];
        IndexI = 0;
        IndexJ = 0;
        for (int i = 0; i < Array.length; i++)
            for (int j = 0; j < Array[i].length; j++) {
                if (Array[i][j] <= MinElement) {
                    MinElement = Array[i][j];
                    IndexI = i;
                    IndexJ = j;
                }
            }
    }
    private void Permutation(int row, int column)
    {
        int[] SaveArray = Array[IndexI];
        Array[IndexI] = Array[row];
        Array[row] = SaveArray;

        for (int i=0; i<Array.length; i++)
        {
            int SaveNumber = Array[i][IndexJ];
            Array[i][IndexJ] = Array[i][column];
            Array[i][column] = SaveNumber;
        }
    }
    private void PrintArray()
    {
        for (int[] ints : Array) System.out.println(Arrays.toString(ints));
    }
    public void OutputTask()
    {
        System.out.println("Исходная матрица");
        PrintArray();
        System.out.println("Введите координаты значения с которым поменять местами последнее минималиное значение");
        System.out.print("Индекс строки: ");
        int row = InsertIntNumber(0, Array.length - 1);
        System.out.print("Индекс столбца: ");
        int column = InsertIntNumber(0, Array[row].length - 1);
        Permutation(row, column);
        System.out.println("строки "+IndexI+" и "+row+", колонки "+IndexJ+" и "+column+" были пересетавлены");
        PrintArray();
    }
}

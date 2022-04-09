package MainPack;
import TaskPack.*;
import InsertNumber.*;

public class MainClass
{
    public static void main(String[] args)
    {
        System.out.print("Enter the size of the square field: ");
        int SizeFields = InsertNumber.Integer.ZeroMax(50);
        System.out.print("Enter the number of generated points: ");
        int CountPoints = InsertNumber.Integer.ZeroMax();
        CountPoints = CheckCountPointsOnField(SizeFields, CountPoints);

        Task T = new Task(CountPoints, SizeFields);
        T.GetAllEquationOfAStraightLine();
        T.FindTheNumberOfPointsOnOneLine();
        T.PrintEquationOnConsole();
        T.PrintEquationOnFile();
    }

    private static int CheckCountPointsOnField(int Size, int Count)
    {
        while(true)
        {
            if (Math.pow(Size, 2) > Count)
            {
                return Count;
            }
            else
            {
                System.out.print("Too many points entered(Maximum points < "+ Math.pow(Size, 2) +"),\nPlease re-enter: ");
                Count = InsertNumber.Integer.ZeroMax();
            }
        }
    }
}

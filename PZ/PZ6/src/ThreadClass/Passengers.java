package ThreadClass;

import java.util.Random;

public class Passengers extends Thread
{
    private static int CountPass;
    @Override
    public void run()
    {
        for (int i=0; i<25; i++)
        {
            CountPass = new Random().nextInt(1000);
            System.out.println("///////////////////////////////////////////\nPass : "+CountPass+"\n///////////////////////////////////////////");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.err.println(e.toString());
            }
        }
    }

    public static int getCountPass() {
        return CountPass;
    }

    public static void setCountPass(int countPass) {
        CountPass = countPass;
    }
}

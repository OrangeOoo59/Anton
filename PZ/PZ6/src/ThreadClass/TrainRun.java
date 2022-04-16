package ThreadClass;

import java.util.Random;

class Train
{
    private int Spaciousness;
    private int CountPass;

    public Train()
    {
        Spaciousness = new Random().nextInt(500);
        CountPass = new Random().nextInt(Spaciousness);
    }
    public int getSpaciousness()
    {
        return  Spaciousness;
    }

    public int getCountPass() {
        return CountPass;
    }

    public void setCountPass(int countPass) {
        CountPass = countPass;
    }
}


public class TrainRun extends Thread
{
    private int MinP(Train T)
    {
        return Math.min((T.getSpaciousness() - T.getCountPass()), Passengers.getCountPass());
    }
    @Override
    public void run()
    {
        for (int i=0; i<25; i++)
        {
            Train T = new Train();
            System.out.println("Train on station");
            System.out.println("Spaciousness: " + T.getSpaciousness());
            System.out.println("CountPass: " + T.getCountPass());
            System.out.println("Pass of station: " + Passengers.getCountPass());
            int out = new Random().nextInt(T.getCountPass());
            T.setCountPass(T.getCountPass() - out);
            Passengers.setCountPass(Passengers.getCountPass() + out);
            int sid = new Random().nextInt(MinP(T));
            T.setCountPass(T.getCountPass()+sid);
            Passengers.setCountPass(Passengers.getCountPass() - sid);

            System.out.println("Train out pass: " + out);
            System.out.println("Train sid pass: " + sid);
            System.out.println("CountPass: " + T.getCountPass());
            System.out.println("Pass of station: " + Passengers.getCountPass());
            System.out.println("The train has left the station");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.err.println(e.toString());
            }
        }
    }
}

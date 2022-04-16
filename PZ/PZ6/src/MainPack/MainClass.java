package MainPack;

import ThreadClass.Passengers;
import ThreadClass.TrainRun;

// Станция. поезда приходят на станцию для пасадки/высадки посажиров.
// Число пассажиров, находящихся в текущий момент на станции должно быть не отрицательным и не превышать заданую вместимость
// На одной станции может стоять один поезд.
// Поезд может производить посадку/высодку посожиров.

public class MainClass
{
    public static void main(String[] args)
    {
        TrainRun TR = new TrainRun();
        Passengers P = new Passengers();
        P.start();
        TR.start();
// WalkRunnable w = new WalkRunnable(); // просто объект, не поток
// w.run(); или talk.run();
    }
}

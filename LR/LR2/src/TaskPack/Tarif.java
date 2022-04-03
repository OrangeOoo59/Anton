package TaskPack;

public class Tarif
{
    private String Name;
    private int Cost;

    public Tarif (String Name, int Cost)
    {
        this.Name = Name;
        this.Cost = Cost;
    }

    public int getCost() {
        return Cost;
    }
    public String getInfo()
    {
        return Name + " -> " + Cost;
    }
}

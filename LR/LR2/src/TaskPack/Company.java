package TaskPack;

import java.util.*;

import static StaticPack.InsertClass.*;

public class Company
{
    private ArrayList<Tarif> CompanyTarifs;
    private ArrayList<Client> CompanyClients;

    public Company()
    {
        CompanyTarifs = new ArrayList<Tarif>();
        CompanyTarifs.add(new Tarif("Black", 100));
        CompanyTarifs.add(new Tarif("Base", 10));
        CompanyTarifs.add(new Tarif("Red", 80));
        CompanyTarifs.add(new Tarif("Advance", 30));
        CompanyTarifs.add(new Tarif("Classic", 20));
        CompanyTarifs.add(new Tarif("Green", 60));


        CompanyClients = new ArrayList<Client>();
        SortTarif();
    }
    public void RangeTarif(int f, int l)
    {
        System.out.println("Tariffs in the range: "+ f + " - " + l + ":");
        ArrayList<Tarif> S = new ArrayList<Tarif>();
        for (Tarif T: CompanyTarifs)
        {
            if (T.getCost() >= f && T.getCost() <= l)
            {
                S.add(T);
            }
        }
        PrintTarif(S);
    }
    private void SortTarif()
    {
        try
        {
            for (int i=0; i<CompanyTarifs.size(); i++)
            {
                for (int j = 0; j<(CompanyTarifs.size()-1);j++)
                {
                    if (CompanyTarifs.get(j).getCost() > CompanyTarifs.get(j+1).getCost())
                    {
                        Tarif S = CompanyTarifs.get(j);
                        CompanyTarifs.remove(j);
                        if (j+1 == CompanyTarifs.size())
                        {
                            CompanyTarifs.add(S);
                        }
                        else
                        {
                            CompanyTarifs.add((j+1), S);
                        }


                    }
                }
            }
        }
        catch (IndexOutOfBoundsException | UnsupportedOperationException e)
        {
            System.out.println("Fail sorting: " + e.getMessage());
        }
    }
    public int CountClients()
    {
        return CompanyClients.size();
    }
    public void AddClient(String NameClient)
    {
        int NumberTarif;
        PrintTarif(CompanyTarifs);
        System.out.print("Select the tariff number for the client: \"" + NameClient + "\": ");
        NumberTarif = InsertIntNumber(1, CompanyTarifs.size());
        CompanyClients.add(new Client(NameClient, CompanyTarifs.get(NumberTarif - 1)));
    }
    private void PrintTarif(ArrayList<Tarif> CompanyTarifs)
    {
        System.out.println("Number) Name tariff -> Cost tariff");
        int i = 1;
        for (Tarif T: CompanyTarifs)
        {
            System.out.println(i + ") " + T.getInfo());
            i++;
        }
    }

}

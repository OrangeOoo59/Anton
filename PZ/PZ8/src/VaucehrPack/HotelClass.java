package VaucehrPack;

import java.util.ArrayList;

public class HotelClass
{
    String Stars;
    String Television;
    String Nutrition;
    String Conditioner;

    public HotelClass(ArrayList<String> H)
    {
        Stars = H.get(0);
        Television = H.get(1);
        Nutrition = H.get(2);
        Conditioner = H.get(3);
    }
    public String getHotel()
    {
        String result = "<table border=\"1\">";
        result += "<tr><td>Stars</td><td>"+Stars+"</td></tr>";
        result += "<tr><td>Television</td><td>"+Television+"</td></tr>";
        result += "<tr><td>Nutrition</td><td>"+Nutrition+"</td></tr>";
        result += "<tr><td>Conditioner</td><td>"+Conditioner+"</td></tr>";
        result += "</table>";
        return result;
    }

}

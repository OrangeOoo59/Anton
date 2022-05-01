package VaucehrPack;

import java.util.ArrayList;

public class VaucherClass
{
    String Type;
    String Country;
    String Number;
    String Transport;
    HotelClass Hotel;
    String Cost;
    public VaucherClass(ArrayList<String> V,ArrayList<String> H)
    {
        Type = V.get(0);
        Country = V.get(1);
        Number = V.get(2);
        Transport = V.get(3);
        Cost = V.get(4);
        Hotel = new HotelClass(H);
    }
    public String getVauchers()
    {
        String result = "<table border=\"3\">";
        result += "<tr><td>Type</td><td>"+Type+"</td></tr>";
        result += "<tr><td>Country</td><td>"+Country+"</td></tr>";
        result += "<tr><td>Number</td><td>"+Number+"</td></tr>";
        result += "<tr><td>Transport</td><td>"+Transport+"</td></tr>";
        result += "<tr><td>Hotel</td><td>"+Hotel.getHotel()+"</td></tr>";
        result += "<tr><td>Cost</td><td>"+Cost+"</td></tr>";
        result += "</table>";
        return result;
    }

}

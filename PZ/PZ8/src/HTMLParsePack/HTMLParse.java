package HTMLParsePack;

import VaucehrPack.VaucherClass;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class HTMLParse
{
    public HTMLParse(ArrayList<VaucherClass> V)
    {


        try(FileWriter WriteFile = new FileWriter("File.html", false))
        {
            String s = "<html><body>";
            for (VaucherClass v : V)
            {
                s += v.getVauchers();
            }
            s+="</body></html>";
            WriteFile.write(s);
            WriteFile.flush();
        }
        catch(IOException e)
        {
            System.out.println("Problem: " + e.getMessage());
            e.printStackTrace();
        }
    }

}

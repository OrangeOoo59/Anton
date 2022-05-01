package XMLParsPack;

import VaucehrPack.HotelClass;
import VaucehrPack.VaucherClass;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class XMLPars
{
    Document Doc;
    public XMLPars(String PathXML)
    {
        try
        {
            DocumentBuilderFactory Factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder Builder = Factory.newDocumentBuilder();
            Doc = Builder.parse(new File(PathXML));
        }
        catch (ParserConfigurationException | SAXException | IOException e)
        {
            System.out.println("Error with pars XML");
            e.printStackTrace();
        }
    }
    public ArrayList<VaucherClass> Parsing()
    {
        Doc.getDocumentElement().normalize();
        NodeList ListNode = Doc.getElementsByTagName("TouristVoucher");

        ArrayList<VaucherClass> Vouchers = new ArrayList<VaucherClass>();

        for (int i=0; i< ListNode.getLength(); i++)
        {
            Node n = ListNode.item(i);
            if (n.getNodeType() == Node.ELEMENT_NODE)
            {
                Element el = (Element) n;
                ArrayList<String> Hotel = new ArrayList<String>();
                ArrayList<String> Voucher = new ArrayList<String>();
                Hotel = HotelP(el.getElementsByTagName("Hotel").item(0).getTextContent().trim().split("\n"));
                Voucher.add(el.getElementsByTagName("Type").item(0).getTextContent().trim());
                Voucher.add(el.getElementsByTagName("Country").item(0).getTextContent().trim());
                Voucher.add(el.getElementsByTagName("Number").item(0).getTextContent().trim());
                Voucher.add(el.getElementsByTagName("Transport").item(0).getTextContent().trim());
                Voucher.add(el.getElementsByTagName("Cost").item(0).getTextContent().trim());
                Vouchers.add(new VaucherClass(Voucher, Hotel));
            }
        }
        return Vouchers;
    }
    private ArrayList<String> HotelP(String[] arr)
    {
        ArrayList<String> Hotel = new ArrayList<String>();
        for (String s: arr)
        {
            //System.out.println(s.trim());
            Hotel.add(s.trim());
        }
        return Hotel;
    }
}

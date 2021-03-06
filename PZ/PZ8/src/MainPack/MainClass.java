package MainPack;

import HTMLParsePack.HTMLParse;
import VaucehrPack.VaucherClass;
import XMLParsPack.*;

import java.util.ArrayList;

//Туристические путевки.
//Туристические путевки, предлагаемые агентством, имеют следующие
//характеристики:
//  —Type — тип (выходного дня, экскурсионная, отдых, паломничество и т. д.);
//  —Country — страна, выбранная для путешествия;
//  —Number days/nights — количество дней и ночей;
//  —Тransport — вид перевозки туристов (авиа, ж/д, авто, лайнер);
//  —Hotel characteristic (должно быть несколько) — количество звезд, включено ли питание и какое (HB, BB, Al), какой номер (1-, 2-, 3-местные), есть ли телевизор, кондиционер и т. д.;
//  —Сost — стоимость путевки (сколько и что включено).
//  Корневой элемент назвать Тourist voucher.
//Преобразовать XML-файл в формат HTML, c выводом
//информации в табличном виде.

public class MainClass
{
    public static void main(String[] args)
    {
        ArrayList<VaucherClass> Vouchers;
        XMLPars Pars = new XMLPars("XMLFile.xml");
        Vouchers = Pars.Parsing();
        HTMLParse HTML = new HTMLParse(Vouchers);
    }
}

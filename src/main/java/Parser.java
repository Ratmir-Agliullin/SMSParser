import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Аглиуллины on 06.10.2017.
 */
public class Parser {
    private static String link;

    public static void main(String[] args) {
        System.out.println(SmsActivate());
    }

    public static String SmsActivate(){
        String result=null;
       link="http://sms-activate.ru/";
        Document doc = null;
        try {
            doc = Jsoup.connect(link).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i=0;
while (true) {

            try {
                Element element = doc.select("tr.tabbed.cell").get(i);
                Element td = element.getElementsByTag("td").get(1);
                Element label = td.getElementsByTag("label").first();
                String name = label.getElementsByTag("span").first().text();
                String count = label.getElementsByTag("span").get(1).text();
                String price = element.getElementsByTag("td").get(2).text();
                i++;
                System.out.println(name.substring(5)+" "+count.substring(0,count.length()-2)+" "+price);
            } catch (IndexOutOfBoundsException e){
                break;
            }
}
        return " ";//name.substring(5)+" "+count.substring(0,count.length()-2)+" "+price;
    }

    public static String parsingWihRegex(String input, String regex, int start, int end) {
        String result = null;
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(input);
        if (m.find()) {
            result = m.group(0).substring(start, m.group(0).length() - end);


        }
        return result;
    }
}

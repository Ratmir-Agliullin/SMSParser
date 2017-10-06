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
   //       SmsActivate();
     SimSMS();
    }

    public static String SimSMS(){
        String result=null;
        link="http://simsms.org/";
        Document doc = null;
        try {
            doc = Jsoup.connect(link).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i=0;
      //  while (true) {

          //  try {
                Element element = doc.select("div.list-body").get(0);
            Element li = element.getElementsByClass("li.row.list-item").get(0);
            String image = "http://simsms.org"+li.getElementsByTag("img").get(0).attr("src");
        //    Element div = element.getElementsByClass("col-xs-20").get(0);
//                Element label = td.getElementsByTag("label").first();
//                String name = label.getElementsByTag("span").first().text();
//                String count = label.getElementsByTag("span").get(1).text();
//                String price = element.getElementsByTag("td").get(2).text();
//                i++;
            //    System.out.println(name.substring(5)+" "+count.substring(0,count.length()-2)+" "+price);
                System.out.println(image);
         //   } catch (IndexOutOfBoundsException e){
              //  break;
          //  }
     //   }

        return " ";//name.substring(5)+" "+count.substring(0,count.length()-2)+" "+price;
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
                String image = "http://sms-activate.ru"+label.getElementsByTag("img").get(0).attr("src");
                String name = label.getElementsByTag("span").first().text();
                String count = label.getElementsByTag("span").get(1).text();
                String price = element.getElementsByTag("td").get(2).text();
                i++;
                System.out.println(image+" "+name.substring(5)+" "+count.substring(0,count.length()-2)+" "+price);
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

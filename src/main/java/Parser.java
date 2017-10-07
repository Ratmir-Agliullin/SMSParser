import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Аглиуллины on 06.10.2017.
 */
public class Parser {
    private static String link;

    public static void main(String[] args) {
   //       SmsActivate();
 //  SimSMS();
  //      SmsVK();
     //   SmsLike();
        try {
            getPage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public static String SmsLike(){
        String result=null;
        link="https://smslike.ru/ru/";
        Document doc = null;
        try {
            doc = Jsoup.connect(link).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i=0;
        Element element = doc.select("div.pt-15").get(0);
        while (true) {

            try {
               Element tr = element.getElementsByTag("tr").get(i);
             String image = "https://smslike.ru"+tr.getElementsByTag("td").get(0).getElementsByTag("img").attr("src");
                String name  = tr.getElementsByTag("td").get(0).getElementsByTag("span").get(0).text();
                String count = tr.getElementsByTag("td").get(0).getElementsByTag("span").get(1).text();
               String price = tr.getElementsByTag("td").get(0).getElementsByTag("div").get(0).text().split(" ")[1]+"р.";
                i++;

        System.out.println(image+" "+name+" "+count+" "+price);

            } catch (IndexOutOfBoundsException e){
                break;
            }
        }

        return " ";
    }




    public static String SmsVK(){
        String result=null;
        link="http://smsvk.net/";
        Document doc = null;
        try {
            doc = Jsoup.connect(link).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i=0;
        Element element = doc.select("div.vsep").get(0);
        while (true) {

            try {

              Element tr = element.getElementsByTag("tr").get(i);
              String name  = tr.getElementsByTag("td").get(0).text();
              String image = "http://smsvk.net"+tr.getElementsByTag("td").get(0).getElementsByTag("img").attr("src");
              String countBuf = tr.getElementsByTag("td").get(1).text();
        String count = countBuf.substring(0,countBuf.length()-2);
        String price = tr.getElementsByTag("td").get(2).text();
                i++;
        System.out.println(image+" "+name+" "+count+" "+price);
            } catch (IndexOutOfBoundsException e){
                break;
            }
        }

        return " ";//name.substring(5)+" "+count.substring(0,count.length()-2)+" "+price;
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

//                Element element = doc.select("section.main-section").get(0);
//            Element ul = element.getElementsByTag("ul").get(0);
        Element ul = doc.select("section").get(0);
//            String image = "http://simsms.org"+li.getElementsByTag("img").get(0).attr("src");

                System.out.println(ul.toString());


        return " ";
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

    public static void getPage() throws IOException {
        String url = "http://simsms.org/";

        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println(response.toString());
    }
}

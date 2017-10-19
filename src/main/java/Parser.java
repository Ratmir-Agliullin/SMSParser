


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.*;
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
    public static JSONObject globalJSON=new JSONObject();
    public  JSONArray globalArray=new JSONArray();

    public static void main(String[] args) throws IOException {
      Parser parser = new Parser();
     parser.SmsActivate();
    parser.SmsVK();
   // SmsLike();
        System.out.println(parser.globalArray.toString());
        //Service.writeStringInFile(globalArray.toString());
    }




    public  String SmsLike(){
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

                JSONObject bodySite = new JSONObject();
                JSONObject bodyInfo = new JSONObject();
                bodyInfo.put("count",count);
                bodyInfo.put("price",price);
                bodySite.put("nameservice","smslike");
                bodySite.put("namesite",name);
                bodySite.put("bodysite",bodyInfo);
                globalArray.add(bodySite);



            } catch (IndexOutOfBoundsException e){
                break;
            }
        }

    //  System.out.println(globalArray.toString());
        return " ";
    }




    public  String SmsVK(){
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
        JSONObject siteJSON = new JSONObject();
        while (true) {

            try {

              Element tr = element.getElementsByTag("tr").get(i);
              String name  = tr.getElementsByTag("td").get(0).text();
              String image = "http://smsvk.net"+tr.getElementsByTag("td").get(0).getElementsByTag("img").attr("src");
              String countBuf = tr.getElementsByTag("td").get(1).text();
        String count = countBuf.substring(0,countBuf.length()-2);
        String price = tr.getElementsByTag("td").get(2).text();
                i++;
    //    System.out.println(image+" "+name+" "+count+" "+price);
//                JSONObject SiteJSON = new JSONObject();
//                SiteJSON.put("count",count);
//                SiteJSON.put("price",price);
//                siteJSON.put(name,SiteJSON);
                JSONObject bodySite = new JSONObject();
                JSONObject bodyInfo = new JSONObject();
                bodyInfo.put("count",count);
                bodyInfo.put("price",price);
                bodySite.put("nameservice","smsvk");
                bodySite.put("namesite",name);
                bodySite.put("bodysite",bodyInfo);
                globalArray.add(bodySite);

            } catch (IndexOutOfBoundsException e){
                break;
            }
        }
     //   globalJSON.put("smsvk",siteJSON);
      //  System.out.println(globalArray.toString());
        return " ";//name.substring(5)+" "+count.substring(0,count.length()-2)+" "+price;
    }




    public  String SimSMS() throws IOException {
        String result=null;
        link="http://simsms.org";
        Document doc = null;
        try {
            doc = Jsoup.connect(link).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i=0;
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Аглиуллины\\IdeaProjects\\SMSParser\\src\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String baseUrl = "http://yandex.ru";
        driver.get(baseUrl);
    //    driver.quit();
     //   WebElement element = driver.findElement(By.className("list-body"));
      //  System.out.println(element.toString());
//        WebClient webClient = new WebClient();
//        HtmlPage page = webClient.getPage(link);
//        System.out.println(page.getBody().toString());
        return " ";
    }




    public  String SmsActivate(){
        String result=null;
       link="http://sms-activate.ru/";
        Document doc = null;
        try {
            doc = Jsoup.connect(link).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i=0;
        JSONObject siteJSON = new JSONObject();
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
             //   System.out.println(image+" "+name.substring(5)+" "+count.substring(0,count.length()-2)+" "+price);
//                JSONObject SiteJSON = new JSONObject();
//                SiteJSON.put("count",count);
//                SiteJSON.put("price",price);
//                siteJSON.put(name.substring(5),SiteJSON);
                JSONObject bodySite = new JSONObject();
                JSONObject bodyInfo = new JSONObject();
                bodyInfo.put("count",count);
                bodyInfo.put("price",price);
                bodySite.put("nameservice","sms-activate");
                bodySite.put("namesite",name.substring(5));
                bodySite.put("bodysite",bodyInfo);
               globalArray.add(bodySite);

            } catch (IndexOutOfBoundsException e){
                break;
            }
}
       // globalJSON.put("sms-activate",siteJSON);
      //  System.out.println(globalArray.toString());
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

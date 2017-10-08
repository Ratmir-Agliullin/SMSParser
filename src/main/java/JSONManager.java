import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Created by Аглиуллины on 06.10.2017.
 */
public class JSONManager {

    public static void main(String[] args) {
//        System.out.println(setResult(Append(getExpression("name", "count", "345"),
//                getExpression("name2", "count2", "34")),"one").toString());
        System.out.println(getExpression( "name", "count", "price").toString());
    }

    public static JSONObject getExpression(String name, String count, String price){
//        JSONObject resultWithKey = new JSONObject();
        JSONObject resultJson = new JSONObject();
        JSONObject siteJson = new JSONObject();
        siteJson.put("count",count);
        siteJson.put("price",price);
        resultJson.put(name,siteJson);
     //   resultWithKey.put(key, resultJson);
        return resultJson;
    }


    public static JSONArray Append(JSONArray one,JSONObject two){
        JSONArray ar = new JSONArray();
        ar.add(one);
        ar.add(two);
        return ar;
    }

    public static JSONObject setResult(JSONArray ar, String key){
        JSONObject resultJson = new JSONObject();
        resultJson.put(key,ar);
        return resultJson;
    }
    public static JSONObject setElement(JSONObject ar, String key){
        JSONObject resultJson = new JSONObject();
        resultJson.put(key,ar);
        return resultJson;
    }

}

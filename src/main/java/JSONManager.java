import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Created by Аглиуллины on 06.10.2017.
 */
public class JSONManager {

    public static void main(String[] args) {
        System.out.println(setResult(Append(getExpression("name", "count", "345"),
                getExpression("name2", "count2", "34"))).toString());
    }

    public static JSONObject getExpression(String name, String count, String price){
        JSONObject resultJson = new JSONObject();
        resultJson.put("name",name);
        resultJson.put("count",count);
        resultJson.put("price",price);
        return resultJson;
    }


    public static JSONArray Append(JSONObject one,JSONObject two){
        JSONArray ar = new JSONArray();
        ar.add(one);
        ar.add(two);
        return ar;
    }

    public static JSONObject setResult(JSONArray ar){
        JSONObject resultJson = new JSONObject();
        resultJson.put("body",ar);
        return resultJson;
    }
}

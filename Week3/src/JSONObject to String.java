import org.json.JSONObject;

public class JSONExample {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Phuc");
        jsonObject.put("age", 21);
        jsonObject.put("city", "Hai Duong");

        String jsonString = jsonObject.toString();
        System.out.println("JSON String: " + jsonString);
    }
}

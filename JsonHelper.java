import minimaljson.Json;
import minimaljson.JsonObject;
import minimaljson.JsonValue;

public class JsonHelper {
    public static String toJson(String sourceLang, String targetLang, String text) {

        JsonObject abc = new JsonObject();
        abc.add("q", text)
                .add("source", sourceLang)
                .add("target", targetLang);

        return abc.toString();
    }

    public static String getTranslatedText(String responseBody) {
        System.out.println(responseBody);
        JsonValue json = Json.parse(responseBody);
        String translatedText = json.asObject().get("data").asObject().get("translations")
                .asArray().get(0)
                .asObject().get("translatedText").asString();
        return translatedText;
    }
}

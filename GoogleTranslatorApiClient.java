import java.net.http.HttpResponse;

public class GoogleTranslatorApiClient {
    public String translate(String sourceLang, String targetLang, String text) {
        String translatedText = null;

        String requestJson = JsonHelper.toJson(sourceLang, targetLang, text);
        HttpResponse<String> response = HttpHelper.post(requestJson);

        translatedText = JsonHelper.getTranslatedText(response.body());

        return translatedText;
    }
}
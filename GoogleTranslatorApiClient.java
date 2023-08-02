import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GoogleTranslatorApiClient {

    public String translate(String sourceLang, String targetLang, String text) {
        String translatedText = null;
        try {

            String requestJson = JsonHelper.toJson(sourceLang, targetLang, text);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://translation.googleapis.com/language/translate/v2"))
                    .header("Authorization",
                            "Bearer ya29.a0AbVbY6N1evKEo72_cDq8Q5Sm6_zjdKOttbCDIn7qdb1YkoCkTxNWpkG0cSxIdVvn48lbV6sAgpH1cIMckHWqKvNo3uqxsnUE6lw66X9mqhXyhwLAIAWll_h4GJakV_hcJGae9XuEQXdo4mqlrobfkiRTcsMJUzNpvsASgPMaCgYKAbUSARISFQFWKvPlgoT_u-NQWZV7ixzkX-SYWg0174")
                    .header("x-Goog-User-Project", "translator-387919")
                    .header("Content-type", "application/json;charset=utf-8")
                    .POST(HttpRequest.BodyPublishers.ofString(requestJson)).build();

            HttpResponse<String> response = HttpClient.newHttpClient().send(request,
                    HttpResponse.BodyHandlers.ofString());

            System.out.println(response.body());
            translatedText = JsonHelper.getTranslatedText(response.body());
        } catch (IOException | InterruptedException | URISyntaxException e) {
            e.printStackTrace();

        }
        return translatedText;
    }
}
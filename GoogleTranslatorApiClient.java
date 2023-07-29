import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import minimaljson.Json;
import minimaljson.JsonValue;

public class GoogleTranslatorApiClient {

    public String translate(String sourceLang, String targetLang, String text) {
        String translatedText = null;
        try {

            JsonValue requestJson = JsonHelper.toJson(sourceLang, targetLang, text);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://translation.googleapis.com/language/translate/v2"))
                    .header("Authorization",
                            "Bearer ya29.a0AWY7CkngaaiAE2mInSaFhGkBkxmTpTbj0tYLLSQrcZ3ohi3wUqO-qt8twKT6G8Mj3t0xH9eyUiH8_uvMgCPPHZl_I3G6wXIx1UO6haLZ-c_1KRgDSWvGE4-eIj_Gqg8tJM1b9egf9dfAiB4PNmePE_1VrMN8j0ZVCHpLlwaCgYKAbQSARISFQG1tDrpB0WvZQ9kRE-FVOgK1cXETQ0173")
                    .header("x-Goog-User-Project", "translator-387919")
                    .header("Content-type", "application/json;charset=utf-8")
                    .POST(HttpRequest.BodyPublishers.ofString(requestJson.toString())).build();

            HttpResponse<String> response = HttpClient.newHttpClient().send(request,
                    HttpResponse.BodyHandlers.ofString());

            System.out.println(response.body());
            JsonValue json = Json.parse(response.body());
            translatedText = json.asObject().get("data").asObject().get("translations")
                    .asArray().get(0)
                    .asObject().get("translatedText").asString();
        } catch (IOException | InterruptedException | URISyntaxException e) {
            e.printStackTrace();

        }
        return translatedText;
    }
}
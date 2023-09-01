import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HttpHelper {
    public static HttpResponse<String> post(String requestJson) {

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://translation.googleapis.com/language/translate/v2"))
                    .header("Authorization",
                            "Bearer ya29.a0AfB_byBUptHRAOrHerB-HU5g9zZKLHsWFw9zP5juZTL6217UPm2-Igwh6eB4yNLWCamiELfYaTVfdo-f6nQ5jWCPrHPGilb4c9dDvfqvEtmiR9POpqOpwGcOXywUydsgVfVZZLbMjk1CfPDdpoZW0dmRjuKkrKhrE9eHHp_qlzXTaPYnaCgYKATQSARISFQHsvYlsepgnhRrpc6UnyhJlHCOvBg0183")
                    .header("x-Goog-User-Project", "translator-387919")
                    .header("Content-type", "application/json;charset=utf-8")
                    .POST(HttpRequest.BodyPublishers.ofString(requestJson)).build();

            HttpResponse<String> response = HttpClient.newHttpClient().send(request,
                    HttpResponse.BodyHandlers.ofString());
            return response;
        } catch (IOException | InterruptedException | URISyntaxException e) {
            e.printStackTrace();
            return null;
        }

    }

}

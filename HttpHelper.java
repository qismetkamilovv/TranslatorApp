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
                            "Bearer ya29.a0AfB_byDh7x9kxAkUDxtfuaigTqAE2bzFMxRWUfy8NlvnPrVJmpqEUYKMZ8uiiF6x6oJyZ3oQX7KGqbX5dM1ZgXskN3ErT5QmPpnvigYlqp8_baHktcLzzvgllJkQiSPY6jGiHJSvjdK-9CJddlfcbn1aVuQK4Wx7dIzlVuHgngUaCgYKAWMSARISFQGOcNnCPHTgGtBHd6VDouUElYNrBw0178")
                    .header("x-Goog-User-Project", "translatorapp-398317")
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

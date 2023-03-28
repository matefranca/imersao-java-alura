import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI uri = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        JsonParser parser = new JsonParser();
        List<Map<String, String>> movies = parser.parse(body);

        for (Map<String, String> movie : movies) {
            // System.out.println(movie.get("title"));
            // System.out.println(movie.get("image"));
            // System.out.println(movie.get("imDbRating"));

            String imageUrl = movie.get("image");
            String title = movie.get("title");
            
            InputStream inputStream = new URL(imageUrl).openStream();
            String fileName =  title + ".png";

            StickerFactory stickerFactory = new StickerFactory();
            stickerFactory.create(inputStream, fileName);

            System.out.println(title);
            System.out.println();
        }
    }
}
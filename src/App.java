import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        
        ClientHttp httpClient = new ClientHttp();
        String json = httpClient.getData(url);

        ContentExtractor contentExtractorImdb = new ContentExtractorImdb();
        List<Content> contents = contentExtractorImdb.extraContents(json);

        StickerFactory stickerFactory = new StickerFactory();

        for (Content content : contents) {            
            InputStream inputStream = new URL(content.getUrlImage()).openStream();
            String fileName =  "exit/" + content.getTitle() + ".png";

            stickerFactory.create(inputStream, fileName);

            System.out.println(content.getTitle());
            System.out.println();
        }
    }
}
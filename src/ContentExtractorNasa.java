import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ContentExtractorNasa implements ContentExtractor {
    
    public List<Content> extraContents(String json) {
        JsonParser parser = new JsonParser();
        List<Map<String, String>> attributesList = parser.parse(json);

        List<Content> contents = new ArrayList<>();

        for (Map<String, String> attribute : attributesList) {
            String title = attribute.get("title");
            String urlImage = attribute.get("url");
            Content content = new Content(title, urlImage);

            contents.add(content);
        }

        return contents;
    }
}

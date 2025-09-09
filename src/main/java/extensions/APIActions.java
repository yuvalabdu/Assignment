package extensions;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import utilities.CommonOps;


public class APIActions extends CommonOps {
    public static String fetchWikipediaPage() {
        try {
            String response = new String(conn.getInputStream().readAllBytes());
            JSONObject json = new JSONObject(response);
            String result = json.getJSONObject("parse").getJSONObject("text").getString("*");
            System.out.println("Wikipedia page fetched successfully!");
            return result;
        } catch (Exception e) {
            System.out.println("Failed to fetch Wikipedia page.");
            e.printStackTrace();
            return null;
        }
    }

    public static String extractDebuggingFeaturesText(String html) {
        Document doc = Jsoup.parse(html);

        Element debuggingDiv = doc.selectFirst("div.mw-heading3:has(h3#Debugging_features)");
        if (debuggingDiv != null) {
            Elements sectionContent = new Elements();
            sectionContent.add(debuggingDiv);

            Element next = debuggingDiv.nextElementSibling();
            while (next != null && !next.hasClass("mw-heading")) {
                sectionContent.add(next);
                next = next.nextElementSibling();
            }

            StringBuilder textOnly = new StringBuilder();
            for (Element el : sectionContent) {
                textOnly.append(el.text()).append("\n");
            }

            String result = textOnly.toString().trim();
            System.out.println("Debugging features section extracted successfully!");
            return result;
        } else {
            System.out.println("Debugging features section not found.");
            return "Debugging features section not found.";
        }
    }
}

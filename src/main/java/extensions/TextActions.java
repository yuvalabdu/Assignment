package extensions;


public class TextActions {
    public static String normalizeText(String text) {
        return text.toLowerCase()
                .replaceAll("\\[edit]", "")
                .replaceAll("[^a-z\\- ]", " ")
                .replaceAll("-", " ")
                .replaceAll("\\s+", " ")
                .trim();
    }

    public static int countWords(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        String[] words = text.split("\\s+");
        return words.length;
    }
}

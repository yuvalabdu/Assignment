package Workflows;

import extensions.UIActions;
import utilities.CommonOps;

import java.util.List;

public class Webflow extends CommonOps {
    public static String ExtractTextsFromDebuggingSection(){
        String header = UIActions.getElementText(WikipediaDebuggingSection.DebuggingSectionHeader);
        String paragraph = UIActions.getElementText(WikipediaDebuggingSection.DebuggingSectionParagraph);
        List<String> listItems = UIActions.getElementsText(WikipediaDebuggingSection.DebuggingSectionListItems);

        StringBuilder combinedText = new StringBuilder();
        combinedText.append(header).append(" ");
        combinedText.append(paragraph).append(" ");

        for (String item : listItems) {
            combinedText.append(item).append(" ");
        }

        return combinedText.toString().trim();
    }
}

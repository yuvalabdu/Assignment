package Workflows;

import extensions.APIActions;
import utilities.CommonOps;

public class ApiFlows extends CommonOps {

    public static String getDebuggingFeaturesSection() {
        String pageHtml = APIActions.fetchWikipediaPage();
        String debuggingSectionText = APIActions.extractDebuggingFeaturesText(pageHtml);
        return debuggingSectionText;
    }
}

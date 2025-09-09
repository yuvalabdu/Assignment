import Workflows.ApiFlows;
import Workflows.Webflow;
import extensions.TextActions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.CommonOps;

public class GenpactTest extends CommonOps {

    @Test
    public void test01() {
        String allTextUI = Webflow.ExtractTextsFromDebuggingSection();
        String normalUi = TextActions.normalizeText(allTextUI);
        System.out.println("UI word count: " + TextActions.countWords(normalUi));

        String debuggingText = ApiFlows.getDebuggingFeaturesSection();
        String normalApi = TextActions.normalizeText(debuggingText);
        System.out.println("API word count: " + TextActions.countWords(normalApi));

        Assert.assertEquals(
                TextActions.countWords(normalUi),
                TextActions.countWords(normalApi),
                "Word count mismatch: UI and API should have the same number of words."
        );
    }
}

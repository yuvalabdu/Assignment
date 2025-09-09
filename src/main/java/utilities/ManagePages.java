package utilities;

import org.openqa.selenium.support.PageFactory;
import pageObjects.DebuggingPage;

public class ManagePages extends CommonOps{
    public static void initWikipedia() {
        WikipediaDebuggingSection = PageFactory.initElements(driver, DebuggingPage.class);
    }
}

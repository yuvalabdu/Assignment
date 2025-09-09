package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utilities.CommonOps;

import java.util.List;

public class DebuggingPage extends CommonOps {
    @FindBy(how = How.ID,using ="Debugging_features")
    public WebElement DebuggingSectionHeader;

    @FindBy(how = How.XPATH,using ="//*[@id='mw-content-text']/div[1]/p[13]")
    public WebElement DebuggingSectionParagraph;

    @FindBy(how = How.XPATH, using = "//*[@id='mw-content-text']/div[1]/ul[2]/li")
    public List<WebElement> DebuggingSectionListItems;

}

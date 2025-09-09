package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

import java.util.ArrayList;
import java.util.List;

public class UIActions extends CommonOps {

    public static void click(WebElement elem){
        elem.click();
    }
    @Step("Update Text Element")
    public static void updateText(WebElement elem, String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }

    @Step("Get text from element")
    public static String getElementText(WebElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        String text = elem.getText();
        System.out.println("Extracted text from element: \"" + text + "\"");
        return text;
    }

    @Step("Get text from list of elements")
    public static List<String> getElementsText(List<WebElement> elements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));

        List<String> texts = new ArrayList<>();

        for (WebElement elem : elements) {
            String text = elem.getText().trim();
            System.out.println("Extracted text from element: \"" + text + "\"");
            texts.add(text);
        }

        return texts;
    }

}

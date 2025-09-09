package utilities;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.DebuggingPage;

import java.net.HttpURLConnection;


public class Base {
    protected static WebDriverWait wait;
    protected static Actions actions;
    protected static RequestSpecification httpRequest;
    protected static Response response;
    protected static WebDriver driver;
    protected static DebuggingPage WikipediaDebuggingSection;
    protected static HttpURLConnection conn;
}

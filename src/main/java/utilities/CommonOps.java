package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.Duration;

public class CommonOps extends Base{

    public static void initBrowser(String browserType) {
        if (browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if (browserType.equalsIgnoreCase("firefox"))
            driver = initFirefoxDriver();
        else if (browserType.equalsIgnoreCase("ie"))
            driver = initIEDriver();
        else
            throw new RuntimeException("Invalid browser type");


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://en.wikipedia.org/wiki/Playwright_(software)#Debugging_features");
        ManagePages.initWikipedia();
        actions = new Actions(driver);
    }

      public static WebDriver initChromeDriver() {
         WebDriverManager.chromedriver().setup();
         WebDriver driver = new ChromeDriver();
         return driver;
    }

     public static WebDriver initFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    public static WebDriver initIEDriver() {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }


    public static HttpURLConnection initAPI(String pageTitle) {
        try {
            String encodedTitle = URLEncoder.encode(pageTitle, "UTF-8");
            URL url = new URL("https://en.wikipedia.org/w/api.php?action=parse&page="
                    + encodedTitle + "&prop=text&format=json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");

            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @BeforeClass
    public static void StartSession(){
        initBrowser("Chrome");
        Base.conn = initAPI("Playwright_(software)");
    }

    @AfterClass
    public static void CloseSession(){
        driver.quit();
    }

}


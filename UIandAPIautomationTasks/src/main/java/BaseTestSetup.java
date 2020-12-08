import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class BaseTestSetup{

    public static WebDriver driver;
    public static String appURL = "https://www.credify.tech/phone/nonDMFunnel";

    //initializing browser and navigating to the Application
    public void initializeApplication(){
        Reporter.log("App started...", true);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.navigate().to(appURL);
    }

    //closing the browser session
    public void closeApplication(){
        driver.quit();
        Reporter.log("App Ended...", true);
    }

}

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class LoanOfferPage extends BaseTestSetup{

    String bOfferLoanAmount = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/span[2]")).getText();
    String bOfferMonthlyPayment = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]")).getText();
    String bOfferLoanTerm = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]")).getText();
    String bOfferLoanInterestRate = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]")).getText();
    String bOfferAPR = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]")).getText();


    WebElement menu_button = driver.findElement(By.xpath("//*[contains(@class,'header-nav-menu')]"));
    WebElement signOut_button = driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]"));


    public LoanOfferPage(){
        super();
    }

    public void signOutFromLoanOfferPage(){
        JavascriptExecutor menu_button_executor = (JavascriptExecutor) driver;
        menu_button_executor.executeScript("arguments[0].click();", menu_button);
        JavascriptExecutor signOut_button_executor = (JavascriptExecutor) driver;
        signOut_button_executor.executeScript("arguments[0].click();", signOut_button);
    }
}

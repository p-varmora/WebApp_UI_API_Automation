import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BorrowerPortalLoginPage extends BaseTestSetup{

    WebElement userName_textBox = driver.findElement(By.xpath("//*[contains(@name,'username')]"));
    WebElement password_textBox = driver.findElement(By.xpath("//*[contains(@name,'password')]"));
    WebElement signIn_button = driver.findElement(By.xpath("//*[contains(text(),'Sign in to your account')]"));

    public BorrowerPortalLoginPage(){
        super();
    }

    public void borrowerPortal_userName_passWord(String bEmail, String bPassWord){
        userName_textBox.sendKeys(bEmail);
        password_textBox.sendKeys(bPassWord);
    }

    public void signInToBorrowerPortal(){
        signIn_button.click();
    }

}

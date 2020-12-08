import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CreateBorrowerAccountPage extends BaseTestSetup{

    WebElement borrowerUserName_textBox = driver.findElement(By.xpath("//*[contains(@name,'username')]"));
    WebElement borrowerPassword_textBox = driver.findElement(By.xpath("//*[contains(@name,'password')]"));
    WebElement agreements_checkBox = driver.findElement(By.xpath("//*[contains(@class,'sc-xGAYn sc-dWBSoC cRGvbh czwUhv')]"));
    WebElement finalCheckYourRate_button = driver.findElement(By.xpath("//*[contains(@class,'sc-gXfWUo kPkGiO section')]"));

    public CreateBorrowerAccountPage(){
        super();
    }

    public void fillBorrower_userName_passWord(String bEmail, String bPassword){
        borrowerUserName_textBox.sendKeys(bEmail);
        borrowerPassword_textBox.sendKeys(bPassword);
    }

    public void checkAgreements(){
        agreements_checkBox.click();
    }

    public void clickOnFinalRateCheckButton(){
        finalCheckYourRate_button.click();
    }
}

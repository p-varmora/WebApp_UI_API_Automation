import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class BorrowerApplicationFormPage extends BaseTestSetup {

    WebElement borrowerFirstName_textBox = driver.findElement(By.xpath("//*[contains(@name,'borrowerFirstName')]"));
    WebElement borrowerLastName_textBox = driver.findElement(By.xpath("//*[contains(@name,'borrowerLastName')]"));
    WebElement borrowerAddress_textBox = driver.findElement(By.xpath("//input[@id='geosuggest__input--borrowerStreet']"));
    WebElement borrowerCity_textBox = driver.findElement(By.xpath("//*[contains(@name,'borrowerCity')]"));
    WebElement borrowerState_textBox = driver.findElement(By.xpath("//*[contains(@name,'borrowerState')]"));
    WebElement borrowerZipCode_textBox = driver.findElement(By.xpath("//*[contains(@name,'borrowerZipCode')]"));
    WebElement borrowerDateOfBirth_textBox = driver.findElement(By.xpath("//*[contains(@name,'borrowerDateOfBirth')]"));
    WebElement continue_button = driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));


    public BorrowerApplicationFormPage(){
        super();
    }

    public void fillBorrowerFirstName_LastName(String bFirstName, String bLastName){
        borrowerFirstName_textBox.sendKeys(bFirstName);
        borrowerLastName_textBox.sendKeys(bLastName);
    }

    public void fillBorrower_Address(String bAddress){
        borrowerAddress_textBox.sendKeys(bAddress);
        borrowerAddress_textBox.sendKeys(Keys.RETURN);
    }

    public void fillBorrower_city_state_zipCode(String bCity, String bState, String bZipcode){
        borrowerCity_textBox.clear();
        borrowerCity_textBox.sendKeys(bCity);
        borrowerState_textBox.clear();
        borrowerState_textBox.sendKeys(bState);
        borrowerZipCode_textBox.clear();
        borrowerZipCode_textBox.sendKeys(bZipcode);
    }

    public void fillBorrower_birthDate(String bBirthDate){
        borrowerDateOfBirth_textBox.sendKeys(bBirthDate);
    }

    public void clickOnContinueButton(){
        continue_button.click();
    }
}

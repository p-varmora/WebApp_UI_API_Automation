import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class BorrowerIncomeInfoPage extends BaseTestSetup{

    WebElement borrowerIncome_textBox = driver.findElement(By.xpath("//*[contains(@name,'borrowerIncome')]"));
    WebElement borrowerAdditionalIncome_textBox = driver.findElement(By.xpath("//*[contains(@name,'borrowerAdditionalIncome')]"));

    public BorrowerIncomeInfoPage(){
        super();
    }

    public void fillBorrowerIncomeInfo(String bIncome, String bAdditionalIncome){
        borrowerIncome_textBox.sendKeys(bIncome);
        borrowerAdditionalIncome_textBox.sendKeys(bAdditionalIncome);
        borrowerAdditionalIncome_textBox.sendKeys(Keys.RETURN);
    }

}

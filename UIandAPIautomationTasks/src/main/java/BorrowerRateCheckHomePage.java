import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BorrowerRateCheckHomePage extends BaseTestSetup{

    WebElement loanAmount_textBox = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"));
    WebElement loanPurposes_dropDown = driver.findElement(By.xpath("//body/div[@id='root']/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/select[1]"));
    WebElement checkYourRate_button = driver.findElement(By.xpath("//button[contains(text(),'Check your rate')]"));


    public BorrowerRateCheckHomePage(){
        super();
    }

    public void fillBorrowerLoanAmountAndLoanPurposeInfo(String loanAmount, int selectLoanPurposeOptions){
        loanAmount_textBox.sendKeys(loanAmount);
        loanPurposes_dropDown.click();
        selectLoanPurposesOptions(selectLoanPurposeOptions);
    }

    public void selectLoanPurposesOptions(int loanPurposeOptions){
        Select loanPurposes_options = new Select(loanPurposes_dropDown);
        loanPurposes_options.selectByIndex(loanPurposeOptions);
    }

    public void clickOnCheckYourRateButton(){
        checkYourRate_button.click();
    }

}

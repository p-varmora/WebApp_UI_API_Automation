import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class UITest extends BaseTestSetup {

     /*
    UserStory : Verfiy via the UI that As Borrower - you are seeing loan offers,
                upon filling the required form fields with valid inputs.

Automation Steps :
1.Launch the browser with “https://www.credify.tech/portal/login”
2.Fill the loan Amount and select the purposes and Click the "Check your rate" button
3.Fill the Borrower basic information based on User Story acceptance criteria
4.Fill the Income info based on User Story acceptance criteria
5.Create Borrower Account and
6.Log Out from Menu option of Loan offer Page
7.Login into the Borrower Account via "https://www.credify.tech/portal/login"
8.Borrower logged successfully Into the Portal with valid credentials
9.Validate the Borrower's LoanAmount, MonthlyPayment, LoanTerm, LoanInterestRate, APR matches with
  previously stored info the default offer from the top of the offer-Page
10.Validate that Borrower is on Loan Offer Page

 */

    private BorrowerRateCheckHomePage borrowerRateCheckHomePage;
    private BorrowerApplicationFormPage borrowerApplicationFormPage;
    private BorrowerIncomeInfoPage borrowerIncomeInfoPage;
    private CreateBorrowerAccountPage createBorrowerAccountPage;
    private LoanOfferPage loanOfferPage;
    private BorrowerPortalLoginPage borrowerPortalLoginPage;
    public static String borrowerPortalApp = "https://www.credify.tech/portal/login";


    public UITest(){
        super();
    }

    @Test
    public void validateThat_offerPageLoanInfo_matchesWith_BorrowerPortalPageLoanInfo() {

        initializeApplication();
        Reporter.log("navigate to the credify homepage", true);

        Reporter.log("fill the Borrower loan amount info", true);
        borrowerRateCheckHomePage = new BorrowerRateCheckHomePage();
        borrowerRateCheckHomePage.fillBorrowerLoanAmountAndLoanPurposeInfo("3000", 3);
        borrowerRateCheckHomePage.clickOnCheckYourRateButton();

        Reporter.log("fill the Borrower application info", true);
        borrowerApplicationFormPage = new BorrowerApplicationFormPage();
        borrowerApplicationFormPage.fillBorrowerFirstName_LastName("Parth", "QAEngineer");
        borrowerApplicationFormPage.fillBorrower_Address("275 Battery St");
        borrowerApplicationFormPage.fillBorrower_city_state_zipCode("San Francisco", "CA","94111");
        borrowerApplicationFormPage.fillBorrower_birthDate("10101992");
        borrowerApplicationFormPage.clickOnContinueButton();

        Reporter.log("fill the Borrower income info", true);
        borrowerIncomeInfoPage = new BorrowerIncomeInfoPage();
        borrowerIncomeInfoPage.fillBorrowerIncomeInfo("135000", "6500");

        Reporter.log("create the Borrower Account", true);
        createBorrowerAccountPage = new CreateBorrowerAccountPage();
        createBorrowerAccountPage.fillBorrower_userName_passWord("Parth9091@upgrade-challenge.com", "TESLAmodel3");
        createBorrowerAccountPage.checkAgreements();
        createBorrowerAccountPage.clickOnFinalRateCheckButton();

        driver.manage().timeouts().implicitlyWait(02, TimeUnit.MINUTES);
        Reporter.log("sign out from the menu option", true);
        loanOfferPage = new LoanOfferPage();
        loanOfferPage.signOutFromLoanOfferPage();

        Reporter.log("navigate to the Borrower account login portal", true);
        driver.navigate().to(borrowerPortalApp);

        Reporter.log("Borrower log into the portal", true);
        borrowerPortalLoginPage = new BorrowerPortalLoginPage();
        borrowerPortalLoginPage.borrowerPortal_userName_passWord("Parth9091@upgrade-challenge.com", "TESLAmodel3");
        borrowerPortalLoginPage.signInToBorrowerPortal();

        driver.manage().timeouts().implicitlyWait(02, TimeUnit.MINUTES);

        Reporter.log("validate that loan info matches with previously stored info", true);
        validate_offerPageLoanInfo_matchesWith_BorrowerPortalPageLoanInfo();

        Reporter.log("validate that Borrower is on Loan offer page", true);
        validate_user_on_LoanOfferPage();

        closeApplication();
    }

    //This method checks user is on Offer-Page
    public void validate_user_on_LoanOfferPage(){
        Assert.assertTrue(driver.getTitle().contains("Affordable Online Personal Loans | Upgrade"));
    }

    /*
    This method checks borrower's LoanAmount, MonthlyPayment, LoanTerm, LoanInterestRate, APR matches with
    previously stored info the default offer from the top of the offer-Page
    */
    public void validate_offerPageLoanInfo_matchesWith_BorrowerPortalPageLoanInfo(){
        Assert.assertEquals(loanOfferPage.bOfferLoanAmount, new BorrowerPortalLoanOfferPage().borrower_portalLoanAmount);
        Assert.assertEquals(loanOfferPage.bOfferMonthlyPayment, new BorrowerPortalLoanOfferPage().borrower_portalMonthlyPayment);
        Assert.assertEquals(loanOfferPage.bOfferLoanTerm, new BorrowerPortalLoanOfferPage().borrower_portalLoanTerm);
        Assert.assertEquals(loanOfferPage.bOfferLoanInterestRate, new BorrowerPortalLoanOfferPage().borrower_portalLoanInterestRate);
        Assert.assertEquals(loanOfferPage.bOfferAPR, new BorrowerPortalLoanOfferPage().borrower_portalAPR);
    }
}



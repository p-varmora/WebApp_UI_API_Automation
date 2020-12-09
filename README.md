### Upgrade_Website_Functionality
As an independent auditor to verify the certain functionality of upgrade website. 

###UI Scenario : 

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

 ----------------------------------------------------------------------------------------------------------------------------------------------------------------
###API Tests
 
1. validate that for correct credentials provided in the payload below the API response code is 200 (OK)

2.For the above use case, parse each json value in the response payload individually. Then validate the producttype attribute has value PERSONAL_LOAN

3.Validate that in the initail POST request, if a different username is provided (that doesnt exist in our system)-the API response is a 401 (Unauthorized)

-----------------------------------------------------------------------------------------------------------------------------------------------------------

Ive followed page object design pattern for UI and API test. 

UI Test code walk through : for each page I've created a sperate class with constructor. I've put Page classes in java package and Test Class in Test package. 



1.BaseTestSetup.java - for initializing webdriver, browser and navigating to the Application "https://www.credify.tech/phone/nonDMFunnel"

it has below methods : 
1.initializeApplication()
2.closeApplication() 

2.BorrowerRateCheckHomePage.java - for locating and storing webElements specific to this page and it has three methods to filling the borrower loan amount and purposes details 

it has below methods : 
1.initializeApplication()
2.closeApplication() 

3.BorrowerApplicationFormPage.java - for locating and storing webElements specific to this page and it has five methods to filling the borrower application
it has below methods : 
1.fillBorrowerFirstName_LastName()
2.fillBorrower_Address() 
3.fillBorrower_city_state_zipCode()
4.fillBorrower_birthDate()
5.clickOnContinueButton()

4.BorrowerIncomeInfoPage.java - for locating and storing webElements specific to this page and it has one methods to filling the borrower income

it has below method : 
1.fillBorrowerIncomeInfo()
 
5.BorrowerPortalLoanOfferPage.java - for locating and storing webElements specific to this page for validating purpose 

6.BorrowerPortalLoginPage.java - for locating and storing webElements specific to this page and it has two methods to login into portal

it has below methods : 
1.borrowerPortal_userName_passWord()
2.signInToBorrowerPortal() 

7.CreateBorrowerAccountPage.java - for locating and storing webElements specific to this page and it has three methods to create the borrower account

it has below methods : 
1.fillBorrower_userName_passWord()
2.checkAgreements() 
3.clickOnFinalRateCheckButton()

8.LoanOfferPage.java - for locating and storing webElements specific to this page and it has one method for signing out from offer page

it has below method : 
1.signOutFromLoanOfferPage()


9.UITest.java - for running UI test scenario and validating it. 

------------------------------------------------------------------------------------------------------------------------------------------------------------------------

API test code walk through: 

1. CredapiRestClient.java - for creating rest client for Post call request 

2. APITest.java - for running and validating API tests 


Yes - I used Java, Selenium, TestNG and Maven! 

Notes: I haven't included any additional validation. also in order to validate  the productType attribute has value PERSONAL_LOAN - i haven't parsed each json value in the response payload individually. API response is big so I skipped POJO process. 

Thank you!
 
 
 

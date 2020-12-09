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


 
 
 
 

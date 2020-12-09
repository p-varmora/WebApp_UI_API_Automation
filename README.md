### Upgrade_Website_Functionality
As an independent auditor to verify the certain functionality of upgrade website. 

###UI Scenario : 
-----
    UserStory : Verfiy via the UI that As Borrower - you are seeing loan offers,
                upon filling the required form fields with valid inputs.

Automation Steps :
----
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

 
###API Tests
-----------------

/*

Write the test that makes the post request to API mentionned in the user story. 

*/


Automation Steps: 
 
###Test 1. validate that for correct credentials provided in the payload below the API response code is 200 (OK)
----------------------------------------------------------------------------------------------------------------

1.create a rest client for Post Request

2.hit the server with valid headers, end-point, and payLoad through restclient object 

3. strore the status code in variable and validate it with expected status code

###Test 2.For the above use case, parse each json value in the response payload individually. Then validate the producttype attribute has value PERSONAL_LOAN
---------------------------------------------------------------------------------------------------------------------------------------------------------

1.create a rest client for Post Request

2.hit the server with valid headers, end-point, and payLoad through restclient object 

3.strore the api response in string

4.create jsonObject from string

5.look for specific jsonArray for productType attribute

6.fetch the productType attribute value and validate that it has value PERSONAL_LOAN


###Test 3.Validate that in the initail POST request, if a different username is provided (that doesnt exist in our system)-the API response is a 401 (Unauthorized)
----------------------------------------------------------------------------------------------------------------------------------------------------------

1.create a rest client for Post Request

2.hit the server with a different username is provided (that doesnt exist in our system through restclient object 

3. strore the status code in variable and validate it with expected status code

-----------------------------------------------------------------------------------------------------------------------------------------------------------

Ive followed page object design pattern for UI and API test. 

###UI Test code walk through : for each page I've created a sperate class with constructor. I've put Page classes in java package and Test Class in Test package. 
------------------------------


1.BaseTestSetup.java - for initializing webdriver, browser and navigating to the Application "https://www.credify.tech/phone/nonDMFunnel"
-----------------
it has below methods : 

1.initializeApplication()

2.closeApplication() 

2.BorrowerRateCheckHomePage.java - for locating and storing webElements specific to this page and it has three methods to filling the borrower loan details
--------                           

it has below methods : 

1.initializeApplication()

2.closeApplication() 

3.BorrowerApplicationFormPage.java - for locating and storing webElements specific to this page and it has five methods to filling the borrower application
------

it has below methods : 

1.fillBorrowerFirstName_LastName()

2.fillBorrower_Address() 

3.fillBorrower_city_state_zipCode()

4.fillBorrower_birthDate()

5.clickOnContinueButton()

4.BorrowerIncomeInfoPage.java - for locating and storing webElements specific to this page and it has one methods to filling the borrower income
---------
it has below method : 

1.fillBorrowerIncomeInfo()
 
5.BorrowerPortalLoanOfferPage.java - for locating and storing webElements specific to this page for validating purpose 
------
6.BorrowerPortalLoginPage.java - for locating and storing webElements specific to this page and it has two methods to login into portal
-----
it has below methods : 

1.borrowerPortal_userName_passWord()

2.signInToBorrowerPortal() 

7.CreateBorrowerAccountPage.java - for locating and storing webElements specific to this page and it has three methods to create the borrower account
--------
it has below methods : 

1.fillBorrower_userName_passWord()

2.checkAgreements() 

3.clickOnFinalRateCheckButton()

8.LoanOfferPage.java - for locating and storing webElements specific to this page and it has one method for signing out from offer page
------
it has below method : 

1.signOutFromLoanOfferPage()


###UITest.java - for running UI test scenario and validating it. 
------------------------------------------------------------------

test - validateThat_offerPageLoanInfo_matchesWith_BorrowerPortalPageLoanInfo()
---------------------------------------------------------------------------

it has below methods for validating : 

1.validate_user_on_LoanOfferPage()

2.validate_offerPageLoanInfo_matchesWith_BorrowerPortalPageLoanInfo()

-----------------------------------------------------------------------------------------------------------------------------------------------------------------

###API test code walk through: 
----------------------------

1. CredapiRestClient.java - for creating rest client for Post call request 

###APITest.java - for running and validating API tests 
----------------------------------------------------

test 1 - validate_withCorrectCredentials_apiResponse200()

test 2 - validate_withCorrectCredentials_productTypeAttribute()

test 3 - validate_withUserNameDoesntExistInDB_apiResponse401()

-----------------------------------------------------------------------------------------------------------------------------------------------------------------
###Yes - I used Java, Selenium, chromedriver,  TestNG and Maven! 
-----
###Notes: I haven't included any additional validation. also in order to validate  the productType attribute has value PERSONAL_LOAN - i haven't parsed each json value in the response payload individually. API response is big so I skipped POJO process. 


Test Logs : 
----------

/Users/p_varmora/Library/Java/JavaVirtualMachines/openjdk-15.0.1/Contents/Home/bin/java -Dmaven.multiModuleProjectDirectory=/Users/p_varmora/IdeaProjects/Upgrade_Website_Functionality/UIandAPIautomationTasks "-Dmaven.home=/Applications/IntelliJ IDEA CE.app/Contents/plugins/maven/lib/maven3" "-Dclassworlds.conf=/Applications/IntelliJ IDEA CE.app/Contents/plugins/maven/lib/maven3/bin/m2.conf" "-Dmaven.ext.class.path=/Applications/IntelliJ IDEA CE.app/Contents/plugins/maven/lib/maven-event-listener.jar" "-javaagent:/Applications/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar=63034:/Applications/IntelliJ IDEA CE.app/Contents/bin" -Dfile.encoding=UTF-8 -classpath "/Applications/IntelliJ IDEA CE.app/Contents/plugins/maven/lib/maven3/boot/plexus-classworlds.license:/Applications/IntelliJ IDEA CE.app/Contents/plugins/maven/lib/maven3/boot/plexus-classworlds-2.6.0.jar" org.codehaus.classworlds.Launcher -Didea.version=2020.2.3 test
[INFO] Scanning for projects...
[WARNING] 
[WARNING] Some problems were encountered while building the effective model for org.example:WebScenario:jar:1.0-SNAPSHOT
[WARNING] 'dependencies.dependency.(groupId:artifactId:type:classifier)' must be unique: org.testng:testng:jar -> duplicate declaration of version 6.14.3 @ line 62, column 21
[WARNING] 'dependencies.dependency.(groupId:artifactId:type:classifier)' must be unique: org.testng:testng:jar -> duplicate declaration of version 6.14.3 @ line 68, column 21
[WARNING] 
[WARNING] It is highly recommended to fix these problems because they threaten the stability of your build.
[WARNING] 
[WARNING] For this reason, future Maven versions might no longer support building such malformed projects.
[WARNING] 
[INFO] 
[INFO] ----------------------< org.example:WebScenario >-----------------------
[INFO] Building WebScenario 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ WebScenario ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 0 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ WebScenario ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 9 source files to /Users/p_varmora/IdeaProjects/Upgrade_Website_Functionality/UIandAPIautomationTasks/target/classes
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ WebScenario ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /Users/p_varmora/IdeaProjects/Upgrade_Website_Functionality/UIandAPIautomationTasks/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ WebScenario ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 2 source files to /Users/p_varmora/IdeaProjects/Upgrade_Website_Functionality/UIandAPIautomationTasks/target/test-classes
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ WebScenario ---
[INFO] Surefire report directory: /Users/p_varmora/IdeaProjects/Upgrade_Website_Functionality/UIandAPIautomationTasks/target/surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running TestSuite
Configuring TestNG with: org.apache.maven.surefire.testng.conf.TestNG652Configurator@12bc6874
App started...
------
Starting ChromeDriver 87.0.4280.88 (89e2380a3e36c3464b5dd1302349b1382549290d-refs/branch-heads/4280@{#1761}) on port 21495
Only local connections are allowed.
Please see https://chromedriver.chromium.org/security-considerations for suggestions on keeping ChromeDriver safe.
ChromeDriver was started successfully.
Dec 08, 2020 10:08:37 PM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: W3C

navigate to the credify homepage
-----
fill the Borrower loan amount info
----
fill the Borrower application info
---
fill the Borrower income info
---
create the Borrower Account
-----
sign out from the menu option
---
navigate to the Borrower account login portal
----
Borrower log into the portal
--
validate that loan info matches with previously stored info
-
validate that Borrower is on Loan offer page
--
App Ended...
--
Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 36.768 sec
---

Results :
-----

Tests run: 4, Failures: 0, Errors: 0, Skipped: 0
---------------

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  42.876 s
[INFO] Finished at: 2020-12-08T22:09:10-08:00
[INFO] ------------------------------------------------------------------------


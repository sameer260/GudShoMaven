Feature: To check Studio Settings and Studio Preview

Background: Redirection to My Studio Page
Given Click on profile and click on My Studio


Scenario: To check studio info in studio Preview Page
Given Gather all studio Info in My studio page and check the same in Studio Preview page

Scenario Outline: To check the Visibilty of Studio On frontend
Given visibility of studio to <visibility>
When Go to frontend and search the studio

Examples:
|visibility|
|Private|
|Public|


Scenario: To check Studio Settings
Given Check the studio settings slide bar is opened
When The File Supported text is showing
Then Check all the field Names are displaying
And Edit the Studio Profile image


Scenario: To check description field
Given Enter more description and check the chracters count are showing


Scenario Outline: To check the Studio description and Social icon fields
Given Open the Studio Settings
Then Check all the placeholders of the social icon fields
And Check the error messages with <invalid urls>


Examples:
|invalid urls|
|https:|
|facebook|
|facebook.com|
|.com|


Scenario Outline: To check the Visibilty of Studio On frontend
Given Open the Studio Settings
When visibility of studio to <visibility>
And Save the profile
Then Go to frontend and search the studio

Examples:
|visibility|
|Private|
|Public|


Scenario Outline: To check the studio owner name functionality
Given Open the Studio Settings
And The Studio owner name field name as "Studio Owner Name*"
When clear the studio owner name and check the error message as "Studio Owner Name is required"
And Check the studio owner name placeholder
Then Enter space in the filed and check the <error message>
And Enter single digit and check the <error message>
Then Enter valid Studio owner name as "Sameer"
And Save the profile

Examples:
|error message|
|Minimum 3 characters allowed|


Scenario Outline: To check the studio Email functionality
Given Open the Studio Settings
Then The field name should be display as "Email Address*"
When Clear the Email field and check the errormessage as "Email must be a valid email address"
And Check the Email id placeholder
Then Edit the Email address and give <invalid email>
And check the <invalid error message>
Then Give valid Email id as "sameer3434@yopmail.com"
And Save the profile

Examples:
|invalid email|invalid error message|
|sameer@|Email must be a valid email address|
|sameer|Email must be a valid email address|
|sameer@gmail|Email must be a valid email address|
|sameer@gmail.|Email must be a valid email address|
|sameer@gmailcom|Email must be a valid email address|


Scenario: To check the studio phone number functionality
Given Open the Studio Settings
When Check Studio phone number field should diaplay as "Phone Number*"
Then Edit the phone number field
And check request otp button is disabled


Scenario: To check Studio Address Functionality
Given Open the Studio Settings
When Check the Studio Address Field should display as "Studio Address*"
When Check all the Placeholders
Then Enter Studio Address in to the field
And Save the profile


 

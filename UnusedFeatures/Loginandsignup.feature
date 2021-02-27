@undev @nohook
Feature: Login and SignUp functonality

Background: Launch browser and signin
Given Launch the browser and go to login page

Scenario: To check the Sigin page is displayed
Given in email field verify the placeholder
Then in password field verify the placeholder
Then The Signin button and requestotp button should be displayed
Then the forgotpassword link will display
Then the Signup label or link should be display
Then the facebook and gmail login should be display
Then the Signin and request otp buttons should be disabled before input

 
Scenario Outline: Removing backspace in mobile number field
Given enter the <phonenumber> in the emailfield
When press or remove the one letter or number

Examples:
|phonenumber|
|9542840|
|sameer239|


Scenario: Enter Space in the fields 
Given give space in the mail field
Then the Signin and request otp buttons should be disabled before input 


Scenario Outline: Without password check the validation error
Given give <phonenumber> in the mobile field
When click on submit button
Then <errormessage> should display 

Examples:
|phonenumber|errormessage|
|9542840307|Please enter password|


Scenario Outline: After entering the credentials again backsapce and submit
Given enter the <phonenumber> and <password> in the fields
When give backspace in both email and paswword
When click on submit button
Then <errormessage> should display

Examples:
|phonenumber|password|errormessage|
|9542840307|sameer6789|Incorrect Password, Please try again|


Scenario Outline: to check after credentials the sigin and request otps buttons should be disable
Given enter the <phonenumber> and <password> in the fields
Then the sigin and requestotps buttons showuld be enable

Examples:
|phonenumber|password|
|9542840307|sameer6789|


Scenario Outline: to check after credentials and again clear the fields
Given enter the <phonenumber> and <password> in the fields
When Clear the fields
Then the Signin and request otp buttons should be disabled before input

Examples:
|phonenumber|password|
|9542840307|sameer6789|


Scenario Outline: To check after passsowrd the Eye icon is displayed
Given enter the <phonenumber> and <password> in the fields
Then The eye icon should be displayed
And Click on the eye icon

Examples:
|phonenumber|password|
|9542840307|sameer|

Scenario Outline: Invalid Phone number and password
Given enter the <phonenumber> and <password> in the fields
When click on submit button
Then <errormessage> should display

Examples:
|phonenumber|password|errormessage|
|9542|sameer6789|Please enter valid mobile number|
|9542840307|sameer67|Incorrect Password, Please try again|
|9542840307|samee|Password must be at least 8 characters|
|sameer|sameer|Please enter valid email address|
|@#$%^&&@^@|sameer12|Please enter valid email address|
|954@#$%%^|sameer12|Please enter valid email address|
|sameer239gmail.com|sameer12|Please enter valid email address|


Scenario Outline: For first time login the page sould redirect to the sigup page and sigin link
Given enter the <phonenumber> and <password> in the fields
When click on submit button
Then it will redirect tologin page there should display text and ph number field
And Click on sigin link it should redirect again to back

Examples:
|phonenumber|password|
|9874646|sameer567|
|sksam236@gmail.com|sameer456|


Scenario Outline: Login with OTP
Given enter the <phonenumber> and <password> in the fields
When click on request otp
And verify the <toastmessage>
Then enter otp in the otp field

Examples:
|phonenumber|password|toastmessage|
|9542840307|sameer6789|hdhsdhsd|


Scenario Outline: Forgot password
Given enter the <phonenumber> and <password> in the fields
When click on forgot link
And verify the <toastmessage>

Examples:
|phonenumber|password|toastmessage|
|9542840307|sameer6789|hdhsdhsd|


Scenario Outline: New Registration without clicking on sign up link
Given enter the <phonenumber> and <password> in the fields
When click on submit button
And Cick on getotp button
And verify the <toastmessage>
And check the <phonenumber> is displaying correctly and click on otp button

Examples:
|phonenumber|password|toastmessage|
|9573875793|sameer6789|sjdhsjdhsjs|


Scenario Outline: Sign Up new with phone number
Given click on sign up link
And Cick on getotp button
Then <errormessage> should display 

Examples:
|errormessage|
|Mobile Number is required|

Scenario Outline: Sign Up new with phone number
Given click on sign up link
When Enter the <phonenumber>
And Cick on getotp button
Then <errormessage> should display 

Examples:
|phonenumber|errormessage|
|957|Please enter valid mobile number|
|967546345678|Please enter valid mobile number|

Scenario Outline: Sign Up new with phone number
Given click on sign up link
Then Enter the <phonenumber>
And Cick on getotp button
And verify the <toastmessage>
And check the <phonenumber> is displaying correctly and click on otp button

Examples:
|phonenumber|
|9573875793|


Scenario Outline: Verification of Change Password
Given enter the <phonenumber> and <password> in the fields
When click on submit button
Given Mouse hover on the profile icon lefside of the page
When Click on Account & Settings tab
Given Click on change password link
When Enter old password as <inputoldpassword>
And  input <inputnewpassword> and <inputconfirmpassword>
Then Save the password
Then verify the <toastmessage>
Given Mouse hover on the profile icon lefside of the page
Then check the oldpassword is working or not
Given enter the <phonenumber> and <password> in the fields
When click on submit button
Then <errormessage> should display 


Examples:
|phonenumber|password|inputoldpassword|inputnewpassword|inputconfirmpassword|toastmessage|errormessage|
|9542840307|sameer6789|sameer6789|sameer1234|sameer1234|Password successfully updated|Incorrect Password, Please try again|



Scenario Outline: Login with new password  
Given enter the <phonenumber> and <password> in the fields
When click on submit button
Given Mouse hover on the profile icon lefside of the page
When Click on Account & Settings tab
Given Click on change password link
When Enter old password as <inputoldpassword>
And  input <inputnewpassword> and <inputconfirmpassword>
Then Save the password
Then verify the <toastmessage>

Examples:
|phonenumber|password|inputoldpassword|inputnewpassword|inputconfirmpassword|toastmessage|
|9542840307|sameer1234|sameer1234|sameer6789|sameer6789|Password successfully updated|














@test
Scenario: Verify Login Page Elements
	Then verify all login page elements
	Then verify all login page buttons

 
  @test  
Scenario: Click on and signUp and verify the elements
    When Verify all screen elemets


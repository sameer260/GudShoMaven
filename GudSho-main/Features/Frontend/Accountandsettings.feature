Feature: Functonality of Account & Settings Module


Background: Verification of MyProfile Module 
Given Mouse hover on the profile icon lefside of the page
When Click on Account & Settings tab
Then Verify My profile is displaying


Scenario Outline: In valid input in the name field
Given invalid input in the name field as <name>
When save the profile clicking on save button
Then <errormessage> should display

Examples:
|name   |errormessage           |
|@#$$$sa|Only characters allowed|
|2323244|Only characters allowed|


Scenario Outline: less than 3 chracters
Given invalid input in the name field as <name>
When save the profile clicking on save button
Then the name field should show <errormessage>  

Examples:
|name|errormessage                |
|Sa  |Minimum 3 characters allowed|


Scenario Outline: Invalid input in the email field
Given invalid email in the email field as <emailid>
When save the profile clicking on save button
Then <errormessage> should display

Examples:
|emailid          |errormessage                    |
|sameer23gmail.com|Please enter valid email address|
|sameer@     |Please enter valid email address|


Scenario Outline: Empty dob verification
Given Give empty DOB in the field
When save the profile clicking on save button
Then date of birth <errormessage> will display

Examples:
|errormessage             |
|Please enter a valid date|


Scenario Outline: set date of birth by using calender icon  
Given Set DOB using calendor icon as <year> and <month> and <date>
When save the profile clicking on save button
Then verify the <toastmessage>

Examples:
|year|month|date|toastmessage                              |
|1995|JAN  |19  |Your Profile has been updated successfully|


Scenario Outline: upload the profile pic with valid resoultion
Given Upload the profile picture which is having <filename>
When Upload the image by clicking on submit button
Then verify the <toastmessage>

Examples:
|filename  |toastmessage                                      |
|Fileupload|Your profile picture has been updated successfully|


Scenario Outline: upload the profile pic with valid resoultion
Given Upload the profile picture which is having <filename>
When Upload the image by clicking on cancel button


Examples:
|filename  |
|Fileupload|


Scenario Outline: upload the profile pic with invalid resoultion
Given Upload the profile picture which is having <filename>
Then verify the <toastmessage>

Examples:
|filename                |toastmessage                          |
|accountprofileinvalidres|Minimum resolution should be 400 * 400|
 

Scenario Outline: Editing fields in My Profile
Given complete the profile with <name>and <gender> and <dob> and <emailid>
When save the profile clicking on save button
Then verify the <toastmessage>
 
Examples:
|name  |gender |dob       | emailid           |   toastmessage                               |
|Sameer|Others |10101991| sameer@contus.in  |Your Profile has been updated successfully    |
|Sameer|Female |01101996| sameer@yopmail.com|Your Profile has been updated successfully    |
|Sameer|Male   |19101991| sameer239@yopmail.com|Your Profile has been updated successfully |
 

Scenario: Verification of placeholders in Change password tab
Given Click on change password link
When Check the all fields placeholders


Scenario Outline: Verifying change password with invalid old password
Given Click on change password link
When Enter old password as <inputoldpassword>
And  input <inputnewpassword> and <inputconfirmpassword>
Then Save the password
Then verify the <toastmessage>
  
Examples:
|inputoldpassword|inputnewpassword|inputconfirmpassword|toastmessage                                            |
|sameer4567      |sameer6789      |sameer6789          |Old Password Is Incorrect, Please Enter Correct Password|


Scenario Outline: Verifying change password with invalid inputs
Given Click on change password link
When Enter old password as <inputoldpassword>
And  input <inputnewpassword> and <inputconfirmpassword>
Then Save the password
Then <errormessage> should display

 
Examples:
|inputoldpassword |inputnewpassword |inputconfirmpassword |errormessage                              |
|sameer1235       |sameer           |sameer               |Password must be at least 8 characters    |
|sameer1235       |sameer6789       |sameer4567           |Please make sure your passwords match     |
|sameer6789       |sameer6789       |sameer6789           |New and old password should be different  |


Scenario Outline: Verifying change password with invalid inputs
Given Click on change password link
When Enter old password as <inputoldpassword>
And  input <inputnewpassword> and <inputconfirmpassword>
Then The eye icon should be displayed
And Click on the eye icon


Examples:
|inputoldpassword|inputnewpassword|inputconfirmpassword|
|sameer1235      |sameer          |sameer              |        
|sameer1235      |sameer6789      |sameer4567          |         
|sameer6789      |sameer6789      |sameer6789          | 




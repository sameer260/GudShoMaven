Feature: Create Studio Functionality

Background: To Open the Create Studio Page
Given Go to create Studio Page tab from profile

Scenario: Go to Create Studio Page and Close the page and Cancel the page
When Click on close icon
Then It should redirect to home page
And Go to create Studio Page tab from profile
Then Click cancel button
And It should redirect to home page

Scenario: Check three mini Tabs are showing with text
When Check first tab is displaying with "1. Name Your Studio"
Then Check second tab is diaplaying with "2. Studio Details"
And Check third tab is dispaying with "3. Contact Info"

Scenario: Check the Placeholders and description of MiniTitle Tab-1
When Check the place holder is displaying as "Enter Your Studio Name"
Then Check description "Your studio name will appear in your studio detail page and next to each uploads throughout gudsho. You cannot change your studio name once its set."

Scenario: Check the Studio Name validations
When Input the field with null values
Then The errormessage should show "The name field is required."
And Enter "a" in the field and errormessage should show "Minimum 3 characters allowed"
Then Without studio name the errormessage should show "Studio Name is required"
And Header error message should show "Sorry! Please continue filling all the mandatory fields."

Scenario Outline: Check the Stuido Name Avilability status
When Input the <studio name> in to the field
And The errormessage as "The name has already been taken."
Then Give <valid studioname> and available text should show "Available"

Examples:
|studio name|valid studioname|
|Sameer     |Sameer Studio|

Scenario: Studio Picture Placeholders
Given check "Studio Picture *" is displaying
And Check description of filed name is "Add a profile picture of your studio." displaying
Then The thumbnail image icon and the "Upload" and "Thumbnail" text is displaying
And The file supported text is displaying


Scenario Outline: Studio Thumbnail image invalid image 
Given upload the <thumbnailimage>
Then the error toast message is <toast message>

Examples:
|thumbnailimage|toast message|
|Studioprofileinvalid|Recommended height 200px|

Scenario Outline: Studio Thumbnail image Valid image and Edit and Delet icon
Given upload the <thumbnailimage>
When upload image
Then Uploaded image has been displayed in studio preview
And Change the <thumbnailimage>
And upload image
And Delete the uploaded profile pic and the errormessage should show "Please upload image"


Examples:
|thumbnailimage|
|Studioprofile|

Scenario: About Studio Field
Then About studio field name should display "About Studio*"
And About studio field description should display "Share a bit about your studio, what kind sho studio"
And The description place holder should display "Description"
Then Give Description in to the field as "Sameer Studios are will have more movies"
And The Description chracter count


Scenario Outline: About Studio Visibility
When Studio visibility field name "Studio Visibility*"
Then Studio visibility description "This is your studios visibility status"
And Studio visibility options
And Click visibility <visibility>

Examples:
|visibility|
|Public Studio|
|Private Studio|

Scenario: To check the all error messages in Studio Detail page
Given To check all the field error messages


Scenario: To check all the social icon fields
When Check all the social icon field names
Then Check all the placeholders of the social icon fields
And Check the invalid urls


Scenario: Check contact info Field Names and Description
Given Click on Contact info mini tiltle tab
When The Studio name field name is "Studio Owner Name*"
And The Studio name description is "Studio owner name goes here and will be used for any further contact purposes"
Then The Email Address field name is "Email Address*"
And The Email Address field description is "This will be your primary email for any contact purposes"
Then The Phone Number field name is "Phone Number*"
And The Phone Number field escription is "This will be your primary phone number for any contact purposes"


Scenario Outline: To Check the error messages
Given Give Studio owner name as <owner name>
Then Edit the Email field and give inavlid Email id

Examples:
|owner name|
|sa|

Scenario: To Check the Phone number field Studio Complete Address
And Edit the Phone number field and check request otp button is disabled
Given The Studio Address field name is "Studio Address*"
And The Studio Address field description is "Studio physical address goes here and will be used as the primary contact address"
When Check all the Placeholders
Then Enter Studio Address in to the field


Scenario: To check the Studio Address Errormessage
Given Fill all the details except the studio address
Then Check the errormessage


Scenario Outline: Check Footer text and Complete create Studio Module
Given the footer text should match and check box should select
When After filling all details do <action>


Examples:
|action|
|cancelbutton|
|cancelpage|
|createstudio|









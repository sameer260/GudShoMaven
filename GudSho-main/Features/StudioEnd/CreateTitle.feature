Feature: Create Sho and Series

Background: Go to My Studio
Given Click on profile and click on My Studio
Given Check Create Title button is available and Enabled
When Mouse hover on Create Title button
Then Capture all buttons and verify its displaying correctly


Scenario Outline: Click on Create Sho
When Click on <ShoType> to create title
Then Check redirection will be <headers> 
And Description should be <description>
Then Should display all the fields
And first section name is "1. Name your " and <shoorseries>
And second section name is "2. Upload video for your " and <shoorseries>
And third section name is "3. Upload promo for your " and <shoorseries>
And fourth section name is "4. Upload audio for your " and <shoorseries>
And fivth section name is "5. Manage Detail of your " and <shoorseries>
And sixth section name is "6. Configure your " and <shoorseries>
And seventh section name is "7. Set your monetization details"
And eight section name is "8. Geo Restriction"


Examples:
|ShoType         |headers        |description                                                                            |shoorseries|
|Create Sho      |Create Sho     |This step-by-step process that helps you to upload and manage details about your sho   |sho        |
|Create Series   |Create Series  |This step-by-step process that helps you to upload and manage details about your series|series     | 
|Schedule sho    |Schedule Sho   |This step-by-step process that helps you to upload and manage details about your sho   |sho         |
|Schedule series |Schedule Series|This step-by-step process that helps you to upload and manage details about your series|series      |


Scenario Outline: To check the Field Names and Description of the field-First Tab
Given Click on <ShoType> to create title
When Click on First section
Then Verify first fieldname should be <Type> and "Name*"
And verify first field Description should be "Primary Name that will be used for identification"
And Check first field placeholder should be "Name"
Then Verify second fieldname should be <Type> and "Name PNG"
And Verify second field Description should be "This PNG will be used in the detail page of this sho."
And Upload Png button placeholder with supported text should be <supportedtext>

 
Examples: 
|ShoType        |Type  |supportedtext                 |
|Create Sho     |Sho   |PNG only, Height should be 200|
|Create Series  |Series|PNG only, Height should be 200|
|Schedule sho   |Sho   |PNG only, Height should be 200|
|Schedule series|Series|PNG only, Height should be 200|


Scenario Outline: To check the Field Validations for ShoName-First Tab
Given Click on <ShoType> to create title
When Click on First section
Then Check with out shoname and <fielderrormessage>
And Enter <shoname> in to the field
And Validation check <validationerrormessage>
Then enter shoname more than three chracters and check the charactercount


Examples:
|ShoType        |shoname|fielderrormessage      |validationerrormessage|
|Create Sho     |sa     |Tittle name is required|Minimum 3 character required|
|Create Series  |sa     |Tittle name is required|Minimum 3 character required|
|Schedule sho   |sa     |Tittle name is required|Minimum 3 character required|
|Schedule series|sa     |Tittle name is required|Minimum 3 character required|   


Scenario Outline: To check the Title Png validation and upload
Given Click on <ShoType> to create title
When Click on First section
And Upload other format <image>
Then System will throw <toaster>
Then Upload inavlid <invalidtitlePNG>
And Check toaster <invaliderrormessage>
Then Upload valid <validtitlePNG>
And Edit already uploaded png with <validtitlePNG>
Then Delete uploaded png

Examples:
|ShoType        |image               | toaster             |invalidtitlePNG|invaliderrormessage              |validtitlePNG      |
|Create Sho     |Studioprofileinvalid|Only PNG file allowed|invalidtitlepng|Recommended Image height is 200px|Studioprofile      |
|Create Series  |Studioprofileinvalid|Only PNG file allowed|invalidtitlepng|Recommended Image height is 200px|Studioprofile      |
|Schedule Sho   |Studioprofileinvalid|Only PNG file allowed|invalidtitlepng|Recommended Image height is 200px|Studioprofile      |
|Schedule Series|Studioprofileinvalid|Only PNG file allowed|invalidtitlepng|Recommended Image height is 200px|Studioprofile      |


Scenario Outline:Check fieldNames and description of field names
Given Click on <ShoType> to create title
When Click on Manage detail sho section
Then Check all the field names
And Check all the description of field names

Examples:
|ShoType        |
|Create Sho     |
|Create Series  |
|Schedule Sho   |
|Schedule Series|



Scenario Outline: To Check Manage Detail section-Upload Cover Image
Given Click on <ShoType> to create title
When Click on Manage detail sho section
Then Upload invalid cover image with <invalidsize>
And Check toaster <invaliderrormessage>
Then Upload cover Image with valid <validsize>
And Edit uploaded cover image with <validsize>
Then delete uploaded cover image

Examples:
|ShoType        |invalidsize|invaliderrormessage                |validsize      |
|Create Sho     |pngfile|Minimum resolution should be 1900 * 768|coverimagevalid|
|Create Series  |pngfile|Minimum resolution should be 1900 * 768|coverimagevalid|
|Schedule Sho   |pngfile|Minimum resolution should be 1900 * 768|coverimagevalid|
|Schedule Series|pngfile|Minimum resolution should be 1900 * 768|coverimagevalid|


Scenario Outline: To Check thumbnail scenarios
Given Click on <ShoType> to create title
When Click on Manage detail sho section
Then upload inavlid thumb nail image with <invalidsize>
And The popup should show <invaliderrormessage>
Then Upload thubnail image with valid <validsize>
And Edit the uploaded thumbnail image with <validsize>
Then delete uploaded thumbnail image

Examples:
|ShoType        |invalidsize|invaliderrormessage               |validsize      |
|Create Sho     |pngfile|Minimum resolution should be 350 * 550|coverimagevalid|
|Create Series  |pngfile|Minimum resolution should be 350 * 550|coverimagevalid|
|Schedule Sho   |pngfile|Minimum resolution should be 350 * 550|coverimagevalid|
|Schedule Series|pngfile|Minimum resolution should be 350 * 550|coverimagevalid|


Scenario Outline: Tags and Keywords Functionality
Given Click on <ShoType> to create title
When Click on Manage detail sho section
Then Check placehoder values should match "Ex: #Sho2020H #Bestwebseries #Medieval fantasy"
And Enter keywords and tags one by one check character count
Then Enter more than three keywords
And Check toaster <errormessage>
Then Remove tag by tag and check the chracter count

Examples:
|ShoType        |errormessage|
|Create Sho     |You can able to Select only 3 Tags|
|Create Series  |You can able to Select only 3 Tags|
|Schedule Sho   |You can able to Select only 3 Tags|
|Schedule Series|You can able to Select only 3 Tags|


Scenario Outline: Primary and Secondary genre Functionality
Given Click on <ShoType> to create title
When Click on Manage detail sho section
Then Select any one <primarygenre> from the dropdown
And Placeholder of secondary genere
And Select secondary one by one check character count
Then Enter secondary genre more than three chracters
And Check toaster <errormessage>
And Remove the secondary genre and check chracter count

Examples:
|ShoType|primarygenre|errormessage|
|Create Sho     |Action|You Can able to Select only 3 Genres|
|Create Series  |Drama |You Can able to Select only 3 Genres|
|Schedule Sho   |Crime|You Can able to Select only 3 Genres|
|Schedule Series|Comedy|You Can able to Select only 3 Genres|

@steps
Scenario Outline: Maturity Rating Functionality
Given Click on <ShoType> to create title
When Click on Manage detail sho section
Then Check all label and maturity ratings text
And maturity rating as  <maturityrating>

Examples:
|ShoType|maturityrating|
|Create Sho|ALL|
|Create Series  |7+|
|Schedule Sho   |13+|
|Schedule Series|18+|

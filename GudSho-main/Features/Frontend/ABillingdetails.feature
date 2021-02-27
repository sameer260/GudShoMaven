Feature: Buy the sho if profile is incompleted

@End2End
Scenario Outline: Without profile complete try to buy any sho or series
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Try to buy a sho or series and it will ask to complete the profile
And complete the profile with <name>and <gender> and <dob> and <emailid>
And verify the <toastmessage>


Examples:
|keyword|shoseries or studioname|name  |gender |dob       |emailid            |toastmessage                                  | 
|Talent|Talent          |Sameer|Male |01-10-1996|sameer239@gmail.com|Your Profile has been updated successfully|



Scenario Outline:Without billing details
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Try to buy the show without billing details
And verify the <toastmessage> 

Examples:
|keyword|shoseries or studioname|error message|toastmessage|
|Singh|Singh Is King        | Address is required |Please add the billing address|


Scenario Outline: Change and confirm without address
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
And placeholder values
Then without address the <error message>

Examples:
|keyword|shoseries or studioname|error message|
|Singh|Singh Is King         | Address is required |


Scenario Outline: Add billings details
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Add billing details

Examples:
|keyword|shoseries or studioname|
|Singh|Singh Is King          |


Scenario Outline: Change the adddress bu channge link
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Chnage the address by cliking on link

Examples:
|keyword|shoseries or studioname|
|Singh|Singh Is King          |












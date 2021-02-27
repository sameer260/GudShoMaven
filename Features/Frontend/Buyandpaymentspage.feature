Feature: Buy Sho or series and Payment page


Scenario Outline: Check the Sho or series details with payment page
Given In search enter <keyword> and select wanted <shoseries or studioname>
Then Check the page title and <shoseries or studioname>is showing on page
When Cross verify the sho or series details with payment page

Examples:
|keyword|shoseries or studioname|
|Talent|Talent           |


Scenario Outline: Check the Sho or series details with validity
Given In search enter <keyword> and select wanted <shoseries or studioname>
Then Check the page title and <shoseries or studioname>is showing on page
When Check the validity of sho or series <days> and <hours>

Examples:
|keyword|shoseries or studioname|days|hours|
|Talent|Talent          |1   |1    |


Scenario Outline: Check the Sho or series details with no validity
Given In search enter <keyword> and select wanted <shoseries or studioname>
Then Check the page title and <shoseries or studioname>is showing on page
When Check the validty text if there is no text

Examples:
|keyword|shoseries or studioname|
|Red|Red         |


Scenario Outline: Check the Sho or series biling details in payment page
Given In search enter <keyword> and select wanted <shoseries or studioname>
Then Check the page title and <shoseries or studioname>is showing on page
When check billing details <username> and <useremail>

Examples:
|keyword|shoseries or studioname|username|useremail|
|Red|Red         |sameer|sameer239@yopmail.com|


Scenario Outline: Without card details
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Click on buy button and do not give any details and check errormessages


Examples:
|keyword|shoseries or studioname|         
|Red|Red|


Scenario Outline: Failed Payments
Given In search enter <keyword> and select wanted <shoseries or studioname>
Then Check the page title and <shoseries or studioname>is showing on page
When Click on Buy button and do payment with <payment method>
And Fail the payment
And check toastmessage and again click try again
And Click on try again button and this time close the window
And Fail transaction come back to sho or series detail page

Examples:
|keyword|shoseries or studioname|payment method|
|Talent|Talent           |Debit or Credit Card|

@End2End
Scenario Outline: Success Payments and Play button
Given In search enter <keyword> and select wanted <shoseries or studioname>
Then Check the page title and <shoseries or studioname>is showing on page
When Buy the sho or series with <payment method> and verify the details of transaction page
And Click on play button after successfull bought


Examples:
|keyword|shoseries or studioname|payment method|
|Singh|Singh Is King         |Debit or Credit Card|


Scenario Outline: Success Payments and continue button
Given In search enter <keyword> and select wanted <shoseries or studioname>
Then Check the page title and <shoseries or studioname>is showing on page
When Buy the sho or series with <payment method> and verify the details of transaction page
And Click on continue button

Examples:
|keyword|shoseries or studioname|payment method|
|Web|Web Series        |Debit or Credit Card|


Scenario Outline: Success Payments and with UPI and play
Given In search enter <keyword> and select wanted <shoseries or studioname>
Then Check the page title and <shoseries or studioname>is showing on page
When Buy the Sho or seires by choosing <payment method> and  with <upiid>
And Click on play button after successfull bought

Examples:
|keyword|shoseries or studioname|payment method|upiid|
|Red|Red        |UPI|sameer@ybl|


Scenario Outline: Success Payments and with UPI and continue
Given In search enter <keyword> and select wanted <shoseries or studioname>
Then Check the page title and <shoseries or studioname>is showing on page
When Buy the Sho or seires by choosing <payment method> and  with <upiid>
And Click on continue button

Examples:
|keyword|shoseries or studioname|payment method|upiid|
|Avengers|Avengers (Tamil)        |UPI|sameer@ybl|

Scenario: to check the head elements of Payments
Given Check all the headings are displaying

Scenario Outline: Check the failed payments is showing in payments tab
Given In search enter <keyword> and select wanted <shoseries or studioname>
Then Check the page title and <shoseries or studioname>is showing on page
When Check in the payment tab <shoseries or studioname> is showing with <text> and <paymentmethod>

Examples:
|keyword|shoseries or studioname|text|paymentmethod|
|Kaithi|Kaithi - Tamil        |Failed|CARD|
|Kaithi|Kaithi - Tamil        |Success|CARD|
|abcd|Abcd|Success|UPI|


Scenario: To check pagination scenarios
Given Check all pagination scenarios

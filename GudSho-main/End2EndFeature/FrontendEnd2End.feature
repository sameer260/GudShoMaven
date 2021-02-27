Feature: End 2 End Scenarios for Frontend

Scenario Outline: Without profile complete try to buy any sho or series
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Try to buy a sho or series and it will ask to complete the profile
And complete the profile with <name>and <gender> and <dob> and <emailid>
And verify the <toastmessage>

Examples:
|keyword|shoseries or studioname|name  |gender |dob       |emailid            |toastmessage                                  | 
|Talent|Talent          |Sameer|Male |01-10-1996|sameer239@gmail.com|Your Profile has been updated successfully|


Scenario Outline: Add watch list from Sho detail page and check its displaying on home page
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Click on watch list button and check the same sho is present on homepage
And The <title> will display

Examples:
|keyword|shoseries or studioname|title|
|Talent|Talent|My Watch List|


Scenario Outline: Like the promo and check on home page from shodetailpage
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Play the <promo> and like the promo and check on home page
And The <title> will display

Examples:
|keyword|shoseries or studioname|promo|title|toastmessage|
|Kaithi|Kaithi - Tamil| Kaithi - Official Teaser|My Gud Promos|You liked this promo|


Scenario Outline: Add fav audios from shodetail page
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Play <audio> and fav the audio and same check same on my fav audios
And The <title> will display

Examples:
|keyword|shoseries or studioname|audio|title|
|Wedding|Wedding Life|[iSongs.info] 01 - Shatagni Anthem.mp3|My Favourite Audios|


Scenario Outline: Follow studio from studio profile Page
Given In search enter <keyword> and select wanted <shoseries or studioname>
When It should redirect to the correct <shoseries or studioname> page
Then Click on Follow button on Studio Page and check the same <shoseries or studioname> is visibile on home page
And The <title> will display

Examples:
|keyword|shoseries or studioname|title|
|sameer |Sameer|Following Studios|


Scenario Outline: Add billings details
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Add billing details

Examples:
|keyword|shoseries or studioname|
|Singh|Singh Is King          |


Scenario Outline: Success Payments and Play button
Given In search enter <keyword> and select wanted <shoseries or studioname>
Then Check the page title and <shoseries or studioname>is showing on page
When Buy the sho or series with <payment method> and verify the details of transaction page
And Click on play button after successfull bought


Examples:
|keyword|shoseries or studioname|payment method|
|Singh|Singh Is King         |Debit or Credit Card|


Scenario Outline: Play any sho or series and check its displayed in continue watching-for sho
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Play <shoseries or studioname> and check on home page in continue watching and remove

Examples:
|keyword|shoseries or studioname|
|Singh|Singh Is King|

Scenario Outline: : Verify that played sho is displaying in the watch history
Given search <searchName> sho or series or studio
When click on watch free button
And play for a while and close the player
And navigate to my watch history
Then verify played sho availability

Examples:
| searchName |
| carmen |

@ee
Scenario Outline: Check the failed payments is showing in payments tab
Given In search enter <keyword> and select wanted <shoseries or studioname>
Then Check the page title and <shoseries or studioname>is showing on page
When Check in the payment tab <shoseries or studioname> is showing with <text> and <paymentmethod>

Examples:
|keyword|shoseries or studioname|text|paymentmethod|
|Uppena|Uppena       |Success|CARD|		


#########  Paywall ########

@nohook
Scenario Outline: Verify add to watchlist feature on sho detail page 
    Given Open the browser
	When search <searchName> sho or series or studio 
	Then click on add to watchlist button from sho detail page 
	And Verify the add to watchlist mini pop elements 
	And click on later button 
	Then click on add to watchlist button from sho detail page 
	And click on signin button 
	And verify that system is redirecting login page 
	And Navigate back from login page 
	And scroll and click on the add to watchlist button 
	And Verify the add to watchlist mini pop elements 
	And click on later button 
	And scroll and click on the add to watchlist button 
	And click on signin button 
	And verify that system is redirecting login page 

	Examples: 
		| searchName |
		| Interstellar - English |
		
@nohook
Scenario Outline: Verify buy button feature on sho detail page 
    Given Open the browser 
	When search <searchName> sho or series or studio 
	Then click on buy button 
	And verify that system is redirecting login page 
	And Navigate back from login page 
	And Scroll and click on the buy button 
	And verify that system is redirecting login page 
	Examples: 
		| searchName |
		| Interstellar - English |
		
@nohook		
Scenario Outline: verify that user cant able to create gud as non logged user in sho detail page 
    Given Open the browser
	When search <searchName> sho or series or studio 
	When Scroll to bottom and play any promo 
	Then click on create gud button 
	And verify mini popup elements of create gud 
	And click on later button 
	Then click on create gud button 
	And click on signin button 
	And verify that system is redirecting login page 
	And Navigate back from login page 
	And play promo in fullscreen 
	Then click on create gud button 
	And verify mini popup elements of create gud 
	And click on later button 
	Then click on create gud button 
	And click on signin button 
	And verify that system is redirecting login page 
	
	
	Examples: 
		| searchName |
		| Interstellar - English |
		

@nohook
Scenario Outline: search any studio and try to follow the studio as non logged user 
    Given Open the browser
	When search <searchName> sho or series or studio 
	Then click on follow button from studio detail page 
	Then verify mini popup elements of follow 
	And click on later button 
	Then click on follow button from studio detail page 
	And click on signin button 
	And verify that system is redirecting login page 
	And Navigate back from login page 
	
	
	Examples: 
		| searchName |
		| santii |

@nohook
Scenario Outline: Verify audio favorite feature in sho or series detail page 
    Given Open the browser
	When search <searchName> sho or series or studio 
	Then scroll to bottom and click on play all button 
	Then verify audio player 
	And click on the fav button from player 
	Then verify mini popup elements of favorite 
	And click on later button 
	And click on the fav button from player 
	And click on signin button 
	And verify that system is redirecting login page 
	
	Examples: 
		| searchName |
		| Interstellar - English |			
		
		
			
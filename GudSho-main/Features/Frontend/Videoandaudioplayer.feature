Feature: Audio and Video player settings


Scenario Outline:Puase or Play the Song
Given In search enter <keyword> and select wanted <shoseries or studioname>
Then Check the page title and <shoseries or studioname>is showing on page
Then Play any <audioname>
And it should display gudsho icon
And stop the audio after <duration> and play the audio and other settings


Examples:
|keyword|shoseries or studioname|audioname|duration|
|Wedding|Wedding Life|[Isongs.info] 01 - Shatagni Anthem.mp3|00:10|



Scenario Outline:Mute,unmute and other settings in Audio player
Given In search enter <keyword> and select wanted <shoseries or studioname>
Then Check the page title and <shoseries or studioname>is showing on page
Then Play any <audioname>
And it should display gudsho icon
And Hide or show the player
And next and previous song button
And mute and unmute the audio


Examples:
|keyword|shoseries or studioname|audioname|duration|
|Wedding|Wedding Life|[Isongs.info] 01 - Shatagni Anthem.mp3|00:10|


##Video Player Settings

Scenario Outline:Pause or Play the video
Given In search enter <keyword> and select wanted <shoseries or studioname>
Then Check the page title and <shoseries or studioname>is showing on page
Then Play the <promo name> from sho detail page 
And Pause and Play the video after <k> seconds  

Examples:
|keyword|shoseries or studioname|k|promo name|
|Talent|Talent              |00:10|Jaya Janaki Nayaka Movie| 


Scenario Outline:Forward and Backward the video
Given In search enter <keyword> and select wanted <shoseries or studioname>
Then Check the page title and <shoseries or studioname>is showing on page
Then Play the <promo name> from sho detail page
And Forward video after <forward> and <durationafterforward>
And Backward video after <backward> and <durationafterbackward>
  
Examples:
|keyword|shoseries or studioname|forward|durationafterforward|backward|durationafterbackward|promo name|
|Talent|Talent    |00:10 |00:20               |00:25    |00:15                | Jaya Janaki Nayaka Movie|


Scenario Outline:Mute and unmute the video
Given In search enter <keyword> and select wanted <shoseries or studioname>
Then Check the page title and <shoseries or studioname>is showing on page
Then Play the <promo name> from sho detail page
And Mute and adjust the audio
  
Examples:
|keyword|shoseries or studioname|forward|durationafterforward|backward|durationafterbackward|promo name|
|Talent|Talent               |00:10 |00:20               |00:25    |00:15|Jaya Janaki Nayaka Movie| 


Scenario Outline: Playing promos 
Given In search enter <keyword> and select wanted <shoseries or studioname>
Then Check the page title and <shoseries or studioname>is showing on page
Then Play the <promo name> from sho detail page
And Click on next promo from the player

Examples:
|keyword|shoseries or studioname|promo name|
|Talent|Talent    |Jaya Janaki Nayaka Movie          | 


Scenario Outline: Playing promos from full screen
Given In search enter <keyword> and select wanted <shoseries or studioname>
Then Check the page title and <shoseries or studioname>is showing on page
Then Play the <promo name> from sho detail page
And Enter in to the full screen
And Click on next promo from the player for full screen


Examples:
|keyword|shoseries or studioname|promo name|
|Talent|Talent    |Jaya Janaki Nayaka Movie        | 


Scenario Outline: To check the Next episode button functionality
Given In search enter <keyword> and select wanted <shoseries or studioname>
Then Check the page title and <shoseries or studioname>is showing on page
Then Buy or play any series
And Click next episode button

Examples:
|keyword|shoseries or studioname|
|Talent|Talent                  |


Scenario Outline: To check the Next episode button functionality from full screen
Given In search enter <keyword> and select wanted <shoseries or studioname>
Then Check the page title and <shoseries or studioname>is showing on page
Then Buy or play any series
And Enter in to the full screen
And Click next episode button for full screen


Examples:
|keyword|shoseries or studioname|
|Talent|Talent                  |

Scenario Outline:Episode popup screen and playing episodes 
Given In search enter <keyword> and select wanted <shoseries or studioname>
Then Check the page title and <shoseries or studioname>is showing on page
Then Buy or play any series
And select <season name> and play <episode name>


Examples:
|keyword|shoseries or studioname|season name|episode name|
|Talent|Talent                  |Season 3   |2. Ramaraju|


Scenario Outline:Promo playing from right hand side panel
Given In search enter <keyword> and select wanted <shoseries or studioname>
Then Check the page title and <shoseries or studioname>is showing on page
Then Play the <promo name> from sho detail page
And From rightside promo section play the promos and check hide functionality


Examples:
|keyword|shoseries or studioname|promo name|
|Talent|Talent                  |Jaya Janaki Nayaka Movie   | 

@test
Scenario Outline:Episode popup screen and playing episodes from full screen
Given In search enter <keyword> and select wanted <shoseries or studioname>
Then Check the page title and <shoseries or studioname>is showing on page
Then Buy or play any series
And Enter in to the full screen
And select <season name> and play <episode name>



Examples:
|keyword|shoseries or studioname|season name|episode name|
|Talent|Talent                  |Season 3   |2. Ramaraju|


@sameer
Scenario Outline: Play promo and verify the auto switching from the left panel 
	When search sho name <shoName> for promo switching 
	And Play the first promo 
	And Drag to the end 
	And click on the next expisode button 
	Then verify promo is play the next 
	Examples: 
		|shoName|
		|kaththi|
@sameer		
Scenario Outline: Play promo and verify the auto switching without click button.  
	When search sho name <shoName> for promo switching 
	And Play the first promo 
	And Drag to the end 
	And wait for ten seconds 
	Then verify promo is play the next 
	Examples: 
		|shoName|
		|kaththi|
@sameer
Scenario Outline: Play promo and verify the auto switching without click button - fullscreen  
	When search sho name <shoName> for promo switching 
	And Play the first promo 
	And click on fullscreen button
	And Drag to the end 
	And wait for ten seconds 
	Then verify promo is play the next 
	Examples: 
		|shoName|
		|kaththi|
@sameer
Scenario Outline: This is to verify the promo switching by clicking next button - fullscreen
	When search sho name <shoName> for promo switching 
	And Play the first promo
	And click on fullscreen button 
	And Drag to the end 
	And click on the next expisode button 
	Then verify promo is play the next 
	Examples: 
		|shoName|
		|kaththi|
@sameer
Scenario Outline: Play promo and verify the auto switching without clicking next button - fullscreen 
	When search sho name <shoName> for promo switching 
	And Play the first promo 
	And click on fullscreen button 
	And Drag to the end 
	And wait for ten seconds 
	Then verify promo is play the next 
	Examples: 
		|shoName|
		|kaththi|

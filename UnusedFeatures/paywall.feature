@undev @nohook
Feature: This is to test the paywall feature 

Scenario: Verify add to watchlist feature on home page 
	When click on add to watchlist from flick page 
	Then Verify the add to watchlist mini pop elements 
	And click on later button 
	And click on add to watchlist from flick page 
	And click on signin button 
	And verify that system is redirecting login page 
	
#create gud feature		
Scenario: verify that user cant able to create gud as non logged user in home page 
	
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
	Then close the browser 
	
	#follow feature		
Scenario: verify that user cant able follo studio from home 
	When Scroll to bottom and follow any studio 
	Then verify mini popup elements of follow 
	And click on later button 
	Then follow any studio 
	And click on signin button 
	And verify that system is redirecting login page 
	And Navigate back from login page 
	Then close the browser 
	

Scenario: verify that user cant able follo studio from explore studio page 
	When click on shocial and click on explore studio card 
	Then follow any studio 
	Then verify mini popup elements of follow 
	And click on later button 
	Then follow any studio 
	And click on signin button 
	And verify that system is redirecting login page 
	And Navigate back from login page 
	Then close the browser 
	
	#Audio Feature		
Scenario: Verify audio favorite feture in flick page 
	When scroll to bottom and play any audio 
	Then verify the audio player 
	And click on the fav button from player 
	Then verify mini popup elements of favorite 
	And click on later button 
	And click on the fav button from player 
	And click on signin button 
	And verify that system is redirecting login page 
	Then close the browser	
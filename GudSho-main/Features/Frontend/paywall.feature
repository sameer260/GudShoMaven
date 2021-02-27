@nohook
Feature: This is to test the paywall feature 

Background: Pre-requsit for paywall
Given Launch the browser and naviagate to home page
	
@End2End
Scenario Outline: Verify add to watchlist feature on sho detail page 
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
		
		
@paywall		
Scenario Outline: Verify add to watchlist feature on studio detail page 
	When search <searchName> sho or series or studio 
	Then click on add to watchlist from flick page 
	And Verify the add to watchlist mini pop elements 
	And click on later button 
	Then click on add to watchlist from flick page 
	And click on signin button 
	And verify that system is redirecting login page 
	
	Examples: 
		| searchName |
		| santii |
		

@End2End
Scenario Outline: Verify buy button feature on sho detail page  
	When search <searchName> sho or series or studio 
	Then click on buy button 
	And verify that system is redirecting login page 
	And Navigate back from login page 
	And Scroll and click on the buy button 
	And verify that system is redirecting login page 
	Examples: 
		| searchName |
		| Interstellar - English |
		
@paywalltt		
Scenario Outline: Verify buy button feature on series detail page 
	
	When search <searchName> sho or series or studio 
	Then click on buy button 
	And verify that system is redirecting login page 
	And Navigate back from login page 
	And Scroll and click on the buy button 
	And verify that system is redirecting login page 
	
	Examples: 
		| searchName |
		| trolls |
		
@paywall		
Scenario Outline: Verify that user cant able to play episodes as non logged user 
	
	When search <searchName> sho or series or studio 
	Then scroll down and click on first episode 
	And verify that system is redirecting login page 
	And Navigate back from login page 
	And Scroll down and click on episode hyper link 
	And play the first episode 
	And verify that system is redirecting login page 
	 
	Examples: 
		| searchName |
		| trolls |

	
@paywallt
Scenario Outline: verify that user cant able to create gud as 
				  non logged user in studio detail page 
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
		| santii |
		
@End2End	
Scenario Outline: verify that user cant able to create gud as non logged user in sho detail page 
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
		

@End2End
Scenario Outline: search any studio and try to follow the studio as non logged user 
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
		
	
@paywall
Scenario Outline: Verify audio favorite feture in studio detail page 
	When search <searchName> sho or series or studio 
	Then scroll to bottom and play any audio 
	Then verify audio player 
	And click on the fav button from player 
	Then verify mini popup elements of favorite 
	And click on later button 
	And click on the fav button from player 
	And click on signin button 
	And verify that system is redirecting login page 
	
	Examples: 
		| searchName |
		| santii |
		
@End2End
Scenario Outline: Verify audio favorite feature in sho or series detail page 
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
		
#Minititle
@paywall	
Scenario Outline: verify add to watchlist button from minitittle 
	When search <searchName> sho or series or studio 
	And play the promo 
	And forward to the end 
	And Click on add to watchlist button from minititle 
	And Verify the add to watchlist mini pop elements 
	And click on later button 
	Then click on add to watchlist button from sho detail page 
	And click on signin button 
	And verify that system is redirecting login page 
	
	
	Examples: 
		|searchName|
		|Interstellar - English|
@paywall	
Scenario Outline: verify add to watchlist button from minitittle fullscreen mode 
	When search <searchName> sho or series or studio 
	And play the promo 
	And play promo in fullscreen 
	And forward to the end 
	And Click on add to watchlist button from minititle 
	And Verify the add to watchlist mini pop elements 
	And click on later button 
	Then click on add to watchlist button from sho detail page 
	And click on signin button 
	And verify that system is redirecting login page 
	
	
	Examples: 
		|searchName|
		|Interstellar - English|
		
@paywallt
Scenario Outline: verify buy button from minitittle 
	When search <searchName> sho or series or studio 
	And play the promo 
	And forward to the end 
	And Click on buy button from minititle 
	And verify that system is redirecting login page 
	
	
	Examples: 
		|searchName|
		|Interstellar - English|
@paywall	
Scenario Outline: verify buy button from minitittle fullscreen mode 
	When search <searchName> sho or series or studio 
	And play the promo 
	And play promo in fullscreen 
	And forward to the end 
	And Click on buy button from minititle 
	And verify that system is redirecting login page 
	
	
	Examples: 
		|searchName|
		|Interstellar - English|
		
#watch Free feature	
@paywall	
Scenario Outline: This test is to verify the watch free button on detail page 
	When search <searchName> sho or series or studio 
	And click on the watch free button 
	And verify that system is redirecting login page 
	And Navigate back from login page 
	
	
	Examples: 
		| searchName |
		| carmen |
		
@paywallt
Scenario Outline: This test is to verify the watch free button on minititle 
	When search <searchName> sho or series or studio 
	And play the promo 
	And forward to the end 
	And click on the watch free button 
	And verify that system is redirecting login page 
	And Navigate back from login page 
	
	Examples: 
		| searchName |
		| carmen |
		
@paywall
Scenario Outline: This test is to verify the watch free button on minititle full screen 
	When search <searchName> sho or series or studio 
	And play the promo 
	And play promo in fullscreen 
	And forward to the end 
	And click on the watch free button 
	And verify that system is redirecting login page 
	Examples: 
		| searchName |
		| carmen |
		
#coming soon feature
@paywall	
Scenario Outline: This test is to verify the coming soon button from sho detail page 
	When search <searchName> sho or series or studio 
	And Verify the coming soon button 
	
	Examples: 
		| searchName |
		| Mundasupatti |
		
@paywall
Scenario Outline: This test is to verify the coming soon button from mini title 
	When search <searchName> sho or series or studio 
	And play the promo 
	And forward to the end 
	And Verify the coming soon button 
	Examples: 
		| searchName |
		| Mundasupatti |
		
@paywallt	
Scenario Outline: This test is to verify the coming soon button from mini title full screen 
	When search <searchName> sho or series or studio 
	And play the promo 
	And play promo in fullscreen 
	And forward to the end 
	And Verify the coming soon button 
	Examples: 
		| searchName |
		| Mundasupatti |

		
#gud increment
@paywall	
Scenario Outline: This test is to verify the gud increment 
	When search <searchName> sho or series or studio 
	And play the promo 
	And create gud and verify the gud count 
	And close player 
	Examples: 
		| searchName |
		| Interstellar - English |
		
@paywall
Scenario Outline: This test is to verify the gud increment full screen
	When search <searchName> sho or series or studio 
	And play the promo 
	And play promo in fullscreen  
	And create gud and verify the gud count 
	And close player 
	Examples: 
		| searchName |
		| Interstellar - English |
		

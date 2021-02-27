@nohook
Feature: Catalog Management Scenarios End 2 End

Background: Go to My Studio Page
Given Launch the browser and naviagate to home page 
When Sign in button
Then username and password and login


Scenario: Add banners 
	Given Navigate to my studio 
	When click add banner button from center 
	And select five banners 
	And click save and verify 
	

Scenario: Delete banner 
	Given Navigate to my studio 
	When Delete singl banner 
	Then verify toaster 
	
Scenario Outline: Create sho and series row and add 10cards into the row 
	Given Navigate to my studio 
	When click on add row button and verify the pop 
	And Enter row name <RowName> 
	And click on the select row type dropdown 
	And click on <RowType> option 
	And click on save button 
	And Click on insert card for <RowType> 
	Then Add ten cards in to the row <RowType> 
	Then delete the created row 
	Examples: 
		| RowName | RowType |
		| test sho | sho & series |
		| test promos | promos |
		| test audios | Audio Tracks |
		
Scenario Outline: Verify the re-order feature - sho series type 
	Given Navigate to my studio 
	When click on add row button and verify the pop 
	And Enter row name <RowName> 
	And click on the select row type dropdown 
	And click on <RowType> option 
	And click on save button 
	And Click on insert card for <RowType> 
	Then Add ten cards in to the row <RowType> 
	And Click on reorder option 
	And reorder the cards 
	Then delete the created row 
	Examples: 
		| RowName | RowType |
		| test sho1 | sho & series |
		| test promos1 | promos |
		| test audios1 | Audio Tracks |
		
		
Scenario Outline: Verify the disable feature - sho series type 
	Given Navigate to my studio 
	When click on add row button and verify the pop 
	And Enter row name <RowName> 
	And click on the select row type dropdown 
	And click on <RowType> option 
	And click on save button 
	And Click on insert card for <RowType> 
	Then Add ten cards in to the row <RowType> 
	And verify disable feature 
	Then delete the created row 
	Examples: 
		| RowName | RowType |
		| test sho2 | sho & series |
		| test promos2 | promos |
		| test audios2 | Audio Tracks |

	
Scenario: Reorder rows 
	Given Navigate to my studio  
	And Create 1st row sho series 
	And Add ten cards in to the sho row 
	And create 2nd row promo 
	And Add ten cards in to the promo row 
	And create 3rd row promo 
	And Add ten cards in to the audio row 
	And Reorder the rows and verify 
	Then delete the created rows
	
				
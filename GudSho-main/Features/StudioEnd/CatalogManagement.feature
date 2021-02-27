Feature: This is to test catalogmanagement feature 
	of my studio (creation of sho-promo-audio row types and features)



@banner 
Scenario: Add banners 
	Given Navigate to my studio 
	When click add banner button from center 
	And select five banners 
	And click save and verify 
	
@banner 
Scenario: Delete banner 
	Given Navigate to my studio 
	When Delete singl banner 
	Then verify toaster













	
 
Scenario: Verify the elements of catalogmanagement if there is no row. 
	Given Navigate to my studio 
	When verify header element 
	And Verify the shuffle and add row buttons 
	And verify visibilty of create new row image 
	And check create new row element 
	Then click on add row button and verify the pop 
	

Scenario: Verify the warning messages of add row popup 
	Given Navigate to my studio 
	When click on add row button and verify the pop 
	And click on save button 
	And verify field warning messages 
	And click on cancel button 
	Then verify pop is closed or not 
	

Scenario: Verify the options in select row type dropdown 
	Given Navigate to my studio 
	When click on add row button and verify the pop 
	And click on the select row type dropdown 
	And verify options 
	And click on cancel button 
	Then verify pop is closed or not 
	
		
Scenario Outline: Verify that user is able to select all type from dropdown one by one 
	Given Navigate to my studio 
	When click on add row button and verify the pop 
	And click on the select row type dropdown 
	And click on <RowType> option 
	And Verify the options is selected or not <RowType> 
	And click on cancel button 
	Then verify pop is closed or not 
	Examples: 
		| RowType |
		| sho & series |
		| promos |
		| Audio Tracks |
		
		
Scenario Outline: Fill rescpective fields and click on cancell button and verify 
	Given Navigate to my studio 
	When click on add row button and verify the pop 
	And Enter row name <RowName> 
	And click on the select row type dropdown 
	And click on <RowType> option 
	And click on cancel button 
	Then verify pop is closed or not 
	Examples: 
		| RowName | RowType |
		| test sho | sho & series |
		
		

Scenario Outline: Fill rescpective fields and click on save button and verify 
	Given Navigate to my studio 
	When click on add row button and verify the pop 
	And  Enter the row name <RowName> 
	And click on the select row type dropdown 
	And click on <RowType> option 
	And click on save button 
	Then verify created row <RowName> 
	Then delete the created row 
	Examples: 
		| RowName | RowType |
		| test sho | sho & series |
		| test promos | promos |
		| test audios | Audio Tracks |
		

Scenario Outline: verify that system should not allow to create duplicate row 
	Given Navigate to my studio 
	When click on add row button and verify the pop 
	And  Enter the row name <RowName> 
	And click on the select row type dropdown 
	And click on <RowType> option 
	And click on save button 
	Then verify created row <RowName> 
	When click on add row button and verify the pop second row 
	And  Enter the row name <RowName> 
	And click on the select row type dropdown 
	And click on <RowType> option 
	And click on save button 
	And verify toaster for duplicate row 
	And click on cancel button 
	Then delete the created row 
	Examples: 
		| RowName | RowType |
		| test sho | sho & series |
		| test promos | promos |
		| test audios | Audio Tracks |
		

Scenario Outline: Create sho and series row and add 10cards into the row 
	Given Navigate to my studio 
	When click on add row button and verify the pop 
	And Enter the row name <RowName> 
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
		
	
Scenario Outline: Create sho and series row and add few into the row 
	Given Navigate to my studio 
	When click on add row button and verify the pop 
	And Enter the row name <RowName> 
	And click on the select row type dropdown 
	And click on <RowType> option 
	And click on save button 
	And Click on insert card for <RowType> 
	Then Add few cards <RowType> 
	Then delete the created row 
	Examples: 
		| RowName | RowType |
		| test sho | sho & series |
		| test promos | promos |
		| test audios | Audio Tracks |
		
	
Scenario Outline: Verify the disable feature - sho series type 
	Given Navigate to my studio 
	When click on add row button and verify the pop 
	And Enter the row name <RowName> 
	And click on the select row type dropdown 
	And click on <RowType> option 
	And click on save button 
	And Click on insert card for <RowType> 
	Then Add ten cards in to the row <RowType> 
	And verify disable feature 
	Then delete the created row 
	Examples: 
		| RowName | RowType |
		| test sho | sho & series |
		| test promos | promos |
		| test audios | Audio Tracks |
		

Scenario Outline: Verify the re-order feature - sho series type 
	Given Navigate to my studio 
	When click on add row button and verify the pop 
	And Enter the row name <RowName> 
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
		| test sho | sho & series |
		| test promos | promos |
		| test audios | Audio Tracks |
		
		
		
Scenario Outline: Verify select and delete feature - sho series type 
	Given Navigate to my studio 
	When click on add row button and verify the pop 
	And Enter the row name <RowName> 
	And click on the select row type dropdown 
	And click on <RowType> option 
	And click on save button 
	And Click on insert card for <RowType> 
	Then Add ten cards in to the row <RowType> 
	And select card check box from home 
	And delete the selected card 
	Then delete the created row 
	Examples: 
		| RowName | RowType |
		| test sho | sho & series |
		| test promos | promos |
		| test audios | Audio Tracks |
		
		
Scenario Outline: Search and add in to the row - sho/series 
	Given Navigate to my studio 
	When click on add row button and verify the pop 
	And Enter the row name <RowName> 
	And click on the select row type dropdown 
	And click on <RowType> option 
	And click on save button 
	And Click on insert card for <RowType> 
	And search name <searching> and add into row <RowType> and verify 
	Then Add ten cards in to the row <RowType> 
	Then delete the created row 
	Examples: 
		| RowName | RowType | searching |
		| test sho | sho & series | kaththi |
		| test promos | promos | kaththi |
		| test audios | Audio Tracks | kaththi |
		
		
Scenario Outline: Verify search filters for sho type - sho/series 
	Given Navigate to my studio 
	When click on add row button and verify the pop 
	And Enter the row name <RowName> 
	And click on the select row type dropdown 
	And click on <RowType> option 
	And click on save button 
	And Click on insert card for <RowType> 
	And select search filter into sho and verify the results 
	Then Add ten cards in to the row <RowType> 
	Then delete the created row 
	Examples: 
		| RowName | RowType |
		| test sho | sho & series |
		| test promos | promos |
		

Scenario Outline: Verify search filters for series type - sho/series 
	Given Navigate to my studio 
	When click on add row button and verify the pop 
	And Enter the row name <RowName> 
	And click on the select row type dropdown 
	And click on <RowType> option 
	And click on save button 
	And Click on insert card for <RowType> 
	And select search filter into series and verify the results 
	Then Add ten cards in to the row <RowType> 
	Then delete the created row 
	Examples: 
		| RowName | RowType |
		| test sho | sho & series |
		| test promos | promos |
		
		
Scenario Outline: Verify search filters for all type - sho/series 
	Given Navigate to my studio 
	When click on add row button and verify the pop 
	And Enter the row name <RowName> 
	And click on the select row type dropdown 
	And click on <RowType> option 
	And click on save button 
	And Click on insert card for <RowType> 
	And select search filter into all type and verify the results 
	Then Add ten cards in to the row <RowType> 
	Then delete the created row 
	Examples: 
		| RowName | RowType |
		| test sho | sho & series |
		| test promos | promos |
		

Scenario Outline: Verify that user is able to update the rowname 
	Given Navigate to my studio 
	When click on add row button and verify the pop 
	And Enter the row name <RowName> 
	And click on the select row type dropdown 
	And click on <RowType> option 
	And click on save button 
	And update row name <newRowName> and <RowType> verify 
	Then delete the created row 
	Examples: 
		| RowName | RowType | newRowName |
		| test sho | sho & series | test sho 21 |
		| test promos | promos | test promo 31 |
		| test audios | Audio Tracks | test Audio 41|
		
		
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
	
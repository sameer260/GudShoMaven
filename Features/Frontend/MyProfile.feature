Feature: This is to test the myprofile elements and naviagation on all pages 

Scenario: Verify the my profile elements availibility on home page 
	Then hover on my profile 
	And Navigate to my accounts and get profName and mobile number 
	And Validate my prof username and mobile number element 
	And Validate dark them check box 
	And Validate Account and setting, help, signOut and my studio 
	
	
Scenario: Verify that user able to click on accounts and settings from home page 
	Then hover on my profile 
	And click on accounts and settings and verify page redirection 
	And Navigate back 
	And Verify system should redirect home page 
	
	
	
Scenario: Verify that user able to click help from home page 

	Then hover on my profile 
	And click on help and verify page redirection 
	And Navigate back 
	And Verify system should redirect home page 
	
	
@test	
Scenario Outline: Verify the my profile elements availibility on sho detail page 
	Then search <searchName> sho or series or studio 
	Then hover on my profile 
	And Navigate to my accounts and get profName and mobile number 
	And Validate my prof username and mobile number element 
	And Validate dark them check box 
	And Validate Account and setting, help, signOut and my studio 
	Examples: 
		| searchName |
		| kaththi |
		
		
Scenario Outline: Verify that user able to click on accounts and settings from sho detail page 
	Then search <searchName> sho or series or studio 
	Then hover on my profile 
	And click on accounts and settings and verify page redirection 
	And Navigate back 
	And Verify system should redirect sho detail page 
	Examples: 
		| searchName |
		| kaththi |
		
		
Scenario Outline: : Verify that user able to click help from sho detail page 
	Then search <searchName> sho or series or studio 
	Then hover on my profile 
	And click on help and verify page redirection 
	And Navigate back 
	And Verify system should redirect sho detail page 
	And hover on my profile 
	Examples: 
		| searchName |
		| kaththi |
		
		
		
		
Scenario Outline: Verify the my profile elements availibility on studio detail page 
	Then search <searchName> sho or series or studio 
	Then hover on my profile 
	And Navigate to my accounts and get profName and mobile number 
	And Validate my prof username and mobile number element 
	And Validate dark them check box 
	And Validate Account and setting, help, signOut and my studio 
	Examples: 
		| searchName |
		| santii |
		
		
Scenario Outline: Verify that user able to click on accounts and settings from studio detail page 
	Then search <searchName> sho or series or studio 
	Then hover on my profile 
	And click on accounts and settings and verify page redirection 
	And Navigate back 
	And Verify system should redirect studio detail page 
	And hover on my profile 
	
	Examples: 
		| searchName |
		| santii |
		
Scenario Outline: Verify that user able to click help from studio detail page 

	Then search <searchName> sho or series or studio 
	Then hover on my profile 
	And click on help and verify page redirection 
	And Navigate back 
	And Verify system should redirect studio detail page 
	And hover on my profile 
	
	Examples: 
		| searchName |
		| santii |
		
		
Scenario: Verify the my profile elements availibility on acc settings page 

	Then Navigate to accounts and settings 
	Then hover on my profile 
	And Navigate to my accounts and get profName and mobile number 
	And Validate my prof username and mobile number element 
	And Validate dark them check box 
	And Validate Account and setting, help, signOut and my studio 
	
	
Scenario: Verify that user able to click on accounts and settings from acc settings page 

	Then Navigate to accounts and settings 
	Then hover on my profile 
	And click on accounts and settings and verify page redirection 
	And Navigate back 
	And Verify system should redirect home page 
	
	
	
Scenario: Verify that user able to click help from acc settings page 

	Then Navigate to accounts and settings 
	Then hover on my profile 
	And click on help and verify page redirection 
	And Navigate back 
	And Verify system should redirect accounts and settings page 
	
	
Scenario: Verify the my profile elements availibility on help page 

	Then Navigate to help page 
	Then hover on my profile 
	And Navigate to my accounts and get profName and mobile number 
	And Validate my prof username and mobile number element 
	And Validate dark them check box 
	And Validate Account and setting, help, signOut and my studio 
	
	
Scenario: Verify that user able to click on accounts and settings from help page 

	Then Navigate to help page 
	Then hover on my profile 
	And click on accounts and settings and verify page redirection 
	And Navigate back 
	And Verify system should redirect help page 

	
Scenario: Verify that user able to click help from help page 
	Then Navigate to help page 
	Then hover on my profile 
	And click on help and verify page redirection 
	And Navigate back 
	And Verify system should redirect home page 
	
	
Scenario Outline: Verify the my profile elements availibility on payment page 
	Given search <searchName> sho or series or studio 
	Then Click on buy button 
	Then hover on my profile 
	And Navigate to my accounts and get profName and mobile number 
	And Validate my prof username and mobile number element 
	And Validate dark them check box 
	And Validate Account and setting, help, signOut and my studio 
	Examples: 
		| searchName |
		| qwerty |
		
		
Scenario Outline: Verify that user able to click on accounts and settings from payment page 
	Given search <searchName> sho or series or studio 
	Then Click on buy button 
	Then hover on my profile 
	And click on accounts and settings and verify page redirection 
	And Navigate back 
	And Verify system should redirect payment page 
	And hover on my profile 
	Examples: 
		| searchName |
		| qwerty |
		
		
Scenario Outline: Verify that user able to click help from payment page 
	Given search <searchName> sho or series or studio 
	Then Click on buy button 
	Then hover on my profile 
	And click on help and verify page redirection 
	And Navigate back 
	And Verify system should redirect payment page 
	Examples: 
		| searchName |
		| qwerty |
		
	
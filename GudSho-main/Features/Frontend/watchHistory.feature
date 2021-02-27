Feature: This is to test watch history feature


Scenario Outline: : Verify that played sho is displaying in the watch history
Given search <searchName> sho or series or studio
When click on watch free button
And play for a while and close the player
And navigate to my watch history
Then verify played sho availability

Examples:
| searchName |
| carmen |


Scenario Outline:: Verify that user is able to delete the played record from watch history sho
Given search <searchName> sho or series or studio
When click on watch free button
And play for a while and close the player
And navigate to my watch history
And verify played sho availability
And click on delete icon for the played sho
Then verify toaster message of delete sho


Examples:
| searchName |
| kaththi |


Scenario Outline:: Verify that user is able to delete the played record from watch history series
Given search <searchName> sho or series or studio
When click on watch free button
And play for a while and close the player
And navigate to my watch history
And verify played sho availability
And click on delete icon for the played sho
Then verify toaster message of delete series

Examples:
| searchName |
| carmen |


@sameer
Scenario Outline:: Verify clear all functionality of watch history
Given search <searchName> sho or series or studio
When click on watch free button
And play for a while and close the player
And navigate to my watch history
And click on clear all button and verify the elements
And click on no button and verify the sho availabilty
Then click on yes and verify the CTA

Examples:
| searchName |
| kaththi |


Scenario Outline:: Click on start watch and verify that system is redirecting the user to home page.

Given search <searchName> sho or series or studio
When click on watch free button
And play for a while and close the player
And navigate to my watch history
And click on clear all button and verify the elements
And click on no button and verify the sho availabilty
And click on yes and verify the CTA
And click on the start watch button
Then the system should redirect the user to home page

Examples:
| searchName |
| kaththi |


Scenario Outline: Verify that user is able to play the sho from watch history
Given search <searchName> sho or series or studio
When click on watch free button
And play for a while and close the player
And navigate to my watch history
And Click on the first hyperlink
Then verify that respective sho is playing or not

Examples:
| searchName |
| kaththi |


Scenario Outline: Verify that watch history is capturing records when playing the sho from promo
Given search <searchName> sho or series or studio
When Scroll to bottom and play any promo 
And forward to the end
When click on watch free button
And play for a while and close the player
And navigate to my watch history
Then verify played sho availability


Examples:
| searchName |
| kaththi |


Scenario Outline: Play the first series from detial page and verify it in history
Given search <searchName> sho or series or studio
When Scroll to buttom and play first episode
And play for a while and close the player
And navigate to my watch history
Then verify played sho availability


Examples:
| searchName |
| carmen |


Scenario Outline: click on episode hyper link and play first episode and verify it in watch history
Given search <searchName> sho or series or studio
When Scroll to buttom and click on episodes hyperlink
And play the first episode
And play for a while and close the player
And navigate to my watch history
Then verify played sho availability


Examples:
| searchName |
| carmen |

@test
Scenario Outline: Verify that watch history is capturing records when playing the series from nextup
Given search <searchName> sho or series or studio
When Scroll to buttom and play first episode
And forward to the end for sho
And play for a while and close the player
And navigate to my watch history
Then verify played sho availability


Examples:
| searchName |
| carmen |


Scenario Outline: Verify that watch history is capturing records when hitting on the next episode
Given search <searchName> sho or series or studio
When Scroll to buttom and play first episode
And Play for a while and click on next episode button
And Play for a while and click on next episode button
And play for a while and close the player
And navigate to my watch history
Then verify played sho availability


Examples:
| searchName |
| carmen |


Scenario Outline: Verify that watch history is capturing records when hitting on the next episode
Given search <searchName> sho or series or studio
When Scroll to buttom and collect all episodes


Examples:
| searchName |
| carmen |


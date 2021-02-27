Feature: Checking Sreaming page functionality


Scenario: To check the page titles and Redirection of sho card-1
Given verify all the titles are available on the streaming page
When click on any sho card

Scenario: Redirection of sho card-2
Given To check the redirection of sho card in particular row
Then check the page has redirected correctly

Scenario: Redirection of sho card-3
Given Check the redirection of sho card in particular row from all sho page
Then check the page has redirected correctly

Scenario: Play promo and give count and check the view count and gud count-1
Given Play the promo and like the promo and check the count
Then Again play the same promo and dislike and now see the gud count

Scenario: Play the promo and give count and check and view count and gud count-2
Given To check gud and view count of promo from all promos page after like
Then To check gud and view count of promo from all promos page after dislike

Scenario: Follow and unfollow the studio and check coresponding followers count and redirection of studio page
Given Click on the studio name check its redirecting to correct page
When Click on follow and followers count should increase by one
Then Click on same studio and check the followers count on the studio profile page
And unfollow the same studio from studio page and check the count should decrease
Then check on streaming page also the count should decrease and button should change

Scenario: Play any audio do fav/unfav-1
Given Play any audio and check player opend and audio is playing
When Play next and previous song and check its playing correctly
Then Click fav and check its marked in to fav

Scenario: Play any audio do fav/unfav-2
Given Click on pagetitle to redirect the all songs page
Given Play any audio and check player opend and audio is playing
When Play next and previous song and check its playing correctly
Then Click fav and check its marked in to fav

@undev
Scenario: promo Share on streaming page 
Given Share the promo by facebook from streaming page
Then Share the promos by twitter from streaming page
Then Share the promos by whatsapp from streaming page
Then Share the promos by copylink from streaming page

Scenario: To check promo share inside the promo page
Given Click on all promos title and facebook share
Then Share the promos by twitter from streaming page
Then Share the promos by whatsapp from streaming page
Then Share the promos by copylink from streaming page

@undev
Scenario: Audio share on streaming page
Given Share the audio by facebook from streaming page
Then Share the audio by twitter from streaming page
Then Share the audio by whatsapp from streaming page
Then Share the audio by copylink from streaming page

@undev
Scenario: Audio share inside the audio page
Given click on all audios andShare the audio by facebook
Then Share the audio by twitter from streaming page
Then Share the audio by whatsapp from streaming page
Then Share the audio by copylink from streaming page


Scenario: To add watch list is working from streaming page
Given Add to watch list from streaming page
Then remove from watch list


Scenario: To add watch list is working from streaming page and from particular row
Given Add to watch list from streaming page from particular row
Then remove from watch list from particular row


Scenario: To add watch list is working from streaming page and from all page
Given Add to watch list from streaming page from particular row from all sho or series page
Then remove from watch list from particular row from all page

@undev
Scenario: To Check the continue watching removing section and contiue watching should display
Given Remove the continue watching from the streaming page
Then check the removed sho or episode should not visible again in continue watching

@undev
Scenario: Click o continue watchng see the redirection
Given click on any sho or episode card on continue watching 
Then Check the redirected correctly or not







Scenario Outline: To check the season dropdowns and Episode count
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then check season dropdown and episodes are displaying and verify the episode count is showing correctly


Examples:
|keyword|shoseries or studioname|
|Talent  |Talent                |

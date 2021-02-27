Feature: Functionality to Studio profile frontend


Scenario Outline: To check the Studio info including the followers count,sho and series count
Given In search enter <keyword> and select wanted <shoseries or studioname>  
When It should redirect to the correct <shoseries or studioname> page
And verify all the studiodetails are showing in the page
When Click on the studio info
Then See studioinfo and click back 
 
Examples:
|keyword    |shoseries or studioname|
|sameer     |Sameer                 | 


Scenario Outline: Adding a sho or series to watch list from studio profile page
Given In search enter <keyword> and select wanted <shoseries or studioname>
When It should redirect to the correct <shoseries or studioname> page
When Mousehover on given <shoorseriesname> and add to watchlist
And verify the <toastmessage>



Examples:
|keyword    |shoseries or studioname   |shoorseriesname      | toastmessage   |
|sameer     |Sameer             |RRR-2         |Rrr-2 has been added to watchlist|


Scenario Outline: Removed a sho or series from watch list from studio profile page
Given In search enter <keyword> and select wanted <shoseries or studioname>
When It should redirect to the correct <shoseries or studioname> page
When Mousehover on given <shoorseriesname> and add to watchlist
And verify the <toastmessage>

Examples:
|keyword    |shoseries or studioname   |shoorseriesname      | toastmessage   |
|sameer     |Sameer             |RRR-2                | Rrr-2 has been removed from watchlist|


Scenario Outline: To check all sho and series and audio tracks in All genere
Given In search enter <keyword> and select wanted <shoseries or studioname>
When It should redirect to the correct <shoseries or studioname> page
Then Check all the sho and shoseries and promos and audiotracks
 
Examples:
|keyword    |shoseries or studioname   |
|sameer     |Sameer                    | 


Scenario Outline: Verify Rowtitile names
Given In search enter <keyword> and select wanted <shoseries or studioname>
When It should redirect to the correct <shoseries or studioname> page
Then verify <rowtitle name> on the page with <expected rowtitle name>

Examples:
|keyword    |shoseries or studioname   |rowtitle name       |expected rowtitle name|
|sameer     |Sameer                    |Trending Shos       |Trending Shos                |


Scenario Outline: Verification of all shoorseries names in all generes
Given In search enter <keyword> and select wanted <shoseries or studioname>
When It should redirect to the correct <shoseries or studioname> page
Then click on each genere and capture the all shoandseries in the genere

Examples:
|keyword    |shoseries or studioname  |
|sameer     |Sameer                   | 


Scenario Outline: Verification of shoorseries name in <generename>
Given In search enter <keyword> and select wanted <shoseries or studioname>
When It should redirect to the correct <shoseries or studioname> page
Given click on <generename> and capture shoorseries name
When Verify the click opertion is happening on right <generename>

Examples:
|keyword    |shoseries or studioname   |generename        |
|sameer     |Sameer                    |Social       |


Scenario Outline: Verification of <shoorseries> name in <generename>
Given In search enter <keyword> and select wanted <shoseries or studioname>
When It should redirect to the correct <shoseries or studioname> page
Then click on <generename> and capture shoorseries name
And verify <shoorseries> is present in the particular genere
Then click on <shoorseries> on other <generename> and verify the shotitle

Examples:
|keyword    |shoseries or studioname  |generename       | shoorseries   |
|sameer     |Sameer                   |  Action         |Singh is King  |
|sameer     |Sameer                   |  Historical     |Talent     |


Scenario Outline: See the sho or series detail page from banner -view more
Given In search enter <keyword> and select wanted <shoseries or studioname>
When It should redirect to the correct <shoseries or studioname> page
Then Click on view more from banner to see <shoorseriesname> 
And verify shoorseriesname with shoorseries detail page
 
Examples:
|keyword    |shoseries or studioname   |shoorseriesname |
|sameer     |Sameer                    | Singh is King   |

	
Scenario Outline: See the sho or series trailer from the studio profile
Given In search enter <keyword> and select wanted <shoseries or studioname>
When It should redirect to the correct <shoseries or studioname> page
And Click on play trailer button from banner to see <shoorseriesname>
Then Verify the page title of the promo <shoorseriesname>

Examples:
|keyword    |shoseries or studioname   |shoorseriesname|
|sameer     |Sameer                    |Singh is King   |


Scenario Outline: See the sho or series trailer from the studio profile-Play Trailer
Given In search enter <keyword> and select wanted <shoseries or studioname>
When It should redirect to the correct <shoseries or studioname> page
And Click on play trailer button from banner to see <shoorseriesname>
Then check error toast message as "Currently no Trailer available"

Examples:
|keyword    |shoseries or studioname   |shoorseriesname|
|sameer     |Sameer                    |ranam-roudhram |


Scenario Outline: promo Share inside page
Given In search enter <keyword> and select wanted <shoseries or studioname>
When It should redirect to the correct <shoseries or studioname> page
And click on latestpromos page to see all the promos by clicking on <rowtitle name>
Then Share the promo by facebook
Then Share the promo by twitter
Then Share the promo by whatsapp
Then Share the promo by copylink
And come back

Examples:
|keyword    |shoseries or studioname   |rowtitle name|
|sameer     |Sameer                    |Latest Promos|




Scenario Outline: audio Share 
Given In search enter <keyword> and select wanted <shoseries or studioname>
When It should redirect to the correct <shoseries or studioname> page
Then Share the audio by facebook
Then Share the audio by twitter
Then Share the audio by watsapp
Then Share the audio by copylink

Examples:
|keyword    |shoseries or studioname   |
|sameer     |Sameer                    |


@fail
Scenario Outline: Studio Share 
Given In search enter <keyword> and select wanted <shoseries or studioname>
When It should redirect to the correct <shoseries or studioname> page
Then share studio by facebook
Then share studio by twitter
Then share studio by whataspp
Then share studio by copylink

Examples:
|keyword    |shoseries or studioname   |
|sameer     |Sameer                    |


Scenario Outline: Play any promo and see the view and gud count incremented by 1 
Given In search enter <keyword> and select wanted <shoseries or studioname>
When It should redirect to the correct <shoseries or studioname> page
Then The view count and gud count sould be incremented by one after promo play
And click on latestpromos page to see all the promos by clicking on <rowtitle name>
Then The view and gud count also same in inside the page 

Examples:
|keyword    |shoseries or studioname   |rowtitle name|
|sameer     |Sameer                    |Latest Promos|



Scenario Outline: Play any promo and see the view and gud count decremneted by 1 
Given In search enter <keyword> and select wanted <shoseries or studioname>
When It should redirect to the correct <shoseries or studioname> page
Then The view count and gud count sould be decremented by one after promo play
And click on latestpromos page to see all the promos by clicking on <rowtitle name>
And click on latestpromos page to see all the promos by clicking on <rowtitle name>
Then The view and gud count also same in inside the page

Examples:
|keyword    |shoseries or studioname   |rowtitle name|
|sameer     |Sameer                    |Latest Promos|

@fail
Scenario Outline:Follow us on
Given In search enter <keyword> and select wanted <shoseries or studioname>
When It should redirect to the correct <shoseries or studioname> page
Then Follow the studio by facebook
Then Follow rhe studio by twitter
Then Follow the studio by instagram
Then Follow the studio by linkedin
Then Follow the studio by website


Examples:
|keyword    |shoseries or studioname   |
|sameer     |Sameer                    |  


Scenario Outline: Sho or series share
Given In search enter <keyword> and select wanted <shoseries or studioname>
When It should redirect to the correct <shoseries or studioname> page
Then Mousehover on given <shoorseriesname> and share

 Examples:
|keyword    |shoseries or studioname   |shoorseriesname      | 
|sameer     |Sameer             |RRR-2         |
 

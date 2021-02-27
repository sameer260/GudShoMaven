Feature: Shocial Page functionalities


Scenario: To check the search field for invalid data
Given invalid data in to the search field
Then Check the text it should show no searh found text




##########################           Watch List           #######################################################################
@End2End
Scenario Outline: Add watch list from Sho detail page and check its displaying on home page
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Click on watch list button and check the same sho is present on homepage
And The <title> will display

Examples:
|keyword|shoseries or studioname|title|
|Talent|Talent|My Watch List|


Scenario Outline: Remove from watch list from Sho detail page and check its displaying on home page
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Click on watch list button and check the same sho is removed from homepage

Examples:
|keyword|shoseries or studioname|
|Singh  |Singh Is King |


Scenario Outline: Add watch list from Sho detail page and check its displaying on home page after scrolldown
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Click on watch list button after scrolldown and check the same sho is present on homepage and check <toastmessage>

Examples:
|keyword|shoseries or studioname|toastmessage|
|Singh  |Singh Is King |has been added to watchlist|
|Wedding|Wedding Life|has been added to watchlist|


Scenario Outline: Remove watch list from Sho detail page and check its displaying on home page after scrolldown
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Click on watch list button after scrolldown and check the same sho is present on homepage and check <toastmessage>

Examples:
|keyword|shoseries or studioname|toastmessage|
|Singh  |Singh Is King |has been removed from watchlist|


Scenario Outline: Add to watch list from Promo minititle page
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Click on watch list button from promo minititle and check <toastmessage>


Examples:
|keyword|shoseries or studioname|toastmessage|
|Singh  |Singh Is King |has been added to watchlist|


Scenario Outline: remove from watch list from Promo minititle page
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Click on watch list button from promo minititle and check <toastmessage>

Examples:
|keyword|shoseries or studioname|toastmessage|
|Singh  |Singh Is King |has been removed from watchlist|


Scenario Outline: Add to watch list from Studio detail page
Given In search enter <keyword> and select wanted <shoseries or studioname>
When It should redirect to the correct <shoseries or studioname> page
Then Click on watch list on <shoname> and <toastmessage> and check on home page

Examples:
|keyword|shoseries or studioname|shoname|toastmessage|
|Sameer  |Sameer |RRR-2|has been added to watchlist|


Scenario Outline: Remove from watch list from Studio detail page
Given In search enter <keyword> and select wanted <shoseries or studioname>
When It should redirect to the correct <shoseries or studioname> page
Then Click on watch list on <shoname> and <toastmessage> and check on home page

Examples:
|keyword|shoseries or studioname|shoname|toastmessage|
|Sameer  |Sameer |RRR-2|has been removed from watchlist|



Scenario Outline: Add and Remove from watch list from HomePage
Given Mouse hover on <shoseries or studioname> and remove from watchlist verify the <toastmessage>
And Removed <shoseries or studioname> should not on home page

Examples:
|keyword|shoseries or studioname|toastmessage|
|Wedding  |Wedding Life |has been removed from watchlist|

Scenario Outline: Add watch list from Sho detail page and check its displaying on home page after scrolldown
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Click on watch list button after scrolldown and check the same sho is present on homepage and check <toastmessage>

Examples:
|keyword|shoseries or studioname|toastmessage|
|Wedding|Wedding Life|has been added to watchlist|


Scenario Outline:Check redirection of sho card
Given Click on <shoname> and it should redirect to correct sho detail page

Examples:
|shoname|
|Talent|


Scenario Outline: Sho Share from Home page
Given Share <shoname> via all social links

Examples:
|shoname|
|Talent|

#############     Check Following/Unfollowing Studios      ##################

@End2End
Scenario Outline: Follow studio from studio profile Page
Given In search enter <keyword> and select wanted <shoseries or studioname>
When It should redirect to the correct <shoseries or studioname> page
Then Click on Follow button on Studio Page and check the same <shoseries or studioname> is visibile on home page
And The <title> will display

Examples:
|keyword|shoseries or studioname|title|
|sameer |Sameer|Following Studios|

Scenario Outline: Follow the studio from header
Given In search enter <keyword> and select wanted <shoseries or studioname>
When It should redirect to the correct <shoseries or studioname> page
Then Click on Follow button on Studio Page from headder and check the same <shoseries or studioname> is visibile on home page

Examples:
|keyword|shoseries or studioname|
|Naveen  |Naveen |


Scenario Outline: Follow studio from studio profile Page
Then From homepage click on <shoseries or studioname> and unfollow the studio
And Check from home page <shoseries or studioname> the studio is invisble


Examples:
|keyword|shoseries or studioname|
|sameer |Sameer|

Scenario Outline: Add/Remove to from watch list from Latest titles Section
Given Add to watch list from latestitles and <toastmessage>
Then remove to watch list from latestitles and <toastmessage1>

Examples:
|toastmessage|toastmessage1|
|has been added to watchlist|has been removed from watchlist|

##########################  After Follow studio Check the My Titles and Latest trailers are visible ############################

Scenario: After follow any studio the studio related titles and Latest Promos should display
Given Check the latest promos and latest titles heading text is displyed
Then Just printout the promos and titles card names

##################################    Sho Card Share and redirection  ########################################


Scenario: Check redirection of sho card from Latest titles
Given Redirection of shocard from latestst titles and it should redirect to correct sho detail page



Scenario: Sho card share from Latest tiles
Given Share shocard from latestst titles


################################## My Fav Audios     ############################################################

@End2End
Scenario Outline: Add fav audios from shodetail page
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Play <audio> and fav the audio and same check same on my fav audios
And The <title> will display

Examples:
|keyword|shoseries or studioname|audio|title|
|Wedding|Wedding Life|[iSongs.info] 01 - Shatagni Anthem.mp3|My Favourite Audios|
|Wedding|Wedding Life|[Isongs.info] 02 - Endhukho Emo.mp3 |My Favourite Audios|


Scenario Outline: Remove fav audios from shodetail page
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Play <audio> and fav the audio and same check same on my fav audios

Examples:
|keyword|shoseries or studioname|audio|
|Wedding|Wedding Life|[iSongs.info] 01 - Shatagni Anthem.mp3|


Scenario Outline: Add fav audios from Studio detail page
Given In search enter <keyword> and select wanted <shoseries or studioname>
When It should redirect to the correct <shoseries or studioname> page
Then Play <audio> and fav the audio from studio detail page and same check same on my fav audios

Examples:
|keyword|shoseries or studioname|audio|
|Sameer|Sameer|01 - Vakil Saab|


Scenario Outline: Remove fav audios from Studio detail page
Given In search enter <keyword> and select wanted <shoseries or studioname>
When It should redirect to the correct <shoseries or studioname> page
Then Play <audio> and fav the audio from studio detail page and same check same on my fav audios

Examples:
|keyword|shoseries or studioname|audio|
|Sameer|Sameer|Bhoom Bhaddhal |


Scenario Outline: Share audio from home page
Given Share <audio> from home page

Examples:
|audio|
|[Isongs.info] 02 - Endhukho Emo.mp3|


Scenario Outline: Remove fav audios from home Page
Then Play <audio> and fav the audio from studio detail page and same check same on my fav audios

Examples:
|keyword|shoseries or studioname|audio|
|Sameer|Sameer|[Isongs.info] 02 - Endhukho Emo.mp3 |




###########################################   My Gud Promos     ########################################

@End2End
Scenario Outline: Like the promo and check on home page from shodetailpage
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Play the <promo> and like the promo and check on home page
And The <title> will display

Examples:
|keyword|shoseries or studioname|promo|title|toastmessage|
|Kaithi|Kaithi - Tamil| Kaithi - Official Teaser|My Gud Promos|You liked this promo|
|Kaithi|Kaithi - Tamil|Kaithi Fight Bgm _ Aasai Athigam Song|My Gud Promos|You liked this promo|


Scenario Outline: DisLike the promo and check on home page from shodetailpage
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Play the <promo> and dislike the promo and check on home page
And The <title> will display

Examples:
|keyword|shoseries or studioname|promo|title|
|Kaithi|Kaithi - Tamil| Kaithi - Official Teaser|My Gud Promos|


Scenario Outline: Like promo and check view and gud count from studio profile page
Given In search enter <keyword> and select wanted <shoseries or studioname>
When It should redirect to the correct <shoseries or studioname> page
Then Play promo from stuido profile page and check on home page
And The <title> will display

Examples:
|keyword|shoseries or studioname|title|
|Sameer|Sameer|My Gud Promos|


Scenario Outline: Like promo and check view and gud count from studio profile page
Given In search enter <keyword> and select wanted <shoseries or studioname>
When It should redirect to the correct <shoseries or studioname> page
Then Play promo from stuido profile page and check on home page after dislike
And The <title> will display

Examples:
|keyword|shoseries or studioname|title|
|Sameer|Sameer|My Gud Promos|


Scenario Outline: Share the promo from my gud promos
Given Share the <promo> from my gud promos

Examples:
|promo|
|Kaithi Fight Bgm _ Aasai Athigam Song|


Scenario Outline: Dislike the promo from home page and it should hide
Given Dislike the <promo> from the home page and check its should invisble
And The <title> will display

Examples:
|promo|title|
|Kaithi Fight Bgm _ Aasai Athigam Song|My Gud Promos|


Scenario: Like the promo from latest promos
Given Play the promo from the latestpromos and like the promo


Scenario: Promo Share from latest titles
Given Share the promo from latest promos section

################################   Continue Watching Scenarios   ##############################

Scenario Outline: Play any sho or series and check its displayed in continue watching-for sho
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Play <shoseries or studioname> and check on home page in continue watching and remove

Examples:
|keyword|shoseries or studioname|
|Singh|Singh Is King|


Scenario Outline: Play any sho or series and check its displayed in continue watching-For Series
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Check continue watching after playing and series and remove

Examples:
|keyword|shoseries or studioname|
|Red|Red|





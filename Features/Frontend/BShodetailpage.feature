Feature: Functonality of Sho or series detail page


#############                              Watch List Scenarios & Elements                              #######

Scenario Outline: Check the sho or series redirect to correct page
Given In search enter <keyword> and select wanted <shoseries or studioname>
Then Check the page title and <shoseries or studioname>is showing on page
And check <shoseries or studioname> and watch list button is dsiplaying
Then Scrolldown and check the watchlist is showing <shoseries or studioname>

Examples:
|keyword|shoseries or studioname|
|Talent|Talent          |


Scenario Outline: Check the studio name is displayed and studio link is clickable
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then check studioname is displayed and studioname should matches with <studioname>
And Click on <studioname> and check the redirection of the page

Examples:
|keyword|shoseries or studioname|studioname|
|Singh|Singh Is King           |Sameer's    |


Scenario Outline: Check that sho or series and details of the sho or series
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then The sho type is <sho or series>
And The season counts should be <totalseason>
And The maturity rating is <rating>
And The default genere is <genere>
And The languages showing <language>
And The screensdate should be <screened date>

Examples:
|keyword|shoseries or studioname|sho or series|totalseason|rating     |genere|language |screened date|
|Talent|Talent           |Series       |7 Seasons  |All  |Action |ENGLISH |Nov 2020|


Scenario Outline: Check the Sho or series description is displaying
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then check sho or series description is displaying
And The main heading of sho or series detail is showing

Examples:
|keyword|shoseries or studioname|
|Singh|Singh Is King            |


Scenario Outline: Check the readmore link is visible or not and check the redirection of readmore link
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Check the readmore link is showing and click on it

Examples:
|keyword|shoseries or studioname|
|Singh  |Singh Is King          |


Scenario Outline: Click on watchList button to add into watch list check the toast message
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then click on watchlist button from sho detail page
And verify the <toastmessage>

Examples:
|keyword|shoseries or studioname|toastmessage|
|Singh  |Singh Is King                  |Singh Is King has been added to watchlist|


Scenario Outline: Click on watchList button to remove from watchlist check the toast message
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then click on watchlist button from sho detail page
And verify the <toastmessage>

Examples:
|keyword|shoseries or studioname|toastmessage|
|Singh  |Singh Is King                  |Singh Is King has been removed from watchlist|


Scenario Outline: Click on watchList button to add into watch list after scroll down
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then scroll down the page and click on watchlist button
And verify the <toastmessage>

Examples:
|keyword|shoseries or studioname|toastmessage|
|Minister  |Minister                  |Minister has been added to watchlist|


Scenario Outline: Click on watchList button to remove from watchlist after scroll down
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then scroll down the page and click on watchlist button
And verify the <toastmessage>

Examples:
|keyword|shoseries or studioname|toastmessage|
|Minister  |Minister                  |Minister has been removed from watchlist|

@share
Scenario Outline: Sho or series share
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
And Check share button is visible and share with facebook
Then check share button is visble and share with twitter
Then check share button is visble and share with watsapp share
Then check copylink button is visble and share with copylink share

Examples:
|keyword|shoseries or studioname|
|Singh  |Singh Is King                  |

@share
Scenario Outline: Sho or series share after scroll down
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Scrolldown the page for header share button

Examples:
|keyword|shoseries or studioname|
|Wedding  |Wedding Life                  |

@share
Scenario Outline: Promo Share
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Share <promo name> via facebook
Then Share <promo name> via twitter
Then Share <promo name> via whatsapp
Then Share <promo name> via copy link

Examples:
|keyword|shoseries or studioname|promo name|
|Singh  |Singh Is King          |Promo-2|


Scenario Outline: Check the Feelers headings and feelers percentage
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Feelers is visible and check all the feelers titles

Examples:
|keyword|shoseries or studioname|
|Minister  |Minister         |


Scenario Outline: Check the promos are avilable in shodetail page
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Check whether the sho or series have promos and extras section

Examples:
|keyword|shoseries or studioname|
|Talent  |Talent   |


Scenario Outline: Play promo from sho detail page
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Play the <promo name> from sho detail page
And check same <promo name> is displayed on player


Examples:
|keyword|shoseries or studioname|promo name|
|Wedding  |Wedding Life    |Waterscape_2.mp4 |

@End2End
Scenario Outline: To check View count and Gud Count on sho detail page after like
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Play <promo name> from sho detail page and check the view and gud count incremented by one

Examples:
|keyword|shoseries or studioname|promo name|
|Wedding   |Wedding Life    |Waterscape_2.mp4         |


Scenario Outline: To check View count and Gud Count on sho detail page after unlike
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Play <promo name> from sho detail page and check the view and gud count decremented by one

Examples:
|keyword|shoseries or studioname|promo name|
|Wedding   |Wedding Life    |Waterscape_2.mp4         |


Scenario Outline: Check the Musical tracks is available in sho or detail page
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then check musical tracks title is displaying

Examples:
|keyword|shoseries or studioname|
|Wedding  |Wedding Life    |


Scenario Outline: Check the Musical tracks are availble and Play all button is avilable or not
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Check <name> and total <nooftracks> and <duration> and play all button is displayed

Examples:
|keyword|shoseries or studioname|name|nooftracks|duration|
|Wedding   |Wedding Life    |sameer|2 Tracks|5.67m|


Scenario Outline: Check the header titles of Audio section
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then check all the titles are displaying

Examples:
|keyword|shoseries or studioname|
|Wedding   |Wedding Life    |


Scenario Outline: Check the Musical tracks are availble and Play all button is avilable or not
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Click on Playall button and check the audio player is opened and playing first song

Examples:
|keyword|shoseries or studioname|
|Wedding  |Wedding Life    |


Scenario Outline: Play the Wanted audio name from the Musical tracks and Verify its playing correct Audio 
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Play <audio name> from the player section

Examples:
|keyword|shoseries or studioname|audio name|
|Wedding  |Wedding Life    |[Isongs.info] 02 - Endhukho Emo.mp3|


Scenario Outline: To check the Audios is switching by clicking next and previos button
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Click on Playall button and check the audio player is opened and playing first song
And Click on next song and verify its switched right song
And click on previous song and verify its switched previous song 

Examples:
|keyword|shoseries or studioname|
|Wedding|Wedding Life    |

@share
Scenario Outline: Check the Synposis heading and details are visible and print it
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Check all lined details headings are showing and correct

Examples:
|keyword|shoseries or studioname|
|Wedding  |Wedding Life    |


Scenario Outline: Check the Synposis heading and details are visible and print it
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then The Specifics heading and the Specifics details

Examples:
|keyword|shoseries or studioname|
|Wedding  |Wedding Life    |

Scenario Outline: Check the Castdetails heading and details are visible and print it
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then The cast details heading and the cast details

Examples:
|keyword|shoseries or studioname|
|New  |New Sho    |


Scenario Outline: Check the Crew details heading and details are visible and print it
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then The crew details heading and the crew details

Examples:
|keyword|shoseries or studioname|
|Wedding  |Wedding Life    |





Scenario Outline: Check the episode link is working and same verify all the seasons and episodes are showing
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Season dropdown is displaying and corresponsing episodes

Examples:
|keyword|shoseries or studioname|
|Talent |Talent                |

@fail
Scenario Outline:Check the same episodes are displaying in shodetailpage and episode page
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then verify same episodes names is displaying in episode page and shodetail page with <seasonname>


Examples:
|keyword|shoseries or studioname|seasonname|
|Talent |Talent                |Season 4  |


Scenario Outline:Check the maturity rating,description and timing is diplaying in episode page
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then should display description and time and <maturity rating>


Examples:
|keyword|shoseries or studioname|maturity rating|
|Talent  |Talent                |All            |


Scenario Outline: Check the back button and series name in episode detail page
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Check the back button and series link is working as expected in episode detail page


Examples:
|keyword|shoseries or studioname|
|Talent  |Talent                | 


Scenario Outline: Check the episode is playng without buy from the shodetail page episodes section
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then play any episode from <seasonname> 


Examples:
|keyword|shoseries or studioname|seasonname|
|Minister  |Minister                |Season 1  |


Scenario Outline: Check the episode is playng without buy from the episode page
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then From episode page play any episode from <seasonname>

Examples:
|keyword|shoseries or studioname|seasonname|
|Minister  |Minister                |Season 1  |


Scenario Outline: Play Sho or series from shodetail page
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Buy or play the sho or series with <payment method> and check the <shoseries or studioname> is playing


Examples:
|keyword|shoseries or studioname|payment method|
|Talent |Talent                 |Debit or Credit Card|


Scenario Outline: Play Sho or series from shodetail page-watch free
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Watch free sho or series from sho detail page


Examples:
|keyword|shoseries or studioname|
|News |News                     |


Scenario Outline: Play Sho or series from shodetail page-coming soon
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then verify coming soon text


Examples:
|keyword|shoseries or studioname|
|Mundasupatti |Mundasupatti     |


Scenario Outline: Play Sho or series from shodetail page after scroll down
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Scroll down the page and play or buy <shoseries or studioname>  with <payment method>

Examples:
|keyword|shoseries or studioname|payment method|
|Talent |Talent                 |Debit or Credit Card|


Scenario Outline: Play Sho or series from shodetail page after scroll down-watch free
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Scroll down and watch free the sho or series

Examples:
|keyword|shoseries or studioname|
|News |News|


Scenario Outline: Play Sho or series from shodetail page after scroll down-coming soon
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Scroll down and coming soon the sho or series

Examples:
|keyword|shoseries or studioname|
|Mundasupatti |Mundasupatti|


Scenario Outline: Check the mini title detailsfor series
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Play promo and while switching promo check the details of mini title

Examples:
|keyword|shoseries or studioname|payment method|
|Web |Web Series             |Debit or Credit Card|


Scenario Outline: Check the mini title details for series-last promo
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Play promo and while switching promo check the details of mini title after all promos play

Examples:
|keyword|shoseries or studioname|
|Talent |Talent          |


Scenario Outline: Check the mini title cancel for series
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Check the cancel button in minititle

Examples:
|keyword|shoseries or studioname|
|Trolls |Trolls            |


Scenario Outline: Check the mini title details for sho
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Buy the sho or series from minititle and verify the details

Examples:
|keyword|shoseries or studioname|
|Singh |Singh Is King           |


Scenario Outline: Check the mini title details for sho-watch free
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then watch free sho or series

Examples:
|keyword|shoseries or studioname|
|Ranam |Ranam|


Scenario Outline: Check the watch free content is playing from  episode section
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Play the any episode from shodetail page for watch free content

Examples:
|keyword|shoseries or studioname|
|Carmen |Carmen Sandiago|


Scenario Outline: Check the watch free content is playing from episode page section
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Play the any episode from episode page for watch free content

Examples:
|keyword|shoseries or studioname|
|Carmen |Carmen Sandiago|


Scenario Outline: Check the mini title details for sho-comingsoon
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then The text should show coming soon

Examples:
|keyword|shoseries or studioname|
|Mundasupatti |Mundasupatti|


Scenario Outline: Check the episode is playing after bought from the shodetail page episodes section
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Play episode from <seasonname> in episode detailpage which already bought 


Examples:
|keyword|shoseries or studioname|seasonname|
|Talent |Talent               |Season 1  |



Scenario Outline: Check the episode is playing after bought from the Episode detail page
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Play episode from <seasonname> in episode detailpage which already bought


Examples:
|keyword|shoseries or studioname|seasonname|
|Talent  |Talent               |Season 1  |


Scenario Outline: Add feleres concept
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then The feelers should be update when i am giving the <feeler>

Examples:
|keyword|shoseries or studioname|feeler|
|Talent  |Talent                |Comedy|



Scenario Outline: Audio Share 
Given In search enter <keyword> and select wanted <shoseries or studioname>
When Check the page title and <shoseries or studioname>is showing on page
Then Click on Playall button and check the audio player is opened and playing first song
And Share audio with facebook
And Share audio with twitter
And Share audio with watsapp
And Share audio with copylink

Examples:
|keyword|shoseries or studioname|
|Wedding |Wedding Life|











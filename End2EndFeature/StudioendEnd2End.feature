Feature: End 2 End Flow of Studio End

Background: Redirection to My Studio Page
Given Go to Studio End by clicking on My studio or create studio

Scenario Outline: Check Footer text and Complete create Studio Module
Given the footer text should match and check box should select
When After filling all details do <action>

Examples:
|action|
|createstudio|

Scenario Outline: To check the Visibilty of Studio On frontend
Given visibility of studio to <visibility>
When Go to frontend and search the studio

Examples:
|visibility|
|Private|
|Public|







			
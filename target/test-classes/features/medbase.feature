Feature: In order to test the AUT As a registered user I want to run the following test
Background:

Given I have navigated to the AUT
And I log in with valid Credentilas
|njF83mf@jN7p.z7B|3K4Mq*S%1ejqV0iu^glcK&o$m4q^D157|

@practical1
Scenario Outline: Update the logged-in-user's details
	When I navigate to the Logged-In-User's Profile page
	And I update the work address details
	|medbase|2nd floor|6 Broad Street|East London|E16 4HB|
	And I update the <Contact-option> by <options>
	And I confirm that an error occurs upon attempting to save without populating the required fields
	And I save the changes
	Then My changes should have successfully applied
Examples:
|Contact-option         |options |
|All                    |Email   |

@practical1
Scenario: Assert management information report results
	When I navigate to the Absence Overview page
	And I set the time window
	| START DATE | END DATE   |
	| 30/04/2019 | 30/10/2019 |
	And I update the data
	Then The employee surnames on the first 5 pages should include "Streater", "Acland" and "De la Yglesia", but not "Graddon" or "Shoobridge"
	And Print the number of occurrences to the browser console

@practical
Scenario: Compare absence data with local file
	When I navigate to the Absence Management page
	And I use "Y" as the search criteria
	And I perform the search
	And I generate the CSV containing the search results
	When I download the spreadsheet to a predefined directory on the local machine
	Then The data in the spreadsheet should be consistent with the data displayed on screen
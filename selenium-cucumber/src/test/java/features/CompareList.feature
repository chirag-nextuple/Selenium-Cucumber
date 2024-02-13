Feature: Compare products

@CompareTest
Scenario: Adding items to compare list

Given User is on login page
And User login with <email> <password>
When User adds items to compare list
Then Validate items present in compare list

Examples:
|						email							  |  password  | 
|gehomibrunne-6442@yopmail.com	| Password123|	
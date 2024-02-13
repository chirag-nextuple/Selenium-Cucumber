Feature: Login

@LoginTest
Scenario: User login

Given User is on login page
When User enters email <email> and password <password> 
Then Verify successful login of user <first_name> <last_name>

Examples:
|						email							    |  password  | first_name | last_name |
|gehomibrunne-6442@yopmail.com		| Password123|	Chirag		|	Sharda		|
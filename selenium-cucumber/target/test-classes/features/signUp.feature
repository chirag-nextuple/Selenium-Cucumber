Feature: Sign Up


@SignupTest
Scenario: User is creating an account

Given User is on sign up page
When User entered his personal informaton <First_Name> <Last_Name> <email> <password> <confirm_password>
And Clicked create an account
Then Validate successful sign up and welcome message 

Examples:
|First_Name|Last_Name|						email								|  password  |confirm_password|
|	Chirag	 |	Sharda |gehomibrunne-6442@yopmail.com  	| Password123|	Password123		|

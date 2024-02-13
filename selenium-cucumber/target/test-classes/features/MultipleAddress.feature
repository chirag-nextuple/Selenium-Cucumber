Feature: Multiple address checkout

@MultiaddressTest
Scenario: User wants to checkout with multiple addresses

Given User is on login page
And User login with <email> <password>
And User adds items to cart
When User adds new address with details <Addressline1> <Addressline2> <City> <Zipcode> <Phone> 
Then Verify order success

Examples:
|						email							 |  password   |Addressline1|Addressline2|City |Zipcode|	Phone	   |	
|gehomibrunne-6442@yopmail.com | Password123 |		Street2	|		Area2	   |City2| 654321|9999999999 |
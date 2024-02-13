Feature: Checkout

@OrderCreation	
Scenario: Create order and validate success

Given User is on login page
And User login with <email> <password>
And User adds items to cart
When User process to checkout with details <Addressline1> <Addressline2> <City> <Zipcode> <Phone> 
Then Verify order success
And Validate in my account order section

Examples:
|						email							 |  password   |Addressline1|Addressline2|City|Zipcode|	Phone	   |	
|gehomibrunne-6442@yopmail.com | Password123 |		Street	|		Area	   |City| 123456|9999999999|
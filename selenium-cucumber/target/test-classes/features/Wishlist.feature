Feature: Wishlist

@WishlistTest
Scenario: Adding and verifying items in wishlist

Given User is on login page
And User login with <email> <password>
When User adds items to wishlist
Then Verify same items present

Examples:
|						email							  |  password  | 
|gehomibrunne-6442@yopmail.com	| Password123|	
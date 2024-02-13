Feature: Edit wishlist

@EditWishlistTest
Scenario: User edits wishlist

Given User is on login page
And User login with <email> <password>
And User goes to wishlist
And User deletes an item 
Then Verify item deleted

Examples:
|						email						  	|  password  | 
|gehomibrunne-6442@yopmail.com	| Password123|	
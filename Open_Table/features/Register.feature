Feature: OpenTable Register Functionality

    
Background:
	Given the application browser is launched
    And the Open Table homepage is opened 



Scenario: Successful creation of an account
When user clicks Sign up button
And user enters the first name 
And user enters the last name 
And user enters the email
And user enters valid password
And user Reenters the password
And user selects the primary dining location
And user clicks on create account button
Then the homepage is reloaded
And user clicks on the profile icon
And user clicks on sign out option
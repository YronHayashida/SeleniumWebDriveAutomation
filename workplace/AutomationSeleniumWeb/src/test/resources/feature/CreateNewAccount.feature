@tag
Feature: Create nem Account

  I want to create a new account

	Background: 
		Given the user acces the menu user
    When click in create new account
  
  Scenario: Access page to create account
   Then should access the Create account Page

 	Scenario: Create a New Account
 		And insert "Account Details"
 		And insert "Personal Details"
 		And insert "Address"
 		And finalize registration 
 		Then should access the home Page
 		And show user correctly

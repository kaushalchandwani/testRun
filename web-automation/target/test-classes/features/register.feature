#Author: Kaushal.Chandwani@nhs.net
#Keywords Summary : Cucumber feature file for user registeration process to NHS account
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for a table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios 
#<> (placeholder)
#""
## (Comments)

#Feature Definition 

	Feature:  User Registration: 	As I user, I want to register successfully with NHS Account and login with two-factor authentication.

	@signin
	Scenario Outline: Sign up a new user
    Given the user is on login page of a NHS account
    When he click on register link for registration page navigation
    And he provides the valid emailaddress as "<emailaddress>" 
    And he provides the valid password as  "<password>" 
    And he provides the valid confirm password again as "<confirmpassword>"
    And he submit register button
    Then he should be navigated to Validate Email page
    
	Examples:
			| emailaddress         | password    | confirmpassword |
      | testdata26@nhs.net| Welcome123# | Welcome123#     |
      
	@signin
	Scenario Outline: Verify email for user registration process
    Given the user is login to his mail account to verify NHS account
    When he click on verify email link to verify NHS account with valid emailaddress as "<emailaddress>"
    Then he should be navigated to Account verified page
    
  Examples:
			| emailaddress |
			| testdata26@nhs.net|
  
    
@signin
  Scenario Outline: Login first time with two factor authentication process
    Given the user is on login page of a NHS account
    When he provides the valid emailaddress on login page as "<emailaddress>" 
    And he provides the valid password on login page as "<password>" 
    And he submit login button
    And he is navigated to twoFA page to input phoneno as "<contactno>" 
    And he is navigated to twoFA page to input security code for phoneno as "<contactno>"
    Then he should be navigated to account dashboard page
      
  Examples:
			| emailaddress         | password    | contactno |
      | testdata26@nhs.net| Welcome123# | +447567898743 |
      
@signin2fa
  Scenario Outline: Login second time with two factor authentication process
    Given the user is on login page of a NHS account
    When he provides the valid emailaddress on login page as "<emailaddress>" 
    And he provides the valid password on login page as "<password>" 
    And he submit login button
    And he is navigated to twoFA page to input security code for phoneno as "<contactno>"
    Then he should be navigated to account dashboard page
    
    Examples:
			| emailaddress         | password    | contactno |
      | testdata10@nhs.net| Welcome123# | +447987898789 |
      
@signin
  Scenario Outline: Using Forgot password feature to reset user password
    Given the user is on login page of a NHS account
    When he click on the forgotton your password link
    And he is navigated to forgot password page to specify email address as "<emailaddress>" to reset password
    And he clicked on submit button
    Then he should be navigated to successful password reset email sent page
      
  Examples:
			| emailaddress        |
      | testdata26@nhs.net| 
   

@signin2fa
  Scenario Outline: Login second time with two factor authentication process and resend OTP code
    Given the user is on login page of a NHS account
    When he provides the valid emailaddress on login page as "<emailaddress>" 
    And he provides the valid password on login page as "<password>" 
    And he submit login button
    And he is navigated to twoFA page to input resend security code for phoneno as "<contactno>"
    Then he should be navigated to account dashboard page
    
    Examples:
			| emailaddress         | password    | contactno |
      | testdata10@nhs.net| Welcome123# | +447987898789 |

  @signin
  	Scenario Outline: Reset user password via reset password link email
    Given the user is login to his mail account to reset password
    When he click on reset password link to reset password for NHS account with valid emailaddress as "<emailaddress>"
    And he should be navigated to password reset page 
    And he enters new password with confirm password as "<newpassword>"
    And he click on continue button on password reset page 
    Then he should be navigated to info page
    
 Examples:
			| emailaddress         | newpassword    | 
      | testdata26@nhs.net| Welcome123# | 
      
    @multiattemptUnvalidatedUser
	Scenario Outline: multi login attempt on unvalidated user
    Given the user is on login page of a NHS account
    When he click on register link for registration page navigation
    And he provides the valid emailaddress as "<emailaddress>" 
    And he provides the valid password as  "<password>" 
    And he provides the valid confirm password again as "<confirmpassword>"
    And he submit register button
    And he should be navigated to Validate Email page
    And when he click to back to sign in link
    And the user is on login page of a NHS account
    And he provides the valid emailaddress on login page as "<emailaddress>" 
    And he provides the valid password on login page as "<password>" 
    And he submit login button
    ##And he is navigated to twoFA page to input phoneno as "<contactno>" 
    And he should be navigated to Validate Email page
    And when he click to back to sign in link
    And the user is on login page of a NHS account
    And he provides the valid emailaddress on login page as "<emailaddress>" 
    And he provides the valid password on login page as "<password>" 
    And he submit login button
    ##And he is navigated to twoFA page to input phoneno as "<contactno>" 
    Then he should be navigated to validate email page with message of three attempts
     Examples:
			| emailaddress         | password    |confirmpassword | contactno|
      | testdata1004@nhs.net| Welcome123# | Welcome123# | +447987898789 |
      
 @delete
  	Scenario Outline: deletion of user account from admin console
    Given the user is logged in admin page 
    When he provides the valid emailaddress on login page as "<adminemailaddress>" 
    And he provides the valid password on login page as "<adminpassword>" 
    And he submit login button
    And he is navigated to twoFA page to input security code for phoneno as "<contactno>"
    And he is navigated to admin console for deletion of user account with username as "<username>" 
    Then the user should be successfully deleted
    
 Examples:
			| adminemailaddress| adminpassword |  username         | contactno |
      | realmadmin | Welcome123 | testdata21@nhs.net| +447931130685 |
     
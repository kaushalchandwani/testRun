#Author: jyothi.buddaraju1@nhs.net
#Keywords Summary : Cucumber feature file for user step up page process to NHS account
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Feature Definition 

Feature: StepUp Page - NHS number entry process: As a registered user with an NHS Account only
I want to understand what additional verification activities I need to perform
So I can access services which require a higher assurance level

  @nhsnumber
  Scenario: Accessing the NHS Step Up Page
    Given the user has navigated to the prove your identity page
		Then step up page is displayed
		And first option of Create an NHS account is shown as Completed 
		And second option of Your NHS number has a clickable Start button
	
	@nhsnumber
	Scenario: Accessing the Your NHS number Page
    Given the user is on the step up page
    When user click on the Start button visible in the second option of step up page
    Then Your NHS number page is displayed
  
  @nhsnumber1
  Scenario Outline: Valid NHS Number Entry in the Your NHS number page
    Given the user is on the YOUR NHS number page
    When user enters the "<nhsnumber>" in the text box provided
    And select continue
    Then navigate to the step up page with second option of Your NHS number as Completed
    And third option of Photo ID document details has a clickable Start button
    
    Examples:
			| nhsnumber     	|     
      | 1234056789   		|
    
      
     
  @nhsnumber
 	Scenario Outline: Invalid NHS Number Entry in the Your NHS number page
 		Given the user is on the YOUR NHS number page
    When user enters the invalid "<nhsnumber>" in the text box provided
    And select continue
		Then an error message is displayed in the Your NHS number page
		
		Examples:
			| nhsnumber     	|     
      | abc123   				|
      | 123!            |
      | NULL            |
      |12345678901      |
      |123456789        |
	
	 @nhsnumber
	 Scenario: Accessing the Sorry you cannot continue page
     Given the user is on the Your NHS number page
		 When the user clicks on I dont know my NHS number link
		 Then a page is displayed advising the user that they cant continue with the step up activities
		  
   @nhsnumber
   Scenario: Navigating Back to Your NHS number Page
     Given the user is on the Sorry you cannot continue page
		 When the user click on the Go back link
		 Then Your NHS Number Page is displayed
		
	 @nhsnumber	
	 Scenario: Successful Back End Validation
		 Given connection is established with DynamoDB
		 When select the location where nhs number is stored
		 Then display the values in the console
		 
	 @photoid
	 Scenario: Accessing What type of photo ID do you have page
	 	Given the user is on the step up page
	 	When the user clicks the start button next to third Option of Photo ID Document
    Then What type of photo ID do you have page is displayed
    
   @photoid
   Scenario: Navigating back to the step up page from What type of photo ID do you have page
   	Given the user is on the What type of photo ID do you have page
   	When the user clicks on the Go back link
   	Then display the step up page
   	And third option has a visible start option 
   	
   @photoid1
   Scenario: Selecting ID Type as UK Passport
   	Given the user is on the What type of photo ID do you have page
   	When user selects the UK passport option
   	And click on continue button
   	Then display the Take a photo of your passport page
   	
   @photoid1
   Scenario: Selecting ID Type as UK Driving Licence
   	Given the user is on the What type of photo ID do you have page
   	When user selects the UK driving licence option
   	And click on continue button
   	Then display the Take a photo of your driving licence page
   	
   @photoid1
   Scenario: Navigating back to the What type of photo ID do you have page from Take a photo page
   	Given the user is on the Take a photo page
		When the user clicks on the Go back link
		Then display the What type of photo ID do you have page
		
	 @neither1
	 Scenario: Selecting Neither of these option
	 	
   	When user selects the Neither of these option
   	
   	@neither1
   Scenario: Navigating Back to What type of photo ID do you have page
     
     Then What type of photo ID do you have Page is displayed
     
   @video
   Scenario: Select option to take a Video Selfie
   Given the step up page has clickable start button on forth step Capture Video Selfie
   When user clicks on the start button
   Then the upload a selfie page is displayed
   
   @video
   Scenario: Back to the step up page from upload a selfie page
   Given the user in on the Take a selfie page
   When the user clicks the go back link
   Then display the step up page with Video Selfie option has a start button next to it
		
   	
    
   	
	 
		
		
    
  
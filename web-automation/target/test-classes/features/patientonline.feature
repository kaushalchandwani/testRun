#Author: waqar.iqbal2@nhs.net
#Keywords Summary : Cucumber feature file for patient-online page process to NHS account
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
Feature: Patient Online Page - GP registeration entry process: As a registered user with an NHS Account only
I want to understand what additional verification activities I need to perform
So I can access services which require a higher assurance level

  @patientonline
  Scenario Outline: Invalid entries for online GP registration details on patient online page
    Given the user is on the patient online Page
    When user enters "<linkageKey>" "<odsCode>" "<userID>" invalid entries in the text boxes
    And presses continue button
    Then error messages shown to enter valid values

    Examples:
      | linkageKey        | odsCode | userID                                           |
      | 11AA22BB33CC44D   | A12334   | @less30chars                                     |
      | 11AA22BB33CC44DD  | A123     |                                      						|
      | 11AA22BB33CC44DD  | A12334  | @less30chars@less30chars@less30chars@less30chars |
      |                   |         |                                                  |
      | NULL              | A12334  | @less30chars@less30chars@less30 |

  @patientonline
  Scenario Outline: Fetching the nhs number providing the valid enttries in the form
    Given the user is on the patient online Page
    When user enters "<linkageKey>" "<odsCode>" "<userID>" valid entries in the text boxes provided
    And presses continue button
    Then navigate to the nhs-number page display page

    Examples:
      | linkageKey       | odsCode | userID      |
      | 11AA22BB33CC44DD | A12334  | less30chars |

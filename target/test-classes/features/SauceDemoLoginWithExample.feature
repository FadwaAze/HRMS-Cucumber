#Author: Fadwa Azeroual fadwa@syntaxtech.com
Feature: Sauce Demo login
  
  Description: User story N-3421 The purpose of this feature file is
               to auatomate sauce demo app login with valid and invalid credential
  Acceptance Criteria: I want to automate sauce demo login functionality
 

  #@review
  #Scenario Outline: invalid login
  #Given user is on login page
  #When user enters invalid username as "<username>"
  #And user enters invalid password as "<password>"
  #And click on login button
  #Then user should see the error message
  #Examples:
  #  | username |   password     |
  #| Admin    |   Admin@123    |
  # | Sarmed   |   Sarmed@123   |
  #| Sarmed1  |   Sarmed@1233  |
  #| Sarmed2  |   Sarmed@12333 |
  Scenario: invalid login
    Given user is on login page
    When user validates below paragraph
      """
      Each day has a promise to brighten up the day you must
      first let the sun come your way
      """
    And user enters invalid password
    And click on login button
    Then user should see the error message

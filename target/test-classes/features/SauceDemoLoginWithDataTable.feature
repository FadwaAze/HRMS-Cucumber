#Author: Fadwa Azeroual fadwa@syntaxtech.com
Feature: Sauce Demo login
  
  Description: User story N-3421 The purpose of this feature file is
               to auatomate sauce demo app login with valid and invalid credential
  Acceptance Criteria: I want to automate sauce demo login functionality

  Scenario: invalid login
    Given user is on login page
    When user enters invalid username as username as below
      | Admin  |
      | Sarmed |
    And user enters invalid password
    And click on login button
    Then user should see the error message

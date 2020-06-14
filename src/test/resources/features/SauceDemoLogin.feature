#Author: Fadwa Azeroual fadwa@syntaxtech.com
Feature: Sauce Demo login
  
  Description: User story N-3421 The purpose of this feature file is
               to auatomate sauce demo app login with valid and invalid credential
  Acceptance Criteria: I want to automate sauce demo login functionality

  Background: 
    Given user is on login page
    When user enters invalid username

  Scenario: invalid login
    #Given user is on login page
    #When user enters invalid username
    And user enters invalid password
    And click on login button
    Then user should see the error message

  @review
  Scenario: invalid login
    Given user is on login page
    When user enters invalid username as "Admin"
    And user enters invalid password as "Admin@123"
    And click on login button
    Then user should see the error message

Feature: add new employee

  Background: 
    When user enters employees first name and last name

  @smoke
  Scenario: add new employee
    #Given user logged in into HRMS
    #When user enters employees first name and last name
    And user clicks save button
    Then employee is added successfully

  @smoke
  Scenario: add employee without employee id
    #Given user logged in into HRMS
    #When user enters employees first name and last name
    And user deletes employee id
    And user clicks save button
    Then employee is added successfully

  @smoke
  Scenario: add employee and create Login Credentials
    #Given user logged in into HRMS
    #When user enters employees first name and last name
    And user clicks on create login checkbox
    And user enters login credentials
    And user clicks save button
    Then employee is added successfully

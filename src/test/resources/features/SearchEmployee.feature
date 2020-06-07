# Group Scenarion based on functionality
@searchEmplyee @sprint13
Feature: Employee Search

  Background: 
    Given user is logged with valid admin credentials
    And user navigate to employee list page

  @smoke
  Scenario: Search employee by id
    #Given user is navigated to HRMS--> Taking care by using Hooks class from Steps package
    #And user is logged with valid admin credentials
    #And user navigate to employee list page
    When user enters valid employee id
    And click on search button
    Then user see employee information is displayed

  @regression
  Scenario: Search employee by name
    
    When user enters valid employee name and last name
    And click on search button
    Then user see employee information is displayed

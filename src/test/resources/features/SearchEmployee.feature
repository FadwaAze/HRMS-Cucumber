# Group Scenarion based on functionality

@searchEmplyee @sprint13
Feature: Employee Search

  Background: #used to define steps that are common for all tests in the same feature file
  
    Given user is logged with valid admin credentials
    And user navigate to employee list page

  @smoke
  Scenario: Search employee by id
    #Given user is navigated to HRMS--> Taking care by using Hooks class from Steps package
    #And user is logged with valid admin credentials
    #And user navigate to employee list page
    When user enters valid employee id "10079"
    And click on search button
    Then user see employee information is displayed

  @regression
  Scenario: Search employee by name
    
    When user enters valid employee "John" and "Smith"
    And click on search button
    Then user see employee information is displayed

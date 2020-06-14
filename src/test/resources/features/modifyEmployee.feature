#Author: fadwaAzreoual@syntax.com
@ModiyEmployee
Feature: Add and modify Employee personal Details

  Background: 
    Given user is logged with valid admin credentials
    And user navigates to AddEmployeePage

  Scenario: Add and modify Employee
    When user add employee and employee is displayed succssfully
      | FirstName | MiddleName | LastName |
      | Amie      | S          | Smith    |
    Then user updates employee personal details then employee is updated
      | License Expiry Date | SSN         | SIN   | Gender | Marital Status | Nationality | Date of Birth | Nick Name | Smoker | Military Service |
      | 2020-11-20          | 234-34-2345 | F3456 | Female | Maried         | USA         | 1990-05-20    | Dany      | No     | Active           |

Feature: Login

  #prevoiusly written test
  #Background: all steps in this feature file are diff.
  #when running from here all will be executed
  @smoke
  Scenario: valid admin login
    #Given user is navigated to HRMS --> Taking care by using Hooks class from Steps package
    When user enter valid admin username and password
    And user click on login button
    Then admin user is successfully logged in

  #enhancing test with Scenario outline
  @smoke
  Scenario: valid ess login
    When user enter valid ess username and password
    And user click on login button
    Then ess user is successfully logged in

  Scenario Outline: #Data Driving Testing
    When user enter valid "<UserName>" and "<PassWord>"
    And user click on login button
    Then "<FirstName>" user is successfully logged in

    Examples: 
      | UserName | PassWord   | FirstName |
      | Mahady   | Mahady123! | John      |
      | abd77    | Syntax123! | Abdullah  |

  @smoke
  Scenario: Login with valid username and invalid password
    When User enter valid username and invalid password
    And user click on login button
    Then User see Invalid Credentials text on login page
    
    
@smoke
  Scenario: Login with invalid credentials
    When I enter invalid username and password and see error message
      | UserName | Password   | ErrorMessage        |
      | Admin    | Admin123   | Invalid Credentials |
      | Hello    | Syntax123! | Invalid Credentials |
      
      
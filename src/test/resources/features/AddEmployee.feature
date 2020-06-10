Feature: Add new Employee

  Background: 
    Given user is logged with valid admin credentials
    And user navigates to AddEmployeePage

  @smoke
  Scenario: Add Employee with first and lastname
    When user enters employees "John" and "Smith"
    And user clicks save button
    Then "John Smith" is added successfully

  @regression
  Scenario: Add Employee without employee id
    When user enters employees first name and last name
    And user deletes employee id
    And user clicks save button
    Then employee is added successfully

  @smoke
  Scenario: AddEmployee and create Login Credentials
    When user enters employees first name and last name
    And user clicks on create login checkbox
    And user enters login credentials
    And user clicks save button
    Then employee is added successfully

  #to perform DDT in cucumber we use Scenario Outline  --> to add multiple employees repeating the entire scenario based on examples
  @regression
  Scenario Outline: Adding multiple employees
    When user enter employees "<FirstName>", "<MiddleName>" and "<LastName>"
    And user clicks save button
    Then "<FirstName>", "<MiddleName>" and "<LastName>" is added successfully

    #Example works for the entire Scenario
    Examples: 
      | FirstName | MiddleName | LastName  |
      | James     | J          | Smith     |
      | Faisal    | F          | Sakhi     |
      | Sohil     | S          | Instuctor |
      | Yunus     | Emre       | Yakut     |

  #adding multiple employees using Cucumber DataTable --> repeat only one step to add employees before move to the next step /
  @smoke
  Scenario: Adding multiple employees
    When user enters employee details and click on save then employee is added
      | FirstName | MiddleName | LastName |
      | John      | J          | Smith    |
      | Jane      | J          | Doe      |
    #Then employee is added successfully
    
    @Excel
    Scenario: Adding multiple employees from excel
    When user enters employee data from "EmployeeLoginCredentials" excel sheet then employee is added
    
    
    
    
    
    
    
    
    
    
    
    
    
    

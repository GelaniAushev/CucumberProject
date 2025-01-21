Feature:

  Background:
    When user enters correct username and password
    And user clicks on login button
    Then user is able to see dashboard page
    When user clicks on PIM button
    And user clicks on Add Employee button

  @addEmp
  Scenario: Add Employee
    When user enters firstname and middlename and lastname
    And user clicks on save button
    Then user adds employee successfully


  @addEmpID
  Scenario: Add Employee with ID
    When user enters firstname and middlename and lastname and ID
    And user clicks on save button
    Then user adds employee successfully


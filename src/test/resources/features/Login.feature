Feature:

  Scenario: Valid login
    #Given user is able to access HRMS application
    When user enters correct username and password
    And user clicks on login button
    Then user is able to see dashboard page

  @invalid
  Scenario: Invalid login
    #Given user is able to access HRMS application
    When user enters incorrect username and password
    And user clicks on login button
    Then user is able to see error message
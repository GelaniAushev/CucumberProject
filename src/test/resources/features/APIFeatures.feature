Feature: API Testing

  Background:
    Given a JWT bearer token is generated

  # when ever a user is created the
  # status code is 201
  # The key Message has value Employee Created

  @api
  Scenario: creating an employee
    Given a request is prepared for creation of an employee
    When a Post call is made to create an Employee
    Then status code is 201 for the call
    And the value of the key "Message" is "Employee Created"
    And the employee id "Employee.employee_id" is stored in a global variable

  @api
  Scenario: Retrieving recently created employee
    Given a request is prepared to retrieve an employee
    When a get call is made to retrieve the employee
    Then status code is 200 for the call
    And the value of the key "employee.emp_firstname" is "martin"
    And the received data from the object "employee" matches the expected data
      |emp_firstname|emp_lastname|emp_middle_name|emp_gender|emp_birthday|emp_status|emp_job_title|
      |tokyo        |shwarz      |sn             |Female    |2024-02-09  |junior    |QA           |

# create an employee using the payload json in api constants
  @api
  Scenario: creating an employee
    Given a request is prepared for creation of an employee using jsonPayload
    When a Post call is made to create an Employee
    Then status code is 201 for the call
    And the value of the key "Message" is "Employee Created"
    And the employee id "Employee.employee_id" is stored in a global variable

# create an employee using dynamic-payload
  @api
  Scenario: creating an employee
    Given a request is prepared for creation of an employee using dynamic payload
    When a Post call is made to create an Employee
    Then status code is 201 for the call
    And the value of the key "Message" is "Employee Created"
    And the employee id "Employee.employee_id" is stored in a global variable
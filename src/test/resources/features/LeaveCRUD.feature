Feature: leave CRUD Operations

  @LeaveCrudOperations
  Scenario: I am able to add, edit and Delete  LeaveType
    Given Navigate to LEave after log in with Admin user
    When I navigate config and then select Leave Types
    Then Add the Leave with below field and values and I verify leave is displayed in leave list
      | LeaveTypeTitle | SickLeave6 |
    Then I Edit the Leave type and change below values and I verify verify the leave name is changed to new name
      | LeaveTypeTitle | 1 |
    And Delete the Newly added Leave Type

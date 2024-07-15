Feature: Login Functionality
  In order to user internet banking
  As a valid Para Bank customer
  I want to login successfully

  Scenario: Successful Login

    Given The user is on the login page of the Para Bank web application
    When the user enters valid credentials
    Then account overview page should be displayed
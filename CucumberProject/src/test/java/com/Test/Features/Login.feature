Feature: Validate the Login functionality of PHP Travels User for positive and negative scenarios

  Background: 
    Given I navigate to the PHP travels website
    When I click on the My Account link
    And click on the Login link

  @Smoke
  Scenario: Navigate to Login
    Test to verify that user is able to navigate to Login Page from Home Page

    Then I must land in the login page

  @Login @Positive
  Scenario: Successful Login
    Test to verify that user is able to successfully login to the application

    When I enter the login details
    And click on the Login button
    Then I must land in the account page

  @Login @Negative
  Scenario: Unsuccessful Login
    Test to verify that user is not able to login to the application with incorrect details

    When I enter the incorrect login details
    And click on Login button
    Then I must receive an error

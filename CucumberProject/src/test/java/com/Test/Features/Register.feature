Feature: Validate the Register functionality of PHP Travels User for positive and negative scenarios

  Background: 
    Given I navigate to the PHP travels website
    When I click on the My Account link
    And click on the Signup link

  @Register @DataTable
  Scenario: Successful Single Register
    Test to verify that user is able to successfully signup to the application

    When I enter the following details in Register page
      | Firstname  | Lastname  | Mobile     | Email               | Password  | ConfirmPassword |
      | firsttest1 | lasttest1 | 9876543456 | firstlast11@test.com | testtest1 | testtest1       |
    And click on the Signup button
    Then I land in the account page

  @Register @ExampleTable
  Scenario Outline: Successful Multiple Register
    Test to verify that users are able to successfully signup to the application

    When I enter the "<Firstname>" "<Lastname>" "<Mobile>" "<Email>" "<Password>" "<ConfirmPassword>" in Register page
    And click on the Signup button
    Then I land in the account page

    Examples: 
      | Firstname  | Lastname  | Mobile     | Email               | Password  | ConfirmPassword |
      | firsttest1 | lasttest1 | 9876543456 | firstlast12@test.com | testtest1 | testtest1       |
      | firsttest1 | lasttest1 | 9876543456 | firstlast13@test.com | testtest1 | testtest1       |
      | firsttest1 | lasttest1 | 9876543456 | firstlast14@test.com | testtest1 | testtest1       |
  
  @Register @Negative
  Scenario: Already registered
    Test to verify the message for already registered user

    When I enter the following details in Register page
      | Firstname  | Lastname  | Mobile     | Email               | Password  | ConfirmPassword |
      | firsttest1 | lasttest1 | 9876543456 | firstlast4@test.com | testtest1 | testtest1       |
    And click on Signup button
    Then I receive an error that user is already registered

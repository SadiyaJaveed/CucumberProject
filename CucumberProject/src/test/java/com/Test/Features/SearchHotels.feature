Feature: Validate the Hotel search functionality of PHP Travels User

  @Search
  Scenario: Successful Search
    Test to validate that user is displayed with search results for hotel search

    Given I navigate to the PHP travels website
    When I enter the following details for hotel search
      | Destination | Checkin    | Checkout   | Adults | Child |
      | london      | 05-05-2020 | 07-05-2020 |      2 |     1 |
    And click on the search button
    Then I must be displayed with the search results

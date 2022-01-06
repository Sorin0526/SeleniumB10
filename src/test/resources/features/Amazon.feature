Feature: Amazon most important features testing

  Scenario: Happy path, positive scenario for Amazon search
    When I navigate to Amazon homepage
    And I search for Iphone13 case
    Then I should get more than 20 results
    And I validate the search result number

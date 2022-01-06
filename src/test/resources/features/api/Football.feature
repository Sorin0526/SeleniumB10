Feature: Testing football api

  Scenario: Find competition id
    Given I have football competition endpoint
    When I send GET request to retrieve list of competitons
    Then status code should be 200
    Then competitions list must be more then 0


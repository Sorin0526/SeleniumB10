@regression
Feature: Testing Google functionalities

  Background:
    Given  I navigated to Google.com

  @smoketest @regression @random @newScenario
  Scenario: Happy path Google search functionality
    When I search for Techtorial Academy
    Then I get more than 10 results

  Scenario: Google search negative scenarios
    When I search for "ujhgewtgujhwte5u"
    Then I should get 0 results



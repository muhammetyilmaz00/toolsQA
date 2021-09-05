@regression @alert
Feature: Alerts Validation

  Scenario: Simple Alert
    Given I go to tools QA page
    And I click to <"Alerts, Frame & Windows"> category
    And I click to <"Alerts"> in menu list
    When I click to the first button
    Then I see alert is opened successfully
    And I close the browser
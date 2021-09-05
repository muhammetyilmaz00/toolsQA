@regression @alert
Feature: Alerts Validation

  Scenario: Alert Confirmation
    Given I go to tools QA page
    And I click to <"Alerts, Frame & Windows"> category
    And I click to <"Alerts"> in menu list
    When I click to the third button
    And I click to <"OK">
    Then I see alert confirmation message is <"Ok">
    And I close the browser
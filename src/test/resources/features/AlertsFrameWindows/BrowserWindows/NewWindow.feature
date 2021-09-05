@regression @newWindow
Feature: Browser New Window Validation

  Scenario: New Window
    Given I go to tools QA page
    And I click to <"Alerts, Frame & Windows"> category
    And I click to <"Browser Windows"> in menu list
    When I click to New Window button
    Then I see new window is opened successfully
    And I close the browser
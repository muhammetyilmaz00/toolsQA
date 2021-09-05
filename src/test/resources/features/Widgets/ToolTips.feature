@regression @toolTips
Feature: Tool Tips Validation

  Scenario: Tool Tips
    Given I go to tools QA page
    And I click to <"Widgets"> category
    And I click to <"Tool Tips"> in menu list
    When I hover over the button
    Then I see the message next to the button
    And I close the browser
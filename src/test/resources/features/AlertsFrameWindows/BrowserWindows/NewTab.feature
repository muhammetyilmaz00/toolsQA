@regression @newTab
  Feature: Browser New Tab Validation

    Scenario: New Tab
      Given I go to tools QA page
      And I click to <"Alerts, Frame & Windows"> category
      And I click to <"Browser Windows"> in menu list
      When I click to New Tab button
      Then I see new tab is opened successfully
      And I close the browser
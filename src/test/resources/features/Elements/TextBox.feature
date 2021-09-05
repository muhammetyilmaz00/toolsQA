@regression @textBox
  Feature: Text Box Validation in Elements Page

    Scenario: Text Box
      Given I go to tools QA page
      And I click to <"Elements"> category
      And I click to <"Text Box"> in menu list
      And I enter the name <"Muhammet"> in Full Name input field
      And I enter the email <"muhammet@email.com"> in Email input field
      And I enter the address <"Istanbul Turkey"> in Current Address input field
      And I enter the address <"Istanbul Turkey"> in Permanent Address input field
      When I click to Submit button
      Then I see the entered details are viewed below the submit button
      And I close the browser
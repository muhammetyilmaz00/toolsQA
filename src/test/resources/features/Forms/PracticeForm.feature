@regression @practiceForm
  Feature: Practice Form Validation in Forms Page

    Scenario: Practice Form
      Given I go to tools QA page
      And I click to <"Forms"> category
      And I click to <"Practice Form"> in menu list
      And I enter the first name <"Muhammet"> and last name <"Yilmaz">
      And I enter the email <"muhammet@email.com">
      And I choose the gender <"Male">
      And I enter the mobile number <"1234567891">
      And I choose the hobbies <"Sports">
      And I enter the current address <"Istanbul Turkey">
      When I click to submit button in Practice Form page
      Then I see the entered details are viewed in a form
      And I close the browser
package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.web.FormsPageObjects;

public class PracticeFormStepDef {

    final FormsPageObjects formsPageObjects = new FormsPageObjects();

    @And("I enter the first name <{string}> and last name <{string}>")
    public void iEnterTheFirstNameAndLastName(String firstName, String lastName) {
        formsPageObjects.setFirstName(firstName);
        formsPageObjects.setLastName(lastName);
    }

    @And("I enter the email <{string}>")
    public void iEnterTheEmail(String email) {
        formsPageObjects.setUserEmail(email);
    }

    @And("I choose the gender <{string}>")
    public void iChooseTheGender(String gender) {
        formsPageObjects.chooseGender(gender);
    }

    @And("I enter the mobile number <{string}>")
    public void iEnterTheMobileNumber(String number) {
        formsPageObjects.setUser_mobileNumber(number);
    }

    @And("I choose the hobbies <{string}>")
    public void iChooseTheHobbies(String hobby) {
        formsPageObjects.chooseHobby(hobby);
    }

    @And("I enter the current address <{string}>")
    public void iEnterTheCurrentAddress(String currentAddress) {
        formsPageObjects.setCurrentAddress(currentAddress);
    }

    @When("I click to submit button in Practice Form page")
    public void iClickToSubmitButton() {
        formsPageObjects.clickSubmitButton();
    }

    @Then("I see the entered details are viewed in a form")
    public void iSeeTheEnteredDetailsAreViewedInAForm() {
        formsPageObjects.checkForm();
    }
}

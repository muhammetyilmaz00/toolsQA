package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.web.TextBoxPageObjects;

public class TextBoxStepDef {

    final TextBoxPageObjects textBoxPageObjects = new TextBoxPageObjects();

    @And("I enter the name <{string}> in Full Name input field")
    public void iEnterTheNameInFullNameInputField(String userName) {
        textBoxPageObjects.setUserName(userName);
    }

    @And("I enter the email <{string}> in Email input field")
    public void iEnterTheEmailInEmailInputField(String email) {
        textBoxPageObjects.setEmail(email);
    }

    @And("I enter the address <{string}> in Current Address input field")
    public void iEnterTheAddressInCurrentAddressInputField(String address) {
        textBoxPageObjects.setCurrentAddress(address);
    }

    @And("I enter the address <{string}> in Permanent Address input field")
    public void iEnterTheAddressInPermanentAddressInputField(String address) {
        textBoxPageObjects.setPermanentAddress(address);
    }

    @When("I click to Submit button")
    public void iClickToSubmitButton() {
        textBoxPageObjects.clickSubmitButton();
    }

    @Then("I see the entered details are viewed below the submit button")
    public void iSeeTheEnteredDetailsAreViewedBelowTheSubmitButton() {
        textBoxPageObjects.checkOutput();
    }

}

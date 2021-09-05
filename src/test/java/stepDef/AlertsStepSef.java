package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.web.AlertsPageObjects;

public class AlertsStepSef {

    final AlertsPageObjects alertsPageObjects = new AlertsPageObjects();

    @When("I click to the first button")
    public void iClickToTheFirstButton() {
        alertsPageObjects.clickFirstAlertButton();
    }

    @Then("I see alert is opened successfully")
    public void iSeeAlertIsOpenedSuccessfully() {
        alertsPageObjects.checkAlertMessage();
    }

    @When("I click to the third button")
    public void iClickToTheThirdButton() {
        alertsPageObjects.clickThirdAlertButton();
    }

    @And("I click to <{string}>")
    public void iClickTo(String text) {
        alertsPageObjects.manageAlert(text);
    }

    @Then("I see alert confirmation message is <{string}>")
    public void iSeeAlertConfirmationMessageIs(String result) {
        alertsPageObjects.checkConfirmResult(result);
    }
}

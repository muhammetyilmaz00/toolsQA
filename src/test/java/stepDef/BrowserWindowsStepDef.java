package stepDef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.web.BrowserWindowsPageObjects;

public class BrowserWindowsStepDef {

    final BrowserWindowsPageObjects browserWindowsPageObjects = new BrowserWindowsPageObjects();

    @When("I click to New Tab button")
    public void iClickToNewTabButton() {
        browserWindowsPageObjects.clickNewTab();
    }

    @Then("I see new tab is opened successfully")
    public void iSeeNewTabIsOpenedSuccessfully() {
        browserWindowsPageObjects.checkNewTab();
    }

    @When("I click to New Window button")
    public void iClickToNewWindowButton() {
        browserWindowsPageObjects.clickNewWindow();
    }

    @Then("I see new window is opened successfully")
    public void iSeeNewWindowIsOpenedSuccessfully() {
        browserWindowsPageObjects.checkNewWindow();
    }

}

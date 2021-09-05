package stepDef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.Helper;

public class ToolTipsStepDef {

    private final String toolTipButtonId = "toolTipButton";

    @When("I hover over the button")
    public void iHoverOverTheButton() {
        Helper.hoverToElementById(toolTipButtonId);
    }

    @Then("I see the message next to the button")
    public void iSeeTheMessageNextToTheButton() {
        Assert.assertEquals("You hovered over the Button",Helper.getTextOfWebElementByXpath("//div[@class='tooltip-inner']"));
    }
}

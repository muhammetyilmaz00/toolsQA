package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pageObjects.web.ToolQAPageObjects;

public class ToolsQAStepDef {

    final ToolQAPageObjects toolQAPageObjects = new ToolQAPageObjects();

    @Given("I go to tools QA page")
    public void iGoToToolsQAPage() {
        toolQAPageObjects.navigateToToolsQA();
    }

    @And("I click to <{string}> category")
    public void iClickToCategory(String text) {
        toolQAPageObjects.clickToCategory(text);
    }

    @And("I click to <{string}> in menu list")
    public void iClickToInMenuList(String text) {
        toolQAPageObjects.clickToTitleInMenuList(text);
    }

    @And("I close the browser")
    public void iCloseTheBrowser() {
        toolQAPageObjects.closeBrowser();
    }
}

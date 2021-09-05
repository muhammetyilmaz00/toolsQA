package pageObjects.web;

import pageObjects.interfaces.ToolQAPageObjectsInterface;
import utils.ConfigFileReader;
import utils.Helper;

public class ToolQAPageObjects implements ToolQAPageObjectsInterface {

    final ConfigFileReader configFileReader = new ConfigFileReader();


    @Override
    public void navigateToToolsQA() {
        Helper.openBrowser();
        Helper.navigateURL(configFileReader.getToolsQAUrl());
        Helper.verifyCurrentPageURL(configFileReader.getToolsQAUrl());
    }

    @Override
    public void clickToCategory(String text) {
        Helper.waitAndClickByXpath("//h5[contains(.,'" + text + "')]");
    }

    @Override
    public void clickToTitleInMenuList(String text) {
        Helper.waitAndClickByXpath("//*[@class='menu-list']//span[contains(.,'" + text + "')]");
    }

    @Override
    public void closeBrowser(){
        Helper.closeBrowser();
    }
}

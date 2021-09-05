package pageObjects.web;

import org.junit.Assert;
import org.openqa.selenium.By;
import pageObjects.interfaces.BrowserWindowsPageObjectsInterface;
import utils.Helper;

@SuppressWarnings("FieldCanBeLocal")
public class BrowserWindowsPageObjects implements BrowserWindowsPageObjectsInterface {


    private final String newTabId = "tabButton";
    private final String newWindowId = "windowButton";
    private final String headingId = "sampleHeading";
    private final String heading = "This is a sample page";


    @Override
    public void clickNewTab() {
        Helper.waitAndClickByID(newTabId);
    }

    @Override
    public void clickNewWindow() {
        Helper.waitAndClickByID(newWindowId);
    }

    @Override
    public void checkNewTab(){
        Helper.switchToTab(1);
        Assert.assertEquals(heading,Helper.getTextOfWebElementByID(headingId));
    }

    @Override
    public void checkNewWindow(){
        Assert.assertEquals(heading,Helper.newWindowText(By.id(headingId)).get(0));
    }


}

package pageObjects.web;

import org.junit.Assert;
import pageObjects.interfaces.AlertsPageObjectsInterface;
import utils.Helper;

@SuppressWarnings("FieldCanBeLocal")
public class AlertsPageObjects implements AlertsPageObjectsInterface {

    private final String firstAlertButtonId = "alertButton";
    private final String thirdAlertButtonId = "confirmButton";
    private final String confirmResultId = "confirmResult";

    @Override
    public void clickFirstAlertButton() {
        Helper.waitAndClickByID(firstAlertButtonId);
    }

    @Override
    public void checkAlertMessage() {
        Assert.assertEquals("You clicked a button", Helper.alertMessage());
    }

    @Override
    public void clickThirdAlertButton() {
        Helper.waitAndClickByID(thirdAlertButtonId);
    }

    public void manageAlert(String text) {
        if (text.equals("OK")) {
            Helper.acceptAlert();
        } else if (text.equals("Cancel")) {
            Helper.dismissAlert();
        } else {
            System.out.println("Nothing to do");
        }
    }

    @Override
    public void checkConfirmResult(String result) {
        Assert.assertEquals("You selected "+result, Helper.getTextOfWebElementByID(confirmResultId));
    }

}

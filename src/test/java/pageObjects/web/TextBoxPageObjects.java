package pageObjects.web;

import org.junit.Assert;
import pageObjects.interfaces.TextBoxPageObjectsInterface;
import utils.Helper;

public class TextBoxPageObjects implements TextBoxPageObjectsInterface {

    private final String usernameId = "userName";
    private final String userEmailId = "userEmail";
    private final String currentAddressId = "currentAddress";
    private final String permanentAddressId = "permanentAddress";
    private final String submitButtonId = "submit";
    private final String outputNameId = "name";
    private final String outputEmailId = "email";
    private final String outputCurrentAddressXpath = "//*[@id='output']//*[@id='currentAddress']";
    private final String outputPermanentAddressXpath = "//*[@id='output']//*[@id='permanentAddress']";
    private String name;
    private String mail;
    private String current;
    private String permanent;

    @Override
    public void setUserName(String userName) {
        name = userName;
        Helper.waitAndSendKeysById(usernameId, userName);
    }

    @Override
    public void setEmail(String email) {
        mail = email;
        Helper.waitAndSendKeysById(userEmailId, email);
    }

    @Override
    public void setCurrentAddress(String address) {
        current = address;
        Helper.waitAndSendKeysById(currentAddressId, address);
    }

    @Override
    public void setPermanentAddress(String address) {
        permanent = address;
        Helper.waitAndSendKeysById(permanentAddressId, address);
    }

    @Override
    public void clickSubmitButton() {
        Helper.waitAndClickByID(submitButtonId);
    }

    @Override
    public void checkOutput() {
        Assert.assertEquals("Name:" + name, Helper.getTextOfWebElementByID(outputNameId));
        Assert.assertEquals("Email:" + mail, Helper.getTextOfWebElementByID(outputEmailId));
        Assert.assertEquals("Current Address :" + current, Helper.getTextOfWebElementByXpath(outputCurrentAddressXpath));
        Assert.assertEquals("Permananet Address :" + permanent, Helper.getTextOfWebElementByXpath(outputPermanentAddressXpath));
    }

}

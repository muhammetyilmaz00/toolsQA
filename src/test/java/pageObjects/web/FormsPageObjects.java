package pageObjects.web;

import org.junit.Assert;
import pageObjects.interfaces.FormsPageObjectsInterface;
import utils.Helper;

public class FormsPageObjects implements FormsPageObjectsInterface {

    private final String firstNameId = "firstName";
    private final String lastNameId = "lastName";
    private final String userEmailId = "userEmail";
    private final String maleXpath = "//label[contains(text(),'Male')]";
    private final String femaleXpath = "//label[contains(text(),'Female')]";
    private final String otherXpath = "//label[contains(text(),'Other')]";
    private final String mobileNumberId = "userNumber";
    private final String sportsXpath = "//label[contains(text(),'Sports')]";
    private final String readingXpath = "//label[contains(text(),'Reading')]";
    private final String musicXpath = "//label[contains(text(),'Music')]";
    private final String currentAddressId = "currentAddress";
    private final String submitButtonXpath = "//button[@id='submit']";
    private final String formBodyXpath = "//*[@class='table-responsive']//tbody";
    private String user_firstName;
    private String user_lastName;
    private String user_email;
    private String user_gender;
    private String user_mobileNumber;
    private String user_hobby;
    private String user_address;

    @Override
    public void setFirstName(String firstName) {
        user_firstName = firstName;
        Helper.waitAndSendKeysById(firstNameId, firstName);
    }

    @Override
    public void setLastName(String lastName) {
        user_lastName = lastName;
        Helper.waitAndSendKeysById(lastNameId, lastName);
    }

    @Override
    public void setUserEmail(String email) {
        user_email = email;
        Helper.waitAndSendKeysById(userEmailId, email);
    }

    @Override
    public void chooseGender(String gender) {
        user_gender = gender;
        if (gender.equals("Male")) {
            Helper.waitAndClickByXpath(maleXpath);
        } else if (gender.equals("Female")) {
            Helper.waitAndClickByXpath(femaleXpath);
        } else {
            Helper.waitAndClickByXpath(otherXpath);
        }
    }

    @Override
    public void setUser_mobileNumber(String number) {
        user_mobileNumber = number;
        Helper.waitAndSendKeysById(mobileNumberId, number);
    }

    @Override
    public void chooseHobby(String hobby) {
        user_hobby = hobby;
        switch (hobby) {
            case "Sports" -> Helper.waitAndClickByXpath(sportsXpath);
            case "Reading" -> Helper.waitAndClickByXpath(readingXpath);
            case "Music" -> Helper.waitAndClickByXpath(musicXpath);
        }
    }

    @Override
    public void setCurrentAddress(String currentAddress) {
        user_address = currentAddress;
        Helper.waitAndSendKeysById(currentAddressId, currentAddress);
    }

    @Override
    public void clickSubmitButton(){
        Helper.waitAndClickByXpath(submitButtonXpath);
    }

    @Override
    public void checkForm() {
        Assert.assertEquals(user_firstName + " " + user_lastName, Helper.getTextOfWebElementByXpath(formBodyXpath+"//tr[1]//td[2]"));
        Assert.assertEquals(user_email, Helper.getTextOfWebElementByXpath(formBodyXpath+"//tr[2]//td[2]"));
        Assert.assertEquals(user_gender, Helper.getTextOfWebElementByXpath(formBodyXpath+"//tr[3]//td[2]"));
        Assert.assertEquals(user_mobileNumber, Helper.getTextOfWebElementByXpath(formBodyXpath+"//tr[4]//td[2]"));
        Assert.assertEquals(user_hobby, Helper.getTextOfWebElementByXpath(formBodyXpath+"//tr[7]//td[2]"));
        Assert.assertEquals(user_address, Helper.getTextOfWebElementByXpath(formBodyXpath+"//tr[9]//td[2]"));
    }


}

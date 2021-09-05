package pageObjects.interfaces;

public interface TextBoxPageObjectsInterface {

    void setUserName(String userName);

    void setEmail(String email);

    void setCurrentAddress(String address);

    void setPermanentAddress(String address);

    void clickSubmitButton();

    void checkOutput();

}

package pageObjects.interfaces;

public interface FormsPageObjectsInterface {
    void setFirstName(String firstName);

    void setLastName(String firstName);

    void setUserEmail(String email);

    void chooseGender(String gender);

    void setUser_mobileNumber(String number);

    void chooseHobby(String hobby);

    void setCurrentAddress(String currentAddress);

    void clickSubmitButton();

    void checkForm();
}

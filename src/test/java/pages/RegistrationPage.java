package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.CheckResulTable;
import pages.components.UploadFileComponent;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    private final SelenideElement firstNameInput = $("#firstName"),
    lastNameInput = $("#lastName"),
    userEmailInput = $("#userEmail"),
    userGenderRadioButton = $("#genterWrapper"),
    userNumber = $("#userNumber"),
    userDateOfBirth = $("#dateOfBirthInput"),
    userSubjects = $("#subjectsInput"),
    userHobbies = $("#hobbiesWrapper"),
    userAddress = $("#currentAddress"),
    userStateField = $("#state"),
    userStateWrapper = $("#stateCity-wrapper"),
    userCityField = $("#city"),
    practiceFormSubmitButton = $("#submit"),
    modalDialog = $(".modal-dialog"),
    modalDialogHeader = $("#example-modal-sizes-title-lg");


    CalendarComponent calendarComponent = new CalendarComponent();
    CheckResulTable checkResulTable = new CheckResulTable();
    UploadFileComponent uploadFileComponent = new UploadFileComponent();

    public RegistrationPage openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Practice Form"));

        return this;
    }

    public RegistrationPage removeBanners(){
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserEmail(String value){
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserGender(String value){
        userGenderRadioButton.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String value){
        userNumber.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year){
        userDateOfBirth.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjects(String value){
        userSubjects.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setUserHobbies(String value){
        userHobbies.$(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadUserPhoto(String value){
        uploadFileComponent.uploadFile(value);

        return this;
    }

    public RegistrationPage setUserAddress(String value){
        userAddress.setValue(value);

        return this;
    }

    public RegistrationPage setUserState(String value){
        userStateField.click();
        userStateWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserCity(String value){
        userCityField.click();
        userStateWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage clickSubmitButton(){
        practiceFormSubmitButton.click();

        return this;
    }

        public RegistrationPage checkTableResultsAppear(){
            modalDialog.should(appear);

        return this;
    }

    public RegistrationPage checkTableResultsNotAppear(){
        modalDialog.shouldNot(appear);

        return this;
    }

    public RegistrationPage checkTableResultsHeader(){
        modalDialogHeader.shouldHave(text("Thanks for submitting the form"));

        return this;
    }

    public RegistrationPage checkResuls(String key, String value){
        checkResulTable.checkResult(key, value);

        return this;
    }
}

package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.CheckResulTable;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    public SelenideElement firstNameInput = $("#firstName"),
    lastNameInput = $("#lastName"),
    userEmailInput = $("#userEmail"),
    userGenderRadioButton = $("#genterWrapper"),
    userNumber = $("#userNumber"),
    userDateOfBirth = $("#dateOfBirthInput"),
    userSubjects = $("#subjectsInput"),
    userHobbies = $("#hobbiesWrapper");

    CalendarComponent calendarComponent = new CalendarComponent();
    CheckResulTable checkResulTable = new CheckResulTable();

    public RegistrationPage openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Practice Form"));
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

/*    public RegistrationPage checkResuls(String key, String value){
        checkResulTable.checkResult(key, value);

        return this;
    }*/

    public RegistrationPage setUserHobbies(String value){
        userHobbies.$(byText(value)).click();

        return this;
    }

}

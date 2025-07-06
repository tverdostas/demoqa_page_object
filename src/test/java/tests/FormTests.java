package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class FormTests extends TestBase {

    @BeforeAll
    public static void browserConfiguration() {
        Configuration.browser = "chrome";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
    }

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void RegistrationFormAllFieldsTest() {
        registrationPage.openPage().
                setFirstName("test1").
                setLastName("test1").
                setUserEmail("test1@local.local").
                setUserGender("Female").
                setUserNumber("8963598710").
                setDateOfBirth("30", "July", "1990").
                setSubjects("Social Studies").
                setUserHobbies("Music").
                uploadUserPhoto("test_summer_copy.jpg").
                setUserAddress("test_address").
                setUserState("NCR").
                setUserCity("Gurgaon").
                clickSubmitButton();

        registrationPage.checkTableResultsAppear()
                .checkTableResultsHeader()
                .checkResuls("Student Name", "test1 test1")
                .checkResuls("Student Email", "test1@local.local")
                .checkResuls("Gender", "Female")
                .checkResuls("Mobile", "8963598710")
                .checkResuls("Date of Birth", "30 July,1990")
                .checkResuls("Subjects", "Social Studies")
                .checkResuls("Hobbies", "Music")
                .checkResuls("Picture", "test_summer_copy.jpg")
                .checkResuls("Address", "test_address")
                .checkResuls("State and City", "NCR Gurgaon");
    }

    @Test
    void RegistrationFormMinFieldsTest(){
        registrationPage.openPage().
                setFirstName("test1").
                setLastName("test1").
                setUserEmail("test1@local.local").
                setUserGender("Female").
                setUserNumber("8963598710").
                setDateOfBirth("30", "July", "1990").
                clickSubmitButton();

        registrationPage.checkTableResultsAppear()
                .checkTableResultsHeader()
                .checkResuls("Student Name", "test1 test1")
                .checkResuls("Student Email", "test1@local.local")
                .checkResuls("Gender", "Female")
                .checkResuls("Mobile", "8963598710")
                .checkResuls("Date of Birth", "30 July,1990");
    }
}

package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class FormTests extends TestBase {

    @BeforeEach
    public void browserConfiguration() {

        Configuration.browser = "chrome";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
    }

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void testForm() {
        registrationPage.openPage();

        registrationPage.setFirstName("test1");
        registrationPage.setLastName("test1");
        registrationPage.setUserEmail("test1@local.local");


        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("8963598710");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Social Studies").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("test_summer_copy.jpg"); // только для элементов с type = "file"
        $("#currentAddress").setValue("test_address");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Gurgaon")).click();
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").shouldHave(Condition.text("Student Name test1 test1"));
        $(".table-responsive").shouldHave(Condition.text("Student Email test1@local.local"));
        $(".table-responsive").shouldHave(Condition.text("Gender Female"));
        $(".table-responsive").shouldHave(Condition.text("Mobile 8963598710"));
        $(".table-responsive").shouldHave(Condition.text("Date of Birth 30 July,1990"));
        $(".table-responsive").shouldHave(Condition.text("Subjects Social Studies"));
        $(".table-responsive").shouldHave(Condition.text("Hobbies Music"));
        $(".table-responsive").shouldHave(Condition.text("Picture test_summer_copy.jpg"));
        $(".table-responsive").shouldHave(Condition.text("Address test_address"));
        $(".table-responsive").shouldHave(Condition.text("State and City NCR Gurgaon"));
    }
    @Test
    void testFormPage() {
        registrationPage.openPage().
                setFirstName("test1").
                setLastName("test1").
                setUserEmail("test1@local.local").
                setUserGender("Female").
                setUserNumber("8963598710").
                setDateOfBirth("30", "July", "1990").
                setSubjects("Social Studies").
                setUserHobbies("Music");

        sleep(10000);
        // $("#genterWrapper").$(byText("Female")).click();
        // $("#userNumber").setValue("8963598710");
/*        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();*/
        //$("#subjectsInput").setValue("Social Studies").pressEnter();
        //$("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("test_summer_copy.jpg"); // только для элементов с type = "file"
        $("#currentAddress").setValue("test_address");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Gurgaon")).click();
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        // registrationPage.checkResuls("Student Name", "test1 test1");
        $(".table-responsive").shouldHave(Condition.text("Student Name test1 test1"));
        $(".table-responsive").shouldHave(Condition.text("Student Email test1@local.local"));
        $(".table-responsive").shouldHave(Condition.text("Gender Female"));
        $(".table-responsive").shouldHave(Condition.text("Mobile 8963598710"));
        $(".table-responsive").shouldHave(Condition.text("Date of Birth 30 July,1990"));
        $(".table-responsive").shouldHave(Condition.text("Subjects Social Studies"));
        $(".table-responsive").shouldHave(Condition.text("Hobbies Music"));
        $(".table-responsive").shouldHave(Condition.text("Picture test_summer_copy.jpg"));
        $(".table-responsive").shouldHave(Condition.text("Address test_address"));
        $(".table-responsive").shouldHave(Condition.text("State and City NCR Gurgaon"));
    }
}

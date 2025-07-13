package tests;

import tests.data.TestData;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class FormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void registrationFormAllFieldsTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName(TestData.getUserFirstName())
                .setLastName(TestData.getUserLastName())
                .setUserEmail(TestData.getUserEmail())
                .setUserGender(TestData.getUserGender())
                .setUserNumber(TestData.getUserPhoneNumber())
                .setDateOfBirth(TestData.getUserBirthDay(), TestData.getUserMonthOfBirth(), TestData.getUserYearOfBirth())
                .setSubjects(TestData.getUserSubject())
                .setUserHobbies(TestData.getUserHobbies())
                .uploadUserPhoto(TestData.getUserPicture())
                .setUserAddress(TestData.getUserAddress())
                .setUserState(TestData.getUserState())
                .setUserCity(TestData.getUserCity())
                .clickSubmitButton();

        registrationPage.checkTableResultsAppear()
                .checkTableResultsHeader()
                .checkResuls("Student Name", TestData.getUserFirstName() + " " + TestData.getUserLastName())
                .checkResuls("Student Email", TestData.getUserEmail())
                .checkResuls("Gender", TestData.getUserGender())
                .checkResuls("Mobile", TestData.getUserPhoneNumber())
                .checkResuls("Date of Birth", TestData.getUserBirthDay() + " " + TestData.getUserMonthOfBirth() + "," + TestData.getUserYearOfBirth())
                .checkResuls("Subjects", TestData.getUserSubject())
                .checkResuls("Hobbies", TestData.getUserHobbies())
                .checkResuls("Picture", TestData.getUserPicture())
                .checkResuls("Address", TestData.getUserAddress())
                .checkResuls("State and City", TestData.getUserState() + " " + TestData.getUserCity());
    }

    @Test
    void registrationFormMinFieldsTest(){
        registrationPage.openPage()
                .removeBanners()
                .setFirstName(TestData.getUserFirstName())
                .setLastName(TestData.getUserLastName())
                .setUserEmail(TestData.getUserEmail())
                .setUserGender(TestData.getUserGender())
                .setUserNumber(TestData.getUserPhoneNumber())
                .setDateOfBirth(TestData.getUserBirthDay(), TestData.getUserMonthOfBirth(), TestData.getUserYearOfBirth())
                .clickSubmitButton();

        registrationPage.checkTableResultsAppear()
                .checkTableResultsHeader().checkResuls("Student Name", TestData.getUserFirstName() + " " + TestData.getUserLastName())
                .checkResuls("Student Email", TestData.getUserEmail())
                .checkResuls("Gender", TestData.getUserGender())
                .checkResuls("Mobile", TestData.getUserPhoneNumber())
                .checkResuls("Date of Birth", TestData.getUserBirthDay() + " " + TestData.getUserMonthOfBirth() + "," + TestData.getUserYearOfBirth());
    }

    @Test
    void registrationFormNegativeTest(){
        registrationPage.openPage().
                removeBanners()
                .setFirstName(TestData.getUserFirstName())
                .setUserEmail(TestData.getUserEmail())
                .setUserGender(TestData.getUserGender())
                .setUserNumber(TestData.getUserPhoneNumber())
                .setDateOfBirth(TestData.getUserBirthDay(), TestData.getUserMonthOfBirth(), TestData.getUserYearOfBirth())
                .clickSubmitButton();

        registrationPage.checkTableResultsNotAppear();
    }
}

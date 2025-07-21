package tests;

import tests.data.TestData;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class FormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void registrationFormAllFieldsTest() {
        TestData testData = new TestData();

        registrationPage.openPage()
                .removeBanners()
                .setFirstName(testData.getUserFirstName())
                .setLastName(testData.getUserLastName())
                .setUserEmail(testData.getUserEmail())
                .setUserGender(testData.getUserGender())
                .setUserNumber(testData.getUserPhoneNumber())
                .setDateOfBirth(testData.getUserBirthDay(), testData.getUserMonthOfBirth(), testData.getUserYearOfBirth())
                .setSubjects(testData.getUserSubject())
                .setUserHobbies(testData.getUserHobbies())
                .uploadUserPhoto(testData.getUserPicture())
                .setUserAddress(testData.getUserAddress())
                .setUserState(testData.getUserState())
                .setUserCity(testData.getUserCity())
                .clickSubmitButton();

        registrationPage.checkTableResultsAppear()
                .checkTableResultsHeader()
                .checkResuls("Student Name", testData.getUserFirstName() + " " + testData.getUserLastName())
                .checkResuls("Student Email", testData.getUserEmail())
                .checkResuls("Gender", testData.getUserGender())
                .checkResuls("Mobile", testData.getUserPhoneNumber())
                .checkResuls("Date of Birth", testData.getUserBirthDay() + " " + testData.getUserMonthOfBirth() + "," + testData.getUserYearOfBirth())
                .checkResuls("Subjects", testData.getUserSubject())
                .checkResuls("Hobbies", testData.getUserHobbies())
                .checkResuls("Picture", testData.getUserPicture())
                .checkResuls("Address", testData.getUserAddress())
                .checkResuls("State and City", testData.getUserState() + " " + testData.getUserCity());
    }

    @Test
    void registrationFormMinFieldsTest(){
        TestData testData = new TestData();

        registrationPage.openPage()
                .removeBanners()
                .setFirstName(testData.getUserFirstName())
                .setLastName(testData.getUserLastName())
                .setUserEmail(testData.getUserEmail())
                .setUserGender(testData.getUserGender())
                .setUserNumber(testData.getUserPhoneNumber())
                .setDateOfBirth(testData.getUserBirthDay(), testData.getUserMonthOfBirth(), testData.getUserYearOfBirth())
                .clickSubmitButton();

        registrationPage.checkTableResultsAppear()
                .checkTableResultsHeader().checkResuls("Student Name", testData.getUserFirstName() + " " + testData.getUserLastName())
                .checkResuls("Student Email", testData.getUserEmail())
                .checkResuls("Gender", testData.getUserGender())
                .checkResuls("Mobile", testData.getUserPhoneNumber())
                .checkResuls("Date of Birth", testData.getUserBirthDay() + " " + testData.getUserMonthOfBirth() + "," + testData.getUserYearOfBirth());
    }

    @Test
    void registrationFormNegativeTest(){
        TestData testData = new TestData();
        registrationPage.openPage().
                removeBanners()
                .setFirstName(testData.getUserFirstName())
                .setUserEmail(testData.getUserEmail())
                .setUserGender(testData.getUserGender())
                .setUserNumber(testData.getUserPhoneNumber())
                .setDateOfBirth(testData.getUserBirthDay(), testData.getUserMonthOfBirth(), testData.getUserYearOfBirth())
                .clickSubmitButton();

        registrationPage.checkTableResultsNotAppear();
    }
}

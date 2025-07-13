package tests;

import tests.data.TestData;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;

import static utils.RandomUtils.*;

public class FormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void registrationFormAllFieldsTest() {
        registrationPage.openPage().
                removeBanners().
                setFirstName(TestData.getUserFirstName()).
                setLastName(TestData.getUserLastName()).
                setUserEmail(TestData.getUserEmail()).
                setUserGender(TestData.getUserGender()).
                setUserNumber(TestData.getUserPhoneNumber()).
                setDateOfBirth(TestData.getUserBirthDay(), TestData.getUserMonthOfBirth(), TestData.getUserYearOfBirth()).
                setSubjects(TestData.getUserSubject()).
                setUserHobbies(TestData.getUserHobbies()).
                uploadUserPhoto(TestData.getUserPicture()).
                setUserAddress(TestData.getUserAddress()).
                setUserState(TestData.getUserState()).
                setUserCity(TestData.getUserCity()).
                clickSubmitButton();

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
        registrationPage.openPage().
                removeBanners().
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

    @Test
    void registrationFormNegativeTest(){
        registrationPage.openPage().
                removeBanners().
                setFirstName("test1").
                setUserEmail("test1@local.local").
                setUserGender("Female").
                setUserNumber("8963598710").
                setDateOfBirth("30", "July", "1990").
                clickSubmitButton();

        registrationPage.checkTableResultsNotAppear();
    }
}

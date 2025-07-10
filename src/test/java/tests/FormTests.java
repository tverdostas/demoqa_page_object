package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;

public class FormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void registrationFormAllFieldsTest() {
        registrationPage.openPage().
                removeBanners().
                setFirstName(RandomUtils.getUserFirstName()).
                setLastName(RandomUtils.getUserLastName()).
                setUserEmail(RandomUtils.getUserEmail()).
                setUserGender(RandomUtils.getRandomGender()).
                setUserNumber(RandomUtils.getUserPhoneNumber()).
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

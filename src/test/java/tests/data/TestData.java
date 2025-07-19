package tests.data;

import utils.RandomUtils;

public class TestData {
    private final String userFirstName = RandomUtils.getUserFirstName();
    private final String userLastName = RandomUtils.getUserLastName();
    private final String userEmail = RandomUtils.getUserEmail();
    private final String userGender = RandomUtils.getUserGender();
    private final String userPhoneNumber = RandomUtils.getUserPhoneNumber();
    private final String userBirthDay = RandomUtils.getUserBirthDay();
    private final String userMonthOfBirth = RandomUtils.getUserMonthOfBirth();
    private final String userYearOfBirth = RandomUtils.getUserYearOfBirth();
    private final String userSubject = RandomUtils.getSubject();
    private final String userHobbies = RandomUtils.getUserHobbies();
    private final String userPicture = RandomUtils.getUserPhoto();
    private final String userAddress = RandomUtils.getUserAddress();
    private final String state = RandomUtils.getUserState();
    private final String city = RandomUtils.getUserCity(state);

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserGender() {
        return userGender;
    }
    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public String getUserBirthDay() {
        return userBirthDay;
    }

    public String getUserMonthOfBirth() {
        return userMonthOfBirth;
    }

    public String getUserYearOfBirth() {
        return userYearOfBirth;
    }

    public String getUserSubject() {
        return userSubject;
    }

    public String getUserHobbies() {
        return userHobbies;
    }

    public String getUserPicture() {
        return userPicture;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public String getUserState() {
        return state;
    }

    public String getUserCity() {
        return city;
    }

}

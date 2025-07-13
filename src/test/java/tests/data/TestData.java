package tests.data;

import utils.RandomUtils;

public class TestData {

    static String userFirstName = RandomUtils.getUserFirstName();
    static String userLastName = RandomUtils.getUserLastName();
    static String userEmail = RandomUtils.getUserEmail();
    static String userGender = RandomUtils.getUserGender();
    static String getUserPhoneNumber = RandomUtils.getUserPhoneNumber();
    static String userPhoneNumber = RandomUtils.getUserPhoneNumber();
    static String userBirthDay = RandomUtils.getUserBirthDay();
    static String userMonthOfBirth = RandomUtils.getUserMonthOfBirth();
    static String userYearOfBirth = RandomUtils.getUserYearOfBirth();
    static String userSubject = RandomUtils.getSubject();
    static String userHobbies = RandomUtils.getUserHobbies();
    static String userPicture = RandomUtils.getUserPhoto();
    static String userAddress = RandomUtils.getUserAddress();
    static String state = RandomUtils.getUserState();
    static String city = RandomUtils.getUserCity(state);

    public static String getUserFirstName() {
        return userFirstName;
    }

    public static String getUserLastName() {
        return userLastName;
    }

    public static String getUserEmail() {
        return userEmail;
    }

    public static String getUserGender() {
        return userGender;
    }

    public static String getGetUserPhoneNumber() {
        return getUserPhoneNumber;
    }

    public static String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public static String getUserBirthDay() {
        return userBirthDay;
    }

    public static String getUserMonthOfBirth() {
        return userMonthOfBirth;
    }

    public static String getUserYearOfBirth() {
        return userYearOfBirth;
    }

    public static String getUserSubject() {
        return userSubject;
    }

    public static String getUserHobbies() {
        return userHobbies;
    }

    public static String getUserPicture() {
        return userPicture;
    }

    public static String getUserAddress() {
        return userAddress;
    }

    public static String getUserState() {
        return state;
    }

    public static String getUserCity() {
        return city;
    }

}

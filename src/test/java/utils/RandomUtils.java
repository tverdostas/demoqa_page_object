package utils;

import com.github.javafaker.Faker;

import java.util.Map;

import static java.lang.String.format;


public class RandomUtils {

    static Faker faker = new Faker();

    public static String getUserFirstName() {
        return faker.name().firstName();
    }
    public static String getUserLastName() {
        return faker.name().lastName();
    }

    public static String getUserEmail() {
        return getUserFirstName().toLowerCase() + "." + getUserLastName().toLowerCase() + "@gmail.com";
    }
    public static String getUserGender() {
        return faker.options().option("Male", "Female", "Other");
    }

    public static String getUserPhoneNumber() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public static String getUserBirthDay() {
        return format("%02d", faker.number().numberBetween(1, 9));
    }

    public static String getUserMonthOfBirth() {
        return faker.options().option("January", "February", "March", "April",
                "May", "June", "July", "August", "September", "October", "November", "December");
    }

    public static String getUserYearOfBirth() {
        return format("%s", faker.number().numberBetween(1950, 2007));
    }

    public static String getSubject(){
return faker.options().option("English", "Maths", "Physics", "Chemistry", "Computer Science", "Economics", "Arts",
        "Social Studies", "History", "Civics");
    }

    public static String getUserHobbies(){
        return faker.options().option("Sports", "Reading", "Music");
    }

    public static String getUserPhoto(){
        return faker.options().option("gif_raсcoon.gif", "jpg_summer.jpg", "png_vinni.png");
    }
    
    public static String getUserAddress(){
        return faker.address().fullAddress();
    }

    public static final Map<String, String[]> mapStateWithCity = Map.of(
            "NCR", new String[]{"Delhi", "Gurgaon", "Noida"},
            "Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"},
            "Haryana", new String[]{"Karnal", "Panipat"},
            "Rajasthan", new String[]{"Jaipur", "Jaiselmer"}
    );
    public static String getUserState() {
        return faker.options().option(mapStateWithCity.keySet().toArray()).toString();
    }

    public static String getUserCity(String state) {
        return faker.options().option(mapStateWithCity.get(state));
    }

}

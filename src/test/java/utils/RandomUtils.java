package utils;

import com.github.javafaker.Faker;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.String.format;


public class RandomUtils {

    static Faker faker = new Faker();
    static String userFirstName = faker.name().firstName();
    static String userLastName = faker.name().lastName();
    static String userEmail = userFirstName.toLowerCase() + "." + userLastName.toLowerCase() + "@gmail.com";
    static String userPhoneNumber = faker.phoneNumber().subscriberNumber(10);
    static String userBirthDay;

    public static String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public static String getUserFirstName() {
        return userFirstName;
    }
    public static String getUserLastName() {
        return userLastName;
    }

    public static String getUserEmail() {
        return userEmail;
    }

    public static String getUserBirthDay() {
        return format("%02d", faker.number().numberBetween(1, 9));
    }

    public static String getMonth() {
        return faker.options().option("January", "February", "March", "April",
                "May", "June", "July", "August", "September", "October", "November", "December");
    }

    public static String getYear() {
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

    public static int getRandomInt(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomItemFromArray(String[] array){
        int index = getRandomInt(0, array.length - 1);

        return array[index];
    }

    public static String getRandomGender(){
        String[] genders = {"Male", "Female", "Other"};

        return getRandomItemFromArray(genders);
    }


}

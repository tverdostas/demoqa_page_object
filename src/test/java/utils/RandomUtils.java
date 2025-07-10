package utils;

import com.github.javafaker.Faker;

import java.util.concurrent.ThreadLocalRandom;


public class RandomUtils {

    static Faker faker = new Faker();
    static String userFirstName = faker.name().firstName();
    static String userLastName = faker.name().lastName();
    static String userEmail = userFirstName.toLowerCase() + "." + userLastName.toLowerCase() + "@gmail.com";
    static String userPhoneNumber = faker.phoneNumber().subscriberNumber(10);
    static String userDayOfBirth;

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

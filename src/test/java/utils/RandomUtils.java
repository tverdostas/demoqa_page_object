package utils;

import com.github.javafaker.Faker;

public class RandomUtils {

    static Faker faker = new Faker();

    static String userName = faker.name().firstName();
    static String userLastName = faker.name().lastName();
    static String userEmail = userName + "." + userLastName + "@gmail.com";;

    public static String getUserName() {
        return userName;
    }

    public static String getRandomGender(){
        String[] genders = {"Male", "Female", "Other"};

        return getRandomItemFromArray(genders);
    }

    public static String getRandomItemFromArray(String[] array){
        int index = getRandomInt(0, array.length - 1);

        return array[index];
    }
}

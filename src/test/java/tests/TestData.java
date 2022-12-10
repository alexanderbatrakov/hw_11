package tests;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class TestData {
    static Faker faker = new Faker(new Locale("en"));
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
    static String[] birthday = dateFormat.format(faker.date().birthday()).split(" ");
    static String[] stateAndCityArray = stateAndCity();
    static String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userNumber = faker.number().digits(10),
            currentAddress = faker.address().cityName(),
            gender = genderInputData(),
            dayOfBirth = birthday[0],
            monthOfBirth = birthday[1],
            yearOfBirth = birthday[2],
            subject = subjectInputData(),
            hobby = hobbyInputData(),
            picPath = "src/test/resources/testfile.jpg",
            state = stateAndCityArray[0],
            city = stateAndCityArray[1];


    public static String genderInputData() {
        String[] genders = {"Male", "Female", "Other"};
        int index = faker.number().numberBetween(0, genders.length);

        return genders[index];
    }

    public static String subjectInputData() {
        String[] subject = {"Maths", "Chemistry", "Computer Science", "Commerce", "Economics"};
        int index = faker.number().numberBetween(0, subject.length);

        return subject[index];
    }

    public static String hobbyInputData() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        int index = faker.number().numberBetween(0, hobbies.length);

        return hobbies[index];

    }

    public static String[] stateAndCity() {
        String[][] test = {{"NCR", "Delhi"},
                {"NCR", "Gurgaon"},
                {"NCR", "Noida"},
                {"Uttar Pradesh", "Agra"},
                {"Uttar Pradesh", "Lucknow"},
                {"Uttar Pradesh", "Merrut"},
                {"Haryana", "Karnal"},
                {"Haryana", "Panipat"},
                {"Rajasthan", "Jaipur"},
                {"Rajasthan", "Jaiselmer"}};
        int index = faker.number().numberBetween(0, test.length);
        return test[index] ;
    }

}


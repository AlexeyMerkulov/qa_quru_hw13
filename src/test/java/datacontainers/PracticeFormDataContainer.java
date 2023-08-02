package datacontainers;

import com.github.javafaker.Faker;
import utils.PracticeFormDataGenerator;

public class PracticeFormDataContainer {

    private PracticeFormDataGenerator dataGenerator = new PracticeFormDataGenerator();
    private String[] birthdate = dataGenerator.getRandomDate().split(" ");

    private String firstName = dataGenerator.getRandomFirstName();
    private String lastName = dataGenerator.getRandomLastName();
    private String userEmail = dataGenerator.getRandomEmail();
    private String gender = dataGenerator.getRandomGender();
    private String userNumber = dataGenerator.getRandomPhoneNumber();
    private String dayOfBirthdate = birthdate[0];
    private String monthOfBirthdate = birthdate[1];
    private String yearOfBirthdate = birthdate[2];
    private String subject = dataGenerator.getRandomSubject();
    private String hobby = dataGenerator.getRandomHobby();
    private String filePath = "selenide.jpg";
    private String address = dataGenerator.getRandomAddress();
    private String state = dataGenerator.getRandomState();
    private String city = dataGenerator.getRandomCity(state);

    public PracticeFormDataContainer() {}

    public PracticeFormDataContainer(Faker faker) {
        this.dataGenerator = new PracticeFormDataGenerator(faker);
    }

    public PracticeFormDataContainer(String filePath) {
        this.filePath = filePath;
    }

    public PracticeFormDataContainer(Faker faker, String filePath) {
        this.dataGenerator = new PracticeFormDataGenerator(faker);
        this.filePath = filePath;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getGender() {
        return gender;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public String getDayOfBirthdate() {
        return dayOfBirthdate;
    }

    public String getMonthOfBirthdate() {
        return monthOfBirthdate;
    }

    public String getYearOfBirthdate() {
        return yearOfBirthdate;
    }

    public String getSubject() {
        return subject;
    }

    public String getHobby() {
        return hobby;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getAddress() {
        return address;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }
}

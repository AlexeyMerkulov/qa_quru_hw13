package tests;

import datacontainers.PracticeFormDataContainer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static io.qameta.allure.Allure.step;

public class RegistrationTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @Tag("registration")
    @DisplayName("Успешная регистрация")
    void successfulRegistrationTest() {
        var testData = new PracticeFormDataContainer();
        step("Открыть форму регистрации", () -> {
            registrationPage.openPage()
                    .removeBanners();
        });
        step("Заполнить форму регистрации", () -> {
            registrationPage.setFirstName(testData.getFirstName())
                    .setLastName(testData.getLastName())
                    .setUserEmail(testData.getUserEmail())
                    .setGender(testData.getGender())
                    .setUserNumber(testData.getUserNumber())
                    .setBirthDay(
                            testData.getDayOfBirthdate(),
                            testData.getMonthOfBirthdate(),
                            testData.getYearOfBirthdate()
                    )
                    .setSubject(testData.getSubject())
                    .setHobby(testData.getHobby())
                    .uploadPicture(testData.getFilePath())
                    .setAddress(testData.getAddress())
                    .setState(testData.getState())
                    .setCity(testData.getCity())
                    .submitInputData();
        });
        step("Проверить результаты заполнения формы", () -> {
            registrationPage.verifyModalDialogAppeared()
                    .verifyResult("Student Name", String.format(
                            "%s %s",
                            testData.getFirstName(),
                            testData.getLastName())
                    )
                    .verifyResult("Student Email", testData.getUserEmail())
                    .verifyResult("Gender", testData.getGender())
                    .verifyResult("Mobile", testData.getUserNumber())
                    .verifyResult("Date of Birth", String.format(
                            "%s %s,%s",
                            testData.getDayOfBirthdate(),
                            testData.getMonthOfBirthdate(),
                            testData.getYearOfBirthdate())
                    )
                    .verifyResult("Subjects", testData.getSubject())
                    .verifyResult("Hobbies", testData.getHobby())
                    .verifyResult("Picture", testData.getFilePath())
                    .verifyResult("Address", testData.getAddress())
                    .verifyResult("State and City", String.format(
                            "%s %s",
                            testData.getState(),
                            testData.getCity())
                    );
        });
    }
}




package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultTableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();

    ResultTableComponent resultTableComponent = new ResultTableComponent();

    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            birthDayInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbyWrapper = $("#hobbiesWrapper"),
            pictureInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateContainer = $("#state"),
            cityContainer = $("#city"),
            submitButton = $("#submit");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }

    public RegistrationPage removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);

        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);

        return this;
    }

    public RegistrationPage setUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);

        return this;
    }

    public RegistrationPage setGender(String gender) {
        genderWrapper.$(byText(gender)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);

        return this;
    }


    public RegistrationPage setBirthDay(String day, String month, String year) {
        birthDayInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject(String subject) {
        subjectInput.setValue(subject).pressEnter();

        return this;
    }

    public RegistrationPage setHobby(String hobby) {
        hobbyWrapper.$(byText(hobby)).click();

        return this;
    }

    public RegistrationPage uploadPicture(String filePath) {
        pictureInput.uploadFromClasspath(filePath);

        return this;
    }

    public RegistrationPage setAddress(String address) {
        addressInput.setValue(address);

        return this;
    }

    public RegistrationPage setState(String stateName) {
        stateContainer.click();
        $(byText(stateName)).click();

        return this;
    }

    public RegistrationPage setCity(String cityName) {
        cityContainer.click();
        $(byText(cityName)).click();

        return this;
    }

    public RegistrationPage submitInputData() {
        submitButton.click();

        return this;
    }

    public RegistrationPage verifyModalDialogAppeared() {
        resultTableComponent.verifyModalDialogAppeared();

        return this;
    }

    public RegistrationPage verifyResult(String label, String value) {
        resultTableComponent.verifyTableContent(label, value);

        return this;
    }
}
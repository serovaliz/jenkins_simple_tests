package tests.pages;

import com.codeborne.selenide.SelenideElement;
import tests.pages.components.CalendarComponent;
import tests.pages.components.ResultComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class RegistrationFormPage {
    CalendarComponent calendar = new CalendarComponent();
    ResultComponent resultComponent = new ResultComponent();

    private final SelenideElement firstNameInput = $("[id=firstName]");
    private final SelenideElement lastNameInput = $("[id=lastName]");
    private final SelenideElement userEmailInput = $("[id=userEmail]");
    private final SelenideElement genderWrapperContainer = $("[id=genterWrapper]");
    private final SelenideElement userNumberInput = $("[id=userNumber]");
    private final SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private final SelenideElement subjectsInput = $("[id=subjectsInput]");
    private final SelenideElement hobbiesWrapperInput = $("[id=hobbiesWrapper]");
    private final SelenideElement pictureResource = $("#uploadPicture");
    private final SelenideElement userCurrentAddressInput = $("textarea[placeholder*='Current Address']");
    private final SelenideElement userStateInput = $("#react-select-3-input");
    private final SelenideElement userCityInput = $("#react-select-4-input");
    private final SelenideElement submitButton = $("[id=submit]");
    private final SelenideElement title = $("[id=example-modal-sizes-title-lg]");


    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationFormPage enterFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage enterLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage enterUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationFormPage enterGender(String value) {
        genderWrapperContainer.find(byText(value)).click();
        return this;
    }

    public RegistrationFormPage enterUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setDateOfBirth(String day, String month, String year) {
        $(dateOfBirthInput).click();
        calendar.setDateOfBirth(day, month, year);
        return this;
    }

    public RegistrationFormPage selectSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationFormPage selectHobbies(String value) {
        hobbiesWrapperInput.find(byText(value)).click();
        return this;
    }

    public RegistrationFormPage selectPictureResource(String value) {
        pictureResource.uploadFromClasspath(value);
        return this;
    }

    public RegistrationFormPage enterCurrentAddress(String value) {
        userCurrentAddressInput.setValue(value);
        return this;
    }

    public RegistrationFormPage enterUserState(String value) {
        userStateInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationFormPage enterUserCity(String value) {
        userCityInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationFormPage enterSubmitButton() {
        submitButton.click();
        return this;
    }

    public void resultWindowDidNotAppear() {
        title.shouldNotBe(visible);
    }

    public RegistrationFormPage resultWindowAppear() {
        resultComponent.checkResultWindow();
        return this;
    }

    public RegistrationFormPage checkForm(String key, String value) {
        resultComponent.checkResult(key, value);
        return this;
    }

    public void closeForm() {
        resultComponent.closeWindow();
    }


}

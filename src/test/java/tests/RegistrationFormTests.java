package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.pages.RegistrationFormPage;

import static io.qameta.allure.Allure.step;
import static tests.testdata.TestData.*;

@DisplayName("Заполнение формы регистрации студента")
public class RegistrationFormTests extends TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();


    @DisplayName("Успешное заполенение формы")
    @Test
    public void positivePracticeFormTest() {
        step("Opening Registration form page", () ->
                registrationFormPage.openPage()
        );
        step("Filling in the fields on the registration form page", () -> {
            registrationFormPage.enterFirstName(firstName)
                    .enterLastName(lastName)
                    .enterUserEmail(userEmail)
                    .enterGender(sex)
                    .enterUserNumber(userNumber)
                    .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                    .selectSubjects(subjects)
                    .selectHobbies(hobbiesWrapperSports)
                    .selectHobbies(hobbiesWrapperMusic)
                    .selectPictureResource(picture)
                    .enterCurrentAddress(currentAddress)
                    .enterUserState(state)
                    .enterUserCity(city);
        });
        step("Enter submit button", () ->
                registrationFormPage.enterSubmitButton()
        );
        step("Result window appear", () ->
                registrationFormPage.resultWindowAppear()
        );
        step("Result window check", () -> {

            registrationFormPage.checkForm("Student Name", firstName + " " + lastName)
                    .checkForm("Student Email", userEmail)
                    .checkForm("Gender", sex)
                    .checkForm("Mobile", userNumber)
                    .checkForm("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                    .checkForm("Subjects", subjects)
                    .checkForm("Hobbies", hobbiesWrapperSports + ", " + hobbiesWrapperMusic)
                    .checkForm("Address", currentAddress)
                    .checkForm("Picture", picture)
                    .checkForm("State and City", state + " " + city);
        });
        step("Close result window", () ->
                registrationFormPage.closeForm()
        );


    }

    @DisplayName("Проверка заполнения только обязательных полей")
    @Test
    public void requiredFieldsOnly() {
        step("Opening Registration form page", () ->
                registrationFormPage.openPage()
        );
        step("Filling in the fields on the registration form page", () -> {
            registrationFormPage.enterFirstName(firstName)
                    .enterLastName(lastName)
                    .enterUserEmail(userEmail)
                    .enterGender(sex)
                    .enterUserNumber(userNumber);
        });
        step("Enter submit button", () ->
                registrationFormPage.enterSubmitButton()
        );
        step("Result window appear", () ->
                registrationFormPage.resultWindowAppear()
        );
        step("Result window check", () -> {
            registrationFormPage.checkForm("Student Name", firstName + " " + lastName)
                    .checkForm("Student Email", userEmail)
                    .checkForm("Gender", sex)
                    .checkForm("Mobile", userNumber);
        });


    }

    @DisplayName("Проверка на заполнение только не обязательных")
    @Test
    public void notRequiredFieldsOnly() {
        step("Opening Registration form page", () ->
                registrationFormPage.openPage()
        );
        step("Filling in the fields on the registration form page", () -> {
            registrationFormPage.enterUserEmail(userEmail)
                    .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                    .selectSubjects(subjects)
                    .selectPictureResource(picture)
                    .enterCurrentAddress(currentAddress)
                    .enterUserState(state)
                    .enterUserCity(city);
        });
        step("Enter submit button", () ->
                registrationFormPage.enterSubmitButton()
        );
        step("Result window appear", () ->
                registrationFormPage.resultWindowDidNotAppear()
        );


    }

    @DisplayName("Проверка отправки пустой формы")
    @Test
    public void emptyFields() {
        step("Opening Registration form page", () ->
                registrationFormPage.openPage()
        );
        step("Enter submit button", () ->
                registrationFormPage.enterSubmitButton()
        );
        step("Result window didn't appear", () ->
                registrationFormPage.resultWindowDidNotAppear()
        );


    }

    @DisplayName("Отправка формы с невалидным email")
    @Test
    public void invalidEmail() {
        step("Opening Registration form page", () ->
                registrationFormPage.openPage()
        );
        step("Filling in the fields on the registration form page", () -> {
            registrationFormPage.enterFirstName(firstName)
                    .enterLastName(lastName)
                    .enterUserEmail(incorrectEmail)
                    .enterGender(sex)
                    .enterUserNumber(userNumber);
        });
        step("Enter submit button", () ->
                registrationFormPage.enterSubmitButton()
        );
        step("Result window did not appear", () ->
                registrationFormPage.resultWindowDidNotAppear()
        );

    }


}

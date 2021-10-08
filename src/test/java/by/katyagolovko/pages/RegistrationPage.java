package by.katyagolovko.pages;

import by.katyagolovko.pages.components.CalendarComponent;
import by.katyagolovko.pages.components.StateCityComponent;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private final String FORM_TITLE = "Student Registration Form",
                         SUBMIT_TABLE_TITLE = "Thanks for submitting the form";
    private SelenideElement formTitle = $(".practice-form-wrapper"),
                            firstNameInput = $("#firstName"),
                            lastNameInput = $("#lastName"),
                            emailInput = $("#userEmail"),
                            genderSelect = $("#genterWrapper"),
                            mobileNumberInput = $("#userNumber"),
                            currentAddressInput = $("#currentAddress"),
                            hobbySelect = $("#hobbiesWrapper"),
                            subjectsInput = $("#subjectsInput"),
                            uploadPictureInput = $("#uploadPicture"),
                            submitButton = $("#submit"),
                            submitTable = $(".table-responsive"),
                            submitTableTitle = $("#example-modal-sizes-title-lg");


    public CalendarComponent calendar = new CalendarComponent();
    public StateCityComponent stateCity = new StateCityComponent();

    @Step("Открываем страницу с Student Registration Form")
    public void openPage(){
        open("/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
    }

    @Step("Проставляем First Name")
    public RegistrationPage setFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }

    @Step("Проставляем Last Name")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    @Step("Проставляем Email")
    public RegistrationPage setEmail(String value){
        emailInput.setValue(value);
        return this;
    }

    @Step("Проставляем Gender")
    public RegistrationPage selectGender(String value){
        genderSelect.$(byText(value)).click();
        return this;
    }

    @Step("Проставляем Mobile Number")
    public RegistrationPage setMobileNumber(String value){
        mobileNumberInput.setValue(value);
        return this;
    }

    @Step("Проставляем Subject")
    public RegistrationPage selectSubject(String value){
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    @Step("Проставляем Hobby")
    public RegistrationPage selectHobby(String value){
        hobbySelect.$(byText(value)).click();
        return this;
    }

    @Step("Загружаем картинку")
    public RegistrationPage uploadPicture(String fileName){
        uploadPictureInput.uploadFromClasspath(fileName);
        return this;
    }

    @Step("Проставляем Current Address")
    public RegistrationPage setCurrentAddress(String value){
        currentAddressInput.setValue(value);
        return this;
    }

    @Step("Сохраняем данные в форме")
    public void submitPage(){
        submitButton.click();
    }

    @Step("Проверяем текст {value}")
    public RegistrationPage checkValue(String value){
        submitTable.shouldHave(text(value));
        return this;
    }

    @Step("Проверяем тайтл таблицы с данными")
    public RegistrationPage checkTitle() {
        submitTableTitle.shouldHave(text(SUBMIT_TABLE_TITLE));
        return this;
    }
}

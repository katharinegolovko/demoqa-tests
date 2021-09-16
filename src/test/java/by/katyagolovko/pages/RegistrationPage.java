package by.katyagolovko.pages;

import by.katyagolovko.pages.components.CalendarComponent;
import by.katyagolovko.pages.components.StateCityComponent;
import com.codeborne.selenide.SelenideElement;

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

    public void openPage(){
        open("/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
    }

    public RegistrationPage setFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value){
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage selectGender(String value){
        genderSelect.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setMobileNumber(String value){
       mobileNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage selectSubject(String value){
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage selectHobby(String value){
        hobbySelect.$(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String fileName){
        uploadPictureInput.uploadFromClasspath(fileName);
        return this;
    }

    public RegistrationPage setCurrentAddress(String value){
        currentAddressInput.setValue(value);
        return this;
    }

    public void submitPage(){
        submitButton.click();
    }

    public RegistrationPage checkValue(String value){
        submitTable.shouldHave(text(value));
        return this;
    }

    public RegistrationPage checkTitle() {
        submitTableTitle.shouldHave(text(SUBMIT_TABLE_TITLE));
        return this;
    }
}

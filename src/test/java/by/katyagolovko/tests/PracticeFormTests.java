package by.katyagolovko.tests;

import by.katyagolovko.pages.RegistrationPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

public class PracticeFormTests extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
           lastName = faker.name().lastName(),
           email = faker.internet().emailAddress(),
           mobileNumber = faker.numerify("##########"),
           gender = "Female",
           address = faker.address().fullAddress(),
           fileName = "husky-puppy.jpeg",
           hobby = "Music",
           subject = "English",
           dayOfBirth = "26",
           monthOfBirth = "August",
           yearOfBirth = "1997",
           state = "Haryana",
           city = "Karnal";

    @Test
    void fillFormTest(){

        registrationPage.openPage();
        registrationPage.setFirstName(firstName)
                        .setLastName(lastName)
                        .setEmail(email)
                        .selectGender(gender)
                        .setMobileNumber(mobileNumber)
                        .calendar.setDate(dayOfBirth,monthOfBirth, yearOfBirth);
        registrationPage.selectSubject(subject)
                        .selectHobby(hobby)
                        .uploadPicture(fileName)
                        .setCurrentAddress(address)
                        .stateCity.setValues(state, city);
        registrationPage.submitPage();

        registrationPage.checkTitle()
                        .checkValue(firstName)
                        .checkValue(lastName)
                        .checkValue(email)
                        .checkValue(gender)
                        .checkValue(mobileNumber)
                        .checkValue(dayOfBirth)
                        .checkValue(monthOfBirth)
                        .checkValue(yearOfBirth)
                        .checkValue(subject)
                        .checkValue(hobby)
                        .checkValue(fileName)
                        .checkValue(address)
                        .checkValue(state)
                        .checkValue(city);
    }
}

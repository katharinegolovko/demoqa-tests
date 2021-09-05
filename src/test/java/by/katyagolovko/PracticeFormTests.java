package by.katyagolovko;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillFormTest(){
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Ekaterina");
        $("#lastName").setValue("Golovko");
        $("#userEmail").setValue("testemail@gmail.com");
        $("#genterWrapper .custom-control:nth-child(2) .custom-control-label").click();
        $("#userNumber").setValue("7123344214");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").selectOption("1997");
        $(".react-datepicker__day--026").click();
        $("#subjectsInput").setValue("E");
        $("#react-select-2-option-0").click();
        $("#hobbiesWrapper .custom-control:nth-child(3) .custom-control-label").click();
        $("#uploadPicture").uploadFromClasspath("husky-puppy.jpeg");
        $("#currentAddress").setValue("Minsk, Belarus");
        $("#stateCity-wrapper").scrollTo();
        $("#state").click();
        $("#react-select-3-option-2").click();
        $("#stateCity-wrapper #city").click();
        $("#react-select-4-option-0").click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive tr td:nth-child(2)").shouldHave(text("Ekaterina Golovko"));
        $(".table-responsive tr:nth-child(2) td:nth-child(2)").shouldHave(text("testemail@gmail.com"));
        $(".table-responsive tr:nth-child(3) td:nth-child(2)").shouldHave(text("Female"));
        $(".table-responsive tr:nth-child(4) td:nth-child(2)").shouldHave(text("7123344214"));
        $(".table-responsive tr:nth-child(5) td:nth-child(2)").shouldHave(text("26 August,1997"));
        $(".table-responsive tr:nth-child(6) td:nth-child(2)").shouldHave(text("English"));
        $(".table-responsive tr:nth-child(7) td:nth-child(2)").shouldHave(text("Music"));
        $(".table-responsive tr:nth-child(8) td:nth-child(2)").shouldHave(text("husky-puppy.jpeg"));
        $(".table-responsive tr:nth-child(9) td:nth-child(2)").shouldHave(text("Minsk, Belarus"));
        $(".table-responsive tr:nth-child(10) td:nth-child(2)").shouldHave(text("Haryana Karnal"));
    }
}

package by.katyagolovko.tests;

import by.katyagolovko.config.CredentialsConfig;
import by.katyagolovko.helpers.Attach;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static java.lang.String.format;

public class TestBase {

    public static CredentialsConfig credentials = ConfigFactory.create(CredentialsConfig.class);

    @BeforeAll
    static void beforeAll() {

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        String username = credentials.username();
        String password = credentials.password();
        Configuration.browserCapabilities = capabilities;
        Configuration.startMaximized = true;
        String selenoidURL = format("https://%s:$s@selenoid.autotests.cloud/wd/hub/", username, password);
        Configuration.remote = selenoidURL;
        Configuration.baseUrl = "https://demoqa.com";
    }

    @AfterEach
    public void afterAll() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }


}

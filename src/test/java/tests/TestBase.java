package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.PracticeFormPage;
import support.Attach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static support.Attach.*;

public class TestBase {
    public static String selenideUrl = System.getProperty("remoteURL", "https://user1:1234@selenoid.autotests.cloud/");
    PracticeFormPage practiceFormPage = new PracticeFormPage();
    @BeforeAll
    static void beforeAll() {

        Configuration.holdBrowserOpen = false;
        Configuration.browserSize = System.getProperty("browserSize","1920x1080");
        Configuration.browser = System.getProperty("browser","chrome");
        Configuration.browserVersion = System.getProperty("browserVer","100.0");
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.remote = selenideUrl+"wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    public void tearDown() {
        screenshotAs("Last screenshot");
        pageSource();
        browserConsoleLogs();
        addVideo();
        closeWebDriver();
    }
}

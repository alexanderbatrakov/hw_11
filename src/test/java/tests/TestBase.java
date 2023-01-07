package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.ProjectConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.PracticeFormPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static config.ProjectConfiguration.projectConfig;
import static support.Attach.*;

public class TestBase {
    public static String selenideUrl;
    PracticeFormPage practiceFormPage = new PracticeFormPage();
    private static final ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());
    @BeforeAll
    static void beforeAll() {
        projectConfig(config);
        Configuration.holdBrowserOpen = false;
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

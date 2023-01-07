package config;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;
import tests.TestBase;

public class ProjectConfiguration {

    public static void projectConfig(ProjectConfig projectConfig) {
        Configuration.browserSize = projectConfig.getBrowserSize();
        Configuration.browser = projectConfig.getBrowser();
        Configuration.browserVersion = projectConfig.getBrowserVersion();
       Configuration.baseUrl = projectConfig.getBaseUrl();

        if(projectConfig.getIsRemote()) {
            TestBase.selenideUrl = projectConfig.getSelenideUrl();
            Configuration.remote = TestBase.selenideUrl+"wd/hub";
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }
    }
}

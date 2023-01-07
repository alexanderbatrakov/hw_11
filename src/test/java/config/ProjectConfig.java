package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:${env}.properties"})

public interface ProjectConfig extends Config {
    @Key("browserSize")
    String getBrowserSize();

    @Key("browser")
    String getBrowser();

    @Key("browserVersion")
    String getBrowserVersion();

    @Key("baseUrl")
    String getBaseUrl();

    @Key("isRemote")
    Boolean getIsRemote();

    @Key("selenideUrl")
    String getSelenideUrl();

}

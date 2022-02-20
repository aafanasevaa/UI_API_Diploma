package aafanasyevaa.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/local.properties",
        "classpath:config/remote.properties",
        "classpath:config/credentials.properties"
})

public interface ProjectConfig extends Config {

    @Config.Key("browser")
    @Config.DefaultValue("chrome")
    String browser();

    @Config.Key("browserVersion")
    @Config.DefaultValue("95.0")
    String browserVersion();

    @Config.Key("browserSize")
    @Config.DefaultValue("1920x1080")
    String browserSize();

    @Config.Key("remoteUrl")
    @Config.DefaultValue("")
    String remoteUrl();

    @Config.Key("videoStorage")
    String videoStorage();

    String login();

    String password();
}

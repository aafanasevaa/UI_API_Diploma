package aafanasyevaa.helpers;
import aafanasyevaa.config.ProjectConfig;
import com.codeborne.selenide.Configuration;
import aafanasyevaa.config.Project;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static java.lang.String.format;

public class DriverSettings {

    public static final ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());

    public static void configure() {
        Configuration.browser = config.browser();
        Configuration.browserVersion = config.browserVersion();
        Configuration.browserSize = config.browserSize();

        ProjectConfig credentials = ConfigFactory.create(ProjectConfig.class);
        String url = System.getProperty("url", "selenoid.autotests.cloud/wd/hub/");
        Configuration.remote = format("https://%s:%s@%s", credentials.login(), credentials.password(), url);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--lang=en-en");


        if (Project.isRemoteWebDriver()) {
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.remote = String.format(config.remoteUrl(), config.login(), config.password());
        }
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        Configuration.browserCapabilities = capabilities;
    }
}
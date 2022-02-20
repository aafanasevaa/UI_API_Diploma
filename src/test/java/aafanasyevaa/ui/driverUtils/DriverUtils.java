package aafanasyevaa.ui.driverUtils;

import com.codeborne.selenide.Selenide;

import static org.openqa.selenium.logging.LogType.BROWSER;

public class DriverUtils {

    public static String getConsoleLogs() {
        return String.join("\n", Selenide.getWebDriverLogs(BROWSER));
    }
}
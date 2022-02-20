package aafanasyevaa.config;

import org.aeonbits.owner.ConfigFactory;

public class Project {
    public static final ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());

    public static boolean isRemoteWebDriver() {
        return !config.remoteUrl().equals("");
    }

    public static boolean isVideoTurnedOn() {
        return !config.videoStorage().equals("");
    }
}
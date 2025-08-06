package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {
    @BeforeAll
    static void browserConfigurations(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "firefox";
        // Configuration.browserVersion = "134.0";

//        ChromeOptions option = new ChromeOptions();
//        option.addArguments("--incognito");
//
//        Configuration.browserCapabilities.merge(option);

        // Configuration.browserCapabilities = new ChromeOptions().addArguments("--incognito");
    }

    @AfterEach
    public void closeWebDriver() {
        Selenide.closeWebDriver();
    }

}

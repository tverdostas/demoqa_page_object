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

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        if (!System.getenv().containsKey("OS") || !System.getenv("OS").equals("Windows_NT")) {
            options.addArguments("--user-data-dir=/home/jenkins/workspace/anastasiya_elkafrawy_11_lesson_qaguru/chrome_data");
        }
        options.addArguments("--disable-extensions");

        Configuration.browserCapabilities = options;
    }

    @AfterEach
    public void closeWebDriver() {
        Selenide.closeWebDriver();
    }

}

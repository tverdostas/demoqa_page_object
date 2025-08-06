package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
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
//        if (!System.getenv().containsKey("OS") || !System.getenv("OS").equals("Windows_NT")) {
//            options.addArguments("--user-data-dir=/home/jenkins/workspace/anastasiya_elkafrawy_11_lesson_qaguru/chrome_data");
//        }
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless=new");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-setuid-sandbox");

        options.addArguments("--disable-application-cache");
        options.addArguments("--enable-do-not-track");
        options.addArguments("--disable-popup-blocking");

        Configuration.browserCapabilities = options;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        // or for fine-tuning:
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
        );
    }

    @AfterEach
    public void closeWebDriver() {
        Selenide.closeWebDriver();
    }

}

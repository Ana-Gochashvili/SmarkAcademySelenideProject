package utils;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.*;
import steps.AuthorizationPopUpSteps;
import steps.MainPageSteps;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseAuth {
    protected MainPageSteps mainPageSteps;
    protected AuthorizationPopUpSteps authorizationPopUpSteps;

    @BeforeSuite(description = "Initializes Pages objects")
    public void beforeSuite(){
        mainPageSteps = new MainPageSteps();
        authorizationPopUpSteps = new AuthorizationPopUpSteps();
    }

    @BeforeTest(description = "Opens browser")
    public void setUp() {
        Configuration.browser = "chrome";
        open("https://psp.ge/");
        getWebDriver().manage().window().maximize();
        Configuration.timeout = 3000;
    }

    @AfterTest(description = "Closes browser")
    public void close() {
        closeWebDriver();
    }
}

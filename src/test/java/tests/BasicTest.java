package tests;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.composite.WebPage;
import entities.Person;
import entities.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;
import pages.mainPage.MainPage;
import pages.loginPage.LoginPage;
import pages.personPage.PersonPage;
import utils.Bot;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;

public class BasicTest implements BeforeAllCallback {
    private static final Bot bot = new Bot();

    private WebDriver driver;
    private static final String MAIN_URL = "https://www.ok.ru/";

    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        driver = WebDriverFactory.getDriver("chrome");
    }

    public MainPage navigateToMainPage() {
        WebPage.openUrl(MAIN_URL);

        return new MainPage();
    }

    public PersonPage navigateToPerson(Person person) {
        WebPage.openUrl(person.url);

        return new PersonPage();
    }

    @BeforeAll
    public static void login() {
        WebPage.openUrl(MAIN_URL);

        User user = new User().set(u -> {
            u.phone = bot.phone;
            u.password = bot.password;
        });

        new LoginPage(user)
                .login();
    }

    @BeforeEach
    public void openMainSite() {
        WebPage.openUrl(MAIN_URL);
    }


    @AfterAll
    public static void closeDriver() {
        killAllSeleniumDrivers();
    }
}

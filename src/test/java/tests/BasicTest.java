package tests;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.composite.WebPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.GeckoDriverService;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;

public class BasicTest implements BeforeAllCallback {

    private static WebDriver DRIVER;
    private static final String MAIN_URL = "https://www.ok.ru/";

    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        DRIVER = WebDriverFactory.getDriver("chrome");
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

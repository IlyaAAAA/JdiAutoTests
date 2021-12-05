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

//    @BeforeAll
//    public static void runChromeDriver() {
//        System.setProperty("webdriver.chrome.driver", "D:\\programming\\java projects\\JDITest\\chromedriver.exe");
//        DRIVER = new ChromeDriver();
//        DRIVER.manage().window().maximize();
//    }

    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        extensionContext.getRoot().getStore(ExtensionContext.Namespace.GLOBAL)
                .getOrComputeIfAbsent(DriverKiller.class);
        DRIVER = WebDriverFactory.getDriver("chrome");
        WebPage.openUrl(MAIN_URL);
//        initSite(SiteJdi.class);
    }

    static class DriverKiller implements ExtensionContext.Store.CloseableResource {
        @Override
        public void close() {
            killAllSeleniumDrivers();
        }
    }

//    @BeforeEach
//    public void setUp() {
//        WebPage.openUrl(MAIN_URL);
//
////        AuthorizePage authorizePage = new AuthorizePage(new Bot());
////        authorizePage.login();
//    }

//    public MainPage openMainPage() {
//        open(MAIN_URL);
//
//        return new MainPage();
//    }

    @AfterEach
    public void close() {
//        WebPage.
//        Selenide.closeWindow();
    }

//    @AfterAll
//    public static void closeDriver() {
//        DRIVER.close();
//    }
}

package tests;

import entities.User;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.loginPage.LoginPage;
import utils.Bot;

class MainPageTest extends BasicTest {
    private final Bot bot = new Bot();

    @Test
    void test() {

        User user = new User().set(u -> {
            u.phone = bot.phone;
            u.password = bot.password;
        });

        LoginPage loginPage = new LoginPage(user);

        MainPage mainPage = loginPage.login();
        mainPage.isOpened();
    }
}

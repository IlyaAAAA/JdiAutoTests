package pages;

import entities.User;
import org.junit.jupiter.api.Test;
import pages.loginPage.LoginPage;
import tests.BasicTest;
import utils.Bot;

public class MainPage extends BasicTest {
    private final Bot bot = new Bot();

    @Test
    void test() {
        User user = new User().set(u -> {
            u.phone = bot.phone;
            u.password = bot.password;
        });

        LoginPage loginPage = new LoginPage(user);

        MainPage mainPage = loginPage.login();
    }
}

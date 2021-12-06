package pages.loginPage;


import com.epam.jdi.light.elements.composite.WebPage;
import entities.User;
import pages.mainPage.MainPage;

public class LoginPage extends WebPage {
    private final LoginForm loginForm = new LoginForm();
    private final User user;

    public LoginPage(User user) {
        this.user = user;
    }

    public MainPage login() {
        loginForm.loginAs(user);

        return new MainPage();
    }
}

package pages;


import utils.Bot;

public class LoginPage {
    private static final String LOGIN_INPUT_LOCATOR = "//*[type='text' and @name='st.email' or @id='field_email']";
    private static final String PASSWORD_INPUT_LOCATOR = "//*[@type='password' and @name='st.password' or @id='field_password']";
    private static final String LOGIN_BUTTON_LOCATOR = "//*[contains(@value, 'Войти') and @type='submit']";

//    private final SelenideElement loginText = $x(LOGIN_INPUT_LOCATOR);
//    private final SelenideElement passwordText = $x(PASSWORD_INPUT_LOCATOR);
//    private final SelenideElement loginButton = $x(LOGIN_BUTTON_LOCATOR);

//    private final Bot bot;

//    public AuthorizePage(Bot bot) {
//        this.bot = bot;
//    }
}

package pages.loginPage;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import entities.User;

class LoginForm extends Form<User> {
    @UI("//*[type='text' and @name='st.email' or @id='field_email']")
    private TextField phone;
    @UI("//*[@type='password' and @name='st.password' or @id='field_password']")
    private TextField password;
    @UI("//*[contains(@value, 'Войти') and @type='submit']")
    private Button loginButton;
}

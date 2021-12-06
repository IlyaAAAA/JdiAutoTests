package pages.personPage;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class PersonPage extends WebPage {


    @UI("//*[contains(@class, 'toggle-dropdown')]")
    private Dropdown dropdown;

    @UI("//*[contains(@class, 'u-menu_li view_lvl1 __hl __hla')]")
    private Button addToFriendsButton;

    public void addPersonToBookmark() {
        dropdown.expand();
    }

    public void addToFriends() {
//        addToFriendsButton.isDisplayed();
        addToFriendsButton.click();
    }
}

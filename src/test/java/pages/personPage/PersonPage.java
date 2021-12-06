package pages.personPage;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class PersonPage extends WebPage {


    @UI("//*[contains(@class, 'toggle-dropdown')]")
    private Button dropdown;

    @UI("//*[contains(@class, 'u-menu_li view_lvl1 __hl __hla')]")
    private Button addToFriendsButton;

    @UI("//*[contains(text(), 'Добавить в закладки')]")
    private Button addToBookmarkButton;

    public void addPersonToBookmark() {
//        dropdown.expand();
        dropdown.click();
        addToBookmarkButton.click();
    }

    public void addToFriends() {
//        addToFriendsButton.isDisplayed();
        addToFriendsButton.click();
    }
}

package pages.personPage;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.Link;

public class PersonPage extends WebPage {

    private static class ReportModalWindow extends Section {
        @UI("//*[contains(@class, 'irc') and @type='checkbox']")
        private Checkbox blackListCheckBox;

        @UI("//*[contains(@class, 'button-pro form-actions_yes')]")
        private Button reportButton;

        @UI("//*[contains(@class, 'button-pro __sec') and @type='submit']")
        private Button closeButton;
    }

    private ReportModalWindow reportModalWindow = new ReportModalWindow();

    @UI("//*[contains(@class, 'toggle-dropdown')]")
    private Button dropdown;

    @UI("//*[contains(@class, 'u-menu_li view_lvl1 __hl __hla')]")
    private Button addToFriendsButton;

    @UI("//*[contains(text(), 'Добавить в закладки')]")
    private Link addToBookmarkLink;

    @UI("//*[contains(text(), 'Пожаловаться')]")
    private Link reportLink;



    public void addPersonToBookmark() {
        dropdown.click();
        addToBookmarkLink.click();
    }

    public void addToFriends() {
        addToFriendsButton.isDisplayed();
        addToFriendsButton.click();
    }

    public void addPersonToBlackList() {
        dropdown.click();
        reportLink.click();

        reportModalWindow.blackListCheckBox.check();
        reportModalWindow.reportButton.click();
        reportModalWindow.closeButton.click();
    }
}

package pages.profilePage;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Link;
import pages.blackListPage.BlackListPage;

public class ProfilePage extends WebPage {

    @UI("//*[contains(@class, 'mctc_navMenuDropdownSecLabelText') and contains(text(), 'Ещё')]")
    private Label label;

    @UI("//*[contains(@class, 'mctc_navMenuDDLIL') and contains(text(), '«Чёрный список»')]")
    private Link blackListLink;

    public BlackListPage openBlackList() {
        label.click();
        blackListLink.click();

        return new BlackListPage();
    }
}

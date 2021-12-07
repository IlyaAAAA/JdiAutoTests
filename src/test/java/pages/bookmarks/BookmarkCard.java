package pages.bookmarks;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class BookmarkCard extends UIElement {
    private static final String DROPDOWN_LOCATOR = ".//*[contains(@class, 'bookmark-shortcut-menu-anchor__icon')]";
    private static final String NAME_LOCATOR = ".//*[contains(@class, 'bookmarks-menu-user-card__title')]";

    @FindBy(xpath = ".//*[contains(@class, 'bookmarks-menu-user-card__title')]")
    public Text nameText;

    @FindBy(xpath = ".//*[contains(@class, 'bookmark-shortcut-menu-anchor__icon')]")
    public Button dropDown;
}

package pages.blackListPage;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class BlackListCard extends UIElement {
    private static final String NAME_LOCATOR = "//*[contains(@class, 'bold n-t')]";
    private static final String DELETE_FROM_BLACKLIST_LOCATOR = ".//*[contains(@class, 'ic_block-off')]";

    @FindBy(xpath = ".//*[contains(@class, 'bold n-t')]")
    public Text nameText;

    @FindBy(xpath = ".//*[contains(@class, 'ic_block-off')]")
    public Button deleteButton;
}

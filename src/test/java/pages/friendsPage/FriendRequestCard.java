package pages.friendsPage;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class FriendRequestCard extends UIElement {
    //    private static final String CANCEL_REQUEST_BUTTON_LOCATOR = ".//*[contains(@class, 'entity-item_status __action')]";
//    private static final String ENTITY_INFO_LOCATOR = ".//*[contains(@data-l, 't,e2') and @class='o']";

    @FindBy(xpath = ".//*[contains(@class, 'entity-item_status __action')]")
    public Button cancelButton;

    @FindBy(xpath = ".//*[contains(@data-l, 't,e2') and @class='o']")
    public Text nameText;
}

package pages.friendsPage;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class FriendRequestCard extends UIElement {
    @FindBy(xpath = ".//*[contains(@class, 'entity-item_status __action')]")
    public Button cancelButton;

    @FindBy(xpath = ".//*[contains(@data-l, 't,e2') and @class='o']")
    public Text nameText;
}

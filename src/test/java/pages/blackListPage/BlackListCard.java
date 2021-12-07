package pages.blackListPage;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class BlackListCard extends UIElement {
    @FindBy(xpath = ".//*[contains(@class, 'bold n-t')]")
    public Text nameText;

    @FindBy(xpath = ".//*[contains(@class, 'ic_block-off')]")
    public Button deleteButton;
}

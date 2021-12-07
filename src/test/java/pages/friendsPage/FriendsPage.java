package pages.friendsPage;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import entities.Person;
import org.hamcrest.Matchers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;

public class FriendsPage extends WebPage {

    private final Logger logger = LoggerFactory.getLogger(FriendsPage.class);

    @UI("//*[contains(text(), 'Исходящие заявки в друзья')]")
    private Button outgoingRequestButton;

    @UI("//*[contains(@class, 'entity-item_info')]")
    private List<FriendRequestCard> requestList;

    public void checkPersonInOutgoingRequests(Person person) {
        outgoingRequestButton.click();

        logger.info("list size: " + requestList.size());

        assertThat(getNameList(), Matchers.hasItem(person.getNameAndSurname()));
    }

    public void cancelRequestForPerson(Person person) {
        logger.info("cancel list size + " + requestList.size());
        for (FriendRequestCard card : requestList) {
            String text = card.nameText.getText();
            logger.info(text);

            if (text.compareTo(person.getNameAndSurname()) == 0) {
                card.cancelButton.click();
//                card.findElement(By.xpath(CANCEL_REQUEST_BUTTON_LOCATOR)).click();
                break;
            }
        }

        reload();

        assertThat(getNameList(), Matchers.not(Matchers.hasItem(person.getNameAndSurname())));
    }

    private List<String> getNameList() {
        return requestList.stream()
                .map(list -> list.nameText.getText())
                .collect(Collectors.toList());
//        return outgoingRequestsList.stream()
//                .map(WebElement::getText)
//                .collect(Collectors.toList());
    }
}

package pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import entities.Person;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;

public class FriendsPage extends WebPage {
    private final String CANCEL_REQUEST_BUTTON_LOCATOR = ".//*[contains(@class, 'entity-item_status __action')]";
    private final String ENTITY_INFO_LOCATOR = ".//*[contains(@data-l, 't,e2') and @class='o']";

    private final Logger logger = LoggerFactory.getLogger(FriendsPage.class);

    @UI("//*[contains(text(), 'Исходящие заявки в друзья')]")
    private Button outgoingRequestButton;

    @UI("//*[contains(@data-l, 't,e2') and @class='o']")
    private List<WebElement> outgoingRequestsList;

    @UI("//*[contains(@class, 'entity-item_info')]")
    private List<WebElement> list;

    public void checkPersonInOutgoingRequests(Person person) {
        outgoingRequestButton.click();

        logger.info("list size: " + outgoingRequestsList.size());

        assertThat(getNameList(), Matchers.hasItem(person.getNameAndSurname()));
    }

    public void cancelRequestForPerson(Person person) {
        logger.info("cancel list size + " + list.size());
        for (WebElement entity : list) {
            WebElement element = entity.findElement(By.xpath(ENTITY_INFO_LOCATOR));
            String text = element.getText();
            logger.info(text);

            if (text.compareTo(person.getNameAndSurname()) == 0) {
                entity.findElement(By.xpath(CANCEL_REQUEST_BUTTON_LOCATOR)).click();
            }
        }

        reload();

        assertThat(getNameList(), Matchers.not(Matchers.hasItem(person.getNameAndSurname())));
    }

    private List<String> getNameList() {
        return outgoingRequestsList.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}

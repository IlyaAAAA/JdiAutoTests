package pages;

import com.epam.jdi.light.elements.composite.Section;
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
    private Logger logger = LoggerFactory.getLogger(FriendsPage.class);

    //    private class LeftSideBar extends Section {
    @UI("//*[contains(text(), 'Исходящие заявки в друзья')]")
    private Button outgoingRequestButton;

//    }

//    private LeftSideBar leftSideBar = new LeftSideBar();

    @UI("//*[contains(@data-l, 't,e2') and @class='o']")
    private List<WebElement> outgoingRequestsList;

    @UI("//*[contains(@class, 'entity-item_status __action')]")
    private Button cancelFriendRequestButton;

    private final String NAME_LOCATOR = "//*[contains(@data-l, 't,e2')]";


    public void checkPersonInOutgoingRequests(Person person) {

        outgoingRequestButton.click();
//        leftSideBar.outgoingRequestButton.isDisplayed();
//        leftSideBar.outgoingRequestButton.click();

        logger.info("list size: " + outgoingRequestsList.size());

//        for (WebElement request : outgoingRequestsList) {
////            WebElement elementWithName = request.findElement(By.xpath(NAME_LOCATOR));
////            String name = elementWithName.getText();
//            String name = request.getText();
//
//            logger.info("Name is : " + name);
//        }

        assertThat(getNameList(), Matchers.hasItem(person.name + " " + person.surname));
    }

    public void cancelRequestForPerson(String string) {

    }

    private List<String> getNameList() {
        return outgoingRequestsList.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
//    ucard-w-list_i


//    Исходящие заявки в друзья
}

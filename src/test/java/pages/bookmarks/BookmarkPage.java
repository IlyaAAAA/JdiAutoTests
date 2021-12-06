package pages.bookmarks;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.WaitAfterAction;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Link;
import entities.Person;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;

public class BookmarkPage extends WebPage {
    private final Logger logger = LoggerFactory.getLogger(BookmarkPage.class);

    //    private static final String BOOKMARK_GROUP_LIST = "//*[contains(@class, 'bookmarks-card-decorator')]";
//    private static final String BOOKMARK_GROUP_TITLE = ".//*[contains(@class, 'bookmarks-menu-group-card__title')]";
//    private static final String BOOKMARKS_LEFT_BAR_LOCATOR = "//*[contains(@class, 'nav-side')]";
//    private static final String BOOKMARKS_LEFT_BAR_GROUP_LOCATOR = ".//*[contains(text(), 'Группы')]";
//    private static final String BOOKMARKS_SPAN_GROUP_LOCATOR = "//span[contains(text(), 'Группы')]";
    //bookmarks-shortcut-menu_with-collections
    @UI("//*[contains(@class, 'nav-side_tx') and contains(text(), 'Люди')]")
    private Button friendsButton;

    @UI("//*[contains(@class, 'bookmarks-menu-user-card__title')]")
    private List<WebElement> personsList;

    @UI("//*[contains(@class, 'bookmark-shortcut-menu-anchor__icon')]")
    private Dropdown dropdownCard;

    private String DROPDOWN_LOCATOR = ".//*[contains(@class, 'bookmark-shortcut-menu-anchor__icon')]";
    private String NAME_LOCATOR = ".//*[contains(@class, 'bookmarks-menu-user-card__title')]";

    @WaitAfterAction(value = 3, method = "click")
    @UI("//*[contains(@data-l, 't,bookmarks_menu_all_remove_link')]")
//    @UI("//*[contains(@class, 'bookmarks-shortcut-menu_with-collections')]")
    private Link removeLink;

    @UI("//*[contains(@class, 'bookmarks-card-decorator__menu-card-anchor-position')]")
    private List<UIElement> cardList;

    public void checkPersonInBookmarks(Person person) {
        choosePersonFromLeftBar();

        List<String> namesList = getNamesList();
        logger.info("nameslist size: " + namesList.size());

        assertThat(namesList, Matchers.hasItem(person.getNameAndSurname()));

        deleteFromBookmark(person);

//        try {
//            wait(6000);
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//            throw new IllegalStateException(e);
//        }

        reload();

        assertThat(getNamesList(), Matchers.not(Matchers.hasItem(person.getNameAndSurname())));
    }

    private void deleteFromBookmark(Person person) {
        for (UIElement card : cardList) {
            WebElement nameElement = card.findElement(By.xpath(NAME_LOCATOR));
            String name = nameElement.getText();

            if (name.compareTo(person.getNameAndSurname()) == 0) {
                card.hover();
                logger.info("HOVERED");

                WebElement dropdownElement = card.findElement(By.xpath(DROPDOWN_LOCATOR));
                dropdownElement.click();

                removeLink.click();
            }
        }
    }

    private void choosePersonFromLeftBar() {
        friendsButton.click();
    }

    private List<String> getNamesList() {
        return personsList.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}

package pages.bookmarks;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.WaitAfterAction;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Link;
import entities.Person;
import org.hamcrest.Matchers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;

public class BookmarkPage extends WebPage {
    private final Logger logger = LoggerFactory.getLogger(BookmarkPage.class);

    @UI("//*[contains(@class, 'nav-side_tx') and contains(text(), 'Люди')]")
    private Button friendsButton;

    @WaitAfterAction(value = 3, method = "click")
    @UI("//*[contains(@data-l, 't,bookmarks_menu_all_remove_link')]")
    private Link removeLink;

    @UI("//*[contains(@class, 'bookmarks-card-decorator__menu-card-anchor-position')]")
    private List<BookmarkCard> cardList;

    public void checkPersonInBookmarks(Person person) {
        List<String> namesList = getNamesList();
        logger.info("nameslist size: " + namesList.size());

        assertThat(namesList, Matchers.hasItem(person.getNameAndSurname()));
    }

    public void deleteFromBookmark(Person person) {
        checkPersonInBookmarks(person);

        boolean inBookmark = false;
        for (BookmarkCard card : cardList) {

            String name = card.nameText.getText();

            if (name.compareTo(person.getNameAndSurname()) == 0) {
                inBookmark = true;

                card.hover();
                logger.info("HOVERED");

                card.dropDown.click();

                removeLink.click();
            }
        }

        if (!inBookmark) {
            throw new IllegalStateException("Must be in bookmark");
        }

        reload();

        assertThat(getNamesList(), Matchers.not(Matchers.hasItem(person.getNameAndSurname())));
    }

    public BookmarkPage choosePersonFromLeftBar() {
        friendsButton.click();

        return this;
    }

    private List<String> getNamesList() {
        return cardList.stream()
                .map(cardList -> cardList.nameText.getText())
                .collect(Collectors.toList());
    }
}

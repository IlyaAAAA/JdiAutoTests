package tests;

import entities.Person;
import org.junit.jupiter.api.Test;
import pages.bookmarks.BookmarkPage;
import pages.mainPage.MainPage;
import utils.PersonUtils;

public class AddPersonToBookmarkTest extends BasicTest {
    private final Person personToAddToBookmarks = PersonUtils.getPerson();

    @Test
    public void test() {
        navigateToPerson(personToAddToBookmarks)
                .addPersonToBookmark();

        BookmarkPage bookmarkPage = navigateToMainPage()
                .getLeftNavigationBar()
                .openBookmarks();

        bookmarkPage
                .checkPersonInBookmarks(personToAddToBookmarks);

        bookmarkPage.deleteFromBookmark(personToAddToBookmarks);
    }

}

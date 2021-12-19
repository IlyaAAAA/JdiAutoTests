package tests;

import entities.Person;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import pages.bookmarks.BookmarkPage;
import utils.PersonUtils;

public class AddPersonToBookmarkTest extends BasicTest {
    private static final Person personToAddToBookmarks = PersonUtils.getPerson();

    @Test
    public void test() {
        navigateToPerson(personToAddToBookmarks)
                .addPersonToBookmark();

        BookmarkPage bookmarkPage = navigateToMainPage()
                .getLeftNavigationBar()
                .openBookmarks();

        bookmarkPage
                .choosePersonFromLeftBar()
                .checkPersonInBookmarks(personToAddToBookmarks);
    }

    @AfterAll
    public static void deleteFromBookmark() {
        navigateToMainPage()
                .getLeftNavigationBar()
                .openBookmarks()
                .choosePersonFromLeftBar()
                .deleteFromBookmark(personToAddToBookmarks);
    }

}

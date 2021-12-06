package tests;

import entities.Person;
import org.junit.jupiter.api.Test;
import utils.PersonUtils;

public class AddPersonToBookmarkTest extends BasicTest {
    private final Person personToAddToBookmarks = PersonUtils.getPerson();

    @Test
    public void test() {
        navigateToPerson(personToAddToBookmarks)
                .addPersonToBookmark();

        navigateToMainPage()
                .getLeftNavigationBar()
                .openBookmarks()
                .checkPersonInBookmarks(personToAddToBookmarks);
    }

}

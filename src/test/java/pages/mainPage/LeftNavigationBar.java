package pages.mainPage;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import pages.FriendsPage;
import pages.bookmarks.BookmarkPage;
//import pages.bookmarks.BookmarkPage;

public class LeftNavigationBar extends Section {
//    private static final String NAME_LOCATOR = "//*[@data-l='t,userPage']";
//    private static final String NOTES_LOCATOR = "//*[contains(text(), 'Заметки')]";
//    private static final String GROUP_LOCATOR = "//*[contains(text(), 'Группы')]";

//    private static final String BOOKMARK_LOCATOR = "//*[contains(text(), 'Закладки')]";
//    private static final String TOGGLER_LOCATOR = "//*[contains(@class, 'nav-side_toggler')]";

    //TODO MB SUDA ETI LOCATORI VSTAVLYAT'

    @UI("//*[contains(@class, 'nav-side_toggler')]")
    private Button dropdown;

    @UI("//*[contains(text(), 'Закладки')]")
    private Button bookmarkButton;

    @UI("//*[contains(text(), 'Друзья')]")
//    @UI("//*[contains(@data-l, 't,userFriend')]")
    private Button friendsButton;

//    public boolean isLoaded() {
//        $x(NAME_LOCATOR).shouldBe(Condition.visible);
//
//        return true;
//    }
//
//    public GroupsPage openGroups() {
//        $x(GROUP_LOCATOR).shouldBe(Condition.visible).click();
//
//        return new GroupsPage();
//    }

    public BookmarkPage openBookmarks() {
//        $x(TOGGLER_LOCATOR).shouldBe(Condition.visible).click();
//        $x(BOOKMARK_LOCATOR).shouldBe(Condition.visible).click();
        dropdown.click();
        bookmarkButton.isDisplayed();
        bookmarkButton.click();

        return new BookmarkPage();
    }

    public FriendsPage openFriends() {
//        friendsButton.isDisplayed();
        friendsButton.click();

        return new FriendsPage();
    }

//    public ProfilePage openProfile() {
//        $x(NAME_LOCATOR).shouldBe(Condition.visible).click();
//
//        return new ProfilePage();
//    }
//
//    public NotesPage openNotes() {
//        $x(NOTES_LOCATOR).shouldBe(Condition.visible).click();
//
//        return new NotesPage();
//    }
}

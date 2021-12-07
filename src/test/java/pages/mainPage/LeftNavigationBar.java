package pages.mainPage;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Link;
import pages.bookmarks.BookmarkPage;
import pages.friendsPage.FriendsPage;
import pages.profilePage.ProfilePage;

public class LeftNavigationBar extends Section {

    @UI("//*[contains(@class, 'nav-side_toggler')]")
    private Button dropdown;

    @UI("//*[contains(@data-l, 't,bookmarks')]")
    private Link bookmarkLink;

    @UI("//*[contains(@data-l, 't,userFriend')]")
    private Link friendsLink;

    @UI("//*[@data-l='t,userPage']")
    private Link profileLink;

    public BookmarkPage openBookmarks() {
        dropdown.click();
        bookmarkLink.isDisplayed();
        bookmarkLink.click();

        return new BookmarkPage();
    }

    public FriendsPage openFriends() {
        friendsLink.click();

        return new FriendsPage();
    }

    public ProfilePage openProfilePage() {
        profileLink.click();

        return new ProfilePage();
    }
}

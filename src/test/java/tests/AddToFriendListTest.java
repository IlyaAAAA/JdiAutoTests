package tests;

import entities.Person;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import pages.friendsPage.FriendsPage;
import utils.PersonUtils;

public class AddToFriendListTest extends BasicTest {
    private static final Person personToAddToFriends = PersonUtils.getPerson();

    @Test
    public void test() {
        navigateToPerson(personToAddToFriends)
                .addToFriends();

        FriendsPage friendsPage = navigateToMainPage()
                .getLeftNavigationBar()
                .openFriends();

        friendsPage
                .chooseOutgoingRequest()
                .checkPersonInOutgoingRequests(personToAddToFriends);
    }

    @AfterAll
    public static void cancelRequest() {
        navigateToMainPage()
                .getLeftNavigationBar()
                .openFriends()
                .chooseOutgoingRequest()
                .cancelRequestForPerson(personToAddToFriends);
    }
}

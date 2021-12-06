package tests;

import entities.Person;
import org.junit.jupiter.api.Test;
import pages.FriendsPage;
import utils.PersonUtils;

public class AddToFriendListTest extends BasicTest {
    private final Person personToAddToFriends = PersonUtils.getPerson();

    @Test
    public void test() {
        navigateToPerson(personToAddToFriends)
                .addToFriends();

        FriendsPage friendsPage = navigateToMainPage()
                .getLeftNavigationBar()
                .openFriends();

        friendsPage
                .checkPersonInOutgoingRequests(personToAddToFriends);

        friendsPage.cancelRequestForPerson(personToAddToFriends);

    }
}

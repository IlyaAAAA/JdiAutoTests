package tests;

import entities.Person;
import org.junit.jupiter.api.Test;
import pages.FriendsPage;

public class AddToFriendListTest extends BasicTest {
    private final Person personToAddToFriends = new Person(
            "Илья",
            "Сачук",
            "Владивосток",
            "https://ok.ru/profile/512582147925"
    );

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

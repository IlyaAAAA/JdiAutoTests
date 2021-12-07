package tests;

import entities.Person;
import org.junit.jupiter.api.Test;
import pages.blackListPage.BlackListPage;
import utils.PersonUtils;

public class AddPersonToBlackList extends BasicTest {
    private final Person personForBlackList = PersonUtils.getPersonForBlackList();

    @Test
    public void test() {
        navigateToPerson(personForBlackList)
                .addPersonToBlackList();

        BlackListPage blackListPage = navigateToMainPage()
                .getLeftNavigationBar()
                .openProfilePage()
                .openBlackList();

        blackListPage.checkPersonInBlackList(personForBlackList);
        blackListPage.removeFromBlackList(personForBlackList);
    }
}

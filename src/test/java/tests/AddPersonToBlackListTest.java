package tests;

import entities.Person;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import pages.blackListPage.BlackListPage;
import utils.PersonUtils;

public class AddPersonToBlackListTest extends BasicTest {
    private static final Person personForBlackList = PersonUtils.getPersonForBlackList();

    @Test
    public void test() {
        navigateToPerson(personForBlackList)
                .addPersonToBlackList();

        BlackListPage blackListPage = navigateToMainPage()
                .getLeftNavigationBar()
                .openProfilePage()
                .openBlackList();

        blackListPage.checkPersonInBlackList(personForBlackList);
    }

    @AfterAll
    public static void deleteFromBlackList() {
        navigateToMainPage()
                .getLeftNavigationBar()
                .openProfilePage()
                .openBlackList()
                .removeFromBlackList(personForBlackList);
    }
}

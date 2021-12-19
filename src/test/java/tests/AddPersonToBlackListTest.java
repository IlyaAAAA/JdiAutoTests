package tests;

import entities.Person;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterAll;
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
    }

    @AfterAll
    public void deleteFromBlackList() {
        navigateToMainPage()
                .getLeftNavigationBar()
                .openProfilePage()
                .openBlackList()
                .removeFromBlackList(personForBlackList);
    }
}

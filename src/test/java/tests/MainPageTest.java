package tests;

import org.junit.jupiter.api.Test;
import pages.mainPage.MainPage;

class MainPageTest extends BasicTest {


    @Test
    void test() {
        MainPage mainPage = navigateToMainPage();
        mainPage.isOpened();
    }
}

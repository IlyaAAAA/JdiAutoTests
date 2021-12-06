package pages.mainPage;

import com.epam.jdi.light.elements.composite.WebPage;

public class MainPage extends WebPage {
    private final LeftNavigationBar leftNavigationBar = new LeftNavigationBar();

    public LeftNavigationBar getLeftNavigationBar() {
        return leftNavigationBar;
    }
}

package pages.mainPage;

import com.epam.jdi.light.elements.composite.WebPage;

public class MainPage extends WebPage {
//    private final LeftNavigationBar leftNavigationBar = new LeftNavigationBar();

    public MainPage() {
//        leftNavigationBar.isLoaded();
    }

    public LeftNavigationBar getLeftNavigationBar() {
//        return leftNavigationBar;
        return new LeftNavigationBar();
    }
}

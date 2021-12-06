//package pages.bookmarks;
//
//import com.codeborne.selenide.Condition;
//import com.codeborne.selenide.ElementsCollection;
//import com.codeborne.selenide.SelenideElement;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import pages.Reloadable;
//import pages.groupsPage.Group;
//
//import static com.codeborne.selenide.Selenide.$$x;
//import static com.codeborne.selenide.Selenide.$x;
//
//public class BookmarkPage {
//    private final Logger logger = LoggerFactory.getLogger(BookmarkPage.class);
//
//    private static final String BOOKMARK_GROUP_LIST = "//*[contains(@class, 'bookmarks-card-decorator')]";
//    private static final String BOOKMARK_GROUP_TITLE = ".//*[contains(@class, 'bookmarks-menu-group-card__title')]";
//    private static final String BOOKMARKS_LEFT_BAR_LOCATOR = "//*[contains(@class, 'nav-side')]";
//    private static final String BOOKMARKS_LEFT_BAR_GROUP_LOCATOR = ".//*[contains(text(), 'Группы')]";
//    private static final String BOOKMARKS_SPAN_GROUP_LOCATOR = "//span[contains(text(), 'Группы')]";
//
//
//    public boolean isGroupInBookmarks(Group group) {
//        chooseGroupFromLeftBar();
//
//        ElementsCollection bookmarks = $$x(BOOKMARK_GROUP_LIST);
//
//        for (SelenideElement bookmark : bookmarks) {
//            String name = bookmark.$x(BOOKMARK_GROUP_TITLE).text();
//            System.out.println(name);
//            logger.info(name);
//            if (name.compareTo(group.name) == 0) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private void chooseGroupFromLeftBar() {
//        SelenideElement leftBar = $x(BOOKMARKS_LEFT_BAR_LOCATOR).shouldBe(Condition.visible);
//
//        SelenideElement leftBarGroup = leftBar.$x(BOOKMARKS_LEFT_BAR_GROUP_LOCATOR).shouldBe(Condition.visible);
//        leftBarGroup.click();
//
//        $x(BOOKMARKS_SPAN_GROUP_LOCATOR).shouldBe(Condition.visible);
//    }
//}

package pages.blackListPage;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Link;
import entities.Person;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;

public class BlackListPage extends WebPage {

    private static class RemoveFromBlackListModalWindow extends Section {
        @UI("//*[contains(@class, 'button-pro form-actions_yes')]")
        private Button deleteButton;
    }

    @UI("//*[contains(@class, 'ugrid_i')]")
    private List<BlackListCard> blackList;

    @UI("//*[contains(@class, 'ic_block-off')]")
    private Link removeFromBlackListLink;

    private RemoveFromBlackListModalWindow removeFromBlackListModalWindow = new RemoveFromBlackListModalWindow();

    public void checkPersonInBlackList(Person person) {
        List<String> blackListNames = getBlackListNames();

        assertThat(blackListNames, Matchers.hasItem(person.getNameAndSurname()));
    }

    public void removeFromBlackList(Person person) {
        for (BlackListCard blackListCard : blackList) {

            String name = blackListCard.nameText.getText();


            if (name.compareTo(person.getNameAndSurname()) == 0) {
                blackListCard.hover();

                removeFromBlackListLink.click();
                removeFromBlackListModalWindow.deleteButton.click();

                break;
            }
        }

        reload();

        assertThat(getBlackListNames(), Matchers.not(Matchers.hasItem(person.getNameAndSurname())));
    }
    
    private List<String> getBlackListNames() {
        return blackList.stream()
                .map(list -> list.nameText.getText())
                .collect(Collectors.toList());
    }
}

package ru.levelup.tatiana.romanova.qa.homework_6;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.levelup.tatiana.romanova.qa.homework_6.test_data.IssuesNames;
import ru.levelup.tatiana.romanova.qa.homework_6.test_data.LeftSideMenuNames;
import ru.levelup.tatiana.romanova.qa.homework_6.test_data.PageTittles;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SetFilterIssue extends MyBaseTest {

    private HomePage homePage;
    private ViewIssuesPage viewIssuesPage;

    @Test
    private void SetFilterIssueTest() {

        homePage = new HomePage(driver);
        viewIssuesPage = new ViewIssuesPage(driver);

        List<String> expectedLeftSideMenu = new ArrayList<>();
        for(LeftSideMenuNames item : LeftSideMenuNames.values())
        {
            expectedLeftSideMenu.add(item.getItemName());
        }

        List<String> actualLeftSideMenu = new ArrayList<>();
        for(WebElement item : homePage.getElementsLeftSideMenu()){
            actualLeftSideMenu.add(item.getText());
        }
        assertThat(actualLeftSideMenu, containsInAnyOrder(expectedLeftSideMenu.toArray(new String[expectedLeftSideMenu.size()])));

        homePage.clickMenuLeftSideMenu(LeftSideMenuNames.VIEW_ISSUES.getItemName());
        assertThat(viewIssuesPage.getPageTittle(), equalTo(PageTittles.VIEW_ISSUES_PAGE.getItemName()));

        viewIssuesPage.clickFilter();
        viewIssuesPage.setFilters("high", "tweak", "assigned", "2019", "April",
                                  "10", "2019", "April", "23");

        viewIssuesPage.clickApplyFilterButton();

        List<String> expectedBugListResult = new ArrayList<>();
        for(IssuesNames item : IssuesNames.values())
        {
            expectedBugListResult.add(item.getItemName());
        }

        List<String> actualBugListResult = new ArrayList<>();
        for(WebElement item : viewIssuesPage.getBugListResult()){
            actualBugListResult.add(item.getText());
        }
        assertThat(expectedBugListResult, hasItems(actualBugListResult.toArray(new String[actualBugListResult.size()])));

        viewIssuesPage.logout();
    }
}

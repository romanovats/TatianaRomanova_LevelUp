package ru.levelup.tatiana.romanova.qa.homework_6;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.levelup.tatiana.romanova.qa.homework_6.test_data.LeftSideMenuNames;
import ru.levelup.tatiana.romanova.qa.homework_6.test_data.PageTittles;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

public class SetFilterIssue extends MyBaseTest {

    private HomePage homePage;
    private ViewIssuesPage viewIssuesPage;

    @Test
    private void AddIssueTest() {

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
                                  "1", "2019", "April", "23");

        viewIssuesPage.clickApplyFilterButton();
        if(viewIssuesPage.getBugListResult().size() > 1){
            System.out.println("Filters setted");
        }
        viewIssuesPage.logout();
    }
}

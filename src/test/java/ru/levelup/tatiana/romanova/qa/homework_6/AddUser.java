package ru.levelup.tatiana.romanova.qa.homework_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.levelup.tatiana.romanova.qa.homework_6.test_data.CreateUserViewNames;
import ru.levelup.tatiana.romanova.qa.homework_6.test_data.LeftSideMenuNames;
import ru.levelup.tatiana.romanova.qa.homework_6.test_data.ManageTabNames;
import ru.levelup.tatiana.romanova.qa.homework_6.test_data.PageTittles;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

public class AddUser extends MyBaseTest {

    private LoginPage loginPage;
    private HomePage homePage;
    private ManagePage managePage;
    private ManageUsersPage manageUsersPage;
    private CreateNewAccountPage createNewAccountPage;

    @Test
    private void AddUserTest(){

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        managePage = new ManagePage(driver);
        manageUsersPage = new ManageUsersPage(driver);
        createNewAccountPage = new CreateNewAccountPage(driver);

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

        homePage.clickMenuLeftSideMenu(LeftSideMenuNames.MANAGE.getItemName());
        assertThat(managePage.getPageTittle(), equalTo(PageTittles.MANAGE_PAGE.getItemName()));

        managePage.clickUsersTab(ManageTabNames.MANAGE_USERS.getItemName());
        assertThat(manageUsersPage.getPageTittle(), equalTo(PageTittles.MANAGE_USERS_PAGE.getItemName()));

        assertThat(manageUsersPage.getCreateNewAccountButtonName(), equalTo(manageUsersPage.CREATE_NEW_ACCOUNT_BUTTON_NAME));
        manageUsersPage.clickCreateNewAccountButton();

        List<String> expectedCreateUserView = new ArrayList<>();
        for(CreateUserViewNames item : CreateUserViewNames.values())
        {
            expectedCreateUserView.add(item.getItemName());
        }

        List<String> actualCreateUserView = new ArrayList<>();
        for(WebElement item :  createNewAccountPage.getElementsCreateUserView()){
            actualCreateUserView.add(item.getText());
        }
        assertThat(actualCreateUserView, containsInAnyOrder(expectedCreateUserView.toArray(new String[expectedCreateUserView.size()])));

        createNewAccountPage.setAccountInfo(properties.getProperty("testUser.username"),
                                            properties.getProperty("testUser.realname"),
                                            properties.getProperty("testUser.email"),
                                            properties.getProperty("testUser.password"),
                                            properties.getProperty("testUser.password"),
                                            properties.getProperty("testUser.access_level"));

        createNewAccountPage.clickCreateUserButton();

        createNewAccountPage.logout();

        loginPage.login(properties.getProperty("testUser.username"), properties.getProperty("testUser.password"));

        assertThat(homePage.getUserInfoLink().getText(), equalTo(properties.getProperty("testUser.username")));

        homePage.logout();
    }
}

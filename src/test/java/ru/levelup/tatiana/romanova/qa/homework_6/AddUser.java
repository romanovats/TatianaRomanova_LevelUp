package ru.levelup.tatiana.romanova.qa.homework_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.levelup.tatiana.romanova.qa.homework_6.test_data.CreateUserViewNames;
import ru.levelup.tatiana.romanova.qa.homework_6.test_data.LeftSideMenuNames;
import ru.levelup.tatiana.romanova.qa.homework_6.test_data.PageTittles;

import java.util.ArrayList;
import java.util.List;

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

        List<String> actualLeftSideMenu = new ArrayList<>();
        for(WebElement item : homePage.getElementsLeftSideMenu()){
            actualLeftSideMenu.add(item.getText());
        }
        assertThat(actualLeftSideMenu, containsInAnyOrder(LeftSideMenuNames.values()));

        homePage.clickMenuLeftSideMenu(LeftSideMenuNames.MANAGE.getItemName());
        assertThat(managePage.getPageTittle(), equalTo(PageTittles.MANAGE_PAGE.getItemName()));

        managePage.clickUsersTab("Manage Users");
        assertThat(manageUsersPage.getPageTittle(), equalTo(PageTittles.MANAGE_PAGE.getItemName()));

        assertThat(manageUsersPage.getCreateNewAccountButtonName(), equalTo("Create New Account"));
        manageUsersPage.clickCreateNewAccountButton();

        List<String> actualCreateUserView = new ArrayList<>();
        for(WebElement item :  createNewAccountPage.getElementsCreateUserView()){
            actualCreateUserView.add(item.getText());
        }
        assertThat(actualCreateUserView, containsInAnyOrder(CreateUserViewNames.values()));

        createNewAccountPage.setUserNameTextField(properties.getProperty("testUser.username"));
        createNewAccountPage.setUserRealNameTextField(properties.getProperty("testUser.realname"));
        createNewAccountPage.setEmailTextField(properties.getProperty("testUser.email"));
        createNewAccountPage.setPasswordTextField(properties.getProperty("testUser.password"));
        createNewAccountPage.setVerifyPasswordTextField(properties.getProperty("testUser.password"));
        createNewAccountPage.setAccessLevelComboBox(properties.getProperty("testUser.access_level"));
        createNewAccountPage.setEnabledCheckBox();
        createNewAccountPage.setProtectedCheckBox();

        createNewAccountPage.clickCreateUserButton();

        createNewAccountPage.logout();

        loginPage.login(properties.getProperty("testUser.username"), properties.getProperty("testUser.password"));

        assertThat(homePage.getUserInfoLink().getText(), equalTo(properties.getProperty("testUser.username")));

        homePage.logout();
    }
}

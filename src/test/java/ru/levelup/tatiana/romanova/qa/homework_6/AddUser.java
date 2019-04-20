package ru.levelup.tatiana.romanova.qa.homework_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.levelup.tatiana.romanova.qa.homework_5.BaseTest;

import java.util.ArrayList;
import java.util.Arrays;
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

        List<String> expectedLeftSideMenu = new ArrayList<String>(Arrays.asList("My View", "View Issues",
                "Report Issue", "Change Log", "Roadmap", "Summary", "Manage"));

        List<WebElement> elementsLeftSideMenu = homePage.getElementsLeftSideMenu();
        List<String> actualLeftSideMenu = new ArrayList<>();
        for(WebElement item : elementsLeftSideMenu){
            actualLeftSideMenu.add(item.getText());
        }
        assertThat(actualLeftSideMenu, containsInAnyOrder(expectedLeftSideMenu.toArray(new String[expectedLeftSideMenu.size()])));

        homePage.clickMenuLeftSideMenu("Manage");
        assertThat(managePage.getPageTittle(), equalTo("Manage - MantisBT"));

        managePage.clickUsersTab("Manage Users");
        assertThat(manageUsersPage.getPageTittle(), equalTo("Manage Users - MantisBT"));

        assertThat(manageUsersPage.getCreateNewAccountButtonName(), equalTo("Create New Account"));
        manageUsersPage.clickCreateNewAccountButton();

        List<String> expectesCreateUserView = new ArrayList<>(Arrays.asList("Username", "Real Name", "E-mail", "Password",
                "Verify Password", "Access Level", "Enabled", "Protected"));
        List<WebElement> elementsCreateUserView = createNewAccountPage.getElementsCreateUserView();
        List<String> actualCreateUserView = new ArrayList<>();
        for(WebElement item : elementsCreateUserView){
            actualCreateUserView.add(item.getText());
        }
        assertThat(actualCreateUserView, containsInAnyOrder(expectesCreateUserView.toArray(new String[expectesCreateUserView.size()])));

        createNewAccountPage.setUserNameTextField("RTS-User11");
        createNewAccountPage.setUserRealNameTextField("RTS-real-name");
        createNewAccountPage.setEmailTextField("email@email.com");
        createNewAccountPage.setPasswordTextField("123");
        createNewAccountPage.setVerifyPasswordTextField("123");
        createNewAccountPage.setAccessLevelComboBox("reporter");
        createNewAccountPage.setEnabledCheckBox();
        createNewAccountPage.setProtectedCheckBox();

        createNewAccountPage.clickCreateUserButton();

        createNewAccountPage.logout();

        loginPage.login("RTS-User11", "123");

        assertThat(driver.findElement(By.className("user-info")).getText(), equalTo("RTS-User11"));

        homePage.logout();
    }
}

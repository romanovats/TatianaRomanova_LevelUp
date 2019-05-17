package ru.levelup.tatiana.romanova.qa.homework_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import ru.levelup.tatiana.romanova.qa.homework_6.test_data.PageTittles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public abstract class MyBaseTest {

    public WebDriver driver;
    public Properties properties;
    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeClass (alwaysRun = true)
    protected void setUpTest() {

        System.setProperty("webdriver.chrome.driver","libs/chromedriver.exe");

        // TODO Драйвер лучше создавать в BeforeMethod || BeforeTest
        // TODO Со страницами лучше поступать так же
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        properties = new Properties();

        try {
            properties.load(new FileInputStream(new File("src/test/resources/homework_6/test.users")));
            properties.load(new FileInputStream(new File("src/test/resources/homework_6/issue.filters")));
        } catch (IOException e){
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(7000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().setScriptTimeout(15000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();

        //1 Open test site by URL
        driver.get("http://khda91.fvds.ru/mantisbt/");
        //2 Assert Browser tittle
        assertThat(loginPage.getPageTittle(), equalTo(PageTittles.LOGIN_PAGE.getItemName()));
        //3 Perform login
        loginPage.login(properties.getProperty("admin.username"), properties.getProperty("admin.password"));
        //4 Assert User name in the right-top side of screen that user is loggined
        assertThat(homePage.getUserInfoLink().getText(), equalTo(properties.getProperty("admin.username")));
    }

    @AfterTest (alwaysRun = true)
    protected void closeBrowser() {
        driver.close();
    }
}

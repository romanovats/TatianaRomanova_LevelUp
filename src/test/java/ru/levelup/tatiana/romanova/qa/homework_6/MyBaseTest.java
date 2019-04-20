package ru.levelup.tatiana.romanova.qa.homework_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import ru.levelup.tatiana.romanova.qa.homework_6.base.BasePage;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public abstract class MyBaseTest {

    public WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass (alwaysRun = true)
    protected void setUpTest() {

        System.setProperty("webdriver.chrome.driver","libs/chromedriver.exe");

        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);

        driver.manage().timeouts().implicitlyWait(7000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().setScriptTimeout(15000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();

        driver.get("http://khda91.fvds.ru/mantisbt/");
        assertThat(loginPage.getPageTittle(), equalTo("MantisBT"));

        loginPage.login("administrator", "root");
        assertThat(driver.findElement(By.className("user-info")).getText(), equalTo("administrator"));
    }

    @AfterTest (alwaysRun = true)
    protected void closeBrowser() {
        driver.close();
    }
}

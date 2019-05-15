package ru.levelup.tatiana.romanova.qa.homework_6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.levelup.tatiana.romanova.qa.homework_6.base.BasePage;

public class LoginPage extends BasePage {
    // TODO Зачем здесь поле driver
    private WebDriver driver;

    @FindBy(id = "username")
    private WebElement usernameTextField;
    @FindBy(id = "password")
    private  WebElement passwordTextField;
    @FindBy(css = ".btn-success")
    private  WebElement loginButton;

    public LoginPage (WebDriver driver) {
        super(driver);
    }

    public void login(final String username, final String password) {
        usernameTextField.sendKeys(username);
        loginButton.click();
        passwordTextField.sendKeys(password);
        loginButton.click();
    }
}

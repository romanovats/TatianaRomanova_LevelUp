package ru.levelup.tatiana.romanova.qa.homework_6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.levelup.tatiana.romanova.qa.homework_6.base.BasePage;

import java.util.List;

public class CreateNewAccountPage extends BasePage {

    private WebDriver driver;

    @FindBy(xpath = "//td[@class='category']")
    private List<WebElement> elementsCreateUserView;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement createUserButton;
    @FindBy(id = "user-username")
    private WebElement userNameTextField;
    @FindBy(id = "user-realname")
    private WebElement userRealNameTextField;
    @FindBy(id = "email-field")
    private WebElement emailTextField;
    @FindBy(id = "user-password")
    private WebElement passwordTextField;
    @FindBy(id = "user-verify-password")
    private WebElement verifyPasswordTextField;
    @FindBy(id = "user-access-level")
    private WebElement accessLevelComboBox;
    @FindBy(xpath = "(//span[@class='lbl'])[1]")
    private WebElement enabledCheckBox;
    @FindBy(xpath = "(//span[@class='lbl'])[2]")
    private WebElement protectedCheckBox;

    public CreateNewAccountPage(WebDriver driver) {

        super(driver);
    }

    public List<WebElement> getElementsCreateUserView() {
        return elementsCreateUserView;
    }

    public void setUserNameTextField(String userNameTextField) {
        this.userNameTextField.sendKeys(userNameTextField);
    }

    public void setUserRealNameTextField(String userRealNameTextField) {
        this.userRealNameTextField.sendKeys(userRealNameTextField);
    }

    public void setEmailTextField(String emailTextField) {
        this.emailTextField.sendKeys(emailTextField);
    }

    public void setPasswordTextField(String passwordTextField) {
        this.passwordTextField.sendKeys(passwordTextField);
    }

    public void setVerifyPasswordTextField(String verifyPasswordTextField) {
        this.verifyPasswordTextField.sendKeys(verifyPasswordTextField);
    }

    public void setAccessLevelComboBox(String accessLevelComboBox) {
        this.accessLevelComboBox.sendKeys(accessLevelComboBox);
    }

    public void setEnabledCheckBox() {
        if (enabledCheckBox.isSelected()) {
            this.enabledCheckBox.click();
        }
    }

    public void setProtectedCheckBox() {
        if (protectedCheckBox.isSelected()) {
            this.protectedCheckBox.click();
        }
    }

    public void clickCreateUserButton() {
        createUserButton.click();
    }
}

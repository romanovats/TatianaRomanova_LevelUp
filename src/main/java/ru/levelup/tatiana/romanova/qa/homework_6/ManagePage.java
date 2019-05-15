package ru.levelup.tatiana.romanova.qa.homework_6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.levelup.tatiana.romanova.qa.homework_6.base.BasePage;

import java.util.List;

public class ManagePage extends BasePage {

    // TODO Зачем здесь поле driver
    private WebDriver driver;

    @FindBy(xpath = "//ul[contains(@class,'nav-tabs')]//a")
    private List<WebElement> elementsManageTabs;

    public ManagePage(WebDriver driver) {
        super(driver);
    }

    public void clickUsersTab(String tabName){
        for(WebElement menuItem : elementsManageTabs){
            if(menuItem.getText().trim().equals(tabName)){
                menuItem.click();
                break;
            }
        }
    }

    public List<WebElement> getElementsManageTabs() {
        return elementsManageTabs;
    }

}

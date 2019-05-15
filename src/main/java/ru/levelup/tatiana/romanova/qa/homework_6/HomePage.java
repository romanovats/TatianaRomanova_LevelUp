package ru.levelup.tatiana.romanova.qa.homework_6;

import org.openqa.selenium.WebDriver;
import ru.levelup.tatiana.romanova.qa.homework_6.base.BasePage;

public class HomePage extends BasePage {

    // TODO Зачем здесь поле driver
    private WebDriver driver;

    public HomePage (WebDriver driver) {
        super(driver);
    }
}

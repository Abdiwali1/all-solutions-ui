package com.brite.pages;

import com.brite.utilities.*;
import org.jsoup.internal.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[normalize-space(text())='Calendar']")
    public WebElement searchBar;

    @FindBy(xpath = "//span[normalize-space(text())='Calendar']")
    public WebElement searchButton;

    @FindBy(xpath = "//span[normalize-space(text())='Calendar']")
    public WebElement profileIcon;


    public void navigateToModule(String module) {

        String moduleLocator = "//span[normalize-space(text())='" + module + "']";

        Driver.getDriver().findElement(By.xpath(moduleLocator)).click();

    }


}

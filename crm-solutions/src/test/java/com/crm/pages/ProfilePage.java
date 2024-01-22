package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProfilePage extends BasePage{

    @FindBy(css = "#profile-menu-filter a")
    public List<WebElement> userProfileOptions;

    @FindBy(xpath = "//td[.='E-Mail:']/..//a")
    public WebElement userEmail;



}

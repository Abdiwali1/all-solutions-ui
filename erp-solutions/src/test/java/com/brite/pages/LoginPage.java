package com.brite.pages;

import com.brite.utilities.*;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;
import java.util.List;

public class LoginPage {

    public LoginPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//p[@class='alert alert-danger']")
    public WebElement errorMessage;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement emailInputBox;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passWordInputBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    public void login(String email, String password) {
        emailInputBox.sendKeys(email);
        passWordInputBox.sendKeys(password);
        loginButton.click();
    }

    public void login(String userType) {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        String username = ConfigurationReader.getProperty(userType + "_username");
        String password = ConfigurationReader.getProperty(userType + "_password");
        emailInputBox.sendKeys(username);
        passWordInputBox.sendKeys(password);
        loginButton.click();
    }
}

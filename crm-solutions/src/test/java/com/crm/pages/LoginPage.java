package com.crm.pages;


import com.crm.utilities.BrowserUtils;
import com.crm.utilities.ConfigurationReader;
import com.crm.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //--LOCATORS--
    @FindBy(xpath = "//label[.='Remember me on this computer']")
    public WebElement label_rememberMe;

    @FindBy(xpath = "//input[@id='USER_REMEMBER']")
    public WebElement checkBox_rememberMe;
    @FindBy(xpath = "//div[@class='errortext']")
    public WebElement errMessage;

    @FindBy(xpath = "//input[@name='USER_LOGIN']")
    public WebElement txtBox_userName;

    @FindBy(xpath = "//input[@name='USER_PASSWORD']")
    public WebElement txtBox_password;

    @FindBy(xpath = "//input[@value='Log In']")
    public WebElement btn_login;


    public void login(String username, String password) {
        txtBox_userName.sendKeys(username);
        txtBox_password.sendKeys(password);
        BrowserUtils.sleep(3);
        btn_login.click();
    }


    public void login(String userType) {

        String username = ConfigurationReader.getProperty(userType + "_username");
        String password = ConfigurationReader.getProperty(userType + "_password");
        txtBox_userName.sendKeys(username);
        txtBox_password.sendKeys(password);
        btn_login.click();

    }

}

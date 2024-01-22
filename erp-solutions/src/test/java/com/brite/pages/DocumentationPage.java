package com.brite.pages;

import com.brite.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public class DocumentationPage {
    public DocumentationPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[@class='oe_topbar_name']")
    public WebElement userIcon;

    @FindBy(xpath = "//a[.='Documentation']")
    public WebElement docLink;

    @FindBy(xpath = "//h1[@class='text-white']")
    public WebElement OdooDocsMessage;

    @FindBy(xpath = "//div[@class='col-lg-6']/h2/a")
    public List<WebElement> documentTopics;
}

package com.brite.pages;

import com.brite.utilities.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class InventoryPage {

    public InventoryPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath ="//span[text()[normalize-space()='Products']]" )
    public WebElement productsLink;

    @FindBy(xpath ="//span[text()[normalize-space()='Inventory']]" )
    public WebElement inventoryLink;

    @FindBy(xpath = "//button[@accessKey='c']")
    public WebElement createButton;


    @FindBy(xpath = "(//input[contains(@id,'o_field_input')])[2]")
    public WebElement nameBar;

    @FindBy(xpath = "//button[text()[normalize-space()='Save']]")
    public WebElement saveButton;

    @FindBy(xpath = "//button[text()[normalize-space()='Edit']]")
    public WebElement editButton;

    @FindBy(xpath = "//span[@name='name']")
    public WebElement productName;

    @FindBy(xpath = "//span[contains(text(),'test')]")
    public WebElement testProduct;


}

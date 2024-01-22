package com.brite.pages;

import com.brite.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public class OrdersPage {
    public OrdersPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//span[text()[normalize-space()='Point of Sale']])[1]")
    public WebElement POSLink;

    @FindBy(xpath = "(//span[text()[normalize-space()='Orders']])[3]")
    public WebElement ordersLinkBtn;

    @FindBy(xpath = "//th[@class='o_list_record_selector']//input")
    public WebElement recordSelectCheckbox;

    @FindBy(xpath = "//div[@class='o_checkbox']")
    public List<WebElement> checkboxes;

    @FindBy(xpath = "//a[@data-section='other']")
    public List<WebElement> actionList;



}
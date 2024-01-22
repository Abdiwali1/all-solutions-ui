package com.brite.pages;

import com.brite.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public class SalesPage {

    public SalesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



    @FindBy(xpath = "//span[text()[normalize-space()='Sales']]")
    public WebElement salesButton;

    @FindBy(xpath = "(//span[text()[normalize-space()='Customers']])[2]")
    public WebElement customerButton;

    @FindBy(xpath = "//button[@accesskey='c']")
    public WebElement createButton;

    @FindBy (xpath = "//input[@placeholder='Name']")
    public WebElement nameInputBox;

    @FindBy(xpath = "//button[@accesskey='s']")
    public WebElement saveButton;

    @FindBy(xpath = "//span[@name='name']")
    public WebElement displayName;

    @FindBy(xpath = "//div[@class='oe_kanban_details']")
    public WebElement customerModule;

    @FindBy(xpath = "//button[@accesskey='a']")
    public WebElement editButton;

    @FindBy(xpath = "//input[@class='o_searchview_input']")
    public WebElement SearchBox;

    @FindBy(xpath = "//th[@class='o_column_sortable']")
    public List<WebElement> QoutesTableColumns;

    @FindBy(xpath = "//div[@class='o_facet_values']")//td[2][1]")
    //"//td[@class='o_data_cell o_readonly_modifier o_required_modifier'][1]")
    public WebElement searchedOrderNumber;

    @FindBy(xpath = "//th[@class='o_list_record_selector']/div/input")
    public WebElement quotationNumberCheckbox;

    @FindBy(xpath = "//div[contains(@class,'oe_kanban_global')]")
    public List<WebElement> customerList;

    @FindBy(xpath = "//input[@type='checkbox']")
    public List<WebElement> quotationNumberCheckBoxes;


}

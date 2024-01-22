package com.brite.pages;

import com.brite.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RepairsPage {

    public RepairsPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[contains(@class, 'name')]")
    public WebElement nameText;

    @FindBy(xpath = "//input[@placeholder='Search...']")
    public WebElement searchBox;

    @FindBy(xpath = "//tr[.//th[@width='1']]")
    public List<WebElement> columns;

    @FindBy(xpath = "//td[.='RMA/00238']")
    public WebElement searchBoxResult;

    @FindBy(xpath = "(//div[@class='o_checkbox']/input)[3]")
    public WebElement checkBox;

    @FindBy(xpath = "//span[text()[normalize-space()='Repairs']]")
    public WebElement repairsLink;

    @FindBy(xpath = "//th[@class='o_list_record_selector']/div/input")
    public WebElement repairReferenceCheckbox;


    @FindBy(xpath = "//input[@type='checkbox']")
    public List<WebElement> checkboxes;







}

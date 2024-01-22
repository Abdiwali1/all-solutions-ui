package com.vytrack.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class VehiclesOdometerPage extends BasePage{

    @FindBy(xpath = "//div[@class='pagination pagination-centered']//ul/li/input")
    public WebElement input_page_number;

    @FindBy(xpath = "//div[@class='pull-right grid-toolbar-tools']//button")
    public WebElement dropdown_view_per_page;

}

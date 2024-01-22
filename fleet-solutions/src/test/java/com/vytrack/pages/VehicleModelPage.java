package com.vytrack.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class VehicleModelPage extends BasePage{

    @FindBy(xpath = "//table/thead/tr/th/a/span[1]")
    public List<WebElement> tableColumnNames;

    @FindBy(xpath = "//div[@id='container']//a[contains(.,'Create Vehicles')]")
    public WebElement btnCreateVehiclesModel;




}

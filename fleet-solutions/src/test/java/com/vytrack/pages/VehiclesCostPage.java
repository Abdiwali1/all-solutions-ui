package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class VehiclesCostPage extends BasePage{

    @FindBy(xpath = "//thead//th//a[@class='grid-header-cell__link']/span[1]")
    public List<WebElement> tableColumnNames;

   }

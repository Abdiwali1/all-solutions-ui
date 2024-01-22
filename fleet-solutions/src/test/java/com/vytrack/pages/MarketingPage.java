package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MarketingPage extends BasePage{



    @FindBy(xpath = "//ul[@class='ui-multiselect-checkboxes ui-helper-reset fixed-li']/li//input")
    public List< WebElement> select_fiter_options;



    @FindBy(xpath = "//button[.='Manage filters']")
    public WebElement button_manage_filters;


    public int getCheckedFilterNumber() {
        int count=0;

        for (WebElement option : select_fiter_options) {
            if (option.isSelected())
                count++;
        }

        return count;

    }
}

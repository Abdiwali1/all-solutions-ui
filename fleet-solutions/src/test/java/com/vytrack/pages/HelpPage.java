package com.vytrack.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HelpPage extends BasePage{


    @FindBy(xpath = "//div[@class=\"container-fluid\"]//h3")
    public WebElement text_How_To_Use_Pinbar;

    @FindBy(xpath = "//div[@class=\"container-fluid\"]//p[1]")
    public WebElement text_Use_pin_icon_on_the_right_top_corner;

    @FindBy(xpath = "//div[@class=\"container-fluid\"]//p[2]/img")
    public WebElement img_How_To_Use_Pinbar;


}
